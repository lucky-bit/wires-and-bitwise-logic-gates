package com.exercise.part1.handler;

import com.exercise.part1.data.ParseResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.regex.Pattern;

/**
 * Created by Dennis on 2016-01-13.
 */
public class InputFileParser
{
    private Hashtable<String,Integer> wiresSignal;

    public static final String ASSIGNMENT_INPUT_PATTERN = "[a-z0-9]+ -> [a-z]+";
    public static final String NOT_INPUT_PATTERN = "NOT [a-z0-9]+ -> [a-z]+";
    public static final String AND_INPUT_PATTERN = "[a-z0-9]+ AND [a-z0-9]+ -> [a-z]+";
    public static final String OR_INPUT_PATTERN = "[a-z0-9]+ OR [a-z0-9]+ -> [a-z]+";
    public static final String LSHIFT_INPUT_PATTERN = "[a-z0-9]+ LSHIFT [a-z0-9]+ -> [a-z]+";
    public static final String RSHIFT_INPUT_PATTERN = "[a-z0-9]+ RSHIFT [a-z0-9]+ -> [a-z]+";
    public static final String NUMERIC_PATTERN = "[0-9]+";
    public static final String ALPHA_PATTERN = "[a-z]+";

    private Pattern assignmentPattern = Pattern.compile(ASSIGNMENT_INPUT_PATTERN);
    private Pattern notPattern = Pattern.compile(NOT_INPUT_PATTERN);
    private Pattern andPattern = Pattern.compile(AND_INPUT_PATTERN);
    private Pattern orPattern = Pattern.compile(OR_INPUT_PATTERN);
    private Pattern lshiftPattern = Pattern.compile(LSHIFT_INPUT_PATTERN);
    private Pattern rshiftPattern = Pattern.compile(RSHIFT_INPUT_PATTERN);
    private Pattern numericPattern = Pattern.compile(NUMERIC_PATTERN);

    public Hashtable<String,Integer> parseInputFileAndExecuteOperation(File inputFile) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BitwiseOperationExecutor bitwiseOperationExecutor = new BitwiseOperationExecutor();
        String line;
        wiresSignal = new Hashtable<String,Integer>();
        while ((line = br.readLine()) != null)
        {
            if(andPattern.matcher(line).matches())
            {
                ParseResult<Integer,Integer,String> andGate = parseAndStatement(line);
                wiresSignal.put(andGate.getWireId(), bitwiseOperationExecutor.performAndOperation(andGate));
            }
            else if(orPattern.matcher(line).matches())
            {
                ParseResult<Integer,Integer,String> orGate = parseOrStatement(line);
                wiresSignal.put(orGate.getWireId(), bitwiseOperationExecutor.performOrOperation(orGate));
            }
            else if(notPattern.matcher(line).matches())
            {
                ParseResult<Integer,Integer,String> notGate = parseNotStatement(line);
                int result = bitwiseOperationExecutor.performNotOperation(notGate);
                if(result <=0)
                    result += 65536;
                wiresSignal.put(notGate.getWireId(), result);
            }
            else if(lshiftPattern.matcher(line).matches())
            {
                ParseResult<Integer,Integer,String> lshiftGate = parseLshiftStatement(line);
                wiresSignal.put(lshiftGate.getWireId(), bitwiseOperationExecutor.performLshiftOperation(lshiftGate));
            }
            else if(rshiftPattern.matcher(line).matches())
            {
                ParseResult<Integer,Integer,String> rshiftGate = parseRshiftStatement(line);
                wiresSignal.put(rshiftGate.getWireId(), bitwiseOperationExecutor.performRshiftOperation(rshiftGate));
            }
            else if(assignmentPattern.matcher(line).matches())
            {
                ParseResult<Integer,Integer,String> assignment = parseAssignmentStatement(line);
                wiresSignal.put(assignment.getWireId(), assignment.getLeftOperand());
            }
        }
        return wiresSignal;
    }

    private ParseResult<Integer,Integer,String> parseAssignmentStatement(String line)
    {
        return parse(line, line);
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

    private ParseResult<Integer,Integer,String> parse(String line, String splitter)
    {
        String gate = line.split(" -> ")[0];
        String wireId = line.split(" -> ")[1];
        String leftOperand = null;
        if(gate.split(splitter).length > 0)
            leftOperand = gate.split(splitter)[0];
        String rightOperand = null;
        if(gate.split(splitter).length > 1)
            rightOperand = gate.split(splitter)[1];
        int leftOperandIntValue = 0;
        int rightOperandIntValue = 0;
        if(leftOperand != null && leftOperand.length() > 0)
            leftOperandIntValue= numericPattern.matcher(leftOperand).matches() ? Integer.parseInt(leftOperand) : wiresSignal.get(leftOperand);
        if(rightOperand != null && rightOperand.length() > 0)
            rightOperandIntValue = numericPattern.matcher(rightOperand).matches() ? Integer.parseInt(rightOperand) : wiresSignal.get(rightOperand);
        return new ParseResult<Integer,Integer,String>(leftOperandIntValue, rightOperandIntValue, wireId);
    }
}
