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
@Table(name="GeofenceAlerts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "condition", "externalId", "timeOfReception", "timeOfOccurrence"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeofenceAlerts implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GeofenceAlerts() {
		
	}

	public GeofenceAlerts(String id, Integer condition, String externalId, Date timeOfReception, Date timeOfOccurrence,
			GeofenceAlarms geofenceAlarm, TrackingPoints trackingPoints, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.condition = condition;
		this.externalId = externalId;
		this.timeOfReception = timeOfReception;
		this.timeOfOccurrence = timeOfOccurrence;
		this.geofenceAlarm = geofenceAlarm;
		this.trackingPoints = trackingPoints;
		this.additionalProperties = additionalProperties;
	}

	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="Condition")
	@JsonProperty("condition")
	private Integer condition;
	@Column(name="ExternalId")
	@JsonProperty("externalId")
	private String externalId;
	@Column(name="timeOfReception")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
	@Column(name="timeOfOccurrence")
	@JsonProperty("timeOfOccurrence")
	private Date timeOfOccurrence;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private GeofenceAlarms geofenceAlarm;
	@OneToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private Equipment equipment;
//	@OneToOne(cascade =CascadeType.ALL) 
	@JsonIgnore
	private TrackingPoints trackingPoints;
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient 
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("geofenceAlarms");
		l1.add("equipment");
		l1.add("trackingPoints");
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
	@JsonProperty("condition")
	public Integer getCondition() {
		return condition;
	}
	@JsonProperty("condition")
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	@JsonProperty("externalId")
	public String getExternalId() {
		return externalId;
	}
	@JsonProperty("externalId")
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	@JsonProperty("timeOfReception")
	public Date getTimeOfReception() {
		return timeOfReception;
	}
	@JsonProperty("timeOfReception")
	public void setTimeOfReception(String timeOfReception) {
       try {
			
			this.timeOfReception	= simpleDateFormat.parse(timeOfReception);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public GeofenceAlarms getGeofenceAlarms() {
		return geofenceAlarm;
	}
	public void setGeofenceAlarms(GeofenceAlarms geofenceAlarm) {
		this.geofenceAlarm = geofenceAlarm;
	}
//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}

	public TrackingPoints getTrackingPoints() {
		return trackingPoints;
	}

	public void setTrackingPoints(TrackingPoints trackingPoint) {
		this.trackingPoints = trackingPoint;
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
		return "GeofenceAlerts [id=" + id + ", condition=" + condition + ", externalId=" + externalId
				+ ", timeOfReception=" + timeOfReception + ", timeOfOccurrence=" + timeOfOccurrence + ", geofenceAlarm="
				+ geofenceAlarm + ", trackingPoints=" + trackingPoints + ", additionalProperties="
				+ additionalProperties + "]";
	}


	

}