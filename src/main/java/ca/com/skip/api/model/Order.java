package ca.com.skip.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Long id;
	
	@Column(name = "dt_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Column(name = "de_delivery_address")
	private String deliveryAddress;
	
	@Column(name = "de_contact")
	private String contact;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_store")
	private Store store;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems;
	
	@Column(name = "db_total")
	private Double total;
	
	@Column(name = "de_status")
	private String status;
	
	@Column(name = "dt_lastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(final Long id) {
		
		this.id = id;
	}
	
	public Date getDate() {
		
		return date;
	}
	
	public void setDate(final Date date) {
		
		this.date = date;
	}
	
	public Customer getCustomer() {
		
		return customer;
	}
	
	public void setCustomer(final Customer customer) {
		
		this.customer = customer;
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
	
	public Store getStore() {
		
		return store;
	}
	
	public void setStore(final Store store) {
		
		this.store = store;
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
	
	public Date getLastUpdate() {
		
		return lastUpdate;
	}
	
	public void setLastUpdate(final Date lastUpdate) {
		
		this.lastUpdate = lastUpdate;
	}
	
}
