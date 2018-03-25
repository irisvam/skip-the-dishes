package ca.com.skip.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ca.com.skip.util.serializer.CousineSerializer;

@Entity
@Table(name = "tb_cousine")
@JsonSerialize(using = CousineSerializer.class)
public class Cousine implements Serializable {
	
	private static final long serialVersionUID = -2936656149726286756L;
	
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
