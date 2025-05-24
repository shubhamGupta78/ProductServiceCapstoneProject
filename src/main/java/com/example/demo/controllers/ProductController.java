package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

        private ProductService productService;


        public ProductController(@Qualifier("databaseProductServiceImpl")ProductService productService) {
            this.productService = productService;
        }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();
        try{
            Product product = productService.createProduct(CreateProductRequestDto.toProduct(createProductRequestDto),createProductRequestDto.getCategoryId());
            createProductResponseDto=CreateProductResponseDto.fromProduct(product);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return createProductResponseDto;
    }

    @GetMapping("")
    public GetAllProductResponseDto getAllProducts()
    {
        GetAllProductResponseDto getAllProductResponseDto = new GetAllProductResponseDto();
        List<CreateProductResponseDto> responseDtos = new ArrayList<>();
        try{
            List<Product> products=productService.getAllProducts();
            for(Product product:products)
            {
                CreateProductResponseDto createProductResponseDto = CreateProductResponseDto.fromProduct(product);
                    responseDtos.add(createProductResponseDto);

            }
            getAllProductResponseDto.setCreateProductResponseDtoList(responseDtos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return getAllProductResponseDto;
    }

    @PatchMapping("")
    public CreateProductResponseDto updateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto) {
            CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();

            Product product = productService.updateProduct(UpdateProductRequestDto.toProduct(updateProductRequestDto),updateProductRequestDto.getCategoryId());
            createProductResponseDto=CreateProductResponseDto.fromProduct(product);
            return createProductResponseDto;
    }
}
