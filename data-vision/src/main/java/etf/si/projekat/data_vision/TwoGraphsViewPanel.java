package etf.si.projekat.data_vision;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.Label;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TwoGraphsViewPanel extends ExamplePanel {
	 List<DeviceName> list_device=new HibernateDeviceName().giveAllDeviceName();

    final Choice choice; 
    final  Choice choice_10;
    final Choice choice_1;
    final Choice choice_2;
    final Choice choice_3;
    final Choice choice_4;
    final Choice choice_5;
    final Choice choice_6;
    final Choice choice_7;
    final Choice choice_8;
    final Choice choice_9;
    final Choice choice_11;
    final Choice choice_12;
    final Choice choice_13;
    final Choice choice_14;
    final Choice choice_15;
    final Choice choice_16;
    final Choice choice_17;
    final Choice choice_18;
    final Choice choice_19;
    final JSpinner spinner;
    final JSpinner spinner_2;
    final JTabbedPane tabbedPane;
    //final JTabbedPane tabbedPane;
   InteractivePanel interactivePanel;
  InteractivePanel interactivePanel1;
  InteractivePanel interactivePanel2;
  private JPanel contentPane;
   
	/**
	 * Create the panel.
	 */
	public TwoGraphsViewPanel(JTabbedPane tabbedPane_1) {
		tabbedPane=tabbedPane_1;
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
		
		  final JButton btnGenerateGraphs = new JButton("Generate graphs");
	      btnGenerateGraphs.setBounds(493, 477, 136, 23);
	      btnGenerateGraphs.setVisible(false);
	      add(btnGenerateGraphs);
		
		
		SensorChoosingPanel p = new SensorChoosingPanel();
		
		spinner = new JSpinner();
		
		spinner.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
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
      
      choice = new Choice();
      choice.setBounds(152, 51, 165, 23);
      choice.add("Line");
      choice.add("Bar");
      add(choice);
      
      Label label = new Label("Basic data");
      label.setBounds(10, 10, 65, 14);
      add(label);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(10, 30, 614, 15);
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
      separator_2.setBounds(10, 228, 619, 2);
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
      
      choice_1 = new Choice();
      choice_1.setBounds(152, 235, 165, 20);
      add(choice_1);
      choice_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				
				fillChoices(1);
			}
		});
      choice_2 = new Choice();
      choice_2.setBounds(152, 261, 165, 20);
      add(choice_2);
      choice_2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(2);
			}
		});
      choice_3 = new Choice();
      choice_3.setBounds(152, 285, 165, 20);
      add(choice_3);
      choice_3.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(3);
			}
		});
      choice_4 = new Choice();
      choice_4.setBounds(152, 310, 165, 20);
      add(choice_4);
      choice_4.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(4);
			}
		});
      choice_5 = new Choice();
      choice_5.setBounds(152, 335, 165, 20);
      add(choice_5);
      choice_5.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(5);
			}
		});
      choice_6 = new Choice();
      choice_6.setBounds(152, 360, 165, 20);
      add(choice_6);
      choice_6.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(6);
			}
		});
      choice_7 = new Choice();
      choice_7.setBounds(152, 385, 165, 20);
      add(choice_7);
      choice_7.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(7);
			}
		});
      choice_8 = new Choice();
      choice_8.setBounds(152, 410, 165, 20);
      add(choice_8);
      choice_8.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(8);
			}
		});
      choice_9 = new Choice();
      choice_9.setBounds(152, 436, 165, 20);
      add(choice_9);
      choice_9.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(9);
			}
		});
      
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
      btnProcess.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
      btnProcess.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
      		choice_1.enable();
      		choice_2.enable();
      		choice_3.enable();
      		choice_4.enable();
      		choice_5.enable();
      		choice_6.enable();
      		choice_7.enable();
      		choice_8.enable();
      		choice_9.enable();
      		
      		choice_1.removeAll();
      		choice_2.removeAll();
      		choice_3.removeAll();
      		choice_4.removeAll();
      		choice_5.removeAll();
      		choice_6.removeAll();
      		choice_7.removeAll();
      		choice_8.removeAll();
      		choice_9.removeAll();
      		
      		
      		int value = (Integer) spinner.getValue();
			
			
			
			if(value == 1){
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
				lblSensorType_1.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator_2.setVisible(true);
				
				label_1.setVisible(true);
				label_2.setVisible(false);
				label_3.setVisible(false);
				label_4.setVisible(false);
				label_5.setVisible(false);
			
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
				label_3.setVisible(false);
				label_4.setVisible(false);
				label_5.setVisible(false);
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
				label_4.setVisible(false);
				label_5.setVisible(false);

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
				
				
				lblSensorType.setVisible(false);
				separator_2.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_5.setVisible(false);
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

			}
			
    
		      for (int i=0; i<list_device.size(); i++){
			    	 choice_1.add(list_device.get(i).getName() );
			    	
		      }
		      
		     
		     
	
		  		
		      	
			
      	}
      });
		
      
 
 
      
      
      btnProcess.setBounds(181, 165, 136, 23);
      add(btnProcess);
      
      final  Label label_12 = new Label("Sensor type 1");
      label_12.setBounds(376, 241, 83, 14);
      label_12.setVisible(false);
      add(label_12);
      
      choice_11 = new Choice();
     choice_11.setVisible(false);
      choice_11.setBounds(464, 235, 165, 20);
      add(choice_11);
      choice_11.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(1);
			}
		});
      
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
      
      choice_12 = new Choice();
      choice_12.setBounds(464, 260, 165, 20);
      choice_12.setVisible(false);
      add(choice_12);
      choice_12.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(2);
			}
		});
      choice_13 = new Choice();
      choice_13.setBounds(464, 285, 165, 20);
      choice_13.setVisible(false);
      add(choice_13);
      choice_13.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(3);
			}
		});
      choice_14 = new Choice();
      choice_14.setBounds(464, 310, 165, 20);
      choice_14.setVisible(false);
      add(choice_14);
      choice_14.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(4);
			}
		});
      choice_15 = new Choice();
      choice_15.setBounds(464, 335, 165, 20);
      choice_15.setVisible(false);
      add(choice_15);
      choice_15.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(5);
			}
		});
      choice_16 = new Choice();
      choice_16.setBounds(464, 360, 165, 20);
      choice_16.setVisible(false);
      add(choice_16);
      choice_16.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(6);
			}
		});
      
      choice_17 = new Choice();
      choice_17.setBounds(464, 385, 165, 20);
      choice_17.setVisible(false);
      add(choice_17);
      choice_17.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(7);
			}
		});
      
      choice_18 = new Choice();
      choice_18.setBounds(464, 410, 165, 20);
      choice_18.setVisible(false);
      add(choice_18);
      choice_18.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(8);
			}
		});
      
      choice_19 = new Choice();
      choice_19.setBounds(464, 436, 165, 20);
      choice_19.setVisible(false);
      add(choice_19);
      choice_19.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices_1(9);
			}
		});

      
      btnGenerateGraphs.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		/*if(choice.getSelectedItem()=="Bar")	
          	{
          		OneBarGraphShow();
          	}
          	if(choice.getSelectedItem()=="Line")	
          	{
          		OneLineGraphShow();
          	}
      		
      		if(choice_10.getSelectedItem()=="Bar")
      		{
      		OneBarGraphShow();
      		}
      		
      		if(choice_10.getSelectedItem()=="Line")
      		{
      		OneLineGraphShow();
      		}
      		*/
      		twoGraphsShow();
      			
      	}
      });
      btnGenerateGraphs.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
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
      
      
      final JLabel label_6 = new JLabel("Graph type");
      label_6.setHorizontalAlignment(SwingConstants.RIGHT);
      label_6.setBounds(373, 57, 68, 14);
      add(label_6);
      
      choice_10 = new Choice();
      choice_10.setBounds(464, 51, 165, 20);
      choice_10.add("Line");
      choice_10.add("Bar");
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
      

      
      JButton button = new JButton("Process");
      button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
      
    //-------------------------------------------------------------------------
      button.addMouseListener(new MouseAdapter() {
      	@SuppressWarnings("deprecation")
		@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
      		choice_11.enable();
      		choice_12.enable();
      		choice_13.enable();
      		choice_14.enable();
      		choice_15.enable();
      		choice_16.enable();
      		choice_17.enable();
      		choice_18.enable();
      		choice_19.enable();
      		
      		choice_11.removeAll();
      		choice_12.removeAll();
      		choice_13.removeAll();
      		choice_14.removeAll();
      		choice_15.removeAll();
      		choice_16.removeAll();
      		choice_17.removeAll();
      		choice_18.removeAll();
      		choice_19.removeAll();
      		
      		
      		
      	  int valueSecondGraph = (Integer) spinner_2.getValue();
      		
      		// KOD ZA DRUGI GRAF
      		
			
			 if(valueSecondGraph == 1){
				choice_11.setVisible(true);
				choice_12.setVisible(false);
				choice_13.setVisible(false);
				choice_14.setVisible(false);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				
				label_12.setVisible(true);
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				
				
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
				
		
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(false);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
			
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
				
		
				label_12.setVisible(true);
				label_13.setVisible(true);
				label_14.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
				
			
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
				
			}
      		
      		
      		for (int i=0; i<list_device.size(); i++){
		    	 choice_11.add(list_device.get(i).getName() );
		    	
	      }
	      
      		
      		
      	}
      });
      button.setBounds(493, 165, 136, 23);
      add(button);
      
      spinner_2 = new JSpinner();
      spinner_2.setModel(new SpinnerNumberModel(1, 1, 9, 1));
      spinner_2.setBounds(464, 136, 165, 18);
      add(spinner_2);
	}
      
     
      
      //-------------------------------------------------------------------------------
      
