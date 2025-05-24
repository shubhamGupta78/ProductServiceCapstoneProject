package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category extends BaseModel {

    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
