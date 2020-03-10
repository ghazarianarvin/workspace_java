package at.ghazarian.proxy;

import at.ghazarian.proxy.transactionManager.TransactionManager;
import at.ghazarian.proxy.transactionManager.TransactionManagerFactory;

public class Main {

    public static void main(String[] args) {
        TransactionManager transactionManager = TransactionManagerFactory.newTransactionManager();
        transactionManager.begin();
        // do database stuff here.
        transactionManager.commit();

        System.out.println(transactionManager.getClass());
    }
}
