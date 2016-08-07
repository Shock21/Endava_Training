package com.endava.patterns.factory;

/**
 * Created by tvasile on 7/22/2016.
 */
public class HamAnMushroomPizza extends Pizza {

    public HamAnMushroomPizza() {
        super(PizzaTypes.HamAndMushroom, 6);
        make();
    }

    @Override
    public void make() {
        System.out.println("Making a ham and mushroom pizza!");
    }
}
