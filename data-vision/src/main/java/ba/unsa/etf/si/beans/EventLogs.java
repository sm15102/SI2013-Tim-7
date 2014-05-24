package ba.unsa.etf.si.beans;

import java.util.Calendar;



public class EventLogs implements java.io.Serializable{
	Long eventlogs_id;
	String device_name;
	String device_type;
	String event_message;
	Calendar timestamp;
	double value;
	
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	ActivityLogs activity_logs;
	
	public EventLogs(){}

	public Long getEventlogs_id() {
		return eventlogs_id;
	}

	public void setEventlogs_id(Long eventlogs_id) {
		this.eventlogs_id = eventlogs_id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getEvent_message() {
		return event_message;
	}

	public void setEvent_message(String event_message) {
		this.event_message = event_message;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public ActivityLogs getActivity_logs() {
		return activity_logs;
	}

	public void setActivity_logs(ActivityLogs activity_logs) {
		this.activity_logs = activity_logs;
	}
	
	
	

	

}
