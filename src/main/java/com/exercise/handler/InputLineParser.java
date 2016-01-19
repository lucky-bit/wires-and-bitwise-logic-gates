package com.exercise.handler;

import com.exercise.data.ParseResult;
import com.exercise.observation.Subject;
import com.exercise.observation.impl.WireSignalObserver;
import java.util.Hashtable;
import java.util.regex.Pattern;

/**
 * Created by Dennis on 2016-01-16.
 */
public class InputLineParser
{
    private static final String ASSIGNMENT_INPUT_PATTERN = "[a-z0-9]+ -> [a-z]+";
    private static final String NOT_INPUT_PATTERN = "NOT [a-z0-9]+ -> [a-z]+";
    private static final String AND_INPUT_PATTERN = "[a-z0-9]+ AND [a-z0-9]+ -> [a-z]+";
    private static final String OR_INPUT_PATTERN = "[a-z0-9]+ OR [a-z0-9]+ -> [a-z]+";
    private static final String LSHIFT_INPUT_PATTERN = "[a-z0-9]+ LSHIFT [a-z0-9]+ -> [a-z]+";
    private static final String RSHIFT_INPUT_PATTERN = "[a-z0-9]+ RSHIFT [a-z0-9]+ -> [a-z]+";
    private static final String NUMERIC_PATTERN = "[0-9]+";

    private static Pattern assignmentPattern = Pattern.compile(ASSIGNMENT_INPUT_PATTERN);
    private static Pattern notPattern = Pattern.compile(NOT_INPUT_PATTERN);
    private static Pattern andPattern = Pattern.compile(AND_INPUT_PATTERN);
    private static Pattern orPattern = Pattern.compile(OR_INPUT_PATTERN);
    private static Pattern lshiftPattern = Pattern.compile(LSHIFT_INPUT_PATTERN);
    private static Pattern rshiftPattern = Pattern.compile(RSHIFT_INPUT_PATTERN);
    private static Pattern numericPattern = Pattern.compile(NUMERIC_PATTERN);

    BitwiseOperationExecutor bitwiseOperationExecutor = new BitwiseOperationExecutor();
    Subject wireSignalSubject;
    Hashtable<String,Integer> wiresSignals;

    public InputLineParser(Hashtable<String,Integer> wiresSignals, Subject wireSignalSubject)
    {
        this.wiresSignals = wiresSignals;
        this.wireSignalSubject = wireSignalSubject;
    }

    public void parseInputLine(String line) throws Exception {
        ParseResult<Integer, Integer, String> gate;
        if (andPattern.matcher(line).matches()) {
            gate = parseAndStatement(line);
            if (gate != null) {
                wiresSignals.put(gate.getWireId(), bitwiseOperationExecutor.performAndOperation(gate));
                wireSignalSubject.addSubject(gate.getWireId());
            }
        } else if (orPattern.matcher(line).matches()) {
            gate = parseOrStatement(line);
            if (gate != null) {
                wiresSignals.put(gate.getWireId(), bitwiseOperationExecutor.performOrOperation(gate));
                wireSignalSubject.addSubject(gate.getWireId());
            }
        } else if (notPattern.matcher(line).matches()) {
            gate = parseNotStatement(line);
            if (gate != null) {
                int result = bitwiseOperationExecutor.performNotOperation(gate);
                if (result <= 0)
                    result += 65536;
                wiresSignals.put(gate.getWireId(), result);
                wireSignalSubject.addSubject(gate.getWireId());
            }
        } else if (lshiftPattern.matcher(line).matches()) {
            gate = parseLshiftStatement(line);
            if (gate != null) {
                wiresSignals.put(gate.getWireId(), bitwiseOperationExecutor.performLshiftOperation(gate));
                wireSignalSubject.addSubject(gate.getWireId());
            }
        } else if (rshiftPattern.matcher(line).matches()) {
            gate = parseRshiftStatement(line);
            if (gate != null) {
                wiresSignals.put(gate.getWireId(), bitwiseOperationExecutor.performRshiftOperation(gate));
                wireSignalSubject.addSubject(gate.getWireId());
            }
        } else if (assignmentPattern.matcher(line).matches()) {
            gate = parseAssignmentStatement(line);
            if (gate != null) {
                wiresSignals.put(gate.getWireId(), gate.getLeftOperand());
                wireSignalSubject.addSubject(gate.getWireId());
            }
        }
        else
        {
            throw new Exception(line + " is not a valid input");
        }
    }

    private ParseResult<Integer,Integer,String> parseRshiftStatement(String line)
    {
        return parse(line, " RSHIFT ");
    }

    private ParseResult<Integer,Integer,String> parseLshiftStatement(String line)
    {
        return parse(line, " LSHIFT ");
    }

    private ParseResult<Integer,Integer,String> parseNotStatement(String line)
    {
        return parse(line, "NOT ");
    }

    private ParseResult<Integer,Integer,String> parseOrStatement(String line)
    {
        return parse(line, " OR ");
    }

    private ParseResult<Integer,Integer,String> parseAndStatement(String line)
    {
        return parse(line, " AND ");
    }

    private ParseResult<Integer,Integer,String> parseAssignmentStatement(String line)
    {
        return parse(line, line);
    }

    private ParseResult<Integer,Integer,String> parse(String line, String splitter)
    {
        String gate = line.split(" -> ")[0];
        String wireId = line.split(" -> ")[1];
        String leftOperand = getLeftOperand(splitter, gate);
        String rightOperand = getRightOperand(splitter, gate);
        return buildResult(wireId, leftOperand, rightOperand, line);
    }


    private ParseResult<Integer, Integer, String> buildResult(String wireId, String leftOperand, String rightOperand, String line)
    {
        Integer leftOperandIntValue = null;
        Integer rightOperandIntValue = null;
        if(leftOperand != null && leftOperand.length() > 0)
        {
            if((leftOperandIntValue = parseOperand(leftOperand, line)) == null)
            {
                return null;
            }
        }
        if(rightOperand != null && rightOperand.length() > 0)
        {
            if((rightOperandIntValue = parseOperand(rightOperand,  line)) == null)
            {
                return null;
            }
        }
        return new ParseResult<Integer,Integer,String>(leftOperandIntValue, rightOperandIntValue, wireId);
    }

    private Integer parseOperand(String operand, String line)
    {
        Integer operandIntValue;
        if(numericPattern.matcher(operand).matches())
        {
            operandIntValue = Integer.parseInt(operand);
        }
        else
        {
            operandIntValue = wiresSignals.get(operand);
            if(operandIntValue == null)
            {
                wireSignalSubject.addObserver(new WireSignalObserver(operand, line, this));
                return null;
            }
        }
        return operandIntValue;
    }

    private String getRightOperand(String splitter, String gate) {
        String rightOperand = null;
        if(gate.split(splitter).length > 1)
            rightOperand = gate.split(splitter)[1];
        return rightOperand;
    }

    private String getLeftOperand(String splitter, String gate) {
        String leftOperand = null;
        if(gate.split(splitter).length > 0)
            leftOperand = gate.split(splitter)[0];
        return leftOperand;
    }

}
