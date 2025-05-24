package com.example.demo.services;

import com.example.demo.dtos.CreateCategoryRequestDto;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseCategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public DatabaseCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {

        return categoryRepository.findAll();
    }
}
