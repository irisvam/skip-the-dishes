package ca.com.skip.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cousine")
public class Cousine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cusine")
	private Long id;
	
	@Column(name = "nm_name")
	private String name;
	
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
	
}
