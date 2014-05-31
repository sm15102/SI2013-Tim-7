package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

public class Add5SensorsTest {

	@Test
	public void testAdd5Sensors() {
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
	}

	@Test
	public void testFillChoices() {
		Add5Sensors fiveS = new Add5Sensors(null, null, null);
		fiveS.fillChoices(0);
		//ako je fillChoices(0) treba biti choice_1 enabled, a choice disabled
		assertTrue(fiveS.choice_1.isEnabled());
		assertFalse(fiveS.choice.isEnabled());
		fiveS.fillChoices(1);
		//ako je fillChoices(1) treba biti choice_1 disabled, a choice_2 enabled
		assertTrue(fiveS.choice_2.isEnabled());
		assertFalse(fiveS.choice_1.isEnabled());
		fiveS.fillChoices(2);
		//ako je fillChoices(2) treba biti choice_2 disabled a choice_3 enabled
		assertTrue(fiveS.choice_3.isEnabled());
		assertFalse(fiveS.choice_2.isEnabled());
		fiveS.fillChoices(3);
		//ako je fillChoices(3) treba biti choice_3 disabled a choice_4 enabled
		assertTrue(fiveS.choice_4.isEnabled());
		assertFalse(fiveS.choice_3.isEnabled());
		//ako je fillChoices(4) treba biti choice_4 disabled
		fiveS.fillChoices(4);
		assertFalse(fiveS.choice_4.isEnabled());
	}

}
