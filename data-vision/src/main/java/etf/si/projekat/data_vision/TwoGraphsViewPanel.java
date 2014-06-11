package etf.si.projekat.data_vision;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.BasicStroke;
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
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.EventLogs;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateEventLogs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TwoGraphsViewPanel extends ExamplePanel {
	private static final Logger LOGGER = Logger.getLogger(TwoGraphsViewPanel.class.getName());
	 List<DeviceName> listDevice=new HibernateDeviceName().giveAllDeviceName();

    final Choice choice; 
    final  Choice choice10;
    final Choice choice1;
    final Choice choice2;
    final Choice choice3;
    final Choice choice4;
    final Choice choice5;
    final Choice choice6;
    final Choice choice7;
    final Choice choice8;
    final Choice choice9;
    final Choice choice11;
    final Choice choice12;
    final Choice choice13;
    final Choice choice14;
    final Choice choice15;
    final Choice choice16;
    final Choice choice17;
    final Choice choice18;
    final Choice choice19;
    
    final JSpinner spinner;
    final JSpinner spinner2;
    final JTabbedPane tabbedPane;
 
  InteractivePanel interactivePanel;
  InteractivePanel interactivePanel1;
  InteractivePanel interactivePanel2;
	XYPlot plot2=new XYPlot();
	XYPlot plot1=new XYPlot();
InteractivePanel inter1;
InteractivePanel inter2;
  private JPanel contentPane;
  boolean paneliBar;
  boolean paneliLine;

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
  
  private List<List<EventLogs>> listLogs;
  private List<List<Double>> listValues;
  private List<List<EventLogs>> listLogs2;
  private List<List<Double>> listValues2;

  private List<Choice> choices;
  private List<Choice> choices2;

   private List<DataTable> datas;
   private List<DataSeries>series;
   private List<DataTable> datas2;
   private List<DataSeries>series2;
   boolean isFill1=false;
   boolean isFill2=false;

	/**
	 * Create the panel.
	 */
	public TwoGraphsViewPanel(JTabbedPane tabbedPane1) {
		tabbedPane=tabbedPane1;
		setLayout(null);
		paneliLine=false;
		paneliBar=false;
		
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

		
		  final JButton btnGenerateGraphs = new JButton("Generate graphs");
	      btnGenerateGraphs.setBounds(493, 477, 136, 23);
	      btnGenerateGraphs.setVisible(false);
	      add(btnGenerateGraphs);
		
		
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
      
        datePicker.setLocation(152, 75);
        datePicker.setSize(165, 28);
       add(datePicker);
        
        
     
        datePicker1.setLocation(152, 104);
        datePicker1.setSize(165, 28);
      add(datePicker1);
   
      datePicker2.setLocation(464, 75);
      datePicker2.setSize(165, 28);
    add(datePicker2);
    
  
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
      
      final JSeparator separator1 = new JSeparator();
      separator1.setBounds(222, 220, -220, -5);
      separator1.setVisible(false);
      add(separator1);
      
      
      final JSeparator separator2 = new JSeparator();
      separator2.setBounds(10, 228, 619, 2);
      add(separator2);
      
      final  JLabel label1 = new JLabel("Sensor type 1");
      label1.setHorizontalAlignment(SwingConstants.RIGHT);
      label1.setBounds(28, 241, 95, 14);
      add(label1);
      
      final JLabel label2 = new JLabel("Sensor type 2");
      label2.setHorizontalAlignment(SwingConstants.RIGHT);
      label2.setBounds(28, 266, 95, 14);
      add(label2);
      
      final  JLabel label3 = new JLabel("Sensor type 3");
      label3.setHorizontalAlignment(SwingConstants.RIGHT);
      label3.setBounds(30, 291, 95, 14);
      add(label3);
      
      final  JLabel label4 = new JLabel("Sensor type 4");
      label4.setHorizontalAlignment(SwingConstants.RIGHT);
      label4.setBounds(30, 316, 95, 14);
      add(label4);
      
      final  JLabel label5 = new JLabel("Sensor type 5");
      label5.setHorizontalAlignment(SwingConstants.RIGHT);
      label5.setBounds(30, 341, 95, 14);
      add(label5);
      
      choice1 = new Choice();
      choice1.setBounds(152, 235, 165, 20);
      add(choice1);
      choice1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==1 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==1 && !isFill2) isFill1=true;
				fillChoices(1);
				choice2.enable();
			}
		});
      choice2 = new Choice();
      choice2.setBounds(152, 261, 165, 20);
      add(choice2);
      choice2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==2 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==2 && !isFill2) isFill1=true;
				fillChoices(2);
				choice3.enable();
			}
		});
      choice3 = new Choice();
      choice3.setBounds(152, 285, 165, 20);
      add(choice3);
      choice3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==3 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==3 && !isFill2){
					isFill1=true;
				}
				fillChoices(3);
				choice4.enable();
			}
		});
      choice4 = new Choice();
      choice4.setBounds(152, 310, 165, 20);
      add(choice4);
      choice4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==4 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==4 && !isFill2){
					isFill1=true;
				}
				fillChoices(4);
				choice5.enable();
			}
		});
      choice5 = new Choice();
      choice5.setBounds(152, 335, 165, 20);
      add(choice5);
      choice5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==5 && isFill2){
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==5 && !isFill2){
					isFill1=true;
				}
				fillChoices(5);
				choice6.enable();
			}
		});
      choice6 = new Choice();
      choice6.setBounds(152, 360, 165, 20);
      add(choice6);
      choice6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==6 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==6 && !isFill2){
					isFill1=true;
				}
				fillChoices(6);
				choice7.enable();
			}
		});
      choice7 = new Choice();
      choice7.setBounds(152, 385, 165, 20);
      add(choice7);
      choice7.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==7 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==7 && !isFill2){
					isFill1=true;
				}
				fillChoices(7);
				choice8.enable();
			}
		});
      choice8 = new Choice();
      choice8.setBounds(152, 410, 165, 20);
      add(choice8);
      choice8.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==8 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==8 && !isFill2){
					isFill1=true;
				}
				fillChoices(8);
				choice9.enable();
			}
		});
      choice9 = new Choice();
      choice9.setBounds(152, 436, 165, 20);
      add(choice9);
      choice9.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner.getValue()==9 && isFill2) {
					isFill1=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner.getValue()==9 && !isFill2){
					isFill1=true;
				}
				fillChoices(9);
			}
		});
      
      final  JLabel lblSensorType1 = new JLabel("Sensor type 6");
      lblSensorType1.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType1.setBounds(30, 366, 95, 14);
      add(lblSensorType1);
      
      final JLabel lblSensorType2 = new JLabel("Sensor type 7");
      lblSensorType2.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType2.setBounds(30, 391, 95, 14);
      add(lblSensorType2);
      
      final JLabel lblSensorType3 = new JLabel("Sensor type 8");
      lblSensorType3.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType3.setBounds(30, 416, 95, 14);
      add(lblSensorType3);
      
      final JLabel lblSensorType4 = new JLabel("Sensor type 9");
      lblSensorType4.setHorizontalAlignment(SwingConstants.RIGHT);
      lblSensorType4.setBounds(28, 442, 95, 14);
      add(lblSensorType4);
      
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		choice5.setVisible(false);
		choice6.setVisible(false);
		choice7.setVisible(false);
		choice8.setVisible(false);
		choice9.setVisible(false);
		
		lblSensorType1.setVisible(false);
		lblSensorType2.setVisible(false);
		lblSensorType3.setVisible(false);
		lblSensorType4.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		
		lblSensorType.setVisible(false);
		separator2.setVisible(false);
		
		
		

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
	  		String dateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
	  		Date dateString1 = (Date) datePicker1.getModel().getValue();
	  		String dateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dateStart;
			Date dateEnd;
			Date dateNow;
	        String now=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	        
				try {
					dateStart = sdf.parse(dateFrom);
					dateEnd = sdf.parse(dateTo);
				    dateNow = sdf.parse(now);
				   
      	    if( dateStart.compareTo(dateEnd) < 0) {
      	    	date1Beforedate2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "Time interval from (one graph) is before 'Time interval to'");
      	    	}
      	    if(dateStart.compareTo(dateNow) < 0){
    	    	inFuture1=true;
    	    }else{
    	    	JOptionPane.showMessageDialog(null, "Time interval from (one graph) is in the future");
    	    }
      	    if(dateEnd.compareTo(dateNow) < 0){
      	    	inFuture2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "Time interval to (one graph) is  in the future");

      	    }
			} catch (ParseException e) {
				
					LOGGER.log( Level.SEVERE, "context", e );
				
				}
			
      		}
      		
      		if(date1Beforedate2 && inFuture1 && inFuture2){
      		
      		choice1.enable();
      		choice2.disable();
      		choice3.disable();
      		choice4.disable();
      		choice5.disable();
      		choice6.disable();
      		choice7.disable();
      		choice8.disable();
      		choice9.disable();
      		
      		choice1.removeAll();
      		choice2.removeAll();
      		choice3.removeAll();
      		choice4.removeAll();
      		choice5.removeAll();
      		choice6.removeAll();
      		choice7.removeAll();
      		choice8.removeAll();
      		choice9.removeAll();
      		
      		 btnGenerateGraphs.setVisible(false);
      		 
      		int value = (Integer) spinner.getValue();
			
			
			
			if(value == 1){
				choice1.setVisible(true);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
			
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				lblSensorType1.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				
				label1.setVisible(true);
				label2.setVisible(false);
				label3.setVisible(false);
				label4.setVisible(false);
				label5.setVisible(false);
			
			}else if(value == 2){
				
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(false);
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(false);
				label4.setVisible(false);
				label5.setVisible(false);
			}else if(value == 3){
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(false);
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(false);
				label5.setVisible(false);

			}else if(value == 4){
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(true);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(false);
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				
				
				lblSensorType.setVisible(false);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(true);
				label5.setVisible(false);
			}else if(value == 5){
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(true);
				choice5.setVisible(true);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(false);
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(true);
				label5.setVisible(true);
			}else if(value == 6){
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(true);
				choice5.setVisible(true);
				choice6.setVisible(true);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(true);
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
			
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(true);
				label5.setVisible(true);

			}else if(value == 7){
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(true);
				choice5.setVisible(true);
				choice6.setVisible(true);
				choice7.setVisible(true);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(true);
				lblSensorType2.setVisible(true);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(true);
				label5.setVisible(true);
			}else if(value == 8){
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(true);
				choice5.setVisible(true);
				choice6.setVisible(true);
				choice7.setVisible(true);
				choice8.setVisible(true);
				choice9.setVisible(false);
				
				lblSensorType1.setVisible(true);
				lblSensorType2.setVisible(true);
				lblSensorType3.setVisible(true);
				lblSensorType4.setVisible(false);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(true);
				label5.setVisible(true);

			}else{
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice3.setVisible(true);
				choice4.setVisible(true);
				choice5.setVisible(true);
				choice6.setVisible(true);
				choice7.setVisible(true);
				choice8.setVisible(true);
				choice9.setVisible(true);
				
				lblSensorType1.setVisible(true);
				lblSensorType2.setVisible(true);
				lblSensorType3.setVisible(true);
				lblSensorType4.setVisible(true);
				
				
				lblSensorType.setVisible(true);
				separator2.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);
				label4.setVisible(true);
				label5.setVisible(true);

			}
			
    
		      for (int i=0; i<listDevice.size(); i++){
			    	 choice1.add(listDevice.get(i).getName() );
			    	
		      }
      	}else{
      			choice1.setVisible(false);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
				choice5.setVisible(false);
				choice6.setVisible(false);
				choice7.setVisible(false);
				choice8.setVisible(false);
				choice9.setVisible(false);
				
			
				lblSensorType2.setVisible(false);
				lblSensorType3.setVisible(false);
				lblSensorType4.setVisible(false);
				lblSensorType1.setVisible(false);
				
				
				lblSensorType.setVisible(false);
				separator2.setVisible(false);
				
				label1.setVisible(false);
				label2.setVisible(false);
				label3.setVisible(false);
				label4.setVisible(false);
				label5.setVisible(false);
      		}
      	}
      });
		
      
 
 
      
      
      btnProcess.setBounds(181, 165, 136, 23);
      add(btnProcess);
      
      final  Label label12 = new Label("Sensor type 1");
      label12.setBounds(376, 241, 83, 14);
      label12.setVisible(false);
      add(label12);
      
      choice11 = new Choice();
     choice11.setVisible(false);
      choice11.setBounds(464, 235, 165, 20);
      add(choice11);
      choice11.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==1 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==1 && !isFill1){
					isFill2=true;
				}
				fillChoices1(1);
				choice12.enable();
			}
		});
      
      final Label label13 = new Label("Sensor type 2");
      label13.setBounds(376, 266, 83, 14);
      label13.setVisible(false);
      add(label13);
      
      final  Label label14 = new Label("Sensor type 3");
      label14.setBounds(376, 291, 83, 14);
      label14.setVisible(false);
      add(label14);
      
      final  Label label15 = new Label("Sensor type 4");
      label15.setBounds(376, 316, 83, 14);
      label15.setVisible(false);
      add(label15);
      
      final  Label label16 = new Label("Sensor type 5");
      label16.setBounds(376, 341, 83, 14);
      label16.setVisible(false);
      add(label16);
      
      final  Label label17 = new Label("Sensor type 6");
      label17.setBounds(376, 366, 83, 14);
      label17.setVisible(false);
      add(label17);
      
      final Label label18 = new Label("Sensor type 7");
      label18.setBounds(376, 391, 83, 14);
      label18.setVisible(false);
      add(label18);
      
      final Label label19 = new Label("Sensor type 8");
      label19.setVisible(false);
      label19.setBounds(376, 416, 83, 14);
      add(label19);
      
      final Label label20 = new Label("Sensor type 9");
    
      label20.setBounds(376, 442, 83, 14);
      label20.setVisible(false);
      add(label20);
      
      choice12 = new Choice();
      choice12.setBounds(464, 260, 165, 20);
      choice12.setVisible(false);
      add(choice12);
      choice12.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==2 && isFill1) {
					btnGenerateGraphs.setVisible(true);
					isFill2=true;
				}
				if((Integer) spinner2.getValue()==2 && !isFill1){
					isFill2=true;
				}
				fillChoices1(2);
				choice13.enable();
			}
		});
      choice13 = new Choice();
      choice13.setBounds(464, 285, 165, 20);
      choice13.setVisible(false);
      add(choice13);
      choice13.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==3 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==3 && !isFill1){
					isFill2=true;
				}
				fillChoices1(3);
				choice14.enable();
			}
		});
      choice14 = new Choice();
      choice14.setBounds(464, 310, 165, 20);
      choice14.setVisible(false);
      add(choice14);
      choice14.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==4 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==4 && !isFill1){
					isFill2=true;
				}
				fillChoices1(4);
				choice15.enable();
			}
		});
      choice15 = new Choice();
      choice15.setBounds(464, 335, 165, 20);
      choice15.setVisible(false);
      add(choice15);
      choice15.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==5 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==5 && !isFill1){
					isFill2=true;
				}
				fillChoices1(5);
				choice16.enable();
			}
		});
      choice16 = new Choice();
      choice16.setBounds(464, 360, 165, 20);
      choice16.setVisible(false);
      add(choice16);
      choice16.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==6 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==6 && !isFill1){
					isFill2=true;
				}
				fillChoices1(6);
				choice17.enable();
			}
		});
      
      choice17 = new Choice();
      choice17.setBounds(464, 385, 165, 20);
      choice17.setVisible(false);
      add(choice17);
      choice17.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==7 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==7 && !isFill1){
					isFill2=true;
				}
				fillChoices1(7);
				choice18.enable();
			}
		});
      
      choice18 = new Choice();
      choice18.setBounds(464, 410, 165, 20);
      choice18.setVisible(false);
      add(choice18);
      choice18.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==8 && isFill1) {
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==8 && !isFill1){
					isFill2=true;
				}
				fillChoices1(8);
				choice19.enable();
			}
		});
      
      choice19 = new Choice();
      choice19.setBounds(464, 436, 165, 20);
      choice19.setVisible(false);
      add(choice19);
      choice19.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if((Integer) spinner2.getValue()==9 && isFill1){
					isFill2=true;
					btnGenerateGraphs.setVisible(true);
				}
				if((Integer) spinner2.getValue()==9 && !isFill1){
					isFill2=true;
				}
				fillChoices1(9);
			}
		});

      
      btnGenerateGraphs.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
      	
          	if("Line".equals(choice.getSelectedItem()) && "Bar".equals(choice10.getSelectedItem()))	{
          		//na lijevoj strani prikaz line, na desnoj prikaz bar
          		oneLineGraphShow1();
          		oneBarGraphShow2();
          	
          	}
      		
      		if("Line".equals(choice.getSelectedItem()) && "Line".equals(choice10.getSelectedItem())){
      			//i lijevo i desno line
      			oneLineGraphShow1();
          		oneLineGraphShow2();
      		}
      		
      		if("Bar".equals(choice.getSelectedItem()) && "Line".equals(choice10.getSelectedItem())){
      			//lijevo bar, desno line
      			oneBarGraphShow1();
          		oneLineGraphShow2();
      			
      		}
      		
      		if("Bar".equals(choice.getSelectedItem()) && "Bar".equals(choice10.getSelectedItem())){
      			//lijevo i desno bar
      			oneBarGraphShow1();
          		oneBarGraphShow2();
      			
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
      
      final JSeparator separator3 = new JSeparator();
      separator3.setBounds(356, 226, 273, 16);
      separator3.setVisible(false);
      add(separator3);
      

      JSeparator separator4 = new JSeparator();
 
      separator4.setBounds(622, 30, -273, 15);
      add(separator4);
      
      
      final JLabel label6 = new JLabel("Graph type");
      label6.setHorizontalAlignment(SwingConstants.RIGHT);
      label6.setBounds(373, 57, 68, 14);
      add(label6);
      
      choice10 = new Choice();
      choice10.setBounds(464, 51, 165, 20);
      choice10.add("Line");
      choice10.add("Bar");
      add(choice10);
      
      final JLabel label7 = new JLabel("Time interval from");
      label7.setVerticalAlignment(SwingConstants.BOTTOM);
      label7.setHorizontalAlignment(SwingConstants.RIGHT);
      label7.setBounds(327, 85, 113, 14);
      add(label7);
      
      JLabel label8 = new JLabel("Time interval to");
      label8.setHorizontalAlignment(SwingConstants.RIGHT);
      label8.setBounds(348, 114, 93, 14);
      add(label8);
      
      JLabel label9 = new JLabel("Data number");
      label9.setHorizontalAlignment(SwingConstants.RIGHT);
      label9.setBounds(358, 139, 83, 14);
      add(label9);
      

      
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
	  		String dateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
	  		Date dateString1 = (Date) datePicker3.getModel().getValue();
	  		String dateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dateStart;
			Date dateEnd;
			Date dateNow;
	        String now=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	        
				try {
					dateStart = sdf.parse(dateFrom);
					dateEnd = sdf.parse(dateTo);
				    dateNow = sdf.parse(now);
				   
      	    if( dateStart.compareTo(dateEnd) < 0) {
      	    	date1Beforedate2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "Time interval from (two graph) is before 'Time interval to'");
      	    	}
      	    if(dateStart.compareTo(dateNow) < 0){
    	    	inFuture1=true;
    	    }else{
    	    	JOptionPane.showMessageDialog(null, "Time interval from (two graph) is in the future");
    	    }
      	    if(dateEnd.compareTo(dateNow) < 0){
      	    	inFuture2=true;
      	    }else{
      	    	JOptionPane.showMessageDialog(null, "Time interval to (one graph) is  in the future");

      	    }
			} catch (ParseException e) {
				
				
				LOGGER.log( Level.SEVERE, "context", e );
				}
			
      		}
      		
      		if(date1Beforedate2 && inFuture1 && inFuture2){
      		
      		// KOD ZA DRUGI GRAF
      			
      		choice11.enable();
      		choice12.disable();
      		choice13.disable();
      		choice14.disable();
      		choice15.disable();
      		choice16.disable();
      		choice17.disable();
      		choice18.disable();
      		choice19.disable();
      		
      		choice11.removeAll();
      		choice12.removeAll();
      		choice13.removeAll();
      		choice14.removeAll();
      		choice15.removeAll();
      		choice16.removeAll();
      		choice17.removeAll();
      		choice18.removeAll();
      		choice19.removeAll();
      		
      		btnGenerateGraphs.setVisible(false);
      		
      	  int valueSecondGraph = (Integer) spinner2.getValue();
      		
      		
      		
			
			 if(valueSecondGraph == 1){
				choice11.setVisible(true);
				choice12.setVisible(false);
				choice13.setVisible(false);
				choice14.setVisible(false);
				choice15.setVisible(false);
				choice16.setVisible(false);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
				
				label12.setVisible(true);
				label13.setVisible(false);
				label14.setVisible(false);
				label15.setVisible(false);
				label16.setVisible(false);
				label17.setVisible(false);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
				
				
				
				
			}else if(valueSecondGraph == 2){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(false);
				choice14.setVisible(false);
				choice15.setVisible(false);
				choice16.setVisible(false);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
		
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(false);
				label15.setVisible(false);
				label16.setVisible(false);
				label17.setVisible(false);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
			
				
			}else if(valueSecondGraph == 3){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(false);
				choice15.setVisible(false);
				choice16.setVisible(false);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
		
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(false);
				label16.setVisible(false);
				label17.setVisible(false);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
				
			
			}else if(valueSecondGraph == 4){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(true);
				choice15.setVisible(false);
				choice16.setVisible(false);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(true);
				label16.setVisible(false);
				label17.setVisible(false);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
			
				
			}else if(valueSecondGraph == 5){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(true);
				choice15.setVisible(true);
				choice16.setVisible(false);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
		
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(true);
				label16.setVisible(true);
				label17.setVisible(false);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
				
			
			}else if(valueSecondGraph == 6){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(true);
				choice15.setVisible(true);
				choice16.setVisible(true);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
		
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(true);
				label16.setVisible(true);
				label17.setVisible(true);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
				
			
			}else if(valueSecondGraph == 7){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(true);
				choice15.setVisible(true);
				choice16.setVisible(true);
				choice17.setVisible(true);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
		
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(true);
				label16.setVisible(true);
				label17.setVisible(true);
				label18.setVisible(true);
				label19.setVisible(false);
				label20.setVisible(false);
				
			
			}else if(valueSecondGraph == 8){
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(true);
				choice15.setVisible(true);
				choice16.setVisible(true);
				choice17.setVisible(true);
				choice18.setVisible(true);
				choice19.setVisible(false);
				
				
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(true);
				label16.setVisible(true);
				label17.setVisible(true);
				label18.setVisible(true);
				label19.setVisible(true);
				label20.setVisible(false);
				
				
			}else{
				choice11.setVisible(true);
				choice12.setVisible(true);
				choice13.setVisible(true);
				choice14.setVisible(true);
				choice15.setVisible(true);
				choice16.setVisible(true);
				choice17.setVisible(true);
				choice18.setVisible(true);
				choice19.setVisible(true);
				
				
				label12.setVisible(true);
				label13.setVisible(true);
				label14.setVisible(true);
				label15.setVisible(true);
				label16.setVisible(true);
				label17.setVisible(true);
				label18.setVisible(true);
				label19.setVisible(true);
				label20.setVisible(true);
				
				
			}
      		
      		
      		for (int i=0; i<listDevice.size(); i++){
		    	 choice11.add(listDevice.get(i).getName() );
		    	}
      		
	      }else{
	    	  choice11.setVisible(false);
				choice12.setVisible(false);
				choice13.setVisible(false);
				choice14.setVisible(false);
				choice15.setVisible(false);
				choice16.setVisible(false);
				choice17.setVisible(false);
				choice18.setVisible(false);
				choice19.setVisible(false);
				
				
				label12.setVisible(false);
				label13.setVisible(false);
				label14.setVisible(false);
				label15.setVisible(false);
				label16.setVisible(false);
				label17.setVisible(false);
				label18.setVisible(false);
				label19.setVisible(false);
				label20.setVisible(false);
	      }
     }
  });
      button.setBounds(493, 165, 136, 23);
      add(button);
      
      spinner2 = new JSpinner();
      spinner2.setModel(new SpinnerNumberModel(1, 1, 9, 1));
      spinner2.setBounds(464, 136, 165, 18);
      add(spinner2);
	}
      
     
      
      //-------------------------------------------------------------------------------

	
	
	public void  oneLineGraphShow1(){
		

		Integer value = (Integer) spinner.getValue();
		boolean have1=false;
	
				//Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker.getModel().getValue();
			  		String dateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker1.getModel().getValue();
			  		String dateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date dateStart;
					Date dateEnd;
					
					  try {
						dateStart = sdf.parse(dateFrom);
						dateEnd = sdf.parse(dateTo);
						 

						try {
						
							
							choices=new ArrayList<Choice>();
							choices.add(choice1);
							choices.add(choice2);
							choices.add(choice3);
							choices.add(choice4);
							choices.add(choice5);
							choices.add(choice6);
							choices.add(choice7);
							choices.add(choice8);
							choices.add(choice9);	
							listLogs=new ArrayList<List<EventLogs>>();
							for(int i=0;i<value;i++){
								
						  listLogs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),dateStart,dateEnd));
				
							}
							listLogs.size();
							listValues=new ArrayList<List<Double>>();
							for(int i=0; i<listLogs.size();i++){
								
								List<Double>values=new ArrayList<Double>();
								for(int j=0;j<listLogs.get(i).size();j++){
									
								values.add(listLogs.get(i).get(j).getValue());
								
								}
								listValues.add(values);
								}
							for(int i=0; i<listLogs.size();i++){
								if(!listLogs.get(i).isEmpty()){
									have1=true;
								}
							}
							}catch(Exception e){
								 System.out.println("Ne poklapaju se vrijednosti");
							}
						}catch (Exception e1) {
							
								LOGGER.log( Level.SEVERE, "context", e1 );
						}
						
						datas=new ArrayList<DataTable>();
						 series=new ArrayList<DataSeries>();
					  
					  for(int i=0;i<listLogs.size();i++){
						  DataTable d=new DataTable(Long.class, Double.class, String.class);
						  
						  for(int j=0;j<listLogs.get(i).size();j++){
							  d.add(listLogs.get(i).get(j).getTimestamp().getTime(), listValues.get(i).get(j), listLogs.get(i).get(j).getDevice_name());
						  }
						
						  datas.add(d);
						  
					  }
					  
					  for(int i=0;i<datas.size();i++){
						  series.add(new DataSeries(datas.get(i)));
					  }
			
				
	if(have1){	 
	      switch(value)
	      {
	      case 1:
	      {
		XYPlot plot = new XYPlot(series.get(0));
	
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
	
	
	
	public void  oneLineGraphShow2(){
		

		Integer value = (Integer) spinner2.getValue();
		boolean have2=false;

							 
				    //Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker2.getModel().getValue();
			  		String dateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker3.getModel().getValue();
			  		String dateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date dateStart;
					Date dateEnd;
					
					  try {
						dateStart = sdf.parse(dateFrom);
						dateEnd = sdf.parse(dateTo);
						 

						try {
						
							
							choices2=new ArrayList<Choice>();
							choices2.add(choice11);
							choices2.add(choice12);
							choices2.add(choice13);
							choices2.add(choice14);
							choices2.add(choice15);
							choices2.add(choice16);
							choices2.add(choice17);
							choices2.add(choice18);
							choices2.add(choice19);	
						

							listLogs2=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  listLogs2.add(new HibernateEventLogs().getdatesbetween(choices2.get(i).getSelectedItem(),dateStart,dateEnd));//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),dateStart,dateEnd)); //lista eventlogova ciji su datumi izmedu unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						listLogs2.size();
						listValues2=new ArrayList<List<Double>>();
						for(int i=0; i<listLogs2.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<listLogs2.get(i).size();j++){
								
							values.add(listLogs2.get(i).get(j).getValue());//add(listLogs.get(i).get(j).getValue());           //Ovo ÄŤemo stavljati na graf valjda :D
							
							}
							listValues2.add(values);
							}
						for(int i=0; i<listLogs2.size();i++){
							if(listLogs2.get(i).size()!=0){
								have2=true;
							}
						}
						}catch(Exception e){
							 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							System.out.println("Ne poklapaju se vrijednosti");
						}
					}catch (Exception e1) {
						
							LOGGER.log( Level.SEVERE, "context", e1 );
					}
					
					  datas2=new ArrayList<DataTable>();
						 series2=new ArrayList<DataSeries>();
						  
						  
						  for(int i=0;i<listLogs2.size();i++){
							  DataTable d=new DataTable(Long.class, Double.class, String.class);
							  
							  for(int j=0;j<listLogs2.get(i).size();j++){
								  d.add(listLogs2.get(i).get(j).getTimestamp().getTime(), listValues2.get(i).get(j), listLogs2.get(i).get(j).getDevice_name());
							  }
							
							  datas2.add(d);
							  
						  }
						  
						  for(int i=0;i<datas2.size();i++){
							  series2.add(new DataSeries(datas2.get(i)));
						  }
				

		if(have2){ 
	      switch(value)
	      {
	      case 1:
	      {
		XYPlot plot = new XYPlot(series2.get(0));
		plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	

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
     
    
       		  
         plot.getTitle().setText("Line plot: "+device+"(green)");
	         
	         interactivePanel1 = new InteractivePanel(plot);
	         
	         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400)); 
	         
	          contentPane = new JPanel();
	       
				contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

		         interactivePanel1.setLayout(null);			
				 tabbedPane.addTab("Two graphs", contentPane);
				 contentPane.setVisible(true);
				contentPane.add(interactivePanel);
	
			         
			     	contentPane.add(interactivePanel1);
			     	interactivePanel1.setLayout(null);
			
				contentPane.setLayout(null);
				tabbedPane.setSelectedIndex(1);
	         
		break;
	      }
	      case 2:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	 

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
				
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					   
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					     
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  	

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
					
					
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					     
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	    	  
	      }
	    	  
	      
	      case 5:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  	

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
					
					
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					       
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 6:
	      {
	    	  
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  	
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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					      
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 7:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5), series2.get(6));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  	

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					     
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	    	 
	      }
	      
	      
	      case 8:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5), series2.get(6), series2.get(7));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					   
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  XYPlot plot = new XYPlot(series2.get(0), series2.get(1), series2.get(2), series2.get(3), series2.get(4), series2.get(5), series2.get(6), series2.get(7), series2.get(8));
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  	

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					 
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
		
			tabbedPane.remove(0);
			TwoGraphsViewPanel twoGraphs= new TwoGraphsViewPanel(tabbedPane);
			tabbedPane.add("Two graphs",twoGraphs);
			twoGraphs.setLayout(null);
		
			tabbedPane.setSelectedIndex(1);
			
				}
			});
		
	}
	
	
	
	
	
	//-----kod za lijevi bar ---------------------------------------------------------------------//
	
	
	
	public void  oneBarGraphShow1(){
		
		Integer value = (Integer) spinner.getValue();
		
		for(int k=0; k<value; k++){
							 
				//Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker.getModel().getValue();
			  		String dateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker1.getModel().getValue();
			  		String dateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date dateStart;
					Date dateEnd;
					
					  try {
						dateStart = sdf.parse(dateFrom);
						dateEnd = sdf.parse(dateTo);
						 

						try {
						
							
							List<Choice> choices=new ArrayList<Choice>();
							choices.add(choice1);
							choices.add(choice2);
							choices.add(choice3);
							choices.add(choice4);
							choices.add(choice5);
							choices.add(choice6);
							choices.add(choice7);
							choices.add(choice8);
							choices.add(choice9);	
							
							listLogs=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  listLogs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),dateStart,dateEnd));//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),dateStart,dateEnd)); //lista eventlogova ciji su datumi izmedu unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
					 
						}
						listLogs.size();
						listValues=new ArrayList<List<Double>>();
						for(int i=0; i<listLogs.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<listLogs.get(i).size();j++){
								
							values.add(listLogs.get(i).get(j).getValue());//add(listLogs.get(i).get(j).getValue());           //Ovo Ă„Ĺ¤emo stavljati na graf valjda :D
							
							}
							listValues.add(values);
							
							 
						}
						}catch(Exception e){
							 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							System.out.println("Ne poklapaju se vrijednosti");
						}
					}catch (Exception e1) {
					
						 final JLabel lblExport= new JLabel("To export graph, make right click, and choose Export Image.");
							LOGGER.log( Level.SEVERE, "context", e1 );
					}
					
					datas=new ArrayList<DataTable>();
					 series=new ArrayList<DataSeries>();
					  DataTable d=new DataTable(Long.class, Double.class, String.class);
					 
					  
					  for(int i=0;i<listLogs.size();i++){
						  
						  for(int j=0;j<listLogs.get(i).size();j++){
							
							d.add(listLogs.get(i).get(j).getTimestamp().getTime(), listValues.get(i).get(j), listLogs.get(i).get(j).getDevice_name());
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
	     

	       
	          interactivePanel.setVisible(true);
	          
	  
	         
		break;
	      }
	      case 2:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 40.0, 40.0, 0));
	  	

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
	
		   
		
	}
	
	
	
	//Kod za prikaz desno barplota 
	
	public void  oneBarGraphShow2(){
		
		Integer value = (Integer) spinner.getValue();
		
		for(int k=0; k<value; k++){
							 
				    //Podaci koji ce se prikazivati na grafu 
					Date dateString = (Date) datePicker2.getModel().getValue();
			  		String dateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
			  		Date dateString1 = (Date) datePicker3.getModel().getValue();
			  		String dateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date dateStart;
					Date dateEnd;
					
					  try {
						dateStart = sdf.parse(dateFrom);
						dateEnd = sdf.parse(dateTo);
						 

						try {
						
							
							List<Choice> choices=new ArrayList<Choice>();
							choices.add(choice11);
							choices.add(choice12);
							choices.add(choice13);
							choices.add(choice14);
							choices.add(choice15);
							choices.add(choice16);
							choices.add(choice17);
							choices.add(choice18);
							choices.add(choice19);	
						 value = (Integer) spinner2.getValue();

							listLogs=new ArrayList<List<EventLogs>>();
						for(int i=0;i<value;i++){
							
					  listLogs.add(new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),dateStart,dateEnd));
					 
						}
						listLogs.size();
						listValues=new ArrayList<List<Double>>();
						for(int i=0; i<listLogs.size();i++){
							
							List<Double>values=new ArrayList<Double>();
							for(int j=0;j<listLogs.get(i).size();j++){
								
							values.add(listLogs.get(i).get(j).getValue());
							
							}
							listValues.add(values);
							
							 
						}
						}catch(Exception e){
							 System.out.println("Ne poklapaju se vrijednosti");
						}
					}catch (Exception e1) {
					
						 LOGGER.log( Level.SEVERE, "context", e1 );
					}
					
					datas=new ArrayList<DataTable>();
					 series=new ArrayList<DataSeries>();
					  DataTable d=new DataTable(Long.class, Double.class, String.class);
					 
					  
					  for(int i=0;i<listLogs.size();i++){
						  
						  for(int j=0;j<listLogs.get(i).size();j++){
							
							d.add(listLogs.get(i).get(j).getTimestamp().getTime(), listValues.get(i).get(j), listLogs.get(i).get(j).getDevice_name());
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
	         
	   
	         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 400)); 
	         
	          contentPane = new JPanel();
	       
				contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
			
	
		         interactivePanel1.setLayout(null);			
				 tabbedPane.addTab("Two graphs", contentPane);
				 contentPane.setVisible(true);
				contentPane.add(interactivePanel);
			
			         
			     	contentPane.add(interactivePanel1);
			     	interactivePanel1.setLayout(null);
			     
				contentPane.setLayout(null);
				tabbedPane.setSelectedIndex(1);
	         
		break;
	      }
	      case 2:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  	

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					    
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 3:
	    	  
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	  	
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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					     
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break;
	      }
	      
	      case 4:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		
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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					     
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	    	  
	      }
	    	  
	      
	      case 5:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		
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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					   
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 6:
	      {
	    	  
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		

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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					       
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
		          break;
	      }
	      
	      case 7:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		

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
					
					
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
						
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					      
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	    	 
	      }
	      
	      
	      case 8:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  		
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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					      
						contentPane.setLayout(null);
						tabbedPane.setSelectedIndex(1);
			     
			     break; 
	      }
	      
	      case 9:
	      {
	    	  final BarPlot plot= new BarPlot(series.get(0), series.get(1), series.get(2), series.get(3), series.get(4), series.get(5), series.get(6), series.get(7), series.get(8) );
	    	  plot.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
		  	
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
					
				
				         interactivePanel1.setLayout(null);			
						 tabbedPane.addTab("Two graphs", contentPane);
						 contentPane.setVisible(true);
						contentPane.add(interactivePanel);
					
					         
					     	contentPane.add(interactivePanel1);
					     	interactivePanel1.setLayout(null);
					     
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
			for(int i=0; i<listDevice.size();i++){
			if(choice1.getSelectedItem() == listDevice.get(i).getName()){
				continue;
			}
			choice2.add(listDevice.get(i).getName());
			}
			choice1.disable();
			break;
			
		}
		case 2 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice3.add(listDevice.get(i).getName());
				}
				choice2.disable();
				break;
		}
		case 3 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())||(choice3.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice4.add(listDevice.get(i).getName());
				}
				choice3.disable();
				break;
		}
		case 4 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())||(choice3.getSelectedItem() == listDevice.get(i).getName())||
						(choice4.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice5.add(listDevice.get(i).getName());
				}
				choice4.disable();
				break;
		}
		case 5 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())||(choice3.getSelectedItem() == listDevice.get(i).getName())||
						(choice4.getSelectedItem() == listDevice.get(i).getName())||(choice5.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice6.add(listDevice.get(i).getName());
				}
				choice5.disable();
				break;
		}
		case 6 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())||(choice3.getSelectedItem() == listDevice.get(i).getName())||
						(choice4.getSelectedItem() == listDevice.get(i).getName())||(choice5.getSelectedItem() == listDevice.get(i).getName())||(choice6.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice7.add(listDevice.get(i).getName());
				}
				choice6.disable();
				break;
		}
		case 7 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())||(choice3.getSelectedItem() == listDevice.get(i).getName())||
				   (choice4.getSelectedItem() == listDevice.get(i).getName())||(choice5.getSelectedItem() == listDevice.get(i).getName())||(choice6.getSelectedItem() == listDevice.get(i).getName())||
				   (choice7.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice8.add(listDevice.get(i).getName());
				}
				choice7.disable();
				break;
		}
		case 8 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice1.getSelectedItem() == listDevice.get(i).getName()) || (choice2.getSelectedItem() == listDevice.get(i).getName())||(choice3.getSelectedItem() == listDevice.get(i).getName())||
				   (choice4.getSelectedItem() == listDevice.get(i).getName())||(choice5.getSelectedItem() == listDevice.get(i).getName())||(choice6.getSelectedItem() == listDevice.get(i).getName())||
				   (choice7.getSelectedItem() == listDevice.get(i).getName())||(choice8.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice9.add(listDevice.get(i).getName());
				}
				choice8.disable();
				break;
		}
		case 9 : {
			choice9.disable();
			
		}	
	}
		
	}
	public void fillChoices1(int k){
		switch(k){
		case 1 : {
			for(int i=0; i<listDevice.size();i++){
			if(choice11.getSelectedItem() == listDevice.get(i).getName()){
				continue;
			}
			choice12.add(listDevice.get(i).getName());
			}
			choice11.disable();
			break;
			
		}
		case 2 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice13.add(listDevice.get(i).getName());
				}
				choice12.disable();
				break;
		}
		case 3 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())||(choice13.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice14.add(listDevice.get(i).getName());
				}
				choice13.disable();
				break;
		}
		case 4 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())||(choice13.getSelectedItem() == listDevice.get(i).getName())||
						(choice14.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice15.add(listDevice.get(i).getName());
				}
				choice14.disable();
				break;
		}
		case 5 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())||(choice13.getSelectedItem() == listDevice.get(i).getName())||
						(choice14.getSelectedItem() == listDevice.get(i).getName())||(choice15.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice16.add(listDevice.get(i).getName());
				}
				choice15.disable();
				break;
		}
		case 6 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())||(choice13.getSelectedItem() == listDevice.get(i).getName())||
						(choice14.getSelectedItem() == listDevice.get(i).getName())||(choice15.getSelectedItem() == listDevice.get(i).getName())||(choice16.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice17.add(listDevice.get(i).getName());
				}
				choice16.disable();
				break;
		}
		case 7 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())||(choice13.getSelectedItem() == listDevice.get(i).getName())||
				   (choice14.getSelectedItem() == listDevice.get(i).getName())||(choice15.getSelectedItem() == listDevice.get(i).getName())||(choice16.getSelectedItem() == listDevice.get(i).getName())||
				   (choice17.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice18.add(listDevice.get(i).getName());
				}
				choice17.disable();
				break;
		}
		case 8 : {
			for(int i=0; i<listDevice.size();i++){
				if((choice11.getSelectedItem() == listDevice.get(i).getName()) || (choice12.getSelectedItem() == listDevice.get(i).getName())||(choice13.getSelectedItem() == listDevice.get(i).getName())||
				   (choice14.getSelectedItem() == listDevice.get(i).getName())||(choice15.getSelectedItem() == listDevice.get(i).getName())||(choice16.getSelectedItem() == listDevice.get(i).getName())||
				   (choice17.getSelectedItem() == listDevice.get(i).getName())||(choice18.getSelectedItem() == listDevice.get(i).getName())){
					continue;
				}
				choice19.add(listDevice.get(i).getName());
				}
				choice18.disable();
				break;
		}
		case 9 : {
			choice19.disable();
			
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
      
      
