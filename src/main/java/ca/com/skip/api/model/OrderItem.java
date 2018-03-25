package ca.com.skip.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ca.com.skip.util.serializer.OrderItemDeserializer;
import ca.com.skip.util.serializer.OrderItemSerializer;

@Entity
@Table(name = "tb_order_item")
@JsonSerialize(using = OrderItemSerializer.class)
@JsonDeserialize(using = OrderItemDeserializer.class)
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 6172163067353442148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order_item")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_product")
	private Product product;
	
	@Column(name = "db_price")
	private double price;
	
	@Column(name = "nu_quantity")
	private long quantity;
	
	@Column(name = "db_total")
	private double total;
	
	@Transient
	private long idOrder;
	
	@Transient
	private long idProduct;
	
	public long getId() {
		
		return id;
	}
	
	public void setId(final long id) {
		
		this.id = id;
	}
	
	public Order getOrder() {
		
		return order;
	}
	
	public void setOrder(final Order order) {
		
		this.order = order;
	}
	
	public Product getProduct() {
		
		return product;
	}
	
	public void setProduct(final Product product) {
		
		this.product = product;
	}
	
	public double getPrice() {
		
		return price;
	}
	
	public void setPrice(final double price) {
		
		this.price = price;
	}
	
	public long getQuantity() {
		
		return quantity;
	}
	
	public void setQuantity(final long quantity) {
		
		this.quantity = quantity;
	}
	
	public double getTotal() {
		
		return total;
	}
	
	public void setTotal(final double total) {
		
		this.total = total;
	}
	
	public long getIdOrder() {
		
		return idOrder;
	}
	
	public void setIdOrder(final long idOrder) {
		
		this.idOrder = idOrder;
	}
	
	public long getIdProduct() {
		
		return idProduct;
	}
	
	public void setIdProduct(final long idProduct) {
		
		this.idProduct = idProduct;
	}
	
}
