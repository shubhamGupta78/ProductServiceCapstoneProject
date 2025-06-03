package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Data
public class Category extends BaseModel {

    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "category",fetch= FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;

}
