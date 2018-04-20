package ca.com.skip.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.model.Cousine;
import ca.com.skip.api.model.Store;
import ca.com.skip.api.services.CousineService;
import ca.com.skip.api.services.StoreService;

/**
 * Cousine Controller Service.
 * 
 * @author irisvam
 */
@RestController
@Validated
@RequestMapping("v1")
public class CousineController {
	
	@Autowired
	CousineService serviceCousine;
	
	@Autowired
	StoreService serviceStore;
	
	/**
	 * Service to list all cousines.
	 * 
	 * @return {@code List<}{@link Cousine}{@code >}
	 */
	@RequestMapping(value = "/Cousine", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCousines() {
		
		return new ResponseEntity<>(serviceCousine.getAllCousines(), HttpStatus.OK);
	}
	
	/**
	 * Service to list cousines with the name.
	 * 
	 * @param searchText {@link String} with a name of a cousine
	 * @return {@code List<}{@link Cousine}{@code >}
	 */
	@RequestMapping(value = "/Cousine/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCousines(@PathVariable final String searchText) {
		
		return new ResponseEntity<>(serviceCousine.findByName(searchText), HttpStatus.OK);
	}
	
	/**
	 * Service to list stories which have that cousine.
	 * 
	 * @param cousineId {@link Integer} with the {@code ID} of a cousine
	 * @return {@code List<}{@link Store}{@code >}
	 */
	@RequestMapping(value = "/Cousine/{cousineId}/stores", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStoresByCousineId(@PathVariable final Long cousineId) {
		
		return new ResponseEntity<>(serviceStore.findByCousineId(cousineId), HttpStatus.OK);
	}
	
}
