package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping(path = "/add")
    String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping(path = "/add")
    String processAddBookForm(@Valid Book book, BindingResult result) {
        if(result.hasErrors()){
            return "books/add";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping(path = "/edit/{id}")
    String showEditBookForm(Model model, @PathVariable long id) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/edit";
    }

    @PostMapping(path = "/edit/{id}")
    String processEditBookForm(@Valid Book book, @PathVariable long id, BindingResult result) {
        if(result.hasErrors()){
            return "books/edit";
        }
        bookService.updateBook(id, book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/details/{id}")
    public String showBook(Model model, @PathVariable long id) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/details";
    }
}