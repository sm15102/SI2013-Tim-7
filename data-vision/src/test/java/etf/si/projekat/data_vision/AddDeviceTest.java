package etf.si.projekat.data_vision;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.*;

public class AddDeviceTest 
{
	@Test 
	public void TestAddDeviceName()
	{
		DeviceName dn=new DeviceName();
		dn.setName(null);
		HibernateDeviceName HN = new HibernateDeviceName();
		List<DeviceName> l = HN.giveAllDeviceName();
		for(int i = 0;i<l.size();i++)
		{
			assertNotEquals(dn.getName(),l.get(i).getName());
		}
	}
	@Test
	public void TestAddDeviceType()
	{
		DeviceType dt = new DeviceType();
		dt.setType(null);
		HibernateDeviceType HT = new HibernateDeviceType();
		List<DeviceType> lt = HT.giveAllDeviceType();
		for(int i = 0;i<lt.size();i++)
		{
			assertNotEquals(dt.getType(),lt.get(i).getType());
		}
	}
	@Test
	public void TestAddingDevice()
	{
		DeviceName dn=new DeviceName();
		dn.setName("Senzor za zrak");
		HibernateDeviceName HN = new HibernateDeviceName();
		HN.addDeviceName(dn);
		DeviceType dt = new DeviceType();
		dt.setType("Zrak");
		HibernateDeviceType HT = new HibernateDeviceType();
		HT.addDeviceType(dt);
		List<DeviceName> l = HN.giveAllDeviceName();
		List<DeviceType> lt = HT.giveAllDeviceType();
		int size = l.size()-1;
		int size_1 = lt.size()-1;
		assertEquals("Senzor za zrak",l.get(size).getName());
		assertEquals("Zrak",lt.get(size_1).getType());
	}
}
