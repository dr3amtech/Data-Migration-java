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
@Table(name="CurfewAlerts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "time", "timeOfOccurrence", "timeOfReception", "equipment", "curfewAlarms",
		"links", "canVariables","additionalProperties" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurfewAlerts implements  ApiSuperClass, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CurfewAlerts() {
		
	}



	public CurfewAlerts(String id, String time, Date timeOfOccurrence, Date timeOfReception, CurfewAlarms curfewAlarm,
			TrackingPoints trackingPoints, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.time = time;
		this.timeOfOccurrence = timeOfOccurrence;
		this.timeOfReception = timeOfReception;
		this.curfewAlarm = curfewAlarm;
		this.trackingPoints = trackingPoints;
		this.additionalProperties = additionalProperties;
	}



	@Id
	@JsonProperty("id")
	private String id;
	@Column(name ="time")
	@JsonProperty("time")
	private String time;
	@Column(name = "timeOfOccurrence")
	@JsonProperty("timeOfOccurrence")
	private Date timeOfOccurrence;
	@Column(name="timeOfreception")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
//	@OneToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private CanVariables canVariables;
//	@OneToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private Equipment equipment;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private CurfewAlarms curfewAlarm;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private TrackingPoints trackingPoints;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("canVariables");
		l1.add("curfewAlarms");
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

	@JsonProperty("time")
	public String getTime() {
		return time;
	}
	@JsonProperty("time")
	public void setTime(String time) {
		this.time = time;
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

//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}
//
//	
//	public CanVariables getCanVariables() {
//		return canVariables;
//	}
//	public void setCanVariables(CanVariables canVariables) {
//		this.canVariables = canVariables;
//	}
	public CurfewAlarms getCurfewAlarm() {
		return curfewAlarm;
	}
	public void setCurfewAlarm(CurfewAlarms curfewAlarm) {
		this.curfewAlarm = curfewAlarm;
	}
	
	public TrackingPoints getTrackingPoints() {
		return trackingPoints;
	}
	public void setTrackingPoints(TrackingPoints trackingPoints) {
		this.trackingPoints = trackingPoints;
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
		return "CurfewAlerts [id=" + id + ", time=" + time + ", timeOfOccurrence=" + timeOfOccurrence
				+ ", timeOfReception=" + timeOfReception + ", curfewAlarm=" + curfewAlarm + ", trackingPoints="
				+ trackingPoints + ", l1=" + l1 + ", additionalProperties=" + additionalProperties + "]";
	}
	
	
}