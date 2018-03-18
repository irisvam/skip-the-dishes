package ca.com.skip.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.model.Product;
import ca.com.skip.api.model.Store;
import ca.com.skip.api.services.ProductService;
import ca.com.skip.api.services.StoreService;

@RestController
public class StoreController {
	
	@Autowired
	StoreService serviceStore;
	
	@Autowired
	ProductService serviceProduct;
	
	@RequestMapping(value = "/Store", method = RequestMethod.GET)
	public List<Store> getAllStores() {
		
		return serviceStore.getAllStores();
	}
	
	@RequestMapping(value = "/Store/search/{searchText}", method = RequestMethod.GET)
	public List<Store> getAllStores(@PathVariable final String searchText) {
		
		return serviceStore.findByName(searchText);
	}
	
	@RequestMapping(value = "/Store/{storeId}", method = RequestMethod.GET)
	public @ResponseBody Store getStore(@PathVariable final Integer storeId) {
		
		return serviceStore.findById(storeId);
	}
	
	@RequestMapping(value = "/Store/{storeId}/products", method = RequestMethod.GET)
	public List<Product> getAllProductsByStoreId(@PathVariable final Integer storeId) {
		
		return serviceProduct.findByStoreId(storeId);
	}
	
}