public void OneBarGraphShow(){
		
		
		List<Choice> choices=new ArrayList<Choice>();
		choices.add(choice_1);
		choices.add(choice_2);
		choices.add(choice_3);
		choices.add(choice_4);
		choices.add(choice_5);
		choices.add(choice_6);
		choices.add(choice_7);
		choices.add(choice_8);
		choices.add(choice_9);
		
		Integer value = (Integer) spinner.getValue();
		ArrayList<String> senzori = new ArrayList<String>();
		for(int i=0;i<value;i++)
		{
			
			senzori.add(choices.get(i).getSelectedItem());
		   
		}
		
		 DataTable data = new DataTable(Double.class, Integer.class, String.class);
		 double j=0.1;
		 for(int i=0; i<value; i++)
		 {
			
			data.add(j, i+1, senzori.get(i));
			j+=0.2;
			
		 }
       
       BarPlot  plot = new BarPlot(data);
         // Format plot
         plot.setInsets(new Insets2D.Double(40.0, 40.0, 40.0, 40.0));
         plot.setBarWidth(0.075);
         // Format bars
         BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(data);
         pointRenderer.setColor(
                 new LinearGradientPaint(0f,0f, 0f,1f,
                                 new float[] { 0.0f, 1.0f },
                                 new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
                 )
         );
         pointRenderer.setBorderStroke(new BasicStroke(3f));
         pointRenderer.setBorderColor(
                 new LinearGradientPaint(0f,0f, 0f,1f,
                                 new float[] { 0.0f, 1.0f },
                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
                 )
         );
         
         pointRenderer.setValueVisible(true);
         pointRenderer.setValueColumn(2);
         pointRenderer.setValueLocation(Location.CENTER);
         pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
         pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
         // Add plot to Swing component
         // add(new InteractivePanel(plot));
       
         
            /* contentPane = new JPanel();
			contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
			contentPane.setBounds(new Rectangle(50, 0, 50, 50));
			contentPane.setBackground(Color.white);
			contentPane.setBounds(10,10,5,5);

	         add(contentPane, BorderLayout.NORTH);*/
         
          interactivePanel = new InteractivePanel(plot);
          interactivePanel.setLayout(null);
          interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
	       plot.getTitle().setText("Bar plot");
	       interactivePanel.setVisible(true);
	      // contentPane.add(p, BorderLayout.CENTER);
	       
			//p.setVisible(true);
		   // content2.add(interactivePanel, BorderLayout.CENTER);
			//content2.add(new Label("bla")); //doda u novi tab graf
			//content2.add(new InteractivePanel(plot));
		    //content2.setLayout(new BoxLayout(content2, BoxLayout.X_AXIS));

		//f.getContentPane().getComponent(0).getComponentAt(0);
	//	tabbedPane.getTabComponentAt(1).add(interactivePanel, BorderLayout.SOUTH);
	       
	       
	       
	       
	      final JButton btnChange = new JButton("Change data");
	       btnChange.addMouseListener(new MouseAdapter() {
	       	@Override
	       	public void mouseClicked(MouseEvent arg0) {
	       		tabbedPane.setSelectedIndex(0);
	       	}
	       });
	     btnChange.setBounds(81, 462, 137, 23);
		 interactivePanel.add(btnChange);
		 
		 final JButton btnExport = new JButton("Export plot");
	       btnExport.addMouseListener(new MouseAdapter() {
	       	@Override
	       	public void mouseClicked(MouseEvent arg0) {
	      //ovdje ce ici kod za export
	       	}
	       });
	     btnExport.setBounds(281, 462, 137, 23);
		 interactivePanel.add(btnExport);
		 
		 final JButton btnExit = new JButton("Cancel");
		
	     btnExit.setBounds(481, 462, 137, 23);
		 interactivePanel.add(btnExit);
		 
		 tabbedPane.addTab("Line plot", interactivePanel);
		 tabbedPane.setSelectedIndex(1);
		
		 btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			tabbedPane.remove(1);
			tabbedPane.setSelectedIndex(1);
				}
			});
		
		  tabbedPane.addTab("Bar plot",  interactivePanel);
		  tabbedPane.setSelectedIndex(1);
		   	
	}
	
	
	
	public void OneLineGraphShow()
	{
		
		 //Podaci koji ce se prikazivati na grafu 
	       DataTable data = new DataTable(Double.class, Double.class);
	     
	       
	       double x = 1; 
	       double y = 17;
	       data.add(x, y);
	       x = 2; 
	       y = 16;
	       data.add(x, y);
	        
	       x = 3; 
	       y = 18;
	       data.add(x, y);
	        
	      x = 4; 
	       y = 20;
	       data.add(x, y);
	        
	        x = 5; 
	       y = 19;
	       data.add(x, y);
	        
	       x = 6; 
	        y = 22;
	       data.add(x, y);
	        
	       x = 7; 
	       y = 20;
	       
	       data.add(x, y);
	       
	       XYPlot plot=plot = new XYPlot(data);
	       //prikaz grafa na frameu
	     //  add(new InteractivePanel(plot));

	     plot.setVisible(data, true);
	     plot.setInsets(new Insets2D.Double(20.0, 40.0, 40.0, 40.0));
	     // plot.setBackground(Color.WHITE);

         plot.getTitle().setText("Temperature  for 7 days");
         LineRenderer lines = new DefaultLineRenderer2D();
         plot.setLineRenderer(data, lines);
         Color color = new Color(0.0f, 0.3f, 1.0f);
         plot.getPointRenderer(data).setColor(color);
         plot.getLineRenderer(data).setColor(color);
      // Draw a tick mark and a grid line every 10 units along x axis
         plot.getAxisRenderer(XYPlot.AXIS_X).setTickSpacing(1.0);
         // Draw a tick mark and a grid line every 20 units along y axis
         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
         
         
         //InteractivePanel interactivePanel1 = new InteractivePanel(plot);
         interactivePanel1 = new InteractivePanel(plot);
         interactivePanel1.setLayout(null);
		 interactivePanel1.setBounds(new Rectangle(0, 0, 0, 50));
		 final JButton btnChange = new JButton("Change data");
		
	       btnChange.addMouseListener(new MouseAdapter() {
	       	@Override
	       	public void mouseClicked(MouseEvent arg0) {
	       		tabbedPane.setSelectedIndex(0);
	       	}
	       });
	     btnChange.setBounds(81, 462, 137, 23);
		 interactivePanel1.add(btnChange);
		 
		 final JButton btnExport = new JButton("Export plot");
	       btnExport.addMouseListener(new MouseAdapter() {
	       	@Override
	       	public void mouseClicked(MouseEvent arg0) {
	      //ovdje ce ici kod za export
	       	}
	       });
	     btnExport.setBounds(281, 462, 137, 23);
		 interactivePanel1.add(btnExport);
		 
		 final JButton btnExit = new JButton("Cancel");
		
	     btnExit.setBounds(481, 462, 137, 23);
		 interactivePanel1.add(btnExit);
		 
		 tabbedPane.addTab("Line plot", interactivePanel1);
		tabbedPane.setSelectedIndex(1);
		
		 btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			tabbedPane.remove(1);
			tabbedPane.setSelectedIndex(1);
				}
			});
	
		
	}
	
	public void twoGraphsShow()
	{
		//KOD ZA THREE GRAPHS SHOW
		
		/*
		 +		 DataTable data = new DataTable(Double.class, Double.class);
		 +	     
		 +	       
		 +	       double x = 1; 
		 +	       double y = 17;
		 +	       data.add(x, y);
		 +	       x = 2; 
		 +	       y = 16;
		 +	       data.add(x, y);
		 +	        
		 +	       x = 3; 
		 +	       y = 18;
		 +	       data.add(x, y);
		 +	        
		 +	      x = 4; 
		 +	       y = 20;
		 +	       data.add(x, y);
		 +	        
		 +	        x = 5; 
		 +	       y = 19;
		 +	       data.add(x, y);
		 +	        
		 +	       x = 6; 
		 +	        y = 22;
		 +	       data.add(x, y);
		 +	        
		 +	       x = 7; 
		 +	       y = 20;
		 +	       
		 +	       data.add(x, y);
		 +	       
		 +		
		 +		
		 +		
		          
		 +		final DataSeries barSeries = new DataSeries(data, 0, 1);
		 +		final DataSeries lineSeries = new DataSeries(data, 0, 1);
		 +
		 +		BarPlot plot = new BarPlot(barSeries, lineSeries);
		 +
		 +		// Change the color of all bars
		 +		PointRenderer barRenderer = plot.getPointRenderer(barSeries);
		 +		barRenderer.setColor(Color.LIGHT_GRAY);
		 +
		 +		// Display the second data series as a line plot
		 +		LineRenderer lineRenderer = new DefaultLineRenderer2D();
		 +		lineRenderer.setColor(Color.RED);
		 +		plot.setLineRenderer(lineSeries, lineRenderer);
		 +		// The default point renderer (BarRenderer) needs to be deactivated (or changed)
		 +		plot.setPointRenderer(lineSeries, null);
		 +		
		 +		interactivePanel2 = new InteractivePanel(plot);
		  		tabbedPane.addTab("two",  interactivePanel2);
		 -		tabbedPane.setSelectedIndex(1);
		 +		tabbedPane.setSelectedIndex(1);*/
		
		
		
		 //Podaci koji ce se prikazivati na grafu 
	      DataTable data = new DataTable(Double.class, Double.class);
	     
	       
	       double x = 1; 
	       double y = 17;
	       data.add(x, y);
	       x = 2; 
	       y = 16;
	       data.add(x, y);
	        
	       x = 3; 
	       y = 18;
	       data.add(x, y);
	        
	      x = 4; 
	       y = 20;
	       data.add(x, y);
	        
	        x = 5; 
	       y = 19;
	       data.add(x, y);
	        
	       x = 6; 
	        y = 22;
	       data.add(x, y);
	        
	       x = 7; 
	       y = 20;
	       
	       data.add(x, y);
	       
	       XYPlot plot=plot = new XYPlot(data);
	       //prikaz grafa na frameu
	     //  add(new InteractivePanel(plot));

	     plot.setVisible(data, true);
	     plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	   // plot.setBackground(Color.WHITE);

      plot.getTitle().setText("Temperature  for 7 days");
      LineRenderer lines = new DefaultLineRenderer2D();
      plot.setLineRenderer(data, lines);
      Color color = new Color(0.0f, 0.3f, 1.0f);
      plot.getPointRenderer(data).setColor(color);
      plot.getLineRenderer(data).setColor(color);
   // Draw a tick mark and a grid line every 10 units along x axis
      plot.getAxisRenderer(XYPlot.AXIS_X).setTickSpacing(1.0);
      // Draw a tick mark and a grid line every 20 units along y axis
      plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
      
      
      XYPlot plot1 = new XYPlot(data);
      //prikaz grafa na frameu
    //  add(new InteractivePanel(plot));

    plot1.setVisible(data, true);
    
    
    // plot.setBackground(Color.WHITE);

 plot1.getTitle().setText("Temperature  for 7 days");
LineRenderer lines1 = new DefaultLineRenderer2D();
 plot1.setLineRenderer(data, lines);
 Color color1 = new Color(0.0f, 0.3f, 1.0f);
 plot1.getPointRenderer(data).setColor(color);
 plot1.getLineRenderer(data).setColor(color);
//Draw a tick mark and a grid line every 10 units along x axis
 plot1.getAxisRenderer(XYPlot.AXIS_X).setTickSpacing(1.0);
 // Draw a tick mark and a grid line every 20 units along y axis
 plot1.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

      
      InteractivePanel interactivePanel1 = new InteractivePanel(plot1);
      InteractivePanel interactivePanel2=new InteractivePanel(plot);
      interactivePanel1.setBounds(new Rectangle(0, 0, 400, 400));
      interactivePanel1.setVisible(true);
      interactivePanel1.setLayout(null);
      interactivePanel2.setBounds(new Rectangle(200, 0, 400, 400));
      interactivePanel2.setVisible(true);
      interactivePanel2.setLayout(null);
      
      
     plot1.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
     
      //interactivePanel.add(null, plot1);
     /* interactivePanel.setLayout(null);
      plot1.setBounds(0, 0, 10, 50); 
	   interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));*/
		 
      contentPane = new JPanel();
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		//contentPane.setBounds(new Rectangle(0, 0, 0, 50));
		contentPane.setBounds(new Rectangle(0, 0,2000, 2000));
		contentPane.setBackground(Color.white);
		//contentPane.setBounds(10,10,5,5);
		//contentPane.setBounds(0,0,2000,3000);
		contentPane.add(interactivePanel1);
		contentPane.add(interactivePanel2);
		contentPane.setLayout(null);
		 tabbedPane.addTab("Two graphs", contentPane);
		 
		 contentPane.setLayout(null);
		 tabbedPane.setSelectedIndex(1);
		 
		
		
		
	}
	
	public void TwoGraphsShow() 
	{
		if(choice.getSelectedItem()=="Bar" && choice_10.getSelectedItem()=="Bar")
		{
			
			List<Choice> choices=new ArrayList<Choice>();
			choices.add(choice_1);
			choices.add(choice_2);
			choices.add(choice_3);
			choices.add(choice_4);
			choices.add(choice_5);
			choices.add(choice_6);
			choices.add(choice_7);
			choices.add(choice_8);
			choices.add(choice_9);
			
			
			
			Integer value = (Integer) spinner.getValue();
			ArrayList<String> senzori = new ArrayList<String>();
			for(int i=0;i<value;i++)
			{
				
				senzori.add(choices.get(i).getSelectedItem());
			   
			}
			
			 DataTable data = new DataTable(Double.class, Integer.class, String.class);
			 double j=0.1;
			 for(int i=0; i<value; i++)
			 {
				
				data.add(j, i+1, senzori.get(i));
				j+=0.2;
				
			 }
	       
	       BarPlot  plot = new BarPlot(data);
	         // Format plot
	         plot.setInsets(new Insets2D.Double(40.0, 40.0, 40.0, 40.0));
	         plot.setBarWidth(0.075);
	         // Format bars
	         BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(data);
	         pointRenderer.setColor(
	                 new LinearGradientPaint(0f,0f, 0f,1f,
	                                 new float[] { 0.0f, 1.0f },
	                                 new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
	                 )
	         );
	         pointRenderer.setBorderStroke(new BasicStroke(3f));
	         pointRenderer.setBorderColor(
	                 new LinearGradientPaint(0f,0f, 0f,1f,
	                                 new float[] { 0.0f, 1.0f },
	                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
	                 )
	         );
	         
	         pointRenderer.setValueVisible(true);
	         pointRenderer.setValueColumn(2);
	         pointRenderer.setValueLocation(Location.CENTER);
	         pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
	         pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
		
	         
	        
	         //drugi
	        
	         BarPlot  plot1 = new BarPlot(data);
	         // Format plot
	         plot1.setInsets(new Insets2D.Double(40.0, 40.0, 40.0, 40.0));
	         plot1.setBarWidth(0.075);
	         // Format bars
	         BarRenderer pointRenderer1 = (BarRenderer) plot1.getPointRenderer(data);
	         pointRenderer1.setColor(
	                 new LinearGradientPaint(0f,0f, 0f,1f,
	                                 new float[] { 0.0f, 1.0f },
	                                 new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
	                 )
	         );
	         pointRenderer1.setBorderStroke(new BasicStroke(3f));
	         pointRenderer1.setBorderColor(
	                 new LinearGradientPaint(0f,0f, 0f,1f,
	                                 new float[] { 0.0f, 1.0f },
	                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
	                 )
	         );
	         
	         pointRenderer1.setValueVisible(true);
	         pointRenderer1.setValueColumn(2);
	         pointRenderer1.setValueLocation(Location.CENTER);
	         pointRenderer1.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
	         pointRenderer1.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	         
	         //paneli
	         
	         
	        InteractivePanel interactivePanel1 = new InteractivePanel(plot1);
	         InteractivePanel interactivePanel2=new InteractivePanel(plot);
	       interactivePanel1.setBounds(new Rectangle(0, 0, 0, 50));
	         interactivePanel1.setVisible(true);
	         interactivePanel1.setLayout(null);
	         interactivePanel2.setBounds(new Rectangle(0, 0, 0, 50));
	         interactivePanel2.setVisible(true);
	         interactivePanel2.setLayout(null);
	         
	         
	      //  plot1.setInsets(new Insets2D.Double(20.0, 40.0, 100.0, 500.0));
	        
	         //interactivePanel.add(null, plot1);
	       /*  interactivePanel.setLayout(null);
	         plot1.setBounds(0, 0, 10, 50); 
	   	   interactivePanel.setBounds(new Rectangle(0, 0, 0, 50))*/
	   		 
	         contentPane = new JPanel();
	   		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
	   		contentPane.setBounds(new Rectangle(0, 0, 0, 50));
	   		contentPane.setBackground(Color.white);
	   		//contentPane.setBounds(10,10,5,5);
	   		
	   		contentPane.add(interactivePanel1);
	   		contentPane.add(interactivePanel2);
	   		
	   		 tabbedPane.addTab("Two graphs", contentPane);
	   		 
	   		 tabbedPane.setSelectedIndex(1);
	}
	}
	
	public void fillChoices(int k){
		switch(k){
		case 1 : {
			for(int i=0; i<list_device.size();i++){
			if(choice_1.getSelectedItem() == list_device.get(i).getName()) continue;
			choice_2.add(list_device.get(i).getName());
			}
			choice_1.disable();
			break;
			
		}
		case 2 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_3.add(list_device.get(i).getName());
				}
				choice_2.disable();
				break;
		}
		case 3 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())||(choice_3.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_4.add(list_device.get(i).getName());
				}
				choice_3.disable();
				break;
		}
		case 4 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())||(choice_3.getSelectedItem() == list_device.get(i).getName())||
						(choice_4.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_5.add(list_device.get(i).getName());
				}
				choice_4.disable();
				break;
		}
		case 5 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())||(choice_3.getSelectedItem() == list_device.get(i).getName())||
						(choice_4.getSelectedItem() == list_device.get(i).getName())||(choice_5.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_6.add(list_device.get(i).getName());
				}
				choice_5.disable();
				break;
		}
		case 6 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())||(choice_3.getSelectedItem() == list_device.get(i).getName())||
						(choice_4.getSelectedItem() == list_device.get(i).getName())||(choice_5.getSelectedItem() == list_device.get(i).getName())||(choice_6.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_7.add(list_device.get(i).getName());
				}
				choice_6.disable();
				break;
		}
		case 7 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())||(choice_3.getSelectedItem() == list_device.get(i).getName())||
				   (choice_4.getSelectedItem() == list_device.get(i).getName())||(choice_5.getSelectedItem() == list_device.get(i).getName())||(choice_6.getSelectedItem() == list_device.get(i).getName())||
				   (choice_7.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_8.add(list_device.get(i).getName());
				}
				choice_7.disable();
				break;
		}
		case 8 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_1.getSelectedItem() == list_device.get(i).getName()) || (choice_2.getSelectedItem() == list_device.get(i).getName())||(choice_3.getSelectedItem() == list_device.get(i).getName())||
				   (choice_4.getSelectedItem() == list_device.get(i).getName())||(choice_5.getSelectedItem() == list_device.get(i).getName())||(choice_6.getSelectedItem() == list_device.get(i).getName())||
				   (choice_7.getSelectedItem() == list_device.get(i).getName())||(choice_8.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_9.add(list_device.get(i).getName());
				}
				choice_8.disable();
				break;
		}
		case 9 : {
			choice_9.disable();
			
		}	
	}
		
	}
	public void fillChoices_1(int k){
		switch(k){
		case 1 : {
			for(int i=0; i<list_device.size();i++){
			if(choice_11.getSelectedItem() == list_device.get(i).getName()) continue;
			choice_12.add(list_device.get(i).getName());
			}
			choice_11.disable();
			break;
			
		}
		case 2 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_13.add(list_device.get(i).getName());
				}
				choice_12.disable();
				break;
		}
		case 3 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())||(choice_13.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_14.add(list_device.get(i).getName());
				}
				choice_13.disable();
				break;
		}
		case 4 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())||(choice_13.getSelectedItem() == list_device.get(i).getName())||
						(choice_14.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_15.add(list_device.get(i).getName());
				}
				choice_14.disable();
				break;
		}
		case 5 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())||(choice_13.getSelectedItem() == list_device.get(i).getName())||
						(choice_14.getSelectedItem() == list_device.get(i).getName())||(choice_15.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_16.add(list_device.get(i).getName());
				}
				choice_15.disable();
				break;
		}
		case 6 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())||(choice_13.getSelectedItem() == list_device.get(i).getName())||
						(choice_14.getSelectedItem() == list_device.get(i).getName())||(choice_15.getSelectedItem() == list_device.get(i).getName())||(choice_16.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_17.add(list_device.get(i).getName());
				}
				choice_16.disable();
				break;
		}
		case 7 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())||(choice_13.getSelectedItem() == list_device.get(i).getName())||
				   (choice_14.getSelectedItem() == list_device.get(i).getName())||(choice_15.getSelectedItem() == list_device.get(i).getName())||(choice_16.getSelectedItem() == list_device.get(i).getName())||
				   (choice_17.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_18.add(list_device.get(i).getName());
				}
				choice_17.disable();
				break;
		}
		case 8 : {
			for(int i=0; i<list_device.size();i++){
				if((choice_11.getSelectedItem() == list_device.get(i).getName()) || (choice_12.getSelectedItem() == list_device.get(i).getName())||(choice_13.getSelectedItem() == list_device.get(i).getName())||
				   (choice_14.getSelectedItem() == list_device.get(i).getName())||(choice_15.getSelectedItem() == list_device.get(i).getName())||(choice_16.getSelectedItem() == list_device.get(i).getName())||
				   (choice_17.getSelectedItem() == list_device.get(i).getName())||(choice_18.getSelectedItem() == list_device.get(i).getName())) continue;
				choice_19.add(list_device.get(i).getName());
				}
				choice_18.disable();
				break;
		}
		case 9 : {
			choice_19.disable();
			
		}	
	}
		
	}
	@Override
	 public String getTitle() {
	         return "Bar plot";
	 }
	 @Override
	 public String getDescription() {
	         return "Bar plot with example data and color gradients";
	 }
	}
//}
      
      