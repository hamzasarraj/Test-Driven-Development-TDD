package com.eql.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository{

    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();

        Book book1 = new Book("1", "title", 500, LocalDate.now());
        Book book2 = new Book("2", "title2", 400, LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);

        return newBooks;
    }
}
