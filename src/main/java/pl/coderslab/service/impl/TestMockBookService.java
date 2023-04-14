package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestMockBookService implements BookService {
    private List<Book> list;
    private static Long nextId = 0L;

    public TestMockBookService() {
        list = new ArrayList<>();

        addBook(Book.builder()
                .author("Michalina Odrowska")
                .isbn("1500100900")
                .title("Sztuka smarkania")
                .publisher("Wydawnictwa Szkolne i Przedszkolne")
                .type("Poradniki")
                .build());

        addBook(Book.builder()
                .author("Bruce Eckel")
                .isbn("9788324631766")
                .title("Thinking in Java")
                .publisher("Helion")
                .type("programming")
                .build());

        addBook(Book.builder()
                .author("Tom Morello")
                .isbn("666")
                .title("Anarchia dla opornych")
                .publisher("ReadMe")
                .type("Poradniki")
                .build());
    }

    private long next() {
        return ++nextId;
    }

    public List<Book> getAllBooks() {
        return this.list;
    }

    public Book getBookById(Long index) {
        return list.stream()
                .filter(n -> n.getId().equals(index))
                .findAny()
                .orElse(null);
    }

    public void addBook(Book book) {
        Optional.ofNullable(book).ifPresent(n ->
                list.add(Book.builder()
                        .id(next())
                        .author(n.getAuthor())
                        .isbn(n.getIsbn())
                        .title(n.getTitle())
                        .publisher(n.getPublisher())
                        .type(n.getType())
                        .build()));
    }

    public void updateBook(Long bookId, Book book) {
        Optional.ofNullable(book)
                .filter(n -> bookId > 0)
                .map(n -> getBookById(bookId))
                .map(n -> list.indexOf(n))
                .ifPresent(n -> list.set(n, book));
    }

    public void deleteBook(Long index) {
        Optional.ofNullable(getBookById(index))
                .ifPresent(n -> list.remove(n));
    }
}