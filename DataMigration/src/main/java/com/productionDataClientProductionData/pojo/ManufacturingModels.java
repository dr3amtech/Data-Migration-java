package com.productionDataClientProductionData.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class ManufacturingModels implements Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String Id;
	public static String getId() {
		return Id;
	}
	public static void setId(String id) {
		Id = id;
	}
	
	
	
	
	
}
