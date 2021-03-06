package etf.si.projekat.data_vision;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateEventLogs;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Consumption extends JPanel {
	private List<DeviceName> listdevices;
	public List<DeviceType> ListDevices = new ArrayList<DeviceType>();
	final JTable table;
	private String selecteddevice;
	private  DefaultTableModel tablemodel;
	private  DefaultTableModel tablemodel1;
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
	final JScrollPane pane1;
	final JSpinner spinner;
	private JTable table1;
	final JLabel lblTotalResult;
   
	
public Consumption() {
	setForeground(Color.WHITE);
	setBounds(10, 49, 990, 501);
	setBackground(Color.WHITE);
	setLayout(null);
	
	JLabel lblTimeIntervalFrom = new JLabel("Time interval to:");
	lblTimeIntervalFrom.setBounds(50, 49, 114, 27);
	add(lblTimeIntervalFrom);
	
	JLabel lblDevice = new JLabel("Device:");
	lblDevice.setBounds(50, 86, 114, 27);
	add(lblDevice);
	
	JLabel lblPower = new JLabel("Power:");
	lblPower.setBounds(50, 124, 114, 27);
	add(lblPower);
	
	btnAdd = new JButton("Calculate");
	btnAdd.setBounds(195, 164, 165, 28);
	add(btnAdd);
	
	JLabel lblTimeInterfvalFrom = new JLabel("Time interval from:");
	lblTimeInterfvalFrom.setBounds(50, 11, 114, 27);
	add(lblTimeInterfvalFrom);
	
	model = new UtilDateModel();
	datePanel = new JDatePanelImpl(model);
	
	time_interval_from = new JDatePickerImpl(datePanel);
    time_interval_from.setLocation(195, 11);
    time_interval_from.setSize(165, 28);
    add(time_interval_from);
    
    model1 = new UtilDateModel();
    datePane1 = new JDatePanelImpl(model1);
    time_interval_to = new JDatePickerImpl(datePane1);
    time_interval_to.setLocation(195, 48);
    time_interval_to.setSize(165, 28);
    add(time_interval_to);
    
    devices = new JComboBox();
    devices.addPopupMenuListener(new PopupMenuListener() {
    	public void popupMenuCanceled(PopupMenuEvent arg0) {
    	}
    	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
    		if(selecteddevice!=null && !"Chose device...".equals(selecteddevice))
    			eraseTable();
    		    PopuniTabelu();
    		
    	}
    	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
    		devices.removeAllItems();
    		
    		List<DeviceName> listdevices = new HibernateDeviceName().giveAllDeviceName();
    		
    		devices.addItem("Chose device...");
    		for(int i=0; i<listdevices.size(); i++){
    		devices.addItem(listdevices.get(i).getName());
    		}
    	}
    });
    
    devices.setToolTipText("Device name");
    devices.setBounds(195, 86, 165, 28);
    add(devices);
        
    units = new JComboBox();
    units.setModel(new DefaultComboBoxModel(new String[] {"watts (W)", "kilowatts (kW)"}));
        units.setBounds(370, 125, 120, 28);
        add(units);
        
        Model();
        Model1();
        
        table = new  JTable();
        table.setBackground(Color.WHITE);
        table.setModel(tablemodel);
        table.setVisible(true);
        pane = new JScrollPane(table);
        pane.setSize(440, 255);
        pane.setLocation(50, 235);
        add(pane);
        
        table1 = new JTable();
        table1.setBackground(Color.WHITE);
        table1.setVisible(true);
        table1.setModel(tablemodel1);
        pane1 = new JScrollPane(table1);
        pane1.setSize(369, 255);
        pane1.setLocation(549, 235);
        add(pane1);
       
        
        
        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(10)));
        spinner.setBounds(195, 125, 165, 28);
        add(spinner);
        
        Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
        rigidArea.setBounds(50, 0, 440, 201);
        add(rigidArea);
        
        JLabel lblNewLabel = new JLabel("Event logs for selected device");
        lblNewLabel.setBounds(50, 211, 200, 14);
        add(lblNewLabel);
        
        JLabel lblNewLabel1 = new JLabel("Periodical results (kWh)");
        lblNewLabel1.setBounds(550, 211, 150, 14);
        add(lblNewLabel1);
        
        JLabel lblNewLabel2 = new JLabel("Total result for selected period ");
        lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel2.setBounds(549, 20, 260, 31);
        add(lblNewLabel2);
        
        lblTotalResult = new JLabel("0.0000 kWh");
        lblTotalResult.setForeground(Color.BLACK);
        lblTotalResult.setToolTipText("Result");
        lblTotalResult.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblTotalResult.setBounds(549, 62, 304, 58);
        add(lblTotalResult);
       
        
       
        
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				calculateResults();
				
			}
			
		});
		devices.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			selecteddevice =(String) arg0.getItem();
			eraseTable();
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
	            		Integer.class, String.class, String.class, String.class, String.class, String.class
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
public void Model1() {
	tablemodel1=new DefaultTableModel(
        	new Object[][] {},
            	new String[] {
            		"Date from", "Date to", "Energy Cuonsumption"
            	}
            ) {
            	Class[] columnTypes = new Class[] {
            		String.class, String.class, Double.class
            	};
            	public Class getColumnClass(int columnIndex) {
            		return columnTypes[columnIndex];
            	}
            	boolean[] columnEditables = new boolean[] {
            		false, false, false
            	};
            	public boolean isCellEditable(int row, int column) {
            		return columnEditables[column];
            	}
            };
            
           
   }

