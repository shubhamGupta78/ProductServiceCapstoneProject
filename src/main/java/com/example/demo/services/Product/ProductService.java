package com.example.demo.services.Product;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.models.Product;

import java.util.List;


public interface ProductService {

    public Product createProduct(Product product,Integer categoryId) throws CategoryNotFoundException;

    public List<Product> getAllProducts();

    public Product updateProduct(Product product,Integer categoryId) throws CategoryNotFoundException;
}
