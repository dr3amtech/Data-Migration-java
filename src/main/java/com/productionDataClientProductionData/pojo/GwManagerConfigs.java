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
import javax.persistence.Lob;
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
@Table(name = "GwManagerConfigs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "fileContents","version" })
public class GwManagerConfigs implements ApiSuperClass,Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GwManagerConfigs(String id, String fileContents, String version, ComServiceLevels comServiceLevel,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.fileContents = fileContents;
		this.version = version;
		this.comServiceLevels = comServiceLevel;
		this.additionalProperties = additionalProperties;
	}


	@Override
	public String toString() {
		return "GwManagerConfigs [id=" + id + ", fileContents=" + fileContents + ", version=" + version
				+ ", comServiceLevel=" + comServiceLevels + ", additionalProperties=" + additionalProperties + "]";
	}


	public GwManagerConfigs() {
		
	}
	






	@Id
	@JsonProperty("id")
	private String id;
	
	@Column(name ="FileContents")
	@JsonProperty("fileContents")
	@Lob
	private String fileContents;
	
	@Column(name ="Version")
	@JsonProperty("version")
	private String version;

	@OneToOne(cascade =CascadeType.ALL)
	private ComServiceLevels comServiceLevels;
	
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	public List<String> l1(String nothing){
		l1.add("comServiceLevels");
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

	

	public String getFileContents() {
		return fileContents;
	}


	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
	
	


	public ComServiceLevels getComServiceLevels() {
		return comServiceLevels;
	}


	public void setComServiceLevels(ComServiceLevels comServiceLevel) {
		this.comServiceLevels = comServiceLevel;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
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

}