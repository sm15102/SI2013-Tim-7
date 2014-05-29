package etf.si.projekat.data_vision;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.*;

public class SenzorTest 
{
	@Test
	public void TestKreiranjaSenzora()
	{
		Senzor s = new Senzor();
		assertEquals(null,s.getDatumMjerenja());
		assertEquals(null,s.getTipSenzora());
		assertEquals(null,s.getDatumMjerenja());
	}

}
