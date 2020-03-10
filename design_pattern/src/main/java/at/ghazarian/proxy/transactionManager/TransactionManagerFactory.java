package at.ghazarian.proxy.transactionManager;

public class TransactionManagerFactory {

    public static TransactionManager newTransactionManager() {
        return new TransactionManagerProxy(new TransactionManagerImpl());
    }
}
