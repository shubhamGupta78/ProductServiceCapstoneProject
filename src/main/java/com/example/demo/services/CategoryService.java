package com.example.demo.services;

import com.example.demo.dtos.CreateCategoryRequestDto;
import com.example.demo.models.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);
    public List<Category> findAllCategory();
    public Category updateCategory(Category category);
}
