package com.mylearning.productservice.productservice.repository;

import com.mylearning.productservice.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    public Product findByName(String name);
}
