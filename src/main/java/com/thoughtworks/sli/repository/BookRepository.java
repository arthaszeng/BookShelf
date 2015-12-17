package com.thoughtworks.sli.repository;

import com.thoughtworks.sli.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Repository
public class BookRepository {

    public static final Map<String, Book> BOOKS_MAP =
            new HashMap<String, Book>() {
                {
                    put("9780201485677", new Book("9780201485677", "Refactoring", "Martin Fowler", 64.99));
                    put("9780132350884", new Book("9780132350884", "Clean Code", "Robert C. Martin", 35.44));
                    put("9780131429017", new Book("9780131429017", "The Art of UNIX Programming", "Eric S. Raymond", 39.99));
                }
            };
    public static Stack<Book> BOOK_STACK = new Stack<>();

    public Iterable<Book> findAll() {
        return BOOKS_MAP.values();
    }

    public Book findOne(String isbn) {
        return BOOKS_MAP.get(isbn);
    }

    public void saveBook(Book book) {
        BOOKS_MAP.put(book.getIsbn(), book);
    }

    public void delete(Book book) {
        BOOKS_MAP.remove(book.getIsbn());
        BOOK_STACK.add(book);
    }

    public void undo() {
        if(!BOOK_STACK.isEmpty()){
            Book buf = (Book) BOOK_STACK.pop();
            System.out.println(buf.getName() + buf.getIsbn() + buf.getAuthor());
            BOOKS_MAP.put(buf.getIsbn(), buf);
        }else {;}
    }
}
