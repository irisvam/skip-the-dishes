package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Product;

@Repository
public interface ProductRepository<P> extends CrudRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByStoreId(Integer storeId);
}
