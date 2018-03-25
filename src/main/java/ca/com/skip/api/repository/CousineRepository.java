package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Cousine;

/**
 * Repository to Cousines.
 * 
 * @author irisvam
 *
 * @param <P> a {@link Cousine}
 */
@Repository
public interface CousineRepository<P> extends CrudRepository<Cousine, Long> {
	
	/**
	 * Method to list the cousises by name.
	 * 
	 * @param name {@link String} with the name of a cousine
	 * @return {@code List<}{@link Cousine}{@code >}
	 */
	List<Cousine> findByNameContainingIgnoreCase(String name);
}
