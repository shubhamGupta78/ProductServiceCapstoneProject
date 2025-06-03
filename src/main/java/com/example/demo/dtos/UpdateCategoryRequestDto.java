package com.example.demo.dtos;

import com.example.demo.models.Category;

import lombok.Data;
@Data
public class UpdateCategoryRequestDto {


    private int id;
    private String name;
    private String description;

    public Category toCategory() {
        Category category = new Category();

        category.setId(id);
        category.setName(this.name);
        category.setDescription(this.description);
        return category;
    }
}
