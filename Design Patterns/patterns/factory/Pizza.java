package com.endava.patterns.factory;

/**
 * Created by tvasile on 7/22/2016.
 */
public abstract class Pizza {

    private PizzaTypes pizzaType;
    private final Integer price;

    public Pizza(PizzaTypes pizzaType, Integer price) {
        this.pizzaType = pizzaType;
        this.price = price;
    }

    public PizzaTypes getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaTypes pizzaType) {
        this.pizzaType = pizzaType;
    }

    public Integer getPrice() {
        return price;
    }

    public abstract void make();
}
