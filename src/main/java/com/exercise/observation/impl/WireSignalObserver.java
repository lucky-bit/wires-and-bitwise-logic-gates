package com.exercise.observation.impl;

import com.exercise.handler.InputLineParser;
import com.exercise.observation.Observer;
import com.exercise.observation.Subject;

/**
 * Created by Dennis on 2016-01-16.
 */
public class WireSignalObserver implements Observer
{
    String wireIdToObserve;
    String inputLineToParse;
    InputLineParser inputLineParser;

    public WireSignalObserver(String wireIdToObserve, String inputLineToParse, InputLineParser inputLineParser)
    {
        this.wireIdToObserve  = wireIdToObserve;
        this.inputLineToParse = inputLineToParse;
        this.inputLineParser  = inputLineParser;
    }

    @Override
    public void reprocessLine(Subject subject) throws Exception
    {
        inputLineParser.parseInputLine(inputLineToParse);
    }

    public String getWireIdToObserve()
    {
        return wireIdToObserve;
    }

}
