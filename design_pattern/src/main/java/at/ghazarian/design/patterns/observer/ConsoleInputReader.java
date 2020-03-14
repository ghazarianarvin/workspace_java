package at.ghazarian.design.patterns.observer;

import java.util.Scanner;

public class ConsoleInputReader extends Subject implements Runnable {

    private Scanner scanner;

    public ConsoleInputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String input;
        while (true) {
            input = scanner.next();
            if ("END".equals(input)) {
                break;
            } else {
                notifyObservers(input);
            }
        }
    }
}
