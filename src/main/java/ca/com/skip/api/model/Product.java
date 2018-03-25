package ca.com.skip.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ca.com.skip.util.serializer.ProductDeserializer;
import ca.com.skip.util.serializer.ProductSerializer;

@Entity
@Table(name = "tb_product")
@JsonSerialize(using = ProductSerializer.class)
@JsonDeserialize(using = ProductDeserializer.class)
public class Product implements Serializable {
	
	private static final long serialVersionUID = 5604769293621572135L;
	
	@Id
	@Column(name = "id_product")
	private long id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_store")
	private Store store;
	
	@Column(name = "nm_name")
	private String name;
	
	@Column(name = "de_description")
	private String description;
	
	@Column(name = "db_price")
	private double price;
	
	@Transient
	private long idStore;
	
	public long getId() {
		
		return id;
	}
	
	public void setId(final long id) {
		
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
	
	public double getPrice() {
		
		return price;
	}
	
	public void setPrice(final double price) {
		
		this.price = price;
	}
	
	public long getIdStore() {
		
		return idStore;
	}
	
	public void setIdStore(final long idStore) {
		
		this.idStore = idStore;
	}
	
}
