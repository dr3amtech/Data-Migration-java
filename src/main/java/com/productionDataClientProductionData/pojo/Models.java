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
import javax.persistence.ManyToOne;
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
@Table(name="Models")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "year"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Models implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Models() {
		
	}
	public Models(String id, String name, Long year, EquipmentTypes equipmentType, Series series, ServiceSchedules serviceSchedule, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.equipmentTypes = equipmentType;
		this.series = series;
		this.serviceSchedules = serviceSchedule;
		this.additionalProperties = additionalProperties;
	}


	@Override
	public String toString() {
		return "Models [id=" + id + ", name=" + name + ", year=" + year + ", equipmentType=" + equipmentTypes
				+ ", series=" + series + ", serviceSchedule=" + serviceSchedules + ", links=" +", additionalProperties=" + additionalProperties + "]";
	}
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="Name")
	@JsonProperty("name")
	private String name;
	@Column(name="year")
	@JsonProperty("year")
	private Long year;
	@ManyToOne(cascade =CascadeType.ALL) 
	@JsonIgnore
	private Series series;
	@ManyToOne(cascade =CascadeType.ALL) 
	@JsonIgnore
	private EquipmentTypes equipmentTypes;
	@ManyToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private ServiceSchedules serviceSchedules;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("series");
		l1.add("equipmentTypes");
		l1.add("serviceSchedules");
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
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("year")
	public Long getYear() {
		return year;
	}
	@JsonProperty("year")
	public void setYear(Long year) {
		this.year = year;
	}
	
	public EquipmentTypes getEquipmentTypes() {
		return equipmentTypes;
	}

	public void setEquipmentTypes(EquipmentTypes equipmentType) {
		this.equipmentTypes = equipmentType;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public ServiceSchedules getServiceSchedules() {
		return serviceSchedules;
	}

	public void setServiceSchedules(ServiceSchedules serviceSchedule) {
		this.serviceSchedules = serviceSchedule;
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