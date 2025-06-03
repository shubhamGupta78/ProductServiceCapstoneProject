package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        private final CategoryService categoryService;

        public CategoryController(CategoryService categoryService) {
                this.categoryService = categoryService;
        }

    @PostMapping("")
    public ResponseEntity<CreateCategoryResponseDto> addCategory(
            @RequestBody CreateCategoryRequestDto createCategoryRequestDto)
    {

        Category category = categoryService.createCategory(createCategoryRequestDto.toCategory());
        CreateCategoryResponseDto responseDto = CreateCategoryResponseDto.toDto(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("")
    public ResponseEntity<GetAllCategoryResponseDto> getAllCategories() {

            GetAllCategoryResponseDto getAllCategoryResponseDto = new GetAllCategoryResponseDto();
            List<Category> categoryList=categoryService.findAllCategory();
            List<GetCategoryResponseDto> responseDtoList=categoryList.stream().map(GetCategoryResponseDto::toDto).collect(Collectors.toList());
            getAllCategoryResponseDto.setResponseDto(responseDtoList);
            return ResponseEntity.status(HttpStatus.CREATED).body(getAllCategoryResponseDto);
    }

    @PatchMapping("")
    public ResponseEntity<CreateCategoryResponseDto> updateCategory(
            @RequestBody UpdateCategoryRequestDto updateCategoryRequestDto)
    {
        Category category = categoryService.updateCategory(updateCategoryRequestDto.toCategory());
        CreateCategoryResponseDto responseDto =CreateCategoryResponseDto.toDto(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

    }
}
