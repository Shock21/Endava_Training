package com.endava.patterns.observer;

/**
 * Created by tvasile on 7/31/2016.
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Client client1 = new Client();
        Client client2 = new Client();

        calculator.addObserver(client1);
        calculator.addObserver(client2);

        calculator.addNumber(5);

        calculator.addNumber(12);
    }


}
