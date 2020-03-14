package at.ghazarian.design.patterns.strategy.policy;

public class RetryNTimes implements RetryPolicy {

    private int n;

    private RetryNTimes() {}

    public RetryNTimes(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater 1");
        }
        this.n = n;
    }

    @Override
    public boolean retry() {
        if (n == 0)
            return false;
        this.n --;
        return true;
    }
}
