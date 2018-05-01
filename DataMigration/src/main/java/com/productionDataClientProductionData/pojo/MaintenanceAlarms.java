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
@Table(name="MaintenanceAlarms")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "archived", "offset", "recurringHours","recurringCount"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaintenanceAlarms implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaintenanceAlarms() {
		
	}
	

	public MaintenanceAlarms(String id, Boolean archived, Integer offset, Integer recurringHours,
			Integer recurringCount, Integer initialHours, Boolean initialTriggered) {
		super();
		this.id = id;
		this.archived = archived;
		this.offset = offset;
		this.recurringHours = recurringHours;
		this.recurringCount = recurringCount;
		this.initialHours = initialHours;
		this.initialTriggered = initialTriggered;
	}


	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="archived") 
	@JsonProperty("archived")
	private Boolean archived;
	@Column(name="OffSet")
	@JsonProperty("offset")
	private Integer offset;
	@Column(name="reccuringHours")
	@JsonProperty("recurringHours")
	private Integer recurringHours;
	@Column(name="reccuringCount")
	@JsonProperty("recurringCount")
	private Integer recurringCount;
	@Column(name="initialHours")
	@JsonProperty("initialHours")
	private Integer initialHours;
	@Column(name="initialTriggered")
	@JsonProperty("initialTriggered")
	private Boolean initialTriggered;
//	@OneToOne(cascade =CascadeType.ALL)
//    @JsonIgnore
//	private Equipment equipment;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<String> l1(String nothing){
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
	
	@JsonProperty("archived")
	public Boolean getArchived() {
		return archived;
	}
	@JsonProperty("archived")
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	@JsonProperty("offset")
	public Integer getOffset() {
		return offset;
	}
	@JsonProperty("offset")
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	@JsonProperty("recurringHours")
	public Integer getRecurringHours() {
		return recurringHours;
	}
	@JsonProperty("recurringHours")
	public void setRecurringHours(Integer recurringHours) {
		this.recurringHours = recurringHours;
	}
	@JsonProperty("recurringCount")
	public Integer getRecurringCount() {
		return recurringCount;
	}
	@JsonProperty("recurringCount")
	public void setRecurringCount(Integer recurringCount) {
		this.recurringCount = recurringCount;
	}

//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}
	
	public Integer getInitialHours() {
		return initialHours;
	}
	public void setInitialHours(Integer initialHours) {
		this.initialHours = initialHours;
	}
	public Boolean getInitialTriggered() {
		return initialTriggered;
	}
	public void setInitialTriggered(Boolean initialTriggered) {
		this.initialTriggered = initialTriggered;
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
		return "MaintenanceAlarms [id=" + id + ", archived=" + archived + ", offset=" + offset + ", recurringHours="
				+ recurringHours + ", recurringCount=" + recurringCount + ", initialHours=" + initialHours
				+ ", initialTriggered=" + initialTriggered + "]";
	}


	

}