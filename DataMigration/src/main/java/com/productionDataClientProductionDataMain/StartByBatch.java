package com.productionDataClientProductionDataMain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.productionDataClientProductionData.Service.ServiceImpl;
import com.productionDataClientProductionData.impl.Service;

public class StartByBatch {
	
	//Declare GLobal Variable
	private static int statusTracker;
	
	//Declaring Logging File
	static Logger logger = LogManager
			.getLogger(com.productionDataClientProductionDataMain.StartByBatch.class.getName());
	
	
	public static void main(String[] args) {
		//Service class to handle action between service and database
		Service serviceI = new ServiceImpl();
		
		//Track Migration time
		long startTime = System.currentTimeMillis();
		
		//LOGGER
		logger.debug("Starting to Read Files");
		
		//fileReader Method returning how many objects have been inserted into the database
		statusTracker = statusTracker+serviceI.fileReader(statusTracker);
		
		//End Time
		long endTime   = System.currentTimeMillis();
		
		
		//Total Time
		long totalTime = endTime - startTime;
		
		//total time in mins 
		totalTime = totalTime/60000;
		
		
		//email notification
		serviceI.sendMail("Data Migration has Ended -\nNumber of updated Items: "+statusTracker+"\nProcess Time(MIN) : "+totalTime+"\n");
		
		
		//logger
		logger.info("-------PRODUCTION DATA COLLECTION COMPLETED-------");
	}
	

}
