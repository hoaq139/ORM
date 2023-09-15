package com.example.ormassignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
private final ProductRepository productRepository;
    public List<Products> findProductByCategory(Categories categories) {
        return productRepository.findProductsByCategories(categories);

    }

    public List<Products> getAll() {
        return productRepository.findAll();
    }
}
