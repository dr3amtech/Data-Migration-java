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
@Table(name="StatusReports")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "externalId", "start","end","duration","distance" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusReports implements ApiSuperClass ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusReports() {

	}
	



	public StatusReports(String id, String externalId, Date start, Date end, Integer duration, Integer distance,
			Equipment equipment, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.externalId = externalId;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.distance = distance;
		this.equipment = equipment;
		this.additionalProperties = additionalProperties;
	}




	@Id
	@JsonProperty("id")
	private String id;	
	@Column(name="ExternalId")
	@JsonProperty("externalId")
	private String externalId;
	@Column(name="Start_Status_Time")
	@JsonProperty("start")
	private Date start;
	@Column(name="EndStatusTime")
	@JsonProperty("end")
	private Date end;
	@Column(name="DurationT")
	@JsonProperty("duration")
	private Integer duration;
	@Column(name="Distance")
	@JsonProperty("distance")
	private Integer distance;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Equipment equipment;
//	@OneToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private Duties duties;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<String> l1(String nothing){
		l1.add("duty");
		l1.add("equipment");
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
	@JsonProperty("start")
	public Date getStart() {
		return start;
	}
	@JsonProperty("start")
	public void setStart(String start) {
		try {
			
			this.start	=simpleDateFormat.parse(start);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@JsonProperty("end")
	public Date getEnd() {
		return end;
	}
	@JsonProperty("end")
	public void setEnd(String end) {
		try {
			
			this.end	=simpleDateFormat.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}
	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	@JsonProperty("distance")
	public Integer getDistance() {
		return distance;
	}
	@JsonProperty("distance")
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Equipment getEquipments() {
		return equipment;
	}

	public void setEquipments(Equipment equipment) {
		this.equipment = equipment;
	}

//	public Duties getDuties() {
//		return duties;
//	}
//
//	public void setDuties(Duties duty) {
//		this.duties = duty;
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
		return "StatusReports [id=" + id + ", externalId=" + externalId + ", start=" + start + ", end=" + end
				+ ", duration=" + duration + ", distance=" + distance + ", equipment=" + equipment + "]";
	}

}