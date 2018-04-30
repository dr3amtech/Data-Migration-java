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
@Table(name="StandardUnits")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "domain", "domainCode", "identificationNumber", "allowDataSharing", "hasSeenBefore",
		"links", "properties","ManufacturingDate" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardUnits implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StandardUnits() {
		
	}
	public StandardUnits(String id, String domain, String domainCode, String standardUnits,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.domain = domain;
		this.domainCode = domainCode;
		this.standardUnits = standardUnits;
		this.additionalProperties = additionalProperties;
	}

	
	@Override
	public String toString() {
		return "StandardUnits [id=" + id + ", domain=" + domain + ", domainCode=" + domainCode + ", standardUnits="
				+ standardUnits + ", additionalProperties=" + additionalProperties + "]";
	}






	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="Domain")
	@JsonProperty("domain")
	private String domain;
	@Column(name ="DomainCode")
	@JsonProperty("domainCode")
	private String domainCode;
	@Column(name="Units")
	@JsonProperty("standardUnitss")
	private String standardUnits;
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


	@JsonProperty("domain")
	public String getDomain() {
		return domain;
	}




	@JsonProperty("domain")
	public void setDomain(String domain) {
		this.domain = domain;
	}




	@JsonProperty("domainCode")
	public String getDomainCode() {
		return domainCode;
	}




	@JsonProperty("domainCode")
	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}
	
	public String getStandardUnits() {
		return standardUnits;
	}
	public void setStandardUnits(String standardUnitss) {
		this.standardUnits = standardUnitss;
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