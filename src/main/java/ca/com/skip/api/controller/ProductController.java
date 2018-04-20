package ca.com.skip.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.exception.ResourceNotFoundException;
import ca.com.skip.api.model.Product;
import ca.com.skip.api.services.ProductService;

/**
 * Product Controller Service.
 * 
 * @author irisvam
 */
@RestController
@Validated
@RequestMapping("v1")
public class ProductController {
	
	@Autowired
	ProductService serviceProduct;
	
	/**
	 * Service to list all products.
	 * 
	 * @return {@code List<}{@link Product}{@code >}
	 */
	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProducts() {
		
		return new ResponseEntity<>(serviceProduct.getAllProducts(), HttpStatus.OK);
	}
	
	/**
	 * Service to list all products with the name.
	 * 
	 * @param searchText {@link String} with the name of a product
	 * @return {@code List<}{@link Product}{@code >}
	 */
	@RequestMapping(value = "/Product/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProducts(@PathVariable final String searchText) {
		
		return new ResponseEntity<>(serviceProduct.findByName(searchText), HttpStatus.OK);
	}
	
	/**
	 * Service to find a product by it's ID.
	 * 
	 * @param productId {@link Long} with the {@code ID} of a product
	 * @return {@link Product}
	 */
	@RequestMapping(value = "/Product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<?> getProductById(@PathVariable final Long productId) {
		
		Optional<Product> product = serviceProduct.findById(productId);
		
		if (!product.isPresent()) {
			
			throw new ResourceNotFoundException("Product not found for ID: " + productId);
		}
		
		return new ResponseEntity<>(product.get(), HttpStatus.OK);
	}
}
