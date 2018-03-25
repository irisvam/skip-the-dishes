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

@Entity
@Table(name = "tb_store")
public class Store implements Serializable {
	
	private static final long serialVersionUID = -4652744071092704699L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_store")
	private Long id;
	
	@Column(name = "nm_name")
	private String name;
	
	@Column(name = "de_address")
	private String address;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "cousine_id")
	private Cousine cousine;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(final Long id) {
		
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
	
	public Cousine getCousine() {
		
		return cousine;
	}
	
	public void setCousine(final Cousine cousine) {
		
		this.cousine = cousine;
	}
	
}
