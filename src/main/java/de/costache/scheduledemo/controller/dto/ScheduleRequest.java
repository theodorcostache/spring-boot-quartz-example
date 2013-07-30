package de.costache.scheduledemo.controller.dto;

public class ScheduleRequest {

	private String jobClass;
	private String jobName;
	private String jobGroup;
	private String cronExpression;

	public ScheduleRequest() {

	}

	public ScheduleRequest(String jobClass, String jobName, String jobGroup, String cronExpression) {
		this.jobClass = jobClass;
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.cronExpression = cronExpression;
	}

	/**
	 * @return the jobClass
	 */
	public String getJobClass() {
		return jobClass;
	}

	/**
	 * @param jobClass
	 *            the jobClass to set
	 */
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName
	 *            the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the jobGroup
	 */
	public String getJobGroup() {
		return jobGroup;
	}

	/**
	 * @param jobGroup
	 *            the jobGroup to set
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	/**
	 * @return the cronExpression
	 */
	public String getCronExpression() {
		return cronExpression;
	}

	/**
	 * @param cronExpression
	 *            the cronExpression to set
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobClass == null) ? 0 : jobClass.hashCode());
		result = prime * result + ((jobGroup == null) ? 0 : jobGroup.hashCode());
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleRequest other = (ScheduleRequest) obj;
		if (jobClass == null) {
			if (other.jobClass != null)
				return false;
		} else if (!jobClass.equals(other.jobClass))
			return false;
		if (jobGroup == null) {
			if (other.jobGroup != null)
				return false;
		} else if (!jobGroup.equals(other.jobGroup))
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		return true;
	}

}
