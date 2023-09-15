package com.example.ormassignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer findById(int customerId) {
        return customerRepository.findById(customerId).get();
    }
}
