package ba.unsa.etf.si.beans;

public class DeviceName implements java.io.Serializable {
	private long devicename_id;
	private String name;
	
	public DeviceName() {}
	
	public long getDevicename_id() {
		return devicename_id;
	}
	public void setDevicename_id(long devicename_id) {
		this.devicename_id = devicename_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
