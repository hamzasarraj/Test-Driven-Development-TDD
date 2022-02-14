package com.eql.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpyTest {

	@Test
	void demoSpy() {
		
		BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
		BookService bookService = new BookService(bookRepositorySpy);
		
		Book book1 = new Book("1234", "Le Soleil", 600, LocalDate.now());
		Book book2 = new Book("1235", "La Lune", 300, LocalDate.now());
		
		bookService.addBook(book1);
		assertEquals(0, bookRepositorySpy.timesCalled());
		
		bookService.addBook(book2);
		assertEquals(1, bookRepositorySpy.timesCalled());
		
		assertTrue(bookRepositorySpy.calledWith(book2));
	}
	
	@Test
	void demoSpyWithMockito() {
		
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);
		
		Book book1 = new Book("1234", "Le Soleil", 600, LocalDate.now());
		Book book2 = new Book("1235", "La Lune", 300, LocalDate.now());
		
		bookService.addBook(book1);	// return
		bookService.addBook(book2);	// appel à save
		
		verify(bookRepository, Mockito.times(0)).save(book1);
		verify(bookRepository, Mockito.times(1)).save(book2);
	}
}
