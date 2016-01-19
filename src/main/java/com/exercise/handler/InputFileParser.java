package com.exercise.handler;

import com.exercise.observation.impl.WireSignalSubject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;

/**
 * Created by Dennis on 2016-01-13.
 */
public class InputFileParser
{

    public Hashtable<String,Integer> parseInputFileAndPerformOperation(File inputFile) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        Hashtable<String,Integer> wiresSignals = new Hashtable<String,Integer>();
        WireSignalSubject wireSignalSubject = new WireSignalSubject();
        InputLineParser inputLineParser = new InputLineParser(wiresSignals, wireSignalSubject);
        String line;
        while ((line = br.readLine()) != null)
        {
            inputLineParser.parseInputLine(line);
        }
        return wiresSignals;
    }








}
