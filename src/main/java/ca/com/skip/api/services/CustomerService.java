package ca.com.skip.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.com.skip.api.model.Customer;
import ca.com.skip.api.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository<Customer> repCustomer;
	
	public Customer findByEmailPassword(final String email, final String password) {
		
		return repCustomer.findByEmailAndPassword(email, password);
	}
	
	@Transactional
	public boolean addCustomer(final Customer customer) {
		
		return repCustomer.save(customer) != null;
	}
}
