package pl.coderslab.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.BookService;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long index) {
        return bookRepository.findById(index).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long index) {
        bookRepository.deleteById(index);
    }
}