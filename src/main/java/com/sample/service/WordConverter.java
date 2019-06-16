package com.sample.service;

import com.sample.exception.ValidationException;

/**
 * interface that Converts a Number to Word
 * 
 * @author shanmukh
 *
 */
public interface WordConverter {
	/**
	 * @param inputData input data which will be converting to Word
	 * @return returns converted word
	 * @throws ValidationException
	 */
	public String convertNumberToWord(String inputData) throws ValidationException;
}