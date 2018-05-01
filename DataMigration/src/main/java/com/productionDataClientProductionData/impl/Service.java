package com.productionDataClientProductionData.impl;


import java.util.Date;
import java.util.Map;

public interface Service {
	
	
	
	public Map<String, String>  getApiCalls();
	public void getJSonObject ();
	public void DataCollection(int offSet);
	public Object trackerCollection(Object Key);
	public Object equipmentCollection(Object Key);
	public Object subDataCollection(Map<String,Object> newMap,Object thisi,Class<?> cl); 
	public void wirteToFile(Object tempObject);
	public int getFilesNumber();
	//public void storeData();
	public int fileReader(int status);
	public void sendMail(String body);
}
