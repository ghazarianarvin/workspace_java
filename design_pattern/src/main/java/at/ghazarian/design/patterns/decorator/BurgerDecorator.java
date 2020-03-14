package at.ghazarian.design.patterns.decorator;

public abstract class BurgerDecorator implements Burger {

    protected Burger delegate;

    public BurgerDecorator(Burger delegate) {
        this.delegate = delegate;
    }
}
