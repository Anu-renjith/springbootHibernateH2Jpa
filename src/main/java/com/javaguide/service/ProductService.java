package com.javaguide.service;

import java.util.List;

import com.javaguide.model.Product;

public interface ProductService {
Product createProduct(Product product);
Product updateProduct(Product product);
List<Product> getAllProducts();
Product getProductById(Long productId);
void deleteById(Long id);
}
