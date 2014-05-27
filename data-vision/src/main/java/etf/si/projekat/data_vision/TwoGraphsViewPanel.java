package etf.si.projekat.data_vision;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import java.awt.Button;
import java.awt.Choice;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.Label;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.List;

import javax.swing.JButton;

import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TwoGraphsViewPanel extends JPanel {
    List<DeviceType> list_device=new HibernateDeviceType().giveAllDeviceType();

	/**
	 * Create the panel.
	 */
	public TwoGraphsViewPanel() {
		setLayout(null);

		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval from");
		lblTimeIntervalFrom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeIntervalFrom.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTimeIntervalFrom.setBounds(10, 85, 113, 14);
		add(lblTimeIntervalFrom);
		
		JLabel lblTimeIntervalTo = new JLabel("Time interval to");
		lblTimeIntervalTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeIntervalTo.setBounds(30, 114, 93, 14);
		add(lblTimeIntervalTo);
		
		JLabel lblDataNumber = new JLabel("Data number");
		lblDataNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNumber.setBounds(40, 139, 83, 14);
		add(lblDataNumber);
		
	/*	 choice = new Choice();
		choice.setBounds(177, 50, 117, 25);
		choice.add("Line");
		choice.add("Bar");
		contentPane.add(choice);*/
		
		SensorChoosingPanel p = new SensorChoosingPanel();
		
		final JSpinner spinner = new JSpinner();
		
		spinner.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		spinner.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner.setBounds(152, 136, 165, 18);
		
		add(spinner);
		
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JLabel lblGraphType = new JLabel("Graph type");
        lblGraphType.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGraphType.setBounds(55, 60, 68, 14);
        add(lblGraphType);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setLocation(152, 75);
        datePicker.setSize(165, 28);
       add(datePicker);
        
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
        datePicker1.setLocation(152, 104);
        datePicker1.setSize(165, 28);
      add(datePicker1);
      
      UtilDateModel model2 = new UtilDateModel();
      JDatePanelImpl datePane2 = new JDatePanelImpl(model2);
      final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePane2);
      datePicker2.setLocation(464, 75);
      datePicker2.setSize(165, 28);
    add(datePicker2);
    
    UtilDateModel model3 = new UtilDateModel();
    JDatePanelImpl datePane3 = new JDatePanelImpl(model3);
    final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePane3);
    datePicker3.setLocation(464, 104);
    datePicker3.setSize(165, 28);
  add(datePicker3);
      
      Choice choice = new Choice();
      choice.setBounds(152, 51, 165, 23);
      add(choice);
      
      Label label = new Label("Basic data");
      label.setBounds(10, 10, 65, 14);
      add(label);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(-13, 30, 330, 15);
      add(separator);
      
      final JLabel lblSensorType = new JLabel("Sensor type");
      lblSensorType.setBounds(10, 201, 77, 14);
      lblSensorType.setVisible(false);
      add(lblSensorType);
      
      final JSeparator separator_1 = new JSeparator();
      separator_1.setBounds(222, 220, -220, -5);
      separator_1.setVisible(false);
      add(separator_1);
      
      
      final JSeparator separator_2 = new JSeparator();
      separator_2.setBounds(10, 226, 307, 2);
      add(separator_2);
      
      final  JLabel label_1 = new JLabel("Sensor type 1");
      label_1.setHorizontalAlignment(SwingConstants.RIGHT);
      label_1.setBounds(28, 241, 95, 14);
      add(label_1);
      
      final JLabel label_2 = new JLabel("Sensor type 2");
      label_2.setHorizontalAlignment(SwingConstants.RIGHT);
      label_2.setBounds(28, 266, 95, 14);
      add(label_2);
      
      final  JLabel label_3 = new JLabel("Sensor type 3");
      label_3.setHorizontalAlignment(SwingConstants.RIGHT);
      label_3.setBounds(30, 291, 95, 14);
      add(label_3);
      
      final  JLabel label_4 = new JLabel("Sensor type 4");
      label_4.setHorizontalAlignment(SwingConstants.RIGHT);
      label_4.setBounds(30, 316, 95, 14);
      add(label_4);
      
      final  JLabel label_5 = new JLabel("Sensor type 5");
      label_5.setHorizontalAlignment(SwingConstants.RIGHT);
      label_5.setBounds(30, 341, 95, 14);
      add(label_5);
      
      final Choice choice_1 = new Choice();
      choice_1.setBounds(152, 235, 165, 20);
      add(choice_1);
      
      final Choice choice_2 = new Choice();
      choice_2.setBounds(152, 261, 165, 20);
      add(choice_2);
      
      final Choice choice_3 = new Choice();
      choice_3.setBounds(152, 285, 165, 20);
      add(choice_3);
      
      final Choice choice_4 = new Choice();
      choice_4.setBounds(152, 310, 165, 20);
      add(choice_4);
      
      final Choice choice_5 = new Choice();
      choice_5.setBounds(152, 335, 165, 20);
      add(choice_5);
      
      final Choice choice_6 = new Choice();
      choice_6.setBounds(152, 360, 165, 20);
      add(choice_6);
      
      final  Choice choice_7 = new Choice();
      choice_7.setBounds(152, 385, 165, 20);
      add(choice_7);
      
      final  Choice choice_8 = new Choice();
      choice_8.setBounds(152, 410, 165, 20);
      add(choice_8);
      
      final Choice choice_9 = new Choice();
      choice_9.setBounds(152, 436, 165, 20);
      add(choice_9);
      
      final  JLabel lblSensorType_1 = new JLabel("Sensor type 6");
      lblSensorType_1.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType_1.setBounds(30, 366, 95, 14);
      add(lblSensorType_1);
      
      final JLabel lblSensorType_2 = new JLabel("Sensor type 7");
      lblSensorType_2.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType_2.setBounds(30, 391, 95, 14);
      add(lblSensorType_2);
      
      final JLabel lblSensorType_3 = new JLabel("Sensor type 8");
      lblSensorType_3.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType_3.setBounds(30, 416, 95, 14);
      add(lblSensorType_3);
      
      final JLabel lblSensorType_4 = new JLabel("Sensor type 9");
      lblSensorType_4.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType_4.setBounds(28, 442, 95, 14);
      add(lblSensorType_4);
      
		choice_1.setVisible(false);
		choice_2.setVisible(false);
		choice_3.setVisible(false);
		choice_4.setVisible(false);
		choice_5.setVisible(false);
		choice_6.setVisible(false);
		choice_7.setVisible(false);
		choice_8.setVisible(false);
		choice_9.setVisible(false);
		
		lblSensorType_1.setVisible(false);
		lblSensorType_2.setVisible(false);
		lblSensorType_3.setVisible(false);
		lblSensorType_4.setVisible(false);
		label_1.setVisible(false);
		label_2.setVisible(false);
		label_3.setVisible(false);
		label_4.setVisible(false);
		label_5.setVisible(false);
		
		lblSensorType.setVisible(false);
		separator_2.setVisible(false);

      JButton btnProcess = new JButton("Process");
      btnProcess.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
      		int value = (Integer) spinner.getValue();
			
			if(value == 0){
				choice_1.setVisible(false);
				choice_2.setVisible(false);
				choice_3.setVisible(false);
				choice_4.setVisible(false);
				choice_5.setVisible(false);
				choice_6.setVisible(false);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(true);
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(false);
				separator_2.setVisible(false);
			}
			
			else if(value == 1){
				choice_1.setVisible(true);
				choice_2.setVisible(false);
				choice_3.setVisible(false);
				choice_4.setVisible(false);
				choice_5.setVisible(false);
				choice_6.setVisible(false);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
			
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				//btnGenerateGraphs.setVisible(true);
			}
			
			else if(value == 2){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(false);
				choice_4.setVisible(false);
				choice_5.setVisible(false);
				choice_6.setVisible(false);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(false);
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				//btnGenerateGraphs.setVisible(true);
			}
			
			else if(value == 3){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(false);
				choice_5.setVisible(false);
				choice_6.setVisible(false);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(false);
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				//btnGenerateGraph.setVisible(true);
			}
			
			else if(value == 4){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(true);
				choice_5.setVisible(false);
				choice_6.setVisible(false);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(false);
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				//btnGenerateGraph.setVisible(true);
			}
			
			else if(value == 5){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(true);
				choice_5.setVisible(true);
				choice_6.setVisible(false);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(false);
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_5.setVisible(true);
				//btnGenerateGraph.setVisible(true);
			}
			
			
			
			
			else if(value == 6){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(true);
				choice_5.setVisible(true);
				choice_6.setVisible(true);
				choice_7.setVisible(false);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(true);
				lblSensorType_2.setVisible(false);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
			
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_5.setVisible(true);
				//btnGenerateGraph.setVisible(true);
			}
			
			else if(value == 7){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(true);
				choice_5.setVisible(true);
				choice_6.setVisible(true);
				choice_7.setVisible(true);
				choice_8.setVisible(false);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(true);
				lblSensorType_2.setVisible(true);
				lblSensorType_3.setVisible(false);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_5.setVisible(true);
			}
			
			else if(value == 8){
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(true);
				choice_5.setVisible(true);
				choice_6.setVisible(true);
				choice_7.setVisible(true);
				choice_8.setVisible(true);
				choice_9.setVisible(false);
				
				lblSensorType_1.setVisible(true);
				lblSensorType_2.setVisible(true);
				lblSensorType_3.setVisible(true);
				lblSensorType_4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_5.setVisible(true);
				//btnGenerateGraph.setVisible(true);
			}
			
			else{
				choice_1.setVisible(true);
				choice_2.setVisible(true);
				choice_3.setVisible(true);
				choice_4.setVisible(true);
				choice_5.setVisible(true);
				choice_6.setVisible(true);
				choice_7.setVisible(true);
				choice_8.setVisible(true);
				choice_9.setVisible(true);
				
				lblSensorType_1.setVisible(true);
				lblSensorType_2.setVisible(true);
				lblSensorType_3.setVisible(true);
				lblSensorType_4.setVisible(true);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_5.setVisible(true);
				//btnGenerateGraph.setVisible(true);
			}
			
			
			
		      
		      for (int i=0; i<list_device.size(); i++){
			    	 choice_1.add(list_device.get(i).getType() );
			    	 choice_2.add(list_device.get(i).getType() );
			    	 choice_3.add(list_device.get(i).getType() );
			    	 choice_4.add(list_device.get(i).getType() );
			    	 choice_5.add(list_device.get(i).getType() );
			    	 choice_6.add(list_device.get(i).getType() );
			    	 choice_7.add(list_device.get(i).getType() );
			    	 choice_8.add(list_device.get(i).getType() );
			    	 choice_9.add(list_device.get(i).getType() );
		      }
		      
		     
		     
	
		  		
		      	
			
      	}
      });
		
      
 
 
      
      
      btnProcess.setBounds(181, 165, 136, 23);
      add(btnProcess);
      
      
      Label label_10 = new Label("Basic data");
      label_10.setBounds(358, 10, 65, 14);
      add(label_10);
      
      final  Label label_11 = new Label("Sensor type");
      label_11.setBounds(358, 201, 65, 14);
      label_11.setVisible(false);
      add(label_11);
      
      final  Label label_12 = new Label("Sensor type 1");
      label_12.setBounds(376, 241, 83, 14);
      label_12.setVisible(false);
      add(label_12);
      
      final Choice choice_11 = new Choice();
     choice_11.setVisible(false);
      choice_11.setBounds(464, 235, 165, 20);
      add(choice_11);
      
      final Label label_13 = new Label("Sensor type 2");
      label_13.setBounds(376, 266, 83, 14);
      label_13.setVisible(false);
      add(label_13);
      
      final  Label label_14 = new Label("Sensor type 3");
      label_14.setBounds(376, 291, 83, 14);
      label_14.setVisible(false);
      add(label_14);
      
      final  Label label_15 = new Label("Sensor type 4");
      label_15.setBounds(376, 316, 83, 14);
      label_15.setVisible(false);
      add(label_15);
      
      final  Label label_16 = new Label("Sensor type 5");
      label_16.setBounds(376, 341, 83, 14);
      label_16.setVisible(false);
      add(label_16);
      
      final  Label label_17 = new Label("Sensor type 6");
      label_17.setBounds(376, 366, 83, 14);
      label_17.setVisible(false);
      add(label_17);
      
      final Label label_18 = new Label("Sensor type 7");
      label_18.setBounds(376, 391, 83, 14);
      label_18.setVisible(false);
      add(label_18);
      
      final Label label_19 = new Label("Sensor type 8");
      label_19.setVisible(false);
      label_19.setBounds(376, 416, 83, 14);
      add(label_19);
      
      final Label label_20 = new Label("Sensor type 9");
    
      label_20.setBounds(376, 442, 83, 14);
      label_20.setVisible(false);
      add(label_20);
      
      final Choice choice_12 = new Choice();
      choice_12.setBounds(464, 260, 165, 20);
      choice_12.setVisible(false);
      add(choice_12);
      
      final  Choice choice_13 = new Choice();
      choice_13.setBounds(464, 285, 165, 20);
      choice_13.setVisible(false);
      add(choice_13);
      
      final  Choice choice_14 = new Choice();
      choice_14.setBounds(464, 310, 165, 20);
      choice_14.setVisible(false);
      add(choice_14);
      
      final  Choice choice_15 = new Choice();
      choice_15.setBounds(464, 335, 165, 20);
      choice_15.setVisible(false);
      add(choice_15);
      
      final Choice choice_16 = new Choice();
      choice_16.setBounds(464, 360, 165, 20);
      choice_16.setVisible(false);
      add(choice_16);
      
      final  Choice choice_17 = new Choice();
      choice_17.setBounds(464, 385, 165, 20);
      choice_17.setVisible(false);
      add(choice_17);
      
      final  Choice choice_18 = new Choice();
      choice_18.setBounds(464, 410, 165, 20);
      choice_18.setVisible(false);
      add(choice_18);
      
      final  Choice choice_19 = new Choice();
      choice_19.setBounds(464, 436, 165, 20);
      choice_19.setVisible(false);
      add(choice_19);
      
      final JButton btnGenerateGraphs = new JButton("Generate graphs");
      btnGenerateGraphs.setBounds(493, 462, 136, 23);
      btnGenerateGraphs.setVisible(false);
      add(btnGenerateGraphs);
      
      final JSeparator separator_3 = new JSeparator();
      separator_3.setBounds(356, 226, 273, 16);
      separator_3.setVisible(false);
      add(separator_3);
      
      JSeparator separator_4 = new JSeparator();
      //separator_4.setForeground(Color.GRAY);
      separator_4.setBounds(622, 30, -273, 15);
      add(separator_4);
      
      JSeparator separator_5 = new JSeparator();
      separator_5.setBounds(358, 30, 330, 15);
      add(separator_5);
      
      
      final JLabel label_6 = new JLabel("Graph type");
      label_6.setHorizontalAlignment(SwingConstants.RIGHT);
      label_6.setBounds(373, 57, 68, 14);
      add(label_6);
      
      final  Choice choice_10 = new Choice();
      choice_10.setBounds(464, 51, 165, 20);
      add(choice_10);
      
      final JLabel label_7 = new JLabel("Time interval from");
      label_7.setVerticalAlignment(SwingConstants.BOTTOM);
      label_7.setHorizontalAlignment(SwingConstants.RIGHT);
      label_7.setBounds(327, 85, 113, 14);
      add(label_7);
      
      JLabel label_8 = new JLabel("Time interval to");
      label_8.setHorizontalAlignment(SwingConstants.RIGHT);
      label_8.setBounds(348, 114, 93, 14);
      add(label_8);
      
      JLabel label_9 = new JLabel("Data number");
      label_9.setHorizontalAlignment(SwingConstants.RIGHT);
      label_9.setBounds(358, 139, 83, 14);
      add(label_9);
      
      final JSpinner spinner_1 = new JSpinner();
      spinner_1.setBounds(464, 136, 165, 18);
      add(spinner_1);
      
      JButton button = new JButton("Process");
      
    //-------------------------------------------------------------------------
      button.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      	  int valueSecondGraph = (Integer) spinner_1.getValue();
      		
      		// KOD ZA DRUGI GRAF
      		if(valueSecondGraph == 0){
				choice_11.setVisible(false);
				choice_12.setVisible(false);
				choice_13.setVisible(false);
				choice_14.setVisible(false);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(false);
				label_12.setVisible(false);
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				
				separator_3.setVisible(false);
			}
			
			else if(valueSecondGraph == 1){
				choice_11.setVisible(true);
				choice_12.setVisible(false);
				choice_13.setVisible(false);
				choice_14.setVisible(false);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				
				separator_3.setVisible(true);
				btnGenerateGraphs.setVisible(true);
				
			}
			
			else if(valueSecondGraph == 2){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(false);
				choice_14.setVisible(false);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(false);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				
				separator_3.setVisible(true);
				btnGenerateGraphs.setVisible(true);
			}
			
			else if(valueSecondGraph == 3){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(false);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				btnGenerateGraphs.setVisible(true);
				separator_3.setVisible(true);
			}
			
			else if(valueSecondGraph == 4){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(true);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				btnGenerateGraphs.setVisible(true);
				separator_3.setVisible(true);
			}
			
			else if(valueSecondGraph == 5){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(true);
				choice_15.setVisible(true);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				btnGenerateGraphs.setVisible(true);
				separator_3.setVisible(true);
			}
			
			
			
			
			else if(valueSecondGraph == 6){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(true);
				choice_15.setVisible(true);
				choice_16.setVisible(true);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				
				separator_3.setVisible(true);
			}
			
			else if(valueSecondGraph == 7){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(true);
				choice_15.setVisible(true);
				choice_16.setVisible(true);
				choice_17.setVisible(true);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(true);
				label_19.setVisible(false);
				label_20.setVisible(false);
				btnGenerateGraphs.setVisible(true);
				separator_3.setVisible(true);
			}
			
			else if(valueSecondGraph == 8){
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(true);
				choice_15.setVisible(true);
				choice_16.setVisible(true);
				choice_17.setVisible(true);
				choice_18.setVisible(true);
				choice_19.setVisible(false);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(true);
				label_19.setVisible(true);
				label_20.setVisible(false);
				btnGenerateGraphs.setVisible(true);
				separator_3.setVisible(true);
			}
			
			else{
				choice_11.setVisible(true);
				choice_12.setVisible(true);
				choice_13.setVisible(true);
				choice_14.setVisible(true);
				choice_15.setVisible(true);
				choice_16.setVisible(true);
				choice_17.setVisible(true);
				choice_18.setVisible(true);
				choice_19.setVisible(true);
				
				label_11.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(true);
				label_19.setVisible(true);
				label_20.setVisible(true);
				btnGenerateGraphs.setVisible(true);
				separator_3.setVisible(true);
			}
      		
      		
      	}
      });
      button.setBounds(493, 165, 136, 23);
      add(button);
      
      //-------------------------------------------------------------------------------
      
     
      
     
      
      
      
  
	}
}
      
      