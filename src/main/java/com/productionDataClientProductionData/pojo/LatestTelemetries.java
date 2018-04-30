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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name="LatestTeleM")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "equipment", "timeOfOccurrence", "timeOfReception", "timeOfReception", "timeOfReception",
		"timeOfReception", "timeOfReception","timeOfReception" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestTelemetries implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LatestTelemetries() {
		
	}



	public LatestTelemetries(Long id, String mongo_ID, Equipment equipment, Double coordinates, Double coordinates2,
			Integer coordinates3, Date timeOfOccurrence, Date timeOfReception, String heading, String speed,
			String type, Duties duties, List<com.productionDataClientProductionData.pojo.CanVariablesL> canVariablesL,
			String firmware, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.Mongo_ID = mongo_ID;
		this.equipment = equipment;
		this.coordinates = coordinates;
		this.coordinates2 = coordinates2;
		this.coordinates3 = coordinates3;
		this.timeOfOccurrence = timeOfOccurrence;
		this.timeOfReception = timeOfReception;
		this.heading = heading;
		this.speed = speed;
		this.type = type;
		this.duties = duties;
		this.CanVariablesL = canVariablesL;
		this.firmwareVersion = firmware;
		this.additionalProperties = additionalProperties;
	}



	@Id
	@SequenceGenerator(name = "generator", sequenceName = "MY_SEQ")@GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
	@Column(name = "Id", updatable=true, nullable = false,insertable=true)
	private Long id;
	
	
	@Column
	@JsonProperty("Mongo_ID")
	private String Mongo_ID;
	@ManyToOne(cascade =CascadeType.ALL)
	@JsonProperty("equipment")
	private Equipment equipment;
	@Column(name="coordinates1")
	@JsonProperty("coordinates1")
	private Double coordinates;
	@Column(name="coordinates2")
	@JsonProperty("coordinates2")
	private Double coordinates2;
	@Column(name="Loaction")
	@JsonProperty("coordinates3")
	private Integer coordinates3;
	@Column(name="timeOfOccurrence")
	@JsonProperty("timeOfOccurrence")
	private Date timeOfOccurrence;
	@Column(name="timeOfReception")
	@JsonProperty("timeOfReception")
	private Date timeOfReception;
	@Column(name="heading")
	@JsonProperty("heading")
	private String heading;
	@Column(name="speed")
	@JsonProperty("speed")
	private String speed;
	@Column(name="Type")
	private String type;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonProperty("Duty")
	private Duties duties;
	@OneToMany(cascade =CascadeType.ALL)
	@JoinTable(name="LatestTeleM_CanVariablesE",joinColumns={@JoinColumn(name="Mongo_ID")}
	,inverseJoinColumns= {@JoinColumn(name="canId")})
	private List<CanVariablesL> CanVariablesL;
	@Column(name="Firmware")
	private String firmwareVersion;
	
	
	@JsonProperty
	@Transient
	private boolean isItTrue =false;

	
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	
	
	@Transient
	@JsonIgnore
	public Long getDId() {
		return this.id;
		
	}
	@JsonProperty("id")
	public String getId() {
		return Mongo_ID;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.Mongo_ID = id;
	}
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipmentid) {
		this.equipment = equipmentid;
	}

	public Duties getDuty() {
		return duties;
	}

	public void setDuty(Duties duty) {
		this.duties = duty;
	}

	public List<CanVariablesL> getCanVariables() {
		return CanVariablesL;
	}

	public void setCanVariables(ArrayList<CanVariablesL> canVariables) {
		this.CanVariablesL = canVariables;
	}


	public Double getCoordinates1() {
		return coordinates;
	}

	public void setCoordinates1(Double coordinates) {
		this.coordinates = coordinates;
	}
	@JsonIgnore
	public void setCoordinates1(Long coordinates) {
		this.coordinates = coordinates.doubleValue();
		isItTrue=true;
	}
	public Double getCoordinates2() {
		return coordinates2;
	}

	public void setCoordinates2(Double coordinates2) {
		this.coordinates2 = coordinates2;
		isItTrue=true;
	}
	@JsonIgnore
	public void setCoordinates2(Long coordinates2) {
		this.coordinates2 = coordinates2.doubleValue();
		isItTrue=true;
	}

	public Integer getCoordinates3() {
		return coordinates3;
	}

	public void setCoordinates3(Integer coordinates3) {
		this.coordinates3 = coordinates3;
	}

	public Date getTimeOfOccurrence() {
		return timeOfOccurrence;
	}
	
	public String getFirmwareVersion() {
		return firmwareVersion;
	}




	public void setFirmwareVersion(String firmware) {
		this.firmwareVersion = firmware;
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

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

    public boolean dontAddData(){
		return isItTrue;
	}
	@Override
	public List<String> l1(String nothing) {
		l1.add("equipment");
		l1.add("duty");
		l1.add("canVariables");
		return l1;
	}



	@Override
	public String toString() {
		return "LatestTelemetries [id=" + id + ", Mongo_ID=" + Mongo_ID + ", equipment=" + equipment + ", coordinates="
				+ coordinates + ", coordinates2=" + coordinates2 + ", coordinates3=" + coordinates3
				+ ", timeOfOccurrence=" + timeOfOccurrence + ", timeOfReception=" + timeOfReception + ", heading="
				+ heading + ", speed=" + speed + ", type=" + type + ", duties=" + duties + ", CanVariablesL="
				+ CanVariablesL + ", firmware=" + firmwareVersion + ", l1=" + l1 + ", additionalProperties="
				+ additionalProperties + "]";
	}

	

	

}