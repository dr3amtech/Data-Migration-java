package com.productionDataClientProductionData.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productionDataClientProductionData.impl.ApiSuperClass;
import com.productionDataClientProductionData.pojo.Brands;
import com.productionDataClientProductionData.pojo.CanAlarms;
import com.productionDataClientProductionData.pojo.CanVariableEnumerations;
import com.productionDataClientProductionData.pojo.CanVariables;
import com.productionDataClientProductionData.pojo.Duties;
import com.productionDataClientProductionData.pojo.Trackers;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Unit test for simple App.
 */

@Ignore
public class AppTest implements Serializable
   {
	private static Logger logger = LogManager.getLogger(com.productionDataClientProductionData.test.AppTest.class.getName());
	private static Logger logger2 = LogManager.getLogger("com.productionDataClientProductionData.test");
	
	static int trackerCollection=0;
	//global to handle storeAllData method N 
	private static int n=0;
	private static int v=0;
    Properties properties = null;
    private static List<Object> test = new LinkedList<Object>();
    static List<String> badDataList = new ArrayList<String>();
    private static Set<Object> propertiesSet = new LinkedHashSet<Object>();
    private static Map<String,Object> brandsMap = new LinkedHashMap<String,Object>();
	private static Map<String,Object> canAlarms = new LinkedHashMap<String,Object>();
	private static TreeMap<Integer, Object> documentList2=new TreeMap<Integer,Object>();
	private static List<String> vollist = new ArrayList<String>();
	private static Map<String,String> propertiesMap = new LinkedHashMap<String,String>();
	public  static ConnectionTest test1  =null;
	//integers help us keep track of what we already did when time for creating objects
	static Map<Integer,TreeMap<Integer,Object>> newMapLinkMapFinal = new HashMap<Integer,TreeMap<Integer,Object>>();
	static Map<Integer,Map<Integer,TreeMap<Integer,Object>>> newMapLinkMapFinalFinal = new TreeMap<Integer,Map<Integer,TreeMap<Integer,Object>>> ();
	private static Map<Integer, Object> automaticGeneration = new LinkedHashMap<Integer, Object>();
	private static Integer xIterationTracker = 0;
	private static Map<Integer,Map<Integer,Object>> automaticIterationMap = new TreeMap<Integer,Map<Integer,Object>>();
	private static Map<Integer, Map<Integer, String>> numbersToAdd = new TreeMap<Integer,Map<Integer,String>>();
	WebTarget webR=null;
	ObjectMapper mapper = new ObjectMapper();
	private static boolean runit = true;
	String newString ="";
	private static int iterationNumber=0;
	private static List<String> place = new ArrayList<String>();
	//do we need to watch the data 
	private static boolean search=false;
	private static int middleGround=0;
	private static List<ArrayList<Object>> dataDynamicLength =null;
	private static List<Object> dyListLength =null;
	private static boolean connectSession =true;
	private static boolean removeString =false;
	private static LinkedHashMap<Integer,TreeMap<Integer,Object>> downloadList = new LinkedHashMap<Integer,TreeMap<Integer,Object>>();
    private static List<String> MadeData = new ArrayList<String>(); 
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
			logger.error(e.getMessage());
		}
    	
//    for(Entry<String,String> properties:propertiesMap.entrySet()) {
//    	System.out.println(properties.getKey());
//    }
//System.out.println("Done");
   logger.info("TestGetApICollection: API Properties recieved successfully");
   assertEquals(true, test);
    }
	@Ignore 
	@Test
	public  void getApi() throws ClassNotFoundException, InstantiationException, IllegalAccessException, JsonParseException, JsonMappingException, IOException {
		
	
	
		boolean answer = false;
		try {
		ClientConfig cC = new ClientConfig();
		Client client = ClientBuilder.newClient(cC); 
		HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder().credentials("ADMTHREE.AC2OA@gmail.com", "password1234").build();
		WebTarget webR = client.target(UriBuilder.fromUri("http://agco-fuse-trackers.herokuapp.com").build());
		webR.register(access);
		ObjectMapper mapper = new ObjectMapper();
		for(Entry<Object,Object> entry: properties.entrySet()) {
		
		
		    Object 	tempObject = mapper.readValue(webR.path(entry.getValue().toString().trim()).request(MediaType.APPLICATION_JSON).get(String.class),Brands.class);
			}
	
			
			} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, answer);
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
	 Object	tempCheck = mapper.readValue(webR.path(property.getValue().toString().trim()+"/7dd78a9e-7b2e-4726-a16d-c6e63ccfcfb8").queryParam(property.getValue().toString().trim()).request(MediaType.APPLICATION_JSON).get(String.class),cl);
	 HashMap<? extends Object, ? extends Object> entryMap =(HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) tempCheck).getAdditionalProperties();
		

	 
	 
	 
	 
	 if(!tempCheck.toString().contains("links")){
	System.out.println(property.getKey());
	}
	
