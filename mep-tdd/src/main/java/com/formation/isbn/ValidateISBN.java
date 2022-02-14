package com.formation.isbn;

public class ValidateISBN {

	private static final int SHORT_ISBN_X_VALUE = 10;
	private static final int SHORT_ISBN_MULTIPLIER = 10;
	private static final int SHORT_ISBN_NUMBER = 10;
	private static final int LONG_ISBN_NUMBER = 13;

	public boolean checkISBN(String isbn) {
		
		if (isbn.length()== LONG_ISBN_NUMBER) {
			return isThisValide13DigitISBN(isbn);
			
		}else if (isbn.length() == SHORT_ISBN_NUMBER){
			
			
			return isThisValid10DigitsISBN(isbn);
		}
		
		throw new NumberFormatException("ISBN must be 10 digits");
		
	}

	private boolean isThisValid10DigitsISBN(String isbn) {
		int total = 0;
		
		for (int i = 0; i < SHORT_ISBN_NUMBER; i++) {
			
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == SHORT_ISBN_NUMBER - 1 && isbn.charAt(i) == 'X') {
					total += SHORT_ISBN_X_VALUE;
				}else {
					throw new NumberFormatException("ISBN must be a digit");
				}		
			}else {
				total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_MULTIPLIER-i);
			}		
		}	
		return (total % 11 == 0) ? true : false;
	}

	private boolean isThisValide13DigitISBN(String isbn) {
		int total = 0;
		
		for (int i = 0; i < LONG_ISBN_NUMBER; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		
		return (total % 10 == 0) ? true : false;
	}

}
