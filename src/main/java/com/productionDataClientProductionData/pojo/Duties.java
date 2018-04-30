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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;
@Entity 
@Table(name="Duties")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id","status", "externalId" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Duties implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Duties() {
		
	}


	public Duties(String id, String status, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.status = status;
		this.additionalProperties = additionalProperties;
	}


	@Id
	@Column(name= "DExternalId")
	@JsonProperty("id")
	private String id;
	@Column(name="Status")
	@JsonProperty("status")
	private String status;
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@JsonProperty("id")
	public String get_id() {
		return id;
	}

	@JsonProperty("id")
	public void set_id(String id) {
		this.id = id;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
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


	@Override
	public String toString() {
		return "Duties [id=" + id + ", status=" + status + "]";
	}


	

}