package com.productionDataClientProductionData.test;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.transaction.TransactionalException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;
import org.junit.Ignore;
import org.junit.Test;

import com.productionDataClientProductionData.hibernationConnection.Connection;



@Ignore
public class ConnectionTest implements Serializable {
	/**
	 * 
	 */
	private static Logger logger = LogManager.getLogger(com.productionDataClientProductionData.test.ConnectionTest.class.getName());
	private static final long serialVersionUID = 1L;
	private Session session;
	private static List<Object> brandsList = new LinkedList<Object>();
	private static String packName = "com.productionDataClientProductionData.pojo.";
	private  static String className = null;
	SessionFactory sessionFactory = null;
	private static boolean useit= false;
	private static boolean save = false;
	
	@Test
	public void  getConnectionAndSessionFactory() throws ClientProtocolException, ClassNotFoundException {
		
		//Class<?> cl = Class.forName(packName.trim()+className.toString().trim());
		int c =0;
		
		useit =true;
		   try {
		    	session.getSessionFactory().isOpen();
	          
		    	}catch(NullPointerException ne) {
		    		Connection.getConnection();      
		    	}
		for(int x =0; x<brandsList.size();x++) {
	    try {
	    	
	 
	    sessionFactory =Connection.getSessionFactory();
	    session = sessionFactory.openSession();
	    
	   
        session.getTransaction().begin();
		
	  
	   // tx = 	session.getTransaction();
		 
			 
			//session.save(brandsList.get(x));
			 session.saveOrUpdate(brandsList.get(x));
			 //session.update(brandsList.get(x));
			// session.update(brandsList.get(x));
			 //logger.info(session);
			 //}else {
				 //session.save(brandsList.get(x));
				// session.update(brandsList.get(x));
			 //}
        c=x;
        //tx.commit();
		 
		
//		//session.save(brandsList.get(0));
       }catch(TransactionException e) {
			e.printStackTrace();
	    }catch(NullPointerException es) {
			es.printStackTrace();
			//ession.close();
		}catch(TransactionalException ex) {
			ex.printStackTrace();
			//if (tx !=null) {
				session.getTransaction().rollback();
			//}
		}catch(HibernateException hb) {
			hb.printStackTrace();
			System.out.println("");
//			if (tx !=null) {
//				tx.rollback();
//			}
		}
	    finally {
	    	//tx.commit();
	    	session.getTransaction().commit();
	    	sessionFactory.close();//close threads
	    	//brandsList.clear();
	    	
    	
	    	System.out.println("Successfully Created"+c);
	    
		}
		}
	//}
		 assertEquals(true,true);
	}
	
	public void setBrands(String error,Map<Integer,Object> documentList2) throws ClientProtocolException, ClassNotFoundException{
		brandsList= new LinkedList<Object>();
	
		for(Entry<Integer,Object> entry : documentList2.entrySet()) {
		brandsList.add(entry.getValue());
		className=entry.getValue().getClass().getSimpleName();
		}
		try {
		brandsList.get(0);
		getConnectionAndSessionFactory();
		}catch(IndexOutOfBoundsException in) {
			logger.fatal("No data For tables: "+ error);
		}catch(ClassNotFoundException ce) {
			
		}
		
	}
	@Ignore
	//@Test
	public Object getObject(String id,String tableName,String document) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//logger.warn("GETOBJECT!!!!!!!!!!!");
		Method mI = null;
		Transaction tx =null;
//		if(!tableName.endsWith("s")) {
//			tableName+='s';
//		}
		save = true;
		Class<?> cl = Class.forName(packName.trim()+tableName.substring(0, 1).toUpperCase() +tableName.substring(1));
		List<Object> q = new ArrayList<Object>();
		List<?> tempObject =null;
		int c =0;
		
		

	    try {
	    	session = sessionFactory.openSession();
		tx = session.beginTransaction();
		//tx.begin();
		Object thisi = cl.newInstance();
       Field[] fields =  cl.getDeclaredFields();
		//EntityManager em = new entitymana;
        	//session.save(brandsList.get(x));
			String hql ="select * from "+tableName+" where MonogId in ('"+id+"')";
			System.out.println(hql);
			Query query  = session.createNativeQuery(hql,cl);
			//TypedQuery<? extends Object> query2=	em.createQuery("select * from "+tableName+"s where "+tableName+"sid  in ('"+id+"')",cl);;
			 tempObject = query.getResultList();
			System.out.println(tempObject.get(0).toString());
		}catch(TransactionException e) {
			e.printStackTrace();
	     }catch(NullPointerException es) {
			//es.printStackTrace();
			session.close();
		}catch(TransactionalException ex) {
			ex.printStackTrace();
			if (tx !=null) {
				tx.rollback();
			}
		}catch(HibernateException hb) {
			hb.printStackTrace();
			System.out.println("");
//			if (tx !=null) {
//				tx.rollback();
//			}
		}catch(IndexOutOfBoundsException ie) {
			
				String hql ="select * from "+tableName+" where id in ('nnnnnnnn-nnnn-nnnn-nnnn-nnnnnnnnnnnn')";
				System.out.println(hql);
				Query query  = session.createNativeQuery(hql,cl);
				tempObject = query.getResultList();
			logger.error("Document ERROR  : "+ document);
			logger.error("Document Error data: "+"Table: "+tableName+" id :"+id);
			
			
		}
	    finally {
	    	session.getTransaction().commit();
	    	session.close();
	    	brandsList.clear();
	    	
    	
	    	//logger.info("Successfully Completed");
	    
		}
		
	  
	
