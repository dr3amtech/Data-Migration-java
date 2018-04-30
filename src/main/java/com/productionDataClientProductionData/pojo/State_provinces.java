package com.productionDataClientProductionData.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Address_state_province")
public class State_provinces implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public State_provinces() {
		
	}
	
	public State_provinces(String id) {
		super();
		this.id = id;
	}
	@Id
	@Column(name= "Id")
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
		return "State_provinces [id=" + id + "]";
	}
	
	
	
}
