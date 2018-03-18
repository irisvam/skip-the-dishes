package ca.com.skip.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.skip.api.model.Cousine;

@Repository
public interface CousineRepository<P> extends CrudRepository<Cousine, Integer> {
	
	List<Cousine> findByName(String name);
}
