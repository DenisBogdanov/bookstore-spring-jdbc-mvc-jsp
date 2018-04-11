package ru.bogdanium.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.bogdanium.bookstore.model.Book;
import ru.bogdanium.bookstore.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping("/book/{bookId}")
    public String getBook(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "book";
    }

    @RequestMapping("/{category}")
    public String getBookByCategory(Model model, @PathVariable String category) {
        model.addAttribute("books", bookService.getBooksByCategory(category));
        return "books";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("emptyBook", book);
        return "add-book";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book, BindingResult result) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        bookService.addBook(book);
        return "redirect:/books";
    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id", "unitsInOrder");
    }
}
