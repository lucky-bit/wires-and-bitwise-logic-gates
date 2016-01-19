package com.exercise.observation.impl;

import com.exercise.observation.Observer;
import com.exercise.observation.Subject;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Denis on 2016-01-16.
 */
public class WireSignalSubject implements Subject
{
    private List<Observer> observers = new CopyOnWriteArrayList<Observer>();

    @Override
    public void addSubject(String wireId) throws Exception
    {
        notifyObservers(wireId);
    }

    @Override
    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    private void notifyObservers(String wireId) throws Exception
    {
        for(Observer o : observers)
        {
            if(o.getWireIdToObserve().equals(wireId))
            {
                o.reprocessLine(this);
                observers.remove(o);
            }
        }
    }
}