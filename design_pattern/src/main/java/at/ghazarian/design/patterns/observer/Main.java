package at.ghazarian.design.patterns.observer;

public class Main {

    public static void main(String[] args) {
        var consoleInputReader = new ConsoleInputReader();
        (new Thread(consoleInputReader)).start();
        consoleInputReader.register(new DbObserver());
        consoleInputReader.register(new LogObserver());
        System.out.println("End the thread by typing the word 'END'");
    }
}
