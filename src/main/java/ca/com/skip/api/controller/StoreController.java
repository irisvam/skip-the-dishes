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

/**
 * Store Controller Service.
 * 
 * @author irisvam
 */
@RestController
public class StoreController {
	
	@Autowired
	StoreService serviceStore;
	
	@Autowired
	ProductService serviceProduct;
	
	/**
	 * Service to list all stores.
	 * 
	 * @return {@code List<}{@link Store}{@code >}
	 */
	@RequestMapping(value = "/v1/Store", method = RequestMethod.GET)
	public List<Store> getAllStores() {
		
		return serviceStore.getAllStores();
	}
	
	/**
	 * Service to list all stories with the name.
	 * 
	 * @param searchText {@link String} with the name of a store
	 * @return {@code List<}{@link Store}{@code >}
	 */
	@RequestMapping(value = "/v1/Store/search/{searchText}", method = RequestMethod.GET)
	public List<Store> getAllStores(@PathVariable final String searchText) {
		
		return serviceStore.findByName(searchText);
	}
	
	/**
	 * Service to find a store by ID.
	 * 
	 * @param storeId {@link Long} with the {@code ID} of a store
	 * @return {@link Store}
	 */
	@RequestMapping(value = "/v1/Store/{storeId}", method = RequestMethod.GET)
	public @ResponseBody Store getStore(@PathVariable final Long storeId) {
		
		return serviceStore.findById(storeId);
	}
	
	/**
	 * Service to list all products from one store.
	 * 
	 * @param storeId {@link Long} with the {@code ID} of a store
	 * @return {@code List<}{@link Product}{@code >}
	 */
	@RequestMapping(value = "/v1/Store/{storeId}/products", method = RequestMethod.GET)
	public List<Product> getAllProductsByStoreId(@PathVariable final Long storeId) {
		
		return serviceProduct.findByStoreId(storeId);
	}
	
}
