package de.costache.scheduledemo.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import de.costache.scheduledemo.job.GreetJob;

@Service
public class SchedulerService implements InitializingBean {

	@Autowired
	private SchedulerFactoryBean schedulerFactory;

	@Override
	public void afterPropertiesSet() throws Exception {
		scheduleJob(GreetJob.class, GreetJob.class.getSimpleName(), "GREETING", "* * * * * ?");
	}

	/**
	 * Registers a job without a trigger
	 * 
	 * @param jobClass
	 *            the job class
	 * @param jobName
	 *            the job's name
	 * @param jobGroup
	 *            the job's group
	 * @param replace
	 *            if the job is already registered
	 * @throws SchedulerException
	 *             if there is an internal Scheduler error, or a Job with the same
	 *             name already exists, and <code>replace</code> is
	 *             <code>false</code>.
	 */
	public void register(Class<? extends Job> jobClass, String jobName, String jobGroup, boolean replace)
			throws SchedulerException {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).storeDurably().build();
		scheduler.addJob(jobDetail, replace);
	}

	/**
	 * Schedules a job using the given cron expression.
	 * 
	 * @param jobClass
	 *            the job class
	 * @param jobName
	 *            the job's name
	 * @param jobGroup
	 *            the job's group
	 * @param cronExpression
	 *            the cron expression for the trigger
	 * @throws SchedulerException
	 *             if the Trigger cannot be added to the Scheduler, or there is an
	 *             internal Scheduler error.
	 */
	public void scheduleJob(Class<? extends Job> jobClass, String jobName, String jobGroup, String cronExpression)
			throws SchedulerException {

		Scheduler scheduler = schedulerFactory.getScheduler();

		JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

		if (!scheduler.checkExists(jobKey)) {
			register(jobClass, jobName, jobGroup, true);
		}

		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobDetail)
				.withSchedule(cronScheduleBuilder).build();

		if (!scheduler.checkExists(triggerKey)) {
			scheduler.scheduleJob(cronTrigger);
		} else {
			scheduler.rescheduleJob(triggerKey, cronTrigger);
		}
	}
}
