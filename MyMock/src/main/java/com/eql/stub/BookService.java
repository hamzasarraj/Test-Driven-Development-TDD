package com.eql.stub;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   public List<Book> getNewBookWithAppliedDiscount(int discountRate, int jour) {
        List<Book> newBooks = bookRepository.findNewBooks(7);
        //500 applique 10
       for (Book book: newBooks) {
           int price = book.getPrice();
           int newPrice = price - (discountRate* price /100);
            book.setPrice(newPrice);
       }
        return newBooks;
   }
}
