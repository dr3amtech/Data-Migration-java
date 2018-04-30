package com.productionDataClientProductionDataMain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.productionDataClientProductionData.Service.ServiceImpl;
import com.productionDataClientProductionData.impl.Service;

public class StartByBatch {
	private static int statusTracker = 0;
	static Logger logger = LogManager
			.getLogger(com.productionDataClientProductionDataMain.StartByBatch.class.getName());
	// static Service serviceI = new ServiceImpl();
	public static void main(String[] args) {
		int statusTracker =0;
		Service serviceI = new ServiceImpl();
//		// process data
//		int[] storage = {0,1000,2000};
//		for(int x =0;x<storage.length;x++){
//		serviceI.DataCollection(storage[x]);
//		}
		long startTime = System.currentTimeMillis();
		logger.debug("Starting to Read Files");
		statusTracker = statusTracker+serviceI.fileReader(statusTracker);
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		totalTime = totalTime/60000;
		
		serviceI.sendMail("Data Migration has Ended -\nNumber of updated Items: "+statusTracker+"\nProcess Time(MIN) : "+totalTime+"\n");
		logger.info("-------PRODUCTION DATA COLLECTION COMPLETED-------");
	}
	// Service serviceStart = new ServiceImpl();
	// serviceStart.getApiCalls();
	// log complete if complete

}
