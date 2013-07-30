package de.costache.scheduledemo.controller.dto;

public class ErrorResponse {

	private String message;
	private int errorCode;

	/**
	 * @param message
	 * @param errorCode
	 */
	public ErrorResponse(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
