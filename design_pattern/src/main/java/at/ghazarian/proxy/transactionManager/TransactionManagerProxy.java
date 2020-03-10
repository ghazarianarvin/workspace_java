package at.ghazarian.proxy.transactionManager;

class TransactionManagerProxy implements TransactionManager {

    private TransactionManager realTransactionManager;

    public TransactionManagerProxy(TransactionManager realTransactionManager) {
        this.realTransactionManager = realTransactionManager;
    }

    @Override
    public void begin() {
        System.out.println("starting transaction");
        this.realTransactionManager.begin();
    }

    @Override
    public void commit() {
        System.out.println("committing transaction");
        this.realTransactionManager.commit();

    }

    @Override
    public void rollback() {
        System.out.println("something went wrong");
        this.realTransactionManager.rollback();

    }
}
