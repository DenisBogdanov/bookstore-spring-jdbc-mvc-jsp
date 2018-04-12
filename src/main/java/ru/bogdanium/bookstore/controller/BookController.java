package ru.bogdanium.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.bogdanium.bookstore.exception.BookNotFoundException;
import ru.bogdanium.bookstore.exception.NoBooksWithCategoryException;
import ru.bogdanium.bookstore.model.Book;
import ru.bogdanium.bookstore.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
    public String getBooksByCategory(Model model, @PathVariable String category) {
        List<Book> booksByCategory = bookService.getBooksByCategory(category);
        if (booksByCategory == null || booksByCategory.isEmpty()) {
            throw new NoBooksWithCategoryException();
        }
        model.addAttribute("books", booksByCategory);
        return "books";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("emptyBook", book);
        return "add-book";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(HttpServletRequest request, @ModelAttribute Book bookToAdd, BindingResult result) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        // TODO: set id to give img name, fix later
        bookToAdd.setId(bookService.getAllBooks().size() + 1L);

        MultipartFile bookImg = bookToAdd.getImg();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);

        if (bookImg != null && !bookImg.isEmpty()) {
            try {
                bookImg.transferTo(new File(rootDirectory + "resources\\img\\" + bookToAdd.getId() + ".jpg"));
            } catch (IOException e) {
                throw new RuntimeException("Product Image saving failed",e);
            }
        }

        bookService.addBook(bookToAdd);
        return "redirect:/books";
    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setAllowedFields("title", "author", "price", "category", "unitsInStock", "img");
    }

    @ExceptionHandler
    public ModelAndView handleError(HttpServletRequest request, BookNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("invalidBookId", e.getBookId());
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        modelAndView.setViewName("book-not-found");

        return modelAndView;
    }
}
