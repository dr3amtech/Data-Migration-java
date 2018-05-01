package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name="Owners")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "year","address1","city","postalCode"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owners implements  ApiSuperClass,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Owners() {
		
	}
	public Owners(String id, String name, String address1, String city, String postalCode,
			Dealers dealers) {
		super();
		this.id = id;
		this.name = name;
		this.address1 = address1;
		this.city = city;
		this.postalCode = postalCode;
		Dealers = dealers;
	}

	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="Name")
	@JsonProperty("name")
	private String name;
	@Column(name="address1")
	@JsonProperty("address1")
	private String address1;
	@Column(name="City")
	@JsonProperty("city")
	private String city;
	@Column(name="PostalCode")
	@JsonProperty("postalCode")
	private String postalCode;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Dealers Dealers;
	
	@Transient
	public final List<String> l1 = new LinkedList<String>();
	@Transient
	private boolean isItTrue = true;
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@Override
	public List<String> l1(String nothing){
		l1.add("address_country=countries");
		l1.add("state_provinces=state_provinces");
		l1.add("visibleToDealers=dealers");
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
	@JsonProperty("address1")
	public String getAddress1() {
		return address1;
	}
	@JsonProperty("address1")
	public void setAddress1(String address1) {
		this.address1 = address1;
		if(isItTrue) {
		isItTrue= false;
		}
	}
	@JsonProperty("city")
	public String getCity() {
		return city;
	}
	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
		if(isItTrue) {
			isItTrue= false;
			}
	}
	@JsonProperty("postalCode")
	public String getPostalCode() {
		return postalCode;
	}
	@JsonProperty("postalCode")
	public void setPostalCode(String postalCode) {
		
		try {	
		this.postalCode = postalCode;
		postalCode.equals(null);
		if(isItTrue) {
			isItTrue= false;
			}
		}catch(NullPointerException n) {
			isItTrue=true;
		}
		
		
		}
	public boolean dontAddData(){
		return isItTrue;
	}
	public Dealers getDealers() {
		return Dealers;
	}
	public void setDealers(Dealers dealers) {
		Dealers = dealers;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
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
	public String toString() {
		return "Owners [id=" + id + ", name=" + name + ", address1=" + address1 + ", city=" + city + ", postalCode="
				+ postalCode + ", l1=" + l1 + ", additionalProperties=" + additionalProperties + "]";
	}


	

}