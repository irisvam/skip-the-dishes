package ca.com.skip.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.com.skip.api.exception.ResourceNotFoundException;
import ca.com.skip.api.model.Customer;
import ca.com.skip.api.model.Order;
import ca.com.skip.api.services.CustomerService;
import ca.com.skip.api.services.OrderService;

/**
 * Order Controller Service.
 * 
 * @author irisvam
 */
@RestController
@Validated
@RequestMapping("v1")
public class OrderController {
	
	@Autowired
	OrderService serviceOrder;
	
	@Autowired
	CustomerService serviceCustomer;
	
	/**
	 * Service to find a order.
	 * 
	 * @param orderId {@link Long} with the {@code ID} of a order
	 * @return {@link Order}
	 */
	@RequestMapping(value = "/Order/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable final Long orderId) {
		
		Optional<Order> order = serviceOrder.findById(orderId);
		
		if (!order.isPresent()) {
			
			throw new ResourceNotFoundException("Order not found for ID: " + orderId);
		}
		
		return new ResponseEntity<>(order.get(), HttpStatus.OK);
	}
	
	/**
	 * Service to insert a new order.
	 * 
	 * @param order {@link Order}
	 * @return {@link HttpStatus} with the status of the request
	 */
	@RequestMapping(value = "/Order", method = RequestMethod.POST)
	public ResponseEntity<?> insertOrder(@RequestBody final Order order) {
		
		return new ResponseEntity<>(serviceOrder.addOrder(order), HttpStatus.CREATED);
	}
	
	/**
	 * Service to list orders by customer.
	 * 
	 * @param customer {@link Customer}
	 * @return {@code List<}{@link Order}{@code >}
	 */
	@RequestMapping(value = "/Order/customer", method = RequestMethod.GET)
	public ResponseEntity<?> getAllOrderByCustomer(@RequestBody final Customer customer) {
		
		return new ResponseEntity<>(serviceOrder.findByCustomerId(customer.getId()), HttpStatus.OK);
	}
}
