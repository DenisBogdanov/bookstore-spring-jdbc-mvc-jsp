package ru.bogdanium.bookstore.repository;

import org.springframework.stereotype.Repository;
import ru.bogdanium.bookstore.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

    private List<Customer> customers;

    public InMemoryCustomerRepository() {
        customers = new ArrayList<>();

        customers.add(new Customer(1L, "Test1", "Test1", "test1@mail.com"));
        customers.add(new Customer(2L, "Test2", "Test2", "test2@mail.com"));
    }


    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customers);
    }
}
