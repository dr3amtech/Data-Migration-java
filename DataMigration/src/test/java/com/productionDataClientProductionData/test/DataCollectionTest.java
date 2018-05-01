package com.productionDataClientProductionData.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.client.ClientProtocolException;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productionDataClientProductionData.impl.ApiSuperClass;

/**
 * Unit test for simple App.
 */

@Ignore
public class DataCollectionTest implements Serializable
   {
	private static Object thisi=null;
	static int trackerCollection=0;
	//global to handle storeAllData method N 
	private static int n=0;
    Properties properties = null;
    private static List<Object> test = new LinkedList<Object>();
    static List<String> badDataList = new ArrayList<String>();
   private static Map<Integer,Object> documentList2=new TreeMap<Integer,Object>();
	private static List<String> vollist = new ArrayList<String>();
	private static Map<String,String> propertiesMap = new TreeMap<String,String>();
	public  static ConnectionTest test1  =null;
	//integers help us keep track of what we already did when time for creating objects
	static Map<Integer,TreeMap<Integer,Object>> newMapLinkMapFinal = new HashMap<Integer,TreeMap<Integer,Object>>();
	static Map<Integer,Map<Integer,TreeMap<Integer,Object>>> newMapLinkMapFinalFinal = new TreeMap<Integer,Map<Integer,TreeMap<Integer,Object>>> ();
	private static Map<Integer, Object> automaticGeneration = new LinkedHashMap<Integer, Object>();
	private static Integer xIterationTracker = 1;
	private static Map<Integer,Map<Integer,Object>> automaticIterationMap = new TreeMap<Integer,Map<Integer,Object>>();
	private static Map<Integer, Map<Integer, String>> numbersToAdd = new TreeMap<Integer,Map<Integer,String>>();
	private static LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>> linkChild = new LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>();
	private static LinkedHashMap<LinkedHashMap<String, LinkedHashMap<String, Object>>, String> linkLostChild = new LinkedHashMap<LinkedHashMap<String,LinkedHashMap<String,Object>>,String>();
	private static Map<Object,LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>> hiddenLinksMap = new LinkedHashMap<Object,LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>>();
	static WebTarget webR=null;
	static ObjectMapper mapper = new ObjectMapper();
	private static boolean runit = true;
	String newString ="";
	private static int iterationNumber=0;
	private static int middleGround=0;
	private static List<Object> dyListLength = new ArrayList<Object>();
	private static String packName = "com.productionDataClientProductionData.pojo.";
	private static boolean areThereMore = true;
	private static List<String> newLostType = new ArrayList<String>();
	private static String notDone =null;
	private static Map<String,List<String>> notDoneMap = new LinkedHashMap<String,List<String>>();
	@Ignore
    @Test
    public void TestGetApICollection() {
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	boolean test = false;
    	InputStream input = loader.getResourceAsStream("APIs.properties");
    	StringBuilder sb = new StringBuilder();
    	BufferedReader bf = new BufferedReader(new InputStreamReader(input));
    	try {
    		//returns back 0-65535 or -1 for end of line
			for(int c; (c=bf.read())!=-1;) {
				if(c!=0) {//0 is a space
				sb.append((char)c);
				}
			}
			
			String[] places =sb.toString().split("\\r\\n");
	    	for(int x =0; x<places.length;x++) {
	    	String[] temp=	places[x].split("=");
	    	propertiesMap.put(temp[0], temp[1]);
	    	test =true;
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    

   
   assertEquals(true, test);
    }
	
	@Ignore
	@Test
	public void getLinks() throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	String packName = "com.productionDataClientProductionData.pojo.";
	
	
	
	ClientConfig cC = new ClientConfig();
	Client client = ClientBuilder.newClient(cC);
	HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder().credentials("ADMTHREE.AC2OA@gmail.com", "password1234").build();
	webR = client.target(UriBuilder.fromUri("http://agco-fuse-trackers-test.herokuapp.com").build());
	webR.register(access);
	
	
	
	for(Entry<String,String> property : propertiesMap.entrySet()){
	mapper.configure(MapperFeature.USE_ANNOTATIONS, true);
	Class<?> cl = Class.forName(packName.trim()+property.getKey().toString().trim());
		
	//check try catch for changed field 
	 Object	tempCheck = mapper.readValue(webR.path(property.getValue().toString().trim()).queryParam(property.getValue().toString().trim()+"305ad8b6-cafc-4e80-8273-f9c4ea88bdbd").request(MediaType.APPLICATION_JSON).get(String.class),cl);
	 HashMap<? extends Object, ? extends Object> entryMap =(HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) tempCheck).getAdditionalProperties();
	if(!tempCheck.toString().contains("links")){
	System.out.println(property.getKey());
	}
	
	for(Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()){
	     // System.out.println(entry.getKey()+"-"+entry.getValue());
	      
	  try {
		  int LinksTracker =0;
	      System.out.println(entry.getKey());
	      List<String> LinkTrackerList = new ArrayList<String>();
	      for(Entry<?,?> entryLinks : ((LinkedHashMap<?,?>) entry.getValue()).entrySet()){
	    	//  for(Entry<?,?> entryEntryLinks :((LinkedHashMap<?,?>) entryLinks.getValue()).entrySet()) {
	    	  LinksTracker++;
	    	  LinkTrackerList.add(entryLinks.getKey().toString());
	    	//  }
	    	  
	      }
	      System.out.println("Object: "+property.getKey()+" Has "+LinksTracker);
	      for(String it : LinkTrackerList) {
	    	  System.out.println(it);
	      }
	  }catch(ClassCastException cee) {
		  
	  }

	}
	}
	}
	@Ignore
	@Test
	public void getEqupipmentTest() throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	List<String> news = new ArrayList<String>();
		Class[] cLarg = new Class[1];
		cLarg[0] = String.class;
		
		ClientConfig cC = new ClientConfig();
		Client client = ClientBuilder.newClient(cC);
		HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder().credentials("ADMTHREE.AC2OA@gmail.com", "password1234").build();
		 webR = client.target(UriBuilder.fromUri("http://agco-fuse-trackers-test.herokuapp.com").build());
		webR.register(access);
		
		
		//System.out.println("Start");
		for(Entry<String,String> property : propertiesMap.entrySet()){
			test1  = new ConnectionTest();
			news = new ArrayList<String>();
			boolean time = true;
			mapper.configure(MapperFeature.USE_ANNOTATIONS, true);
			//Class<?> cl = Class.forName(packName.trim()+"CanAlarms");
			Class<?> cl = Class.forName(packName.trim()+property.getKey().toString().trim());
			
		//check try catch for changed field 
		 Object	tempCheck = mapper.readValue(webR.path(property.getValue().toString().trim()).request(MediaType.APPLICATION_JSON).get(String.class),cl);
	
		
		 
			DataCollectionTest.StoreInsideOfObject(cl,cLarg[0],tempCheck);

		
		
	}
		
			
	}
	
	public static void StoreInsideOfObject(Class<?> cl,Class<?> cLarg,Object tempCheck) throws JsonParseException, JsonMappingException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		Map<String,Object> newMap = new LinkedHashMap<String,Object>();
		Set<String> linkTrackerSetter=new HashSet<String>();
		Set<String> linkTrackCaller = new HashSet<String>();
		Map<String,String> newMapLinkMap = new TreeMap<String,String>();//Maybe a link map instead and var links not getting set for new code nor is it running a sceond time 
		int lowestNumber =0;
		List<String> tmepEntryLinkArrayList;
		List<String> objectList = new ArrayList<String>();
		LinkedHashMap<Object, Object> corrMap = new LinkedHashMap<Object,Object>();
		Map<Integer, LinkedHashMap<Object, Object>> finalCorpMap = new LinkedHashMap<Integer,LinkedHashMap<Object,Object>>();
		boolean anyObject =false;
		documentList2=new TreeMap<Integer,Object>();
		int sizeI =0;
		n=0;	
		try {
			objectList = ((ApiSuperClass) tempCheck).l1("nothing");
			}catch(NullPointerException n) {
			System.out.println("No Object assoicated to class");
		}
		
		boolean isOne =false;
		HashMap<? extends Object, ? extends Object> entryMap =(HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) tempCheck).getAdditionalProperties();
		entryMap.remove("links");
		for(Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()){
	    System.out.println(entry.getKey()+"-"+entry.getValue());
	       
			for(Object entryh2 : (ArrayList<?>) entry.getValue()){
				runit=true;
				 newMap = new LinkedHashMap<String,Object>();
				 linkTrackCaller = new HashSet<String>();
				 linkTrackerSetter = new HashSet<String>();
				 newMapLinkMap = new TreeMap<String,String>();
				 tmepEntryLinkArrayList= new ArrayList<String>();
				 newMapLinkMapFinalFinal = new TreeMap<Integer,Map<Integer,TreeMap<Integer,Object>>> (); 
				 automaticIterationMap = new TreeMap<Integer,Map<Integer,Object>>();
				 xIterationTracker=0;
				 System.out.println(entryh2.toString());
				LinkedHashMap<?,?> lastEntry1 = ((LinkedHashMap<?, ?>)  entryh2);
				for(Entry<?, ?> lastEntry : lastEntry1.entrySet()) {
					System.out.println(lastEntry.getKey()+" - "+lastEntry.getValue());
					newMap.put(lastEntry.getKey().toString(), lastEntry.getValue());
					
					
					if(lastEntry.getKey().equals("links")) {
					String remove =null;
						boolean removeE = false;
						int xInt =0;
						for(Entry<?,?> entryLinks :((LinkedHashMap<?, ?>) lastEntry.getValue()).entrySet()) {
							boolean first = true;
						    System.out.println(entryLinks.getKey());
						try {
							 xInt =	((ArrayList<?>) entryLinks.getValue()).size();
							System.out.println(xInt);
							
							
								//tmepEntryLinkArrayList.addAll((ArrayList<? extends Object>) entryLinks.getValue());
								linkTrackerSetter.add(entryLinks.getKey().toString());
								for(int entryLinksArray =0; entryLinksArray< ((ArrayList<?>) entryLinks.getValue()).size();entryLinksArray++){
									
								//newMap.put(entryLinks.getValue().toString(),entryLinks.getKey().toString());
								newMapLinkMap.put(((ArrayList<?>)entryLinks.getValue()).get(entryLinksArray).toString(),(String) entryLinks.getKey());
								newMap.put(entryLinks.getKey().toString(),"");
								if(first) {
									remove = ((ArrayList<?>)entryLinks.getValue()).get(entryLinksArray).toString();
								}
									
								}
							}catch(ClassCastException cee) {
							System.out.println("link was not an array");
							newMap.put(entryLinks.getKey().toString(),entryLinks.getValue().toString());
							linkTrackCaller.add(entryLinks.getKey().toString());
							}
						if(xInt==1){
							linkTrackerSetter.remove(entryLinks.getKey().toString());
							newMapLinkMap.remove(remove);
							newMap.put(entryLinks.getKey().toString(),remove);
						}
						first = false;
					}
					}else if(lastEntry.getKey().equals("location")||lastEntry.getKey().equals("geospatial")) {//check for contains coordinates 
						for(Entry<?,?> entryLocation : ((LinkedHashMap<?,?>) lastEntry.getValue()).entrySet()) {
						System.out.println(entryLocation);
						if(lastEntry.getKey().equals("location")) {
						try {
							
							for(int locationPoints =0; locationPoints<((ArrayList<?>)entryLocation.getValue()).size();locationPoints++) {
							
								newMap.put("coordinates"+(locationPoints+1), ((ArrayList<?>)entryLocation.getValue()).get(locationPoints));
								newMap.remove("geospatial");
								newMap.remove("type");
								
							
								}

							
							
						}catch(ClassCastException cee1) {
							System.out.println("was not a coordinate");
							newMap.put(entryLocation.getKey().toString(), entryLocation.getValue());
						
						}
						}else if(lastEntry.getKey().equals("geospatial")) {
							for(Entry<?,?> geospatialEntry : ((LinkedHashMap<?,?>)lastEntry.getValue()).entrySet()) {
							try {
								
							for(int coordinateXint=0; coordinateXint< ((ArrayList<?>)geospatialEntry.getValue()).size(); coordinateXint++) {
								int corTrack =1;
								for(int nestedArray =0; nestedArray< ((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).size();nestedArray++) {
									corrMap= new LinkedHashMap<Object,Object>();
									int x = 1;
									for(int hopefully =0; hopefully< ((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).size();hopefully++){
									
										System.out.println("Coor"+x +":"+((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).get(hopefully));

										newMap.put(geospatialEntry.getKey().toString()+x, "");
										
										corrMap.put(geospatialEntry.getKey().toString()+x,((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).get(hopefully));
										x++;
										}
								
									finalCorpMap.put(corTrack, corrMap);
									corTrack++;
								
								}
								
							
							}
							}catch(ClassCastException cee) {
								System.out.println("Not an issue");
								newMap.put(geospatialEntry.getKey().toString(), geospatialEntry.getValue());
							}
							}
						}
						}
					}else if(anyObject&&entry.getKey().equals("latestTelemetries")) {
						for(Entry<?,?> objectEntry : ((LinkedHashMap<?,?>) lastEntry.getValue()).entrySet()) {
							System.out.println(objectEntry);
							try {
								for(Entry<?,?> nameEntry: ((LinkedHashMap<?,?>)objectEntry.getValue()).entrySet()) {
									newMap.put(lastEntry.getKey().toString()+nameEntry.getKey().toString(), nameEntry.getValue());
								
								
								
								
								}
								newMap.put(lastEntry.getKey().toString(), objectEntry.getKey());
								
							}catch(ClassCastException cee) {
								System.out.println("was not Array of Head");
									newMap.put(lastEntry.getKey().toString()+objectEntry.getKey().toString(),objectEntry.getValue());
									newMap.remove(lastEntry.getKey());
							}

							}
						anyObject =false;
						
					}
				}
				
				
				for(Entry<String,Object> entry77: newMap.entrySet()){
					try {
					System.out.println("Key:"+entry77.getKey()+"- Value:"+entry77.getValue().toString());
					}catch(NullPointerException n) {
						System.out.println("Not an issue");
					}
					}
				//comtinue after setting map
				List<String> news = new ArrayList<String>();
				Map<String,String> mapValues = new TreeMap<String,String>();
				 thisi =cl.newInstance();
				int linkNumberTracker=0;
				int SmallsizeTracker = 0;
				List<Integer> dataSize = new LinkedList<Integer>();
				Map<Integer, String> tempMapTracker = new TreeMap<Integer,String>();
				TreeMap<Integer, Object>KeepTracker=new TreeMap<Integer,Object>();
				
				

		newMap.remove("links");
		
		
		
		
		Integer coloumnTracker = 0;
		if(!linkTrackerSetter.isEmpty()) {
			//iterate over out linktrackSetter to keep track of our link arrays 
		for(String it : linkTrackerSetter) {
			newMapLinkMapFinal = new TreeMap<Integer,TreeMap<Integer,Object>>();
			//temp map to split our link values stored in our newMapLinkMap 
			KeepTracker = new TreeMap<Integer,Object>();
			//add keep track of the DataType by adding a index to our key data
			int x =0;
		for(Entry<String,String> entry3:newMapLinkMap.entrySet()) {
			if(entry3.getValue().toString().contains(it)){
				x++;
				KeepTracker.put(x,entry3.getKey());
			}
			//newMapLinkMap.put(it, KeepTracker);
		}

		SmallsizeTracker = KeepTracker.size();
		//tracks how many times the iteration loop will need to go L583/L584
		tempMapTracker.put(++coloumnTracker, it);//was smalltracker stores array index and var
		//important that we set the inteteger in this map it allows us to check for conditino later on to see if its array one or array two
		newMapLinkMapFinal.put(coloumnTracker, KeepTracker);
		//model is 37 long
		newMapLinkMapFinalFinal.put(SmallsizeTracker, newMapLinkMapFinal);
		//dataSize.add(it);
		//track different numbers of arrays for links maybe should put in a set 
		dataSize.add(SmallsizeTracker);
		}
		}
		
		
		if(!linkTrackerSetter.isEmpty()) {
		lowestNumber=newMapLinkMapFinalFinal.entrySet().iterator().next().getKey().intValue();
		for(Entry<Integer,Map<Integer,TreeMap<Integer,Object>>> entrylinkMap :newMapLinkMapFinalFinal.entrySet()) {
			middleGround=	entrylinkMap.getKey().intValue()-lowestNumber;
		}
		}
		
	     
	if(!linkTrackerSetter.isEmpty()) {	
		//Major Map Order
		createNewMapLinkMapFinalFinal(newMapLinkMapFinalFinal,lowestNumber);
		for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
		}
	}
//}


for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
	// for every key value pair make our dataColumnLength.length length be a new index static will not change at runtime
	int[] dataColumnLength = new int[newMapLinkMapFinalFinal.size()];
	int[] dataColumnLengthM = null;
	int testc =0;
	int key2=0;
   //was it higher then index(lowest) number
	if(entry1.getKey()>lowestNumber && lowestNumber!=0) {
		 
	for(Entry<Integer,TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
			//for every added array/object
			dyListLength= new ArrayList<Object>();
			//for(Entry<Integer,Object> entry3 : entry2.getValue().entrySet()) {
				for(Entry<Integer, Map<Integer, String>> entryChange : numbersToAdd.entrySet()) {
				for(Entry<Integer,String> entryChange2 : entryChange.getValue().entrySet()) {
											dyListLength.add(entryChange2.getValue());//newvalues

			}
			
			}
			//make DY
			dataColumnLengthM = new int[newMapLinkMapFinalFinal.size()-1];
			iterationNumber = entry2.getValue().size();
			for(int i=0; i<dataColumnLengthM.length;i++) {
				resetM(dataColumnLengthM,i);
			}
			solveM(dataColumnLengthM,0,lowestNumber,key2);
			
		}
		numbersToAdd =null;
		numbersToAdd = new TreeMap<Integer,Map<Integer,String>>();
	}else {
		 
			for(Entry<Integer,TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
				
			//set size for iteration index even if its just one to many
			iterationNumber = entry2.getValue().size();
			for(int i =0; i<dataColumnLength.length;i++) {
				reset(dataColumnLength,i);
			}
			solve(dataColumnLength,0);
		
		
	}

	}
	for(Entry<Integer,Map<Integer,Object>> xL : automaticIterationMap.entrySet()) {
		System.out.println(xL.toString());
				}
	
}



		for(Entry<String,Object> entryMap2 : newMap.entrySet()) {
			System.out.println(entryMap2.getKey());
			System.out.println(entryMap2.getValue());
		}
		
			    //collect all methods from class at run time the Pojos
				Method m[] = cl.getMethods();
				
				//Used to get Base Objects method
				Object object = new Object();
				
				//Store Base Objects
				Method[] ex = object.getClass().getMethods();	
				
				Method mI =null;
				Object methodSet =null;
				
				
				//for the number of methods in the Class at runtime  Object 
				for(int j =0; j<m.length;j++) {
					//add them to the NEWS object in order to be removed
							news.add(m[j].getName().trim());
					
					}
				//for the Base Object methods
					for(int i =0; i<ex.length;i++) {
						//remove them from the Runtime Object 
						news.remove(ex[i].getName().trim());
						
					}
					

				news.remove("getLinks");

				mapValues.remove("links");
				//process all link number
				Map<Object,LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>>	hiddenLinksScope = new LinkedHashMap<Object,LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>>();
				if(linkTrackerSetter.isEmpty()&&finalCorpMap.isEmpty()) {
					for(Entry<String,Object> entry2: newMap.entrySet()) {
						String vol ="set";
					
				int x =0;
				String id = null;
				boolean isItNull =false;

				try {
					vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
					//vol = vol.replaceAll(" ", "");
					
					//use entry value in order to invoke the return type at runtime
				 mI = cl.getDeclaredMethod(vol, entry2.getValue().getClass());
			
				
				 methodSet =  entry2.getValue();
				
				}catch(NullPointerException ne) {
					methodSet =(String)("null");
					isItNull=true;
					test.add(thisi);
				}catch(NoSuchMethodException ex1) {
					vollist.add(vol);
					isItNull=true;
				}
					if(linkTrackCaller.contains(entry2.getKey().toString())) {
						if(entry2.getKey().equals("id")) {
							id = entry2.getValue().toString();
						}
						 
						//if(isItNull) {		
					//for(String it:linkTrackCaller) {
						//get object from links 
						//if(entry2.getKey().equals(it)) {
							ClientConfig cC = new ClientConfig();
							Client client = ClientBuilder.newClient(cC);
							HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder().credentials("ADMTHREE.AC2OA@gmail.com", "password1234").build();
							webR = client.target(UriBuilder.fromUri("http://agco-fuse-trackers-test.herokuapp.com/").build());
							webR.register(access);
							mapper.configure(MapperFeature.USE_ANNOTATIONS, true);
							String objectT = entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1)+"s";
							String objectT2 = entry2.getKey()+"s";
							Class<?> cls = null;
							boolean moreLinks = true;
							try {
								//vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
								//if its going through here its only going to be one so add the s any way
								cls = Class.forName(packName.trim()+objectT);
								
							} catch (ClassNotFoundException e) {
								
								
								  mI = cl.getDeclaredMethod(vol, entry2.getValue().getClass());
									
									
								   methodSet =  entry2.getValue();
								 
									mI.invoke(thisi,methodSet);
									
									test.add(thisi);
									//break;
									moreLinks =false;
							}
								
							//check try catch for changed field making useble by everyone 
							 //Object	linkTempCheck = mapper.readValue(webR.path(objectT+"/"+entry2.getValue()).request(MediaType.APPLICATION_JSON).get(String.class),cls);
							//callIt = api call for links 
							//process LinkAPiCAlls calls for the  child links
							if(moreLinks) {
							hiddenLinksScope = processLinkAPiCalls(callIt(objectT,entry2.getValue(),cls),objectT2,thisi,mI, cls);
							while(areThereMore) {
							finshoffCheckLinks(hiddenLinksMap);
							}
						} 
						//}	
					//}
						//}
					
					}
					
				
				
				
				if(!isItNull) {
				mI.invoke(thisi,methodSet);
				
			test.add(thisi);
			isItNull=false;
				}
				
				}
					
					documentList2.put(n,thisi);
					//single instance 
					n++;
					
				}else {
					
					for(Entry<Integer, Map<Integer, Object>> entryMethod: automaticIterationMap.entrySet()) {
						//new instance  of the object  based of the class every loop
						Object thisi2 = cl.newInstance();
						//store data and while making iteration one to many to iterations
						storeAllData(newMap,entry.getKey().toString(),tempMapTracker, thisi2,cLarg,entryMethod);
	
					}
					for (Entry<Integer, LinkedHashMap<Object, Object>> coorEntry1 : finalCorpMap.entrySet()) {
						Object thisi2 = cl.newInstance();
						//for(Entry<?, ?> coorEntry2 :((LinkedHashMap<?,?>) coorEntry1).entrySet()) {
							StoreAllCoordinatesArray(newMap,cl,cLarg, thisi2,coorEntry1.getValue());
							//newMap.put(coorEntry2.getKey().toString(),coorEntry2.getValue());
						//}
					}
				}

				
				
	}
			if (sizeI==1) {
			test1 =null;
		}
		}//for(Entry<? extends Object, ? extends Object> entry: ((ApiSuperClass) tempCheck).getAdditionalProperties().entrySet()) L325
		//System.out.println("Done Put Objects into Database");
		if(runit) {
//			for(Entry<Integer, Object> DBentry: documentList2.entrySet()) {
//				//System.out.println(DBentry.getKey()+" : "+DBentry.getValue());
//				sizeI=1;
//				
//				//test1.getConnectionAndSessionFactory();
//				}
			try {
				test1.setBrands(tempCheck.getClass().getSimpleName(),documentList2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			documentList2 =null;
			test.clear();
			test1 =null;
		}
		
	}
	
	
	public static void resetM(int[] array,int i)
    {
    	//for every loop we we make our index i =1 
       array[i] =1;
    }
    public static void reset(int[] array,int i)
    {
    	//for every loop we we make our index i =1 
       array[i] =1;
    }
    public static void addOne(int[] array, int i) {
    	
    	array[i]+=1;
    }
  public static void addOneM(int[] array, int i) {
    	
    	array[i]+=1;
    }
    public static void solve(int[] array,int i) {
    	//for the array size of our array length[0,0,0.....n] = x
    	if(i==array.length) {
    		addObjectsToProccess(array);
    		return;
    	}
    	//for the iteration number number we must handle weather its for many or one index this will be looped through many times newLinkMapsFinalFinal ->
    	//->Entry<Integer,TreeMap<Integer,String>> entry of newLinkMap ->solve loop for the number of iterations [1++,2++,3,4,5....n]
    	for(int k=0;k<iterationNumber;k++) {
    		//how many iterations each index basically the objects or the entries of my maps 
    		solve(array,i+1);
    		//add one  after every addObjectToProcess if its only more then one entry from newLinkMapsFinalFinal it will never get here i will update
    		addOne(array,i);
    	}
    	//sets back to one based on the index
    	reset(array,i);
    }
    
    public static void solveM(int[] array,int i,int lowestNumber,int key2) {
    	//for the array size of our array length[0,0,0.....n] = x
    	if(i==array.length) {
    		addObjectsToProccessM(array,lowestNumber,key2);
    		return;
    	}
    	//for the iteration number number we must handle weither its for many or one index this will be looped through many times newLinkMapsFinalFinal ->
    	//->Entry<Integer,TreeMap<Integer,String>> entry of newLinkMap ->solve loop for the number of iterations [1++,2++,3,4,5....n]
    	for(int k=0;k<iterationNumber;k++) {
    		//how many iterations each index basically the objects or the entries of my maps 
    		solveM(array,i+1, lowestNumber,key2);
    		//add one  after every addObjectToProcess if its only more then one entry from newLinkMapsFinalFinal it will never get here i will update and longer be accepted 
    		addOneM(array,i);
    	}
    	//sets back to one based on the index
    	resetM(array,i);
    }
   
    private static Map<Integer, Map<Integer, Object>> addObjectsToProccess(int[] array) {
    	automaticGeneration = new LinkedHashMap<Integer,Object>();
    	xIterationTracker++;
    	//Grabs one array of data at a time 
    	for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
    		for(Entry<Integer, TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
    				Map<Integer,TreeMap<Integer,Object>> tempMap = new TreeMap<Integer,TreeMap<Integer,Object>>();
    				tempMap.put(entry2.getKey(), entry2.getValue());
    				GetOneMap(tempMap, array,entry1.getKey());
    			}
    	}
		return automaticIterationMap;
    	

    	
    }
    private static Map<Integer, Map<Integer, Object>> addObjectsToProccessM(int[] array,int lowestNumber,int key2) {
    	automaticGeneration = new LinkedHashMap<Integer,Object>();
    	
    	
    	//Grabs one array of data at a time 
    	for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
    		if(entry1.getKey().intValue()==38) {
    			System.out.println("jkk");
    		}
    		for(Entry<Integer, TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
    				Map<Integer,TreeMap<Integer,Object>> tempMap = new TreeMap<Integer,TreeMap<Integer,Object>>();
    				tempMap.put(entry2.getKey(), entry2.getValue());
    				GetOneMapM(tempMap, array,entry1.getKey(),lowestNumber,key2);
    				
    			}
    		
    	}
		return automaticIterationMap;
    	

    	
    }
    
    public static Map<Integer, TreeMap<Integer, Object>> createNewMapLinkMapFinalFinal(Map<Integer, Map<Integer, TreeMap<Integer, Object>>> newMapLinkMapFinalFinal2, int lowestNumber) {
    	List<Integer> removeList = new ArrayList<Integer>();
		Map<Integer,String> KeepTracker = new TreeMap<Integer,String>();
		int xReset =0;
		//24{2={1=....n
			
		for(Entry<Integer,Map<Integer,TreeMap<Integer,Object>>> entry: newMapLinkMapFinalFinal2.entrySet()) {
			for(Entry<Integer,TreeMap<Integer,Object>> entryMap2 : entry.getValue().entrySet()) {
			//whats the limit 
			int iTake =0;
			//how many variables we have for our lowest number
			if(entryMap2.getValue().size()>lowestNumber) {
				System.out.println("createNewMapLinkMapFinalFinal"+entryMap2.getValue().size());
				//loop through our nested map in order to collect unneeded items first go around
				for(Entry<Integer,Object> mapEntry3 : entryMap2.getValue().entrySet()) {
					//how many we will take away in order to make correct number of permutation  while lowestNumber  is greater then itake dont add to remove list until over the NUmber of Array
					
					if(iTake>=lowestNumber) {
						
						removeList.add(mapEntry3.getKey());
					
					xReset++;
					//keep list map in order to add permutations later 
					//reset back to zero
					KeepTracker.put(xReset,(String) mapEntry3.getValue());
					
					numbersToAdd.put(entry.getKey(), KeepTracker);
				}
					iTake++;
				}
				//loop through with list of keys in order to remove from list.
				for(int x =0; x<removeList.size();x++) {
					//Remove values from second Map 
					entryMap2.getValue().remove(removeList.get(x));
				
				}
			}
			iTake=0;
		}
			
			
		}
    	return newMapLinkMapFinal;
    }
    public static void GetOneMap(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array,Integer key) {
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
    public static void GetOneMapM(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array,Integer key,int lowestNumber,int key2) {
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
    public static void storeAllData(Map<String,Object> newMap,String entry,Map<Integer,String> tempMapTracker,Object thisi,Class<?> cLarg,Entry<Integer, Map<Integer, Object>> entryMethod ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	for(Entry<String,Object> entry2: newMap.entrySet()) {
    		Object methodSet;
			
			String vol ="set";
			
			vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
			vol = vol.replaceAll(" ", "");

			

		try {
		//global time 	
		Method  mI = thisi.getClass().getMethod(vol.trim(),entry2.getValue().getClass());
		
		methodSet =  entry2.getValue();
		
		//
		//loop through link list 2=can 1=models
		//think about bringning to local scoop
		for(Entry<Integer,String> linkIntValue : tempMapTracker.entrySet()) {
			if(linkIntValue.getValue().trim().equals(entry2.getKey())) {
				for(Entry<Integer, Object> entryVar : entryMethod.getValue().entrySet()) {
					if(entryVar.getKey().intValue()==linkIntValue.getKey()) {
						//only need to trim for arrays
				 methodSet= entryVar.getValue();
				//System.out.println(entry2.getKey());
				//System.out.println(methodSet);
					}
				
				}
			}
		}

		
		
			
		//invoke method to set method 
		mI.invoke(thisi,methodSet);
		}catch(NoSuchMethodException ex1) {
			vollist.add(vol);
		}
		}
test.add(thisi);

	documentList2.put(n,test.get(n));
	n++;
	if(documentList2.size()>150) {
		System.out.println("theres 150");
	for(Entry<Integer, Object> DBentry: documentList2.entrySet()) {
		//System.out.println(DBentry.getKey()+" : "+DBentry.getValue());
		
		
		//test1.getConnectionAndSessionFactory();
		}
	try {
		try {
			test1.setBrands(thisi.getClass().getSimpleName(),documentList2);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	documentList2.clear();
	test1 =null;
	test.clear();
	runit=false;
	}
	
	
	
    }
    
    public static void 	StoreAllCoordinatesArray(Map<String,Object> newMap,Class<?> cl,Class<?> cLarg,Object thisi,LinkedHashMap<Object,Object> entry) {
    	boolean setW = false; 
    	for(Entry<String,Object> entry2: newMap.entrySet()) {
    		Object methodSet = null;
			
			String vol ="set";
			Method  mI= null;
			////System.out.println(entry2.getKey().substring(1,2).toUpperCase());
			//vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
//			if(entry2.getKey().toUpperCase().contains(entry.toString().trim().toUpperCase())) {
//				break;
//			}
			System.out.println("field : "+entry2.getKey());
			vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
			vol = vol.replaceAll(" ", "");
//			if(vol.equals("setD")) {
//				vol ="setId";
//			}
			

		try {
			
			if(!entry.isEmpty()) {
				for(Entry<Object, Object> coorEntry : entry.entrySet()) {
					if(coorEntry.getKey().toString().trim().equals(entry2.getKey())) {
					
						
						
						 mI = thisi.getClass().getMethod(vol.trim(),coorEntry.getValue().getClass());
						 methodSet= coorEntry.getValue();
						 setW = true;
					
					}
				}
					
				}
			if(!setW) {
		  mI = thisi.getClass().getMethod(vol.trim(),entry2.getValue().getClass());
		
		methodSet =  entry2.getValue();
		
				}
		
		
		//invoke method to set method 
		mI.invoke(thisi,methodSet);
		}catch(NoSuchMethodException ex1) {
			//ex1.printStackTrace();
			vollist.add(vol);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException n) {
			n.printStackTrace();
		}
		setW=false;
test.add(thisi);
    	}
	documentList2.put(n,test.get(n));
	n++;
    	
    	
    	
    	
    	
    }
    public static Object callIt(Object objectT,Object entry2,Class<?> cls) {
    	Object linkTempCheck=null;
		try {
			linkTempCheck = mapper.readValue(webR.path(objectT+"/"+entry2).request(MediaType.APPLICATION_JSON).get(String.class),cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return linkTempCheck;
    }
    public static void checkLinks(Object objectT,Map<Object, LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Object>>> hiddenLinksMap2,Object thisi,Method mI,Class<?> cl,List<String> newLostType, Object thisiParentLink) {
    	int trackMore =0;
    	boolean notYet = true;
    	for(Entry<LinkedHashMap<String, Object>, LinkedHashMap<String, Object>> entryW : hiddenLinksMap2.get(thisiParentLink).entrySet()) {
    		//linked list will be in the same order so use x to pull 
    		int x =0;
    		for(Entry<String,Object>entryL2: entryW.getValue().entrySet()) {
    		
    				String linkVol = "set";
    	Class<?> cls=null;
		try {
			 
			newLostType.get(x);
			
			linkVol +=	entryL2.getKey().substring(0,1).toUpperCase() + entryL2.getKey().substring(1);
			
			cls = Class.forName(packName.trim()+newLostType.get(x).substring(0,1).toUpperCase()+newLostType.get(x).substring(1));
			notDone	=	thisiParentLink.getClass().getSimpleName();
			
//			String linkVol = "set";
//			linkVol+=entryL3.getKey().toString();
			//linkTempCheck = mapper.readValue(webR.path(objectT+"/"+entry2).request(MediaType.APPLICATION_JSON).get(String.class),cls);
			//for now if the class is not made there is no other links:Use given apis 
		} catch (ClassNotFoundException e1) {
			//set for object of parent class owner needs to set its address
		//	for()//map
			try {
				  
				mI= cl.getDeclaredMethod(linkVol, entryL2.getValue().getClass());
				mI.invoke(thisiParentLink,entryL2.getValue());
				test.add(thisiParentLink);
				entryW.getKey().remove(entryL2.getKey().toString());
				trackMore++;
				notYet = false;
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//remove and store inside of map to pass back to be handle  global
				//model will have its on map 
		}
		
		test.add(thisiParentLink);
		x++;
    	}
    	}
//    	if(notYet){
//    		notDone	=	thisiParentLink.getClass().getSimpleName();
//    	}
    if(trackMore==newLostType.size()) {
    areThereMore=true;
    }
    	
    }
    public static  Map<Object,LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>> processLinkAPiCalls(Object linkTempCheck,Object objectT,Object thisi,Method m2,Class<?> cls) {
    	
    	HashMap<? extends Object, ? extends Object> entryMap =(HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) linkTempCheck).getAdditionalProperties();
		//entryMap.remove("links");
    	LinkedHashMap<String,Object> newMap = new LinkedHashMap<String,Object>();
		Set<String> linkTrackerSetter=new HashSet<String>();
		LinkedHashMap<String,Object> linkTrackCaller = new LinkedHashMap<String,Object>();
		Map<String,String> newMapLinkMap = new TreeMap<String,String>();//Maybe a link map instead and var links not getting set for new code nor is it running a sceond time 
		int lowestNumber =0;
		List<String> tmepEntryLinkArrayList;
		List<String> objectList = new ArrayList<String>();
		LinkedHashMap<Object, Object> corrMap = new LinkedHashMap<Object,Object>();
		Map<Integer, LinkedHashMap<Object, Object>> finalCorpMap = new LinkedHashMap<Integer,LinkedHashMap<Object,Object>>();
		boolean anyObject =false;
	    newLostType =new LinkedList<String>();
		List<Object> lostParentToIn = new LinkedList<Object>();
		Object thisiParentLink=null;
		boolean goodToGO = true;
		Method mI= null;
		
		newMap.remove("links");
		linkChild.put(newMap,linkTrackCaller);
		try {
			 thisiParentLink = cls.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//newMapLinkMapFinalFinal = new TreeMap<Integer,Map<Integer,TreeMap<Integer,Object>>> (); 
		for(Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()){
		    System.out.println(entry.getKey()+"-"+entry.getValue());
		       if(!entry.getKey().equals("links")) {
				for(Object entryh2 : (ArrayList<?>) entry.getValue()){
    				runit=true;
    				 newMap = new LinkedHashMap<String,Object>();
    				 linkTrackCaller = new LinkedHashMap<String,Object>();
    				 linkTrackerSetter = new HashSet<String>();
    				 newMapLinkMap = new TreeMap<String,String>();
    				 tmepEntryLinkArrayList= new ArrayList<String>();
    				 newMapLinkMapFinalFinal = new TreeMap<Integer,Map<Integer,TreeMap<Integer,Object>>> (); 
    				 automaticIterationMap = new TreeMap<Integer,Map<Integer,Object>>();
    				 linkChild = new LinkedHashMap<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>>();
    				 xIterationTracker=0;
    				 System.out.println(entryh2.toString());
    				LinkedHashMap<?,?> lastEntry1 = ((LinkedHashMap<?, ?>)  entryh2);
    				for(Entry<?, ?> lastEntry : lastEntry1.entrySet()) {
    					System.out.println(lastEntry.getKey()+" - "+lastEntry.getValue());
    					
    					if(lastEntry.getKey().equals("links")) {
    					String remove =null;
    						boolean removeE = false;
    						int xInt =0;
    						for(Entry<?,?> entryLinks :((LinkedHashMap<?, ?>) lastEntry.getValue()).entrySet()) {
    							boolean first = true;
    						    System.out.println(entryLinks.getKey());
    						try {
    							 xInt =	((ArrayList<?>) entryLinks.getValue()).size();
    							System.out.println(xInt);
    							
    							
    								//tmepEntryLinkArrayList.addAll((ArrayList<? extends Object>) entryLinks.getValue());
    								linkTrackerSetter.add(entryLinks.getKey().toString());
    								for(int entryLinksArray =0; entryLinksArray< ((ArrayList<?>) entryLinks.getValue()).size();entryLinksArray++){
    									
    								//newMap.put(entryLinks.getValue().toString(),entryLinks.getKey().toString());
    								newMapLinkMap.put(((ArrayList<?>)entryLinks.getValue()).get(entryLinksArray).toString(),(String) entryLinks.getKey());
    								newMap.put(entryLinks.getKey().toString(),"");
    								if(first) {
    									remove = ((ArrayList<?>)entryLinks.getValue()).get(entryLinksArray).toString();
    								}
    									
    								}
    								goodToGO=false;
    							}catch(ClassCastException cee) {
    							System.out.println("link was not an array");
    							
    							if(entryLinks.getKey().equals("brand")||entryLinks.getKey().equals("comServiceLevels")) {
    								if(entryLinks.getKey().equals("brands")){
    									String store="Brands";
    									try {
											cls = Class.forName(packName.trim()+store+"/"+ entryLinks.getValue().toString());
										} catch (ClassNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
    											;
    											HashMap<? extends Object, ? extends Object> entryMapLinkHidden =(HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) callIt(store,entryLinks.getValue().toString(),cls)).getAdditionalProperties();
    											
    											for(Entry<? extends Object, ? extends Object> entryMapLinkHiddenkm : entryMapLinkHidden.entrySet()){
    											
    											}
    											
    								}
    								
    							newMap.put(entryLinks.getKey().toString(),entryLinks.getValue().toString());
    							linkTrackCaller.put(entryLinks.getKey().toString(),entryLinks.getValue().toString());
    							goodToGO=false;
    							}
    							}
    						if(xInt==1){
    							linkTrackerSetter.remove(entryLinks.getKey().toString());
    							newMapLinkMap.remove(remove);
    							newMap.put(entryLinks.getKey().toString(),remove);
    						}
    						first = false;
    					}
    					}else if(lastEntry.getKey().equals("location")||lastEntry.getKey().equals("geospatial")) {//check for contains coordinates 
    						for(Entry<?,?> entryLocation : ((LinkedHashMap<?,?>) lastEntry.getValue()).entrySet()) {
    						System.out.println(entryLocation);
    						if(lastEntry.getKey().equals("location")) {
    						try {
    							
    							for(int locationPoints =0; locationPoints<((ArrayList<?>)entryLocation.getValue()).size();locationPoints++) {
    							
    								newMap.put("coordinates"+(locationPoints+1), ((ArrayList<?>)entryLocation.getValue()).get(locationPoints));
    								newMap.remove("geospatial");
    								newMap.remove("type");
    								
    							
    								}

    							goodToGO=false;
    							
    						}catch(ClassCastException cee1) {
    							System.out.println("was not a coordinate");
    							newMap.put(entryLocation.getKey().toString(), entryLocation.getValue());
    						
    						}
    						}else if(lastEntry.getKey().equals("geospatial")) {
    							for(Entry<?,?> geospatialEntry : ((LinkedHashMap<?,?>)lastEntry.getValue()).entrySet()) {
    							try {
    								
    							for(int coordinateXint=0; coordinateXint< ((ArrayList<?>)geospatialEntry.getValue()).size(); coordinateXint++) {
    								int corTrack =1;
    								for(int nestedArray =0; nestedArray< ((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).size();nestedArray++) {
    									corrMap= new LinkedHashMap<Object,Object>();
    									int x = 1;
    									for(int hopefully =0; hopefully< ((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).size();hopefully++){
    									
    										System.out.println("Coor"+x +":"+((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).get(hopefully));

    										newMap.put(geospatialEntry.getKey().toString()+x, "");
    										
    										corrMap.put(geospatialEntry.getKey().toString()+x,((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).get(hopefully));
    										x++;
    										}
    								
    									finalCorpMap.put(corTrack, corrMap);
    									corTrack++;
    								
    								}
    								
    							
    							}
    							goodToGO=false;
    							}catch(ClassCastException cee) {
    								System.out.println("Not an issue");
    								newMap.put(geospatialEntry.getKey().toString(), geospatialEntry.getValue());
    							}
    							}
    						}
    						}
    					}
    					if (goodToGO&&!lastEntry.getKey().toString().equals("links")) {
    					String setVol ="set";
    					newMap.put(lastEntry.getKey().toString(), lastEntry.getValue());
    					setVol +=	lastEntry.getKey().toString().substring(0,1).toUpperCase() + lastEntry.getKey().toString().substring(1);
						try {
							mI = cls.getMethod(setVol,lastEntry.getValue().getClass());
							mI.invoke(thisiParentLink,lastEntry.getValue());
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    				}	
    					
    				}
    			}	
				linkChild.put(newMap,linkTrackCaller);
				hiddenLinksMap.put(thisiParentLink,linkChild);
		       }else{
		    	   for(Entry<?,?> entryLinks :((LinkedHashMap<?, ?>) entry.getValue()).entrySet()) {
		    		   for(Entry<?,?> entryLinks2 :((LinkedHashMap<?, ?>) entryLinks.getValue()).entrySet()) {
		    			  if(entryLinks2.getKey().equals("type")){
		    				  
		    				  newLostType.add(entryLinks2.getValue().toString());
		    				  
		    			  }
		    	   
		       }
    		//if map loop through subtract one then add them to 
    	
		}
    	//child Object = Parent Object
    	
    	//linkLostChild.put(linkChild,id);
    	//child Object and childchild ids
    	
    	
    	//lostParentToIn.add(thisiParentLink);
    	
    	//keep processing until all links collected 
    			//processLinkAPiCalls(linkTempCheck,objectT);
		    	   notDoneMap.put(cls.getSimpleName(), newLostType);
    	   }
		}
		checkLinks(linkTempCheck, hiddenLinksMap,thisi, mI,cls,newLostType,thisiParentLink);
    	
		
		       return hiddenLinksMap;
		       
		}
    public static void finshoffCheckLinks(Map<Object, LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Object>>> hiddenLinksMap2) {
    	
    	Class<?> cl = null;
    	Object thisiParentLinkchild=null;
    	String linkVol ="set";
    	Method mI =null;
    	List<String> tempScopeList = new ArrayList<String>(newLostType);
    	
    	boolean continueN = true;
    	while(areThereMore)
		{
    		int scopeInt = 0;
			for(Entry<Object, LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Object>>> entry :hiddenLinksMap2.entrySet()) {
				for(Entry<LinkedHashMap<String,Object>,LinkedHashMap<String,Object>> entry2 :entry.getValue().entrySet()){
					for (Entry<String,Object> entry3 : entry2.getValue().entrySet()) {
						
						
					    try {
					    	
					    	
							
					    	
					    	cl=	Class.forName(packName.trim()+tempScopeList.get(scopeInt).substring(0,1).toUpperCase() + tempScopeList.get(scopeInt).substring(1));
					    	thisiParentLinkchild = cl.newInstance();
					    } catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							
							
							linkVol +=	entry3.getKey().substring(0,1).toUpperCase() + entry3.getKey().substring(1);
							
							try {
								 mI = entry.getKey().getClass().getMethod(linkVol,entry3.getValue().getClass());
							} catch (NoSuchMethodException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SecurityException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								mI.invoke(entry.getKey(),entry3.getValue());
								continueN=false;
							} catch (IllegalAccessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IllegalArgumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (InvocationTargetException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//test.add(thisiParentLink);
							entry2.getKey().remove(entry3.getKey().toString());
						}
						
							
					   if(continueN) {
						processLinkAPiCalls(callIt(tempScopeList.get(scopeInt),entry3.getValue(),cl),entry3.getKey(),thisiParentLinkchild,mI, cl);
					   }
					   scopeInt++;
					}
					areThereMore=false;
					//newLostType.clear();
					
				}
				
				
			}
			
		  }
    	
    	
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
       
    }
}
