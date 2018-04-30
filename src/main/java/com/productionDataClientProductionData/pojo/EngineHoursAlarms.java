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
@Table(name="EngineHoursAlarms")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "hours", "interval", "isRecurring", "archived", "consumerKey" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineHoursAlarms implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EngineHoursAlarms() {
		
	}

	





	public EngineHoursAlarms(String id, Integer hours, String application, Integer interval, Boolean isRecurring,
			Boolean archived, String consumerKey, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.hours = hours;
		this.application = application;
		this.interval = interval;
		this.isRecurring = isRecurring;
		this.archived = archived;
		this.consumerKey = consumerKey;
		this.additionalProperties = additionalProperties;
	}











	@Id
	@JsonProperty("id")
	private String id;
	@Column(name = "hours")
	@JsonProperty("hours")
	private Integer hours;
	@Column(name="ApplicationId")
	@JsonIgnore
	private String application;
//	@OneToOne(cascade =CascadeType.ALL) 
//	@JsonIgnore
//	private Equipment equipment;
	@Column(name="interval")
    @JsonProperty("interval")
	private Integer interval;
	@Column(name="isRecurring")
	@JsonProperty("isRecurring")
	private Boolean isRecurring;
	@Column(name="archived")
	@JsonProperty("archived")
	private Boolean archived;
	@Column(name="ConsumerKey")
	@JsonProperty("consumerKey")
	private String consumerKey;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	
	public List<String> l1(String nothing){
		l1.add("equipment");
		l1.add("application");
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


	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	@JsonProperty("application")
	public String getApplication() {
		return application;
	}
	@JsonProperty("application")
	public void setApplication(String application) {
		this.application = application;
	}
	
//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}
	@JsonProperty("interval")
	public Integer getInterval() {
		return interval;
	}
	@JsonProperty("interval")
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	@JsonProperty("isRecurring")
	public Boolean getIsRecurring() {
		return isRecurring;
	}
	@JsonProperty("isRecurring")
	public void setIsRecurring(Boolean isRecurring) {
		this.isRecurring = isRecurring;
	}
	@JsonProperty("archived")
	public Boolean getArchived() {
		return archived;
	}
	@JsonProperty("archived")
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	@JsonProperty("consumerKey")
	public String getConsumerKey() {
		return consumerKey;
	}
	@JsonProperty("consumerKey")
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
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
		return "EngineHoursAlarms [id=" + id + ", hours=" + hours + ", application=" + application + ", interval="
				+ interval + ", isRecurring=" + isRecurring + ", archived=" + archived + ", consumerKey=" + consumerKey
				+ ", l1=" + l1 + ", additionalProperties=" + additionalProperties + "]";
	}


}