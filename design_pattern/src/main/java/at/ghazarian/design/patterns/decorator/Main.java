package at.ghazarian.design.patterns.decorator;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("One Big Mac please..");
        Burger burger = new BigMacBurger();
        printBurgerProperties(burger);
        System.out.println("more cheese please...");
        burger = new AdditionalCheeseBurgerDecorator(burger);
        printBurgerProperties(burger);
        System.out.println("another slice of cheese please...");
        burger = new AdditionalCheeseBurgerDecorator(burger);
        printBurgerProperties(burger);
        System.out.println("and 3 x sauces...");
        for (int i = 0; i < 3; i++) {
            burger = new AdditionalSouceBurgerDecorator(burger);
        }
        printBurgerProperties(burger);
        System.out.println("Total cost: " + burger.cost());
    }

    public static void printBurgerProperties(Burger burger) {
        System.out.println(burger.describtion() + " with " + burger.calories() + " calories");
    }
}
