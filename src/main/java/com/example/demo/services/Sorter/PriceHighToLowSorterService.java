package com.example.demo.services.Sorter;

import com.example.demo.models.Product;

import java.util.Collections;
import java.util.List;

public class PriceHighToLowSorterService implements SorterService {

    @Override
    public List<Product> sortProducts(List<Product> products) {
        Collections.sort(products, (o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
        return products;
    }
}
