package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name = "Brands")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name" })
public class Brands implements ApiSuperClass ,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Brands() {
		
	}
	public Brands(String id, String name, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.name = name;
		this.additionalProperties = additionalProperties;
	}
	public Brands(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	
	@Override
	public String toString() {
		return "Brands [id=" + id + ", name=" + name + ", additionalProperties=" + additionalProperties + "]";
	}
	
	@Id
	@JsonProperty("id")
	private String id;
	
	
	@Column(name ="Name")
	@JsonProperty("name")
	private String name;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	@Override
	public List<String> l1(String nothing) {
		return l1;
	}

}