		return tempObject.get(0);
	}
	
	@SuppressWarnings("null")
	public Object getObject(List<String> id,String tableName,String document) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Method mI = null;
		Transaction tx =null;

		
		Class<?> cl = Class.forName(packName.trim()+tableName.substring(0, 1).toUpperCase() +tableName.substring(1));
		List<Object> q = new ArrayList<Object>();
		List<?> tempObject =null;
		int c =0;
		
		

	    try {
	    	session = sessionFactory.openSession();
		tx = session.beginTransaction();
		//tx.begin();
		Object thisi = cl.newInstance();
       Field[] fields =  cl.getDeclaredFields();
		//EntityManager em = new entitymana;
        	//session.save(brandsList.get(x));
       
			String hql ="select * from "+tableName+" where id in :list";
			System.out.println(hql);
			Query query  = session.createNativeQuery(hql,cl).setParameterList("list",id);
			//query.setParameter(0, id);
			//TypedQuery<? extends Object> query2=	em.createQuery("select * from "+tableName+"s where "+tableName+"sid  in ('"+id+"')",cl);;
			 tempObject =query.getResultList();
       
			System.out.println(tempObject.get(0).toString());
		}catch(TransactionException e) {
			e.printStackTrace();
	     }catch(NullPointerException es) {
			//es.printStackTrace();
			session.close();
		}catch(TransactionalException ex) {
			ex.printStackTrace();
			if (tx !=null) {
				tx.rollback();
			}
		}catch(HibernateException hb) {
			hb.printStackTrace();
			System.out.println("");
//			if (tx !=null) {
//				tx.rollback();
//			}
		}catch(IndexOutOfBoundsException ie) {
			
				String hql ="select * from "+tableName+" where id in ('nnnnnnnn-nnnn-nnnn-nnnn-nnnnnnnnnnnn')";
				System.out.println(hql);
				Query query  = session.createNativeQuery(hql,cl);
				tempObject = query.getResultList();
			logger.error("Document ERROR  : "+ document);
			logger.error("Document Error data: "+"Table: "+tableName+" id :"+id);
			
			
		}
	    finally {
	    	session.getTransaction().commit();
	    	session.close();
	    	brandsList.clear();
	    	
    	
	    	//logger.info("Successfully Completed");
	    
		}
		
	  
	
		return tempObject;
	}
	
	public void getConnection(String id,String tableName) {
		Class<?> cl;
		useit = false;
		try {
		
//			if(!tableName.endsWith("s")) {
//				tableName+='s';
//			}
			cl = Class.forName(packName.trim()+tableName.substring(0, 1).toUpperCase() +tableName.substring(1));
			
			  Connection.getConnection();
			  sessionFactory =Connection.getSessionFactory();
			
		        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.error("getConnection",e);
		}
		
	      
	}
	public void closeConntection() {
		sessionFactory.close();
	}
	
	public void setTrackers(String error,Object object) throws ClientProtocolException, ClassNotFoundException{
		brandsList= new LinkedList<Object>();
		//brandsList= new LinkedList<Object>();
		
		
	
		className=error;
		
		brandsList.add(object);
		
		try {
		brandsList.get(0);
		getConnectionAndSessionFactory();
		}catch(IndexOutOfBoundsException in) {
			logger.fatal("No data For tables: "+ error);
		}catch(ClassNotFoundException ce) {
			
		}
		
	}
	public void closeSession() {
		session.close();
		sessionFactory.close();
    	
	}
	
	public void setObjects(String error,Map<Integer,TreeMap<Integer,Object>> documentList2) throws ClientProtocolException, ClassNotFoundException{
		brandsList= new LinkedList<Object>();
	
		for(Entry<Integer,TreeMap<Integer,Object>> entry : documentList2.entrySet()) {
			for(Entry<Integer, Object> entry2 : entry.getValue().entrySet()) {
		brandsList.add(entry2.getValue());
		//className=entry.getValue().getClass().getSimpleName();
			}
		}
		try {
		brandsList.get(0);
		getConnectionAndSessionFactory();
		}catch(IndexOutOfBoundsException in) {
			logger.fatal("No data For tables: "+ error);
		}catch(ClassNotFoundException ce) {
			
		}
		
	}
 }

