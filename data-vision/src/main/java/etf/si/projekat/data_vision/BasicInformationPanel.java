package etf.si.projekat.data_vision;


import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import com.mysql.jdbc.Statement;

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataSource;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.graphics.DrawingContext;
import de.erichseifert.gral.io.data.DataWriter;
import de.erichseifert.gral.io.data.DataWriterFactory;
import de.erichseifert.gral.io.plots.DrawableWriter;
import de.erichseifert.gral.io.plots.DrawableWriterFactory;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.plots.axes.AxisRenderer;
import de.erichseifert.gral.plots.legends.SeriesLegend;
import de.erichseifert.gral.plots.legends.ValueLegend;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import de.erichseifert.gral.util.Orientation;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateEventLogs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicInformationPanel  extends ExamplePanel {
	
	
	// POkupiti iz baze ime device-a
    List<DeviceName> list_device=new HibernateDeviceName().giveAllDeviceName();
    final Choice choice;
    final JSpinner spinner;
    private JPanel contentPane;
    final JTabbedPane tabbedPane;
    //choices
    final Choice choice_1;
    final Choice choice_2;
    final Choice choice_3;
    final Choice choice_4;
    final Choice choice_5;
    final Choice choice_6;
    final Choice choice_7;
    final Choice choice_8;
    final Choice choice_9;
    private int size;
    private List<List<EventLogs>> list_logs;
   private List<List<Double>> list_values;
   private List<DataTable> datas;
   private List<DataSeries>series;
   private List<Choice> choices;
    final static DataTable data=new DataTable(Long.class, Double.class);
    XYPlot plot;
    
    UtilDateModel model1 = new UtilDateModel();
    JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
    final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    DataTable data1;
  
    
    InteractivePanel interactivePanel;
    
    
	/**
	 * Create the panel.
	 */
	public BasicInformationPanel(JTabbedPane tabbedPane_1) {
		setBackground(UIManager.getColor("Button.light"));
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
		
	   /* choice = new Choice();
		choice.setBounds(177, 50, 117, 25);
		choice.add("Line");
		choice.add("Bar");
		add(choice);*/
		
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
		
		
        JLabel lblGraphType = new JLabel("Graph type");
        lblGraphType.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGraphType.setBounds(55, 60, 68, 14);
        add(lblGraphType);
        datePicker.setLocation(152, 76);
        datePicker.setSize(165, 28);
       add(datePicker);
        
        
       
        datePicker1.setLocation(152, 106);
        datePicker1.setSize(165, 28);
      add(datePicker1);
      
     choice = new Choice();
      choice.setBounds(152, 51, 165, 23);
      choice.add("Line");
      choice.add("Bar");
      add(choice);
      
      Label label = new Label("Basic data");
      label.setBounds(10, 10, 65, 14);
      add(label);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(10, 30, 307, 15);
      add(separator);
      
      final JLabel lblSensorType = new JLabel("Sensor type");
      lblSensorType.setBounds(10, 201, 77, 14);
      lblSensorType.setVisible(false);
      add(lblSensorType);
      
      final JSeparator separator_1 = new JSeparator();
      separator_1.setBounds(221, 213, -219, 2);
      separator_1.setVisible(false);
      add(separator_1);
      
      final JButton btnGenerateGraph = new JButton("Generate graph");
      btnGenerateGraph.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
      btnGenerateGraph.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      	if(choice.getSelectedItem()=="Bar")	
      	{
      		//OneBarGraphShow();
      		GrafBar();
      	}
      	else
      	{
      		Graf();
      	}
      	}
      });
      btnGenerateGraph.setBounds(181, 462, 137, 23);
      btnGenerateGraph.setVisible(false);
      
      add(btnGenerateGraph);
      
      
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
      
      choice_1 = new Choice();
      choice_1.setBounds(152, 235, 165, 20);
      add(choice_1);
      
      choice_1.addMouseListener(new MouseAdapter() {
        	@Override
          	public void mouseClicked(MouseEvent arg0) {
				
				if((Integer) spinner.getValue()==1) btnGenerateGraph.setVisible(true);
				fillChoices(1);
				choice_2.enable();
			}
		});
      
      
      choice_2 = new Choice();
      choice_2.setBounds(152, 261, 165, 20);
      add(choice_2);
      choice_2.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==2) btnGenerateGraph.setVisible(true);
				fillChoices(2);
				choice_3.enable();

			}
		});
      
       choice_3 = new Choice();
      choice_3.setBounds(152, 285, 165, 20);
      add(choice_3);
      choice_3.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==3) btnGenerateGraph.setVisible(true);
				fillChoices(3);
				choice_4.enable();

			}
		});
      
      choice_4 = new Choice();
      choice_4.setBounds(152, 310, 165, 20);
      add(choice_4);
      choice_4.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==4) btnGenerateGraph.setVisible(true);
				fillChoices(4);
				choice_5.enable();

			}
		});
      
     choice_5 = new Choice();
      choice_5.setBounds(152, 335, 165, 20);
      add(choice_5);
      choice_5.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==5) btnGenerateGraph.setVisible(true);
				fillChoices(5);
				choice_6.enable();

			}
		});
      
      choice_6 = new Choice();
      choice_6.setBounds(152, 360, 165, 20);
      add(choice_6);
      choice_6.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==6) btnGenerateGraph.setVisible(true);
				fillChoices(6);
				choice_7.enable();

			}
		});
      
      choice_7 = new Choice();
      choice_7.setBounds(152, 385, 165, 20);
      add(choice_7);
      choice_7.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==7) btnGenerateGraph.setVisible(true);
				fillChoices(7);
				choice_8.enable();

			}
		});
       choice_8 = new Choice();
      choice_8.setBounds(152, 410, 165, 20);
      add(choice_8);
      choice_8.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==8) btnGenerateGraph.setVisible(true);
				fillChoices(8);
				choice_9.enable();

			}
		});
      choice_9 = new Choice();
      choice_9.setBounds(152, 436, 165, 20);
      add(choice_9);
      choice_9.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
				if((Integer) spinner.getValue()==9) btnGenerateGraph.setVisible(true);
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
      		
      		boolean islect=false;
      		boolean date1Beforedate2=false;
      		boolean inFuture1=false;
      		boolean inFuture2=false;

      		if(datePicker.getModel().isSelected() && datePicker1.getModel().isSelected()){
				islect=true;
			}else{
      			JOptionPane.showMessageDialog(null, "Time is not selected");
      		}
      		if(islect){
      		Date dateString = (Date) datePicker.getModel().getValue();
	  		String date_from = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
	  		Date dateString1 = (Date) datePicker1.getModel().getValue();
	  		String date_to = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date_start;
			Date date_end;
			Date date_now;
	        String now=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	        
				try {
					date_start = sdf.parse(date_from);
					date_end = sdf.parse(date_to);
				    date_now = sdf.parse(now);
				    

      	    if( date_start.compareTo(date_end) < 0) {
      	    	date1Beforedate2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "'Time interval from' is before 'Time interval to'");
      	    	}
      	    if((date_start.compareTo(date_now) < 0)){
    	    	inFuture1=true;
    	    }else{
    	    	JOptionPane.showMessageDialog(null, "'Time interval from' is in the future");
    	    }
      	    if((date_end.compareTo(date_now) < 0)){
      	    	inFuture2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "'Time interval to' is  in the future");

      	    }
			} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
      		}
      		
      		if(date1Beforedate2 && inFuture1 && inFuture2){
      		
      		
      			
      	    choice_1.enable();
      	  choice_2.disable();
  		choice_3.disable();
  		choice_4.disable();
  		choice_5.disable();
  		choice_6.disable();
  		choice_7.disable();
  		choice_8.disable();
  		choice_9.disable();
      		
      		choice_1.removeAll();
      		choice_2.removeAll();
      		choice_3.removeAll();
      		choice_4.removeAll();
      		choice_5.removeAll();
      		choice_6.removeAll();
      		choice_7.removeAll();
      		choice_8.removeAll();
      		choice_9.removeAll();
      		
      		
     
      	   
      		btnGenerateGraph.setVisible(false);
      		
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
		      
		     
		     String s = datePicker1.getComponentListeners().toString();
		     System.out.println(s);
	
      		}
      		else{
      			choice_1.setVisible(false);
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
				
				
				lblSensorType.setVisible(false);
				separator_2.setVisible(false);
				
				label_1.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				label_4.setVisible(false);
				label_5.setVisible(false);
      			
      		}
		  		
		      	
			
      	}
      });
		
      
      
      
      btnProcess.setBounds(181, 163, 136, 23);
      add(btnProcess);
     
    
      
    
      
  
	}
	
	/*public void OneBarGraphShow(){
		
		
	}
	*/
	
