package com.productionDataClientProductionData.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Translations")
public class Translations implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Translations() {
		
	}
	public Translations(String id) {
		super();
		this.id = id;
	}

	@Id
	@JsonProperty("id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Translations [id=" + id + "]";
	}
	
	

}
