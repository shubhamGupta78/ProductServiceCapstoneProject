package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel {

    private String title;
    private Double price;
    private String description;

    @ManyToOne
    private Category category;
    private String image;
    private String brand;
    private String ram;
    private Double rating;

}
