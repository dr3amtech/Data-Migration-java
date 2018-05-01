package com.productionDataClientProductionData.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name ="Countries")
public class Countries implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Countries() {
		
	}
	



	public Countries(String id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}




	@Id
	@JsonProperty("id")
	private String id;
	
	@Column(name="Code")
	private  String code;
	
	@Column(name="Description")
	private  String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Regions region;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Regions getRegions() {
		return region;
	}




	public void setRegions(Regions region) {
		this.region = region;
	}




	@Override
	public String toString() {
		return "Countries [id=" + id + ", code=" + code + ", description=" + description + "]";
	}



}
