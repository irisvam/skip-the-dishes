package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Order;

@Repository
public interface OrderRepository<P> extends CrudRepository<Order, Integer> {

	List<Order> findByCustomerId(Integer customerId);
}
