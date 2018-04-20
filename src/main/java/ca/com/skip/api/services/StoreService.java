package ca.com.skip.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.com.skip.api.model.Store;
import ca.com.skip.api.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	StoreRepository<Store> repStore;
	
	public List<Store> getAllStores() {
		
		return (List<Store>) repStore.findAll();
	}
	
	public List<Store> findByCousineId(final Long cousineId) {
		
		return repStore.findByCousine_Id(cousineId);
	}
	
	public List<Store> findByName(final String name) {
		
		return repStore.findByNameContainingIgnoreCase(name);
	}
	
	public Optional<Store> findById(final Long storeId) {
		
		return repStore.findById(storeId);
	}
	
}
