package etf.si.projekat.data_vision;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import ba.unsa.etf.si.beans.ActivityLogs;
import ba.unsa.etf.si.beans.EventLogs;
import etf.si.projekat.util.HibernateUtil;
import ba.unsa.etf.si.hibernate_klase.HibernateEventLogs;

public class UnosPretragaEventLogs {
	 private static Scanner sc = new Scanner(System.in); 
	 
	 public static void main(String[] args) { 
//		 Session session = HibernateUtil.getSessionFactory().openSession();
		 //dodajActivity(session);
		 //nadjiActivity(session); 
		 dodaj();
		 //dodajEventLogs(session);
		 //pretraziEventLogs(session);
		 
//		 session.close(); 
		 } 
	 private static void dodaj() { 
		
		 
		 ActivityLogs al = new ActivityLogs();
		 al.setActivitylogs_id((long) 1);
		 al.setCommand("komanda");
		 al.setFixtureName("fixture");
		 al.setGranted(true);
		 al.setUser("user");

		 Date datum = Date.valueOf("2014-1-1");

		 al.setTimestamp(datum);
		 
		 
		 EventLogs s=new EventLogs();
		 s.setActivity_logs(al);
		 
		 s.setDevice_name("Naziv uredjaja");
		 s.setDevice_type("Tip Uredjaja");
		 s.setEvent_message("poruka o stanju");

		 HibernateEventLogs EL = new HibernateEventLogs();
		 EL.addEventLogs(s);
		
		 
		 System.out.println("Dodan red u tabeli EventLogs sa  IDom "+s.getEventlogs_id()); 
		
		 } 
		 
	 		
	 	 
		 private static void dodajEventLogs(Session session) { 
		 Transaction t = session.beginTransaction(); 
		 
		 ActivityLogs al = new ActivityLogs();
		 al.setActivitylogs_id((long) 1);
		 al.setCommand("komanda");
		 al.setFixtureName("fixture");
		 al.setGranted(true);
		 al.setUser("user");

		 Date datum = Date.valueOf("2014-1-1");

		 al.setTimestamp(datum);
		 
		 EventLogs s=new EventLogs();
		 s.setActivity_logs(al);
		 
		 s.setDevice_name("Naziv uredjaja");
		 s.setDevice_type("Tip Uredjaja");
		 s.setEvent_message("poruka o stanju");

		 
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



