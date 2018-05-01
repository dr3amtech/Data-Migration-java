package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;
@Entity 
@Table(name="Trackers")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "activated", "deviceId","serialNumber","type","revision" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trackers implements ApiSuperClass,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Trackers() {

	}
	



public Trackers(String mongo_id, Boolean activated, String deviceId, String serialNumber, String type,
			String revision, Equipment equipment, ComServiceSubscriptions comServiceSubscriptions,
			Configurations configurations, GwODXLiteConfigurations gwODXLiteConfigurations,
			GwStatusCalculations gwStatusCalculations, Map<String, Object> additionalProperties) {
		super();
		Mongo_id = mongo_id;
		this.activated = activated;
		this.deviceId = deviceId;
		this.serialNumber = serialNumber;
		this.type = type;
		this.revision = revision;
		this.equipment = equipment;
		this.comServiceSubscriptions = comServiceSubscriptions;
		this.configurations = configurations;
		this.gwODXLiteConfigurations = gwODXLiteConfigurations;
		this.gwStatusCalculations = gwStatusCalculations;
		this.additionalProperties = additionalProperties;
	}




@Id
@JsonProperty("id")
private String Mongo_id;
@Column(name="Activated")
	@Type(type="true_false")
	@JsonProperty("activated")
	private Boolean activated;
@Column(name="DeviceId")
	@JsonProperty("deviceId")
	private String deviceId;
@Column(name="SerialNumber")
	@JsonProperty("serialNumber")
	private String serialNumber;
@Column(name="Type")
	@JsonProperty("type")
	private String type;
@Column(name="Revision")
	@JsonProperty("revision")
	private String revision;
@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Equipment equipment;
@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private ComServiceSubscriptions comServiceSubscriptions;
@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Configurations configurations;
//@OneToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private ComServiceLevels comServiceLevels;
@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private GwODXLiteConfigurations gwODXLiteConfigurations;
@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private GwStatusCalculations gwStatusCalculations;
@Transient
public final List<String> l1 = new ArrayList<String>();


@Transient 
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<String> l1(String nothing){
	l1.add("comServiceSubscription");
	l1.add("configuration");
	l1.add("comServiceLevel");
	l1.add("gwODXLiteConfiguration");
	l1.add("gwStatusCalculation");
	return l1;
}

	@JsonProperty("id")
	public String getId() {
		return Mongo_id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.Mongo_id = id;
	}
	

	@JsonProperty("activated")
	public Boolean getActivated() {
		return activated;
	}
	@JsonProperty("activated")
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	@JsonProperty("deviceId")
	public String getDeviceId() {
		return deviceId;
	}
	@JsonProperty("deviceId")
	public void setDeviceId(String deviceId) {
		this.deviceId =  deviceId;
	}
	@JsonProperty("serialNumber")
	public String getSerialNumber() {
		return serialNumber;
	}
	@JsonProperty("serialNumber")
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	@JsonProperty("revision")
	public String getRevision() {
		return revision;
	}
	@JsonProperty("revision")
	public void setRevision(String revision) {
		this.revision = revision;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public ComServiceSubscriptions getComServiceSubscriptions() {
		return comServiceSubscriptions;
	}

	public void setComServiceSubscriptions(ComServiceSubscriptions comServiceSubscription) {
		this.comServiceSubscriptions = comServiceSubscription;
	}

	public Configurations getConfigurations() {
		return configurations;
	}

	public void setConfigurations(Configurations configuration) {
		this.configurations = configuration;
	}

//	public ComServiceLevels getComServiceLevels() {
//		return ComServiceLevels;
//	}
//
//	public void setComServiceLevels(ComServiceLevels comServiceLevel) {
//		this.comServiceLevels = comServiceLevel;
//	}
//
	public GwODXLiteConfigurations getGwODXLiteConfigurations() {
		return gwODXLiteConfigurations;
	}

	public void setGwODXLiteConfigurations(GwODXLiteConfigurations gwODXLiteConfiguration) {
		this.gwODXLiteConfigurations = gwODXLiteConfiguration;
	}

	public GwStatusCalculations getGwStatusCalculations() {
		return gwStatusCalculations;
	}

	public void setGwStatusCalculations(GwStatusCalculations gwStatusCalculation) {
		this.gwStatusCalculations = gwStatusCalculation;
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
		return "Trackers [Mongo_id=" + Mongo_id + ", activated=" + activated + ", deviceId=" + deviceId
				+ ", serialNumber=" + serialNumber + ", type=" + type + ", revision=" + revision + ", equipment="
				+ equipment + ", comServiceSubscriptions=" + comServiceSubscriptions + ", configurations="
				+ configurations + ", gwODXLiteConfigurations=" + gwODXLiteConfigurations + ", gwStatusCalculations="
				+ gwStatusCalculations + "]";
	}




	
}