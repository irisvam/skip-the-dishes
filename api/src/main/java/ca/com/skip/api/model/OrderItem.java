package ca.com.skip.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "orderId")
	private Integer orderId;
	
	@Column(name = "productId")
	private Integer productId;
	
	@JoinColumn(name = "product")
	private Product product;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "total")
	private Double total;
	
	public Integer getId() {
		
		return id;
	}
	
	public void setId(final Integer id) {
		
		this.id = id;
	}
	
	public Integer getOrderId() {
		
		return orderId;
	}
	
	public void setOrderId(final Integer orderId) {
		
		this.orderId = orderId;
	}
	
	public Integer getProductId() {
		
		return productId;
	}
	
	public void setProductId(final Integer productId) {
		
		this.productId = productId;
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
