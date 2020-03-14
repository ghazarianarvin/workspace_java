package at.ghazarian.design.patterns.decorator;

public class BigMacBurger implements Burger {
    @Override
    public double cost() {
        return 5;
    }

    @Override
    public double calories() {
        return 500;
    }

    @Override
    public String describtion() {
        return "this is a big mac";
    }
}
