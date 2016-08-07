package com.endava.patterns.factory;

/**
 * Created by tvasile on 7/22/2016.
 */
public class ProsciutoPizza extends Pizza {

    public ProsciutoPizza() {
        super(PizzaTypes.Prosciuto, 8);
        make();
    }

    @Override
    public void make() {
        System.out.println("Making a prosciutto pizza!");
    }
}
