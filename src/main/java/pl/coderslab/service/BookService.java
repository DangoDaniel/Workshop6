package pl.coderslab.service;

import pl.coderslab.entity.Book;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(Long index);
    void addBook(Book book);
    void updateBook(Long bookId, Book book);
    void deleteBook(Long index);
}
