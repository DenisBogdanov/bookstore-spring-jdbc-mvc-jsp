package ru.bogdanium.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogdanium.bookstore.model.Book;
import ru.bogdanium.bookstore.repository.BookRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void processOrder(Long bookId, int quantity) {
        Book book = bookRepository.getBookById(bookId);

        int unitsInStock = book.getUnitsInStock();

        if (unitsInStock < quantity) {
            throw new IllegalArgumentException("Out of stock. Available units in stock " + unitsInStock);
        }

        book.setUnitsInStock(unitsInStock - quantity);
    }
}
