package com.javaguide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguide.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
