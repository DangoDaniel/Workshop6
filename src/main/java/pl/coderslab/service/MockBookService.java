package pl.coderslab.service;
import org.springframework.stereotype.Service;
import pl.coderslab.beans.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {
    private List<Book> books;
    private Long id = 0L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in Java",
                "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glowa Java.",
                "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    private Long next() {
        return ++id;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getBook(Long id) {
        return books.stream()
                .filter(n -> id.equals(n.getId()))
                .findAny()
                .orElse(null);
    }
    @Override
    public void addBook(Book book) {

        Optional.ofNullable(book).ifPresent(n ->
                books.add(new Book(
                        next(),
                        n.getIsbn(),
                        n.getTitle(),
                        n.getAuthor(),
                        n.getPublisher(),
                        n.getType()
                        ))
        );
    }
    @Override
    public void updateBook(Long bookId, Book book) {
        Optional.ofNullable(book)
                .filter(n -> bookId > 0)
                .map(n -> getBook(bookId))
                .map(books::indexOf)
                .ifPresent(n -> books.set(n, book));
    }

    @Override
    public void deleteBook(Long bookId) {
        Optional.ofNullable(getBook(bookId))
                .ifPresent(books::remove);
    }
}
