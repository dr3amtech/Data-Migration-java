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
import javax.persistence.ManyToOne;
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
@Table(name="Equipment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "description", "serviceLevel", "identificationNumber", "allowDataSharing", "hasSeenBefore",
		"links", "properties","ManufacturingDate" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Equipment implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Equipment() {
		
	}
	
	private static Logger logger = LogManager.getLogger(com.productionDataClientProductionData.pojo.Equipment.class.getName());



	public Equipment(String id, Date manufacturingDate, String description, Models models, Owners owners,
			String manufacturingLocations, String manufacturingModels, Long serviceLevel, String identificationNumber,
			Boolean allowDataSharing, Boolean hasSeenBefore) {
		super();
		this.id = id;
		this.manufacturingDate = manufacturingDate;
		this.description = description;
		this.models = models;
		this.owners = owners;
		this.manufacturingLocations = manufacturingLocations;
		this.manufacturingModels = manufacturingModels;
		this.serviceLevel = serviceLevel;
		this.identificationNumber = identificationNumber;
		this.allowDataSharing = allowDataSharing;
		this.hasSeenBefore = hasSeenBefore;
	}















	/**
	 * @param manufacturingDate
	 */
	public void setManufacturingDate(String manufacturingDate) {
		try {
			this.manufacturingDate = simpleDateFormat.parse(manufacturingDate);
			}catch(ParseException e) {
				logger.catching(e);
			}
		
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
//	
//	
//	@SequenceGenerator(name = "generator", sequenceName = "MY_SEQ")@GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
//	@Column(name = "id", updatable=true, nullable = false)
//	private Long TI;
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name="ManuFacturingDate")
	@JsonProperty("manufacturingDate")
	private Date manufacturingDate;
	@Column(name="Description")
	@JsonProperty("description")
	private String description;
//	@ManyToOne(cascade =CascadeType.ALL)
//	@JsonIgnore
//	private Dealers dealers;
	@ManyToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Models models;
	@ManyToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Owners owners;
	@Column(name="ManufacturingLocId")
	private String manufacturingLocations;
	@Column(name="ManufacturingModelsId")
	private String manufacturingModels="manufacturingModels";
	
	@Column(name="ServiceLevel")
	@JsonProperty("serviceLevel")
	private Long serviceLevel;
	@Column(name="identifiicationNumber")
	@JsonProperty("identificationNumber")
	private String identificationNumber;
	@Column(name = "allowDataSharing")
	@JsonProperty("allowDataSharing")
	private Boolean allowDataSharing;
	@Column(name="HasSeenBefore")
	@JsonProperty("hasSeenBefore")
	private Boolean hasSeenBefore;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient 
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("dealers");
		l1.add("manufacturingLocations");
		l1.add("manufacturingModels");
		l1.add("modules");
		l1.add("owners");
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

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("serviceLevel")
	public Long getServiceLevel() {
		return serviceLevel;
	}

	@JsonProperty("serviceLevel")
	public void setServiceLevel(Long serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	@JsonProperty("identificationNumber")
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	@JsonProperty("identificationNumber")
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	@JsonProperty("allowDataSharing")
	public Boolean getAllowDataSharing() {
		return allowDataSharing;
	}

	@JsonProperty("allowDataSharing")
	public void setAllowDataSharing(Boolean allowDataSharing) {
		this.allowDataSharing = allowDataSharing;
	}

	@JsonProperty("hasSeenBefore")
	public Boolean getHasSeenBefore() {
		return hasSeenBefore;
	}

	@JsonProperty("hasSeenBefore")
	public void setHasSeenBefore(Boolean hasSeenBefore) {
		this.hasSeenBefore = hasSeenBefore;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}


	public Models getModels() {
		return models;
	}

	public void setModels(Models model) {
		this.models = model;
	}

	public Owners getOwners() {
		return owners;
	}

	public void setOwners(Owners owner) {
		this.owners = owner;
	}

	public String getManufacturingLocation() {
		return manufacturingLocations;
	}

	public void setManufacturingLocations(String manufacturingLocations) {
		this.manufacturingLocations = manufacturingLocations;
	}

	public String getManufacturingModels() {
		return manufacturingModels;
	}

	public void setManufacturingModels(String manufacturingModels) {
		this.manufacturingModels = manufacturingModels;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}



	@Override
	public String toString() {
		return "Equipment [id=" + id + ", manufacturingDate=" + manufacturingDate + ", description=" + description
				+ ", models=" + models + ", owners=" + owners + ", manufacturingLocations=" + manufacturingLocations
				+ ", manufacturingModels=" + manufacturingModels + ", serviceLevel=" + serviceLevel
				+ ", identificationNumber=" + identificationNumber + ", allowDataSharing=" + allowDataSharing
				+ ", hasSeenBefore=" + hasSeenBefore + "]";
	}

	
}