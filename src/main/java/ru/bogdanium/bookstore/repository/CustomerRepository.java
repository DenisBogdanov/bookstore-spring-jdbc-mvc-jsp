package ru.bogdanium.bookstore.repository;

import ru.bogdanium.bookstore.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();
}
