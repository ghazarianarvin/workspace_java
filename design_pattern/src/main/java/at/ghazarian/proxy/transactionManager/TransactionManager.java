package at.ghazarian.proxy.transactionManager;

public interface TransactionManager {

    void begin();

    void commit();

    void rollback();
}
