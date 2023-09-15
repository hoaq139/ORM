package com.example.ormassignment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OrderID")
    int orderId;
    @Column(name="OrderDate")
    String orderDate;
    @Column(name="TotalAmount")
    int totalAmount;
    @ManyToOne()
    @JoinColumn(name="CustomerID", nullable=false)
    private Customer customer;





}
