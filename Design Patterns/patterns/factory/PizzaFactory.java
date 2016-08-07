package com.endava.patterns.factory;

/**
 * Created by tvasile on 7/22/2016.
 */
public class PizzaFactory {

    public static Pizza makePizza(PizzaTypes pizzaType)
    {
        Pizza pizza = null;

        switch (pizzaType) {
            case Deluxe:
                pizza = new DeluxePizza();
                break;

            case HamAndMushroom:
                pizza = new HamAnMushroomPizza();
                break;

            case Prosciuto:
                pizza = new ProsciutoPizza();
                break;

            default:
                break;
        }

        return pizza;
    }

    public static void main(String[] args) {
        Pizza deluxePizza = new PizzaFactory().makePizza(PizzaTypes.Deluxe);
    }

}
