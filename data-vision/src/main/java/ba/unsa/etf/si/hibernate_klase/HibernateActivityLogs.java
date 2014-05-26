package ba.unsa.etf.si.hibernate_klase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import etf.si.projekat.util.HibernateUtil;
import ba.unsa.etf.si.beans.ActivityLogs;


public class HibernateActivityLogs {
	Session session;
	Transaction t;
	public HibernateActivityLogs(){
		
	}
	public void addActivityLogs(ActivityLogs a) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		Long id = (Long)session.save(a);
		t.commit();	
		
		session.close();
	}
	
	public void updateActivityLogs(ActivityLogs a) {
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		session.update(a);
		t.commit();
		
		session.close();
		
	}
	
	public ActivityLogs giveActivityLogs(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		ActivityLogs a = (ActivityLogs)session.get(ActivityLogs.class, id);
		
		
		if(a == null) {
			session.close();
			return new ActivityLogs();
			
		}
		
		else {
			session.close();
			return a;
		}
	}
	
	


	public List<ActivityLogs> giveAllActivityLogs() throws HibernateException
	{
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
			
		List<ActivityLogs> temp=new ArrayList<ActivityLogs>();
		temp=session.createCriteria(ActivityLogs.class).list();
		if(temp.size()==0) {
			session.close();
			return new ArrayList<ActivityLogs>();
		}
			session.close();
		return temp;
	}
	
	public boolean existActivityLogs(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		t= session.beginTransaction();
		
		ActivityLogs u = (ActivityLogs)session.get(ActivityLogs.class, id);
		
		if(u == null) {
			session.close();
			return false;
		}
		
		else {
			session.close();
			return true;
		}
	}
	
	

	
	

}
