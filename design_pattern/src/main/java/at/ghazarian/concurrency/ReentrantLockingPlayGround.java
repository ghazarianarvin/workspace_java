package at.ghazarian.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockingPlayGround {

    private static final Object importantSingleton = new Object();
    private static final ReentrantLock lock = new ReentrantLock();

    public void doSomethingWithSingleton() {
        boolean lockedByCurrentThread = false;
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                lockedByCurrentThread = true;
                // process singleton forever
                while (true)
                    Thread.sleep(1000);
            } else {
                System.err.println(Thread.currentThread().getName() + ": Could get access after three seconds.");
            }
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + ": has been interrupted");
        } finally {
            if (lockedByCurrentThread)
                lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantLockingPlayGround playGround = new ReentrantLockingPlayGround();
        Thread t1 = new Thread(() -> playGround.doSomethingWithSingleton(), "t1");
        Thread t2 = new Thread(() -> playGround.doSomethingWithSingleton(), "t2");

        t1.start();
        shortWait(200);
        t2.start();

        while (true) {
            System.out.println("t1 state: " + t1.getState());
            System.out.println("t2 state: " + t2.getState()); // hopefully blocked.
            shortWait(1000);
        }

    }

    private static void shortWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            //
        }
    }

}
