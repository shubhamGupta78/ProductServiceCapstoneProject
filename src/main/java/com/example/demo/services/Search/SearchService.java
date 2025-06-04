package com.example.demo.services.Search;

import com.example.demo.dtos.FilterDto;
import com.example.demo.dtos.SortingCriteria;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.Filter.FilterFactory;
import com.example.demo.services.Sorter.SorterFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProduct(String query, List<FilterDto> filters, SortingCriteria sortingCriteria,int pageNo,int size) {


        List<Product> products=productRepository.findByTitle(query);

        for (FilterDto filter : filters) {
            products= FilterFactory.getFilterService(filter.getKey()).filterproducts(products,filter.getValues());
        }

        products= SorterFactory.getSorter(String.valueOf(sortingCriteria)).sortProducts(products);

        int start=(pageNo-1)*size;
        int end=pageNo*size;

        products=products.subList(start,end);
        return products;
    }
}
