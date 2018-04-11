package ru.bogdanium.bookstore.service;

public interface OrderService {

    void processOrder(Long bookId, int quantity);
}
