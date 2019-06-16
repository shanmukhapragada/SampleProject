package com.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.exception.ValidationException;

/**
 * class that Converts a Number to Word
 * 
 * @author shanmukh
 *
 */
public class WordConverterImpl implements WordConverter {

	Logger logger = LoggerFactory.getLogger(WordConverterImpl.class);

	private final String[] numberArray = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	private final String[] tensArray = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	/**
	 * @param inputData input data which will be converting to Word
	 * @return returns converted word
	 * @throws ValidationException
	 */
	public String convertNumberToWord(final String inputData) throws ValidationException {
		validateInputData(inputData);
		int num = Integer.parseInt(inputData);
		if (num == 0) {
			return "Zero";
		}
		return convert(num);
	}

	/**
	 * @param number input number which will be converting to Word
	 * @return returns converted word
	 */
	private String convert(final int num) {
		if (num < 20) {
			return numberArray[num];
		} else if (num < 100) {
			return tensArray[num / 10] + ((num % 10 != 0) ? " " : "") + numberArray[num % 10];
		} else if (num < 1000) {
			return numberArray[num / 100] + " Hundred" + ((num % 100 != 0) ? " and " : "") + convert(num % 100);
		} else if (num < 100000) {
			return convert(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " and " : "") + convert(num % 1000);
		} else if (num < 1000000) {
			return convert(num / 1000) + " Thousand" + ((num % 1000 != 0) ? " and " : "") + convert(num % 1000);
		} else {
			return convert(num / 1000000) + " million" + ((num % 1000000 != 0) ? " and " : "") + convert(num % 1000000);
		}
	}

	/**
	 * @param inputData input data that has to be validated
	 * @throws ValidationException
	 */
	private void validateInputData(String inputData) throws ValidationException {
		if (inputData == null || inputData.isEmpty()) {
			throw new ValidationException("Enter data is " + inputData + " invalid Data. Please enter valid data");
		} else if (inputData.length() > 9) {
			throw new ValidationException(
					"Enter data is " + inputData + " exceeds max length 9(max allowed number is 999,999,999)");
		}
		int number = 0;
		try {
			number = Integer.parseInt(inputData);
		} catch (NumberFormatException e) {
			throw new ValidationException(
					"Enter input data is " + inputData + " invalid Data. Please enter valid data");
		}
		if (number < 0) {
			throw new ValidationException(
					"The entered number " + number + " is negetive number. Please enter positive number");
		}
	}
}