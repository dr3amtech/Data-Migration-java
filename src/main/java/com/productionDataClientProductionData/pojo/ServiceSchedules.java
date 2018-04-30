package com.productionDataClientProductionData.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="ServiceSchedules")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "initialServiceHours", "recurringServiceHours" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceSchedules implements ApiSuperClass {

	public ServiceSchedules() {

	}

	public ServiceSchedules(String id, Long initialServiceHours, Long recurringServiceHours,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.initialServiceHours = initialServiceHours;
		this.recurringServiceHours = recurringServiceHours;
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "ServiceSchedules [id=" + id + ", initialServiceHours=" + initialServiceHours
				+ ", recurringServiceHours=" + recurringServiceHours + ", additionalProperties=" + additionalProperties + "]";
	}
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name ="InitialServiceHours")
	@JsonProperty("initialServiceHours")
	private Long initialServiceHours;
	@Column(name="reccurningServiceHours")
	@JsonProperty("recurringServiceHours")
	private Long recurringServiceHours;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("initialServiceHours")
	public Long getInitialServiceHours() {
		return initialServiceHours;
	}

	@JsonProperty("initialServiceHours")
	public void setInitialServiceHours(Long initialServiceHours) {
		this.initialServiceHours = initialServiceHours;
	}

	@JsonProperty("recurringServiceHours")
	public Long getRecurringServiceHours() {
		return recurringServiceHours;
	}

	@JsonProperty("recurringServiceHours")
	public void setRecurringServiceHours(Long recurringServiceHours) {
		this.recurringServiceHours = recurringServiceHours;
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
	public List<String> l1(String nothing) {
		return l1;
	}

}