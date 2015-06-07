package dk.trustworks.cronmanager.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by hans on 07/06/15.
 */
public class BudgetCleanupJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Say Hello to the World and display the date/time
        System.out.println("Hello World! - " + new Date());
    }

}
