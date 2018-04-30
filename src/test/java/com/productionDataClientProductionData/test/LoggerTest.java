package com.productionDataClientProductionData.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class LoggerTest {
	@Ignore
	@Test
	public void testPerformSomeTask()throws Exception {
		
		Log4j2properties nestedclass = new Log4j2properties();
		nestedclass.performSomeTask();
	}
	
	public static class Log4j2properties{
		
		private static Logger logger = LogManager.getLogger(com.productionDataClientProductionData.test.LoggerTest.class.getName());
		public void performSomeTask() {
			logger.debug("THIS SHALL WORK THIS TIME");
			logger.info("THIS DID WORK THIS TIME");
			logger.warn("YOUR GETTING BETTER");
			logger.error("THEY GUESSED WRONG");
			logger.fatal("YOU CATCH UP *****");
			}
		
	}
	
	
	
}
