package at.ghazarian.design.patterns.strategy;

import at.ghazarian.design.patterns.strategy.job.BackupJob;
import at.ghazarian.design.patterns.strategy.job.CleanLogsJob;
import at.ghazarian.design.patterns.strategy.policy.DontRetry;
import at.ghazarian.design.patterns.strategy.policy.RetryNTimes;

public class Main {

    public static void main(String[] args) {
        BackupJob bj = new BackupJob();
        bj.setRetry(new RetryNTimes(3));
        bj.executeJob();

        CleanLogsJob cj = new CleanLogsJob();
        cj.setRetry(new DontRetry());
        cj.executeJob();

        // execute method is protected!
        //cj.execute()

//          runs forever
//        cj = new CleanLogsJob();
//        cj.setRetry(new RetryUntilSuccessful());
//        cj.executeJob();
    }
}
