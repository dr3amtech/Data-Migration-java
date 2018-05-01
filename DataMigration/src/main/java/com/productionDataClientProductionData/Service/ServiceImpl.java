package com.productionDataClientProductionData.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.mail.Session;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productionDataClient.ProductionData.Utilities.EmailUtil;
import com.productionDataClientProductionData.DAO.SessionDaoImpl;
import com.productionDataClientProductionData.impl.ApiSuperClass;
import com.productionDataClientProductionData.impl.Service;
import com.productionDataClientProductionData.impl.SessionDAO;
import com.productionDataClientProductionData.pojo.CanVariablesL;
import com.productionDataClientProductionData.pojo.Duties;
import com.productionDataClientProductionData.pojo.Equipment;
import com.productionDataClientProductionData.pojo.Trackers;

public class ServiceImpl implements Service {
	private static Logger logger = LogManager
			.getLogger(com.productionDataClientProductionData.Service.ServiceImpl.class.getName());

	private static SessionDAO sessionSendToDB = new SessionDaoImpl();
	private final String packName = "com.productionDataClientProductionData.pojo.";
	private static Map<Integer, Object> documentList2 = new TreeMap<Integer, Object>();
	private static Map<Integer, Object> documentList3 = new TreeMap<Integer, Object>();
	private static List<String> vollist = new ArrayList<String>();
	private static ClassLoader loader = Thread.currentThread().getContextClassLoader();
	private static boolean doNotAdd = true;
	private static int v = 0;
	private static InputStream input = loader.getResourceAsStream("APIs.properties");
	private static Object tempObject = null;
	private static List<Object> tempList = new ArrayList<Object>();
	private static boolean split = true;
	public static int offSet=0;

