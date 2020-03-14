package at.ghazarian.design.patterns.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {

    private Set<Observer> observers = new HashSet<>();

    protected void notifyObservers(String input) {
        observers.stream().forEach(o -> o.update(input));
    }

    protected void register(Observer observer) {
        observers.add(observer);
    }

    protected void unregister(Observer observer) {
        observers.remove(observer);
    }

}
