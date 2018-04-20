package ca.com.skip.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.model.Customer;
import ca.com.skip.api.services.CustomerService;

/**
 * Customer Controller Service.
 * 
 * @author irisvam
 */
@RestController
@Validated
@RequestMapping("v1")
public class CustomerController {
	
	@Autowired
	CustomerService serviceCustomer;
	
	/**
	 * Service to insert a new custumer.
	 * 
	 * @param customer {@link Customer}
	 * @return {@link HttpStatus} with the status of the request
	 */
	@RequestMapping(value = "/Customer", method = RequestMethod.POST)
	public ResponseEntity<?> insertCustomer(@RequestBody final Customer customer) {
		
		return new ResponseEntity<>(serviceCustomer.addCustomer(customer), HttpStatus.CREATED);
	}
	
	/**
	 * Service to authenticate a customer.
	 * 
	 * @param email {@link String} with the e-mail of the customer
	 * @param password {@link String} with the password of the customer
	 * @return {@link Customer}
	 */
	@RequestMapping(value = "/Customer/auth", method = RequestMethod.POST)
	public ResponseEntity<?> insertCustomer(@RequestParam("email") final String email, @RequestParam("password") final String password) {
		
		return  new ResponseEntity<>(serviceCustomer.findByEmailPassword(email, password), HttpStatus.OK);
	}
	
}
