package com.example.demo.services.Sorter;

import com.example.demo.models.Product;

import java.util.Collections;
import java.util.List;

public class PopularitySorterService implements SorterService {

    @Override
    public List<Product> sortProducts(List<Product> products) {

        Collections.sort(products, (o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt()));
        return products;
    }
}
