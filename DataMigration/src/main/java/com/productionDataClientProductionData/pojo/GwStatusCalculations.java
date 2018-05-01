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
@Table(name = "GwStatusCalculations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "fileName","fileContents","timestamp","trackerType","version" })
public class GwStatusCalculations implements ApiSuperClass ,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public GwStatusCalculations() {
		
	}
	
	

	public GwStatusCalculations(String id, String fileIdentifier, String fileContents, Date uploadTimestamp,
			String version, Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.fileIdentifier = fileIdentifier;
		this.fileContents = fileContents;
		this.uploadTimestamp = uploadTimestamp;
		this.version = version;
		this.additionalProperties = additionalProperties;
	}



	@Id
	@JsonProperty("id")
	private String id;
	
	
	@Column(name ="FileIdentifier")
	@JsonProperty("fileIdentifier")
	private String fileIdentifier;
	
	@Column(name ="FileContents")
	@JsonProperty("fileContents")
	@Lob
	private String fileContents;
	
	@Column(name ="UploadTimestamp")
	@JsonProperty("uploadTimestamp")
	private Date uploadTimestamp;
	
	
	@Column(name ="Version")
	@JsonProperty("version")
	private String version;
	
//	@ManyToMany(cascade =CascadeType.ALL)
//	private List<Models> models = new ArrayList<Models>();
//	
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
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
	public Date getUploadTimestamp() {
		return uploadTimestamp;
	}
	@JsonProperty("UploadTimestamp")
	public void setUploadTimestamp(String timeStamp) {
		try {
			this.uploadTimestamp= simpleDateFormat.parse(timeStamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@JsonProperty("version")
	public String getVersion() {
		return version;
	}
	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}
	
//	public List<Models> getModels() {
//		return models;
//	}
//
//	public void setModels(ArrayList<Models> models) {
//		this.models = models;
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
	public List<String> l1(String nothing) {
		l1.add("models");
		return l1;
	}



	@Override
	public String toString() {
		return "GwStatusCalculations [id=" + id + ", fileIdentifier=" + fileIdentifier + ", fileContents="
				+ fileContents + ", uploadTimestamp=" + uploadTimestamp + ", version=" + version + ", l1=" + l1 + "]";
	}
	
	

}