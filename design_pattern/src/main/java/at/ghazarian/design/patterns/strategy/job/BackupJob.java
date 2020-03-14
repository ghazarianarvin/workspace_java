package at.ghazarian.design.patterns.strategy.job;

import java.time.LocalDateTime;

public class BackupJob extends Job {

    private static final String BACKUP_JOB = "BackupJob_";

    public BackupJob() {
        super(BACKUP_JOB.concat(LocalDateTime.now().toString()));
    }

    @Override
    protected void execute() throws Exception {
        throw new Exception("this job always fails");
    }
}
