package ca.com.skip.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.com.skip.api.model.Order;
import ca.com.skip.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository<Order> repOrder;
	
	@Transactional
	public Optional<Order> findById(final Long orderId) {
		
		return repOrder.findById(orderId);
	}
	
	@Transactional
	public boolean addOrder(final Order order) {
		
		return repOrder.save(order) != null;
	}
	
	@Transactional
	public List<Order> findByCustomerId(final Long customerId) {
		
		return repOrder.findByCustomer_Id(customerId);
	}
	
}
