package ru.bogdanium.bookstore.service;

import ru.bogdanium.bookstore.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
}
