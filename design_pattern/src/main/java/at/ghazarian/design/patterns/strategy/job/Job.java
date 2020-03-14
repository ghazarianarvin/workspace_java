package at.ghazarian.design.patterns.strategy.job;

import at.ghazarian.design.patterns.strategy.policy.RetryPolicy;
import lombok.Getter;
import lombok.Setter;

// instead of implementing RetryPolicy composite it.
// if you look into the subclasses of job, they are not polluted with retryPolicy implementations
// the only responsibility of the Subclasses of Job is implementing their job logic --> SR checked.
public abstract class Job {

    @Getter
    private JobStatus jobStatus;
    @Getter
    @Setter
    private RetryPolicy retry;
    @Getter
    @Setter
    private String name;

    public Job(String name) {
        this.jobStatus = JobStatus.CREATED;
        this.name = name;
    }

    public final void executeJob() {
        try {
            System.out.println("starting " + this.name);
            this.jobStatus = JobStatus.RUNNING;
            execute();
            this.jobStatus = JobStatus.FINISHED;
        } catch (Exception e) {
            if (retry != null && retry.retry()) {
                System.out.println("restarting " + this.name);
                executeJob();
            } else {
                System.err.println(this.name + " failed.");
                this.jobStatus = JobStatus.FAILED;
            }
        }
    }

    abstract void execute() throws Exception;

}
