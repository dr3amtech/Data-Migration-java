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
@Table(name="EquipmentHoursOffSets")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "userSetHours", "offset", "timeOfReception"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipmentHoursOffsets implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EquipmentHoursOffsets() {
		
	}

	
	public EquipmentHoursOffsets(String id, Integer userSetHours, Integer offset, Date timeOfReception,
			Equipment equipment,Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.userSetHours = userSetHours;
		this.offset = offset;
		this.timeOfReception = timeOfReception;
		this.equipment = equipment;
		this.additionalProperties = additionalProperties;
	}






	@Override
	public String toString() {
		return "EquipmentHoursOffsets [id=" + id + ", userSetHours=" + userSetHours + ", offset=" + offset
				+ ", timeOfReception=" + timeOfReception + ", equipment=" + equipment +", additionalProperties=" + additionalProperties + "]";
	}





	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="UserSetHours")
	@JsonProperty("userSetHours")
	private Integer userSetHours;
	@Column(name="OffSet")
	@JsonProperty("offset")
	private Integer offset;
	@Column(name="timeOfReception")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
	@OneToOne(cascade =CascadeType.ALL) 
	@JsonIgnore
	private Equipment equipment;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		//l1.add("equipment");
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

	@JsonProperty("userSetHours")
	public Integer getUserSetHours() {
		return userSetHours;
	}
	@JsonProperty("userSetHours")
	public void setUserSetHours(Integer userSetHours) {
		this.userSetHours = userSetHours;
	}
	@JsonProperty("offset")
	public Integer getOffset() {
		return offset;
	}
	@JsonProperty("offset")
	public void setOffset(Integer offset) {
		this.offset = offset;
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

	public Equipment getEquipments() {
		return equipment;
	}

	public void setEquipments(Equipment equipment) {
		this.equipment = equipment;
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

	
	

}