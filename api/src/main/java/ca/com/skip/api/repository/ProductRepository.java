package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Product;

/**
 * Repository of products.
 * 
 * @author irisvam
 *
 * @param <P> a {@link Product}
 */
@Repository
public interface ProductRepository<P> extends CrudRepository<Product, Integer> {

	/**
	 * Method to list produtcs by its name.
	 * 
	 * @param name {@link String} with a name of a product
	 * @return {@code List<}{@link Product}{@code >}
	 */
	List<Product> findByName(String name);

	/**
	 * Method to list products from a store.
	 * 
	 * @param storeId {@link Integer} with the {@code ID} of a store
	 * @return {@code List<}{@link Product}{@code >}
	 */
	List<Product> findByStoreId(Integer storeId);
}
