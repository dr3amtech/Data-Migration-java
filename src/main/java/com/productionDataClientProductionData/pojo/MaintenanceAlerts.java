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
@Table(name="MaintenanceAlerts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "externalId", "timeOfOccurrence", "timeOfReception","engineHours"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaintenanceAlerts implements  ApiSuperClass,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaintenanceAlerts() {
		
	}
	
	public MaintenanceAlerts(String id, String externalId, Date timeOfOccurrence, Date timeOfReception,
			String engineHours, TrackingPoints trackingPoints, MaintenanceAlarms maintenanceAlarms,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.externalId = externalId;
		this.timeOfOccurrence = timeOfOccurrence;
		this.timeOfReception = timeOfReception;
		this.engineHours = engineHours;
		this.trackingPoints = trackingPoints;
		this.maintenanceAlarms = maintenanceAlarms;
		this.additionalProperties = additionalProperties;
	}

	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="externalId")
	@JsonProperty("externalId")
	private String externalId;
	@Column(name="timeOfOccurrence")
	@JsonProperty("timeOfOccurrence")
	private Date timeOfOccurrence;
	@Column(name="timeOfReception")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
	@Column(name = "EngineHours")
	@JsonProperty("engineHours")
	private String engineHours;
//	@OneToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private Equipment equipment;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private TrackingPoints trackingPoints;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private MaintenanceAlarms maintenanceAlarms;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<String> l1(String nothing){
//		l1.add("trackingPoints");
//		l1.add("equipment");
//		l1.add("maintenanceAlarms");
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
	@JsonProperty("externalId")
	public String getExternalId() {
		return externalId;
	}
	@JsonProperty("externalId")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	@JsonProperty("timeOfOccurrence")
	public Date getTimeOfOccurrence() {
		return timeOfOccurrence;
	}
	@JsonProperty("timeOfOccurrence")
	public void setTimeOfOccurrence(String timeOfOccurrence) {
		try {
			
			this.timeOfOccurrence	=simpleDateFormat.parse(timeOfOccurrence);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@JsonProperty("timeOfReception")
	public Date getTimeOfReception() {
		return timeOfReception;
	}
	@JsonProperty("timeOfReception")
	public void setTimeOfReception(String timeOfReception) {
		try {
			this.timeOfReception= simpleDateFormat.parse(timeOfReception.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@JsonProperty("engineHours")
	public String getEngineHours() {
		return engineHours;
	}
	@JsonProperty("engineHours")
	public void setEngineHours(String engineHours) {
		this.engineHours = engineHours;
	}

	public TrackingPoints getTrackingPoints() {
		return trackingPoints;
	}

	public void setTrackingPoints(TrackingPoints trackingPoint) {
		this.trackingPoints = trackingPoint;
	}

	public MaintenanceAlarms getMaintenanceAlarm() {
		return maintenanceAlarms;
	}

	public void setMaintenanceAlarm(MaintenanceAlarms maintenanceAlarm) {
		this.maintenanceAlarms = maintenanceAlarm;
	}

//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}

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
		return "MaintenanceAlerts [id=" + id + ", externalId=" + externalId + ", timeOfOccurrence=" + timeOfOccurrence
				+ ", timeOfReception=" + timeOfReception + ", engineHours=" + engineHours + ", trackingPoints="
				+ trackingPoints + ", maintenanceAlarms=" + maintenanceAlarms + ", l1=" + l1 + ", additionalProperties="
				+ additionalProperties + "]";
	}


	

}