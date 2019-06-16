package com.sample.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.sample.exception.ValidationException;
import com.sample.service.WordConverterImpl;

@RunWith(MockitoJUnitRunner.class)
public class WordConverterImplTest {
	WordConverterImpl wordConverterImpl;

	@Before
	public void init() {
		wordConverterImpl = new WordConverterImpl();
	}

	@Test
	public void validateNegetiveNumberTest() {
		String inputData = "-100";
		try {
			wordConverterImpl.convertNumberToWord(inputData);
			assertFalse(true);
		} catch (ValidationException e) {
			assertTrue(
					e.getMessage().equals("The entered number -100 is negetive number. Please enter positive number"));
		}
	}

	@Test
	public void validateNullNumberTest() {
		String inputData = "1234567890";
		try {
			wordConverterImpl.convertNumberToWord(inputData);
			assertFalse(true);
		} catch (ValidationException e) {
			assertTrue(e.getMessage()
					.equals("Enter data is 1234567890 exceeds max length 9(max allowed number is 999,999,999)"));
		}
	}

	@Test
	public void validateExceededNumberTest() {
		String inputData = null;
		try {
			wordConverterImpl.convertNumberToWord(inputData);
			assertFalse(true);
		} catch (ValidationException e) {
			assertTrue(e.getMessage().equals("Enter data is null invalid Data. Please enter valid data"));
		}
	}

	@Test
	public void validateInvalidNumberTest() {
		String inputData = "abcd";
		try {
			wordConverterImpl.convertNumberToWord(inputData);
			assertFalse(true);
		} catch (ValidationException e) {
			assertTrue(e.getMessage().equals("Enter input data is abcd invalid Data. Please enter valid data"));
		}
	}

	@Test
	public void validateZeroNumberTest() {
		String inputData = "0";
		try {
			String word = wordConverterImpl.convertNumberToWord(inputData);
			assertTrue(word.equals("Zero"));
		} catch (ValidationException e) {
			assertFalse(true);
		}
	}

	@Test
	public void validateOneNumberTest() {
		String inputData = "1";
		try {
			String word = wordConverterImpl.convertNumberToWord(inputData);
			assertTrue(word.equals("one"));
		} catch (ValidationException e) {
			assertFalse(true);
		}
	}

	@Test
	public void validateLargeNumberTest() {
		String inputData = "56945781";
		try {
			String word = wordConverterImpl.convertNumberToWord(inputData);
			assertTrue(word.equals(
					"fifty six million and nine Hundred and forty five Thousand and seven Hundred and eighty one"));
		} catch (ValidationException e) {
			assertFalse(true);
		}
	}
}
