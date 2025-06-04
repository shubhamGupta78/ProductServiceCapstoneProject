package com.example.demo.services.Product;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public DatabaseProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(Product product,Integer categoryId) throws CategoryNotFoundException {
        System.out.println("ds"+categoryId);
        Optional<Category> optionalCategory = categoryRepository.findCategory(categoryId);
        if(optionalCategory.isEmpty())
            throw new CategoryNotFoundException("Category not found");

        Category category = optionalCategory.get();
        product.setCategory(category);
        return productRepository.save(product);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product updateProduct(Product product, Integer categoryId) throws CategoryNotFoundException {


        Optional<Category> optionalCategory = categoryRepository.findCategory(categoryId);
        Category category = optionalCategory.get();

        Optional<Product> optionalProduct = productRepository.findProduct(product.getId());
        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product not found");


        Product updatedProduct = optionalProduct.get();
        if(product.getTitle()!=null)
            updatedProduct.setTitle(product.getTitle());
        if(product.getDescription()!=null)
            updatedProduct.setDescription(product.getDescription());
        if(product.getPrice()!=null)
            updatedProduct.setPrice(product.getPrice());
        if(product.getImage()!=null)
            updatedProduct.setImage(product.getImage());
        if(updatedProduct.getCategory().getId()!=category.getId())
            updatedProduct.setCategory(category);
        if(product.getBrand()!=null)
            updatedProduct.setBrand(product.getBrand());
        if(product.getRam()!=null)
            updatedProduct.setRam(product.getRam());
        if(product.getRating()!=null)
            updatedProduct.setRating(product.getRating());


        return productRepository.save(product);
    }
}
