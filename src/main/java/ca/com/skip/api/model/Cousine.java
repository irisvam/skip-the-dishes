package ca.com.skip.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cousine")
public class Cousine implements Serializable {
	
	private static final long serialVersionUID = -2936656149726286756L;
	
	@Id
	@Column(name = "id_cusine")
	private long id;
	
	@Column(name = "nm_name")
	private String name;
	
	public long getId() {
		
		return id;
	}
	
	public void setId(final long id) {
		
		this.id = id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(final String name) {
		
		this.name = name;
	}
	
}
