package ru.bogdanium.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogdanium.bookstore.model.Book;

import java.math.BigDecimal;

@Controller
public class BookController {

    @RequestMapping("/books")
    public String listBooks(Model model) {
        Book book = new Book(1L, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", new BigDecimal("39.95"));
        book.setCategory("Children's Books");
        book.setUnitsInStock(100);

        model.addAttribute("book", book);
        return "books";
    }
}
