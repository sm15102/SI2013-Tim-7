package ba.unsa.etf.si.hibernate_klase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.DeviceType;
import etf.si.projekat.util.HibernateUtil;

public class HibernateDeviceType {
	Session session;
	Transaction t;
	public HibernateDeviceType(){
		
	}
	public void addDeviceType(DeviceType dv) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Long id = (Long)session.save(dv);
		t.commit();	
		
		session.close();
	}
	
	public void updateDeviceType(DeviceType dv) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		session.update(dv);
		t.commit();
		
		session.close();
		
	}
	
	public DeviceType giveActivityLogs(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		DeviceType dv = (DeviceType)session.get(DeviceType.class, id);
		
		
		if(dv == null) {
			session.close();
			return new DeviceType();
			
		}else {
			session.close();
			return dv;
		}
	}
	
	


	public List<DeviceType> giveAllDeviceType() throws HibernateException
	{
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
			
		List<DeviceType> temp=new ArrayList<DeviceType>();
		temp=session.createCriteria(DeviceType.class).list();
		if(temp.size()==0) {
			session.close();
			return new ArrayList<DeviceType>();
		}
			session.close();
		return temp;
	}
	
	public boolean existDeviceType(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		DeviceType u = (DeviceType)session.get(DeviceType.class, id);
		
		if(u == null) {
			session.close();
			return false;
		}else {
			session.close();
			return true;
		}
	}
	public boolean existDeviceType(String type) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Query query = session.createQuery("from DeviceType where type = :temp");
		query.setParameter("temp", type);
		
		if(query.list().size()==0) {
			session.close();
			return false;
		}else {
			session.close();
			return true;
		}
	}
}
	
