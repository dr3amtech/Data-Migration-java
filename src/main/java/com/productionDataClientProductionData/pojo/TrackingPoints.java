package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Table(name="TrackingPoints")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "heading", "timeOfOccurrence", "timeOfReception", "externalId" })
public class TrackingPoints implements ApiSuperClass,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public TrackingPoints() {
		
	}
	
	

	public TrackingPoints(String id, Integer heading, String type, Double coordinates1, Double coordinates2,
			Double coordinates3, Date timeOfOccurrence, Date timeOfReception, String externalId, Equipment equipment) {
		super();
		this.id = id;
		this.heading = heading;
		this.type = type;
		this.coordinates1 = coordinates1;
		this.coordinates2 = coordinates2;
		this.coordinates3 = coordinates3;
		this.timeOfOccurrence = timeOfOccurrence;
		this.timeOfReception = timeOfReception;
		this.externalId = externalId;
		this.equipment = equipment;
	}



	@Id
	@JsonProperty("id")
	private String id;
	
	@Column(name="TrackingHeader")
	@JsonProperty("heading")
	private Integer heading;
	
	
	@Column(name="Type")
	private String type;
	
	
	 @Column(name = "Location_Coordinates1")
	 private Double coordinates1;
	 
	 @Column(name = "Location_Coordinates2")
	 private Double coordinates2;
	 
	 @Column(name = "Location_Coordinate3")
	 private Double coordinates3;
	
	 @Column(name ="TimeOfOccurrence")
	 private Date timeOfOccurrence;
	 
	 @Column(name ="TimeOfReception")
	 private Date timeOfReception;
	 
	 @Column(name ="ExternalId")
	 private String externalId;
	 @OneToOne(cascade =CascadeType.ALL)
	 private Equipment equipment;
//	 @OneToOne(cascade =CascadeType.ALL)
//	 private Duties duties;
	 @Transient
	 private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		
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

		public Integer getHeading() {
		return heading;
	}

	public void setHeading(Integer heading) {
		this.heading = heading;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getCoordinates1() {
		return coordinates1;
	}

	public void setCoordinates1(Double coordinates1) {
		this.coordinates1 = coordinates1;
	}
	@JsonIgnore
	public void setCoordinates1(Long coordinates1) {
		this.coordinates1 = coordinates1.doubleValue();
	}
	public Double getCoordinates2() {
		return coordinates2;
	}

	public void setCoordinates2(Double coordinates2) {
		this.coordinates2 = coordinates2;
	}
	@JsonIgnore
	public void setCoordinates2(Long coordinates2) {
		this.coordinates2 = coordinates2.doubleValue();
	}
	
	public Double getCoordinates3() {
		return coordinates3;
	}


	public void setCoordinates3(Double coordinates3) {
		this.coordinates3 = coordinates3;
	}


	public Date getTimeOfOccurrence() {
		return timeOfOccurrence;
	}

	public void setTimeOfOccurrence(String timeOfOccurrence) {
		try {
			
			this.timeOfOccurrence	=simpleDateFormat.parse(timeOfOccurrence);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Date getTimeOfReception() {
		return timeOfReception;
	}

	public void setTimeOfReception(String timeOfReception) {
		try {
			this.timeOfReception= simpleDateFormat.parse(timeOfReception.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Equipment getEquipments() {
		return equipment;
	}

//	public Duties getDuties() {
//		return duties;
//	}
//
//	public void setDuties(Duties duty) {
//		this.duties = duty;
//	}

	public void setEquipments(Equipment equipment) {
		this.equipment = equipment;
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
	public List<String> l1(String nothing) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String toString() {
		return "TrackingPoints [id=" + id + ", heading=" + heading + ", type=" + type + ", coordinates1=" + coordinates1
				+ ", coordinates2=" + coordinates2 + ", coordinates3=" + coordinates3 + ", timeOfOccurrence="
				+ timeOfOccurrence + ", timeOfReception=" + timeOfReception + ", externalId=" + externalId
				+ ", equipment=" + equipment + "]";
	}


	
}