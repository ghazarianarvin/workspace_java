package at.ghazarian.design.patterns.observer;

public class DbObserver implements Observer {
    @Override
    public void update(String input) {
        System.out.println("writing " + input + " into some db table");
    }
}
