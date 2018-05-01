package com.productionDataClientProductionData.pojo;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name = "Configurations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "fileName","fileContents","timestamp","trackerType","version" })
public class Configurations implements ApiSuperClass {
private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(com.productionDataClientProductionData.pojo.Configurations.class.getName());
	
	public Configurations() {
		
	}
	
public Configurations(String id, String fileName, String fileContents, Date timestamp, String trackerType,
			String version, List<CanVariables> canVariables, ComServiceLevels comServiceLevels) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileContents = fileContents;
		this.timestamp = timestamp;
		this.trackerType = trackerType;
		this.version = version;
		this.canVariables = canVariables;
		this.comServiceLevels = comServiceLevels;
	}



@Id
@JsonProperty("id")
private String id;
	
	
	@Column(name ="FileName")
	@JsonProperty("fileName")
	private String fileName;
	
	@Column(name ="FileContents")
	@JsonProperty("fileContents")
	@Lob
	private String fileContents;
	
	@Column(name ="timestamp_configuration")
	@JsonProperty("timestamp")
	private Date timestamp;
	
	@Column(name ="TrackerType")
	@JsonProperty("trackerType")
	private String trackerType;
	
	@Column(name ="Version")
	@JsonProperty("version")
	private String version;
	
//	@OneToMany(cascade =CascadeType.ALL)
//	private List<Models> models;
	
	@ManyToMany(cascade =CascadeType.ALL)
//	@JoinTable(name="Configuration_CanVariables",joinColumns={@JoinColumn(name="Configuration_id")}
//	,inverseJoinColumns= {@JoinColumn(name="canVariables_CANid")})
	private List<CanVariables> canVariables;
	
	@OneToOne(cascade =CascadeType.ALL)
	private ComServiceLevels comServiceLevels;
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

	@JsonProperty("fileName")
	public String getFileName() {
		return fileName;
	}
	@JsonProperty("fileName")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@JsonProperty("fileContents")
	public String getFileContents() {
		return fileContents;
	}
	@JsonProperty("fileContents")
	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
	@JsonProperty("timestamp")
	public Date getTimestamp() {
		return timestamp;
	}
	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		try {
		this.timestamp = simpleDateFormat.parse(timestamp);
		}catch(ParseException e) {
			logger.catching(e);
		}
	}
	@JsonProperty("trackerType")
	public String getTrackerType() {
		return trackerType;
	}
	@JsonProperty("trackerType")
	public void setTrackerType(String trackerType) {
		this.trackerType = trackerType;
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
//	public void setModels(Models models) {
//		this.models.add(models);
//	}

	public List<CanVariables> getCanVariables() {
		return canVariables;
	}

	public void setCanVariables(ArrayList<CanVariables> canVariables) {
		this.canVariables = canVariables;
	}

	public ComServiceLevels getComServiceLevels() {
		return comServiceLevels;
	}

	public void setComServiceLevels(ComServiceLevels comServiceLevel) {
		this.comServiceLevels = comServiceLevel;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Configurations [id=" + id + ", fileName=" + fileName + ", fileContents=" + fileContents + ", timestamp="
				+ timestamp + ", trackerType=" + trackerType + ", version=" + version + ", canVariables=" + canVariables
				+ ", comServiceLevels=" + comServiceLevels + "]";
	}

}