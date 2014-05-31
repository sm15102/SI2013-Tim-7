package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

public class Add3SensorsTest {

	@Test
	public void testAdd3Sensors() {
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
	}

	@Test
	public void testFillChoices() {
		Add3Sensors threeS = new Add3Sensors(null, null, null);
		threeS.fillChoices(1);
		//ako je fillChoices(1) treba biti choice_1 enabled, a choice disabled
		assertTrue(threeS.choice_1.isEnabled());
		assertFalse(threeS.choice.isEnabled());
		threeS.fillChoices(2);
		//ako je fillChoices(2) treba biti choice_1 disabled, a choice_2 enabled
		assertTrue(threeS.choice_2.isEnabled());
		assertFalse(threeS.choice_1.isEnabled());
		threeS.fillChoices(3);
		//ako je fillChoices(3) treba biti choice_2 disabled;
		assertFalse(threeS.choice_2.isEnabled());
	}

}
