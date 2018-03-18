package ca.com.skip.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "customerId")
	private Integer customerId;
	
	@Column(name = "deliveryAddress")
	private String deliveryAddress;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "storeId")
	private Integer storeId;
	
	@OneToMany
	private List<OrderItem> orderItems;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "lastUpdate")
	private String lastUpdate;
	
	public Integer getId() {
		
		return id;
	}
	
	public void setId(final Integer id) {
		
		this.id = id;
	}
	
	public String getDate() {
		
		return date;
	}
	
	public void setDate(final String date) {
		
		this.date = date;
	}
	
	public Integer getCustomerId() {
		
		return customerId;
	}
	
	public void setCustomerId(final Integer customerId) {
		
		this.customerId = customerId;
	}
	
	public String getDeliveryAddress() {
		
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(final String deliveryAddress) {
		
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getContact() {
		
		return contact;
	}
	
	public void setContact(final String contact) {
		
		this.contact = contact;
	}
	
	public Integer getStoreId() {
		
		return storeId;
	}
	
	public void setStoreId(final Integer storeId) {
		
		this.storeId = storeId;
	}
	
	public List<OrderItem> getOrderItems() {
		
		return orderItems;
	}
	
	public void setOrderItems(final List<OrderItem> orderItems) {
		
		this.orderItems = orderItems;
	}
	
	public Double getTotal() {
		
		return total;
	}
	
	public void setTotal(final Double total) {
		
		this.total = total;
	}
	
	public String getStatus() {
		
		return status;
	}
	
	public void setStatus(final String status) {
		
		this.status = status;
	}
	
	public String getLastUpdate() {
		
		return lastUpdate;
	}
	
	public void setLastUpdate(final String lastUpdate) {
		
		this.lastUpdate = lastUpdate;
	}
	
}
