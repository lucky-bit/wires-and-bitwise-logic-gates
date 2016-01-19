package com.exercise.observation;

/**
 * Created by Denis on 2016-01-16.
 */
public interface Observer
{
    public void reprocessLine(Subject subject) throws Exception;
    public String getWireIdToObserve();
}
