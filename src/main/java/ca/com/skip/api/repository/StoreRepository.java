package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Store;

/**
 * Repository of stories.
 * 
 * @author irisvam
 *
 * @param <P> a {@link Store}
 */
@Repository
public interface StoreRepository<P> extends CrudRepository<Store, Long> {
	
	/**
	 * Method to list stories by its cousines.
	 * 
	 * @param cousineId {@link Long} with the {@code ID} of a cousine
	 * @return {@code List<}{@link Store}{@code >}
	 */
	List<Store> findByCousine_Id(Long cousineId);
	
	/**
	 * Method to list all stories with the name.
	 * 
	 * @param name {@link String} with the name os a store
	 * @return {@code List<}{@link Store}{@code >}
	 */
	List<Store> findByNameContainingIgnoreCase(String name);
	
	/**
	 * Metho to list stories with the product.
	 * 
	 * @param productId {@link Long} with the {@code ID} of a product
	 * @return {@code List<}{@link Store}{@code >}
	 */
	@Query("SELECT s FROM Store s JOIN Product p ON p.store.id = s.id WHERE p.id = :productId")
	List<Store> findByProduct_Id(Long productId);
}
