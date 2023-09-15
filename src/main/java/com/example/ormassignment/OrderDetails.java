package com.example.ormassignment;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "OrderDetails")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    int orderDetailID;
    @OneToOne()
    @JoinColumn(name = "OrderID")
    Order order;
    @ManyToOne
    @JoinColumn(name = "ProductID")
    Products products;
    @Column(name = "Quantity")
    String quantity;
    @Column(name = "UnitPrice")
    double UnitPrice;





}
