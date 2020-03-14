package at.ghazarian.design.patterns.strategy.policy;

public class DontRetry implements RetryPolicy {
    @Override
    public boolean retry() {
        return false;
    }
}
