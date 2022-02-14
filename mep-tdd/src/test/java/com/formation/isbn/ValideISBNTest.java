package com.formation.isbn;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ValideISBNTest {

	@Test
	public void checkValidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1035204487");
		assertTrue(result);
	}
	
	@Test
	public void checkNoValidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1035204489");
		assertFalse(result);
	}
	
	@Test
	public void nineDigitISBNAreNotAllow() {
		ValidateISBN validator = new ValidateISBN();
		assertThrows(NumberFormatException.class, () -> {
			validator.checkISBN("123456789");
		});
	}
	
	@Test
	public void ISBNMustBeADigit() {
		ValidateISBN validator = new ValidateISBN();
		assertThrows(NumberFormatException.class, () -> {
			validator.checkISBN("aaaaaaaaa0");
		});
	}
	
	@Test
	public void checkValidISBNWithX() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("237884431X");
		assertTrue(result);
	}
	
	@Test
	public void checkValid13DigitsISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9782378844318");
		assertTrue(result);
	}
	
	@Test
	public void checkNonValid13DigitsISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9782378844319");
		assertFalse(result);
	}
}
