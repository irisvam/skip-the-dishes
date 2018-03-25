package ca.com.skip.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ca.com.skip.util.serializer.OrderDeserializer;
import ca.com.skip.util.serializer.OrderSerializer;

@Entity
@Table(name = "tb_order")
@JsonSerialize(using = OrderSerializer.class)
@JsonDeserialize(using = OrderDeserializer.class)
public class Order implements Serializable {
	
	private static final long serialVersionUID = 560622188806131768L;
	
	@Id
	@Column(name = "id_order")
	private long id;
	
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
	
	@Transient
	private long idCustomer;
	
	@Transient
	private long idStore;
	
	public long getId() {
		
		return id;
	}
	
	public void setId(final long id) {
		
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
	
	public long getIdCustomer() {
		
		return idCustomer;
	}
	
	public void setIdCustomer(final long idCustomer) {
		
		this.idCustomer = idCustomer;
	}
	
	public long getIdStore() {
		
		return idStore;
	}
	
	public void setIdStore(final long idStore) {
		
		this.idStore = idStore;
	}
	
}
