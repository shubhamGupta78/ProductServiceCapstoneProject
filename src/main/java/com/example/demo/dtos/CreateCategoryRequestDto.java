package com.example.demo.dtos;

import com.example.demo.models.Category;
import lombok.Data;

@Data
public class CreateCategoryRequestDto {
    private String name;
    private String description;

    public Category toCategory() {
        Category category = new Category();
        category.setName(this.name);
        category.setDescription(this.description);
        return category;
    }
}
