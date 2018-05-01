package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name ="CanVariablenum")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id","name","value","enumerated"})
public class CanVariableEnumerations implements  ApiSuperClass,Serializable{
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;






@Transient	
org.apache.logging.log4j.Logger logger = LogManager.getLogger(com.productionDataClientProductionData.pojo.CanVariableEnumerations.class.getName());
	public CanVariableEnumerations() {
		
	}

	@Id
	@JsonProperty("name")
	private String name;
	
	
	
	
	@Transient
	public final List<String> l1 = new ArrayList<String>();
	
	@Transient 
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	public List<String> l1(String nothing){
		l1.add("canVariables");
		return l1;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}




	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}






	@Override
	public Map<? extends String, ? extends Object> getAdditionalProperties() {
		// TODO Auto-generated method stub
		return null;
	}
	
	






}