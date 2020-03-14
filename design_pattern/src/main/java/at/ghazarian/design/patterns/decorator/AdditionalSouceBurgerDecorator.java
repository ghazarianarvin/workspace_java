package at.ghazarian.design.patterns.decorator;

public class AdditionalSouceBurgerDecorator extends BurgerDecorator {

    public AdditionalSouceBurgerDecorator(Burger delegate) {
        super(delegate);
    }

    @Override
    public double cost() {
        return delegate.cost() + 1;
    }

    @Override
    public double calories() {
        return delegate.calories() + 100;
    }

    @Override
    public String describtion() {
        return delegate.describtion().concat("[Sauce]");
    }
}
