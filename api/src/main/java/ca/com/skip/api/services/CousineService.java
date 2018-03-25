package ca.com.skip.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.com.skip.api.model.Cousine;
import ca.com.skip.api.repository.CousineRepository;

@Service
public class CousineService {
	
	@Autowired
	CousineRepository<Cousine> repCousine;
	
	@Transactional
	public List<Cousine> getAllCousines() {
		
		return (List<Cousine>) repCousine.findAll();
	}
	
	@Transactional
	public List<Cousine> findByName(final String name) {
		
		return repCousine.findByName(name);
	}
}
