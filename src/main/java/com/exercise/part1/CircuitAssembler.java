package com.exercise.part1;

import com.exercise.part1.handler.InputFileParser;

import java.io.*;

/**
 * Created by Dennis on 2016-01-13.
 */
public class CircuitAssembler
{
    private static final String DEFAULT_INPUT_FILE_NAME = "input.txt";

    public int assemblyCircuit(String inputFilePath) throws IOException
    {
        return parseInputFile(inputFilePath);
    }

    private int parseInputFile(String inputFilePath) throws IOException
    {
        return new InputFileParser().parseInputFile(loadInputFile(inputFilePath));
    }

    private File loadInputFile(String inputFilePath)
    {
        if(inputFilePath != null && inputFilePath.length() > 0)
        {
            return new File(inputFilePath);
        }
        else
        {
            ClassLoader classLoader = getClass().getClassLoader();
            return new File(classLoader.getResource(DEFAULT_INPUT_FILE_NAME).getFile());
        }
    }


}
