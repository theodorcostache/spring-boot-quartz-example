package de.costache.scheduledemo.controller.exception;

public class ControllerException extends RuntimeException {

	private int errorCode = 999;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8541185178989014113L;

	/**
	 * 
	 */
	public ControllerException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param message
	 */
	public ControllerException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @param cause
	 */
	public ControllerException(Throwable cause) {
		super(cause);
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
