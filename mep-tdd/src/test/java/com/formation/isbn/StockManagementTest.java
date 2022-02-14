package com.formation.isbn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StockManagementTest {
@Test
public void testCanGetCorrectLocalCode() {
	ExternalISBNDataService testService = new ExternalISBNDataService() {
		
		@Override
		public Book lookup(String isbn) {
			// TODO Auto-generated method stub
			return new Book(isbn, "Cent poeme de Victor Hugo", "Victor Hugo");
		}
	};
	String isbn = "2258151414";
	StockManger stockManger = new StockManger();
	stockManger.setService(testService);
	String localCode = stockManger.getLocalCode(isbn);
	assertEquals("1414V5", localCode);
}
}
