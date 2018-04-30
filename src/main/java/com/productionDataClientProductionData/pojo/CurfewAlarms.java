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
@Table(name ="CurfewAlarms")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "endTime", "archived", "startTime", "equipment", "canVariables" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurfewAlarms implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942024214034630341L;


	public CurfewAlarms() {
		
	}
	

	public CurfewAlarms(String id, Integer endTime, Boolean archived, Integer startTime,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.endTime = endTime;
		this.archived = archived;
		this.startTime = startTime;
		this.additionalProperties = additionalProperties;
	}


	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="EndDate")
	@JsonProperty("endTime")
	private Integer endTime;
	@Column(name ="archived")
	@JsonProperty("archived")
	private Boolean archived;
	@Column(name="startTime")
	@JsonProperty("startTime")
	private Integer startTime;
//	@OneToOne(cascade =CascadeType.ALL)
//	private Equipment equipment;
//	@OneToOne(cascade =CascadeType.ALL)
//	private CanVariables canVariables;
	@Transient
	public final List<String> l1 = new ArrayList<String>();	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("equipment");
		l1.add("canVariables");
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

	
	@JsonProperty("endTime")
	public Integer getEndTime() {
		return endTime;
	}



	@JsonProperty("endTime")
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}



	@JsonProperty("archived")
	public Boolean getArchived() {
		return archived;
	}



	@JsonProperty("archived")
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}



	@JsonProperty("startTime")
	public Integer getStartTime() {
		return startTime;
	}



	@JsonProperty("startTime")
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}



//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//
//
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}




//	public CanVariables getCanVariables() {
//		return canVariables;
//	}
//
//
//
//
//	public void setCanVariables(CanVariables canVariables) {
//		this.canVariables = canVariables;
//	}



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
		return "CurfewAlarms [id=" + id + ", endTime=" + endTime + ", archived=" + archived + ", startTime=" + startTime
				+ "]";
	}



}