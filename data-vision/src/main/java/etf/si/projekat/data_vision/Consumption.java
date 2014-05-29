package etf.si.projekat.data_vision;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.NoResultException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateEventLogs;


public class Consumption extends JPanel {
	List<DeviceName> listdevices = new HibernateDeviceName().giveAllDeviceName();
	public ArrayList<DeviceType> ArrayDevices = new ArrayList<DeviceType>();
	final JTable table;
	private String selecteddevice;
	private  DefaultTableModel tablemodel;
	final  UtilDateModel model;
	final  UtilDateModel model1;
	final JComboBox devices;
	final JButton btnAdd;
	final  JDatePanelImpl datePanel;
	final JDatePickerImpl time_interval_from;
	final JDatePanelImpl datePane1;
	final JDatePickerImpl time_interval_to;
	final JComboBox units;
	final JScrollPane pane;
	final JSpinner spinner;
   
	
public Consumption() {
	   setBounds(10, 49, 694, 501);
	   
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval to:");
		lblTimeIntervalFrom.setBounds(43, 111, 78, 14);
		add(lblTimeIntervalFrom);
		
		JLabel lblDevice = new JLabel("Device:");
		lblDevice.setBounds(75, 142, 53, 14);
		add(lblDevice);
		
	    JLabel lblPower = new JLabel("Power:");
		lblPower.setBounds(75, 173, 53, 14);
		add(lblPower);
		
	    btnAdd = new JButton("Calculate");
		btnAdd.setBounds(132, 201, 89, 23);
		add(btnAdd);
		
		JLabel lblTimeInterfvalFrom = new JLabel("Time interval from:");
		lblTimeInterfvalFrom.setBounds(33, 76, 95, 14);
		add(lblTimeInterfvalFrom);
		
		model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        time_interval_from = new JDatePickerImpl(datePanel);
        time_interval_from.setLocation(132, 63);
        time_interval_from.setSize(117, 27);
        add(time_interval_from);
        
        
        model1 = new UtilDateModel();
        datePane1 = new JDatePanelImpl(model1);
        time_interval_to = new JDatePickerImpl(datePane1);
        time_interval_to.setLocation(132, 101);
        time_interval_to.setSize(117, 27);
        add(time_interval_to);
        
        
        
        
        devices = new JComboBox();
        devices.setBounds(132, 139, 117, 20);
        add(devices);
        devices.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        		if(selecteddevice != null)
        		PopuniTabelu();
        	}
        });
        
        units = new JComboBox();
        
		for(int i=0; i<listdevices.size(); i++){
			devices.addItem(listdevices.get(i).getName());
			}
			
        units.setModel(new DefaultComboBoxModel(new String[] {"watts (W)", "kilowarrs (kW)"}));
        units.setBounds(259, 139, 96, 20);
        add(units);
        
     
        Model();
        
        table = new  JTable();
        table.setBackground(Color.WHITE);
        table.setModel(tablemodel);
        table.setVisible(true);
        pane = new JScrollPane(table);
        pane.setSize(445, 149);
        pane.setLocation(10, 235);
        add(pane);
       
        
        
        spinner = new JSpinner();
        spinner.setBounds(132, 170, 114, 20);
        add(spinner);
        
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				ActivePeriods();
				
				JOptionPane.showMessageDialog(null, selecteddevice, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		devices.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			selecteddevice = (String) arg0.getItem();
			EarseTable();
			 
			
    	}
    });
		
		
	}
	
	private List<EventLogs> getTableData(){
		List<EventLogs> data =  new HibernateEventLogs().giveAllEventLogs();
		return data;
	}
	
public void Model() {
		tablemodel=new DefaultTableModel(
	        	new Object[][] {},
	            	new String[] {
	            		"Br.", "Device name", "Device type", "Event message", "Value", "Timestamp"
	            	}
	            ) {
	            	Class[] columnTypes = new Class[] {
	            		Integer.class, String.class, String.class, String.class, String.class, Date.class
	            	};
	            	public Class getColumnClass(int columnIndex) {
	            		return columnTypes[columnIndex];
	            	}
	            	boolean[] columnEditables = new boolean[] {
	            		false, false, false, false, false, false
	            	};
	            	public boolean isCellEditable(int row, int column) {
	            		return columnEditables[column];
	            	}
	            };
	            
	           
	   }

private void PopuniTabelu()
{
	
	if(model.getValue() == null)
	{
		JOptionPane.showMessageDialog(null, "Enter Time interval from value", "Error", JOptionPane.ERROR_MESSAGE);
		return;
	}
	if(model1.getValue() == null)
	{
		JOptionPane.showMessageDialog(null, "Enter Time interval to value", "Error", JOptionPane.ERROR_MESSAGE);
		return;
	}
	
	try{
    List<EventLogs> sveKolone = new HibernateEventLogs().getdatesbetween(selecteddevice, model.getValue(), model1.getValue());
	
	
	for(int i=0;i<sveKolone.size();i++)
	{
		EventLogs e=sveKolone.get(i);
		String id=e.getEventlogs_id().toString();
		String devName=e.getDevice_name();
		String devType=e.getDevice_type();
		String evMessage=e.getEvent_message();
		String value=String.valueOf(e.getValue());
		
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date time = null;
		if(e.getTimestamp()!=null){
		
	    time = e.getTimestamp();}
		
		if(devName.equals(selecteddevice)){
			tablemodel.addRow(new Object[]{id,devName,devType,evMessage,value,time });}}
		} catch(Exception m){JOptionPane.showMessageDialog(null, "Thera are no data", "Info", JOptionPane.INFORMATION_MESSAGE);}
	}


private void EarseTable()
{   
	tablemodel.getDataVector().removeAllElements();
	tablemodel.fireTableDataChanged();	
}

public void ActivePeriods()
{
	Date start = model.getValue();
	Date end = model1.getValue();
	List<Integer> activeperiod = new ArrayList<Integer>();
	int rowcount = tablemodel.getRowCount();
	long datedifference = start.getTime() - end.getTime();
	datedifference = TimeUnit.MILLISECONDS.toSeconds(datedifference);
	JOptionPane.showMessageDialog(null, datedifference, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
	
}






	
}

