package com.productionDataClientProductionData.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.productionDataClientProductionData.impl.AlgService;

public class AlgServiceImpl implements AlgService {
	private static Map<Integer,Map<Integer,Object>> automaticIterationMap = new TreeMap<Integer,Map<Integer,Object>>();
	private static Map<Integer, Object> automaticGeneration = new LinkedHashMap<Integer, Object>();

	@Override
	public void reset(int[] array, int i) {
		//for every loop we make out index equal back to torignal index
		array[i]=1;
	}
	@Override
	public void resetM(int[] array, int i) {
		//for every loop we make out index equal back to torignal index
		array[i]=1;
	}

	@Override
	public void addOne(int[] array, int i) {
		array[i]+=1;
	}
	@Override
	public void addOneM(int[] array, int i) {
		array[i]+=1;
	}

	
	@Override
	public Map<Integer,Map<Integer,Object>> solve(int[] array, int i,int iterationNumber,Map<Integer,Map<Integer,TreeMap<Integer,Object>>>newMapLinkMapFinalFinal,int xIterationTracker ) {
		//for the array size of our array length[0,0,0,....n]=x
		if(i==array.length) {
			addObjectsToProccess(array,newMapLinkMapFinalFinal,xIterationTracker);
			return null;
		}
		//->Entry<Integer,TreeMap<Integer,String>> entry of newLinkMap ->solve loop for the number of iterations [1++,2++,3,4,5....n]
		for(int k=0;k<iterationNumber;k++) {
			//how many iterations each index basically the objects or the entries of my maps the lowest nunmber
			solve(array,i+1,iterationNumber,newMapLinkMapFinalFinal,xIterationTracker);
			//add one after every addObject to process if its only 
			addOne(array,i);
		}
		
		//sets back to first index
		reset(array,i);
		
		return automaticIterationMap;
	}
	@Override
	public  Map<? extends Integer, ? extends Map<Integer, Object>> solveM(int[] array,int i,int lowestNumber,int key2,List<Object>dyListLength,int xIterationTracker,Map<Integer,Map<Integer,TreeMap<Integer,Object>>>newMapLinkMapFinalFinal,int iterationNumber) {

    	//for the array size of our array length[0,0,0.....n] = x
    	if(i==array.length) {
    		addObjectsToProccessM(array,lowestNumber,key2,dyListLength,xIterationTracker,newMapLinkMapFinalFinal);
    		return null;
    	}
    	//for the iteration number number we must handle weither its for many or one index this will be looped through many times newLinkMapsFinalFinal ->
    	//->Entry<Integer,TreeMap<Integer,String>> entry of newLinkMap ->solve loop for the number of iterations [1++,2++,3,4,5....n]
    	for(int k=0;k<iterationNumber;k++) {
    		//how many iterations each index basically the objects or the entries of my maps 
    		solveM(array,i+1, lowestNumber,key2,dyListLength,xIterationTracker,newMapLinkMapFinalFinal,iterationNumber);
    		//add one  after every addObjectToProcess if its only more then one entry from newLinkMapsFinalFinal it will never get here i will update and longer be accepted 
    		addOneM(array,i);
    	}
    	//sets back to one based on the index
    	resetM(array,i);
    
		return automaticIterationMap;
		
		
		
	}
	

