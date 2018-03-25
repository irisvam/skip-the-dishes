package ca.com.skip.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.com.skip.api.model.Product;
import ca.com.skip.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository<Product> repProduct;
	
	@Transactional
	public List<Product> getAllProducts() {
		
		return (List<Product>) repProduct.findAll();
	}
	
	@Transactional
	public List<Product> findByName(final String name) {
		
		return repProduct.findByName(name);
	}
	
	@Transactional
	public List<Product> findByStoreId(final Integer storeId) {
		
		return repProduct.findByStoreId(storeId);
	}
	
	@Transactional
	public Product findById(final Integer productId) {
		
		return repProduct.findOne(productId);
	}
}
