package com.productionDataClientProductionData.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.productionDataClientProductionData.DAO.SessionDaoImpl;
import com.productionDataClientProductionData.Service.ServiceImpl;
import com.productionDataClientProductionData.impl.Service;
import com.productionDataClientProductionData.impl.SessionDAO;
import com.productionDataClientProductionData.pojo.LatestTelemetries;

public class ServiceImplTest {
	
	private static Service serviceI = new ServiceImpl();
	@Test
	public void getApiCallsTest() throws IOException {
		boolean facts = true;
			
	Map<String,String> map = serviceI.getApiCalls();
	if(map.isEmpty()) {
		facts =false;
	}
		assertEquals(true ,facts);
	}
	
	@Test 
	public void getJSonObjectTest(){	
		//Object  obj = serviceI.getJSonObject();
		Object  obj = null;
		boolean facts = false; 
		//set object
		LatestTelemetries latestTelemetries = new LatestTelemetries();
		if(obj.getClass().getSimpleName().equals(latestTelemetries.getClass().getSimpleName())) {
			facts =true;
		}
		assertEquals(true, facts);
	}
	@Test
	public void Datacollectiontest() {
		int[] offSet = {0,1000,2000};
		for(int y =0; y<offSet.length;y++) {
		serviceI.DataCollection(offSet[y]);
		}
	}
	@Test 
	public void fileString() {
		serviceI.getJSonObject();
	}
	@Test
	public void checkForUpdate(){
		Map<Integer,Object> documentList2 = new TreeMap<Integer,Object>();
		SessionDAO sessiondao = new SessionDaoImpl();
		LatestTelemetries lT = new LatestTelemetries();
		lT.setId("59f8d3b0e0dbc48640fbf179");
		lT.setTimeOfOccurrence("2017-11-02T17:22:36.000Z");
		documentList2.put(0, lT);
		//sessiondao.checkForUpdate(documentList2);
	}
	
	
	
	@Test
	public void getCurrentDateTest() {
		serviceI.getApiCalls();
	}
	@Test
	public void writetToFiles() {
		//serviceI.writeToFile();
	}
	
	@Test 
	public void FileReader()
	{
	Service si = new ServiceImpl();
	int statusTracker=0;
	statusTracker =statusTracker+si.fileReader(statusTracker);
	
	}
	
	@Test
	  public void fileReaderT() throws Exception,ClassNotFoundException,IOException{   
		  File fileDir = new File("D:\\TempJSONObject/");
		  File[] file = fileDir.listFiles();
//		  Object tempObject;
//		  JSONParser parser = new JSONParser();
//		  ObjectMapper mapper = new ObjectMapper();
//		  mapper.configure(MapperFeature.USE_ANNOTATIONS,true);
//			Class<?> cl;
//				//reflect on the given class 
		  Service si = new ServiceImpl();
//				 cl = Class.forName("com.productionDataClientProductionData.pojo.LatestTelemetries");
		  for(int x =0;x<file.length;x++) {
			 FileInputStream fs = new  FileInputStream(file[x].getPath());
			 ObjectInputStream in = new ObjectInputStream(fs);
			 List<?> list =(ArrayList<?>) in.readObject();
			 for(int xx=0; x<list.size();xx++) {
				 System.out.println(list.get(xx));
				Object object =  si.equipmentCollection(((LinkedHashMap<?,?>) list.get(xx)).get("id"));
				System.out.println(object);
			 }
			 System.out.println(list.toString());
			 // tempObject =  mapper.readValue(parser.parse(new FileReader(file[x].getPath())).toString(),cl);
          //FileReader fr=new FileReader(file[x].getPath());
         // BufferedReader bf = new Input
			 
		  }
      
}
}