//	for(Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()){
//	     // System.out.println(entry.getKey()+"-"+entry.getValue());
//	      
//	  try {
//		  int LinksTracker =0;
//	      System.out.println(entry.getKey());
//	      List<String> LinkTrackerList = new ArrayList<String>();
//	      for(Entry<?,?> entryLinks : ((LinkedHashMap<?,?>) entry.getValue()).entrySet()){
//	    	//  for(Entry<?,?> entryEntryLinks :((LinkedHashMap<?,?>) entryLinks.getValue()).entrySet()) {
//	    	  LinksTracker++;
//	    	  LinkTrackerList.add(entryLinks.getKey().toString());
//	    	//  }
//	    	  
//	      }
//	      System.out.println("Object: "+property.getKey()+" Has "+LinksTracker);
//	      for(String it : LinkTrackerList) {
//	    	  System.out.println(it);
//	      }
//	  }catch(ClassCastException cee) {
//		  
//	  }
//
//	}
	}
	}
	@Ignore
	@Test
	public void getEqupipmentTest() throws JsonParseException, JsonMappingException, IOException,NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLIntegrityConstraintViolationException {
		String packName = "com.productionDataClientProductionData.pojo.";
		String tempString = "";
		Map<String,String> mapValues = new TreeMap<String,String>();
		List<String> news = new ArrayList<String>();
		Class[] cLarg = new Class[1];
		cLarg[0] = String.class;
		
		ClientConfig cC = new ClientConfig();
		Client client = ClientBuilder.newClient(cC);
		HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder().credentials("ADMTHREE.AC2OA@gmail.com", "password1234").build();
		//HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder().credentials("almsupportdesk@fuseserviceaccount.com", "ALM2017!").build();
		webR = client.target(UriBuilder.fromUri("http://agco-fuse-trackers-test.herokuapp.com").build());
		webR.register(access);
		MadeData.add("0905650c-c3b4-4e6b-b4b5-87f23fab74fa");
		MadeData.add("96ab8583-3a43-44cb-ae04-2446085b8b9e");
		MadeData.add("88c35260-ec6c-46f9-9260-a2ee599defac");
		MadeData.add("49ea7006-489a-4ea7-84fa-9cf0b8b2a193");
		MadeData.add("02543cec-089c-436d-9c85-b5c674fe9637");
		MadeData.add("1ac276c8-563f-4244-b427-f93375984767");
		MadeData.add("fe97a053-c9cd-4441-85bd-831376c6f196");
		MadeData.add("cbe046de-c584-476f-81df-e8c9ce46b8f0");
		MadeData.add("fb5ac9e5-44ec-48e6-9e8e-56ebdaac18ef");
		MadeData.add("8024134a-3fa9-47f0-aea4-0ec8179b9f5e");
		//System.out.println("Start");
		for(Entry<String,String> property : propertiesMap.entrySet()){
			test1  = new ConnectionTest();
			news = new ArrayList<String>();
			boolean time = true;
			mapper.configure(MapperFeature.USE_ANNOTATIONS, true);
			//Class<?> cl = Class.forName(packName.trim()+"CanAlarms");
			Class<?> cl;
			try {
				cl = Class.forName(packName.trim()+property.getKey().toString().trim());
			
		//check try catch for changed field 
		 Object	tempCheck = mapper.readValue(webR.path(property.getValue().toString().trim()).request(MediaType.APPLICATION_JSON).get(String.class),cl);
		// tempCheck = 	mapper.readValue(webR.queryParam("include","models").request(MediaType.APPLICATION_JSON).get(String.class),Models.class);
		 //tempCheck = mapper.readValue(webR.queryParam("1","limit").request(MediaType.APPLICATION_JSON).get(String.class),cl);							
		 AppTest.StoreInsideOfObject(cl,cLarg[0],tempCheck);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("getEqupipmentTest: ",e);
			}catch(NotFoundException nf) {
				nf.printStackTrace();
			}
			
			
			
//		}
		
		//getAllMethodNames(news);
		
//		for(Entry<Integer, Object> entry: documentList2.entrySet()) {
//			System.out.println(entry.getKey()+" : "+entry.getValue());
//			
//			
//			//test1.getConnectionAndSessionFactory();
//			}
//		test1.setBrands(documentList2);
		}
		//System.out.println("All Collections"+ trackerCollection);
		//System.out.println("Data collected data for all collection: "+tracker);
		//System.out.println("Bad Data"+badDataList.toString());
		
		test1.closeConntection();
	}
	
	@Ignore	
	@Test
	public  void getApi2() throws ClientProtocolException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	try {
		com.sun.jersey.api.client.config.ClientConfig cC = new DefaultClientConfig();
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(cC);
		client.addFilter(new HTTPBasicAuthFilter("ADMTHREE.AC2OA@gmail.com", "password1234"));
		//WebResource webR = client.resource(UriBuilder.fromUri("http://agco-fuse-trackers-test.herokuapp.com").build());
		WebResource webR = client.resource(UriBuilder.fromUri("http://agco-fuse-trackers.herokuapp.com").build());
		ObjectMapper mapper = new ObjectMapper();
		
		Brands jo 	=mapper.readValue(webR.path("/brands").accept(MediaType.APPLICATION_JSON).get(String.class),Brands.class);
			//JsonNode ex = mapper.readTree(testApis);
			//ex.asText();
		CanAlarms eq = mapper.readValue(webR.path("/canalarms").accept(MediaType.APPLICATION_JSON).get(String.class),CanAlarms.class );
			brandsMap.putAll(jo.getAdditionalProperties());
			canAlarms.putAll(eq.getAdditionalProperties());
			for(Entry<String, Object> entry : brandsMap.entrySet()) {
				//System.out.println("Get key: "+entry.getKey());
				//System.out.println("Get Value: "+ entry.getValue());
			}
			for(Entry<String, Object> entry : canAlarms.entrySet()) {
				//System.out.println("Get key: "+entry.getKey());
				//System.out.println("Get Value: "+ entry.getValue());
			}
			
			
			
		} catch (UniformInterfaceException |ClientHandlerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void getAllMethodNames(List<String> methodNames) {
		trackerCollection++;
		List<String>  methods = new ArrayList<String>(methodNames); 
		//System.out.println("Class Name: "+methods.get(0)+"\nMethods Names: ");
		if(methods.get(0).contains("[0-9]")) {
			badDataList.add(methods.get(0));
		}
				String[] test =  methods.get(1).split(", ");
				for(int in =0 ; in <test.length;in++) {
				 //System.out.println(test[in].toString().split("=")[0]);
				}
		
			
	}
	
	public static void StoreInsideOfObject(Class<?> cl,Class<?> cLarg,Object tempCheck) throws JsonParseException, JsonMappingException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException, SQLIntegrityConstraintViolationException {
		Map<String,Object> newMap = new LinkedHashMap<String,Object>();
		Set<String> linkTrackerSetter=new HashSet<String>();
		Set<String> stillLinkTrackerSetter = new HashSet<String>();
		Map<String,String> newMapLinkMap = new TreeMap<String,String>();//Maybe a link map instead and var links not getting set for new code nor is it running a sceond time 
		List<String> mapList = new ArrayList<String>();
		int lowestNumber =0;
		List<String> tmepEntryLinkArrayList;
		List<String> objectList = new ArrayList<String>();
		LinkedHashMap<Object, Object> corrMap = new LinkedHashMap<Object,Object>();
		Map<String,List<String>> mapIt = new LinkedHashMap<String,List<String>>();
		Map<Integer, LinkedHashMap<Object, Object>> finalCorpMap = new LinkedHashMap<Integer,LinkedHashMap<Object,Object>>();
		boolean anyObject =false;
		documentList2=new TreeMap<Integer,Object>();
		int sizeI =0;
			
		try {
			objectList = ((ApiSuperClass) tempCheck).l1("nothing");
			}catch(NullPointerException n) {
			System.out.println("No Object assoicated to class");
		}
		
		 connectSession =true;
		HashMap<? extends Object, ? extends Object> entryMap =(HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) tempCheck).getAdditionalProperties();
		try {
		for(Entry<? extends Object,? extends Object> entryWorld:((LinkedHashMap<?, ?>) entryMap.get("links")).entrySet()) {
			for (Entry<? extends Object,?extends Object> entryWorld2 : ((LinkedHashMap<?,?>)entryWorld.getValue()).entrySet()) {
				if(entryWorld2.getKey().equals("type")) {
					stillLinkTrackerSetter.add(entryWorld2.getValue().toString());
					
				}
			}
		}
		}catch(NullPointerException n) {
			//log
		}
	entryMap.remove("links");
		
		//for(Entry<? extends Object, ? extends Object> entry: ((ApiSuperClass) tempCheck).getAdditionalProperties().entrySet()) {
		for(Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()){
		
	   // System.out.println(entry.getKey()+"-"+entry.getValue());
	      //for(int x1 =0; x1<((ArrayList<?>) entry.getValue()).size();x1++) {
			int index =0;
			for(Object entryh2 : (ArrayList<?>) entry.getValue()){
				runit=true;
				 newMap = new LinkedHashMap<String,Object>();
				 linkTrackerSetter = new HashSet<String>();
				 newMapLinkMap = new TreeMap<String,String>();
				 mapList = new ArrayList<String>();
				 mapIt = new LinkedHashMap<String,List<String>>();
				 tmepEntryLinkArrayList= new ArrayList<String>();
				 newMapLinkMapFinalFinal = new TreeMap<Integer,Map<Integer,TreeMap<Integer,Object>>> (); 
				 automaticIterationMap = new TreeMap<Integer,Map<Integer,Object>>();
				 xIterationTracker=0;
				 System.out.println(entryh2.toString());
				LinkedHashMap<?,?> lastEntry1 = ((LinkedHashMap<?, ?>)  entryh2);
				for(Entry<?, ?> lastEntry : lastEntry1.entrySet()) {
					System.out.println(lastEntry.getKey()+" - "+lastEntry.getValue());
					newMap.put(lastEntry.getKey().toString(), lastEntry.getValue());
//					try {
////					for(String ob : objectList) {
////						if(ob.equals(lastEntry.getKey())) {
////							anyObject=true;
////							break;
////						}
//					}
//					}catch(NullPointerException n) {
//						System.out.println("not an issue");
//					}
					
					
					
					
					if(lastEntry.getKey().equals("links")) {
					String remove =null;
						boolean removeE = false;
						int xInt =0;
						for(Entry<?,?> entryLinks :((LinkedHashMap<?, ?>) lastEntry.getValue()).entrySet()) {
							boolean first = true;
						    System.out.println(entryLinks.getKey());
						    //stillLinkTrackerSetter.add(entryLinks.getKey().toString());
						try {
							 xInt =	((ArrayList<?>) entryLinks.getValue()).size();
							//System.out.println(xInt);
							
							
								//tmepEntryLinkArrayList.addAll((ArrayList<? extends Object>) entryLinks.getValue());
								//linkTrackerSetter.add(entryLinks.getKey().toString());
								for(int entryLinksArray =0; entryLinksArray< ((ArrayList<?>) entryLinks.getValue()).size();entryLinksArray++){
									
								//newMap.put(entryLinks.getValue().toString(),entryLinks.getKey().toString());
								newMapLinkMap.put(((ArrayList<?>)entryLinks.getValue()).get(entryLinksArray).toString(),(String) entryLinks.getKey());
								mapList.add(((ArrayList<?>) entryLinks.getValue()).get(entryLinksArray).toString());
								newMap.put(entryLinks.getKey().toString(),"");
								if(first) {
									remove = ((ArrayList<?>)entryLinks.getValue()).get(entryLinksArray).toString();
								}
									
								}
								mapIt.put(entryLinks.getKey().toString(), mapList);
							}catch(ClassCastException cee) {
							System.out.println("link was not an array");
							boolean wasItSet = false;
							for(String it :stillLinkTrackerSetter) {
								if(it.contains(entryLinks.getKey().toString())) {
								newMap.put(it,entryLinks.getValue().toString());
								wasItSet = true;
								}
							}
							if(!wasItSet) {
								
								newMap.put(entryLinks.getKey().toString(), entryLinks.getValue().toString());
								wasItSet=false;
						}
							//newMap.put(entryLinks.getKey().toString(),entryLinks.getValue().toString());
							//stillLinkTrackerSetter.add(entryLinks.getKey().toString());
							}
						if(xInt==1){
							linkTrackerSetter.remove(entryLinks.getKey().toString());
							//newMapLinkMap.remove(remove);
							newMap.put(entryLinks.getKey().toString(),remove);
							//stillLinkTrackerSetter.add(entryLinks.getKey().toString());
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
				Object thisi =cl.newInstance();
				int linkNumberTracker=0;
				TreeMap<Integer, Object>KeepTracker=new TreeMap<Integer,Object>();
				int SmallsizeTracker = 0;
				List<Integer> dataSize = new LinkedList<Integer>();
				Map<Integer, String> tempMapTracker = new TreeMap<Integer,String>();
				
				

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
		lowestNumber=newMapLinkMapFinalFinal.entrySet().iterator().next().getKey().intValue();
		
		}
	
		for(Entry<Integer,Map<Integer,TreeMap<Integer,Object>>> entrylinkMap :newMapLinkMapFinalFinal.entrySet()) {
			middleGround=	entrylinkMap.getKey().intValue()-lowestNumber;
		}
		
		
		//its in tree map should it be worth the trouble to double check
//	if(!linkTrackerSetter.isEmpty()) {
//	   int  tempNumber = 0;
//	   lowestNumber =0;
//		for(int i =0; i<dataSize.size();i++) {
//			if(i==0) {
//			tempNumber = dataSize.get(i).intValue();
//			}else {
//				if(tempNumber>dataSize.get(i).intValue()) {
//					//new lower number new list
//					dataSize.set(i-1, dataSize.get(i).intValue());
//					dataSize.set(i,tempNumber);
//					tempNumber=dataSize.get(i).intValue();	
//				}else {
//				tempNumber = dataSize.get(i).intValue();	
//				}
//			}if(dataSize.size()==1) {
//				lowestNumber = dataSize.get(0);
//			}else if(!(dataSize.size()==1)) {
//			lowestNumber = tempNumber;
//			}
//		}
//	}
		//37=model TreeMap Order this from smallest to largest
//for(Entry<Integer,String> entryTracker: tempMapTracker.entrySet()) {
		//for data list size loop until we have satisfied all requirments allowing the lowest to loop first
	     
	if(!linkTrackerSetter.isEmpty()) {	
		//Major Map Order
		createNewMapLinkMapFinalFinal(newMapLinkMapFinalFinal,lowestNumber);
//		for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
//		}
	}
//}


for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
	// for every key value pair make our dataColumnLength.length length be a new index static will not change at runtime
	int[] dataColumnLength = new int[newMapLinkMapFinalFinal.size()];
	int[] dataColumnLengthM = null;
	List<Object> dyListLength = new ArrayList<Object>();
    dataDynamicLength = new ArrayList<ArrayList<Object>>();
	//was it higher then index(lowest) number
	if(entry1.getKey()>lowestNumber && lowestNumber!=0) {
		//replace the values with values that were not added to Map will not allow for certain values not to be added again
		for(Entry<Integer,TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
			for(Entry<Integer,Object> entry3 : entry2.getValue().entrySet()) {
			for(Entry<Integer, Map<Integer, String>> entryChange : numbersToAdd.entrySet()) {
				for(Entry<Integer,String> entryChange2 : entryChange.getValue().entrySet()) {
					if(entry3.getKey().intValue()==entryChange2.getKey().intValue()) {
					//replace current 1/2/3/ with new one 
						System.out.println("Before: "+ entry3.getValue().toString());
						dyListLength.add(entry.getValue());//newvalues
					entry3.setValue(entryChange2.getValue());
					System.out.println("After: "+entry3.getValue().toString());
				}
			
			}
			
			}
			//
			}
			//make DY
			dataColumnLengthM = new int[newMapLinkMapFinalFinal.size()-1];
			search =true;
			iterationNumber = entry2.getValue().size();
			for(int i=0; i<dataColumnLengthM.length;i++) {
				resetM(dataColumnLengthM,i);
			}
			solveM(dataColumnLengthM,0,lowestNumber);
		
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
				Constructor c[] = thisi.getClass().getConstructors();
				
				//Used to get Base Objects method
				Object object = new Object();
				
				//Store Base Objects
				Method[] ex = object.getClass().getMethods();	
				
				
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
				
//				 for(Field f : thisi.getClass().getDeclaredFields()) {
//						f.get(thisi.getClass().getDeclaredFields());
//				 }
				
				if(linkTrackerSetter.isEmpty()&&finalCorpMap.isEmpty()) {
				for(Entry<String,Object> entry2: newMap.entrySet()) {
					
					Object arrayOrNot =null;
					boolean happened = false;
				     Method mI = null;
				     
				     String vol ="set";
				     arrayOrNot =  entry2.getValue();
					vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
					//vol = vol.replaceAll(" ", "");
					
					if(entry2.getKey().toString().equals("equipment")) {
						
						//go get equipment and other objects  fa571657-f2a2-4651-92a3-216ff8022455
					      //Object tempObject =	httpTest(entry2.getKey());
						   Object tempObject =	httpTest(MadeData.get(index));
					      try {
								
					    	   //tempObject = test1.getObject("ffad8624-3ecf-4b5c-a03a-fb5e135e227a", "Equipment", "latestTelemetries");
					    	  
								mI = cl.getDeclaredMethod(vol, tempObject.getClass());	
								//use entry value in order to invoke the return type at runtime
								
								 
								 //Object thisi2 =cl2.newInstance();
								 mI.invoke(thisi, tempObject);
								
								
								}catch(NullPointerException ne) {
									arrayOrNot ="null";
									//mI.invoke(thisi, arrayOrNot);
								}catch(NoSuchMethodException ex1) {
									vollist.add(vol);
								}
						 happened = true;
						}
					else if(entry2.getKey().toString().equals("canVariables")) {
						Class<?>	cl2 = Class.forName("com.productionDataClientProductionData.pojo."+CanVariables.class.getSimpleName());
						List<Object> newTempList = new ArrayList<Object>();
						Method mI2 = null;
						for(Entry<?,?> entryCan: ((LinkedHashMap<?, ?>) entry2.getValue()).entrySet()) {
							Object thisi2 =cl2.newInstance();
							String vol2 = "setName";
								mI2 = cl2.getDeclaredMethod(vol2, entryCan.getKey().getClass());
								arrayOrNot = entryCan.getKey();
								mI2.invoke(thisi2, arrayOrNot);
							for(Entry<?,?> entryCan2 : ((LinkedHashMap<?, ?>) entryCan.getValue()).entrySet()) {
								//for(Entry<?,?> entryCan3 :((LinkedHashMap<?,?>) entryCan2.getValue()).entrySet()) {
								String vol3 = "set"+entryCan2.getKey().toString().substring(0, 1).toUpperCase() +entryCan2.getKey().toString().substring(1);
								
								try {
									
									mI2 = cl2.getDeclaredMethod(vol3, entryCan2.getValue().getClass());	
									//use entry value in order to invoke the return type at runtime
									
									 arrayOrNot =  entryCan2.getValue();
									 //Object thisi2 =cl2.newInstance();
									 mI2.invoke(thisi2, arrayOrNot);
									
									arrayOrNot = thisi2;
									}catch(NullPointerException ne) {
										arrayOrNot ="null";
										//mI.invoke(thisi, arrayOrNot);
									}catch(NoSuchMethodException ex1) {
										vollist.add(vol3);
									}
								
								//}
							}
							//set object list
							newTempList.add(thisi2);
						}
						try {
						 mI = cl.getDeclaredMethod(vol, newTempList.getClass());
						}catch(NoSuchMethodException e) {
							vollist.add(vol);
						}
						 mI.invoke(thisi, newTempList);
						happened =true;
						arrayOrNot=newTempList;
					}else if(entry2.getKey().toString().equals("duty")) {
						Class<?>	cl3 = Class.forName("com.productionDataClientProductionData.pojo."+Duties.class.getSimpleName());
						List<Object> newTempList = new ArrayList<Object>();
						String mongoDB =null;
						Method mI2 = null;
						Object thisi3 =cl3.newInstance();
						for(Entry<?,?> entryDuty :((LinkedHashMap<?,?>) entry2.getValue()).entrySet()) {
						//	for(Entry<?,?> entryDuty2 :((LinkedHashMap<?,?>) entryDuty.getValue()).entrySet()) {
								//entryDuty.getKey().toString().replaceAll("_", "");
						
							if(entryDuty.getKey().toString().equals("status")) {
								mongoDB=entryDuty.getKey().toString();
							}
                                String vol4 = "set"+entryDuty.getKey().toString().substring(0, 1).toUpperCase() +entryDuty.getKey().toString().substring(1);
								
								try {
									
									
									
									mI2 = cl3.getDeclaredMethod(vol4, entryDuty.getValue().getClass());	
									//use entry value in order to invoke the return type at runtime
									
									 arrayOrNot =  entryDuty.getValue();
									 //Object thisi2 =cl2.newInstance();
									 mI2.invoke(thisi3, arrayOrNot);
									
									arrayOrNot = thisi3;
									}catch(NullPointerException ne) {
										arrayOrNot ="null";
										//mI.invoke(thisi, arrayOrNot);
									}catch(NoSuchMethodException ex1) {
										vollist.add(vol4);
									}
							//}
						}
				    //test1.setTrackers(thisi3.getClass().getSimpleName(), thisi3);
					//Object 	 tempObject = test1.getObject(mongoDB, "Duties", "latestTelemetries");
					arrayOrNot = thisi3;
					mI = cl.getDeclaredMethod(vol, thisi3.getClass());
							
							
						 mI.invoke(thisi, arrayOrNot);
						 happened = true;
					}
					
					//if(!linkTrackerSetter.isEmpty()) {
//					boolean wentthrough =false;
//					String contains =entry2.getKey().toString();
//					try {
//						for(int it =0; it< objectList.size();it++) {
//							if(objectList.get(it).equals(entry2.getKey())) {
//								
//								
//								if(!entry2.getKey().endsWith("s")) {
//									contains +="s";
//								}
//								wentthrough=true;
//							}else if (!objectList.get(it).equals(entry2.getKey())) {
//								try {
//								String[] correct = objectList.get(it).split("=");
//								if(correct[0].equals(entry2.getKey())){
//									contains =correct[1];
//									wentthrough = true;
//								}
//								
//								}catch(IndexOutOfBoundsException in) {
//									
//								}
//							}
//						}
//						if(wentthrough) {
//					objectList.remove(index++);
//					wentthrough = false;
//						}
//					}catch(NullPointerException ne) {
//						logger.debug("Object has no null value");
//					}
//					
//					
//					Method mI=null;
//					
//					
//					if(stillLinkTrackerSetter.contains(contains)) {
//						String tableName =null;
//						for(String it : stillLinkTrackerSetter) {
//							if(it.equals(contains)) {
//								tableName =it;
//							}
//							
//						}
//						if(connectSession) {
//							test1.getConnection(contains,tableName);
//							connectSession=false;
//						}
//						Object objectLink=null;
//						try {
//								
//					if(!newMapLinkMap.isEmpty()) {
//						boolean went = true;
//						for(Entry<String,String> listIt :newMapLinkMap.entrySet()){
//							if(listIt.getValue().equals(entry2.getKey())) {
//						 objectLink=	test1.getObject(mapIt.get(entry2.getKey()),tableName,cl.getSimpleName());
//						 went = false;
//							}
//						}
//						if(went) {
//						objectLink =	test1.getObject(entry2.getValue().toString(),tableName,cl.getSimpleName());
//						}
//						}else if (newMapLinkMap.isEmpty()) {
//							
//								 objectLink =	test1.getObject(entry2.getValue().toString(),tableName,cl.getSimpleName());
//					}
//						
//						
//						 mI = cl.getDeclaredMethod(vol, objectLink.getClass());
//						// arrayOrNot =  entry2.getValue();
//						
//						mI.invoke(thisi, objectLink);
//						} catch (ClassNotFoundException e) {
//							 mI = cl.getDeclaredMethod(vol, entry2.getValue().getClass());
//							 arrayOrNot =  entry2.getValue();
//								
//							mI.invoke(thisi, arrayOrNot);
//						}catch(NullPointerException np) {
//							//if theres not a relation between the parent and child table with the given key
//							removeString=true;
//						}
//					}
//					
				//else {
					if(!happened) {
				try {
			
				//use entry value in order to invoke the return type at runtime
				 mI = cl.getDeclaredMethod(vol, entry2.getValue().getClass());
				
					
				 mI.invoke(thisi, arrayOrNot);
				
				
				}catch(NullPointerException ne) {
					arrayOrNot ="null";
					//mI.invoke(thisi, arrayOrNot);
				}catch(NoSuchMethodException ex1) {
					vollist.add(vol);
				}
				
					}
					
				}
				
				test.add(thisi);
				documentList2.put(v,test.get(index));
				//downloadList.put(n, documentList2.get(v));
				
				n++;
				v++;
				index++;
			if(v>=2) {
				
				test1.setBrands(tempCheck.getClass().getSimpleName(),documentList2);
				//downloadList.clear();
				n=0;
				v++;
			}
//				}

		//try {
//				if(!removeString) {
//					
//					
//					if (!objectList.isEmpty()) {
//						Method mI=null;
//					for (int q =0;q<objectList.size();q++) {
//						String tableName =null;
//						
//						String vol ="set";
//					
//						if(stillLinkTrackerSetter.contains(objectList.get(q))) {
//							for(String it : stillLinkTrackerSetter) {
//								if(it.equals(objectList.get(q))) {
//									tableName =it;
//								}
//																	
//							}
//							
//					
//					}
//					else if(!stillLinkTrackerSetter.contains(objectList.get(q))){
//						try{
//							String temp[] =objectList.get(q).split("=");
//							if(stillLinkTrackerSetter.contains(temp[0])) {
//								tableName =temp[1];	
//							}
//						}catch(IndexOutOfBoundsException in ) {
//							
//						}
//						
//					}
//                       vol+=tableName.substring(0,1).toUpperCase() + tableName.substring(1);
//						
//						Object objectLink =	test1.getObject("nnnnnnnn-nnnn-nnnn-nnnn-nnnnnnnnnnnn",tableName,cl.getSimpleName());
//					
//						
//						
//						 mI = cl.getDeclaredMethod(vol, objectLink.getClass());
//						// arrayOrNot =  entry2.getValue();
//						
//						mI.invoke(thisi, objectLink);
//					
//				}
//					}else if (objectList.isEmpty()) {
//						objectList = ((ApiSuperClass) tempCheck).l1("nothing");
//					}
//				test.add(thisi);
//			documentList2.put(n,test.get(n));
//			//single instance 
//			n++;
//					
//			//the forien key was set reset
////			objectList =null;
////			try {
////				objectList = ((ApiSuperClass) tempCheck).l1("nothing");
////				}catch(NullPointerException n) {
////				System.out.println("No Links assoicated to class");
////			}
//				
////			}else if(!objectList.isEmpty()) {
////				logger2.error("Data Error With relation:  "+objectList.toString() +"issues: "+thisi);
////			}
////				}catch(NullPointerException e) {
////					test.add(thisi);
////					documentList2.put(n,test.get(n));
////					//single instance 
////					n++;
//			}
				removeString=false;
				}//else {
//					
//					for(Entry<Integer, Map<Integer, Object>> entryMethod: automaticIterationMap.entrySet()) {
//						//new instance  of the object  based of the class every loop
//						Object thisi2 = cl.newInstance();
//						//store data and while making iteration one to many to iterations
//						storeAllData(newMap,entry.getKey().toString(),tempMapTracker, thisi2,linkTrackerSetter,linkNumberTracker,cLarg,entryMethod);
//	
//					}
//					for (Entry<Integer, LinkedHashMap<Object, Object>> coorEntry1 : finalCorpMap.entrySet()) {
//						Object thisi2 = cl.newInstance();
//						//for(Entry<?, ?> coorEntry2 :((LinkedHashMap<?,?>) coorEntry1).entrySet()) {
//							StoreAllCoordinatesArray(newMap,cl,cLarg, thisi2,coorEntry1.getValue());
//							//newMap.put(coorEntry2.getKey().toString(),coorEntry2.getValue());
//						//}
//					}
//				}
//
//		
//	}//for(int x=0; x<((ArrayList<?>) entry.getValue()).size();x++) {
//			if (sizeI==1) {
//			test1 =null;
////			newMapLinkMap=null;
////			newMap=null;
////			linkTrackerSetter=null;
//			}
//			
//		}
//		//test1.closeConntection();
//	//	if(runit) {
//			try {
//				//test1.setBrands(tempCheck.getClass().getSimpleName(),documentList2);
//				test1.setObjects(tempCheck.getClass().getSimpleName(),downloadList);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//documentList2.clear();
			
//			newMapLinkMap=null;
//			newMap=null;
//			linkTrackerSetter=null;
		//}
			}
			
		}
		test1 =null;
	}
	
	@Ignore
	@Test 
	 public  void ManyToManyCOnversion() {
		
		
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
    
    public static void solve(int[] array,int i) {
    	//for the array size of our array length[0,0,0.....n] = x
    	if(i==array.length) {
    		addObjectsToProccess(array);
    		return;
    	}
    	//for the iteration number number we must handle weither its for many or one index this will be looped through many times newLinkMapsFinalFinal ->
    	//->Entry<Integer,TreeMap<Integer,String>> entry of newLinkMap ->solve loop for the number of iterations [1++,2++,3,4,5....n]
    	for(int k=0;k<iterationNumber;k++) {
    		//how many iterations each index basically the objects or the entries of my maps 
    		solve(array,i+1);
    		//add one  after every addObjectToProcess if its only more then one entry from newLinkMapsFinalFinal it will never get here i will update and longer be accepted 
    		addOne(array,i);
    	}
    	//sets back to one based on the index
    	reset(array,i);
    }
  
    public static void solveM(int[] array,int i,int lowestNumber) {
    	//for the array size of our array length[0,0,0.....n] = x
    	if(i==array.length) {
    		addObjectsToProccessM(array,lowestNumber);
    		return;
    	}
    	//for the iteration number number we must handle weither its for many or one index this will be looped through many times newLinkMapsFinalFinal ->
    	//->Entry<Integer,TreeMap<Integer,String>> entry of newLinkMap ->solve loop for the number of iterations [1++,2++,3,4,5....n]
    	for(int k=0;k<iterationNumber;k++) {
    		//how many iterations each index basically the objects or the entries of my maps 
    		solveM(array,i+1, lowestNumber);
    		//add one  after every addObjectToProcess if its only more then one entry from newLinkMapsFinalFinal it will never get here i will update and longer be accepted 
    		addOne(array,i);
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
    	
//    	//size of iteration list[1,2,3......n]
//    	//need to get one  map not two
//    		for(Entry<Integer, Map<Integer, TreeMap<Integer, String>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
//    			for(int index =0;index<list.size();index++) {
//    			//make test that sets object global and rein
//    		for(Entry<Integer, TreeMap<Integer,String>> entry2 : entry1.getValue().entrySet()) {
//    				for(Entry<Integer,String> entry3 : entry2.getValue().entrySet()) {
//    					if(entry3.getKey().equals(index+1)) {
//    					//int num = Integer.parseInt(Character.toString(entry2.getKey().toString().trim().charAt(entry2.getKey().toString().length()-1)));
//    					int num = entry3.getKey();
//    					//does our number equal the place of our array
//    					//last character equals the following spot [1,2,.....n]
//    					if(num == list.get(index)){
//    						System.out.println("index: "+list.get(index));
//    						System.out.println("Values: "+entry3.getValue());
//    						//if number entryKey greater then addNumber List skip placing in map
//    						
//    						//store var for objects [1,23] as Map :(
//    						//one,one=> first place ,, one,two => second place
//    						automaticGeneration.put(entry3.getKey()+"-"+entry1.getKey(),entry3.getValue());
//    						
//    					}
//    				}
//    				
//    			}
//    		}
//        	
//    	}
//    		
//    		//pass back a map of iterations store map and iteration
//       	 automaticIterationMap.put(xIterationTracker, automaticGeneration );
//    	}
//    	return automaticIterationMap;
    	
    }
    private static Map<Integer, Map<Integer, Object>> addObjectsToProccessM(int[] array,int lowestNumber) {
    	automaticGeneration = new LinkedHashMap<Integer,Object>();
    	xIterationTracker++;
    	
    	//Grabs one array of data at a time 
    	for(Entry<Integer, Map<Integer, TreeMap<Integer, Object>>> entry1 : newMapLinkMapFinalFinal.entrySet()) {
    		for(Entry<Integer, TreeMap<Integer,Object>> entry2 : entry1.getValue().entrySet()) {
    				Map<Integer,TreeMap<Integer,Object>> tempMap = new TreeMap<Integer,TreeMap<Integer,Object>>();
    				tempMap.put(entry2.getKey(), entry2.getValue());
    				GetOneMapM(tempMap, array,entry1.getKey(),lowestNumber,array[1]);
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
					removeList.add(mapEntry3.getKey());
					//how many we will take away in order to make correct number of permutation  while lowestNumber  is greater then itake dont add to remove list until over the NUmber of Array
					if(iTake>=lowestNumber) {
						//collect items to remove from list// no concurrent because im technically not editing the map im removing it from
					
					
					xReset++;
					//keep list map in order to add permutations later 
					//reset back to zero
					KeepTracker.put(xReset,(String) mapEntry3.getValue());
					
					numbersToAdd.put(entry.getKey(), KeepTracker);
				}
					iTake++;
				}
//				//loop through with list of keys in order to remove from list.
//				for(int x =0; x<removeList.size();x++) {
//					//Remove values from second Map 
//					entryMap2.getValue().remove(removeList.get(x));
//				
//				}
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
    	if(xIterationTracker == 1152) {
        	System.out.println("its at 1152");	
        	}
    	for (int index = 0; index < list.size(); index++) {
			for (Entry<Integer, TreeMap<Integer, Object>> entry : tempMap.entrySet()) {
				if (entry.getKey().equals(index + 1)) {
					for (Entry<Integer, Object> entry2 : entry.getValue().entrySet()) {
						int num = entry2.getKey().intValue();
						if (num == list.get(index)) {
							//System.out.print(entry2.getValue() + " ");
							automaticGeneration.put(entry.getKey(), entry2.getValue());
							break;
						}
					}

				}
              break;
			}
		}
    	
    	//pass back a map of iterations store map and iteration stops duplicates 
      	 automaticIterationMap.put(xIterationTracker, automaticGeneration );
    }
    public static void GetOneMapM(Map<Integer, TreeMap<Integer, Object>> tempMap, int[] array,Integer key,int lowestNumber,int timer) {
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<array.length;i++) {
    		//keeps track of index of array
    		list.add(array[i]);
    	}
    	
    	
    	for (int index = 0; index < list.size(); index++) {
			for (Entry<Integer, TreeMap<Integer, Object>> entry : tempMap.entrySet()) {
				if (entry.getKey().equals(index + 1)) {
					for (Entry<Integer, Object> entry2 : entry.getValue().entrySet()) {
						int num = entry2.getKey().intValue();
						if (num == list.get(index)) {
//							if() {
//								
//							}else {
							//System.out.print(entry2.getValue() + " ");
							automaticGeneration.put(entry.getKey(), entry2.getValue());
							break;
							//}
						}
					}

				}
              break;
			}
		}
    	
    	//pass back a map of iterations store map and iteration stops duplicates 
    	
      	 automaticIterationMap.put(xIterationTracker, automaticGeneration );
    	
    }
    public static void storeAllData(Map<String,Object> newMap,String entry,Map<Integer,String> tempMapTracker,Object thisi,Set<String> linkTrackerSetter,int linkNumberTracker,Class<?> cLarg,Entry<Integer, Map<Integer, Object>> entryMethod ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLIntegrityConstraintViolationException {
    	for(Entry<String,Object> entry2: newMap.entrySet()) {
    		Object methodSet;
			
			String vol ="set";
			////System.out.println(entry2.getKey().substring(1,2).toUpperCase());
			//vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
//			if(entry2.getKey().toUpperCase().contains(entry.toString().trim().toUpperCase())) {
//				break;
//			}
			//System.out.println("field : "+entry2.getKey());
			vol	+=	entry2.getKey().substring(0,1).toUpperCase() + entry2.getKey().substring(1);
			vol = vol.replaceAll(" ", "");
//			if(vol.equals("setD")) {
//				vol ="setId";
//			}
			

		try {
		//global time 	
		//Method  mI = tempCheck.getClass().getMethod(vol,cLarg);
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
				 String tableName = null;
				 for(String it :linkTrackerSetter) {
					 if(it.equals(entry2.getKey())) {
						 tableName= it;
					 }
				 }
				 
				 
//						if(connectSession) {
//							test1.getConnection(entry2.getValue().toString(),tableName);
//							connectSession=false;
//						}
//						
//						try {
//					     	Object objectLink;
//						
//							objectLink = test1.getObject(entry2.getValue().toString(),tableName,thisi.getClass().getSimpleName());
//						
//						
//						
//						
//						 mI = thisi.getClass().getDeclaredMethod(vol, objectLink.getClass());
//						// arrayOrNot =  entry2.getValue();
//							
//						mI.invoke(thisi, objectLink);
//						} catch (ClassNotFoundException e) {
//							 mI = thisi.getClass().getDeclaredMethod(vol, entry2.getValue().getClass());
//							 methodSet =  entry2.getValue();
//								
//							mI.invoke(thisi, methodSet);
//						} catch (InstantiationException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}catch(NullPointerException ne) {
//							removeString=true;
//						}
				 
				 
				 
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
    	if (!removeString) {
test.add(thisi);

	documentList2.put(n,test.get(n));
	n++;
    	}
	if(documentList2.size()>150) {
		System.out.println("theres 150");
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
    	}
    	test.add(thisi);
	documentList2.put(n,test.get(n));
	n++;
    	
    	
    	
    	
    	
    }
    
    

    /**
     * Rigourous Test :-)
     * @param object 
     * @return 
     */
   @Ignore
   // @Test
    public static Object httpTest(Object key)
    {
    	 //Object key
       CredentialsProvider provider = new BasicCredentialsProvider();
       UsernamePasswordCredentials credintaials =new UsernamePasswordCredentials("ADMTHREE.AC2OA@gmail.com","password1234");
       //UsernamePasswordCredentials credintaials =new UsernamePasswordCredentials("almsupportdesk@fuseserviceaccount.com","ALM2017!");
       provider.setCredentials(AuthScope.ANY, credintaials);
       HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
       Object thisi3 = null;
       Method mI3= null;
       Object objectTemp = null;
       Map<Object,Object> linked = new LinkedHashMap<Object,Object>();
       String vol4="";
       Object arrayOrNot=null;
       linked.put("Trackers",objectTemp);
       linked.put("Equipment",objectTemp );
       linked.put("Models", objectTemp);
       linked.put("Owner", objectTemp);
       linked.put("Series", objectTemp);
       linked.put("Brands", objectTemp);
       linked.put("ServiceSchedules", objectTemp);
      
       
       
       Class<?> cl2 = null;
	try {
		cl2 = Class.forName("com.productionDataClientProductionData.pojo."+Trackers.class.getSimpleName());
		thisi3 = cl2.newInstance();
	} catch (ClassNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     

       HttpResponse response = null;

		
		try {
			
			URIBuilder builder = new URIBuilder();
			builder.setScheme("https").setHost("agco-fuse-trackers-test.herokuapp.com").setPath("/trackers")
				.setParameter("equipment", key.toString())
			    .setParameter("include", "equipment.model.series,equipment,equipment.model,equipment.model.series.brand,equipment.model.equipmentType");
			URI uri;
			try {
				uri = builder.build();
				response =client.execute(new HttpGet(uri));
			} catch (URISyntaxException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			

	
		
     BufferedReader bf = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
	//BufferedReader bf = new BufferedReader(new FileReader("C:/Users/josephjo/Documents/TestFile.json"));
			StringBuffer sb = new StringBuffer();
		if (response.getStatusLine().getStatusCode()!=200) { 
			throw new RuntimeException("Failed  http Error Code: " + response.getStatusLine().getStatusCode());
		}
		//Object one =JSONValue.parse(response.getEntity().toString());
		//try {
			//JSONValue.parseWithException(bf);
		String output;
			while((output=bf.readLine()) != null) {
				System.out.println(output);
				sb.append(output);
			}
			
			Object jsonO;
			
			try {
				jsonO =new JSONParser().parse(sb.toString());
				//LinkedHashMap<Object,Object> thisi= new LinkedHashMap<Object,Object>()jsonO);
				System.out.println(jsonO);
				//(HashMap<?, ?>) jsonO)getClass().getClass().getde
				//Object myObjects = mapper.readValue(output, String.class);
			
				for(Entry<?,?> entry : ((HashMap<?, ?>) jsonO).entrySet()){
					try {
						if(entry.getKey().toString().equals("links")) {
							continue;
						}
						
					       
					JSONArray array = (JSONArray) entry.getValue();
					for(int c =0; c<array.size();c++){
						for(Entry<?,?> entry2 : ((HashMap<?,?>)array.get(c)).entrySet()) {
							if(entry2.getKey().toString().equals("links")) {
								continue;
							}
							vol4= "set"+entry2.getKey().toString().substring(0,1).toUpperCase()+entry2.getKey().toString().substring(1);
							System.out.println(entry2.getKey()+" = "+entry2.getValue());

							try {
								
								mI3 = cl2.getDeclaredMethod(vol4, entry2.getValue().getClass());	
								//use entry value in order to invoke the return type at runtime
								
								 arrayOrNot =  entry2.getValue();
								 //Object thisi2 =cl2.newInstance();
								 mI3.invoke(thisi3, arrayOrNot);
								
								arrayOrNot = thisi3;
								}catch(NullPointerException ne) {
									arrayOrNot ="null";
									//mI.invoke(thisi, arrayOrNot);
								}catch(NoSuchMethodException ex1) {
									vollist.add(vol4);
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
							
							
							
							
													}
						linked.put(thisi3.getClass().getSimpleName(),thisi3);
					}
					}catch(ClassCastException cee){
						for(Entry<?,?> entry3 : ((HashMap<?,?>)entry.getValue()).entrySet()){
							System.out.println(entry3.getKey()+" = "+entry3.getValue());
							//linked.put(entry3.getKey().toString().trim(), entry3.getValue());
							JSONArray array = (JSONArray) entry3.getValue();
							try {
								cl2 = Class.forName("com.productionDataClientProductionData.pojo."+entry3.getKey().toString().substring(0, 1).toUpperCase()+entry3.getKey().toString().substring(1));
								thisi3 = cl2.newInstance();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for(int c =0; c<array.size();c++){	
								for(Entry<?,?> entry4 : ((HashMap<?,?>)array.get(c)).entrySet()) {
									System.out.println(entry4.getKey()+" = "+entry4.getValue());
									vol4= "set"+(entry4.getKey().toString().substring(0,1).toUpperCase()+entry4.getKey().toString().substring(1));
									try{
									mI3 = cl2.getDeclaredMethod(vol4, entry4.getValue().getClass());	
									//use entry value in order to invoke the return type at runtime
									
									 arrayOrNot =  entry4.getValue();
									 //Object thisi2 =cl2.newInstance();
									 mI3.invoke(thisi3, arrayOrNot);
									
									arrayOrNot = thisi3;
									}catch(NullPointerException ne) {
										arrayOrNot ="null";
										//pull Not avaiable from database
										
										//mI.invoke(thisi, arrayOrNot);
									}catch(NoSuchMethodException ex1) {
										vollist.add(vol4);
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
									
									
									
									
									
								}
								linked.put(thisi3.getClass().getSimpleName(),thisi3);
							}
							}
						for(Entry<?,?> entry5: linked.entrySet()) {
							try {
							cl2 = Class.forName("com.productionDataClientProductionData.pojo."+entry5.getValue().getClass().getSimpleName());
							thisi3 = entry5.getValue();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}catch(NullPointerException ne) {
							System.out.println(entry5.getKey());
						}
							
							
							for(Entry<?,?> entry6:linked.entrySet()) {//loop through again and set the objects only will set if the method is there 
								try {
									vol4= "set"+entry6.getKey().toString();
									
									
									
									mI3 = cl2.getDeclaredMethod(vol4, entry6.getValue().getClass());
									
									mI3.invoke(entry5.getValue(), entry6.getValue());
									
									
								} catch (NoSuchMethodException e) {
									// TODO Auto-generated catch block
									vollist.add(vol4);
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
								}catch(NullPointerException ne) {
									arrayOrNot ="null";
								}
							}
						}
					}
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println(linked.toString());
		
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//		try {
//			test1.getConnection("ID", "trackers");
//			test1.setTrackers("Trackers",linked.get("Trackers"));
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
   documentList2.put(v,linked.get("Trackers"));
   linked.clear();
   v++;
   return linked.get("Equipment");
		
		
		
       
    }
}
