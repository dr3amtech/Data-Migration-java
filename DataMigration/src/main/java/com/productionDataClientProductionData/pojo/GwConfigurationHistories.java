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
@Table(name="GwConfigurationHistories")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "userName", "uploadTimestamp", "fileName","type"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GwConfigurationHistories implements  ApiSuperClass,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GwConfigurationHistories() {
		
	}
	
	public GwConfigurationHistories(String id, String userName, Date uploadTimestamp, String fileName, String type,
			Trackers tracker, Map<String, Map<String, String>> links, Object properties,
			Map<String, Object> additionalProperties) {
		super();
		this.id = id;
		this.userName = userName;
		this.uploadTimestamp = uploadTimestamp;
		this.fileName = fileName;
		this.type = type;
		this.trackers = tracker;
		this.additionalProperties = additionalProperties;
	}

	@Override
	public String toString() {
		return "GwConfigurationHistories [id=" + id + ", userName=" + userName + ", uploadTimestamp=" + uploadTimestamp
				+ ", fileName=" + fileName + ", type=" + type + ", tracker=" + trackers + ", additionalProperties=" + additionalProperties + "]";
	}
	@Id
	@JsonProperty("id")
	private String id;
	@Column(name ="UserName")
	@JsonProperty("userName")
	private String userName;
	@Column(name="UploadYimeStamp")
	@JsonProperty("uploadTimestamp")
	private Date uploadTimestamp;
	@Column(name="FileName")
	@JsonProperty("fileName")
	private String fileName;
	@Column(name="Type")
	@JsonProperty("type")
	private String type;
	@OneToOne(cascade =CascadeType.ALL)
	@JsonIgnore
	private Trackers trackers;
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	@Transient
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public List<String> l1(String nothing){
		l1.add("tracker");
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
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}
	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonProperty("uploadTimestamp")
	public Date getUploadTimestamp() {
		return uploadTimestamp;
	}
	@JsonProperty("uploadTimestamp")
	public void setUploadTimestamp(String uploadTimestamp) {
		try {
			this.uploadTimestamp= simpleDateFormat.parse(uploadTimestamp.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@JsonProperty("fileName")
	public String getFileName() {
		return fileName;
	}
	@JsonProperty("fileName")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public Trackers getTrackers() {
		return trackers;
	}

	public void setTrackers(Trackers tracker) {
		this.trackers = tracker;
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