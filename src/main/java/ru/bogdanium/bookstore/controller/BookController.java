package ru.bogdanium.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogdanium.bookstore.repository.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public String listBooks(Model model) {

        model.addAttribute("books", bookRepository.getAllBooks());
        return "books";
    }
}
