package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.Data;
@Data
public class UpdateProductRequestDto {

    private int productId;
    private String title;
    private String description;
    private Double price;
    private String image;
    private int categoryId;
    private String brand;
    private String ram;
    private Double rating;


    public static Product toProduct(UpdateProductRequestDto updateProductRequestDto) {
        Product product = new Product();
        product.setId(updateProductRequestDto.getProductId());
        product.setImage(updateProductRequestDto.getImage());
        product.setTitle(updateProductRequestDto.getTitle());
        product.setDescription(updateProductRequestDto.getDescription());
        product.setPrice(updateProductRequestDto.getPrice());

        product.setBrand(product.getBrand());
        product.setRam(product.getRam());
        product.setRating(product.getRating());

        return product;
    }
}
