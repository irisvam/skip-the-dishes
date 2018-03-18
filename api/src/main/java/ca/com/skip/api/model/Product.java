package ca.com.skip.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "storeId")
	private Integer storeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;
	
	public Integer getId() {
		
		return id;
	}
	
	public void setId(final Integer id) {
		
		this.id = id;
	}
	
	public Integer getStoreId() {
		
		return storeId;
	}
	
	public void setStoreId(final Integer storeId) {
		
		this.storeId = storeId;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(final String name) {
		
		this.name = name;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(final String description) {
		
		this.description = description;
	}
	
	public Double getPrice() {
		
		return price;
	}
	
	public void setPrice(final Double price) {
		
		this.price = price;
	}
	
}
