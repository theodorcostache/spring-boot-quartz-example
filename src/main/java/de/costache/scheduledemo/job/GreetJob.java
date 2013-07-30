package de.costache.scheduledemo.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.costache.scheduledemo.service.GreetService;
import de.costache.scheduledemo.util.QuartzJob;

@QuartzJob
@DisallowConcurrentExecution
public class GreetJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(GreetJob.class);

	@Autowired
	GreetService helloService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info(helloService.sayHello("Teddy"));
	}
}
