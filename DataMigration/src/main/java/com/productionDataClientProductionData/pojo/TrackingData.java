package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
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
@Table(name="TrackingData")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "raw","values","trackingPoint","canVariable"})
public class TrackingData implements ApiSuperClass ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public TrackingData() {
		
	}
	
	


	public TrackingData(String id, Integer raw, Integer values, TrackingPoints trackingPoints,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.raw = raw;
		this.values = values;
		this.trackingPoints = trackingPoints;
		this.additionalProperties = additionalProperties;
	}




	@Id
	@JsonProperty("id")
	private String id;
	
	@Column(name="RawValue")
	@JsonProperty("raw")
	private Integer raw;
	
	@Column(name = "TDValues")
	@JsonProperty("values")
	private Integer values;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JsonProperty("trackingPoint")
	private TrackingPoints trackingPoints;
	
//	
//	 @OneToOne(cascade =CascadeType.ALL)
//	 @JsonIgnore
//	 private CanVariables canVariables;
//	
	

		
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	

	@JsonProperty("id")
	public Object getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	
	public Integer getRaw() {
		return raw;
	}

	public void setRaw(Integer raw) {
		this.raw = raw;
	}

	public Integer getValues() {
		return values;
	}

	public void setValues(Integer values) {
		this.values = values;
	}

	public TrackingPoints getTrackingPoints() {
		return trackingPoints;
	}

	public void setTrackingPoints(TrackingPoints trackingPoint) {
		this.trackingPoints = trackingPoint;
	}

//	public CanVariables getCanVariable() {
//		return getCanVariable();
//	}
//
//	public void setCanVariable(CanVariables canVariable) {
//		this.canVariables = canVariable;
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
	public List<String> l1(String nothing) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String toString() {
		return "TrackingData [id=" + id + ", raw=" + raw + ", values=" + values + ", trackingPoints=" + trackingPoints
				+ ", additionalProperties=" + additionalProperties + "]";
	}


	
}