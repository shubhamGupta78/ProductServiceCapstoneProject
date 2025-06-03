package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.Data;

@Data
public class FakeStoreUpdateProductRequestDto {

        private int id;
        private String title;
        private Double price;
        private String description;
        //private String category;
        private String image;


        public static FakeStoreUpdateProductRequestDto fromProduct(Product product) {
            FakeStoreUpdateProductRequestDto dto = new FakeStoreUpdateProductRequestDto();

            dto.setId(product.getId());
            dto.setTitle(product.getTitle());
            dto.setPrice(product.getPrice());
            dto.setDescription(product.getDescription());
            dto.setImage(product.getImage());
            return dto;

        }
    }


