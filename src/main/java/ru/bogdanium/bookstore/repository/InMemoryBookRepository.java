package ru.bogdanium.bookstore.repository;

import org.springframework.stereotype.Repository;
import ru.bogdanium.bookstore.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        Book book = new Book(1L, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", new BigDecimal("39.95"));
        book.setCategory("Children's Books");
        book.setUnitsInStock(100);
        books.add(book);
        books.add(book);
        books.add(book);

        book = new Book(2L, "Way of the Peaceful Warrior", "Dan Millman", new BigDecimal("11.95"));
        book.setCategory("Spirituality");
        book.setUnitsInStock(10);
        books.add(book);
        books.add(book);
        books.add(book);

        book = new Book(3L, "Memoirs of a Geisha", "Arthur Golden", new BigDecimal("14.95"));
        book.setCategory("Biographical");
        book.setUnitsInStock(30);
        books.add(book);
        books.add(book);
        books.add(book);

        return books;
    }
}
