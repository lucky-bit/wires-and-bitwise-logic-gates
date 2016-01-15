package com.exercise.part1.handler;

import com.exercise.part1.data.ParseResult;

/**
 * Created by Denis on 2016-01-15.
 */
public class BitwiseOperationExecutor
{
    public int performRshiftOperation(ParseResult<Integer,Integer,String> rshiftGate)
    {
        return rshiftGate.getLeftOperand() >>> rshiftGate.getRightOperand();
    }

    public int performLshiftOperation(ParseResult<Integer,Integer,String> lshiftGate)
    {
         return lshiftGate.getLeftOperand() << lshiftGate.getRightOperand();
    }

    public int performNotOperation(ParseResult<Integer,Integer,String> notGate)
    {
        return ~ notGate.getRightOperand();
    }

    public int performOrOperation(ParseResult<Integer,Integer,String> orGate)
    {
        return orGate.getLeftOperand() | orGate.getRightOperand();
    }

    public int performAndOperation(ParseResult<Integer,Integer,String> andGate)
    {
        return andGate.getLeftOperand() & andGate.getRightOperand();
    }
}
