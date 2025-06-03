package com.example.demo.repositories;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(
            value = "SELECT * FROM category WHERE id = :categoryId",
            nativeQuery = true
    )
    Optional<Category> findCategory(@Param("categoryId") Integer categoryId);
}

