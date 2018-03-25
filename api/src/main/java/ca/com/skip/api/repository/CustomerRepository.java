package ca.com.skip.api.repository;

import org.springframework.data.jpa.repository.Query;
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
public interface CustomerRepository<P> extends CrudRepository<Customer, Integer> {
	
	/**
	 * Method to authenticate the customer.
	 * 
	 * @param email {@link String} with a e-mail
	 * @param password {@link String} with a password
	 * @return {@link Customer}
	 */
	@Query("SELECT c FROM Customer c WHERE c.email = ? and c.password = ?")
	Customer findByEmailPassword(String email, String password);
}
