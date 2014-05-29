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
public class GrafTest 
{
	@Test
	public void TestKreiranjaGrafa()
	{
		Graf g = new Graf();
		assertEquals(null,g.getVrstaGrafa());
		assertEquals(0,g.getBrojPodataka());
		assertEquals(null,g.getTipSenzora());
	}
	
}
