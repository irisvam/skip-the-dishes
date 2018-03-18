package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Store;

@Repository
public interface StoreRepository<P> extends CrudRepository<Store, Integer> {
	
	List<Store> findByCousineId(Integer cousineId);
	
	List<Store> findByName(String name);
	
	@Query("SELECT s FROM Store s JOIN Product p ON p.storeId = s.id WHERE p.id = ?")
	List<Store> findByProductId(Integer productId);
}
