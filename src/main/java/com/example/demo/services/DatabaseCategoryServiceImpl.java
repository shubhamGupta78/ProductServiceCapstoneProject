package com.example.demo.services;

import com.example.demo.dtos.CreateCategoryRequestDto;
import com.example.demo.exceptions.CategoryNotFoundException;
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
        System.out.println(category.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {

       List<Category> categoryList= categoryRepository.findAll();
       return categoryList;
    }

    @Override
    public Category updateCategory(Category category) {

        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found");
        }
        Category categoryToUpdate = optionalCategory.get();
        if(category.getName()!=null) {
            categoryToUpdate.setName(category.getName());
        }
        if(category.getDescription()!=null) {
            categoryToUpdate.setDescription(category.getDescription());
        }
        if(category.getImage()!=null) {
            categoryToUpdate.setImage(category.getImage());
        }

        categoryRepository.save(categoryToUpdate);
        return categoryToUpdate;
    }
}
