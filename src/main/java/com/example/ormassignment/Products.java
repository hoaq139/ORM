package com.example.ormassignment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "Products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    int productID;
    @Column(name = "ProductName")
    String productName;
    @Column(name = "ProductPrice")
    double productPrice;
    @Column(name = "StockQuantity")
    int stockQuantity;
    @ManyToOne()
    @JoinColumn(name = "CategoryID")
    Categories categories;
    @OneToMany(mappedBy = "products")
    Set<OrderDetails> orderDetails;

}
