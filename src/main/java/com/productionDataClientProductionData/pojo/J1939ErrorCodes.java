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
@Table(name="J1939ErrorCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "sourceAddress", "SPN", "FMI","severity","source","emissionRelated"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class J1939ErrorCodes implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public J1939ErrorCodes() {
		
	}
	public J1939ErrorCodes(String id, String sourceAddress, String sPN, String fMI, String severity, String source,
			boolean emissionRelated, Models model, String description, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.sourceAddress = sourceAddress;
		SPN = sPN;
		FMI = fMI;
		this.severity = severity;
		this.source = source;
		this.emissionRelated = emissionRelated;
		this.models = model;
		this.description = description;
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "J1939ErrorCodes [id=" + id + ", sourceAddress=" + sourceAddress + ", SPN=" + SPN + ", FMI=" + FMI
				+ ", severity=" + severity + ", source=" + source + ", emissionRelated=" + emissionRelated + ", model="
				+ models + ", description=" + description + ", additionalProperties=" + additionalProperties + "]";
	}
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="SourceAddress")
	@JsonProperty("sourceAddress")
	private String sourceAddress;
	@Column(name="SPN")
	@JsonProperty("SPN")
	private String SPN;
	@Column(name="FMI")
	@JsonProperty("FMI")
	private String FMI;
	@Column(name="Serverity ")
	@JsonProperty("severity")
	private String severity;
	@Column(name="Source")
	@JsonProperty("source")
	private String source;
	@Column(name="EmissionRelated")
	@JsonProperty("emissionRelated")
	private boolean emissionRelated;
	@Column(name="description")
	private String description;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Models models;
		
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Translations 	translations;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<String> l1(String nothing){
		l1.add("models");
		l1.add("translation");
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
	@JsonProperty("sourceAddress")
	public String getSourceAddress() {
		return sourceAddress;
	}
	@JsonProperty("sourceAddress")
	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}
	@JsonProperty("SPN")
	public String getSPN() {
		return SPN;
	}
	@JsonProperty("SPN")
	public void setSPN(String sPN) {
		SPN = sPN;
	}
	@JsonProperty("FMI")
	public String getFMI() {
		return FMI;
	}
	@JsonProperty("FMI")
	public void setFMI(String fMI) {
		FMI = fMI;
	}
	@JsonProperty("severity")
	public String getSeverity() {
		return severity;
	}
	@JsonProperty("severity")
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	@JsonProperty("source")
	public String getSource() {
		return source;
	}
	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}
	@JsonProperty("emissionRelated")
	public boolean getEmissionRelated() {
		return emissionRelated;
	}
	@JsonProperty("emissionRelated")
	public void setEmissionRelated(boolean emissionRelated) {
		this.emissionRelated = emissionRelated;
	}

	public Models getModel() {
		return models;
	}

	public void setModel(Models model) {
		this.models = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonProperty("links")
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


	

}