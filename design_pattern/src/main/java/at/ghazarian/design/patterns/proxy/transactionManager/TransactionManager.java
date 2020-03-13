package at.ghazarian.design.patterns.proxy.transactionManager;

public interface TransactionManager {

    void begin();

    void commit();

    void rollback();
}
