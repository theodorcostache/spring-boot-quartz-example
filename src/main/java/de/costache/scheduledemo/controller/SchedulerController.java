package de.costache.scheduledemo.controller;

import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.costache.scheduledemo.controller.dto.ScheduleRequest;
import de.costache.scheduledemo.controller.dto.ScheduleResponse;
import de.costache.scheduledemo.controller.exception.ExceptionMapping;
import de.costache.scheduledemo.service.SchedulerService;

@RestController
public class SchedulerController {

	@Autowired
	SchedulerService schedulerService;

	@SuppressWarnings("unchecked")
	@ExceptionMapping(exception = ClassNotFoundException.class, errorCode = 0x00001, message = "Job class not found")
	@ExceptionMapping(exception = SchedulerException.class, errorCode = 0x00002, message = "Internal error while registering job. Please check logs for more details")
	@RequestMapping(value = "/schedule", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ScheduleResponse schedule(@RequestBody ScheduleRequest details) throws Exception {

		Class<?> jobClass = Class.forName(details.getJobClass());
		schedulerService.scheduleJob((Class<? extends Job>) jobClass, details.getJobName(), details.getJobGroup(),
				details.getCronExpression());
		return new ScheduleResponse("Successfully scheduled " + details.getJobName());
	}

}
