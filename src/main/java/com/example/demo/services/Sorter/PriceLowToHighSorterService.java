package com.example.demo.services.Sorter;

import com.example.demo.models.Product;

import java.util.Collections;
import java.util.List;

public class PriceLowToHighSorterService implements SorterService {

    @Override
    public List<Product> sortProducts(List<Product> products) {
        Collections.sort(products, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
        return products;
    }
}
