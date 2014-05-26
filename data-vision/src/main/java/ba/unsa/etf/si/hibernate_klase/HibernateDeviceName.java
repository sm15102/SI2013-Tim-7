package ba.unsa.etf.si.hibernate_klase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.DeviceName;
import etf.si.projekat.util.HibernateUtil;

public class HibernateDeviceName {
	
	Session session;
	Transaction transaction;
	
	public HibernateDeviceName() {}
	
	public List<DeviceName> getAllDeviceName() {
		
		session=HibernateUtil.getSessionFactory().openSession();
		 Transaction t=null;
		 List<DeviceName> deviceNames = new ArrayList<DeviceName>();
		
		 try
		 {
			 transaction = session.beginTransaction(); 
			 session.createQuery("from DeviceType").list(); 
			 for (Iterator iterator = deviceNames.iterator(); iterator.hasNext();){  
			        DeviceName dn =(DeviceName) iterator.next();
			        
			       deviceNames.add(dn);
			      }
			      transaction.commit();
			  
			 
		 }
		 
		 catch(Exception ex) {
			 
			 System.out.println("Error:"+ex);
		 }
		 
		 finally{
				session.close();
			}
		 
		 return deviceNames;
		
	}

}
