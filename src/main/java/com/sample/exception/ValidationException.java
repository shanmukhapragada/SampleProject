package com.sample.exception;

/**
 * To handle validation exceptions
 * @author shanmukh
 *
 */
public class ValidationException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public ValidationException(String message)
	{
		super(message);
	}
}
