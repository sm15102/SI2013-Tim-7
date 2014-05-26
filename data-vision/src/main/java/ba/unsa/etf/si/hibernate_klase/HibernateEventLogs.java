package ba.unsa.etf.si.hibernate_klase;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.ActivityLogs;
import ba.unsa.etf.si.beans.EventLogs;
import etf.si.projekat.util.HibernateUtil;

public class HibernateEventLogs {
	
	Session session;
	Transaction transaction;
	
public HibernateEventLogs(){
		
	}
	public void addEventLogs(EventLogs e) {
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		Long id = (Long)session.save(e);
		transaction.commit();	
		
		session.close();
	}
	
	public void updateEventLogs(EventLogs e) {
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		session.update(e);
		transaction.commit();
		
		session.close();
		
	}
	
	public EventLogs giveEventLogs(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		EventLogs e = (EventLogs)session.get(EventLogs.class, id);
		
		
		if(e == null) {
			session.close();
			return new EventLogs();
			
		}
		
		else {
			session.close();
			return e;
		}
	}
	
	


	public List<EventLogs> giveAllEventLogs() throws HibernateException
	{
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
			
		List<EventLogs> temp=new ArrayList<EventLogs>();
		temp=session.createCriteria(EventLogs.class).list();
		if(temp.size()==0) {
			session.close();
			return new ArrayList<EventLogs>();
		}
			session.close();
		return temp;
	}
	
	public boolean existEventLogs(long id) {
		
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		EventLogs e = (EventLogs)session.get(EventLogs.class, id);
		
		if(e == null) {
			session.close();
			return false;
		}
		
		else {
			session.close();
			return true;
		}
	}
	

}
