package ru.bogdanium.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogdanium.bookstore.model.Book;
import ru.bogdanium.bookstore.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        return bookRepository.getBooksByCategory(category);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.getBookById(bookId);
    }
}
