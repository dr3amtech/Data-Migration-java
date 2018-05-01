package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "version", "externalId", "timeOfReception", "error","type"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GwConfigurationAckHistories implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GwConfigurationAckHistories() {
		
	}

	public GwConfigurationAckHistories(String id, String version, Date timeOfReception, Integer error, String type,
			Trackers tracker, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.version = version;
		this.timeOfReception = timeOfReception;
		this.error = error;
		this.type = type;
		this.trackers = tracker;
		this.additionalProperties = additionalProperties;
	}

	
	@Override
	public String toString() {
		return "GwConfigurationAckHistories [id=" + id + ", version=" + version + ", timeOfReception=" + timeOfReception
				+ ", error=" + error + ", type=" + type + ", tracker=" + trackers + ", additionalProperties="
				+ additionalProperties + "]";
	}


	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="version")
	@JsonProperty("version")
	private String version;
	@Column(name="timeOfReception")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
	@Column(name="error")
	@JsonProperty("error")
	private Integer error;
	@Column(name="Type")
	@JsonProperty("type")
	private String type;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Trackers trackers;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		//l1.add("tracker");
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
	@JsonProperty("version")
	public String getVersion() {
		return version;
	}
	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}
	@JsonProperty("error")
	public Integer getError() {
		return error;
	}
	@JsonProperty("error")
	public void setError(Integer error) {
		this.error = error;
	}
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public Trackers getTrackers() {
		return trackers;
	}

	public void setTrackers(Trackers tracker) {
		this.trackers = tracker;
	}

	@JsonProperty("timeOfReception")
	public Date getTimeOfReception() {
		return timeOfReception;
	}
	@JsonProperty("timeOfReception")
	public void setTimeOfReception(String timeOfReception) {
		try {
			this.timeOfReception= simpleDateFormat.parse(timeOfReception);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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