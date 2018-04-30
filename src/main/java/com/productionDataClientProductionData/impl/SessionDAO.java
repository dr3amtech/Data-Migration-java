package com.productionDataClientProductionData.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.productionDataClientProductionData.pojo.Trackers;

public interface SessionDAO extends Serializable {
	
	
	boolean updateObjects(LinkedList<Object> ObjectList);
	public  LinkedList<Object> setObject(Map<Integer,Object> documentList2);
	public void closeSession();
	Map<Integer, Object> checkForUpdate(Map<Integer, Object> documentList2,boolean tr);


}
