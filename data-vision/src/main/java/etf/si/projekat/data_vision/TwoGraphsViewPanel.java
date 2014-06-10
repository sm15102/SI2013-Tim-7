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

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.plots.axes.AxisRenderer;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateEventLogs;

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
	XYPlot plot2=new XYPlot();
	XYPlot plot1=new XYPlot();
InteractivePanel inter1;
InteractivePanel inter2;
  private JPanel contentPane;
  boolean paneli_bar;
  boolean paneli_line;

  final UtilDateModel model = new UtilDateModel();
 final JDatePanelImpl datePanel = new JDatePanelImpl(model);
  final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
  final UtilDateModel model1 = new UtilDateModel();
  final JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
  final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
  final UtilDateModel model2 = new UtilDateModel();
  final JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
  final JDatePickerImpl datePicker2=new JDatePickerImpl(datePanel2);
  final UtilDateModel model3 = new UtilDateModel();
  final JDatePanelImpl datePanel3 = new JDatePanelImpl(model3);
  final JDatePickerImpl datePicker3=new JDatePickerImpl(datePanel3);
  
  private List<List<EventLogs>> list_logs;
  private List<List<Double>> list_values;
  private List<List<EventLogs>> list_logs2;
  private List<List<Double>> list_values2;

  private List<Choice> choices;
  private List<Choice> choices2;
   final static DataTable data=new DataTable(Long.class, Double.class);
   XYPlot plot;
   private int size;
 
   private List<DataTable> datas;
   private List<DataSeries>series;
   private List<DataTable> datas2;
   private List<DataSeries>series2;
   boolean isFill1=false;
   boolean isFill2=false;

	/**
	 * Create the panel.
	 */
	public TwoGraphsViewPanel(JTabbedPane tabbedPane_1) {
		tabbedPane=tabbedPane_1;
		setLayout(null);
		paneli_line=false;
		paneli_bar=false;
		
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
		
		//UtilDateModel model = new UtilDateModel();
       // JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JLabel lblGraphType = new JLabel("Graph type");
        lblGraphType.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGraphType.setBounds(55, 60, 68, 14);
        add(lblGraphType);
       // final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setLocation(152, 75);
        datePicker.setSize(165, 28);
       add(datePicker);
        
        
        /*UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);*/
        datePicker1.setLocation(152, 104);
        datePicker1.setSize(165, 28);
      add(datePicker1);
      
     /* UtilDateModel model2 = new UtilDateModel();
      JDatePanelImpl datePane2 = new JDatePanelImpl(model2);
      final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePane2);*/
      datePicker2.setLocation(464, 75);
      datePicker2.setSize(165, 28);
    add(datePicker2);
    
   /*UtilDateModel model3 = new UtilDateModel();
    JDatePanelImpl datePane3 = new JDatePanelImpl(model3);
    final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePane3);*/
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
      separator.setBounds(10, 30, 821, 15);
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
      choice_1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==1 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==1 && !isFill2) isFill1=true;
				fillChoices(1);
				choice_2.enable();
			}
		});
      choice_2 = new Choice();
      choice_2.setBounds(152, 261, 165, 20);
      add(choice_2);
      choice_2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==2 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==2 && !isFill2) isFill1=true;
				fillChoices(2);
				choice_3.enable();
			}
		});
      choice_3 = new Choice();
      choice_3.setBounds(152, 285, 165, 20);
      add(choice_3);
      choice_3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==3 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==3 && !isFill2) isFill1=true;
				fillChoices(3);
				choice_4.enable();
			}
		});
      choice_4 = new Choice();
      choice_4.setBounds(152, 310, 165, 20);
      add(choice_4);
      choice_4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==4 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==4 && !isFill2) isFill1=true;
				fillChoices(4);
				choice_5.enable();
			}
		});
      choice_5 = new Choice();
      choice_5.setBounds(152, 335, 165, 20);
      add(choice_5);
      choice_5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==5 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==5 && !isFill2) isFill1=true;
				fillChoices(5);
				choice_6.enable();
			}
		});
      choice_6 = new Choice();
      choice_6.setBounds(152, 360, 165, 20);
      add(choice_6);
      choice_6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==6 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==6 && !isFill2) isFill1=true;
				fillChoices(6);
				choice_7.enable();
			}
		});
      choice_7 = new Choice();
      choice_7.setBounds(152, 385, 165, 20);
      add(choice_7);
      choice_7.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==7 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==7 && !isFill2) isFill1=true;
				fillChoices(7);
				choice_8.enable();
			}
		});
      choice_8 = new Choice();
      choice_8.setBounds(152, 410, 165, 20);
      add(choice_8);
      choice_8.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==8 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==8 && !isFill2) isFill1=true;
				fillChoices(8);
				choice_9.enable();
			}
		});
      choice_9 = new Choice();
      choice_9.setBounds(152, 436, 165, 20);
      add(choice_9);
      choice_9.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==9 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==9 && !isFill2) isFill1=true;
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
      	    	JOptionPane.showMessageDialog(null, "Time interval from (one graph) is before 'Time interval to'");
      	    	}
      	    if((date_start.compareTo(date_now) < 0)){
    	    	inFuture1=true;
    	    }else{
    	    	JOptionPane.showMessageDialog(null, "Time interval from (one graph) is in the future");
    	    }
      	    if((date_end.compareTo(date_now) < 0)){
      	    	inFuture2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "Time interval to (one graph) is  in the future");

      	    }
			} catch (ParseException e) {
					// TODO Auto-generated catch block
					LOGGER.log("context", e);
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
      		
      		 btnGenerateGraphs.setVisible(false);
      		 
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
      choice_11.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==1 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==1 && !isFill1) isFill2=true;
				fillChoices_1(1);
				choice_12.enable();
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
      choice_12.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==2 && isFill1) {
					btnGenerateGraphs.setVisible(true);
					isFill2=true;
				}
				if((Integer) spinner_2.getValue()==2 && !isFill1) isFill2=true;
				fillChoices_1(2);
				choice_13.enable();
			}
		});
      choice_13 = new Choice();
      choice_13.setBounds(464, 285, 165, 20);
      choice_13.setVisible(false);
      add(choice_13);
      choice_13.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==3 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==3 && !isFill1) isFill2=true;
				fillChoices_1(3);
				choice_14.enable();
			}
		});
      choice_14 = new Choice();
      choice_14.setBounds(464, 310, 165, 20);
      choice_14.setVisible(false);
      add(choice_14);
      choice_14.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==4 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==4 && !isFill1) isFill2=true;
				fillChoices_1(4);
				choice_15.enable();
			}
		});
      choice_15 = new Choice();
      choice_15.setBounds(464, 335, 165, 20);
      choice_15.setVisible(false);
      add(choice_15);
      choice_15.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==5 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==5 && !isFill1) isFill2=true;
				fillChoices_1(5);
				choice_16.enable();
			}
		});
      choice_16 = new Choice();
      choice_16.setBounds(464, 360, 165, 20);
      choice_16.setVisible(false);
      add(choice_16);
      choice_16.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==6 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==6 && !isFill1) isFill2=true;
				fillChoices_1(6);
				choice_17.enable();
			}
		});
      
      choice_17 = new Choice();
      choice_17.setBounds(464, 385, 165, 20);
      choice_17.setVisible(false);
      add(choice_17);
      choice_17.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==7 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==7 && !isFill1) isFill2=true;
				fillChoices_1(7);
				choice_18.enable();
			}
		});
      
      choice_18 = new Choice();
      choice_18.setBounds(464, 410, 165, 20);
      choice_18.setVisible(false);
      add(choice_18);
      choice_18.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==8 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==8 && !isFill1) isFill2=true;
				fillChoices_1(8);
				choice_19.enable();
			}
		});
      
      choice_19 = new Choice();
      choice_19.setBounds(464, 436, 165, 20);
      choice_19.setVisible(false);
      add(choice_19);
      choice_19.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner_2.getValue()==9 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner_2.getValue()==9 && !isFill1) isFill2=true;
				fillChoices_1(9);
			}
		});

      
      btnGenerateGraphs.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
      	
          	if("Line".equals(choice.getSelectedItem()) && "Bar".equals(choice_10.getSelectedItem()))	
          	{
          		//na lijevoj strani prikaz line, na desnoj prikaz bar
          		OneLineGraphShow1();
          		OneBarGraphShow2();
          	
          	}
      		
      		if("Line".equals(choice.getSelectedItem()) && "Line".equals(choice_10.getSelectedItem()))
      		{
      			//i lijevo i desno line
      			OneLineGraphShow1();
          		OneLineGraphShow2();
      		}
      		
      		if("Bar".equals(choice.getSelectedItem()) && "Line".equals(choice_10.getSelectedItem()))
      		{
      			//lijevo bar, desno line
      			OneBarGraphShow1();
          		OneLineGraphShow2();
      			
      		}
      		
      		if("Bar".equals(choice.getSelectedItem()) && "Bar".equals(choice_10.getSelectedItem()))
      		{
      			//lijevo i desno bar
      			OneBarGraphShow1();
          		OneBarGraphShow2();
      			
      		}
      		
      	
      			
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
      		
      		boolean islect=false;
      		boolean date1Beforedate2=false;
      		boolean inFuture1=false;
      		boolean inFuture2=false;

      		if(datePicker2.getModel().isSelected() && datePicker3.getModel().isSelected()){
				islect=true;
			}else{
      			JOptionPane.showMessageDialog(null, "Time is not selected");
      		}
      		if(islect){
      		Date dateString = (Date) datePicker2.getModel().getValue();
	  		String date_from = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
	  		Date dateString1 = (Date) datePicker3.getModel().getValue();
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
      	    	JOptionPane.showMessageDialog(null, "Time interval from (two graph) is before 'Time interval to'");
      	    	}
      	    if((date_start.compareTo(date_now) < 0)){
    	    	inFuture1=true;
    	    }else{
    	    	JOptionPane.showMessageDialog(null, "Time interval from (two graph) is in the future");
    	    }
      	    if((date_end.compareTo(date_now) < 0)){
      	    	inFuture2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "Time interval to (one graph) is  in the future");

      	    }
			} catch (ParseException e) {
					// TODO Auto-generated catch block
					LOGGER.log("context", e);
				}
			
      		}
      		
      		if(date1Beforedate2 && inFuture1 && inFuture2){
      		
      		// KOD ZA DRUGI GRAF
      			
      		choice_11.enable();
      		choice_12.disable();
      		choice_13.disable();
      		choice_14.disable();
      		choice_15.disable();
      		choice_16.disable();
      		choice_17.disable();
      		choice_18.disable();
      		choice_19.disable();
      		
      		choice_11.removeAll();
      		choice_12.removeAll();
      		choice_13.removeAll();
      		choice_14.removeAll();
      		choice_15.removeAll();
      		choice_16.removeAll();
      		choice_17.removeAll();
      		choice_18.removeAll();
      		choice_19.removeAll();
      		
      		btnGenerateGraphs.setVisible(false);
      		
      	  int valueSecondGraph = (Integer) spinner_2.getValue();
      		
      		
      		
			
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
				
				
			}
      		
      		
      		for (int i=0; i<list_device.size(); i++){
		    	 choice_11.add(list_device.get(i).getName() );
		    	
	      }
	      }else{
	    	  choice_11.setVisible(false);
				choice_12.setVisible(false);
				choice_13.setVisible(false);
				choice_14.setVisible(false);
				choice_15.setVisible(false);
				choice_16.setVisible(false);
				choice_17.setVisible(false);
				choice_18.setVisible(false);
				choice_19.setVisible(false);
				
				
				label_12.setVisible(false);
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_15.setVisible(false);
				label_16.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				label_20.setVisible(false);
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

	
	
	public void  OneLineGraphShow1()
	{
		
//		List<DataTable> vrijednosti= new ArrayList<DataTable>();
		Integer value = (Integer) spinner.getValue();
		
	//	for(int k=0; k<value; k++)
		//{
							 
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
						  //lista eventlogova ciji su datumi izmeÄ‘u unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
						 
							}
							size=list_logs.size();
							list_values=new ArrayList<List<Double>>();
							for(int i=0; i<list_logs.size();i++){
								
								List<Double>values=new ArrayList<Double>();
								for(int j=0;j<list_logs.get(i).size();j++){
									
								values.add(list_logs.get(i).get(j).getValue());//add(list_logs.get(i).get(j).getValue());           //Ovo ÄŤemo stavljati na graf valjda :D
								
								}
								list_values.add(values);
								}
							for(int i=0; i<list_logs.size();i++){
								if(list_logs.get(i).size()!=0) isFill1=true;
							}
							}catch(Exception e){
								 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
								System.out.println("Ne poklapaju se vrijednosti");
							}
						} 
						  catch (Exception e1) {
							
							LOGGER.log("context", e1);
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
			
					//  }
	if(isFill1){	 
	      switch(value)
	      {
	      case 1:
	      {
		XYPlot plot = new XYPlot(series.get(0));
		//plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		//Insets2D.Double(double top, double left, double bottom, double right)
		plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		 plot.getTitle().setText("Line plot");
			
         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
         
        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         rendererX.setTickLabelFormat(dateFormat);
  		 
		  LineRenderer lines = new DefaultLineRenderer2D();
		  lines.setColor(Color.green);
		  plot.setLineRenderer(series.get(0), lines);
		  plot.setPointRenderer(series.get(0), null);

         plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
	         
         
         String device = choices.get(0).getSelectedItem();
         
         //    plot.setLegendVisible(true);
             	              
       //      plot.getLegend().add(datas.get(0));
           		  
             plot.getTitle().setText("Line plot: "+device+"(green)");
             
	         interactivePanel = new InteractivePanel(plot);
	         
	         interactivePanel.setLayout(null);
	         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
	         interactivePanel.setVisible(true);
	         
		break;
	      }
	      case 2:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0));
	  		
	  		 plot.getTitle().setText("Line plot");
	  			
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);
		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), and "+device2+"(blue)");
		        
		          interactivePanel.setVisible(true);
			  	
			     
			     break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	  		 plot.getTitle().setText("Line plot");
	  			
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		         String device1 = choices.get(0).getSelectedItem();
			     String device2 = choices.get(1).getSelectedItem();
			     String device3 = choices.get(2).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), and "+device3+"(red)");
		          interactivePanel.setVisible(true);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
	  		  plot.getTitle().setText("Line plot");
	  			
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);
		         String device1 = choices.get(0).getSelectedItem();
			     String device2 = choices.get(1).getSelectedItem();
			     String device3 = choices.get(2).getSelectedItem();
			     String device4 = choices.get(3).getSelectedItem();
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red),\n and "+device4+"(yellow)");
		          
		          interactivePanel.setVisible(true);
		          break;
	    	  
	      }
	    	  
	      
	      case 5:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
		  			
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);
		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), and "+device5+"(black)");
				      interactivePanel.setVisible(true);
		          break;
	      }
	      
	      case 6:
	      {
	    	  
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);
		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  

				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black),\n and "+device6+"(cyan)");
				  interactivePanel.setVisible(true);
		          break;
	      }
	      
	      case 7:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      plot.getTitle().setText("Line plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  String device7 = choices.get(6).getSelectedItem();
				  

				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), \n"+device6+"(cyan), and "+device7+"(darkGrey)");
				  interactivePanel.setVisible(true);
			     
			     break; 
	    	 
	      }
	      
	      
	      case 8:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7));
	    	 
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);
		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  String device7 = choices.get(6).getSelectedItem();
				  String device8 = choices.get(7).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), \n"+device6+"(cyan), "+device7+"(darkGrey),\n and "+device8+"(magenta)");
				  interactivePanel.setVisible(true);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  XYPlot plot = new XYPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7), series.get(8));
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      plot.getTitle().setText("Line plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 950, 400));
		         interactivePanel.setOpaque(true);

		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices.get(1).getSelectedItem();
				  String device3 = choices.get(2).getSelectedItem();
				  String device4 = choices.get(3).getSelectedItem();
				  String device5 = choices.get(4).getSelectedItem();
				  String device6 = choices.get(5).getSelectedItem();
				  String device7 = choices.get(6).getSelectedItem();
				  String device8 = choices.get(7).getSelectedItem();
				  String device9 = choices.get(8).getSelectedItem();

				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), \n"+device6+"(cyan), "+device7+"(darkGrey), \n"+device8+"(magenta) and "+device9+"(orange)");
			      interactivePanel.setVisible(true);
			     
			     break; 
	      }
	      
	      }
	}
	
		
	}
	
	
	
	public void  OneLineGraphShow2()
	{
		
//		List<DataTable> vrijednosti= new ArrayList<DataTable>();
		Integer value = (Integer) spinner_2.getValue();
		
//		for(int k=0; k<value; k++)
	//	{
							 
				    //Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker2.getModel().getValue();
			  		String date_from = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker3.getModel().getValue();
			  		String date_to = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date date_start;
					Date date_end;
					
					  try {
						date_start = sdf.parse(date_from);
						date_end = sdf.parse(date_to);
						 

						try {
						
							
							choices2=new ArrayList<Choice>();
							choices2.add(choice_11);
							choices2.add(choice_12);
							choices2.add(choice_13);
							choices2.add(choice_14);
							choices2.add(choice_15);
							choices2.add(choice_16);
							choices2.add(choice_17);
							choices2.add(choice_18);
							choices2.add(choice_19);	
						

							list_logs2=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  list_logs2.add(new HibernateEventLogs().getdatesbetween(choices2.get(i).getSelectedItem(),date_start,date_end));//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end)); //lista eventlogova ciji su datumi izmedu unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						size=list_logs2.size();
						list_values2=new ArrayList<List<Double>>();
						for(int i=0; i<list_logs2.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<list_logs2.get(i).size();j++){
								
							values.add(list_logs2.get(i).get(j).getValue());//add(list_logs.get(i).get(j).getValue());           //Ovo ÄŤemo stavljati na graf valjda :D
							
							}
							list_values2.add(values);
							}
						for(int i=0; i<list_logs2.size();i++){
							if(list_logs2.get(i).size()!=0) isFill2=true;
						}
						}catch(Exception e){
							 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							System.out.println("Ne poklapaju se vrijednosti");
						}
					} 
					  catch (Exception e1) {
						
						LOGGER.log("context", e1);
					}
					
					  datas2=new ArrayList<DataTable>();
						 series2=new ArrayList<DataSeries>();
						  
						  
						  for(int i=0;i<list_logs2.size();i++)
						  {
							  DataTable d=new DataTable(Long.class, Double.class, String.class);
							  
							  for(int j=0;j<list_logs2.get(i).size();j++)
							  {
								  d.add(list_logs2.get(i).get(j).getTimestamp().getTime(), list_values2.get(i).get(j), list_logs2.get(i).get(j).getDevice_name());
							  }
							
							  datas2.add(d);
							  
						  }
						  
						  for(int i=0;i<datas2.size();i++)
						  {
							  series2.add(new DataSeries(datas2.get(i)));
						  }
				
