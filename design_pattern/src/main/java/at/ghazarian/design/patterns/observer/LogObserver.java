package at.ghazarian.design.patterns.observer;

public class LogObserver implements Observer {
    @Override
    public void update(String input) {
        System.out.println("writing " + input + " into some file");
    }
}
