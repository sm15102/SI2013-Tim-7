package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;
import etf.si.projekat.util.HibernateUtil;

public class Add1SensorTest {

	@Test
	public void testAdd1Sensor() {
		List<String> choice = new ArrayList<String>();
		HibernateDeviceType HT = new HibernateDeviceType();
		List<DeviceType> lt = HT.giveAllDeviceType();
		String dt = lt.get(0).getType();
		choice.add(dt);
		assertFalse(choice.isEmpty());
		assertTrue(choice.contains(dt));

	}
}


