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
@Table(name="EngineData")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "onTimestamp", "offTimestamp" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineData implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EngineData() {
		
	}
	





	public EngineData(String id, Date onTimestamp, Date offTimestamp, Equipment equipment,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.onTimestamp = onTimestamp;
		this.offTimestamp = offTimestamp;
		this.equipment = equipment;
		this.additionalProperties = additionalProperties;
	}






	@Override
	public String toString() {
		return "EngineData [id=" + id + ", onTimestamp=" + onTimestamp + ", offTimestamp=" + offTimestamp
				+ ", equipment=" + equipment
				+ ", additionalProperties=" + additionalProperties + "]";
	}


	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@Id
//	@SequenceGenerator(name = "generator", sequenceName = "MY_SEQ")@GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
//	@Column(name = "id", updatable=true, nullable = false)
//	private Long TI;
	
	@JsonProperty("id")
	private String id;
	@Column(name = "onTimeStamp")
	@JsonProperty("onTimestamp")
	private Date onTimestamp;
	@Column(name = "OffTimeStamp")
	@JsonProperty("offTimestamp")
	private Date offTimestamp;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Equipment equipment;
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
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
	
	
	@JsonProperty("onTimestamp")
	public Date getOnTimestamp() {
		return onTimestamp;
	}


	@JsonProperty("onTimestamp")
	public void setOnTimestamp(String onTimestamp) {
	try {
			
		this.onTimestamp = simpleDateFormat.parse(onTimestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@JsonProperty("offTimestamp")
	public Date getOffTimestamp() {
		return offTimestamp;
	}


	@JsonProperty("offTimestamp")
	public void setOffTimestamp(String offTimestamp) {
	try {
			
			this.offTimestamp	=simpleDateFormat.parse(offTimestamp);
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


	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}



}