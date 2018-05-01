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
import javax.persistence.ManyToMany;
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
@Table(name = "DefaultCanAlarm")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name","threshhold","comparator","duration" })
public class DefaultCanAlarmThresholds implements ApiSuperClass,Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DefaultCanAlarmThresholds() {
		
	}
	
	

	public DefaultCanAlarmThresholds(String id, String name, Integer threshold, Integer comparator, Integer duration,
			CanVariables canVariable, List<Models> models, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.name = name;
		this.threshold = threshold;
		this.comparator = comparator;
		this.duration = duration;
		this.models = models;
		
	}



	@Override
	public String toString() {
		return "DefaultCanAlarmThresholds [id=" + id + ", name=" + name + ", threshold=" + threshold + ", comparator="
				+ comparator + ", duration=" + duration +", Models=" + models
				+ ", additionalProperties=" + additionalProperties + "]";
	}

	@Id
	@JsonProperty("id")
	private String id;
	
	
	@Column(name ="name")
	@JsonProperty("name")
	private String name;
	
	@Column(name ="threshold")
	@JsonProperty("threshold")
	private Integer threshold;

	@Column(name ="comparator")
	@JsonProperty("comparator")
	private Integer comparator;
	
	@Column(name ="duration")
	@JsonProperty("duration")
	private Integer duration;
	
	 @OneToOne(cascade =CascadeType.ALL)
	 private static CanVariables canVariables;
	
	@ManyToMany(cascade =CascadeType.ALL)
	@JsonProperty("Models")
	private List<Models> models = new ArrayList<Models>();
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("canVariables");
		l1.add("models");
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
	
	
	@JsonProperty("threshold")
	public Integer getThreshold() {
		return threshold;
	}
	@JsonProperty("threshold")
	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}
	@JsonProperty("comparator")
	public Integer getComparator() {
		return comparator;
	}
	@JsonProperty("comparator")
	public void setComparator(Integer comparator) {
		this.comparator = comparator;
	}
	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}
	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	
	

	public List<Models> getModel() {
		return models;
	}

	public void setModel(ArrayList<Models> models) {
		this.models= models;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}



	public static CanVariables getCanVariables() {
		return canVariables;
	}



	public static void setCanVariables(CanVariables canVariables) {
		DefaultCanAlarmThresholds.canVariables = canVariables;
	}



	
}