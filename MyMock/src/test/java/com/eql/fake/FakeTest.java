package com.eql.fake;

import com.eql.fakes.Book;
import com.eql.fakes.BookRepository;
import com.eql.fakes.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class FakeTest {

    @Test
    void testFake() {

        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        bookService.addBook(new Book("1", "Le soleil", 250, LocalDate.now()));
        bookService.addBook(new Book("2", "La lune", 200, LocalDate.now()));

        Assertions.assertEquals(2, bookService.findNumberOfBook());
    }
    
    @Test
    void testFakeWithMokito() {
    	BookRepository bookRepository = mock(BookRepository.class);
    	BookService bookService = new BookService(bookRepository);
    	
    	Book book1 = new Book("1", "Soleil", 250, LocalDate.now());
    	Book book2 = new Book("2", "Lune", 200, LocalDate.now());
    	
    	Collection<Book> books = new ArrayList<Book>();
    	books.add(book1);
    	books.add(book2);
    	
    	when(bookRepository.findAll()).thenReturn(books);
    	
    	assertEquals(2, bookService.findNumberOfBook());
    }
}
