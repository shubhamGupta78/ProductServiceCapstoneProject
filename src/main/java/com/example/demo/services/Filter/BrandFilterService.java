package com.example.demo.services.Filter;

import com.example.demo.models.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrandFilterService implements  FilterService{

    @Override
    public List<Product> filterproducts(List<Product> products, List<String> values) {
        Set<String> st = new HashSet<>(values);

        List<Product> filteredProducts=new ArrayList<>();
        for(Product product: products) {
            if(st.contains(product.getBrand())) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
