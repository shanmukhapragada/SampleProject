package com.sample.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.exception.ValidationException;
import com.sample.service.WordConverter;
import com.sample.service.WordConverterImpl;

/**
 * Main class to perform conversion
 * 
 * @author shanmukh
 *
 */
public class MainApp {
	/**
	 * @param args input command line argument
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(WordConverterImpl.class);
		WordConverter wordConverter = new WordConverterImpl();
		String inputData = null;
		Scanner scanner = null;
		StringWriter stringWriter = null;
		PrintWriter printWriter = null;
		try {
			stringWriter = new StringWriter();
			printWriter = new PrintWriter(stringWriter);
			scanner = new Scanner(System.in);
			System.out.println("Please enter a number to convert into word:");
			inputData = scanner.nextLine();
			logger.info("Entered input number is:" + inputData);
			String word = wordConverter.convertNumberToWord(inputData);
			if (word != null) {
				logger.info(inputData + " = " + word);
			}
		} catch (ValidationException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace(printWriter);
			logger.error("Exception occurred. reason:\n" + stringWriter.toString());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (printWriter != null) {
				printWriter.close();
			}
			if (stringWriter != null) {
				try {
					stringWriter.close();
				} catch (IOException e) {
					// IOException
				}
			}
		}
	}
}