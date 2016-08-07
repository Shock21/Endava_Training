package com.endava.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by tvasile on 7/31/2016.
 */
public class Client implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("This is the new result: " + arg);
    }
}
