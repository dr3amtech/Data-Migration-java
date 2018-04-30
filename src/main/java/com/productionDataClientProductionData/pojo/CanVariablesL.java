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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;
@Entity
@Table(name = "CanVariableEnum")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id","canId","name","resloution","computeOffset","rangeMin","rangeMax","scale","links" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class CanVariablesL implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -384574388462587626L;

	private static Logger logger = LogManager.getLogger(com.productionDataClientProductionData.pojo.CanVariablesL.class.getName());
	
	public CanVariablesL() {
		
	}


	



	public CanVariablesL(Long canId, String name, Long resloution, Long computeOffset, Long rangeMin, Long rangeMax,
			Long scale, Date timeOfOccurrence, StandardUnits standardUnits, Double value) {
		super();
		this.canId = canId;
		this.name = name;
		this.timeOfOccurrence = timeOfOccurrence;
		this.value = value;
	}






	@Id
	@SequenceGenerator(name = "generator", sequenceName = "MY_SEQ")@GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
	@Column(name = "canId", updatable=true, nullable = false,insertable=true)
	private Long canId;
	
//	@Column(name="MongoID")
//	private String id;
	@Column(name ="Can_Name")
	@JsonProperty("name")
	private String name;
	@Column(name="timeOfOccurrence")
	private Date timeOfOccurrence;
	@Column(name ="Value")
	@JsonProperty("value")
	private Double value;
	@Transient 
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	
	
	public Long getCanId() {
		return canId;
	}






	public void setCanId(Long canId) {
		this.canId = canId;
	}

//	public String getId() {
//		return id;
//	}






//	public void setId(String id) {
//		this.id = id;
//	}










	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	






	public Double getValue() {
		return value;
	}






	
	@JsonIgnore
	public void setValue(Long value) {
		this.value = value.doubleValue();
	}
	@JsonIgnore
	public void setValue(Double value) {
		this.value = value.doubleValue();
	}
	public void setValue(Integer value) {
		this.value = value.doubleValue();
	}





	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


	public Date getTimeOfOccurrence() {
		return timeOfOccurrence;
	}


	public void setTimeOfOccurrence(String timeOfOccurrence) {
		
		
		try {
		this.timeOfOccurrence = simpleDateFormat.parse(timeOfOccurrence);
		}catch(ParseException e) {
			logger.catching(e);
		}
		}






	


	public void setTimeOfOccurrence(Date timeOfOccurrence) {
		this.timeOfOccurrence = timeOfOccurrence;
	}






	@Override
	public List<String> l1(String nothing) {
		l1.add("standardUnits");
		return l1;
	}






	@Override
	public String toString() {
		return "CanVariablesL [canId=" + canId + ", name=" + name + ", timeOfOccurrence=" + timeOfOccurrence
				+ ", value=" + value + "]";
	}








	
	

}