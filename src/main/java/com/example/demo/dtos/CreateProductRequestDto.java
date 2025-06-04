package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.Data;

@Data
public class CreateProductRequestDto {

    private String title;
    private Double price;
    private String description;
   // private String category;

    private int categoryId;
    private String image;
    private String brand;
    private String ram;
    private Double rating;

    public static Product toProduct(CreateProductRequestDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        //product.setCategory(dto.getCategory());
        product.setImage(dto.getImage());
        product.setBrand(dto.getBrand());
        product.setRam(dto.getRam());
        product.setRating(dto.getRating());
        return product;
    }
}
