package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.Data;

@Data
public class FakeStoreCreateProductResponseDto {

    private int id;
    private String title;
    private Double price;
    private String description;
   // private String category;
    private String image;


    public static Product  toProduct(FakeStoreCreateProductResponseDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
       // product.setCategory(dto.getCategory());
        product.setImage(dto.getImage());
        return product;

    }

    public static FakeStoreCreateProductResponseDto toDto(Product product) {
        FakeStoreCreateProductResponseDto dto = new FakeStoreCreateProductResponseDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        //dto.setCategory(product.getCategory());
        dto.setImage(product.getImage());
        return dto;

    }
}