/*	public void OneLineGraphShow()
	{
   
	}

*/

	//za export grafa, ali snima graf kao csv file
	private static void writeData() throws IOException {
		
	
	    FileOutputStream dataStream = new FileOutputStream("filename.csv");
	    DataWriterFactory factory = DataWriterFactory.getInstance();
	    DataWriter writer = factory.get("text/tab-separated-values");
	    try {
	        writer.write(data, dataStream);
	    } finally {
	        dataStream.close();
	    }
	}
	
	
	private byte[] getJpg() throws IOException {
        BufferedImage bImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) bImage.getGraphics();
        DrawingContext context = new DrawingContext(g2d);
        
        plot.draw(context);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DrawableWriter wr = DrawableWriterFactory.getInstance().get("image/jpeg");
        wr.write(plot, baos, 800, 600);
        baos.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        return bytes;
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
	
	
	public void GrafBar()
	{
		List<DataTable> vrijednosti= new ArrayList<DataTable>();
		Integer value = (Integer) spinner.getValue();
		boolean have=false;
		for(int k=0; k<value; k++)
		{
			 data1 = new DataTable(Long.class, Double.class, String.class);				 
				//Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker.getModel().getValue();
			  		String date_from = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker1.getModel().getValue();
			  		String date_to = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date date_start;
					Date date_end;
			
					try {
						date_start = sdf.parse(date_from);
						date_end = sdf.parse(date_to);
						 

						try {
						
							
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
							
							list_logs=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  list_logs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end));//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end)); //lista eventlogova ciji su datumi između unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						size=list_logs.size();
						list_values=new ArrayList<List<Double>>();
						for(int i=0; i<list_logs.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<list_logs.get(i).size();j++){
								
							values.add(list_logs.get(i).get(j).getValue());//add(list_logs.get(i).get(j).getValue());           //Ovo čemo stavljati na graf valjda :D
							
							}
							list_values.add(values);
							}
						for(int i=0; i<list_logs.size();i++){
							if(list_logs.get(i).size()!=0) have=true;
						}
						}catch(Exception e){
							
							System.out.println("Ne poklapaju se vrijednosti");
						}
					} 
					  catch (Exception e1) {
						// TODO Auto-generated catch block
						 
						e1.printStackTrace();
					}
					
					datas=new ArrayList<DataTable>();
					 series=new ArrayList<DataSeries>();
					  DataTable d=new DataTable(Long.class, Double.class, String.class);
					  
					  for(int i=0;i<list_logs.size();i++)
					  {
						  
						  for(int j=0;j<list_logs.get(i).size();j++){
							
							d.add(list_logs.get(i).get(j).getTimestamp().getTime(), list_values.get(i).get(j), list_logs.get(i).get(j).getDevice_name());
			  }
						
						  datas.add(d);
						  series.add(new DataSeries(d));
							
		}
		}
		if(have){
		
		switch(value)
		{
		case 1:
		{
			final BarPlot plot= new BarPlot(datas.get(0));
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(datas.get(0));
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
	         
	         
	        		 
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
	         
	         
	         pointRenderer.setValueVisible(true);
	         pointRenderer.setValueColumn(2);
	         pointRenderer.setValueLocation(Location.CENTER);
	         pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
	         pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	         
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
			
		}
		
		case 2: 
		{
			final BarPlot plot= new BarPlot(datas.get(0), datas.get(1) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		  BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(datas.get(0));
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
	         
	         
	        /* BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(datas.get(1));
			    pointRenderer1.setColor(
			           new LinearGradientPaint(0f,0f, 0f,1f,
			           new float[] { 0.0f, 1.0f },
			           new Color[] { COLOR2, GraphicsUtils.deriveBrighter(COLOR2) }
			                 )
			         );
			       
			    pointRenderer1.setBorderStroke(new BasicStroke(3f));
		         pointRenderer1.setBorderColor(
		                 new LinearGradientPaint(0f,0f, 0f,1f,
		                                 new float[] { 0.0f, 1.0f },
		                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR2), COLOR2 }
		                 )
		         );
		         pointRenderer1.setValueVisible(true);
		         pointRenderer1.setValueColumn(2);
		         pointRenderer1.setValueLocation(Location.CENTER);
		         pointRenderer1.setValueColor(GraphicsUtils.deriveDarker(COLOR2));
		         pointRenderer1.setValueFont(Font.decode(null).deriveFont(Font.BOLD)); 
	        	
		  */
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
			
		}
		
		case 3:
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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

	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(3);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	         
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Line plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
		}
		
		case 4:
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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
	         
	         
	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(3);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         
			         BarRenderer pointRenderer3 = (BarRenderer) plot.getPointRenderer(series.get(3));
					    pointRenderer3.setColor(
					           new LinearGradientPaint(0f,0f, 0f,1f,
					           new float[] { 0.0f, 1.0f },
					           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
					                 )
					         );
					       
					    pointRenderer3.setBorderStroke(new BasicStroke(3f));
				         pointRenderer3.setBorderColor(
				                 new LinearGradientPaint(0f,0f, 0f,1f,
				                                 new float[] { 0.0f, 1.0f },
				                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
				                 )
				         );
				         pointRenderer3.setValueVisible(true);
				         pointRenderer3.setValueColumn(2);
				         pointRenderer3.setValueLocation(Location.CENTER);
				         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
				         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	        		 
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
		}
		
		case 5:
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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
	         
	         
	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(2);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         
			         BarRenderer pointRenderer3 = (BarRenderer) plot.getPointRenderer(series.get(3));
					    pointRenderer3.setColor(
					           new LinearGradientPaint(0f,0f, 0f,1f,
					           new float[] { 0.0f, 1.0f },
					           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
					                 )
					         );
					       
					    pointRenderer3.setBorderStroke(new BasicStroke(3f));
				         pointRenderer3.setBorderColor(
				                 new LinearGradientPaint(0f,0f, 0f,1f,
				                                 new float[] { 0.0f, 1.0f },
				                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
				                 )
				         );
				         pointRenderer3.setValueVisible(true);
				         pointRenderer3.setValueColumn(2);
				         pointRenderer3.setValueLocation(Location.CENTER);
				         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
				         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
				         
				         
				         BarRenderer pointRenderer4 = (BarRenderer) plot.getPointRenderer(series.get(4));
						    pointRenderer4.setColor(
						           new LinearGradientPaint(0f,0f, 0f,1f,
						           new float[] { 0.0f, 1.0f },
						           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
						                 )
						         );
						       
						    pointRenderer4.setBorderStroke(new BasicStroke(3f));
					         pointRenderer4.setBorderColor(
					                 new LinearGradientPaint(0f,0f, 0f,1f,
					                                 new float[] { 0.0f, 1.0f },
					                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
					                 )
					         );
					         pointRenderer4.setValueVisible(true);
					         pointRenderer4.setValueColumn(2);
					         pointRenderer4.setValueLocation(Location.CENTER);
					         pointRenderer4.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					         pointRenderer4.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	        		 
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
		}
		
		case 6:
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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
	         
	         
	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(2);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         
			         BarRenderer pointRenderer3 = (BarRenderer) plot.getPointRenderer(series.get(3));
					    pointRenderer3.setColor(
					           new LinearGradientPaint(0f,0f, 0f,1f,
					           new float[] { 0.0f, 1.0f },
					           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
					                 )
					         );
					       
					    pointRenderer3.setBorderStroke(new BasicStroke(3f));
				         pointRenderer3.setBorderColor(
				                 new LinearGradientPaint(0f,0f, 0f,1f,
				                                 new float[] { 0.0f, 1.0f },
				                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
				                 )
				         );
				         pointRenderer3.setValueVisible(true);
				         pointRenderer3.setValueColumn(2);
				         pointRenderer3.setValueLocation(Location.CENTER);
				         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
				         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
				         
				         
				         BarRenderer pointRenderer4 = (BarRenderer) plot.getPointRenderer(series.get(4));
						    pointRenderer4.setColor(
						           new LinearGradientPaint(0f,0f, 0f,1f,
						           new float[] { 0.0f, 1.0f },
						           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
						                 )
						         );
						       
						    pointRenderer4.setBorderStroke(new BasicStroke(3f));
					         pointRenderer4.setBorderColor(
					                 new LinearGradientPaint(0f,0f, 0f,1f,
					                                 new float[] { 0.0f, 1.0f },
					                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
					                 )
					         );
					         pointRenderer4.setValueVisible(true);
					         pointRenderer4.setValueColumn(2);
					         pointRenderer4.setValueLocation(Location.CENTER);
					         pointRenderer4.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					         pointRenderer4.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
					         
					         BarRenderer pointRenderer5 = (BarRenderer) plot.getPointRenderer(series.get(5));
							    pointRenderer5.setColor(
							           new LinearGradientPaint(0f,0f, 0f,1f,
							           new float[] { 0.0f, 1.0f },
							           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
							                 )
							         );
							       
							    pointRenderer5.setBorderStroke(new BasicStroke(3f));
						         pointRenderer5.setBorderColor(
						                 new LinearGradientPaint(0f,0f, 0f,1f,
						                                 new float[] { 0.0f, 1.0f },
						                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
						                 )
						         );
						         pointRenderer5.setValueVisible(true);
						         pointRenderer5.setValueColumn(2);
						         pointRenderer5.setValueLocation(Location.CENTER);
						         pointRenderer5.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
						         pointRenderer5.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	        		 
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
		}
		
		case 7:
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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
	         
	         
	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(2);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         
			         BarRenderer pointRenderer3 = (BarRenderer) plot.getPointRenderer(series.get(3));
					    pointRenderer3.setColor(
					           new LinearGradientPaint(0f,0f, 0f,1f,
					           new float[] { 0.0f, 1.0f },
					           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
					                 )
					         );
					       
					    pointRenderer3.setBorderStroke(new BasicStroke(3f));
				         pointRenderer3.setBorderColor(
				                 new LinearGradientPaint(0f,0f, 0f,1f,
				                                 new float[] { 0.0f, 1.0f },
				                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
				                 )
				         );
				         pointRenderer3.setValueVisible(true);
				         pointRenderer3.setValueColumn(2);
				         pointRenderer3.setValueLocation(Location.CENTER);
				         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
				         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
				         
				         
				         BarRenderer pointRenderer4 = (BarRenderer) plot.getPointRenderer(series.get(4));
						    pointRenderer4.setColor(
						           new LinearGradientPaint(0f,0f, 0f,1f,
						           new float[] { 0.0f, 1.0f },
						           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
						                 )
						         );
						       
						    pointRenderer4.setBorderStroke(new BasicStroke(3f));
					         pointRenderer4.setBorderColor(
					                 new LinearGradientPaint(0f,0f, 0f,1f,
					                                 new float[] { 0.0f, 1.0f },
					                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
					                 )
					         );
					         pointRenderer4.setValueVisible(true);
					         pointRenderer4.setValueColumn(2);
					         pointRenderer4.setValueLocation(Location.CENTER);
					         pointRenderer4.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					         pointRenderer4.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
					         
					         BarRenderer pointRenderer5 = (BarRenderer) plot.getPointRenderer(series.get(5));
							    pointRenderer5.setColor(
							           new LinearGradientPaint(0f,0f, 0f,1f,
							           new float[] { 0.0f, 1.0f },
							           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
							                 )
							         );
							       
							    pointRenderer5.setBorderStroke(new BasicStroke(3f));
						         pointRenderer5.setBorderColor(
						                 new LinearGradientPaint(0f,0f, 0f,1f,
						                                 new float[] { 0.0f, 1.0f },
						                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
						                 )
						         );
						         pointRenderer5.setValueVisible(true);
						         pointRenderer5.setValueColumn(2);
						         pointRenderer5.setValueLocation(Location.CENTER);
						         pointRenderer5.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
						         pointRenderer5.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	        		
						         BarRenderer pointRenderer6 = (BarRenderer) plot.getPointRenderer(series.get(6));
								    pointRenderer6.setColor(
								           new LinearGradientPaint(0f,0f, 0f,1f,
								           new float[] { 0.0f, 1.0f },
								           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
								                 )
								         );
								       
								    pointRenderer6.setBorderStroke(new BasicStroke(3f));
							         pointRenderer6.setBorderColor(
							                 new LinearGradientPaint(0f,0f, 0f,1f,
							                                 new float[] { 0.0f, 1.0f },
							                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
							                 )
							         );
							         pointRenderer6.setValueVisible(true);
							         pointRenderer6.setValueColumn(2);
							         pointRenderer6.setValueLocation(Location.CENTER);
							         pointRenderer6.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
							         pointRenderer6.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
		        		 			         
						         
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
			
		}
		
		case 8: 
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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
	         
	         
	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(2);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         
			         BarRenderer pointRenderer3 = (BarRenderer) plot.getPointRenderer(series.get(3));
					    pointRenderer3.setColor(
					           new LinearGradientPaint(0f,0f, 0f,1f,
					           new float[] { 0.0f, 1.0f },
					           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
					                 )
					         );
					       
					    pointRenderer3.setBorderStroke(new BasicStroke(3f));
				         pointRenderer3.setBorderColor(
				                 new LinearGradientPaint(0f,0f, 0f,1f,
				                                 new float[] { 0.0f, 1.0f },
				                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
				                 )
				         );
				         pointRenderer3.setValueVisible(true);
				         pointRenderer3.setValueColumn(2);
				         pointRenderer3.setValueLocation(Location.CENTER);
				         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
				         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
				         
				         
				         BarRenderer pointRenderer4 = (BarRenderer) plot.getPointRenderer(series.get(4));
						    pointRenderer4.setColor(
						           new LinearGradientPaint(0f,0f, 0f,1f,
						           new float[] { 0.0f, 1.0f },
						           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
						                 )
						         );
						       
						    pointRenderer4.setBorderStroke(new BasicStroke(3f));
					         pointRenderer4.setBorderColor(
					                 new LinearGradientPaint(0f,0f, 0f,1f,
					                                 new float[] { 0.0f, 1.0f },
					                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
					                 )
					         );
					         pointRenderer4.setValueVisible(true);
					         pointRenderer4.setValueColumn(2);
					         pointRenderer4.setValueLocation(Location.CENTER);
					         pointRenderer4.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					         pointRenderer4.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
					         
					         BarRenderer pointRenderer5 = (BarRenderer) plot.getPointRenderer(series.get(5));
							    pointRenderer5.setColor(
							           new LinearGradientPaint(0f,0f, 0f,1f,
							           new float[] { 0.0f, 1.0f },
							           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
							                 )
							         );
							       
							    pointRenderer5.setBorderStroke(new BasicStroke(3f));
						         pointRenderer5.setBorderColor(
						                 new LinearGradientPaint(0f,0f, 0f,1f,
						                                 new float[] { 0.0f, 1.0f },
						                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
						                 )
						         );
						         pointRenderer5.setValueVisible(true);
						         pointRenderer5.setValueColumn(2);
						         pointRenderer5.setValueLocation(Location.CENTER);
						         pointRenderer5.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
						         pointRenderer5.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	        		
						         BarRenderer pointRenderer6 = (BarRenderer) plot.getPointRenderer(series.get(6));
								    pointRenderer6.setColor(
								           new LinearGradientPaint(0f,0f, 0f,1f,
								           new float[] { 0.0f, 1.0f },
								           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
								                 )
								         );
								       
								    pointRenderer6.setBorderStroke(new BasicStroke(3f));
							         pointRenderer6.setBorderColor(
							                 new LinearGradientPaint(0f,0f, 0f,1f,
							                                 new float[] { 0.0f, 1.0f },
							                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
							                 )
							         );
							         pointRenderer6.setValueVisible(true);
							         pointRenderer6.setValueColumn(2);
							         pointRenderer6.setValueLocation(Location.CENTER);
							         pointRenderer6.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
							         pointRenderer6.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
							         
							         BarRenderer pointRenderer7 = (BarRenderer) plot.getPointRenderer(series.get(7));
									    pointRenderer7.setColor(
									           new LinearGradientPaint(0f,0f, 0f,1f,
									           new float[] { 0.0f, 1.0f },
									           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
									                 )
									         );
									       
									    pointRenderer7.setBorderStroke(new BasicStroke(3f));
								         pointRenderer7.setBorderColor(
								                 new LinearGradientPaint(0f,0f, 0f,1f,
								                                 new float[] { 0.0f, 1.0f },
								                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
								                 )
								         );
								         pointRenderer7.setValueVisible(true);
								         pointRenderer7.setValueColumn(2);
								         pointRenderer7.setValueLocation(Location.CENTER);
								         pointRenderer7.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
								         pointRenderer7.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
		        		 			         
						         
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
		}
		
		case 9:
		{
			final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7), series.get(8) );
			plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
		    plot.setBarWidth(0.075);
		         // Format bars
		    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(series.get(0));
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
	         
	         
	         BarRenderer pointRenderer1 = (BarRenderer) plot.getPointRenderer(series.get(1));
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
		         
		         
		         BarRenderer pointRenderer2 = (BarRenderer) plot.getPointRenderer(series.get(2));
				    pointRenderer2.setColor(
				           new LinearGradientPaint(0f,0f, 0f,1f,
				           new float[] { 0.0f, 1.0f },
				           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
				                 )
				         );
				       
				    pointRenderer2.setBorderStroke(new BasicStroke(3f));
			         pointRenderer2.setBorderColor(
			                 new LinearGradientPaint(0f,0f, 0f,1f,
			                                 new float[] { 0.0f, 1.0f },
			                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
			                 )
			         );
			         pointRenderer2.setValueVisible(true);
			         pointRenderer2.setValueColumn(2);
			         pointRenderer2.setValueLocation(Location.CENTER);
			         pointRenderer2.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
			         pointRenderer2.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         
			         BarRenderer pointRenderer3 = (BarRenderer) plot.getPointRenderer(series.get(3));
					    pointRenderer3.setColor(
					           new LinearGradientPaint(0f,0f, 0f,1f,
					           new float[] { 0.0f, 1.0f },
					           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
					                 )
					         );
					       
					    pointRenderer3.setBorderStroke(new BasicStroke(3f));
				         pointRenderer3.setBorderColor(
				                 new LinearGradientPaint(0f,0f, 0f,1f,
				                                 new float[] { 0.0f, 1.0f },
				                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
				                 )
				         );
				         pointRenderer3.setValueVisible(true);
				         pointRenderer3.setValueColumn(2);
				         pointRenderer3.setValueLocation(Location.CENTER);
				         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
				         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
				         
				         
				         BarRenderer pointRenderer4 = (BarRenderer) plot.getPointRenderer(series.get(4));
						    pointRenderer4.setColor(
						           new LinearGradientPaint(0f,0f, 0f,1f,
						           new float[] { 0.0f, 1.0f },
						           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
						                 )
						         );
						       
						    pointRenderer4.setBorderStroke(new BasicStroke(3f));
					         pointRenderer4.setBorderColor(
					                 new LinearGradientPaint(0f,0f, 0f,1f,
					                                 new float[] { 0.0f, 1.0f },
					                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
					                 )
					         );
					         pointRenderer4.setValueVisible(true);
					         pointRenderer4.setValueColumn(2);
					         pointRenderer4.setValueLocation(Location.CENTER);
					         pointRenderer4.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					         pointRenderer4.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
					         
					         BarRenderer pointRenderer5 = (BarRenderer) plot.getPointRenderer(series.get(5));
							    pointRenderer5.setColor(
							           new LinearGradientPaint(0f,0f, 0f,1f,
							           new float[] { 0.0f, 1.0f },
							           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
							                 )
							         );
							       
							    pointRenderer5.setBorderStroke(new BasicStroke(3f));
						         pointRenderer5.setBorderColor(
						                 new LinearGradientPaint(0f,0f, 0f,1f,
						                                 new float[] { 0.0f, 1.0f },
						                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
						                 )
						         );
						         pointRenderer5.setValueVisible(true);
						         pointRenderer5.setValueColumn(2);
						         pointRenderer5.setValueLocation(Location.CENTER);
						         pointRenderer5.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
						         pointRenderer5.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	        		
						         BarRenderer pointRenderer6 = (BarRenderer) plot.getPointRenderer(series.get(6));
								    pointRenderer6.setColor(
								           new LinearGradientPaint(0f,0f, 0f,1f,
								           new float[] { 0.0f, 1.0f },
								           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
								                 )
								         );
								       
								    pointRenderer6.setBorderStroke(new BasicStroke(3f));
							         pointRenderer6.setBorderColor(
							                 new LinearGradientPaint(0f,0f, 0f,1f,
							                                 new float[] { 0.0f, 1.0f },
							                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
							                 )
							         );
							         pointRenderer6.setValueVisible(true);
							         pointRenderer6.setValueColumn(2);
							         pointRenderer6.setValueLocation(Location.CENTER);
							         pointRenderer6.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
							         pointRenderer6.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
							         
							         BarRenderer pointRenderer7 = (BarRenderer) plot.getPointRenderer(series.get(7));
									    pointRenderer7.setColor(
									           new LinearGradientPaint(0f,0f, 0f,1f,
									           new float[] { 0.0f, 1.0f },
									           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
									                 )
									         );
									       
									    pointRenderer7.setBorderStroke(new BasicStroke(3f));
								         pointRenderer7.setBorderColor(
								                 new LinearGradientPaint(0f,0f, 0f,1f,
								                                 new float[] { 0.0f, 1.0f },
								                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
								                 )
								         );
								         pointRenderer7.setValueVisible(true);
								         pointRenderer7.setValueColumn(2);
								         pointRenderer7.setValueLocation(Location.CENTER);
								         pointRenderer7.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
								         pointRenderer7.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
		        		 			   
								         BarRenderer pointRenderer8 = (BarRenderer) plot.getPointRenderer(series.get(8));
										    pointRenderer8.setColor(
										           new LinearGradientPaint(0f,0f, 0f,1f,
										           new float[] { 0.0f, 1.0f },
										           new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
										                 )
										         );
										       
										    pointRenderer8.setBorderStroke(new BasicStroke(3f));
									         pointRenderer8.setBorderColor(
									                 new LinearGradientPaint(0f,0f, 0f,1f,
									                                 new float[] { 0.0f, 1.0f },
									                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
									                 )
									         );
									         pointRenderer8.setValueVisible(true);
									         pointRenderer8.setValueColumn(2);
									         pointRenderer8.setValueLocation(Location.CENTER);
									         pointRenderer8.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
									         pointRenderer8.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
						         
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
        
	         interactivePanel = new InteractivePanel(plot);
		     
		     interactivePanel.setLayout(null);
		     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
		      plot.getTitle().setText("Bar plot");
		      interactivePanel.setVisible(true);
		      
		      tabbedPane.addTab("Bar plot", interactivePanel);
		  		tabbedPane.setSelectedIndex(1);
		     
		     break;
		}
		}
		
		 final JButton btnChange = new JButton("Change data");
			
	       btnChange.addMouseListener(new MouseAdapter() {
	       	@Override
	       	public void mouseClicked(MouseEvent arg0) {
	       		tabbedPane.setSelectedIndex(0);
	       	}
	       });
	     btnChange.setBounds(650, 492, 137, 23);
		 interactivePanel.add(btnChange);
		 
	
		 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
		 lblExport.setBounds(40, 499, 137, 23);
		 lblExport.setSize(400, 15);
		 lblExport.setForeground(Color.red);
		 interactivePanel.add(lblExport);
		 final JButton btnExit = new JButton("Cancel");
		
	     btnExit.setBounds(800, 492, 137, 23);
		 interactivePanel.add(btnExit);
		 
		 
		
		 btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			tabbedPane.remove(1);
			//tabbedPane.resetKeyboardActions();
			//tabbedPane.remove(0);
			//BasicInformationPanel basicInfo = new BasicInformationPanel(tabbedPane);
			//tabbedPane.add("Basic data",basicInfo);
			//tabbedPane.add("Basic data",basicInfo);

			//basicInfo.setLayout(null);
		
			tabbedPane.setSelectedIndex(1);
				}
			});
	}else{
		 JOptionPane.showMessageDialog(null, "Graph is empty");
	 }
	
		
	}
	
	
	public void Graf(){
		
//		List<DataTable> vrijednosti= new ArrayList<DataTable>();
		Integer value = (Integer) spinner.getValue();
		boolean have=false;
		
//		for(int k=0; k<value; k++)
//		{
				//if(value==1){
//				 data1 = new DataTable(Long.class, Double.class, String.class);				 
				//Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker.getModel().getValue();
			  		String date_from = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker1.getModel().getValue();
			  		String date_to = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date date_start;
					Date date_end;
					
					  try {
						date_start = sdf.parse(date_from);
						date_end = sdf.parse(date_to);
						 

						try {
						
							
							choices=new ArrayList<Choice>();
							choices.add(choice_1);
							choices.add(choice_2);
							choices.add(choice_3);
							choices.add(choice_4);
							choices.add(choice_5);
							choices.add(choice_6);
							choices.add(choice_7);
							choices.add(choice_8);
							choices.add(choice_9);	
							
							list_logs=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  list_logs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end));
					  //.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end));
					  //lista eventlogova ciji su datumi između unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						size=list_logs.size();
						list_values=new ArrayList<List<Double>>();
						for(int i=0; i<list_logs.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<list_logs.get(i).size();j++){
								
							values.add(list_logs.get(i).get(j).getValue());//add(list_logs.get(i).get(j).getValue());           //Ovo čemo stavljati na graf valjda :D
							
							}
							list_values.add(values);
							}
						for(int i=0; i<list_logs.size();i++){
							if(list_logs.get(i).size()!=0) have=true;
						}
						}catch(Exception e){
							 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							System.out.println("Ne poklapaju se vrijednosti");
						}
					} 
					  catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
					datas=new ArrayList<DataTable>();
					 series=new ArrayList<DataSeries>();
					  
					  
					  for(int i=0;i<list_logs.size();i++)
					  {
						  DataTable d=new DataTable(Long.class, Double.class, String.class);
						  
						  for(int j=0;j<list_logs.get(i).size();j++)
						  {
							  d.add(list_logs.get(i).get(j).getTimestamp().getTime(), list_values.get(i).get(j), list_logs.get(i).get(j).getDevice_name());
						  }
						
						  datas.add(d);
						  
					  }
					  
					  for(int i=0;i<datas.size();i++)
					  {
						  series.add(new DataSeries(datas.get(i)));
					  }
			
