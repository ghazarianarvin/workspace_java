package at.ghazarian.design.patterns.strategy.job;

import java.time.LocalDateTime;

public class CleanLogsJob extends Job {

    private static final String CLEAN_LOGS_JOB = "CleanLogsJob_";

    public CleanLogsJob() {
        super(CLEAN_LOGS_JOB.concat(LocalDateTime.now().toString()));
    }

    @Override
    protected void execute() throws Exception {
        throw new Exception("this job always fails");
    }
}
