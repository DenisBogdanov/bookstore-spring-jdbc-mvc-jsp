package ru.bogdanium.bookstore.repository;

import ru.bogdanium.bookstore.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    List<Book> getBooksByCategory(String category);
}
