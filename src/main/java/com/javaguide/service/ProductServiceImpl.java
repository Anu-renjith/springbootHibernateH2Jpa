package com.javaguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguide.exception.ResourceNotFoundException;
import com.javaguide.model.Product;
import com.javaguide.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Product createProduct(Product product) {
		
		return repo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
	Optional<Product> productDb=this.repo.findById(product.getId());
	if(productDb.isPresent()) {
		Product productUpdate=productDb.get();
		productUpdate.setId(product.getId());
		productUpdate.setName(product.getName());
		productUpdate.setDescription(product.getDescription());
		productUpdate.setPrice(product.getPrice());
		repo.save(productUpdate);
		return productUpdate;
		
	}else {
		throw new ResourceNotFoundException("record not found with id"+product.getId());
	
	}
	 

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Product getProductById(Long productId) {
		Optional<Product> productDb=this.repo.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ResourceNotFoundException("record not found with id"+productId);
		}
	
	}

	@Override
	public void deleteById(Long productId) {
		Optional<Product> productDb=this.repo.findById(productId);
		if(productDb.isPresent()) {
			this.repo.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("record not found with id"+productId);
		}
		
		
	}

}
