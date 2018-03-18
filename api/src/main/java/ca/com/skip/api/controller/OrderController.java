package ca.com.skip.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.model.Customer;
import ca.com.skip.api.model.Order;
import ca.com.skip.api.services.CustomerService;
import ca.com.skip.api.services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService serviceOrder;
	
	@Autowired
	CustomerService serviceCustomer;
	
	@RequestMapping(value = "/v1/Order/{orderId}", method = RequestMethod.GET)
	public @ResponseBody Order getOrder(@PathVariable final Integer orderId) {
		
		return serviceOrder.findById(orderId);
	}
	
	@RequestMapping(value = "/v1/Order", method = RequestMethod.POST)
	public HttpStatus insertOrder(@RequestBody final Order order) {
		
		return serviceOrder.addOrder(order) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/v1/Order/customer", method = RequestMethod.GET)
	public List<Order> getAllOrderByCustomer(@RequestParam("customer") final Customer customer) {
		
		return serviceOrder.findByCustomerId(customer.getId());
	}
}
