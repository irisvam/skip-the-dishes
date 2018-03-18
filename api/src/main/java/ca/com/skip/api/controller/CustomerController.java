package ca.com.skip.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.model.Customer;
import ca.com.skip.api.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService serviceCustomer;
	
	@RequestMapping(value = "/v1/Customer", method = RequestMethod.POST)
	public HttpStatus insertCustomer(@RequestBody final Customer customer) {
		
		return serviceCustomer.addCustomer(customer) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/v1/Customer/auth", method = RequestMethod.POST)
	public Customer insertCustomer(@RequestParam("email") final String email, @RequestParam("password") final String password) {
		
		return serviceCustomer.findByEmailPassword(email, password);
	}
	
}
