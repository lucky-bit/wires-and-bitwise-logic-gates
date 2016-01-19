package com.exercise.observation;

/**
 * Created by Denis on 2016-01-16.
 */
public interface Subject
{
    public void addObserver(Observer observer);
    public void addSubject(String wireId) throws Exception;
}
