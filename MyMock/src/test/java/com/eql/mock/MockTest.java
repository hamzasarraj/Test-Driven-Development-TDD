package com.eql.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;



public class MockTest {

	@Test
	public void demoMock() {
		BookRepositoryMock mock = new BookRepositoryMock();
		BookService bookService = new BookService(mock);
		
		Book book1 = new Book("1234", "Le Soleil", 600, LocalDate.now());
		Book book2 = new Book("1235", "Le Lune", 300, LocalDate.now());
		
		bookService.addBook(book1);	//return
		bookService.addBook(book2);	//appel save


		mock.verify(book2, 1);
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
		
		ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
		verify(bookRepository).save(bookCaptor.capture());
		assertEquals(book2, bookCaptor.getValue());
	}
}
