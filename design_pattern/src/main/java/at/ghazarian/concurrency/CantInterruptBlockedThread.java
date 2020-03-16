package at.ghazarian.concurrency;

public class CantInterruptBlockedThread {

    private static final Object importantSingleton = new Object();

    public void doSomethingWithSingleton() {
        synchronized (CantInterruptBlockedThread.class) {
            try {
                // process singleton forever
                while (true)
                    Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " has been interrupted");
            }
        }
    }

    public static void main(String[] args) {
        CantInterruptBlockedThread cantInterruptBlockedThread = new CantInterruptBlockedThread();
        Thread t1 = new Thread(() -> cantInterruptBlockedThread.doSomethingWithSingleton(), "t1");
        Thread t2 = new Thread(() -> cantInterruptBlockedThread.doSomethingWithSingleton(), "t2");

        t1.start();
        shortWait();
        t2.start();

        System.out.println("t1 state: " + t1.getState());
        System.out.println("t2 state: " + t2.getState()); // hopefully blocked.
        t2.interrupt();
        shortWait();
        System.out.println("t2 state: " + t2.getState()); // should still be blocked

    }

    private static void shortWait() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            //
        }
    }

}
