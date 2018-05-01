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
@Table(name = "CanVariables")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id","canId","name","resloution","computeOffset","rangeMin","rangeMax","scale","links" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class CanVariables implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -384574388462587626L;

	private static Logger logger = LogManager.getLogger(com.productionDataClientProductionData.pojo.CanVariables.class.getName());
	
	public CanVariables() {
		
	}
	







	






	public CanVariables(String id, Long canId, String name, int resloution, Long computeOffset, Long rangeMin,
			Long rangeMax, Double scale, Date timeOfOccurrence, StandardUnits standardUnits, Double value) {
		super();
		this.id = id;
		this.canId = canId;
		this.name = name;
		this.resloution = resloution;
		this.computeOffset = computeOffset;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.scale = scale;
		this.timeOfOccurrence = timeOfOccurrence;
		this.standardUnits = standardUnits;
		this.value = value;
	}















	@Id
	private String id;
	@Column(name="canID")
	private Long canId;
	@Column(name ="Can_Name")
	@JsonProperty("name")
	private String name;
	@Column(name ="Resloution")
	@JsonProperty("resloution")
	private int resloution;
	@Column(name ="computerOffSet")
	@JsonProperty("computeOffset")
	private Long computeOffset;
	@Column(name = "rangeMin")
	@JsonProperty("rangeMin")
	private Long rangeMin;
	@Column(name ="rangeMax")
	@JsonProperty("rangeMax")
	private Long rangeMax;
	@Column(name ="scale")
	@JsonProperty("scale")
	private Double scale;
	@Column(name="timeOfOccurrence")
	private Date timeOfOccurrence;
	@OneToOne(cascade =CascadeType.ALL)
	private StandardUnits standardUnits;
//	@ManyToMany
//	private Configurations configuration;
	@Column(name ="Value")
	@JsonProperty("value")
	private Double value;
//	@ManyToMany(cascade=CascadeType.PERSIST)
//	private List<CanVariableEnumerations> CanVariableEnumerations;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}






	@JsonProperty("resloution")
	public int getResolution() {
		return resloution;
	}
	@JsonProperty("resloution")
	public void setResolution(Long resloution) {
		this.resloution = resloution.intValue();
	}
	public void setResolution(Double resloution) {
		this.resloution = resloution.intValue();
	}
	
	
	@JsonProperty("computeOffSet")
	public Long getComputeOffset() {
		return computeOffset;
	}




	@JsonProperty("computeOffSet")
	public void setComputeOffset(Long computeOffset) {
		this.computeOffset = computeOffset;
	}




	@JsonProperty("rangeMin")
	public Long getRangeMin() {
		return rangeMin;
	}




	@JsonProperty("rangeMin")
	public void setRangeMin(Long rangeMin) {
		this.rangeMin = rangeMin;
	}




	@JsonProperty("rangeMax")
	public Long getRangeMax() {
		return rangeMax;
	}




	@JsonProperty("rangeMax")
	public void setRangeMax(Long rangeMax) {
		this.rangeMax = rangeMax;
	}




	@JsonProperty("scale")
	public Double getScale() {
		return scale;
	}




	@JsonProperty("scale")
	public void setScale(Long scale) {
		this.scale = scale.doubleValue();
	}
	@JsonIgnore
	public void setScale(Double scale) {
		this.scale = scale.doubleValue();
	}
	@JsonIgnore
	public void setScale(Integer scale) {
		this.scale = scale.doubleValue();
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

//
//	public Configurations getConfiguration() {
//		return configuration;
//	}
//
//
//
//
//
//
//	public void setConfiguration(Configurations configuration) {
//		this.configuration = configuration;
//	}






	public Double getValue() {
		return value;
	}






	public void setValue(Double value) {
		this.value = value;
	}






	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	
//	
//	public List<CanVariableEnumerations> getCanVariableEnumerations() {
//		return CanVariableEnumerations;
//	}
//
//
//
//
//
//
//	public void setCanVariableEnumerations(List<CanVariableEnumerations> canVariableEnumerations) {
//		CanVariableEnumerations = canVariableEnumerations;
//	}






	public StandardUnits getStandardUnits() {
		return standardUnits;
	}
	
	public void setStandardUnits(StandardUnits standardUnit) {
		this.standardUnits = standardUnit;
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
		return "CanVariables [id=" + id + ", canId=" + canId + ", name=" + name + ", resloution=" + resloution
				+ ", computeOffset=" + computeOffset + ", rangeMin=" + rangeMin + ", rangeMax=" + rangeMax + ", scale="
				+ scale + ", timeOfOccurrence=" + timeOfOccurrence + ", standardUnits=" + standardUnits + ", value="
				+ value + ", additionalProperties=" + additionalProperties + "]";
	}





	
	

}