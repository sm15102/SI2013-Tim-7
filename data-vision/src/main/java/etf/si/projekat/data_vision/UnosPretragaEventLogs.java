package etf.si.projekat.data_vision;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import ba.unsa.etf.si.beans.ActivityLogs;
import ba.unsa.etf.si.beans.EventLogs;
import etf.si.projekat.util.HibernateUtil;

public class UnosPretragaEventLogs {
	 private static Scanner sc = new Scanner(System.in); 
	 
	 public static void main(String[] args) { 
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 //dodajActivity(session);
		 //nadjiActivity(session); 
		 
		 dodajEventLogs(session);
		 pretraziEventLogs(session);
		 session.close(); 
		 } 
		 
		 private static void dodajEventLogs(Session session) { 
		 Transaction t = session.beginTransaction(); 
		 
		 EventLogs s=new EventLogs();
		 s.setActivity_logs(null);
		 s.setDevice_name("Naziv uredjaja");
		 s.setDevice_type("Tip Uredjaja");
		 s.setEvent_message("poruka o stanju");
		 s.setEventlogs_id(null);
		 s.setTimestamp(null);
		 
		 Long id = (Long) session.save(s);
		 
		 System.out.println("Dodan red u tabeli EventLogs sa  IDom "+id); 
		 t.commit(); 
		 } 
		 
		 private static void pretraziEventLogs(Session session) { 
	     Transaction t = session.beginTransaction(); 
		 
		 System.out.println("Unesite id Eventloga"); 
		 long id = sc.nextLong();
		 EventLogs s = ( EventLogs) session.get( EventLogs.class, id);
	
		 

		 if (s==null) { 
		 System.out.println("Nema log sa tim IDom u bazi"); 
		 } else { 
	
			
		 System.out.println("Uredjaj: "+s.getDevice_name()+" "+s.getDevice_type()+" "+s.getEvent_message() + " "+ s.getTimestamp()+ s.getValue()); 
		 }
		 
		
		 
		 
		 
		 t.commit(); 
		 } 
	} 



