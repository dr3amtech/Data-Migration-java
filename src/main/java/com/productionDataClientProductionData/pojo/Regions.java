package com.productionDataClientProductionData.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.productionDataClientProductionData.impl.ApiSuperClass;

@Entity
@Table(name = "Regions")
public class Regions implements ApiSuperClass ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Regions(){}
	
	
public Regions(String id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}

@Id
@Column(name ="id")
private  String id;



@Column(name="Code")
private  String code;


@Column(name="description")
private String description;


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


@Override
public String toString() {
	return "Regions [id=" + id + ", code=" + code + ", description=" + description + "]";
}




@Override
public List<String> l1(String nothing) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Map<? extends String, ? extends Object> getAdditionalProperties() {
	// TODO Auto-generated method stub
	return null;
}
}