private void PopuniTabelu(){
	
	if(model.getValue() == null){
		JOptionPane.showMessageDialog(null, "Enter Time interval from value", "Error", JOptionPane.ERROR_MESSAGE);
		return;
		}
	if(model1.getValue() == null){
		JOptionPane.showMessageDialog(null, "Enter Time interval to value", "Error", JOptionPane.ERROR_MESSAGE);
		return;
		}
	if(model1.getValue().before(model.getValue())){
		JOptionPane.showMessageDialog(null, "Time interval from and time interval to are in inccorect order", "Info", JOptionPane.INFORMATION_MESSAGE);
		return;
		}
	if (!"Chose device...".equals(selecteddevice)){
		try{
			List<EventLogs>sveKolone = new HibernateEventLogs().getdatesbetween(selecteddevice, model.getValue(), model1.getValue());
			if(sveKolone.size() == 0 && !"Chose device...".equals(selecteddevice)){
				JOptionPane.showMessageDialog(null, "Thera are no data", "Info", JOptionPane.INFORMATION_MESSAGE);
				return;
				}
			for(int i=0;i<sveKolone.size();i++){
				EventLogs e=sveKolone.get(i);
				String id=e.getEventlogs_id().toString();
				String devName=e.getDevice_name();
				String devType=e.getDevice_type();
				String evMessage=e.getEvent_message();
				String value=String.valueOf(e.getValue());
				String time = null;
				if(e.getTimestamp()!=null){
					SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
					time = formatter.format(e.getTimestamp());
					}
				if(devName.equals(selecteddevice)){
					tablemodel.addRow(new Object[]{id,devName,devType,evMessage,value,time });
					}
				}
			}catch(Exception m){
				JOptionPane.showMessageDialog(null, "Thera are no data", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
		
		}
}
	


private void eraseTable(){   
	tablemodel.getDataVector().removeAllElements();
	tablemodel.fireTableDataChanged();	
}
private void eraseResultTable(){   
	tablemodel1.getDataVector().removeAllElements();
	tablemodel1.fireTableDataChanged();	
}

private List<ActivePeriod> activePeriods(){
	List<ActivePeriod> periods = new ArrayList<ActivePeriod>();
	
	Boolean on = false;
	int rowcount = tablemodel.getRowCount();
	
	ActivePeriod activeperiod = new ActivePeriod();
	for(int i=0;i<rowcount;i++){   
		int id =Integer.valueOf((String) table.getModel().getValueAt(i, 0));
		EventLogs ev = new HibernateEventLogs().giveEventLogs(id);
		String message = ev.getEvent_message();
		if(("open".equalsIgnoreCase(message) ||"turnOn".equalsIgnoreCase(message)) && !on && i<rowcount-1){
			on = true;
			activeperiod.setStart(ev.getTimestamp());
		 }else if(("closed".equalsIgnoreCase(message) || "turnOff".equalsIgnoreCase(message)) && on){
		 on=false;
		 activeperiod.setEnd(ev.getTimestamp());
		 periods.add(activeperiod);
		 activeperiod = new ActivePeriod(); 
		 }else if(("open".equalsIgnoreCase(message) || "turnOn".equalsIgnoreCase(message)) && i==rowcount-1){
			 on=false;
			 activeperiod.setStart(ev.getTimestamp());
			 activeperiod.setEnd(model1.getValue());
			 periods.add(activeperiod);
			 activeperiod = new ActivePeriod();
			 }
		
	}
	 return periods;
	
}
 private void calculateResults(){
	 List<ActivePeriod> periods = new ArrayList<ActivePeriod>();
	 periods = activePeriods();
	 if(periods.isEmpty()){
		 JOptionPane.showMessageDialog(null,"There are no data to calculate", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
		 return;
	 }
	 if(tablemodel1.getRowCount() > 0){
		 eraseResultTable();
	 }
	 double power = (Double) spinner.getValue();
	 if(power == 0){
		 lblTotalResult.setText("0 kWh");
		 return;
		 }
	 double periodicalConsumption;
	 double totalConsumption = 0;
	 SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
	  
	 for(int i=0;i<periods.size();i++){
		 Date date1 = periods.get(i).getStart();
		 Date date2 = periods.get(i).getEnd();
		 long hoursbetween = (date2.getTime() - date1.getTime())/3600000; 
		 periodicalConsumption = power*hoursbetween;
		 tablemodel1.addRow(new Object[]{formatter.format(date1),formatter.format(date2),periodicalConsumption});
		 totalConsumption+=periodicalConsumption;
	 }
	 
	 if("watts (W)".equals((String)units.getSelectedItem())) {
		 lblTotalResult.setText(String.format("%.4f",totalConsumption*1000) +" Wh");
		 }
		 if("kilowatts (kW)".equals((String)units.getSelectedItem())){
		 lblTotalResult.setText(String.format("%.4f",totalConsumption)+" kWh");
		 }
		 
 }

}

