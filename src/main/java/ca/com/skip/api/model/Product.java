package ca.com.skip.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ca.com.skip.util.serializer.ProductSerializer;

@Entity
@Table(name = "tb_product")
@JsonSerialize(using = ProductSerializer.class)
public class Product implements Serializable {
	
	private static final long serialVersionUID = 5604769293621572135L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_store")
	private Store store;
	
	@Column(name = "nm_name")
	private String name;
	
	@Column(name = "de_description")
	private String description;
	
	@Column(name = "db_price")
	private Double price;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(final Long id) {
		
		this.id = id;
	}
	
	public Store getStore() {
		
		return store;
	}
	
	public void setStore(final Store store) {
		
		this.store = store;
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
