package com.example.demo.services.Filter;

import com.example.demo.models.Product;

import java.util.List;

public interface FilterService {

    public List<Product> filterproducts(List<Product> products, List<String> values);
}