	@Override
	public void addObjectsToProccess(int[] array,Map<Integer,Map<Integer,TreeMap<Integer,Object>>> newMapLinkMapFinalFinal,int xIterationTracker) {

    	automaticGeneration = new LinkedHashMap<Integer,Object>();
    	xIterationTracker++;
    	//Grabs one array of data at a time 
    	for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
    		for(Entry<Integer, TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
    				Map<Integer,TreeMap<Integer,Object>> tempMap = new TreeMap<Integer,TreeMap<Integer,Object>>();
    				tempMap.put(entry2.getKey(), entry2.getValue());
    				GetOneMap(tempMap, array,entry1.getKey(),xIterationTracker);
    			}
    	}
		

    	
    
		
	}
	@Override
	public void GetOneMap(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array,Integer key,int xIterationTracker) {
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<array.length;i++) {
    		//keeps track of index of array
    		list.add(array[i]);
    	}
    	
    	for (int index = 0; index < list.size(); index++) {
    		if(index==1) {
    			System.out.println("2");
    		}
			for (Entry<Integer, TreeMap<Integer, Object>> entry : tempMap.entrySet()) {
				if (entry.getKey().equals(index + 1)) {
					for (Entry<Integer, Object> entry2 : entry.getValue().entrySet()) {
						int num = entry2.getKey().intValue();
						if (num == list.get(index)) {
							//System.out.print(entry2.getValue() + " ");
							automaticGeneration.put(entry.getKey(), entry2.getValue());
						}
					}

				}
			}
		}
    	
    	//pass back a map of iterations store map and iteration stops duplicates 
      	 automaticIterationMap.put(xIterationTracker, automaticGeneration );
    }

	
	@Override
	public void GetOneMapM(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array, int lowestNumber,
			Integer key, int xIterationTracker,List<Object> dyListLength,int key2,Map<Integer, Map<Integer, TreeMap<Integer, Object>>> newMapLinkMapFinalFinal) {

    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<array.length;i++) {
    		//keeps track of index of array
    		list.add(array[i]);
    	}
    	boolean skip = false;
    	//waTCH
    	for (int index = 0; index < list.size(); index++) {
			for (Entry<Integer, TreeMap<Integer, Object>> entry : tempMap.entrySet()) {
				//if (entry.getKey().equals(index + 1)) {
					for (Entry<Integer, Object> entry2 : entry.getValue().entrySet()) {
						int num = entry2.getKey().intValue();
						if (num == list.get(index)) {
							if(key==lowestNumber) {
								automaticGeneration.put(entry.getKey(), entry2.getValue());
								skip=true;
							}
						}
					}

				//}
             }
		}
    	
    	if(skip) {
    	
    	for(int x=0; x<dyListLength.size();x++) {
    		xIterationTracker++;
    		Map<Integer,Object> automaticGenerationT = new TreeMap<Integer,Object>();
    		for(Entry<Integer, Object> entry1 : automaticGeneration.entrySet()) {
    		automaticGenerationT.put(entry1.getKey(), entry1.getValue());
    		automaticIterationMap.put(xIterationTracker, automaticGenerationT );
    		}
    		automaticGenerationT.put(key2, dyListLength.get(x));
    		automaticIterationMap.put(xIterationTracker, automaticGenerationT );
    		automaticGenerationT=null;
    	}
    	
    	}
    	//pass back a map of iterations store map and iteration stops duplicates 
    	
      	 skip=false;
    	
    
		
		
		
		
	}
	
	@Override
	public  Map<Integer, Map<Integer, Object>> addObjectsToProccessM(int[] array,int lowestNumber,int key2,List<Object>dyListLength,int xIterationTracker,Map<Integer, Map<Integer, TreeMap<Integer, Object>>> newMapLinkMapFinalFinal){

    	automaticGeneration = new LinkedHashMap<Integer,Object>();
    	
    	
    	//Grabs one array of data at a time 
    	for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
    		if(entry1.getKey().intValue()==38) {
    			System.out.println("jkk");
    		}
    		for(Entry<Integer, TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
    				Map<Integer,TreeMap<Integer,Object>> tempMap = new TreeMap<Integer,TreeMap<Integer,Object>>();
    				tempMap.put(entry2.getKey(), entry2.getValue());
    				GetOneMapM(tempMap, array,lowestNumber,entry1.getKey(),xIterationTracker,dyListLength,key2,newMapLinkMapFinalFinal);
    				
    			}
    		
    	}
		return automaticIterationMap;
    	

    	
    
		
		
	}
	
	
}
