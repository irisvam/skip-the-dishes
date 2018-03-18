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

@RestController
public class CousineController {
	
	@Autowired
	CousineService serviceCousine;
	
	@Autowired
	StoreService serviceStore;
	
	@RequestMapping(value = "/Cousine", method = RequestMethod.GET)
	public List<Cousine> getAllCousines() {
		
		return serviceCousine.getAllCousines();
	}
	
	@RequestMapping(value = "/Cousine/search/{searchText}", method = RequestMethod.GET)
	public List<Cousine> getAllCousines(@PathVariable final String searchText) {
		
		return serviceCousine.findByName(searchText);
	}
	
	@RequestMapping(value = "/Cousine/{cousineId}/stores", method = RequestMethod.GET)
	public List<Store> getAllStoresByCousineId(@PathVariable final Integer cousineId) {
		
		return serviceStore.findByCousineId(cousineId);
	}
	
}
