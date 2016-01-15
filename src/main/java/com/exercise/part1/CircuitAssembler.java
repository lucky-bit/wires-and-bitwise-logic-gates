package com.exercise.part1;

import com.exercise.part1.handler.InputFileParser;

import java.io.*;
import java.util.Hashtable;

/**
 * Created by Dennis on 2016-01-13.
 */
public class CircuitAssembler
{
    private static final String DEFAULT_INPUT_FILE_NAME = "input.txt";

    public Hashtable<String,Integer> assemblyCircuit(String inputFilePath) throws IOException
    {
        return parseInputFile(inputFilePath);
    }

    private Hashtable<String,Integer> parseInputFile(String inputFilePath) throws IOException
    {
        return new InputFileParser().parseInputFileAndExecuteOperation(loadInputFile(inputFilePath));
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
