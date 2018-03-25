package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Order;

/**
 * Repository of Orders.
 * 
 * @author irisvam
 *
 * @param <P> a {@link Order}
 */
@Repository
public interface OrderRepository<P> extends CrudRepository<Order, Long> {

	/**
	 * Method to list orders by it's customer.
	 * 
	 * @param customerId {@link Long} with the {@code ID} of a customer
	 * @return {@code List<}{@link Order}{@code >}
	 */
	List<Order> findByCustomer_Id(Long customerId);
}
