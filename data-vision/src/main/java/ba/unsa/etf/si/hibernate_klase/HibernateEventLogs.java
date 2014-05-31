package ba.unsa.etf.si.hibernate_klase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;





import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public String existDeviceName(String name){
	
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		Query query = session.createQuery("from EventLogs where device_name = :tempJib");
		
		query.setParameter("tempJib", name);
		List<EventLogs> temp=query.list();
		
		if(temp.size() == 0) {
			session.close();
			return null;
		}
		else{
		session.close();
		
		return temp.get(0).getTimestamp().toString().substring(0, 19);
		}
	}
	public List<EventLogs> getdatesbetween(String name,Date dateFrom, Date dateTo){
		session= HibernateUtil.getSessionFactory().openSession();
		transaction= session.beginTransaction();
		
		Query query = session.createQuery("from EventLogs where device_name=:tmp and timestamp between :start_date and :end_date");
		
		query.setParameter("tmp", name);
		query.setParameter("start_date", dateFrom);
		query.setParameter("end_date", dateTo);
		
		
		List<EventLogs> temp_list=query.list();
			if(temp_list.size()==0){
				session.close();
				List<EventLogs> newlist = new ArrayList<EventLogs>(); 
				return newlist;
				
			}else{
				session.close();
				return temp_list;
			}
	}

}
