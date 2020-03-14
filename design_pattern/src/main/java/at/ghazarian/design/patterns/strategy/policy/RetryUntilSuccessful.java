package at.ghazarian.design.patterns.strategy.policy;

public class RetryUntilSuccessful implements RetryPolicy {
    @Override
    public boolean retry() {
        return true;
    }
}
