package de.costache.scheduledemo.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class ContextAwareSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
	}

	@Override
	protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
		final Object job = super.createJobInstance(bundle);
		autowireCapableBeanFactory.autowireBean(job);
		return job;
	}

}