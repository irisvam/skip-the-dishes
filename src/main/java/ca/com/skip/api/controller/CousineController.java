package ca.com.skip.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value = "/v1/Cousine", method = RequestMethod.GET)
	public List<Cousine> getAllCousines() {
		
		return serviceCousine.getAllCousines();
	}
	
	/**
	 * Service to list cousines with the name.
	 * 
	 * @param searchText {@link String} with a name of a cousine
	 * @return {@code List<}{@link Cousine}{@code >}
	 */
	@RequestMapping(value = "/v1/Cousine/search/{searchText}", method = RequestMethod.GET)
	public List<Cousine> getAllCousines(@PathVariable final String searchText) {
		
		return serviceCousine.findByName(searchText);
	}
	
	/**
	 * Service to list stories which have that cousine. 
	 * 
	 * @param cousineId {@link Integer} with the {@code ID} of a cousine
	 * @return {@code List<}{@link Store}{@code >}
	 */
	@RequestMapping(value = "/v1/Cousine/{cousineId}/stores", method = RequestMethod.GET)
	public List<Store> getAllStoresByCousineId(@PathVariable final Long cousineId) {
		
		return serviceStore.findByCousineId(cousineId);
	}
	
}
