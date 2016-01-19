package com.exercise;

import com.exercise.handler.InputFileParser;
import java.io.*;
import java.util.Hashtable;

/**
 * Created by Dennis on 2016-01-13.
 */
public class CircuitAssembler
{
    private static final String DEFAULT_INPUT_FILE_NAME = "com/exercise/input.txt";

    public Hashtable<String,Integer> assemblyCircuit(String inputFilePath) throws Exception
    {
        return parseInputFile(inputFilePath);
    }

    private Hashtable<String,Integer> parseInputFile(String inputFilePath) throws Exception
    {
        return new InputFileParser().parseInputFileAndPerformOperation(loadInputFile(inputFilePath));
    }

    private File loadInputFile(String inputFilePath) throws NullPointerException
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
