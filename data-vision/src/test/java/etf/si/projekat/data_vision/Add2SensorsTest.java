package etf.si.projekat.data_vision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

public class Add2SensorsTest {

	@Test
	public void testAdd2Sensors() {
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
	}

	@Test
	public void testFillChoices() {
		Add2Sensors twoS = new Add2Sensors(null, null, null);
		twoS.fillChoices(1);
		//ako je fillChoices(1) treba biti choice_1 enabled, a choice disabled
		assertTrue(twoS.choice_1.isEnabled());
		assertFalse(twoS.choice.isEnabled());
		twoS.fillChoices(2);
		//ako je fillChoices(2) treba biti choice_1 disabled;
		assertFalse(twoS.choice_1.isEnabled());
	}

}
