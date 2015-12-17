package com.thoughtworks.jimmy.service;

import com.thoughtworks.jimmy.model.Book;

public interface BookService {
    Iterable<Book> findAll();


    Book getBookByIsbn(String isbn);

    void saveBook(Book book);

    void delete(Book book);

    void undo();
}
