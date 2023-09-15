package com.example.ormassignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderManagerRepository extends JpaRepository<Order,Integer> {


    //List<Order> findOrdersByCustomer(Customer customer);

    List<Order> findOrdersByCustomer(Customer customerId);
}
