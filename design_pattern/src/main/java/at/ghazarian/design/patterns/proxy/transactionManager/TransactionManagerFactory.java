package at.ghazarian.design.patterns.proxy.transactionManager;

public class TransactionManagerFactory {

    public static TransactionManager newTransactionManager() {
        return new TransactionManagerProxy(new TransactionManagerImpl());
    }
}
