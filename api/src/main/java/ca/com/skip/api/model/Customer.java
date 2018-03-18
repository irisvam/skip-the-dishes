package ca.com.skip.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "creation")
	private String creation;
	
	@Column(name = "password")
	private String password;
	
	public Integer getId() {
		
		return id;
	}
	
	public void setId(final Integer id) {
		
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
	
	public String getCreation() {
		
		return creation;
	}
	
	public void setCreation(final String creation) {
		
		this.creation = creation;
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(final String password) {
		
		this.password = password;
	}
	
}
