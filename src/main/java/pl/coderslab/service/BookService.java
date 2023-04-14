package pl.coderslab.service;
import pl.coderslab.beans.Book;
import java.util.List;

public interface BookService {
    List<Book> getBooks();
    void addBook(Book book);
    Book getBook(Long id);
    void updateBook(Long bookId, Book book);
    void deleteBook(Long id);
}
