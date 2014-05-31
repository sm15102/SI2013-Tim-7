package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.*;

public class ConsumptionTest {
	
	
	@Test
	public void TestCalculateResult() throws ParseException 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
		
		EventLogs ev1 = new EventLogs();
		ev1.setDevice_name("Test Device1");
		ev1.setDevice_type("senzor");
		ev1.setEvent_message("turnOn");
		ev1.setValue(2);
		ev1.setTimestamp(formatter.parse("01 01 1990 00:00:00"));
		
		EventLogs ev2 = new EventLogs();
		ev2.setDevice_name("Test Device1");
		ev2.setDevice_type("senzor");
		ev2.setEvent_message("turnOn");
		ev2.setValue(2);
		ev2.setTimestamp(formatter.parse("02 01 1990 00:00:00"));
		
		Double power = (double) 1;
		long hoursbetween = (ev2.getTimestamp().getTime() - ev1.getTimestamp().getTime())/3600000; 
		Double PeriodicalConsumption = power*hoursbetween;
		
		assertEquals("24.0",PeriodicalConsumption.toString());
	}
	
	@Test 
	public void NumberofPeriodsTest() throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
		ArrayList<EventLogs> evl = new ArrayList<EventLogs>();
		ArrayList <ActivePeriod> periods = new ArrayList<ActivePeriod>();
		System.out.println(periods.size());
		
		
		for(int i=0;i<10;i++)
		{
			EventLogs p = new EventLogs();
			p.setDevice_name("device1");
			p.setTimestamp(formatter.parse("0"+i+" 01 1990 00:00:00"));
			if(i%2==0)
			{
				p.setEvent_message("turnOn");
			} else p.setEvent_message("turnOff");
			evl.add(p);
		}
		
		boolean on = false;
		Date date1 = formatter.parse("30 12 1989 00:00:00");
		Date date2 = formatter.parse("01 02 1990 00:00:00");
		ActivePeriod activeperiod = new ActivePeriod();
		for(int i=0;i<10;i++)
		{
			EventLogs ev = evl.get(i);
			String message = ev.getEvent_message();
			 
			if((message.equalsIgnoreCase("open") || message.equalsIgnoreCase("turnOn")) && activeperiod.getStart()==null && !on && i==0)
			 {
				 on = true;
				 activeperiod.setStart(date1);
			 }
			 else if((message.equalsIgnoreCase("open") || message.equalsIgnoreCase("turnOn"))  && !on && i>0)
			 {
				 on = true;
				 activeperiod.setStart(ev.getTimestamp());
			 }
			 else if((message.equalsIgnoreCase("closed") || message.equalsIgnoreCase("turnOff")) && on && i==10-1)
			 {
				 on = false;
				 activeperiod.setEnd(date2);
				 periods.add(activeperiod);
				 activeperiod = new ActivePeriod();
			 }
			 else if((message.equalsIgnoreCase("closed") || message.equalsIgnoreCase("turnOff")) && on && i<10-1){
			 on=false;
			 activeperiod.setEnd(ev.getTimestamp());
			 periods.add(activeperiod);
			 activeperiod = new ActivePeriod(); 
			 }
			 else if((message.equalsIgnoreCase("open") || message.equalsIgnoreCase("turnOn")) && !on && i==10-1){
				 on=false;
				 activeperiod.setStart(ev.getTimestamp());
				 activeperiod.setEnd(date2);
				 periods.add(activeperiod);
				 activeperiod = new ActivePeriod();
				 }
			 else if(activeperiod.getStart() !=null && activeperiod.getEnd()==null && i==10-1){
				 on=true;
				 activeperiod.setEnd(date2);
				 periods.add(activeperiod);
				 activeperiod = new ActivePeriod();
				 }
			}
				assertEquals(5, periods.size());
		
		
	}

}
