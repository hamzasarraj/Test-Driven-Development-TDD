package com.eql.dummy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class DummyTest {

    @Test
    void demoDummy() {
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();

        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("1", "title", 35, LocalDate.now()));
        bookService.addBook(new Book("2", "title2", 34, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBook());
    }
    @Test
    void demoDummyWithMockito () {
    	BookRepository bookRepository = mock(BookRepository.class);
    	EmailService emailService = mock(EmailService.class);
    	
    	BookService bookService = new BookService(bookRepository, emailService);
    	
    	Book book1 = new Book("1", "Soleil", 250, LocalDate.now());
    	Book book2 = new Book("2", "Lune", 200, LocalDate.now());
    	
    	Collection<Book> books = new ArrayList<Book>();
    	books.add(book1);
    	books.add(book2);
    	
    	when(bookRepository.findAll()).thenReturn(books);
    	
    	assertEquals(2, bookService.findNumberOfBook());
    	
    }
}
