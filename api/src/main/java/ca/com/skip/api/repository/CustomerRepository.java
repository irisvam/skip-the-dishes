package ca.com.skip.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Customer;

@Repository
public interface CustomerRepository<P> extends CrudRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c WHERE c.email = ? and c.password = ?")
	Customer findByEmailPassword(String email, String password);
}
