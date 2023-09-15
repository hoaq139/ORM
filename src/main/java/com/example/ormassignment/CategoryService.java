package com.example.ormassignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Categories findById(int categoryID) {
        return categoryRepository.findById(categoryID).get();
    }

    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }
}
