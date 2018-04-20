package ca.com.skip.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.com.skip.api.model.Product;
import ca.com.skip.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository<Product> repProduct;
	
	public List<Product> getAllProducts() {
		
		return (List<Product>) repProduct.findAll();
	}
	
	public List<Product> findByName(final String name) {
		
		return repProduct.findByNameContainingIgnoreCase(name);
	}
	
	public List<Product> findByStoreId(final Long storeId) {
		
		return repProduct.findByStore_Id(storeId);
	}
	
	public Optional<Product> findById(final Long productId) {
		
		return repProduct.findById(productId);
	}
}
