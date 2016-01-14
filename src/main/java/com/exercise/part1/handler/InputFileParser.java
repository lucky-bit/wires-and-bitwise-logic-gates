package com.exercise.part1.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dennis on 2016-01-13.
 */
public class InputFileParser
{

    public int parseInputFile(File inputFile) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        int numberOfLines = 0;
        while ((line = br.readLine()) != null)
        {
            numberOfLines++;
            System.out.println(line);
        }

        return numberOfLines;
    }
}
