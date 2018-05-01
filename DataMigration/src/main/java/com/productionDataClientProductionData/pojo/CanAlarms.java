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
@Table(name="CanAlarms")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "valueThreshold", "timeThreshold", "comparator", "created", "deleted", "createRequested",
		"archiveRequested", "archived", "links", "properties" })
public class CanAlarms implements ApiSuperClass,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CanAlarms() {
		
	}
	



public CanAlarms(String id, Float valueThreshold, Integer timeThreshold, Integer comparator, Boolean created,
			Boolean deleted, Boolean createRequested, Boolean archiveRequested, Boolean archived,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.valueThreshold = valueThreshold;
		this.timeThreshold = timeThreshold;
		this.comparator = comparator;
		this.created = created;
		this.deleted = deleted;
		this.createRequested = createRequested;
		this.archiveRequested = archiveRequested;
		this.archived = archived;
		this.additionalProperties = additionalProperties;
	}




@Id
@JsonProperty("id")
private String id;
	@Column(name="valueThreshold")
	@JsonProperty("valueThreshold")
	private Float valueThreshold;
	
	@Column(name = "timeThreshold")
	@JsonProperty("timeThreshold")
	private Integer timeThreshold;
	
	
	@Column(name="comparator")
	@JsonProperty("comparator")
	private Integer comparator;
	@Column(name = "created")
	@JsonProperty("created")
	private Boolean created;
	@Column(name = "deleted")
	@JsonProperty("deleted")
	private Boolean deleted;
	@Column(name = "createRequested")
	@JsonProperty("createRequested")
	private Boolean createRequested;
	@Column(name = "archiveRequested")
	@JsonProperty("archiveRequested")
	private Boolean archiveRequested;
	@Column(name = "archived")
	@JsonProperty("archived")
	private Boolean archived;
	
//	 @OneToOne(cascade =CascadeType.ALL)
//	 private CanVariables canVariables;
//	
//	@OneToOne(cascade =CascadeType.ALL)
//	@JsonProperty("equipment")
//	private Equipment equipment;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
		
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public List<String> l1(String nothing){
		l1.add("equipment");
		l1.add("canVariable");
		return l1;
	}

	@JsonProperty("id")
	public Object getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("valueThreshold")
	public Object getValueThreshold() {
		return valueThreshold;
	}

	@JsonProperty("valueThreshold")
	public void setValueThreshold(Float valueThreshold) {
		this.valueThreshold = valueThreshold;
	}

	@JsonProperty("timeThreshold")
	public Object getTimeThreshold() {
		return timeThreshold;
	}

	@JsonProperty("timeThreshold")
	public void setTimeThreshold(Integer timeThreshold) {
		this.timeThreshold = timeThreshold;
	}

	@JsonProperty("comparator")
	public Object getComparator() {
		return comparator;
	}

	@JsonProperty("comparator")
	public void setComparator(Integer comparator) {
		this.comparator = comparator;
	}

	@JsonProperty("created")
	public Object getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(Boolean created) {
		this.created = created;
	}

	@JsonProperty("deleted")
	public Object getDeleted() {
		return deleted;
	}

	@JsonProperty("deleted")
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@JsonProperty("createRequested")
	public Object getCreateRequested() {
		return createRequested;
	}

	@JsonProperty("createRequested")
	public void setCreateRequested(Boolean createRequested) {
		this.createRequested = createRequested;
	}

	@JsonProperty("archiveRequested")
	public Object getArchiveRequested() {
		return archiveRequested;
	}

	@JsonProperty("archiveRequested")
	public void setArchiveRequested(Boolean archiveRequested) {
		this.archiveRequested = archiveRequested;
	}

	@JsonProperty("archived")
	public Object getArchived() {
		return archived;
	}

	@JsonProperty("archived")
	public void setArchived(Boolean archived) {
		this.archived = archived;
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
		return "CanAlarms [id=" + id + ", valueThreshold=" + valueThreshold + ", timeThreshold=" + timeThreshold
				+ ", comparator=" + comparator + ", created=" + created + ", deleted=" + deleted + ", createRequested="
				+ createRequested + ", archiveRequested=" + archiveRequested + ", archived=" + archived + ", l1=" + l1
				+ ", additionalProperties=" + additionalProperties + "]";
	}

	

//	public Equipment getEquipments() {
//		return equipment;
//	}
//
//	public void setEquipments(Equipment equipment) {
//		this.equipment = equipment;
//	}

//	public CanVariables getCanVariable() {
//		return canVariables;
//	}
//
//	public void setCanVariable(CanVariables canVariable) {
//		this.canVariables = canVariable;
//	}



	
	
}