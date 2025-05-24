package com.example.demo.dtos;

import com.example.demo.models.Category;
import lombok.Data;

@Data
public class CreateCategoryResponseDto {

    private int id;
    private String name;
    private String description;

    public static CreateCategoryResponseDto toDto(Category category) {
       CreateCategoryResponseDto dto = new CreateCategoryResponseDto();
       dto.setId(category.getId());
       dto.setName(category.getName());
       dto.setDescription(category.getDescription());
       return dto;
    }
}