//					  }
		 if(have)
		 {			 
	      switch(value)
	      {
	      case 1:
	    	  {
	    		  
	    		  XYPlot plot = new XYPlot(series.get(0));
	    		  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    		  plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
	    		  
	    		  AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	    		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    		  rendererX.setTickLabelFormat(dateFormat);
	    		  		 
	    		  LineRenderer lines = new DefaultLineRenderer2D();
	    		  lines.setColor(Color.BLUE);
	    		  plot.setLineRenderer(series.get(0), lines);
	    		  plot.setPointRenderer(series.get(0), null);
	   
	              plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
	              
	              interactivePanel = new InteractivePanel(plot);
	              interactivePanel.setLayout(null);
	              interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
	              
	              String device = choices.get(0).getSelectedItem();
	              
	          //    plot.setLegendVisible(true);
	              	              
	        //      plot.getLegend().add(datas.get(0));
	            		  
	              plot.getTitle().setText("Line plot: "+device+"(green)");
	              interactivePanel.setVisible(true);
	              
	              tabbedPane.addTab("Line plot", interactivePanel);
	              tabbedPane.setSelectedIndex(1);
	              
	              break;
	    	  }
	    	  
	      
	      case 2:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	    		
		      plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		      AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		      rendererX.setTickLabelFormat(dateFormat);
			  
		      LineRenderer lines = new DefaultLineRenderer2D();
    		  lines.setColor(Color.green);
    		  plot.setLineRenderer(series.get(0), lines);
    		  plot.getPointRenderer(series.get(0)).setColor(Color.green);
    		  
		      LineRenderer lines1 = new DefaultLineRenderer2D(); 
			  lines1.setColor(Color.blue);
			  plot.setLineRenderer(series.get(1), lines1);
			  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
    		     
			  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
			  interactivePanel = new InteractivePanel(plot);
			  interactivePanel.setLayout(null);
			  interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
			  
			  String device1 = choices.get(0).getSelectedItem();
			  String device2 = choices.get(1).getSelectedItem();
			  
			  plot.getTitle().setText("Line plot: "+device1+"(green), and "+device2+"(blue)");
			  interactivePanel.setVisible(true);
			      
			  tabbedPane.addTab("Line plot", interactivePanel);
			  tabbedPane.setSelectedIndex(1);
			     
			  break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));

	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
	    		  lines.setColor(Color.green);
	    		  plot.setLineRenderer(series.get(0), lines);
	    		  plot.getPointRenderer(series.get(0)).setColor(Color.green);
	    		  
			      LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series.get(1), lines1);
				  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
			     
			     LineRenderer lines2 = new DefaultLineRenderer2D(); 
			     lines2.setColor(Color.red);
				  plot.setLineRenderer(series.get(2), lines2);
				  plot.getPointRenderer(series.get(2)).setColor(Color.red);
			     
			     plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
			  interactivePanel = new InteractivePanel(plot);
			     
			     interactivePanel.setLayout(null);
			     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
			     String device1 = choices.get(0).getSelectedItem();
			     String device2 = choices.get(1).getSelectedItem();
			     String device3 = choices.get(2).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), and "+device3+"(red)");
			     

			      interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	  
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
	    		  lines.setColor(Color.green);
	    		  plot.setLineRenderer(series.get(0), lines);
	    		  plot.getPointRenderer(series.get(0)).setColor(Color.green);
	    		  
			      LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series.get(1), lines1);
				  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
			     
			     LineRenderer lines2 = new DefaultLineRenderer2D(); 
			     lines2.setColor(Color.red);
				  plot.setLineRenderer(series.get(2), lines2);
				  plot.getPointRenderer(series.get(2)).setColor(Color.red);
			     
			     LineRenderer lines3 = new DefaultLineRenderer2D(); 
			     lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series.get(3), lines3);
				  plot.getPointRenderer(series.get(3)).setColor(Color.yellow);
			     
			     plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
			  interactivePanel = new InteractivePanel(plot);
			     
			     interactivePanel.setLayout(null);
			     interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
			     String device1 = choices.get(0).getSelectedItem();
			     String device2 = choices.get(1).getSelectedItem();
			     String device3 = choices.get(2).getSelectedItem();
			     String device4 = choices.get(3).getSelectedItem();
				  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), "+device3+"(red), and "+device4+"(yellow)");
			      interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break; 
	    	  
	      }
	      
	      case 5:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	  
	    		
		      plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		      AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		      rendererX.setTickLabelFormat(dateFormat);
		      LineRenderer lines = new DefaultLineRenderer2D();
	    	  lines.setColor(Color.green);
	    	  plot.setLineRenderer(series.get(0), lines);
	    	  plot.getPointRenderer(series.get(0)).setColor(Color.green);
	    	  
			  LineRenderer lines1 = new DefaultLineRenderer2D(); 
			  lines1.setColor(Color.blue);
			  plot.setLineRenderer(series.get(1), lines1);
			  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
			     
			  LineRenderer lines2 = new DefaultLineRenderer2D(); 
			  lines2.setColor(Color.red);
			  plot.setLineRenderer(series.get(2), lines2);
			  plot.getPointRenderer(series.get(2)).setColor(Color.red);
			     
			  LineRenderer lines3 = new DefaultLineRenderer2D(); 
			  lines3.setColor(Color.yellow);
			  plot.setLineRenderer(series.get(3), lines3);
			  plot.getPointRenderer(series.get(3)).setColor(Color.yellow);
			     
			  LineRenderer lines4 = new DefaultLineRenderer2D(); 
			  lines4.setColor(Color.black);
			  plot.setLineRenderer(series.get(4), lines4);
			  plot.getPointRenderer(series.get(4)).setColor(Color.black);
			
			  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
			  interactivePanel = new InteractivePanel(plot);
			     
			  interactivePanel.setLayout(null);
			  interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
			  String device1 = choices.get(0).getSelectedItem();
			  String device2 = choices.get(1).getSelectedItem();
			  String device3 = choices.get(2).getSelectedItem();
			  String device4 = choices.get(3).getSelectedItem();
			  String device5 = choices.get(4).getSelectedItem();
			  
			  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), and "+device5+"(black)");
			      interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break;  
	      }
	      
	      case 6:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	  plot.getTitle().setText("Measured values");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series.get(0), lines);
		    	  plot.getPointRenderer(series.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series.get(1), lines1);
				  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series.get(2), lines2);
				  plot.getPointRenderer(series.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series.get(3), lines3);
				  plot.getPointRenderer(series.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series.get(4), lines4);
				  plot.getPointRenderer(series.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series.get(5), lines5);
				  plot.getPointRenderer(series.get(5)).setColor(Color.cyan);
				
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
				     
				  interactivePanel = new InteractivePanel(plot);
				     
				  interactivePanel.setLayout(null);
				  interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
				  String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  

				  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), and "+device6+"(cyan)");
				  interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	      case 7:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	  plot.getTitle().setText("Measured values");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series.get(0), lines);
		    	  plot.getPointRenderer(series.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series.get(1), lines1);
				  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series.get(2), lines2);
				  plot.getPointRenderer(series.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series.get(3), lines3);
				  plot.getPointRenderer(series.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series.get(4), lines4);
				  plot.getPointRenderer(series.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series.get(5), lines5);
				  plot.getPointRenderer(series.get(5)).setColor(Color.cyan);
				
				  LineRenderer lines6 = new DefaultLineRenderer2D(); 
				  lines6.setColor(Color.darkGray);
				  plot.setLineRenderer(series.get(6), lines6);
				  plot.getPointRenderer(series.get(6)).setColor(Color.darkGray);
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
				     
				  interactivePanel = new InteractivePanel(plot);
				     
				  interactivePanel.setLayout(null);
				  interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
				  String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  String device7 = choices.get(6).getSelectedItem();
				  

				  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), "+device6+"(cyan), and "+device7+"(darkGrey)");
				  interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break; 
	    	 
	      }
	      
	      case 8:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	  plot.getTitle().setText("Measured values");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series.get(0), lines);
		    	  plot.getPointRenderer(series.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series.get(1), lines1);
				  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series.get(2), lines2);
				  plot.getPointRenderer(series.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series.get(3), lines3);
				  plot.getPointRenderer(series.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series.get(4), lines4);
				  plot.getPointRenderer(series.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series.get(5), lines5);
				  plot.getPointRenderer(series.get(5)).setColor(Color.cyan);
				
				  LineRenderer lines6 = new DefaultLineRenderer2D(); 
				  lines6.setColor(Color.darkGray);
				  plot.setLineRenderer(series.get(6), lines6);
				  plot.getPointRenderer(series.get(6)).setColor(Color.darkGray);
				  
				  LineRenderer lines7 = new DefaultLineRenderer2D(); 
				  lines7.setColor(Color.magenta);
				  plot.setLineRenderer(series.get(7), lines7);
				  plot.getPointRenderer(series.get(7)).setColor(Color.magenta);
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
				     
				  interactivePanel = new InteractivePanel(plot);
				     
				  interactivePanel.setLayout(null);
				  interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
				  String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  String device7 = choices.get(6).getSelectedItem();
				  String device8 = choices.get(7).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), "+device3+"(red), "+device4+"(yellow), \n"+device5+"(black), "+device6+"(cyan), "+device7+"(darkGrey), and "+device8+"(magenta)");
				  interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7), series.get(8));
	    	  plot.setInsets(new Insets2D.Double(20.0, 40.0, 80.0, 40.0));
	    	  plot.getTitle().setText("Measured values");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series.get(0), lines);
		    	  plot.getPointRenderer(series.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series.get(1), lines1);
				  plot.getPointRenderer(series.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series.get(2), lines2);
				  plot.getPointRenderer(series.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series.get(3), lines3);
				  plot.getPointRenderer(series.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series.get(4), lines4);
				  plot.getPointRenderer(series.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series.get(5), lines5);
				  plot.getPointRenderer(series.get(5)).setColor(Color.cyan);
				
				  LineRenderer lines6 = new DefaultLineRenderer2D(); 
				  lines6.setColor(Color.darkGray);
				  plot.setLineRenderer(series.get(6), lines6);
				  plot.getPointRenderer(series.get(6)).setColor(Color.darkGray);
				  
				  LineRenderer lines7 = new DefaultLineRenderer2D(); 
				  lines7.setColor(Color.magenta);
				  plot.setLineRenderer(series.get(7), lines7);
				  plot.getPointRenderer(series.get(7)).setColor(Color.magenta);
				  
				  LineRenderer lines8 = new DefaultLineRenderer2D(); 
				  lines8.setColor(Color.orange);
				  plot.setLineRenderer(series.get(8), lines8);
				  plot.getPointRenderer(series.get(8)).setColor(Color.orange);
				  
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
				     
				  interactivePanel = new InteractivePanel(plot);
				     
				  interactivePanel.setLayout(null);
				  interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
				  String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  String device7 = choices.get(6).getSelectedItem();
				  String device8 = choices.get(7).getSelectedItem();
				  String device9 = choices.get(8).getSelectedItem();

				  plot.getTitle().setText("Line plot: "+device1+"(green), "+device2+"(blue), "+device3+"(red), "+device4+"(yellow), \n"+device5+"(black), "+device6+"(cyan), "+device7+"(darkGrey), "+device8+"(magenta) and "+device9+"(orange)");
			      interactivePanel.setVisible(true);
			      
			      tabbedPane.addTab("Line plot", interactivePanel);
			  		tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	    	  
	      }


			 final JButton btnChange = new JButton("Change data");
				
		       btnChange.addMouseListener(new MouseAdapter() {
		       	@Override
		       	public void mouseClicked(MouseEvent arg0) {
		       		tabbedPane.setSelectedIndex(0);
		       	}
		       });
		     btnChange.setBounds(650, 492, 137, 23);
			 interactivePanel.add(btnChange);
			 
		
			 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
			 lblExport.setBounds(40, 499, 137, 23);
			 lblExport.setSize(400, 15);
			 lblExport.setForeground(Color.red);
			 interactivePanel.add(lblExport);
			 final JButton btnExit = new JButton("Cancel");
			
		     btnExit.setBounds(800, 492, 137, 23);
			 interactivePanel.add(btnExit);
			 
			 
			
			 btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
				tabbedPane.remove(1);
				//tabbedPane.resetKeyboardActions();
				//tabbedPane.remove(0);
				//BasicInformationPanel basicInfo = new BasicInformationPanel(tabbedPane);
				//tabbedPane.add("Basic data",basicInfo);
				//basicInfo.setLayout(null);
			
				//tabbedPane.setSelectedIndex(1);
					}
				});
			
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "Graph is empty");
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
      
      
