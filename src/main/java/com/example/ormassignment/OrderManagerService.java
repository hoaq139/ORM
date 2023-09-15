package com.example.ormassignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManagerService {
    private final OrderManagerRepository orderManagerRepository;
    private final CustomerRepository customerRepository;
    public List<Order> getAll() {
        return orderManagerRepository.findAll();

    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Order findById(int id) {
        return orderManagerRepository.findById(id).get();
    }


//    public List<Order> findOrderByCustomer(Customer customer) {
//        return orderManagerRepository.findOrdersByCustomer(customer);
//    }

//    public List<Order> findOrdersByCustomerId(int customerId) {
//        return orderManagerRepository.findOrdersByCustomer(customerId);
//    }

    public List<Order> findOrdersByCustomer(Customer customerId) {
        return orderManagerRepository.findOrdersByCustomer(customerId);
    }
}
