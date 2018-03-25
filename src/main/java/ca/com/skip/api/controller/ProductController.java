package ca.com.skip.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.model.Product;
import ca.com.skip.api.services.ProductService;

/**
 * Product Controller Service.
 * 
 * @author irisvam
 */
@RestController
public class ProductController {
	
	@Autowired
	ProductService serviceProduct;
	
	/**
	 * Service to list all products.
	 * 
	 * @return  {@code List<}{@link Product}{@code >}
	 */
	@RequestMapping(value = "/v1/Product", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		
		return serviceProduct.getAllProducts();
	}
	
	/**
	 * Service to list all products with the name.
	 * 
	 * @param searchText {@link String} with the name of a product
	 * @return {@code List<}{@link Product}{@code >}
	 */
	@RequestMapping(value = "/v1/Product/search/{searchText}", method = RequestMethod.GET)
	public List<Product> getAllProducts(@PathVariable final String searchText) {
		
		return serviceProduct.findByName(searchText);
	}
	
	/**
	 * Service to find a product by it's ID.
	 * 
	 * @param productId {@link Long} with the {@code ID} of a product
	 * @return {@link Product}
	 */
	@RequestMapping(value = "/v1/Product/{productId}", method = RequestMethod.GET)
	public @ResponseBody Product getProductById(@PathVariable final Long productId) {
		
		return serviceProduct.findById(productId);
	}
}
