package com.example.demo.controllers;

import com.example.demo.dtos.CreateCategoryRequestDto;
import com.example.demo.dtos.CreateCategoryResponseDto;
import com.example.demo.dtos.GetAllCategoryResponseDto;
import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    public CreateCategoryResponseDto addCategory(@RequestBody CreateCategoryRequestDto createCategoryRequestDto) {

        CreateCategoryResponseDto createCategoryResponseDto = new CreateCategoryResponseDto();
        Category category = categoryService.createCategory(createCategoryRequestDto.toCategory());
        return CreateCategoryResponseDto.toDto(category);


    }

    @GetMapping("")
    public GetAllCategoryResponseDto getAllCategories() {

            GetAllCategoryResponseDto getAllCategoryResponseDto = new GetAllCategoryResponseDto();
            List<Category> categoryList=categoryService.findAllCategory();
            List<CreateCategoryResponseDto> responseDtoList=categoryList.stream().map(CreateCategoryResponseDto::toDto).collect(Collectors.toList());
            getAllCategoryResponseDto.setCreateCategoryResponseDtoList(responseDtoList);
            return getAllCategoryResponseDto;
    }
}
