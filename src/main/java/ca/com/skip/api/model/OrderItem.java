package ca.com.skip.api.model;

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

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order_item")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_product")
	private Product product;
	
	@Column(name = "db_price")
	private Double price;
	
	@Column(name = "nu_quantity")
	private Integer quantity;
	
	@Column(name = "db_total")
	private Double total;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(final Long id) {
		
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
	
	public Double getPrice() {
		
		return price;
	}
	
	public void setPrice(final Double price) {
		
		this.price = price;
	}
	
	public Integer getQuantity() {
		
		return quantity;
	}
	
	public void setQuantity(final Integer quantity) {
		
		this.quantity = quantity;
	}
	
	public Double getTotal() {
		
		return total;
	}
	
	public void setTotal(final Double total) {
		
		this.total = total;
	}
	
}
