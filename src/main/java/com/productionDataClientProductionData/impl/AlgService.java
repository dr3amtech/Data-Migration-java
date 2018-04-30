package com.productionDataClientProductionData.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface AlgService {
	
	public  void reset(int[] array, int i);
	public  void resetM(int[] array, int i);
	public  Map<Integer, Map<Integer, Object>> solve(int[] array, int i,int iterationNumber,Map<Integer,Map<Integer,TreeMap<Integer,Object>>>newMapLinkMapFinalFinal,int xIterationTracker );
	public  Map<? extends Integer, ? extends Map<Integer, Object>> solveM(int[] array,int i,int lowestNumber,int key2,List<Object> dyListLength,int xIterationTracker,Map<Integer,Map<Integer,TreeMap<Integer,Object>>>newMapLinkMapFinalFinal,int iterationNumber);
	public  void addOne(int[] array,int i);
	public  void addOneM(int[] array,int i);
	public  void addObjectsToProccess(int[] array,Map<Integer,Map<Integer,TreeMap<Integer,Object>>> newMapLinkMapFinalFinal,int xIterationTracker); 
	public  void GetOneMap(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array,Integer key,int xIterationTracker);
	public  void GetOneMapM(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array,int lowestNumber,Integer key,int xIterationTracker,List<Object> dyListLength,int key2,Map<Integer, Map<Integer, TreeMap<Integer, Object>>> newMapLinkMapFinalFinal);
	public  Map<Integer, Map<Integer, Object>> addObjectsToProccessM(int[] array,int lowestNumber,int key2,List<Object>dyListLength,int xIterationTracker,Map<Integer, Map<Integer, TreeMap<Integer, Object>>> newMapLinkMapFinalFinal);
	
	    	

}
