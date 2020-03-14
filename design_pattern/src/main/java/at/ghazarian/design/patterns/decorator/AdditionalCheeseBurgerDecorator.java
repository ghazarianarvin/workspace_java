package at.ghazarian.design.patterns.decorator;

public class AdditionalCheeseBurgerDecorator extends BurgerDecorator {

    public AdditionalCheeseBurgerDecorator(Burger delegate) {
        super(delegate);
    }

    @Override
    public double cost() {
        return delegate.cost() + 2;
    }

    @Override
    public double calories() {
        return delegate.calories() + 200;
    }

    @Override
    public String describtion() {
        return delegate.describtion().concat("[Cheese]");
    }
}
