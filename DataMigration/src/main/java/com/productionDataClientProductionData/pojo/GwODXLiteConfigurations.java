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
import javax.persistence.ManyToMany;
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
@Table(name = "GwODXLiteConfigurations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "FileIdentifier","fileContents","UploadTimestamp","version" })
public class GwODXLiteConfigurations implements ApiSuperClass,Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;






	public GwODXLiteConfigurations() {
		
	}
	
	




	public GwODXLiteConfigurations(String id, String version, String fileIdentifier, String fileContents,
			String uploadTimestamp) {
		super();
		this.id = id;
		this.version = version;
		this.fileIdentifier = fileIdentifier;
		this.fileContents = fileContents;
		this.uploadTimestamp = uploadTimestamp;
	}






	@Id
	@JsonProperty("id")
	private String id;
	
	@Column(name ="Version")
	@JsonProperty("version")
	private String version;
	
	
	@Column(name ="FileIdentifier")
	@JsonProperty("fileIdentifier")
	private String fileIdentifier;
	
	@Column(name ="FileContents")
	@JsonProperty("fileContents")
	@Lob
	private String fileContents;
	
	@Column(name ="UploadTimestamp")
	@JsonProperty("uploadTimestamp")
	private String uploadTimestamp;
	
//	@ManyToMany(cascade =CascadeType.ALL)
//	private List<Models> models= new ArrayList<Models>();
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	
	
	
	
	public List<String> l1(String nothing){
		l1.add("models");
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

	@JsonProperty("fileIdentifier")
	public String getFileIdentifier() {
		return fileIdentifier;
	}
	@JsonProperty("fileIdentifier")
	public void setFileIdentifier(String fileName) {
		this.fileIdentifier = fileName;
	}
	@JsonProperty("fileContents")
	public String getFileContents() {
		return fileContents;
	}
	@JsonProperty("fileContents")
	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
	@JsonProperty("UploadTimestamp")
	public String getUploadTimestamp() {
		return uploadTimestamp;
	}
	@JsonProperty("UploadTimestamp")
	public void setUploadTimestamp(String timeStamp) {
		this.uploadTimestamp = timeStamp;
	}
	@JsonProperty("version")
	public String getVersion() {
		return version;
	}
	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}
//	
//	public List<Models> getModels() {
//		return models;
//	}
//
//	public void setModels(Models models) {
//		this.models.add(models);
//	}

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
		return "GwODXLiteConfigurations [id=" + id + ", version=" + version + ", fileIdentifier=" + fileIdentifier
				+ ", fileContents=" + fileContents + ", uploadTimestamp=" + uploadTimestamp + ", l1=" + l1
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}