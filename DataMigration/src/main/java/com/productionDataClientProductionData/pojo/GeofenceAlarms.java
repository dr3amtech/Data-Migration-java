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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name = "GeofenceAlarms")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name" })
public class GeofenceAlarms implements ApiSuperClass,Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeofenceAlarms() {
		
	}

		


	public GeofenceAlarms(String id, Boolean created, Boolean createRequested, Boolean archiveRequested,
			Boolean archived, Integer condition, String geospatial, Double coordinates1, Double coordinates2,
			Integer externalId, String type, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.created = created;
		this.createRequested = createRequested;
		this.archiveRequested = archiveRequested;
		this.archived = archived;
		this.condition = condition;
		this.geospatial = geospatial;
		this.coordinates1 = coordinates1;
		this.coordinates2 = coordinates2;
		this.externalId = externalId;
		this.type = type;
		this.additionalProperties = additionalProperties;
	}




	@Id
	@JsonProperty("id")
	private String id;
	
	@Column(name ="Created")
	@JsonProperty("created")
	private Boolean created;
	
	@Column(name="CreateRequested")
	@JsonProperty("createRequested")
	private Boolean createRequested;
	
	@Column(name="ArchiveRequested")
	@JsonProperty("archiveRequested")
	private Boolean archiveRequested;
	
	@Column(name ="Archived")
	@JsonProperty("archived")
	private Boolean archived;
	
	@Column(name ="Condition")
	@JsonProperty("condition")
	private Integer condition;
	
	@Column(name ="Geospatial")
	@JsonProperty("Geospatial")
	private String geospatial;
	
//	@OneToOne(cascade =CascadeType.ALL)
//	@JsonProperty("equipment")
//	private Equipment equipment;
	
	@Column(name ="Coordinates1")
	@JsonProperty("coordinates1")
	private Double coordinates1;
	
	@Column(name ="Coordinates2")
	@JsonProperty("coordinates2")
	private Double coordinates2;
	
	@Column(name ="External_ID")
	@JsonProperty("externalId")
	private Integer externalId;
	
	@Column(name="Geospatial_Type")
	private String type;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<String> l1(String nothing){
		//l1.add("equipment");
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
	
	public Boolean getCreated() {
		return created;
	}

	public void setCreated(Boolean created) {
		this.created = created;
	}

	public Boolean getCreateRequested() {
		return createRequested;
	}

	public void setCreateRequested(Boolean createRequested) {
		this.createRequested = createRequested;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public String getGeospatial() {
		return geospatial;
	}

	public void setGeospatial(String geospatial) {
		this.geospatial = geospatial;
	}

//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}

	public Double getCoordinates1() {
		return coordinates1;
	}

	public void setCoordinates1(Double coordinates1) {
		this.coordinates1 = coordinates1;
	}
	
	public Boolean getArchiveRequested() {
		return archiveRequested;
	}




	public void setArchiveRequested(Boolean archiveRequested) {
		this.archiveRequested = archiveRequested;
	}




	public Double getCoordinates2() {
		return coordinates2;
	}




	public void setCoordinates2(Double coordinates2) {
		this.coordinates2 = coordinates2;
	}




	public Integer getExternalId() {
		return externalId;
	}

	public void setExternalId(Integer externalId) {
		this.externalId = externalId;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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
		return "GeofenceAlarms [id=" + id + ", created=" + created + ", createRequested=" + createRequested
				+ ", archiveRequested=" + archiveRequested + ", archived=" + archived + ", condition=" + condition
				+ ", geospatial=" + geospatial + ", coordinates1=" + coordinates1 + ", coordinates2=" + coordinates2
				+ ", externalId=" + externalId + ", type=" + type + ", l1=" + l1 + ", additionalProperties="
				+ additionalProperties + "]";
	}

}