package com.example.demo.controllers;


import com.example.demo.dtos.FilterDto;
import com.example.demo.dtos.SearchProductsResponseDto;
import com.example.demo.dtos.SortingCriteria;
import com.example.demo.models.Product;
import com.example.demo.services.Search.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;

    }

    private Page<Product> convertToPage(List<Product> productList, int page, int size) {
        int start = Math.min(page * size, productList.size());
        int end = Math.min((page + 1) * size, productList.size());
        List<Product> subList = productList.subList(start, end);
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(subList, pageable, productList.size());
    }

    @GetMapping("/")
    public ResponseEntity<SearchProductsResponseDto> getProducts(
            @RequestParam("query") String query,
            @RequestParam("filter") List<FilterDto> filters,
            @RequestParam("sortBy")SortingCriteria sortingCriteria,
            @RequestParam("pageNo") int pageNo,
            @RequestParam("size") int size
            ) {

        List<Product> products=searchService.searchProduct(query, filters, sortingCriteria,pageNo,size);
        SearchProductsResponseDto responseDto=new SearchProductsResponseDto();
        responseDto.setProductList(convertToPage(products, pageNo, size));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
