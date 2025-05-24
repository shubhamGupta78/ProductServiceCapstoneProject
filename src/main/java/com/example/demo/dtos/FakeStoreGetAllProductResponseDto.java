package com.example.demo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FakeStoreGetAllProductResponseDto {

    List<FakeStoreCreateProductResponseDto> productResponseDtoList;
}
