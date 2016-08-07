package com.endava.patterns.observer;

import java.util.Observable;

/**
 * Created by tvasile on 7/31/2016.
 */
public class Calculator  extends Observable{

    private int result;

    void addNumber(int number) {
        if( result != result + number) {
            result += number;
            setChanged();
            notifyObservers(result);
        }
    }
}
