package com.thoughtworks.sli.service;

import com.thoughtworks.sli.model.Book;

public interface BookService {
    Iterable<Book> findAll();


    Book getBookByIsbn(String isbn);

    void saveBook(Book book);

    void delete(Book book);

    void undo();
}
