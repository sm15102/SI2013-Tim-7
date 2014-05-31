package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

public class Add8SensorsTest {

	@Test
	public void testAdd8Sensors() {
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
		String ch8 = lt.get(7).getType();
		choice.add(ch8);
		assertTrue(choice.contains(ch8));
	}

	@Test
	public void testFillChoices() {
		Add8Sensors eightS = new Add8Sensors(null, null, null);
		eightS.fillChoices(0);
		//ako je fillChoices(0) treba biti choice_1 enabled, a choice disabled
		assertTrue(eightS.choice_1.isEnabled());
		assertFalse(eightS.choice.isEnabled());
		eightS.fillChoices(1);
		//ako je fillChoices(1) treba biti choice_1 disabled, a choice_2 enabled
		assertTrue(eightS.choice_2.isEnabled());
		assertFalse(eightS.choice_1.isEnabled());
		eightS.fillChoices(2);
		//ako je fillChoices(2) treba biti choice_2 disabled a choice_3 enabled
		assertTrue(eightS.choice_3.isEnabled());
		assertFalse(eightS.choice_2.isEnabled());
		eightS.fillChoices(3);
		//ako je fillChoices(3) treba biti choice_3 disabled a choice_4 enabled
		assertTrue(eightS.choice_4.isEnabled());
		assertFalse(eightS.choice_3.isEnabled());
		//ako je fillChoices(4) treba biti choice_4 disabled a choice_5 enabled
		eightS.fillChoices(4);
		assertTrue(eightS.choice_5.isEnabled());
		assertFalse(eightS.choice_4.isEnabled());
		//ako je fillChoices(5) treba biti choice_5 disabled a choice_6 enabled
		eightS.fillChoices(5);
		assertFalse(eightS.choice_5.isEnabled());
		assertTrue(eightS.choice_6.isEnabled());
		//ako je fillChoices(6) treba biti choice_6 disabled a choice_7 enabled
		eightS.fillChoices(6);
		assertTrue(eightS.choice_7.isEnabled());
		assertFalse(eightS.choice_6.isEnabled());
		//ako je fillChoices(7) treba biti choice_7 disabled
		eightS.fillChoices(7);
		assertFalse(eightS.choice_7.isEnabled());
	}

}
