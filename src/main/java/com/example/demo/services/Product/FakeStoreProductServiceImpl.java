package com.example.demo.services.Product;

import com.example.demo.dtos.FakeStoreCreateProductRequestDto;
import com.example.demo.dtos.FakeStoreCreateProductResponseDto;
import com.example.demo.dtos.FakeStoreUpdateProductRequestDto;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.models.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product,Integer categoryId) {

        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto =FakeStoreCreateProductRequestDto.fromProduct(product);
        FakeStoreCreateProductResponseDto fakeStoreCreateProductResponseDto =
                restTemplate.postForObject("https://fakestoreapi.com/products",
                        fakeStoreCreateProductRequestDto, FakeStoreCreateProductResponseDto.class);

        Product product1=FakeStoreCreateProductResponseDto.toProduct(fakeStoreCreateProductResponseDto);
        return product1;

    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreCreateProductResponseDto[] response=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreCreateProductResponseDto[].class);

        return Stream.of(response).map(res->FakeStoreCreateProductResponseDto.toProduct(res)).toList();


    }

    @Override
    public Product updateProduct(Product product, Integer categoryId) throws CategoryNotFoundException {
        FakeStoreUpdateProductRequestDto fakeStoreUpdateProductRequestDto = FakeStoreUpdateProductRequestDto.fromProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // ✅ Ensure URL is correctly formed
        String url = "https://fakestoreapi.com/products/" + fakeStoreUpdateProductRequestDto.getId();

        HttpEntity<FakeStoreUpdateProductRequestDto> entity = new HttpEntity<>(fakeStoreUpdateProductRequestDto, headers);

        ResponseEntity<FakeStoreCreateProductResponseDto> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.PUT,
                        entity,
                        FakeStoreCreateProductResponseDto.class
                );

        return FakeStoreCreateProductResponseDto.toProduct(response.getBody());
    }

}
