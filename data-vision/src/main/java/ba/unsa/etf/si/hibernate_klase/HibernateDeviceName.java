package ba.unsa.etf.si.hibernate_klase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import etf.si.projekat.util.HibernateUtil;

public class HibernateDeviceName {
	
	Session session;
	Transaction transaction;
	
	public HibernateDeviceName() {}
	
	public void addDeviceName(DeviceName dn) {
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		Long id = (Long)session.save(dn);
		transaction.commit();	
		
		session.close();
	}
	
	public void updateDeviceName(DeviceName dn) {
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		session.update(dn);
		transaction.commit();
		
		session.close();
		
	}
	
public DeviceName giveActivityLogs(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		DeviceName dn = (DeviceName)session.get(DeviceName.class, id);
		
		
		if(dn == null) {
			session.close();
			return new DeviceName();
			
		}
		
		else {
			session.close();
			return dn;
		}
	}


	
	public List<DeviceName> giveAllDeviceName() {
		
		session=HibernateUtil.getSessionFactory().openSession();
		 Transaction t=null;
		 List<DeviceName> deviceNames = new ArrayList<DeviceName>();
		
		 try
		 {
			 transaction = session.beginTransaction(); 
			 session.createQuery("from DeviceName").list(); 
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
	
public boolean existDeviceName(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		DeviceName n = (DeviceName)session.get(DeviceName.class, id);
		
		if(n == null) {
			session.close();
			return false;
		}
		
		else {
			session.close();
			return true;
		}
	}

public boolean existDeviceName(String type) {
	session= HibernateUtil.getSessionFactory().openSession();
	transaction= session.beginTransaction();
	
	Query query = session.createQuery("from DeviceName where type = :temp");
	query.setParameter("temp", type);
	
	if(query.list().size()==0) {
		session.close();
		return false;
	}
	
	else {
		session.close();
		return true;
	}
}

}
