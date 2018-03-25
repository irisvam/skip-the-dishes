package ca.com.skip.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 3758543663770749280L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private Long id;
	
	@Column(name = "de_email")
	private String email;
	
	@Column(name = "nm_name")
	private String name;
	
	@Column(name = "de_address")
	private String address;
	
	@Column(name = "dt_creation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
	
	@Column(name = "de_password")
	private String password;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(final Long id) {
		
		this.id = id;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(final String email) {
		
		this.email = email;
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
	
	public Date getCreation() {
		
		return creation;
	}
	
	public void setCreation(final Date creation) {
		
		this.creation = creation;
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
}
