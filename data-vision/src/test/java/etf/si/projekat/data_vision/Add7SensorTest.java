package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

public class Add7SensorTest {

	@Test
	public void testAdd7Sensor() {
		List<String> choice = new ArrayList<String>();
		HibernateDeviceType HT = new HibernateDeviceType();
		List<DeviceType> lt = HT.giveAllDeviceType();
		String ch1 = lt.get(0).getType();
		choice.add(ch1);
		assertFalse(choice.isEmpty());
		assertTrue(choice.contains(ch1));

		String ch2 = lt.get(1).getType();
		choice.add(ch2);
		assertTrue(choice.contains(ch2));
		String ch3 = lt.get(2).getType();
		choice.add(ch3);
		assertTrue(choice.contains(ch3));
		String ch4 = lt.get(3).getType();
		choice.add(ch4);
		assertTrue(choice.contains(ch4));
		String ch5 = lt.get(4).getType();
		choice.add(ch5);
		assertTrue(choice.contains(ch5));
		String ch6 = lt.get(5).getType();
		choice.add(ch6);
		assertTrue(choice.contains(ch6));
		String ch7 = lt.get(6).getType();
		choice.add(ch7);
		assertTrue(choice.contains(ch7));
	}

	@Test
	public void testFillChoices() {
		Add7Sensor sevenS = new Add7Sensor(null, null, null);
		sevenS.fillChoices(0);
		//ako je fillChoices(0) treba biti choice_1 enabled, a choice disabled
		assertTrue(sevenS.choice_1.isEnabled());
		assertFalse(sevenS.choice.isEnabled());
		sevenS.fillChoices(1);
		//ako je fillChoices(1) treba biti choice_1 disabled, a choice_2 enabled
		assertTrue(sevenS.choice_2.isEnabled());
		assertFalse(sevenS.choice_1.isEnabled());
		sevenS.fillChoices(2);
		//ako je fillChoices(2) treba biti choice_2 disabled a choice_3 enabled
		assertTrue(sevenS.choice_3.isEnabled());
		assertFalse(sevenS.choice_2.isEnabled());
		sevenS.fillChoices(3);
		//ako je fillChoices(3) treba biti choice_3 disabled a choice_4 enabled
		assertTrue(sevenS.choice_4.isEnabled());
		assertFalse(sevenS.choice_3.isEnabled());
		//ako je fillChoices(4) treba biti choice_4 disabled a choice_5 enabled
		sevenS.fillChoices(4);
		assertTrue(sevenS.choice_5.isEnabled());
		assertFalse(sevenS.choice_4.isEnabled());
		//ako je fillChoices(5) treba biti choice_5 disabled a choice_6 enabled
		sevenS.fillChoices(5);
		assertFalse(sevenS.choice_5.isEnabled());
		assertTrue(sevenS.choice_6.isEnabled());
		//ako je fillChoices(6) treba biti choice_6 disabled
		sevenS.fillChoices(6);
		assertFalse(sevenS.choice_6.isEnabled());
	}

}
