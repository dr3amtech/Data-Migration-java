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
@Table(name ="ComServiceLevels")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name","serviceLevel","canVariableLimit","canAlarmLimit","geofenceAlarmLimit","properties","additionalProperties" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComServiceLevels implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComServiceLevels() {
		
	}
	
	public ComServiceLevels(String id, String name, String serviceLevel, Long canVariableLimit, Long canAlarmLimit,
			Long geofenceAlarmLimit, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.name = name;
		this.serviceLevel = serviceLevel;
		this.canVariableLimit = canVariableLimit;
		this.canAlarmLimit = canAlarmLimit;
		this.geofenceAlarmLimit = geofenceAlarmLimit;
		this.additionalProperties = additionalProperties;
	}


	@Override
	public String toString() {
		return "ComServiceLevels [id=" + id + ", name=" + name + ", serviceLevel=" + serviceLevel
				+ ", canVariableLimit=" + canVariableLimit + ", canAlarmLimit=" + canAlarmLimit
				+ ", geofenceAlarmLimit=" + geofenceAlarmLimit +  ", additionalProperties=" + additionalProperties + "]";
	}




	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="Name")
	@JsonProperty("name")
	private String name;
	@Column(name="ServiceLevel")
	@JsonProperty("serviceLevel")
	private String serviceLevel;
	@Column(name="canVariableLimit")
	@JsonProperty("canVariableLimit")
	private Long canVariableLimit;
	@Column(name = "canAlarmLimit")
	@JsonProperty("canAlarmLimit")
	private Long canAlarmLimit;
	@Column(name="GeofenceAlarmLimit")
	@JsonProperty("geofenceAlarmLimit")
	private Long geofenceAlarmLimit;
	
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

	

	@JsonProperty("serviceLevel")
	public String getServiceLevel() {
		return serviceLevel;
	}

	@JsonProperty("serviceLevel")
	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("canVariableLimit")
	public Long getCanVariableLimit() {
		return canVariableLimit;
	}
	@JsonProperty("canVariableLimit")
	public void setCanVariableLimit(Long canVariableLimit) {
		this.canVariableLimit = canVariableLimit;
	}
	@JsonProperty("canAlarmLimit")
	public Long getCanAlarmLimit() {
		return canAlarmLimit;
	}
	@JsonProperty("canAlarmLimit")
	public void setCanAlarmLimit(Long canAlarmLimit) {
		this.canAlarmLimit = canAlarmLimit;
	}
	@JsonProperty("geofenceAlarmLimit")
	public Long getGeofenceAlarmLimit() {
		return geofenceAlarmLimit;
	}
	@JsonProperty("geofenceAlarmLimit")
	public void setGeofenceAlarmLimit(Long geofenceAlarmLimit) {
		this.geofenceAlarmLimit = geofenceAlarmLimit;
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
	public List<String> l1(String nothing) {
	
		return l1;
	}
	

}