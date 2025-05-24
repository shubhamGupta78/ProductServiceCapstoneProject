package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.Data;

@Data
public class FakeStoreCreateProductRequestDto {

    private String title;
    private Double price;
    private String description;
    //private String category;
    private String image;


    public static FakeStoreCreateProductRequestDto  fromProduct(Product product) {
        FakeStoreCreateProductRequestDto dto = new FakeStoreCreateProductRequestDto();
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        //dto.setCategory(product.getCategory());
        dto.setImage(product.getImage());

        return dto;

    }
}
