package dk.trustworks.cronmanager;

import dk.trustworks.cronmanager.jobs.BudgetCleanupJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

/**
 * Created by hans on 07/06/15.
 */
public class CronApplication {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        JobDetail job = newJob(BudgetCleanupJob.class)
                .withIdentity("job1", "group1")
                .build();
        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();
        sched.scheduleJob(job, trigger);
        sched.start();
    }

}
