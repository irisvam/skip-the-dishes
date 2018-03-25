package ca.com.skip.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Customer;

/**
 * Repository of Customer.
 * 
 * @author irisvam
 *
 * @param <P> a {@link Customer}
 */
@Repository
public interface CustomerRepository<P> extends CrudRepository<Customer, Long> {
	
	/**
	 * Method to authenticate the customer.
	 * 
	 * @param email {@link String} with a e-mail
	 * @param password {@link String} with a password
	 * @return {@link Customer}
	 */
	Customer findByEmailAndPassword(String email, String password);
}
