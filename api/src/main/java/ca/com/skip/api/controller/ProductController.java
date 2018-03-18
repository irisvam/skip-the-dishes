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

@RestController
public class ProductController {
	
	@Autowired
	ProductService serviceProduct;
	
	@RequestMapping(value = "/v1/Product", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		
		return serviceProduct.getAllProducts();
	}
	
	@RequestMapping(value = "/v1/Product/search/{searchText}", method = RequestMethod.GET)
	public List<Product> getAllProducts(@PathVariable final String searchText) {
		
		return serviceProduct.findByName(searchText);
	}
	
	@RequestMapping(value = "/v1/Product/{productId}", method = RequestMethod.GET)
	public @ResponseBody Product getProductById(@PathVariable final Integer productId) {
		
		return serviceProduct.findById(productId);
	}
}
