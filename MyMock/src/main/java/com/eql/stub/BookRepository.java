package com.eql.stub;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
