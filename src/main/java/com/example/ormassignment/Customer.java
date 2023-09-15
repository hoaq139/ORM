package com.example.ormassignment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CustomerID")
    int customerID;
    @Column(name="FirstName")
    String firstName;
    @Column(name="LastName")
    String lastName;
    @Column(name="Email")
    String email;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orderList;



}