	@Override
	public Map<String, String> getApiCalls() {
		StringBuilder sb = new StringBuilder();
		sendMail("Data Migration has begun -\n ");
		Map<String, String> propertiesMap = new LinkedHashMap<String, String>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(input));
		try {
			// returns back 0-65535 or -1 end of line cast into a character, 0 being space
			for (int c; (c = bf.read()) != -1;) {
				if (c != 0) {
					sb.append((char) c);
				}
			}
		} catch (IOException e) {
			logger.error(e);
		} catch (NullPointerException n) {
			logger.error(n);
		}
		// split up properties files
		String[] places = sb.toString().split("\\r\\n");
		// loop through properties files slplits in order to have key and values used
		// for pojo and api call
		for (int x = 0; x < places.length; x++) {
			String[] temp = places[x].split("=");
			try {
				propertiesMap.put(temp[0], temp[1]);
				// }
			} catch (IndexOutOfBoundsException i) {
				logger.error(i);
				// i.printStackTrace();
			}
		}
		return propertiesMap;
	}

	@Override
	public void getJSonObject() {

		Map<String, String> proerptiesMap = getApiCalls();
		// one array index of classes
		Class<?>[] cLarg = new Class[1];
		cLarg[0] = String.class;
		ClientConfig clientConfig = new ClientConfig();
		// build new client for request
		Client client = ClientBuilder.newClient(clientConfig);
		// Authenticate Access
		HttpAuthenticationFeature access = HttpAuthenticationFeature.basicBuilder()
				.credentials("").build();
		// Define and build URI for WebTarget
		WebTarget webTarget = client.target(UriBuilder.fromUri("http://agco-fuse-trackers.herokuapp.com").build());
		// verify access permission
		webTarget.register(access);
		// mapper object for pojos
		ObjectMapper mapper = new ObjectMapper();
		List<String> missedNewData = new ArrayList<String>();

		// loop though properties file data
		for (Entry<String, String> property : proerptiesMap.entrySet()) {
			mapper.configure(MapperFeature.USE_ANNOTATIONS, true);
			Object tempObject = null;
			// reflect on class given the class name
			Class<?> cl;
			try {
				// reflect on the given class
				// cl = Class.forName(packName.trim()+property.getKey().toString().trim());
				cl = Class.forName(packName.trim() + property.getKey().toString().trim());

				// API call/Query Application/json Get Request(deserialize JSON content)
				// for(int c =0; c<3;c++) {
				tempObject = mapper.readValue(webTarget.path(property.getValue().toString().trim()).queryParam("offset", ServiceImpl.offSet)
						.request(MediaType.APPLICATION_JSON).get(String.class), cl);
				// ServiceImpl.tempObject = tempObject;
				tempList.add(tempObject);
				tempObject.equals("null");
				// wirteToFile(tempObject);
				// }

			} catch (ClassNotFoundException e) {
				missedNewData.add(property.getKey().toString().trim());
				// logger.error(e);
				continue;
			} catch (JsonParseException e) {
				logger.error(e);
			} catch (JsonMappingException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			} catch (NotAuthorizedException e) {
				logger.error("User: " + "almsupportdesk@fuseserviceaccount.com no longer has access" + e);
			} catch (NullPointerException n) {

			}
		}

		logger.info("Errors: " + missedNewData.size());
		logger.info(missedNewData.toString());
		// return tempObject;
	}

	// @Override
	// public void run() {
	// try {
	// while(completed) {
	// logger.info("Thread = "+Thread.currentThread().getId());
	// System.out.println("Thread = "+Thread.currentThread().getId());
	// DataCollection();
	// completed = false;
	// }
	// }catch(Exception e){
	// //System.out.println("caught it");
	// }
	//
	// }
	// @Override
	// public void storeData() {
	// getJSonObject();
	// }
	@Override
	public void DataCollection(int offSet) {
		ServiceImpl.offSet =offSet;
		getJSonObject();
		int xt = 0;
		for (int d = 0; d < tempList.size(); d++) {
			Class<?> cl = tempList.get(d).getClass();
			Map<String, Object> newMap = new LinkedHashMap<String, Object>();
			List<LinkedHashMap> mapListONE = new ArrayList<LinkedHashMap>();
			Set<String> linkTrackerSetter = new HashSet<String>();
			Set<String> stillLinkTrackerSetter = new HashSet<String>();
			Map<String, String> newMapLinkMap = new TreeMap<String, String>();// Maybe a link map instead and var links
																				// not getting set for new code nor is
																				// it running a sceond time
			List<String> mapList = new ArrayList<String>();
			LinkedHashMap<Object, Object> corrMap = new LinkedHashMap<Object, Object>();
			Map<String, List<String>> mapIt = new LinkedHashMap<String, List<String>>();
			Map<Integer, LinkedHashMap<Object, Object>> finalCorpMap = new LinkedHashMap<Integer, LinkedHashMap<Object, Object>>();
			List<Object> test = new LinkedList<Object>();
			boolean anyObject = false;
			documentList2 = new TreeMap<Integer, Object>();

			HashMap<? extends Object, ? extends Object> entryMap = (HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) tempList
					.get(d)).getAdditionalProperties();
			try {
				for (Entry<? extends Object, ? extends Object> entryWorld : ((LinkedHashMap<?, ?>) entryMap
						.get("links")).entrySet()) {
					for (Entry<? extends Object, ? extends Object> entryWorld2 : ((LinkedHashMap<?, ?>) entryWorld
							.getValue()).entrySet()) {
						if (entryWorld2.getKey().equals("type")) {
							stillLinkTrackerSetter.add(entryWorld2.getValue().toString());

						}
					}
				}
			} catch (NullPointerException n) {
				// log
			}
			entryMap.remove("links");

			for (Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()) {

				int index = 0;
				System.out.println(((ArrayList<?>) entry.getValue()).size());
				for (Object entryh2 : (ArrayList<?>) entry.getValue()) {
					newMap = new LinkedHashMap<String, Object>();
					linkTrackerSetter = new HashSet<String>();
					newMapLinkMap = new TreeMap<String, String>();
					mapList = new ArrayList<String>();
					mapIt = new LinkedHashMap<String, List<String>>();
					// System.out.println(entryh2.toString());
					LinkedHashMap<?, ?> lastEntry1 = ((LinkedHashMap<?, ?>) entryh2);
					for (Entry<?, ?> lastEntry : lastEntry1.entrySet()) {
						// System.out.println(lastEntry.getKey()+" - "+lastEntry.getValue());
						newMap.put(lastEntry.getKey().toString(), lastEntry.getValue());

						if (lastEntry.getKey().equals("links")) {
							String remove = null;

							int xInt = 0;
							for (Entry<?, ?> entryLinks : ((LinkedHashMap<?, ?>) lastEntry.getValue()).entrySet()) {
								boolean first = true;
								// System.out.println(entryLinks.getKey());

								try {
									xInt = ((ArrayList<?>) entryLinks.getValue()).size();

									for (int entryLinksArray = 0; entryLinksArray < ((ArrayList<?>) entryLinks
											.getValue()).size(); entryLinksArray++) {

										newMapLinkMap.put(
												((ArrayList<?>) entryLinks.getValue()).get(entryLinksArray).toString(),
												(String) entryLinks.getKey());
										mapList.add(
												((ArrayList<?>) entryLinks.getValue()).get(entryLinksArray).toString());
										newMap.put(entryLinks.getKey().toString(), "");
										if (first) {
											remove = ((ArrayList<?>) entryLinks.getValue()).get(entryLinksArray)
													.toString();
										}

									}
									mapIt.put(entryLinks.getKey().toString(), mapList);
								} catch (ClassCastException cee) {
									// logger.info("link was not an array");
									boolean wasItSet = false;
									for (String it : stillLinkTrackerSetter) {
										if (it.contains(entryLinks.getKey().toString())) {
											newMap.put(it, entryLinks.getValue().toString());
											wasItSet = true;
										}
									}
									if (!wasItSet) {

										newMap.put(entryLinks.getKey().toString(), entryLinks.getValue().toString());
										wasItSet = false;
									}

								}
								if (xInt == 1) {
									linkTrackerSetter.remove(entryLinks.getKey().toString());

									newMap.put(entryLinks.getKey().toString(), remove);

								}
								first = false;
							}
						} else if (lastEntry.getKey().equals("location") || lastEntry.getKey().equals("geospatial")) {
							// check for coordinates
							for (Entry<?, ?> entryLocation : ((LinkedHashMap<?, ?>) lastEntry.getValue()).entrySet()) {
								// System.out.println(entryLocation);
								if (lastEntry.getKey().equals("location")) {
									try {

										for (int locationPoints = 0; locationPoints < ((ArrayList<?>) entryLocation
												.getValue()).size(); locationPoints++) {

											newMap.put("coordinates" + (locationPoints + 1),
													((ArrayList<?>) entryLocation.getValue()).get(locationPoints));
											newMap.remove("geospatial");
											newMap.remove("type");

										}

									} catch (ClassCastException cee1) {
										// System.out.println("was not a coordinate");
										newMap.put(entryLocation.getKey().toString(), entryLocation.getValue());

									}
								} else if (lastEntry.getKey().equals("geospatial")) {
									for (Entry<?, ?> geospatialEntry : ((LinkedHashMap<?, ?>) lastEntry.getValue())
											.entrySet()) {
										try {

											for (int coordinateXint = 0; coordinateXint < ((ArrayList<?>) geospatialEntry
													.getValue()).size(); coordinateXint++) {
												int corTrack = 1;
												for (int nestedArray = 0; nestedArray < ((ArrayList<?>) ((ArrayList<?>) geospatialEntry
														.getValue()).get(coordinateXint)).size(); nestedArray++) {
													corrMap = new LinkedHashMap<Object, Object>();
													int x = 1;
													for (int hopefully = 0; hopefully < ((ArrayList<?>) ((ArrayList<?>) ((ArrayList<?>) geospatialEntry
															.getValue()).get(coordinateXint)).get(nestedArray))
																	.size(); hopefully++) {

														// System.out.println("Coor"+x
														// +":"+((ArrayList<?>)((ArrayList<?>)((ArrayList<?>)geospatialEntry.getValue()).get(coordinateXint)).get(nestedArray)).get(hopefully));

														newMap.put(geospatialEntry.getKey().toString() + x, "");

														corrMap.put(geospatialEntry.getKey().toString() + x,
																((ArrayList<?>) ((ArrayList<?>) ((ArrayList<?>) geospatialEntry
																		.getValue()).get(coordinateXint))
																				.get(nestedArray)).get(hopefully));
														x++;
													}

													finalCorpMap.put(corTrack, corrMap);
													corTrack++;

												}

											}
										} catch (ClassCastException cee) {
											// System.out.println("Not an issue");
											newMap.put(geospatialEntry.getKey().toString(), geospatialEntry.getValue());
										}
									}
								}
							}
						} else if (anyObject && entry.getKey().equals("latestTelemetries")) {
							for (Entry<?, ?> objectEntry : ((LinkedHashMap<?, ?>) lastEntry.getValue()).entrySet()) {
								// System.out.println(objectEntry);
								try {
									for (Entry<?, ?> nameEntry : ((LinkedHashMap<?, ?>) objectEntry.getValue())
											.entrySet()) {
										newMap.put(lastEntry.getKey().toString() + nameEntry.getKey().toString(),
												nameEntry.getValue());

									}
									newMap.put(lastEntry.getKey().toString(), objectEntry.getKey());

								} catch (ClassCastException cee) {
									// System.out.println("was not Array of Head");
									newMap.put(lastEntry.getKey().toString() + objectEntry.getKey().toString(),
											objectEntry.getValue());
									newMap.remove(lastEntry.getKey());
								}

							}
							anyObject = false;

						}

					}

					// for(Entry<String,Object> entry77: newMap.entrySet()){
					// try {
					// // System.out.println("Key:"+entry77.getKey()+"-
					// Value:"+entry77.getValue().toString());
					// }catch(NullPointerException n) {
					// System.out.println("Not an issue");
					// }
					// }

					// runtime instance
					Object thisi = null;
					try {
						thisi = cl.newInstance();
					} catch (InstantiationException e) {
						// the class object represents an abstract class, an interface, an array class,
						// a primitive type, or void
						// the class has no nullary constructor

						e.printStackTrace();
					} catch (IllegalAccessException e) {
						logger.error(e);
					}

					// for(Entry<String,Object> entryMap2 : newMap.entrySet()) {
					// System.out.println(entryMap2.getKey());
					// System.out.println(entryMap2.getValue());
					// }

					if (linkTrackerSetter.isEmpty() && finalCorpMap.isEmpty()) {
						xt++;
						mapListONE.add((LinkedHashMap) newMap);
						if (xt > 285 & split) {
							wirteToFile2(mapListONE, split, cl.getSimpleName());
							// Object thisObject = subDataCollection(newMap,thisi,cl);
							xt = 0;
						} else if ((xt<=100) & (!split)) {
							wirteToFile2(mapListONE, split, cl.getSimpleName());
							xt = 0;
						}
					}
				}
			}
			// try {
			// thisObject.equals(null);
			// test.add(thisObject);
			// documentList2.put(v,test.get(index));
			// v++;
			// index++;
			// }catch(NullPointerException e) {
			// //logger.info("Bad data");
			// }

			// 240
			// if(v>249) {
			// //Joshua
			// //sessionSendToDB.setObject(tempObject.getClass().getSimpleName(),documentList1);
			// documentList3 = sessionSendToDB.checkForUpdate(documentList2);
			// sessionSendToDB.setObject(tempObject.getClass().getSimpleName(),documentList3);
			// test.clear();
			// documentList2.clear();
			// documentList3.clear();
			// v=0;
			// //index=0;
			// }

		}
		//
		// }
		// }

		// }
		// documentList3 = sessionSendToDB.checkForUpdate(documentList2);
		// sessionSendToDB.setObject(tempObject.getClass().getSimpleName(),documentList2);
		// //notify();
		// sessionSendToDB.closeSession();

	}

	@Override
	public Object trackerCollection(Object key) {
		// Object key
		CredentialsProvider provider = new BasicCredentialsProvider();
		// UsernamePasswordCredentials credintaials =new
		// UsernamePasswordCredentials("ADMTHREE.AC2OA@gmail.com","password1234");
		UsernamePasswordCredentials credintaials = new UsernamePasswordCredentials(
				"almsupportdesk@fuseserviceaccount.com", "ALM2017!");
		provider.setCredentials(AuthScope.ANY, credintaials);
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		Object thisi3 = null;
		Method mI3 = null;
		Object objectTemp = null;
		Map<Object, Object> linked = new LinkedHashMap<Object, Object>();
		List<Object> listHolder = new ArrayList<Object>();
		String vol4 = "";
		Object arrayOrNot = null;
		boolean isItTrue = false;
		linked.put("GwODXLiteConfigurations", objectTemp);
		linked.put("StandardUnits", objectTemp);
		linked.put("ComServiceLevels", objectTemp);
		linked.put("CanVariables", objectTemp);
		linked.put("Dealers", objectTemp);
		linked.put("Owners", objectTemp);
		linked.put("EquipmentTypes", objectTemp);
		linked.put("Series", objectTemp);
		linked.put("Brands", objectTemp);
		linked.put("ServiceSchedules", objectTemp);
		linked.put("Models", objectTemp);
		linked.put("Equipment", objectTemp);
		linked.put("Configurations", objectTemp);
		linked.put("Trackers", objectTemp);

		Class<?> cl2 = null;
		try {
			cl2 = Class.forName(packName + Trackers.class.getSimpleName());
			thisi3 = cl2.newInstance();
		} catch (ClassNotFoundException e2) {
			// logger.error(e2);
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		}

		HttpResponse response = null;

		try {

			URIBuilder builder = new URIBuilder();
			builder.setScheme("https").setHost("agco-fuse-trackers.herokuapp.com").setPath("/trackers")
					.setParameter("equipment", key.toString()).setParameter("include",
							"comServiceSubscription,comServiceLevel,configuration,configuration.canVariables,configuration.canVariables.standardUnit,equipment,equipment.model,equipment.model.series,equipment.model.series.brand,equipment.model.equipmentType,equipment.model.serviceSchedule,equipment.owner,equipment.owner.visibleToDealers.address_country.region,equipment.owner.visibleToDealers.provider_code");
			URI uri;
			try {
				uri = builder.build();
				response = client.execute(new HttpGet(uri));
			} catch (URISyntaxException e2) {
				logger.error(e2);
			}

			BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer();
			if (response.getStatusLine().getStatusCode() != 200) {
				logger.error("Failed  http Error Code: " + response.getStatusLine().getStatusCode());
				throw new RuntimeException("Failed  http Error Code: " + response.getStatusLine().getStatusCode());

			}
			// Object one =JSONValue.parse(response.getEntity().toString());
			// try {
			// JSONValue.parseWithException(bf);
			String output;
			while ((output = bf.readLine()) != null) {
				// System.out.println(output);
				sb.append(output);
			}

			Object jsonO;

			try {
				jsonO = new JSONParser().parse(sb.toString());
				// LinkedHashMap<Object,Object> thisi= new LinkedHashMap<Object,Object>()jsonO);
				// System.out.println(jsonO);
				// (HashMap<?, ?>) jsonO)getClass().getClass().getde
				// Object myObjects = mapper.readValue(output, String.class);

				for (Entry<?, ?> entry : ((HashMap<?, ?>) jsonO).entrySet()) {
					try {
						if (entry.getKey().toString().equals("links")) {
							continue;
						}

						JSONArray array = (JSONArray) entry.getValue();
						for (int c = 0; c < array.size(); c++) {
							for (Entry<?, ?> entry2 : ((HashMap<?, ?>) array.get(c)).entrySet()) {

								if (entry2.getKey().toString().equals("links")) {
									continue;
								}
								vol4 = "set" + entry2.getKey().toString().substring(0, 1).toUpperCase()
										+ entry2.getKey().toString().substring(1);
								// System.out.println(entry2.getKey()+" = "+entry2.getValue());

								try {

									mI3 = cl2.getDeclaredMethod(vol4, entry2.getValue().getClass());
									// use entry value in order to invoke the return type at runtime

									arrayOrNot = entry2.getValue();
									// Object thisi2 =cl2.newInstance();
									mI3.invoke(thisi3, arrayOrNot);

									arrayOrNot = thisi3;
								} catch (NullPointerException ne) {
									arrayOrNot = "null";
									// mI.invoke(thisi, arrayOrNot);
								} catch (NoSuchMethodException ex1) {
									// vollist.add(vol4);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									logger.error(e);
								}

							}
							linked.put(thisi3.getClass().getSimpleName(), thisi3);
						}
					} catch (ClassCastException cee) {
						for (Entry<?, ?> entry3 : ((HashMap<?, ?>) entry.getValue()).entrySet()) {
							// System.out.println(entry3.getKey()+" = "+entry3.getValue());
							// linked.put(entry3.getKey().toString().trim(), entry3.getValue());

							JSONArray array = (JSONArray) entry3.getValue();
							try {
								cl2 = Class.forName(packName + entry3.getKey().toString().substring(0, 1).toUpperCase()
										+ entry3.getKey().toString().substring(1));
								thisi3 = cl2.newInstance();
							} catch (ClassNotFoundException e1) {
								// logger.error(e1);
							} catch (InstantiationException e) {
								logger.error(e);
							} catch (IllegalAccessException e) {
								logger.error(e);
							}
							for (int c = 0; c < array.size(); c++) {
								try {
									cl2 = Class
											.forName(packName + entry3.getKey().toString().substring(0, 1).toUpperCase()
													+ entry3.getKey().toString().substring(1));
									thisi3 = cl2.newInstance();
								} catch (ClassNotFoundException e1) {
									// logger.error(e1);
								} catch (InstantiationException e) {
									logger.error(e);
								} catch (IllegalAccessException e) {
									logger.error(e);
								}
								for (Entry<?, ?> entry4 : ((HashMap<?, ?>) array.get(c)).entrySet()) {

									// System.out.println(entry4.getKey()+" = "+entry4.getValue());
									vol4 = "set" + (entry4.getKey().toString().substring(0, 1).toUpperCase()
											+ entry4.getKey().toString().substring(1));
									try {
										mI3 = cl2.getDeclaredMethod(vol4, entry4.getValue().getClass());
										// use entry value in order to invoke the return type at runtime

										arrayOrNot = entry4.getValue();
										// Object thisi2 =cl2.newInstance();
										mI3.invoke(thisi3, arrayOrNot);

										arrayOrNot = thisi3;
									} catch (NullPointerException ne) {
										arrayOrNot = "null";
										// pull Not avaiable from database

										// mI.invoke(thisi, arrayOrNot);
									} catch (NoSuchMethodException ex1) {
										// vollist.add(vol4);
									} catch (IllegalAccessException e) {
										logger.error(e);
									} catch (IllegalArgumentException e) {
										logger.error(e);
									} catch (InvocationTargetException e) {
										logger.error(e);
									}
									try {
										mI3 = cl2.getDeclaredMethod("dontAddData");
										isItTrue = (boolean) mI3.invoke(thisi3);

									} catch (NoSuchMethodException e) {
										// vollist.add(vol4);
									} catch (SecurityException e) {
										logger.error(e);
									} catch (InvocationTargetException e) {
										logger.error(e);
									} catch (IllegalAccessException e) {
										logger.error(e);
									}

									// if(thisi3.getClass().getSimpleName().equals("Models")) {
									// System.out.println("Models");
									// }

								}
								// if(thisi3.getClass().getSimpleName().equals("CanVariables")) {
								// Object listObject = thisi3;
								listHolder.add(thisi3);
								// }else {
								// linked.put(thisi3.getClass().getSimpleName(),thisi3);
								// }
								// if(thisi3.getClass().getSimpleName().equals("CanVariables"))

								// }
							}
							if (listHolder.size() <= 1) {
								linked.put(thisi3.getClass().getSimpleName(), thisi3);
								listHolder.clear();
							} else {
								linked.put(thisi3.getClass().getSimpleName(), listHolder);
								listHolder = new ArrayList<Object>();
								// listHolder.clear();
							}
						}
						try {
							List<Object> newList = new ArrayList<Object>();
							newList = (List<Object>) linked.get("CanVariables");
							for (int h = 0; h < newList.size(); h++) {

								try {
									cl2 = Class.forName(packName + "CanVariables");
									thisi3 = cl2.newInstance();

									mI3 = cl2.getDeclaredMethod("setStandardUnits",
											((ArrayList<?>) linked.get("StandardUnits")).get(h).getClass());

									mI3.invoke(newList.get(h), ((ArrayList<?>) linked.get("StandardUnits")).get(h));

								} catch (ClassNotFoundException e1) {
									// logger.error(e1);
								} catch (InstantiationException e) {
									logger.error(e);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (NoSuchMethodException e) {
									// logger.error(e);
								} catch (SecurityException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IndexOutOfBoundsException in) {

								}
							}
						} catch (NullPointerException n) {

						}
						for (Entry<?, ?> entry5 : linked.entrySet()) {
							try {

								cl2 = Class.forName(packName + entry5.getValue().getClass().getSimpleName());
								thisi3 = entry5.getValue();
							} catch (ClassNotFoundException e1) {
								// logger.error(e1);
							} catch (NullPointerException ne) {
								// System.out.println(entry5.getKey());
							}

							for (Entry<?, ?> entry6 : linked.entrySet()) {// loop through again and set the objects only
																			// will set if the method is there
								try {
									vol4 = "set" + entry6.getKey().toString();

									mI3 = cl2.getDeclaredMethod(vol4, entry6.getValue().getClass());

									mI3.invoke(entry5.getValue(), entry6.getValue());

								} catch (NoSuchMethodException e) {
									vollist.add(vol4);
								} catch (SecurityException e) {
									logger.error(e);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									logger.error(e);
								} catch (NullPointerException ne) {
									arrayOrNot = "null";
									// logger.error(ne);
								}
							}
						}
					}

				}
			} catch (ParseException e) {
				logger.error(e);
			}

			// System.out.println(linked.toString());

		} catch (IOException e1) {
			logger.error(e1);
		}

		// try {
		// linked.get("Configurations").equals(null);
		// linked.get("Equipment").equals(null);
		// linked.get("Dealers").equals(null);
		// linked.get("Owners").equals(null);
		// if(!isItTrue) {
		// documentList2.put(v,linked.get("Trackers"));
		// v++;
		// }else {
		// doNotAdd = false;
		// linked.clear();
		// return null;
		// }
		// }catch(NullPointerException e) {
		// doNotAdd = false;
		// logger.info("No Such Equipment Exist (Trackers)");
		// }

		documentList2.put(v, linked.get("Trackers"));
		v++;
		return linked.get("Equipment");

	}

	@Override
	public Object subDataCollection(Map<String, Object> newMap, Object thisi, Class<?> cl) {
		doNotAdd = true;
		// try {
		// newMap.get("duty").equals(null);
		// newMap.get("equipment").equals(null);
		// newMap.get("canVariables").equals(null);
		// }catch(NullPointerException n) {
		// return null;
		// }
		Method mI = null;
		for (Entry<String, Object> entry2 : newMap.entrySet()) {

			// equipmentCollection(entry2.get);

			Object arrayOrNot = null;
			boolean happened = false;

			String vol = "set";
			arrayOrNot = entry2.getValue();
			vol += entry2.getKey().substring(0, 1).toUpperCase() + entry2.getKey().substring(1);

			if (entry2.getKey().toString().equals("equipment")) {
				for (Entry<?, ?> entryEquipment : ((LinkedHashMap<?, ?>) entry2.getValue()).entrySet()) {

					// get tracker
					Object tempObjectE = trackerCollection(entryEquipment.getValue().toString());
					// Object tempObjecte = httpTest(MadeData.get(index));

					// Object tempObjectE =
					// equipmentCollection(entryEquipment.getValue().toString());

					try {
						tempObjectE.equals(null);
					} catch (NullPointerException ne) {
						return null;

					}

					try {

						// tempObject = test1.getObject("ffad8624-3ecf-4b5c-a03a-fb5e135e227a",
						// "Equipment", "latestTelemetries");

						mI = cl.getDeclaredMethod(vol, tempObjectE.getClass());
						// use entry value in order to invoke the return type at runtime

						// Object thisi2 =cl2.newInstance();
						try {
							mI.invoke(thisi, tempObjectE);
						} catch (IllegalAccessException e) {
							logger.error(e);
						} catch (IllegalArgumentException e) {
							logger.error(e);
						} catch (InvocationTargetException e) {
							logger.error(e);
						}

					} catch (NullPointerException ne) {
						arrayOrNot = "null";
						// mI.invoke(thisi, arrayOrNot);
					} catch (NoSuchMethodException ex1) {
						// vollist.add(vol);
					}
					happened = true;
				}
			} else if (entry2.getKey().toString().equals("canVariables")) {
				Class<?> cl2 = null;
				try {
					cl2 = Class.forName(packName + CanVariablesL.class.getSimpleName());
				} catch (ClassNotFoundException e) {
					// logger.error(e);
				}
				List<Object> newTempList = new ArrayList<Object>();
				Method mI2 = null;
				for (Entry<?, ?> entryCan : ((LinkedHashMap<?, ?>) entry2.getValue()).entrySet()) {

					Object thisi2 = null;
					try {
						thisi2 = cl2.newInstance();
					} catch (InstantiationException e1) {
						logger.error(e1);
					} catch (IllegalAccessException e1) {
						logger.error(e1);
					}
					String vol2 = "setName";
					try {
						mI2 = cl2.getDeclaredMethod(vol2, entryCan.getKey().getClass());
					} catch (NoSuchMethodException e1) {
						// logger.error(e1);
					} catch (SecurityException e1) {
						logger.error(e1);
					}
					arrayOrNot = entryCan.getKey();
					try {
						mI2.invoke(thisi2, arrayOrNot);
					} catch (IllegalAccessException e1) {
						logger.error(e1);
					} catch (IllegalArgumentException e1) {
						logger.error(e1);
					} catch (InvocationTargetException e1) {
						logger.error(e1);
					}
					for (Entry<?, ?> entryCan2 : ((LinkedHashMap<?, ?>) entryCan.getValue()).entrySet()) {
						// for(Entry<?,?> entryCan3 :((LinkedHashMap<?,?>)
						// entryCan2.getValue()).entrySet()) {
						String vol3 = "set" + entryCan2.getKey().toString().substring(0, 1).toUpperCase()
								+ entryCan2.getKey().toString().substring(1);

						try {

							mI2 = cl2.getDeclaredMethod(vol3, entryCan2.getValue().getClass());
							// use entry value in order to invoke the return type at runtime

							arrayOrNot = entryCan2.getValue();
							// Object thisi2 =cl2.newInstance();
							try {
								mI2.invoke(thisi2, arrayOrNot);
							} catch (IllegalAccessException e) {
								logger.error(e);
							} catch (IllegalArgumentException e) {
								logger.error(e);
							} catch (InvocationTargetException e) {
								logger.error(e);
							}
							arrayOrNot = thisi2;
						} catch (NullPointerException ne) {
							arrayOrNot = "null";
							// mI.invoke(thisi, arrayOrNot);
						} catch (NoSuchMethodException ex1) {
							// vollist.add(vol3);
						}

						// }
					}
					// set object list
					newTempList.add(thisi2);
				}
				try {
					mI = cl.getDeclaredMethod(vol, newTempList.getClass());
					mI.invoke(thisi, newTempList);
				} catch (NoSuchMethodException e) {
					// logger.error(e);
				} catch (SecurityException e) {
					logger.error(e);
				} catch (IllegalAccessException e) {
					logger.error(e);
				} catch (IllegalArgumentException e) {
					logger.error(e);
				} catch (InvocationTargetException e) {
					logger.error(e);
				}

				happened = true;
				arrayOrNot = newTempList;
			} else if (entry2.getKey().toString().equals("duty")) {
				Class<?> cl3 = null;
				Object thisi3 = null;
				try {
					cl3 = Class.forName(packName + Duties.class.getSimpleName());

					thisi3 = cl3.newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
					// logger.error(e1);
				}
				Method mI2 = null;
				for (Entry<?, ?> entryDuty : ((LinkedHashMap<?, ?>) entry2.getValue()).entrySet()) {

					String vol4 = "set" + entryDuty.getKey().toString().substring(0, 1).toUpperCase()
							+ entryDuty.getKey().toString().substring(1);

					try {

						mI2 = cl3.getDeclaredMethod(vol4, entryDuty.getValue().getClass());
						// use entry value in order to invoke the return type at runtime

						arrayOrNot = entryDuty.getValue();
						// Object thisi2 =cl2.newInstance();
						mI2.invoke(thisi3, arrayOrNot);

						arrayOrNot = thisi3;
					} catch (NullPointerException ne) {
						arrayOrNot = "null";
						// mI.invoke(thisi, arrayOrNot);
					} catch (NoSuchMethodException ex1) {
						// vollist.add(vol4);
					} catch (IllegalAccessException e) {
						logger.error(e);
					} catch (IllegalArgumentException e) {
						logger.error(e);
					} catch (InvocationTargetException e) {
						logger.error(e);
					}
				}

				arrayOrNot = thisi3;
				try {
					mI = cl.getDeclaredMethod(vol, thisi3.getClass());
				} catch (NoSuchMethodException e) {
					// vollist.add(vol);
				} catch (SecurityException e) {
					logger.error(e);
				}

				try {
					mI.invoke(thisi, arrayOrNot);
				} catch (IllegalAccessException e) {
					logger.error(e);
				} catch (IllegalArgumentException e) {
					logger.error(e);
				} catch (InvocationTargetException e) {
					logger.error(e);
				}
				happened = true;
			}

			if (!happened) {
				try {

					// use entry value in order to invoke the return type at runtime
					mI = cl.getDeclaredMethod(vol, entry2.getValue().getClass());

					mI.invoke(thisi, arrayOrNot);

				} catch (NullPointerException ne) {
					arrayOrNot = "null";
					// mI.invoke(thisi, arrayOrNot);
				} catch (NoSuchMethodException e) {
					// logger.error(e);
					// vollist.add(vol);
				} catch (IllegalAccessException e) {
					logger.error(e);
				} catch (IllegalArgumentException e) {
					logger.error(e);
				} catch (InvocationTargetException e) {
					logger.error(e);
				}

			}

		}
		if (doNotAdd) {
			try {
				mI = cl.getDeclaredMethod("dontAddData");
				doNotAdd = (boolean) mI.invoke(thisi);
			} catch (NoSuchMethodException e) {
				// vollist.add("dontAddData");
			} catch (SecurityException e) {
				logger.error(e);
			} catch (InvocationTargetException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			}
		}

		// if(!doNotAdd) {
		// return null;
		// }

		return thisi;
	}

	@Override
	public Object equipmentCollection(Object key) {
		// Object key
		CredentialsProvider provider = new BasicCredentialsProvider();
		// UsernamePasswordCredentials credintaials =new
		// UsernamePasswordCredentials("","");
		UsernamePasswordCredentials credintaials = new UsernamePasswordCredentials(
				"", "!");
		provider.setCredentials(AuthScope.ANY, credintaials);
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		Object thisi3 = null;
		Method mI3 = null;
		Object objectTemp = null;
		Map<Object, Object> linked = new LinkedHashMap<Object, Object>();
		String vol4 = "";
		Object arrayOrNot = null;
		boolean isItTrue = false;
		linked.put("Equipment", objectTemp);
		linked.put("Models", objectTemp);
		linked.put("Series", objectTemp);
		linked.put("Brands", objectTemp);
		linked.put("ServiceSchedules", objectTemp);
		linked.put("EquipmentTypes", objectTemp);
		linked.put("Owners", objectTemp);
		linked.put("Dealers", objectTemp);
		linked.put("Countries", objectTemp);
		linked.put("Regions", objectTemp);
		linked.put("Provider_codes", objectTemp);

		Class<?> cl2 = null;
		try {
			cl2 = Class.forName(packName + Equipment.class.getSimpleName());
			thisi3 = cl2.newInstance();
		} catch (ClassNotFoundException e2) {
			// logger.error(e2);
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		}

		HttpResponse response = null;

		try {
			URIBuilder builder = new URIBuilder();
			builder.setScheme("https").setHost("agco-fuse-trackers.herokuapp.com");// .setPath("/equipment/"+key.toString()+"/")
			// .setParameter("include",
			// "equipment.model.series,equipment,equipment.model,equipment.model.series.brand,equipment.model.equipmentType").;
			URI uri;
			// try {
			// uri = builder.build();
			// builder.build();
			uri = URI.create("https://agco-fuse-trackers.herokuapp.com/equipment/" + key.toString()
					+ "/?include=model,model.series,model.series.brand,model.equipmentType,model.serviceSchedule,owner,owner.visibleToDealers.address_country.region,owner.visibleToDealers.address_state_province,owner.visibleToDealers.provider_code");
			response = client.execute(new HttpGet(uri));
			// } catch (URISyntaxException e2) {
			// logger.error(e2);
			// }

			BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer();
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed  http Error Code: " + response.getStatusLine().getStatusCode());
			}
			// Object one =JSONValue.parse(response.getEntity().toString());
			// try {
			// JSONValue.parseWithException(bf);
			String output;
			while ((output = bf.readLine()) != null) {
				// System.out.println(output);
				sb.append(output);
			}

			Object jsonO;

			try {
				jsonO = new JSONParser().parse(sb.toString());
				// LinkedHashMap<Object,Object> thisi= new LinkedHashMap<Object,Object>()jsonO);
				// System.out.println(jsonO);
				// (HashMap<?, ?>) jsonO)getClass().getClass().getde
				// Object myObjects = mapper.readValue(output, String.class);

				for (Entry<?, ?> entry : ((HashMap<?, ?>) jsonO).entrySet()) {
					try {
						if (entry.getKey().toString().equals("links")) {
							continue;
						}

						JSONArray array = (JSONArray) entry.getValue();
						for (int c = 0; c < array.size(); c++) {
							for (Entry<?, ?> entry2 : ((HashMap<?, ?>) array.get(c)).entrySet()) {
								if (entry2.getKey().toString().equals("links")) {
									continue;
								}
								vol4 = "set" + entry2.getKey().toString().substring(0, 1).toUpperCase()
										+ entry2.getKey().toString().substring(1);
								// System.out.println(entry2.getKey()+" = "+entry2.getValue());

								try {

									mI3 = cl2.getDeclaredMethod(vol4, entry2.getValue().getClass());
									// use entry value in order to invoke the return type at runtime

									arrayOrNot = entry2.getValue();
									// Object thisi2 =cl2.newInstance();
									mI3.invoke(thisi3, arrayOrNot);

									arrayOrNot = thisi3;
								} catch (NullPointerException ne) {
									arrayOrNot = "null";
									// mI.invoke(thisi, arrayOrNot);
								} catch (NoSuchMethodException ex1) {
									// vollist.add(vol4);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									logger.error(e);
								}

							}
							linked.put(thisi3.getClass().getSimpleName(), thisi3);
						}
					} catch (ClassCastException cee) {
						for (Entry<?, ?> entry3 : ((HashMap<?, ?>) entry.getValue()).entrySet()) {
							// System.out.println(entry3.getKey()+" = "+entry3.getValue());
							// linked.put(entry3.getKey().toString().trim(), entry3.getValue());
							JSONArray array = (JSONArray) entry3.getValue();
							try {
								cl2 = Class.forName(packName + entry3.getKey().toString().substring(0, 1).toUpperCase()
										+ entry3.getKey().toString().substring(1));
								thisi3 = cl2.newInstance();
							} catch (ClassNotFoundException e1) {
								// logger.error(e1);
							} catch (InstantiationException e) {
								logger.error(e);
							} catch (IllegalAccessException e) {
								logger.error(e);
							}
							for (int c = 0; c < array.size(); c++) {
								for (Entry<?, ?> entry4 : ((HashMap<?, ?>) array.get(c)).entrySet()) {
									// System.out.println(entry4.getKey()+" = "+entry4.getValue());
									vol4 = "set" + (entry4.getKey().toString().substring(0, 1).toUpperCase()
											+ entry4.getKey().toString().substring(1));
									try {
										mI3 = cl2.getDeclaredMethod(vol4, entry4.getValue().getClass());
										// use entry value in order to invoke the return type at runtime

										arrayOrNot = entry4.getValue();
										// Object thisi2 =cl2.newInstance();
										mI3.invoke(thisi3, arrayOrNot);

										arrayOrNot = thisi3;
									} catch (NullPointerException ne) {
										arrayOrNot = "null";

										// mI.invoke(thisi, arrayOrNot);
									} catch (NoSuchMethodException ex1) {
										// vollist.add(vol4);
									} catch (IllegalAccessException e) {
										logger.error(e);
									} catch (IllegalArgumentException e) {
										logger.error(e);
									} catch (InvocationTargetException e) {
										logger.error(e);
									}

//									try {
//										mI3 = cl2.getDeclaredMethod("dontAddData");
//										isItTrue = (boolean) mI3.invoke(thisi3);
//										if (isItTrue) {
//											return null;
//										}
//									} catch (NoSuchMethodException e) {
//										// vollist.add(vol4);
//									} catch (SecurityException e) {
//										logger.error(e);
//									} catch (InvocationTargetException e) {
//										logger.error(e);
//									} catch (IllegalAccessException e) {
//										logger.error(e);
//									}

								}
								linked.put(thisi3.getClass().getSimpleName(), thisi3);
							}
						}
						for (Entry<?, ?> entry5 : linked.entrySet()) {
							try {
								cl2 = Class.forName(packName + entry5.getValue().getClass().getSimpleName());
								thisi3 = entry5.getValue();
							} catch (ClassNotFoundException e1) {
								// logger.error(e1);
							} catch (NullPointerException ne) {
								// System.out.println(entry5.getKey());
							}

							for (Entry<?, ?> entry6 : linked.entrySet()) {// loop through again and set the objects only
																			// will set if the method is there
								try {
									vol4 = "set" + entry6.getKey().toString();

									mI3 = cl2.getDeclaredMethod(vol4, entry6.getValue().getClass());

									mI3.invoke(entry5.getValue(), entry6.getValue());

								} catch (NoSuchMethodException e) {
									// vollist.add(vol4);
								} catch (SecurityException e) {
									logger.error(e);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									logger.error(e);
								} catch (NullPointerException ne) {
									arrayOrNot = "null";
									// logger.error(ne);
								}
							}
						}
					}

				}
			} catch (ParseException e) {
				logger.error(e);
			}

			// System.out.println(linked.toString());

		} catch (IOException e1) {
			logger.error(e1);
		}
		// try {
		//
		// linked.get("Provider_codes").equals(null);
		// linked.get("Countries").equals(null);
		// linked.get("Dealers").equals(null);
		// linked.get("Models").equals(null);
		// linked.get("Owners").equals(null);
		// linked.get("Series").equals(null);
		// linked.get("Brands").equals(null);
		// linked.get("ServiceSchedules").equals(null);
		// linked.get("EquipmentTypes").equals(null);
		// linked.get("Equipment").equals(null);
		// return linked.get("Equipment");
		// }catch(NullPointerException e) {
		// logger.info("No Such Equipment Exist (equipmentCollection)");
		// }
		// linked.clear();
		v++;
		return linked.get("Equipment");

	}

	@Override
	public void wirteToFile(Object tempObject) {
		HashMap<? extends Object, ? extends Object> entryMap = (HashMap<? extends Object, ? extends Object>) ((ApiSuperClass) tempObject)
				.getAdditionalProperties();
		boolean split1OR2 = true;
		int numberOfFiles = 0;
		List<Object> tempObjectScope = new ArrayList<Object>();
		for (Entry<? extends Object, ? extends Object> entry : entryMap.entrySet()) {
			for (Object entryh2 : (ArrayList<?>) entry.getValue()) {
				numberOfFiles = getFilesNumber();
				tempObjectScope.add(entryh2);
				if (tempObjectScope.size() == ((ArrayList<?>) entry.getValue()).size() / 2) {
					if (split1OR2) {
						createFile(tempObjectScope, "D:\\TempJSONObject/TempObjectJumpS" + numberOfFiles + ".ser");
						split1OR2 = false;
					} else {
						createFile(tempObjectScope, "D:\\TempJSONObject/TempObjectLocal" + numberOfFiles + ".ser");
						split1OR2 = true;
					}
					tempObjectScope.clear();
				}
			}
			if (!(tempObjectScope.size() == 0)) {
				if (split1OR2) {
					createFile(tempObjectScope, "D:\\TempJSONObject/tempObjectjectJumpS" + numberOfFiles + ".ser");
				} else {
					createFile(tempObjectScope, "D:\\TempJSONObject/TempJsonobjectLocal" + numberOfFiles + ".ser");

				}
			}
		}

	}

	public void wirteToFile2(List tempObject, boolean split, String type) {
		// HashMap<? extends Object, ? extends Object> entryMap =(HashMap<? extends
		// Object, ? extends Object>) ((ApiSuperClass)
		// tempObject).getAdditionalProperties();
		boolean split1OR2 = true;
		int numberOfFiles = 0;
		List<Object> tempObjectScope = tempObject;
		numberOfFiles = getFilesNumber();
		if (split) {
			createFile(tempObjectScope, "D:\\TempObjectJumpS/" + type + numberOfFiles + ".ser");
			this.split = false;
		} else {
			createFile(tempObjectScope, "D:\\TempObjectLocal/" + type + numberOfFiles + ".ser");
			this.split = true;
		}
		tempObjectScope.clear();

		// if(!(tempObjectScope.size()==0)) {
		// if(split1OR2) {
		// createFile(tempObjectScope,"D:\\TempJSONObject/tempObject"+numberOfFiles+".ser");
		// }else {
		// createFile(tempObjectScope,"C:\\Users/josephjo/TempObject/tempObject"+numberOfFiles+".ser");
		//
		// }
		// }

	}

	@Override
	public int getFilesNumber() {
		// File fileDir = new File("C:\\Users\\josephjo\\TempJSONObject\\");
		File fileDir = new File("D:\\TempObjectJumpS/");
		File fileDir2 = new File("D:\\TempObjectLocal/");
		File[] file = fileDir.listFiles();
		int length = file.length;
		length = fileDir.listFiles().length + fileDir2.listFiles().length;
		return length;
	}

	public void createFile(List list, String fileString) {

		String tempString = list.toString();
		// File file = new
		// File("C:\\Users\\josephjo\\TempJSONObject\\tempJsonobject"+numberOfFiles+".txt");
		File file = new File(fileString);
		File fileOut = new File(fileString);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.flush();
			out.close();
			// byte[] strBytes = tempString.getBytes();

			// fos.write(strBytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int fileReader(int statusTracker) {
		boolean isIt =false;
		logger.debug("Collecting Files");
		String[] it = {"D:\\TempObjectJumpS/Equipment/EquipmentR","D:\\TempObjectJumpS/Trackers"};
		boolean closeSession = false;
		//File fileDir = new File("D:\\TempObjectJumpS/Equipment/EquipmentR");
		for(int y=0;y<it.length;y++) {
			File fileDir = new File(it[y]);
		File[] file = fileDir.listFiles();
		boolean status = false;
		try {
			for (int x = 0; x < file.length; x++) {
				FileInputStream fs = new FileInputStream(file[x].getPath());
				ObjectInputStream in = new ObjectInputStream(fs);
				List<?> list = (ArrayList<?>) in.readObject();
				for (int xx = 0; xx < list.size(); xx++) {
					System.out.println(list.get(xx));

					// if (file[x].getPath().contains("L")) {
					// Object thisi = null;
					// try {
					// thisi = LatestTelemetries.class.newInstance();
					// } catch (InstantiationException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// } catch (IllegalAccessException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// subDataCollection((Map<String, Object>) list.get(xx), thisi,
					// LatestTelemetries.class);
					// }else {
					
					if(file[x].getPath().contains("Equip")) {
						for(Entry<?,?> entry : ((LinkedHashMap<?, ?>) list.get(xx)).entrySet()){
							
							
							Object object = equipmentCollection(((LinkedHashMap<?, ?>) entry.getValue()).get("id"));
							
							
							trackerCollection(((Equipment)object).getId());
							documentList2.put(v, object);
							 //v++;
							 if(v>250) {
								 //Joshua
								 
								 //sessionSendToDB.setObject(tempObject.getClass().getSimpleName(),documentList1);
								 logger.debug("Storing updated");
								 sessionSendToDB.setObject(documentList2);
								 statusTracker =statusTracker+documentList2.size();
								 documentList2.clear();
								
								 v=0;
								 closeSession =true;
								 //index=0;
								 }
							}
					}else if(file[x].getPath().contains("Track")) {
						  for(Entry<?,?> entry : ((LinkedHashMap<?, ?>) list.get(xx)).entrySet()){
								Object object = singleTrackers(((LinkedHashMap<?, ?>) entry.getValue()).get("id"));
								try {
								documentList2.put(v, object);
								 isIt=true;
								 if(v>250) {
									 //Joshua
									 //sessionSendToDB.setObject(tempObject.getClass().getSimpleName(),documentList1);
									 logger.debug("Storing updated");
									 sessionSendToDB.setObject(documentList2);
									 statusTracker =statusTracker+documentList2.size();
									 documentList2.clear();
									 v=0;
									 isIt=false;
									 closeSession=true;
									 //index=0;
									 }
							}catch(NullPointerException n) {
								
							logger.debug("Tracker has not been added");
							}
							 
								 
							 }
							
							}
					
					
				}
				 System.out.println(file[x].getName());
					file[x].deleteOnExit();
					status = true;
					
					documentList3 = sessionSendToDB.checkForUpdate(documentList2,isIt);
					 sessionSendToDB.setObject(documentList3);
					 statusTracker =statusTracker+documentList3.size();
					 documentList2.clear();
					 documentList3.clear();
					 closeSession=true;

			}
			
		}catch(FileNotFoundException fe){
			sendMail("Issue: Access to File Has Been changed or file path has been changed");
			fe.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (NullPointerException e) {
			logger.debug("File Has Been Changed");

		}
		if(closeSession) {
		sessionSendToDB.closeSession();
		closeSession=false;
		}
	}
return statusTracker;
	}
	
	public Object singleTrackers(Object key) {

		// Object key
		CredentialsProvider provider = new BasicCredentialsProvider();
		// UsernamePasswordCredentials credintaials =new
		// UsernamePasswordCredentials("","");
		UsernamePasswordCredentials credintaials = new UsernamePasswordCredentials(
				"almsupportdesk@fuseserviceaccount.com", "ALM2017!");
		provider.setCredentials(AuthScope.ANY, credintaials);
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		Object thisi3 = null;
		Method mI3 = null;
		Object objectTemp = null;
		Map<Object, Object> linked = new LinkedHashMap<Object, Object>();
		String vol4 = "";
		Object arrayOrNot = null;
		boolean isItTrue = false;
		linked.put("GwODXLiteConfigurations", objectTemp);
		linked.put("ComServiceLevel", objectTemp);
		linked.put("CanVariables", objectTemp);
		linked.put("Configurations", objectTemp);
		linked.put("Trackers", objectTemp);
		linked.put("Equipment",objectTemp);
		linked.put("Models", objectTemp);
		linked.put("Series", objectTemp);
		linked.put("Brands", objectTemp);
		linked.put("ServiceSchedules", objectTemp);
		linked.put("EquipmentTypes", objectTemp);
		linked.put("Owners", objectTemp);
		linked.put("Dealers", objectTemp);
		linked.put("Countries", objectTemp);
		linked.put("Regions", objectTemp);
		linked.put("Provider_codes", objectTemp);

		Class<?> cl2 = null;
		try {
			cl2 = Class.forName(packName + Trackers.class.getSimpleName());
			thisi3 = cl2.newInstance();
		} catch (ClassNotFoundException e2) {
			// logger.error(e2);
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		}

		HttpResponse response = null;

		try {
			URIBuilder builder = new URIBuilder();
			builder.setScheme("https").setHost("agco-fuse-trackers.herokuapp.com");// .setPath("/equipment/"+key.toString()+"/")
			// .setParameter("include",
			// "equipment.model.series,equipment,equipment.model,equipment.model.series.brand,equipment.model.equipmentType").;
			URI uri;
			// try {
			// uri = builder.build();
			// builder.build();
			uri = URI.create("https://agco-fuse-trackers.herokuapp.com/trackers/" + key.toString()+"/"
					+"?include=comServiceSubscription,comServiceLevel,configuration,configuration.canVariables,configuration.canVariables.standardUnit,equipment,equipment.model,equipment.model.series,equipment.model.series.brand,equipment.model.equipmentType,equipment.model.serviceSchedule,equipment.owner,equipment.owner.visibleToDealers.address_country.region,equipment.owner.visibleToDealers.provider_code");
			
		
			response = client.execute(new HttpGet(uri));
			// } catch (URISyntaxException e2) {
			// logger.error(e2);
			// }

			BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer();
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed  http Error Code: " + response.getStatusLine().getStatusCode());
			}
			// Object one =JSONValue.parse(response.getEntity().toString());
			// try {
			// JSONValue.parseWithException(bf);
			String output;
			while ((output = bf.readLine()) != null) {
				// System.out.println(output);
				sb.append(output);
			}

			Object jsonO;

			try {
				jsonO = new JSONParser().parse(sb.toString());
				// LinkedHashMap<Object,Object> thisi= new LinkedHashMap<Object,Object>()jsonO);
				// System.out.println(jsonO);
				// (HashMap<?, ?>) jsonO)getClass().getClass().getde
				// Object myObjects = mapper.readValue(output, String.class);

				for (Entry<?, ?> entry : ((HashMap<?, ?>) jsonO).entrySet()) {
					try {
						if (entry.getKey().toString().equals("links")) {
							continue;
						}

						JSONArray array = (JSONArray) entry.getValue();
						for (int c = 0; c < array.size(); c++) {
							for (Entry<?, ?> entry2 : ((HashMap<?, ?>) array.get(c)).entrySet()) {
								if (entry2.getKey().toString().equals("links")) {
									continue;
								}
								vol4 = "set" + entry2.getKey().toString().substring(0, 1).toUpperCase()
										+ entry2.getKey().toString().substring(1);
								// System.out.println(entry2.getKey()+" = "+entry2.getValue());

								try {

									mI3 = cl2.getDeclaredMethod(vol4, entry2.getValue().getClass());
									// use entry value in order to invoke the return type at runtime

									arrayOrNot = entry2.getValue();
									// Object thisi2 =cl2.newInstance();
									mI3.invoke(thisi3, arrayOrNot);

									arrayOrNot = thisi3;
								} catch (NullPointerException ne) {
									arrayOrNot = "null";
									// mI.invoke(thisi, arrayOrNot);
								} catch (NoSuchMethodException ex1) {
									// vollist.add(vol4);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									logger.error(e);
								}

							}
							linked.put(thisi3.getClass().getSimpleName(), thisi3);
						}
					} catch (ClassCastException cee) {
						for (Entry<?, ?> entry3 : ((HashMap<?, ?>) entry.getValue()).entrySet()) {
							// System.out.println(entry3.getKey()+" = "+entry3.getValue());
							// linked.put(entry3.getKey().toString().trim(), entry3.getValue());
							JSONArray array = (JSONArray) entry3.getValue();
							try {
								cl2 = Class.forName(packName + entry3.getKey().toString().substring(0, 1).toUpperCase()
										+ entry3.getKey().toString().substring(1));
								thisi3 = cl2.newInstance();
							} catch (ClassNotFoundException e1) {
								// logger.error(e1);
							} catch (InstantiationException e) {
								logger.error(e);
							} catch (IllegalAccessException e) {
								logger.error(e);
							}
							for (int c = 0; c < array.size(); c++) {
								for (Entry<?, ?> entry4 : ((HashMap<?, ?>) array.get(c)).entrySet()) {
									// System.out.println(entry4.getKey()+" = "+entry4.getValue());
									vol4 = "set" + (entry4.getKey().toString().substring(0, 1).toUpperCase()
											+ entry4.getKey().toString().substring(1));
									try {
										mI3 = cl2.getDeclaredMethod(vol4, entry4.getValue().getClass());
										// use entry value in order to invoke the return type at runtime

										arrayOrNot = entry4.getValue();
										// Object thisi2 =cl2.newInstance();
										mI3.invoke(thisi3, arrayOrNot);

										arrayOrNot = thisi3;
									} catch (NullPointerException ne) {
										arrayOrNot = "null";

										// mI.invoke(thisi, arrayOrNot);
									} catch (NoSuchMethodException ex1) {
										// vollist.add(vol4);
									} catch (IllegalAccessException e) {
										logger.error(e);
									} catch (IllegalArgumentException e) {
										logger.error(e);
									} catch (InvocationTargetException e) {
										logger.error(e);
									}

//									try {
//										mI3 = cl2.getDeclaredMethod("dontAddData");
//										isItTrue = (boolean) mI3.invoke(thisi3);
//										if (isItTrue) {
//											return null;
//										}
//									} catch (NoSuchMethodException e) {
//										// vollist.add(vol4);
//									} catch (SecurityException e) {
//										logger.error(e);
//									} catch (InvocationTargetException e) {
//										logger.error(e);
//									} catch (IllegalAccessException e) {
//										logger.error(e);
//									}

								}
								linked.put(thisi3.getClass().getSimpleName(), thisi3);
							}
						}
						for (Entry<?, ?> entry5 : linked.entrySet()) {
							try {
								cl2 = Class.forName(packName + entry5.getValue().getClass().getSimpleName());
								thisi3 = entry5.getValue();
							} catch (ClassNotFoundException e1) {
								// logger.error(e1);
							} catch (NullPointerException ne) {
								// System.out.println(entry5.getKey());
							}

							for (Entry<?, ?> entry6 : linked.entrySet()) {// loop through again and set the objects only
																			// will set if the method is there
								try {
									vol4 = "set" + entry6.getKey().toString();

									mI3 = cl2.getDeclaredMethod(vol4, entry6.getValue().getClass());

									mI3.invoke(entry5.getValue(), entry6.getValue());

								} catch (NoSuchMethodException e) {
									// vollist.add(vol4);
								} catch (SecurityException e) {
									logger.error(e);
								} catch (IllegalAccessException e) {
									logger.error(e);
								} catch (IllegalArgumentException e) {
									logger.error(e);
								} catch (InvocationTargetException e) {
									logger.error(e);
								} catch (NullPointerException ne) {
									arrayOrNot = "null";
									// logger.error(ne);
								}
							}
						}
					}

				}
			} catch (ParseException e) {
				logger.error(e);
			}

			// System.out.println(linked.toString());

		} catch (IOException e1) {
			logger.error(e1);
		}
		// try {
		//
		// linked.get("Provider_codes").equals(null);
		// linked.get("Countries").equals(null);
		// linked.get("Dealers").equals(null);
		// linked.get("Models").equals(null);
		// linked.get("Owners").equals(null);
		// linked.get("Series").equals(null);
		// linked.get("Brands").equals(null);
		// linked.get("ServiceSchedules").equals(null);
		// linked.get("EquipmentTypes").equals(null);
		try {
		 
		 v++;
		 return linked.get("Trackers");
		 }catch(NullPointerException e) {
		 logger.info("No Such Equipment Exist (equipmentCollection)");
		 }
		 linked.clear();
		
		return 0;

	
	
	}

	@Override
	public void sendMail(String body) {

		String relayHost = "smtpapps.atlanta.agcocorp.com";
		Date date = new Date();
		String email = "";
		String subject = "Data Tracker Application";

		body = body + "Date: " + date;

		Properties props = System.getProperties();

		props.put("mail.smtp.host", relayHost);

		Session session = Session.getInstance(props, null);

		EmailUtil.sendEmail(session, email, subject, body);

	}

}
