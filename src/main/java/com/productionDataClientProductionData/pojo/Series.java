package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;
@Entity
@Table(name="Series")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Series() {
		
	}
	
	public Series(String id, String name, Brands brand,Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.name = name;
		this.brands = brand;
		this.additionalProperties = additionalProperties;
	}
	public Series(String id, String name, Brands brand) {
		super();
		this.id = id;
		this.name = name;
		this.brands = brand;
	}

	@Override
	public String toString() {
		return "Series [id=" + id + ", name=" + name + ", brand=" + brands + ", additionalProperties=" + additionalProperties + "]";
	}
	
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="Name")
	@JsonProperty("name")
	private String name;
	@ManyToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Brands brands;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<String> l1(String nothing){
		l1.add("brands");
		return l1;
	}
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	
public Brands getBrands() {
		return getBrands();
	}

	public void setBrands(Brands brand) {
		this.brands = brand;
	}

@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


	

}