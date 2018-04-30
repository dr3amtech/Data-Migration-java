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
@Table(name="EngineHoursAlerts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "hours", "timeOfOccurrence", "consumerKey" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineHoursAlerts implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EngineHoursAlerts() {
		
	}
	








	public EngineHoursAlerts(String id, Integer hours, Date timeOfOccurrence, String consumerKey,
			EngineHoursAlarms engineHoursAlarm, String applications, TrackingData trackingData,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.hours = hours;
		this.timeOfOccurrence = timeOfOccurrence;
		this.consumerKey = consumerKey;
		this.engineHoursAlarm = engineHoursAlarm;
		this.applications = applications;
		this.trackingData = trackingData;
		this.additionalProperties = additionalProperties;
	}









	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="hours")
	@JsonProperty("hours")
	private Integer hours;
	@Column(name="timeOfOccurrence")
	@JsonProperty("timeOfOccurrence")
	private Date timeOfOccurrence;
	@Column(name="consumerKey")
	@JsonProperty("consumerKey")
	private String consumerKey;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private EngineHoursAlarms engineHoursAlarm;
	@Column(name="applicationsId")
	@JsonIgnore
	private String applications;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private TrackingData trackingData;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("applications");
		l1.add("engineHoursAlarms");
		l1.add("trackingData");
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
	@JsonProperty("hours")
	public Integer getHours() {
		return hours;
	}
	@JsonProperty("hours")
	public void setHours(Integer hours) {
		this.hours = hours;
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
	@JsonProperty("consumerKey")
	public String getConsumerKey() {
		return consumerKey;
	}
	@JsonProperty("consumerKey")
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public EngineHoursAlarms getEngineHoursAlarms() {
		return engineHoursAlarm;
	}

	public void setEngineHoursAlarms(EngineHoursAlarms engineHoursAlarm) {
		this.engineHoursAlarm = engineHoursAlarm;
	}

	public String getApplications() {
		return applications;
	}





	public void setApplications(String applications) {
		this.applications = applications;
	}





	public TrackingData getTrackingData() {
		return trackingData;
	}





	public void setTrackingData(TrackingData trackingData) {
		this.trackingData = trackingData;
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
		return "EngineHoursAlerts [id=" + id + ", hours=" + hours + ", timeOfOccurrence=" + timeOfOccurrence
				+ ", consumerKey=" + consumerKey + ", engineHoursAlarm=" + engineHoursAlarm + ", applications="
				+ applications + ", trackingData=" + trackingData + ", l1=" + l1 + ", additionalProperties="
				+ additionalProperties + "]";
	}




}