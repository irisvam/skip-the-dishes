package ca.com.skip.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.com.skip.api.model.Store;
import ca.com.skip.api.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	StoreRepository<Store> repStore;
	
	@Transactional
	public List<Store> getAllStores() {
		
		return (List<Store>) repStore.findAll();
	}
	
	@Transactional
	public List<Store> findByCousineId(final Integer cousineId) {
		
		return repStore.findByCousineId(cousineId);
	}
	
	@Transactional
	public List<Store> findByName(final String name) {
		
		return repStore.findByName(name);
	}
	
	@Transactional
	public Store findById(final Integer storeId) {
		
		return repStore.findOne(storeId);
	}
	
}