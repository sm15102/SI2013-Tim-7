package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.*;


public class TableViewPanelTest {


	@Test
	public void testPopuniTabelu() {
		TableViewPanel tv = new TableViewPanel(null);
		tv.popuniTabelu();
		assertNotNull(tv);
	}

	@Test
	public void testPokupiPodatke() {

		TableViewPanel tv = new TableViewPanel(null);
		List<EventLogs> test = tv.pokupiPodatke();
		HibernateEventLogs HL = new HibernateEventLogs();
		List<EventLogs> t = HL.giveAllEventLogs();
		
		assertEquals(test.size(),t.size());
		assertFalse(test.isEmpty());
	}
}
