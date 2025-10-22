package com.example.customerapp.service;

import com.example.customerapp.model.Customer;
import com.example.customerapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
