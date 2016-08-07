package com.endava.patterns.factory;

/**
 * Created by tvasile on 7/22/2016.
 */
public class DeluxePizza extends Pizza {

    public DeluxePizza() {
        super(PizzaTypes.Deluxe, 12);
        make();
    }

    @Override
    public void make() {
        System.out.println("Making a deluxe pizza!");
    }
}