//					  }
		if(isFill2){ 
	      switch(value)
	      {
	      case 1:
	      {
		XYPlot plot = new XYPlot(series2.get(0));
		plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		//plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		//Insets2D.Double(double top, double left, double bottom, double right)

		 plot.getTitle().setText("Line plot");
	       
			
         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
         
        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         rendererX.setTickLabelFormat(dateFormat);
   	  LineRenderer lines = new DefaultLineRenderer2D();
	  lines.setColor(Color.green);
	  plot.setLineRenderer(series2.get(0), lines);
	  plot.setPointRenderer(series2.get(0), null);

     plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
         
     
     String device = choices2.get(0).getSelectedItem();
     
     //    plot.setLegendVisible(true);
         	              
   //      plot.getLegend().add(datas.get(0));
       		  
         plot.getTitle().setText("Line plot: "+device+"(green)");
	         
	         interactivePanel1 = new InteractivePanel(plot);
	         
	         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400)); 
	         
	          contentPane = new JPanel();
	       
				contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

		         interactivePanel1.setLayout(null);			
				 tabbedPane.addTab("Two graphs", contentPane);
				 contentPane.setVisible(true);
				contentPane.add(interactivePanel);
				//interactivePanel.isOpaque();
					//interactivePanel1.setVisible(true);
			         
			     	contentPane.add(interactivePanel1);
			     	interactivePanel1.setLayout(null);
			        // interactivePanel.setLayout(null);
				contentPane.setLayout(null);
				tabbedPane.setSelectedIndex(1);
	         
		break;
	      }
	      case 2:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	    	  plot.getTitle().setText("Line plot");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
	    		  lines.setColor(Color.green);
	    		  plot.setLineRenderer(series2.get(0), lines);
	    		  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
	    		  
			      LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
	    		     
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
				    String device1 = choices2.get(0).getSelectedItem();
					  String device2 = choices2.get(1).getSelectedItem();
					  
					  plot.getTitle().setText("Line plot: "+device1+"(green), and \n"+device2+"(blue)");
			     interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		          
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	  		 plot.getTitle().setText("Line plot");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
	    		  lines.setColor(Color.green);
	    		  plot.setLineRenderer(series2.get(0), lines);
	    		  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
	    		  
			      LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
			     
			     LineRenderer lines2 = new DefaultLineRenderer2D(); 
			     lines2.setColor(Color.red);
				  plot.setLineRenderer(series2.get(2), lines2);
				  plot.getPointRenderer(series2.get(2)).setColor(Color.red);
			     
			     plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
			     interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         String device1 = choices2.get(0).getSelectedItem();
			     String device2 = choices2.get(1).getSelectedItem();
			     String device3 = choices2.get(2).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), and "+device3+"(red)");
		          interactivePanel.setVisible(true);
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	  			
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
	    		  lines.setColor(Color.green);
	    		  plot.setLineRenderer(series2.get(0), lines);
	    		  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
	    		  
			      LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
			     
			     LineRenderer lines2 = new DefaultLineRenderer2D(); 
			     lines2.setColor(Color.red);
				  plot.setLineRenderer(series2.get(2), lines2);
				  plot.getPointRenderer(series2.get(2)).setColor(Color.red);
			     
			     LineRenderer lines3 = new DefaultLineRenderer2D(); 
			     lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series2.get(3), lines3);
				  plot.getPointRenderer(series2.get(3)).setColor(Color.yellow);
			     
			     plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 440, 400));
		         String device1 = choices2.get(0).getSelectedItem();
			     String device2 = choices2.get(1).getSelectedItem();
			     String device3 = choices2.get(2).getSelectedItem();
			     String device4 = choices2.get(3).getSelectedItem();
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red),\n and "+device4+"(yellow)");
		          
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	    	  
	      }
	    	  
	      
	      case 5:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
		  			
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
			  LineRenderer lines = new DefaultLineRenderer2D();
		         plot.setLineRenderer(series2.get(0), lines);
		         Color color = new Color(0.0f, 0.3f, 1.0f);
		        plot.getPointRenderer(series2.get(0)).setColor(color);
		         plot.getLineRenderer(series2.get(0)).setColor(color);
		         
		         LineRenderer lines1 = new DefaultLineRenderer2D(); 
			     plot.setLineRenderer(series2.get(1), lines1);
			     Color color1 = new Color(0.0f, 0.3f, 1.0f);
			     plot.getPointRenderer(series2.get(1)).setColor(color1);
			     plot.getLineRenderer(series2.get(1)).setColor(color1);
			     
			     LineRenderer lines2 = new DefaultLineRenderer2D(); 
			     plot.setLineRenderer(series2.get(2), lines2);
			     Color color2 = new Color(0.0f, 0.3f, 1.0f);
			     plot.getPointRenderer(series2.get(2)).setColor(color2);
			     plot.getLineRenderer(series2.get(2)).setColor(color2);
			     
			     LineRenderer lines3 = new DefaultLineRenderer2D(); 
			     plot.setLineRenderer(series2.get(3), lines3);
			     Color color3 = new Color(0.0f, 0.3f, 1.0f);
			     plot.getPointRenderer(series2.get(3)).setColor(color3);
			     plot.getLineRenderer(series2.get(3)).setColor(color3);
			     
			     LineRenderer lines4 = new DefaultLineRenderer2D(); 
			     plot.setLineRenderer(series2.get(4), lines4);
			     Color color4 = new Color(0.0f, 0.3f, 1.0f);
			     plot.getPointRenderer(series2.get(4)).setColor(color4);
			     plot.getLineRenderer(series2.get(4)).setColor(color4);
			     
			     plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		         String device1 = choices2.get(0).getSelectedItem();
				  String device2 = choices2.get(1).getSelectedItem();
				  String device3 = choices2.get(2).getSelectedItem();
				  String device4 = choices2.get(3).getSelectedItem();
				  String device5 = choices2.get(4).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), and "+device5+"(black)");

		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 6:
	      {
	    	  
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series2.get(0), lines);
		    	  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series2.get(2), lines2);
				  plot.getPointRenderer(series2.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series2.get(3), lines3);
				  plot.getPointRenderer(series2.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series2.get(4), lines4);
				  plot.getPointRenderer(series2.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series2.get(5), lines5);
				  plot.getPointRenderer(series2.get(5)).setColor(Color.cyan);
				
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));

		         String device1 = choices2.get(0).getSelectedItem();
				  String device2 = choices2.get(1).getSelectedItem();
				  String device3 = choices2.get(2).getSelectedItem();
				  String device4 = choices2.get(3).getSelectedItem();
				  String device5 = choices2.get(4).getSelectedItem();
				  String device6 = choices2.get(5).getSelectedItem();
				  

				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black),\n and "+device6+"(cyan)");

interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 440, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 7:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5), series2.get(6));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series2.get(0), lines);
		    	  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series2.get(2), lines2);
				  plot.getPointRenderer(series2.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series2.get(3), lines3);
				  plot.getPointRenderer(series2.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series2.get(4), lines4);
				  plot.getPointRenderer(series2.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series2.get(5), lines5);
				  plot.getPointRenderer(series2.get(5)).setColor(Color.cyan);
				
				  LineRenderer lines6 = new DefaultLineRenderer2D(); 
				  lines6.setColor(Color.darkGray);
				  plot.setLineRenderer(series2.get(6), lines6);
				  plot.getPointRenderer(series2.get(6)).setColor(Color.darkGray);
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
				     

		         String device1 = choices2.get(0).getSelectedItem();
				  String device2 = choices2.get(1).getSelectedItem();
				  String device3 = choices2.get(2).getSelectedItem();
				  String device4 = choices2.get(3).getSelectedItem();
				  String device5 = choices2.get(4).getSelectedItem();
				  String device6 = choices2.get(5).getSelectedItem();
				  String device7 = choices2.get(6).getSelectedItem();
				  

				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), \n"+device6+"(cyan), and "+device7+"(darkGrey)");

				  interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	    	 
	      }
	      
	      
	      case 8:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5), series2.get(6), series2.get(7));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series2.get(0), lines);
		    	  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series2.get(2), lines2);
				  plot.getPointRenderer(series2.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series2.get(3), lines3);
				  plot.getPointRenderer(series2.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series2.get(4), lines4);
				  plot.getPointRenderer(series2.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series2.get(5), lines5);
				  plot.getPointRenderer(series2.get(5)).setColor(Color.cyan);
				
				  LineRenderer lines6 = new DefaultLineRenderer2D(); 
				  lines6.setColor(Color.darkGray);
				  plot.setLineRenderer(series2.get(6), lines6);
				  plot.getPointRenderer(series2.get(6)).setColor(Color.darkGray);
				  
				  LineRenderer lines7 = new DefaultLineRenderer2D(); 
				  lines7.setColor(Color.magenta);
				  plot.setLineRenderer(series2.get(7), lines7);
				  plot.getPointRenderer(series2.get(7)).setColor(Color.magenta);
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
		         String device1 = choices.get(0).getSelectedItem();
				  String device2 = choices2.get(1).getSelectedItem();
				  String device3 = choices2.get(2).getSelectedItem();
				  String device4 = choices2.get(3).getSelectedItem();
				  String device5 = choices2.get(4).getSelectedItem();
				  String device6 = choices2.get(5).getSelectedItem();
				  String device7 = choices2.get(6).getSelectedItem();
				  String device8 = choices2.get(7).getSelectedItem();
				  
				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), \n"+device6+"(cyan), "+device7+"(darkGrey),\n and "+device8+"(magenta)");

			     
				  interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5), series2.get(6), series2.get(7), series2.get(8));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Line plot");
	    		
		         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
		        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
		         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		         rendererX.setTickLabelFormat(dateFormat);
		         LineRenderer lines = new DefaultLineRenderer2D();
		    	  lines.setColor(Color.green);
		    	  plot.setLineRenderer(series2.get(0), lines);
		    	  plot.getPointRenderer(series2.get(0)).setColor(Color.green);
		    	  
				  LineRenderer lines1 = new DefaultLineRenderer2D(); 
				  lines1.setColor(Color.blue);
				  plot.setLineRenderer(series2.get(1), lines1);
				  plot.getPointRenderer(series2.get(1)).setColor(Color.blue);
				     
				  LineRenderer lines2 = new DefaultLineRenderer2D(); 
				  lines2.setColor(Color.red);
				  plot.setLineRenderer(series2.get(2), lines2);
				  plot.getPointRenderer(series2.get(2)).setColor(Color.red);
				     
				  LineRenderer lines3 = new DefaultLineRenderer2D(); 
				  lines3.setColor(Color.yellow);
				  plot.setLineRenderer(series2.get(3), lines3);
				  plot.getPointRenderer(series2.get(3)).setColor(Color.yellow);
				     
				  LineRenderer lines4 = new DefaultLineRenderer2D(); 
				  lines4.setColor(Color.black);
				  plot.setLineRenderer(series2.get(4), lines4);
				  plot.getPointRenderer(series2.get(4)).setColor(Color.black);
				
				  LineRenderer lines5 = new DefaultLineRenderer2D(); 
				  lines5.setColor(Color.cyan);
				  plot.setLineRenderer(series2.get(5), lines5);
				  plot.getPointRenderer(series2.get(5)).setColor(Color.cyan);
				
				  LineRenderer lines6 = new DefaultLineRenderer2D(); 
				  lines6.setColor(Color.darkGray);
				  plot.setLineRenderer(series2.get(6), lines6);
				  plot.getPointRenderer(series2.get(6)).setColor(Color.darkGray);
				  
				  LineRenderer lines7 = new DefaultLineRenderer2D(); 
				  lines7.setColor(Color.magenta);
				  plot.setLineRenderer(series2.get(7), lines7);
				  plot.getPointRenderer(series2.get(7)).setColor(Color.magenta);
				  
				  LineRenderer lines8 = new DefaultLineRenderer2D(); 
				  lines8.setColor(Color.orange);
				  plot.setLineRenderer(series2.get(8), lines8);
				  plot.getPointRenderer(series2.get(8)).setColor(Color.orange);
				  
				  plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
			     
				  String device1 = choices2.get(0).getSelectedItem();
				  String device2 = choices2.get(1).getSelectedItem();
				  String device3 = choices2.get(2).getSelectedItem();
				  String device4 = choices2.get(3).getSelectedItem();
				  String device5 = choices2.get(4).getSelectedItem();
				  String device6 = choices2.get(5).getSelectedItem();
				  String device7 = choices2.get(6).getSelectedItem();
				  String device8 = choices2.get(7).getSelectedItem();
				  String device9 = choices2.get(8).getSelectedItem();

				  plot.getTitle().setText("Line plot: "+device1+"(green), \n"+device2+"(blue), "+device3+"(red), \n"+device4+"(yellow), "+device5+"(black), \n"+device6+"(cyan), "+device7+"(darkGrey), \n"+device8+"(magenta) and "+device9+"(orange)");
			      
			     
			     
				  interactivePanel1 = new InteractivePanel(plot);
		         
				  interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	    	  
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
		 contentPane.add(btnChange);
		 
	
		 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
		 lblExport.setBounds(40, 499, 137, 23);
		 lblExport.setSize(400, 15);
		 lblExport.setForeground(Color.red);
		 contentPane.add(lblExport);
		 final JButton btnExit = new JButton("Cancel");
		
	     btnExit.setBounds(800, 492, 137, 23);
		contentPane.add(btnExit);
		 
		 
		
		 btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			tabbedPane.remove(1);
			//tabbedPane.resetKeyboardActions();
			tabbedPane.remove(0);
			TwoGraphsViewPanel twoGraphs= new TwoGraphsViewPanel(tabbedPane);
			tabbedPane.add("Two graphs",twoGraphs);
			twoGraphs.setLayout(null);
		
			tabbedPane.setSelectedIndex(1);
			
				}
			});
		
	}
	
	
	
	
	
	//-----kod za lijevi bar ---------------------------------------------------------------------//
	
	
	
	public void  OneBarGraphShow1()
	{
		
		List<DataTable> vrijednosti= new ArrayList<DataTable>();
		Integer value = (Integer) spinner.getValue();
		
		for(int k=0; k<value; k++)
		{
							 
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
							
					  list_logs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end));//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end)); //lista eventlogova ciji su datumi izmedu unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						size=list_logs.size();
						list_values=new ArrayList<List<Double>>();
						for(int i=0; i<list_logs.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<list_logs.get(i).size();j++){
								
							values.add(list_logs.get(i).get(j).getValue());//add(list_logs.get(i).get(j).getValue());           //Ovo Ă„Ĺ¤emo stavljati na graf valjda :D
							
							}
							list_values.add(values);
							
							 
						}
						}catch(Exception e){
							 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							System.out.println("Ne poklapaju se vrijednosti");
						}
					} 
					  catch (Exception e1) {
						// TODO Auto-generated catch block
						 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
						LOGGER.log("context", e1);
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
		 
	      switch(value)
	      {
	      case 1:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0));
		//plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		//Insets2D.Double(double top, double left, double bottom, double right)
		plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		 plot.getTitle().setText("Bar plot");
			
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
	         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
	         //interactivePanel.setOpaque(true);

	       
	          interactivePanel.setVisible(true);
	          
	          //contentPane.add(interactivePanel);
	         
		break;
	      }
	      case 2:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	  		 plot.getTitle().setText("Bar plot");
	  			
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
       		 
        plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        rendererX.setTickLabelFormat(dateFormat);
			     
			     interactivePanel = new InteractivePanel(plot);
		         
		        interactivePanel.setLayout(null);
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		        
		          interactivePanel.setVisible(true);
			  	
			     
			     break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	  		 plot.getTitle().setText("Bar plot");
	  			
	    		
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
       		 
        plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        rendererX.setTickLabelFormat(dateFormat);
			     
			     interactivePanel = new InteractivePanel(plot);
		         
		         interactivePanel.setLayout(null);
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	  		 plot.getTitle().setText("Bar plot");
	  			
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
		          break;
	    	  
	      }
	    	  
	      
	      case 5:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4) );
	    	 
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
		  			
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
		          break;
	      }
	      
	      case 6:
	      {
	    	  
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
		          break;
	      }
	      
	      case 7:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
			     
			     break; 
	    	 
	      }
	      
	      
	      case 8:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7) );
	    	 
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 440, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7), series.get(8) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		      //Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
		         interactivePanel.setBounds(new Rectangle(0, 0, 950, 400));
		         interactivePanel.setOpaque(true);

		          
		          interactivePanel.setVisible(true);
			     
			     break; 
	      }
	      
	      }
	
		   
		
		 /*final JButton btnChange = new JButton("Change data");
			
	       btnChange.addMouseListener(new MouseAdapter() {
	       	@Override
	       	public void mouseClicked(MouseEvent arg0) {
	       		tabbedPane.setSelectedIndex(0);
	       	}
	       });
	     btnChange.setBounds(690, 462, 137, 23);
		 interactivePanel.add(btnChange);
		 
	
		 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
		 lblExport.setBounds(131, 462, 137, 23);
		 lblExport.setSize(400, 15);
		 
		 interactivePanel.add(lblExport);
		 final JButton btnExit = new JButton("Cancel");
		
	     btnExit.setBounds(831, 462, 137, 23);
		 interactivePanel.add(btnExit);
		 
		 
		
		 btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			tabbedPane.remove(1);
			//tabbedPane.resetKeyboardActions();
			tabbedPane.remove(0);
			BasicInformationPanel basicInfo = new BasicInformationPanel(tabbedPane);
			tabbedPane.add("Basic data",basicInfo);
			basicInfo.setLayout(null);
		
			tabbedPane.setSelectedIndex(1);
			
				}
			});
		*/
		
	}
	
	
	
	//Kod za prikaz desno barplota 
	
	public void  OneBarGraphShow2()
	{
		
		List<DataTable> vrijednosti= new ArrayList<DataTable>();
		Integer value = (Integer) spinner.getValue();
		
		for(int k=0; k<value; k++)
		{
							 
				    //Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker2.getModel().getValue();
			  		String date_from = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker3.getModel().getValue();
			  		String date_to = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date date_start;
					Date date_end;
					
					  try {
						date_start = sdf.parse(date_from);
						date_end = sdf.parse(date_to);
						 

						try {
						
							
							List<Choice> choices=new ArrayList<Choice>();
							choices.add(choice_11);
							choices.add(choice_12);
							choices.add(choice_13);
							choices.add(choice_14);
							choices.add(choice_15);
							choices.add(choice_16);
							choices.add(choice_17);
							choices.add(choice_18);
							choices.add(choice_19);	
						 value = (Integer) spinner_2.getValue();

							list_logs=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  list_logs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end));//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end)); //lista eventlogova ciji su datumi izmedu unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						size=list_logs.size();
						list_values=new ArrayList<List<Double>>();
						for(int i=0; i<list_logs.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<list_logs.get(i).size();j++){
								
							values.add(list_logs.get(i).get(j).getValue());//add(list_logs.get(i).get(j).getValue());           //Ovo cemo stavljati na graf valjda :D
							
							}
							list_values.add(values);
							
							 
						}
						}catch(Exception e){
							 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							System.out.println("Ne poklapaju se vrijednosti");
						}
					} 
					  catch (Exception e1) {
						// TODO Auto-generated catch block
						 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
						LOGGER.log("context", e1);
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
		 
	      switch(value)
	      {
	      case 1:
	      {
	    final BarPlot plot= new BarPlot(series.get(0));
		plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		//plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0.0));
		//Insets2D.Double(double top, double left, double bottom, double right)

		 plot.getTitle().setText("Bar plot");
	       
			
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
     
    		 
     plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

     AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
     rendererX.setTickLabelFormat(dateFormat);
     
     
     pointRenderer.setValueVisible(true);
     pointRenderer.setValueColumn(2);
     pointRenderer.setValueLocation(Location.CENTER);
     pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
     pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
	         
	         interactivePanel1 = new InteractivePanel(plot);
	         
	        // interactivePanel1.setBounds(new Rectangle(0, 0, 440, 400));
	         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400)); 
	         
	          contentPane = new JPanel();
	       
				contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
			
			//	interactivePanel1.setVisible(true);
		         interactivePanel1.setLayout(null);			
				 tabbedPane.addTab("Two graphs", contentPane);
				 contentPane.setVisible(true);
				contentPane.add(interactivePanel);
				//interactivePanel.isOpaque();
					//interactivePanel1.setVisible(true);
			         
			     	contentPane.add(interactivePanel1);
			     	interactivePanel1.setLayout(null);
			        // interactivePanel.setLayout(null);
				contentPane.setLayout(null);
				tabbedPane.setSelectedIndex(1);
	         
		break;
	      }
	      case 2:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	    	  plot.getTitle().setText("Bar plot");
	    		
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
	        		 
	         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

	         AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         rendererX.setTickLabelFormat(dateFormat);
     
			     
			     interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		          
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  		//Insets2D.Double(double top, double left, double bottom, double right)

	  		 plot.getTitle().setText("Bar plot");
	    		
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
       		 
        plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        rendererX.setTickLabelFormat(dateFormat);
			     
			     interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	  			
	    		
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
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 440, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	    	  
	      }
	    	  
	      
	      case 5:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
		  			
	    		
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
	         
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 6:
	      {
	    	  
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 440, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 7:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
       
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	    	 
	      }
	      
	      
	      case 8:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
			     
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7), series.get(8) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		//Insets2D.Double(double top, double left, double bottom, double right)

		  		 plot.getTitle().setText("Bar plot");
	    		
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
			     
interactivePanel1 = new InteractivePanel(plot);
		         
		         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400));
		         
		       
		          contentPane = new JPanel();
		       
		          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
					
					//	interactivePanel1.setVisible(true);
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						//interactivePanel.isOpaque();
							//interactivePanel1.setVisible(true);
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					        // interactivePanel.setLayout(null);
						contentPane.setLayout(null);
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
		 contentPane.add(btnChange);
		 
	
		 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
		 lblExport.setBounds(40, 499, 137, 23);
		 lblExport.setSize(400, 15);
		 lblExport.setForeground(Color.red);
		 contentPane.add(lblExport);
		 final JButton btnExit = new JButton("Cancel");
		
	     btnExit.setBounds(800, 492, 137, 23);
		contentPane.add(btnExit);
		 
		 
		
		 btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			tabbedPane.remove(1);
			tabbedPane.setSelectedIndex(1);
				}
			});
		
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
      
      
