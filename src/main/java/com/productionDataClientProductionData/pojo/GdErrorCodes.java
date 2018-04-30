package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name="GdErrorCodes")
public class GdErrorCodes implements ApiSuperClass,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GdErrorCodes() {
		
	}
	

	@Id
	@JsonProperty("id")
	private static String id;
	
	
	@Column(name="ModelId")
	private static String model;
	
	@Column(name="GdErrorSeverity")
	private static int severity;
	
	@Column(name="EmssionRelated")
	private static boolean emissionRelated;
	@Column(name="description")
	private static String description;
	
	@Column(name="gdErrorCode")
	private static String gdErrorCode;
	
	
	@Column(name="gdSource")
	private static String gdSource;
	
	
	@Transient
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	public static String getId() {
		return id;
	}


	public static void setId(String id) {
		GdErrorCodes.id = id;
	}


	public static String getModel() {
		return model;
	}


	public static void setModel(String model) {
		GdErrorCodes.model = model;
	}


	public static int getSeverity() {
		return severity;
	}


	public static void setSeverity(int severity) {
		GdErrorCodes.severity = severity;
	}


	public static boolean isEmissionRelated() {
		return emissionRelated;
	}


	public static void setEmissionRelated(boolean emissionRelated) {
		GdErrorCodes.emissionRelated = emissionRelated;
	}


	public static String getDescription() {
		return description;
	}


	public static void setDescription(String description) {
		GdErrorCodes.description = description;
	}


	public static String getGdErrorCode() {
		return gdErrorCode;
	}


	public static void setGdErrorCode(String gdErrorCode) {
		GdErrorCodes.gdErrorCode = gdErrorCode;
	}


	public static String getGdSource() {
		return gdSource;
	}


	public static void setGdSource(String gdSource) {
		GdErrorCodes.gdSource = gdSource;
	}


	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}


	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}


	@Override
	public List<String> l1(String nothing) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
