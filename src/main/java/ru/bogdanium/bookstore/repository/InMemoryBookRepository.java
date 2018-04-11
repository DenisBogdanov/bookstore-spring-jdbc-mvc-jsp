package ru.bogdanium.bookstore.repository;

import org.springframework.stereotype.Repository;
import ru.bogdanium.bookstore.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private List<Book> books;

    public InMemoryBookRepository() {
        books = new ArrayList<>();

        Book book = new Book(1L, "Harry Potter", "J.K. Rowling", new BigDecimal("39.95"));
        book.setCategory("Children's Books");
        book.setUnitsInStock(100);
        books.add(book);

        book = new Book(2L, "Peaceful Warrior", "Dan Millman", new BigDecimal("11.95"));
        book.setCategory("Spirituality");
        book.setUnitsInStock(10);
        books.add(book);

        book = new Book(3L, "Memoirs of a Geisha", "Arthur Golden", new BigDecimal("14.95"));
        book.setCategory("Biographical");
        book.setUnitsInStock(30);
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(Long bookId) {
        return books.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
