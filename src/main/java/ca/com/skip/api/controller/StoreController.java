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
import ca.com.skip.api.model.Store;
import ca.com.skip.api.services.ProductService;
import ca.com.skip.api.services.StoreService;

/**
 * Store Controller Service.
 * 
 * @author irisvam
 */
@RestController
@Validated
@RequestMapping("v1")
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
	@RequestMapping(value = "/Store", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStores() {
		
		return new ResponseEntity<>(serviceStore.getAllStores(), HttpStatus.OK);
	}
	
	/**
	 * Service to list all stories with the name.
	 * 
	 * @param searchText {@link String} with the name of a store
	 * @return {@code List<}{@link Store}{@code >}
	 */
	@RequestMapping(value = "/Store/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStores(@PathVariable final String searchText) {
		
		return new ResponseEntity<>(serviceStore.findByName(searchText), HttpStatus.OK);
	}
	
	/**
	 * Service to find a store by ID.
	 * 
	 * @param storeId {@link Long} with the {@code ID} of a store
	 * @return {@link Store}
	 */
	@RequestMapping(value = "/Store/{storeId}", method = RequestMethod.GET)
	public ResponseEntity<?> getStore(@PathVariable final Long storeId) {
		
		final Optional<Store> store = serviceStore.findById(storeId);
		
		if (!store.isPresent()) {
			
			throw new ResourceNotFoundException("Store not found for ID: " + storeId);
		}
		
		return new ResponseEntity<>(store.get(), HttpStatus.OK);
	}
	
	/**
	 * Service to list all products from one store.
	 * 
	 * @param storeId {@link Long} with the {@code ID} of a store
	 * @return {@code List<}{@link Product}{@code >}
	 */
	@RequestMapping(value = "/Store/{storeId}/products", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProductsByStoreId(@PathVariable final Long storeId) {
		
		return new ResponseEntity<>(serviceProduct.findByStoreId(storeId), HttpStatus.OK);
	}
	
}
