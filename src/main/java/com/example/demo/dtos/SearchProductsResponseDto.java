package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class SearchProductsResponseDto {

    Page<Product> productList;
}
