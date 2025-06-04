package com.example.demo.services.Category;

import com.example.demo.models.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);
    public List<Category> findAllCategory();
    public Category updateCategory(Category category);
}
