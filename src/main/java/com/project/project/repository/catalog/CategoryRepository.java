package com.project.project.repository.catalog;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project.model.catalog.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    Optional<Category> findById(Integer id);
    
    boolean existsByName(String name);
}
