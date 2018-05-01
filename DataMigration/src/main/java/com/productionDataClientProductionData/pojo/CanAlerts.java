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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name= "CanAlerts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "timeOfReception", "timeOfOccurrence", "value", "raw" })
public class CanAlerts implements ApiSuperClass,Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public CanAlerts() {
	
}
	

	public CanAlerts(String id, Date timeOfReception, Date timeOfOccurrence, Integer value, Integer raw,
		CanAlarms canAlarms, TrackingPoints trackingPoints, Map<String, Object> additionalProperties) {
	super();
	this.id = id;
	this.timeOfReception = timeOfReception;
	this.timeOfOccurrence = timeOfOccurrence;
	this.value = value;
	this.raw = raw;
	this.canAlarms = canAlarms;
	this.trackingPoints = trackingPoints;
	this.additionalProperties = additionalProperties;
}









	@Id
	@JsonProperty("id")
	private String id;
	@Column(name ="timeOfRecpetion")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
	@Column(name = "timeOfOccurrence")
	@JsonProperty("timeOfOccurrence")
	private java.util.Date timeOfOccurrence;
	@Column(name ="valueAlert")
	@JsonProperty("value")
	private Integer value;
	@Column(name="rawAlert")
	@JsonProperty("raw")
	private Integer raw;
	//@OneToOne(cascade =CascadeType.ALL) 
//	@JsonProperty("equipment")
//	private Equipment equipment;
	@OneToOne(cascade =CascadeType.ALL)
	private CanAlarms canAlarms;
//	@OneToOne(cascade =CascadeType.ALL)
//	private CanVariables canVariables;
	@OneToOne(cascade =CascadeType.ALL)
	private TrackingPoints trackingPoints;
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	

	public List<String> l1(String nothing){
		l1.add("canAlarms");
		l1.add("canVariables");
		l1.add("equipment");
		l1.add("trackingPoints");
		return l1;
	}
	
	@JsonProperty("id")
	public Object getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
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
	@JsonProperty("value")
	public Integer getValue() {
		return value;
	}
	@JsonProperty("value")
	public void setValue(Integer value) {
		this.value = value;
	}
	@JsonProperty("raw")
	public Integer getRaw() {
		return raw;
	}
	@JsonProperty("raw")
	public void setRaw(Integer raw) {
		this.raw = raw;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
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
	public CanAlarms getCanAlarm() {
		return canAlarms;
	}


	public void setCanAlarm(CanAlarms canAlarm) {
		this.canAlarms = canAlarm;
	}

//
//	public CanVariables getCanVariable() {
//		return canVariables;
//	}
//
//
//	public void setCanVariable(CanVariables canVariable) {
//		this.canVariables = canVariable;
//	}


	public TrackingPoints getTrackingPoints() {
		return trackingPoints;
	}


	public void setTrackingPoints(TrackingPoints trackingPoint) {
		this.trackingPoints = trackingPoint;
	}







	@Override
	public String toString() {
		return "CanAlerts [id=" + id + ", timeOfReception=" + timeOfReception + ", timeOfOccurrence=" + timeOfOccurrence
				+ ", value=" + value + ", raw=" + raw + ", canAlarms=" + canAlarms + ", trackingPoints="
				+ trackingPoints + ", l1=" + l1 + ", additionalProperties=" + additionalProperties + "]";
	}





	
	
	
}