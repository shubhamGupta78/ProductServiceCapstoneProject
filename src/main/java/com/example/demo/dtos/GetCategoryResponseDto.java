package com.example.demo.dtos;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class GetCategoryResponseDto {
    private int id;
    private String name;
    private String description;
    private List<CreateProductResponseDto> product;


    public static GetCategoryResponseDto toDto(Category category) {
        GetCategoryResponseDto dto = new GetCategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

      List<Product> products=category.getProducts();
        List<CreateProductResponseDto> createProductResponseDtoList=products.stream()
                .map(product1 -> CreateProductResponseDto.fromProduct(product1)).collect(toList());
        dto.setProduct(createProductResponseDtoList);

        return dto;
    }

}
