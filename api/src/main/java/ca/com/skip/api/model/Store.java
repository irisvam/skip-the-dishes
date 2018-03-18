package ca.com.skip.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "cousineId")
	private Integer cousineId;
	
	public Integer getId() {
		
		return id;
	}
	
	public void setId(final Integer id) {
		
		this.id = id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(final String name) {
		
		this.name = name;
	}
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(final String address) {
		
		this.address = address;
	}
	
	public Integer getCousineId() {
		
		return cousineId;
	}
	
	public void setCousineId(final Integer cousineId) {
		
		this.cousineId = cousineId;
	}
	
}
