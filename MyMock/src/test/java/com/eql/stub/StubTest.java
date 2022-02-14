package com.eql.stub;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.eql.stub.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubTest {

	@Test
	void demoStub() {
		BookRepository bookRepository = new BookRepositoryStub();
		BookService bookService = new BookService(bookRepository);

		List<Book> newBookAvecReduction = bookService.getNewBookWithAppliedDiscount(10, 7);

		assertEquals(450, newBookAvecReduction.get(0).getPrice());
		assertEquals(360, newBookAvecReduction.get(1).getPrice());
	}

	@Test
	void demoStubWithMockito() {

		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);

		Book book1 = new Book("1", "Soleil", 500, LocalDate.now());
		Book book2 = new Book("2", "Lune", 400, LocalDate.now());

		List<Book> newBooks = new ArrayList<Book>();
		newBooks.add(book1);
		newBooks.add(book2);

		when(bookRepository.findNewBooks(7)).thenReturn(newBooks);
		
		List<Book> newBookAvecReduction = bookService.getNewBookWithAppliedDiscount(10, 7);
		
		assertEquals(450, newBookAvecReduction.get(0).getPrice());
		assertEquals(360, newBookAvecReduction.get(1).getPrice());
	}
}
