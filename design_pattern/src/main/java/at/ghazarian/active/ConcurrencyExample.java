package at.ghazarian.active;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyExample {


    // solution one:
    private static final List<String> BAD_LIST = new ArrayList();

    public static synchronized void onlyMethodAccessing_BAD_LIST() {
        // if it is guaranteed that this static synchronized method is the only methods accessing
        // BAD_LIST then this solution is thread-safe.
    }

    // -----------------------------------------------------------------------------------------------------------------
    // solution tow:
    private static final List<String> GOOD_LIST = Collections.synchronizedList(new ArrayList());

    public void doSomethingWithList() {
        // synchronized at the point is pretty much unnecessary, because multiple objects of this class can exist
        // and every single object has it's own synchronized method (aka lock)
        // It's not guaranteed that only one object of this class will exist.
    }

    // -----------------------------------------------------------------------------------------------------------------
    // solution three:

    private static final ReentrantLock reentrantLock = new ReentrantLock();


    public void onlyMethodAccessing_BAD_LIST_REENTRANTLOCK() {
        reentrantLock.lock();
        try {
           // do something list
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }

}