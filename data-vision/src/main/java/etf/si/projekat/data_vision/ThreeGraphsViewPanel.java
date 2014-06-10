package etf.si.projekat.data_vision;

import javax.swing.*;
import java.awt.Choice;
import java.util.logging.Logger;
import java.util.logging.Level;

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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.SystemColor;



public class ThreeGraphsViewPanel extends ExamplePanel  {

	private static final long serialVersionUID = 1L;


private static final Logger logger = Logger.getLogger(ThreeGraphsViewPanel.class.getName());
	List<DeviceName> list_device=new HibernateDeviceName().giveAllDeviceName();



		InteractivePanel interactivePanel1;
		InteractivePanel interactivePanel2;
		final JTabbedPane tabbedPane;
		private int size;
	    private List<List<EventLogs>> list_logs;
		private List<List<Double>> list_values;
		private List<DataTable> datas;
		private List<DataTable> datas1;
		private List<DataSeries>series;
		final JSpinner spinner = new JSpinner();
		 DataTable data1;
		
			XYPlot plot1;
			  private JPanel contentPane;
			  boolean paneli_bar;
			  boolean paneli_line;
			  List<EventLogs> logs;
			  List<EventLogs> logs1;
			  List<Double>values;
			  List<Double>values1;
	     final static DataTable data=new DataTable(Long.class, Double.class);


		private static final Color COLOR1 = Color.RED;
		 XYPlot plot;
		 
	
		List<Double>values2;



		 // CHOICE
		 	final Choice choice= new Choice(); 
		 	final Choice choice_1 = new Choice();
		    final Choice choice_11= new Choice();


		    InteractivePanel interactivePanel ;


		    UtilDateModel model = new UtilDateModel();
	        JDatePanelImpl datePanel = new JDatePanelImpl(model);
	        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel); 


	        UtilDateModel model1 = new UtilDateModel();
	        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
	        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);


			private int valueFirstGraph;
			private final Choice choice_12 = new Choice();


	

	
	public ThreeGraphsViewPanel(JTabbedPane tabbedPane_4) {
		tabbedPane = tabbedPane_4;
		setBackground(SystemColor.menu);


		setLayout(null);






		// Svi elemeti za dodavanje prvog grafa
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


	// SPINNER-NOT ENABLED


		SensorChoosingPanel p = new SensorChoosingPanel();




		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(152, 137, 165, 18);


		add(spinner);
		spinner.setValue((Integer)2);
		spinner.setEnabled(false);

        JLabel lblGraphType = new JLabel("Graph type");
        lblGraphType.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGraphType.setBounds(55, 60, 68, 14);
        add(lblGraphType);
       
        SpringLayout springLayout_1 = (SpringLayout) datePicker.getLayout();
        springLayout_1.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
        datePicker.setLocation(152, 75);
        datePicker.setSize(165, 29);
       add(datePicker);
        
        
       
        SpringLayout springLayout_2 = (SpringLayout) datePicker1.getLayout();
        springLayout_2.putConstraint(SpringLayout.SOUTH, datePicker1.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker1);
        datePicker1.setLocation(152, 104);
        datePicker1.setSize(165, 29);
      add(datePicker1);
      
      
      choice.setBounds(152, 51, 165, 23);
      choice.add("Line");
      choice.add("Bar");
      choice.setVisible(true);
      add(choice);
      
      Label label = new Label("Basic data");
      label.setBounds(10, 10, 65, 18);
      add(label);
      
      JSeparator separator = new JSeparator();
      separator.setBackground(SystemColor.textHighlight);
      separator.setBounds(10, 34, 306, 15);
      add(separator);
      
      final JLabel lblSensorType = new JLabel("Sensor type");
      lblSensorType.setBounds(10, 172, 77, 14);
      add(lblSensorType);
      
      final JSeparator separator_1 = new JSeparator();
      separator_1.setBounds(222, 220, -220, -5);
      separator_1.setVisible(false);
      add(separator_1);
      
      
      final JSeparator separator_2 = new JSeparator();
      separator_2.setBackground(SystemColor.textHighlight);
      separator_2.setBounds(10, 233, 618, -5);
      add(separator_2);
      
      final  JLabel label_1 = new JLabel("Sensor type 1");
      label_1.setHorizontalAlignment(SwingConstants.RIGHT);
      label_1.setBounds(28, 220, 95, 18);
      label_1.setVisible(true);
      add(label_1);
      
      choice_1.setBounds(152, 220, 165, 20);
      choice_1.setVisible(true);
      add(choice_1);
      


		lblSensorType.setVisible(false);
		separator_2.setVisible(true);




		setValueFirstGraph((Integer) spinner.getValue());
      
      final Label label_13 = new Label("Sensor type 2");
      label_13.setFont(new Font("Dialog", Font.BOLD, 11));
      label_13.setAlignment(Label.RIGHT);
      label_13.setBounds(40, 253, 83, 14);
      add(label_13);
      
      JSeparator separator_4 = new JSeparator();
      separator_4.setBounds(622, 30, -273, 15);
      add(separator_4);
      
      final  JSeparator separator_5 = new JSeparator();
      separator_5.setBackground(SystemColor.textHighlight);
      separator_5.setBounds(10, 487, 618, -10);
    
      add(separator_5);
      
      final  JSeparator separator_6 = new JSeparator();
      separator_6.setBounds(720, 220, -91, 22);
      add(separator_6);
     
      
      // GENERIRAJ AKCIJA
      		final JButton btnGenerateGraphs = new JButton("Generate graphs");
      		btnGenerateGraphs.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent arg0) {
      			}
      		});
      		btnGenerateGraphs.addMouseListener(new MouseAdapter() {
      			@Override
      			public void mouseClicked(MouseEvent arg0) {
      				choice_1.enable();
      				choice_12.enable();
      				
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
      					
      					logger.log( Level.SEVERE, "context", e );
      					}
      				
      	      		}
      	      		
      	      		if(date1Beforedate2 && inFuture1 && inFuture2){
      				
      				
      				
      				if("Line".equals(choice.getSelectedItem().toString())){
      					Graf();
      					
      				}
      				
      				else GrafBar();
      			}
      			}
      		});
      	
      		
      		
      		btnGenerateGraphs.setBackground(SystemColor.control);
      		btnGenerateGraphs.setVisible(true);
      		btnGenerateGraphs.setBounds(183, 313, 134, 23);
      		add(btnGenerateGraphs);


	      JSeparator separator_3 = new JSeparator();
	      separator_3.setBackground(SystemColor.textHighlight);
	      separator_3.setBounds(10, 199, 306, -13);
	      add(separator_3);


	      JSeparator separator_7 = new JSeparator();
	      separator_7.setBackground(SystemColor.textHighlight);
	      separator_7.setBounds(10, 299, 307, 14);
	      add(separator_7);
	      choice_12.setBounds(152, 247, 165, 20);
	      add(choice_12);


	      JSeparator separator_8 = new JSeparator();
	      separator_8.setBackground(SystemColor.textHighlight);
	      separator_8.setBounds(10, 186, 306, 15);
	      add(separator_8);




	      for (int i=0; i<list_device.size(); i++){
		    	 choice_1.add(list_device.get(i).getName() );
		    	

	    }
	      choice_1.addMouseListener(new MouseAdapter() {
	        	@Override
	          	public void mouseClicked(MouseEvent arg0) {
	        		 for (int i=0; i<list_device.size(); i++){
	        			 if(choice_1.getSelectedItem()==list_device.get(i).getName()) continue;
	        			 choice_12.add(list_device.get(i).getName() );
	                      choice_1.disable();
	        		 }
		
				}
			});
	      choice_12.addMouseListener(new MouseAdapter() {
	        	@Override
	          	public void mouseClicked(MouseEvent arg0) {
	        		
	                      choice_12.disable();
	        		 
		
				}
			});

	}
	public void Graf(){
				boolean have1=true;
				boolean have2=true;

							 
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
						
							
						logs=new ArrayList<EventLogs>();
							
							
					  logs=new HibernateEventLogs().getdatesbetween(choice_1.getSelectedItem(),date_start,date_end);//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end)); //lista eventlogova ciji su datumi između unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.

						}
						
						finally {}
						
						size=logs.size();
						if(size==0){
							have1=false;
							JOptionPane.showMessageDialog(null, "Graph one is empty");
						}
						values=new ArrayList<Double>();
						
						for(int i=0; i<logs.size();i++){
						
							values.add(logs.get(i).getValue());           
						 
						}
						
						}catch(Exception e){
							System.out.println("Ne poklapaju se vrijednosti");
						}
					
					  DataTable d=new DataTable(Long.class, Double.class, String.class);
					 
					  
					  for(int i=0;i<logs.size();i++)
					  {
						 
							
							d.add(logs.get(i).getTimestamp().getTime(), values.get(i),logs.get(i).getDevice_name());
			  }
					  
					  //two graph
					  Date dateString2 = (Date) datePicker.getModel().getValue();
				  		String date_from1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
				  		Date dateString3 = (Date) datePicker1.getModel().getValue();
				  		String date_to1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						Date date_start1;
						Date date_end1;
						
						  try {
							date_start1 = sdf1.parse(date_from1);
							date_end1 = sdf1.parse(date_to1);
							 

							try {
								date_start = sdf.parse(date_from);
								date_end = sdf.parse(date_to);
								
							logs1=new ArrayList<EventLogs>();
								
								
							
								
						  logs1=new HibernateEventLogs().getdatesbetween(choice_12.getSelectedItem(),date_start1,date_end1);//.add( new HibernateEventLogs().getdatesbetween(choices.get(i).getSelectedItem(),date_start,date_end)); //lista eventlogova ciji su datumi između unesenih u datepickere i odgovara im odgovrajuci device name u suprotnom vraca null tako da bi i to trebalo ispitati.
						 
							}
							
							finally {}
							size=logs1.size();
							if(size==0){
								have1=false;
								JOptionPane.showMessageDialog(null, "Graph two is empty");
							}
							
							  values1=new ArrayList<Double>();
							
							for(int i=0; i<logs1.size();i++){
								
					      
								
									
								values1.add(logs1.get(i).getValue());          
								
						
								
								
								 
							}
							}catch(Exception e){
								 
								System.out.println("Ne poklapaju se vrijednosti");
							}
						 
						  
						  //------------------------------
						  
						
		if(have1 && have2)	{		 
						  
		XYPlot plot = new XYPlot(d);
		plot.setInsets(new Insets2D.Double(30.0, 20.0, 40.0, 0));
		

		 plot.getTitle().setText("Line plot");
			
         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
         
        AxisRenderer rendererX = plot.getAxisRenderer(XYPlot.AXIS_X);
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         rendererX.setTickLabelFormat(dateFormat);
		  LineRenderer lines = new DefaultLineRenderer2D();
	         plot.setLineRenderer(d, lines);
	         Color color = new Color(0.0f, 0.3f, 1.0f);
	        plot.getPointRenderer(d).setColor(color);
	         plot.getLineRenderer(d).setColor(color);
	         
	         plot.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
	         
	       
	          
	          
	          
	          //-----------------------------------------------------------------------------------------------------
	          
	          
				 
				  DataTable d1=new DataTable(Long.class, Double.class, String.class);
				 
				  
				  for(int j=0;j<logs1.size();j++){
					 
						
						d1.add(logs1.get(j).getTimestamp().getTime(), values1.get(j),logs1.get(j).getDevice_name());
				  }
					
					
					 
					  
	XYPlot plot1 = new XYPlot(d1);
	plot1.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
	
	 plot1.getTitle().setText("Line plot");
		
   plot1.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
   
  AxisRenderer rendererX1 = plot1.getAxisRenderer(XYPlot.AXIS_X);
   DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   rendererX1.setTickLabelFormat(dateFormat1);
	  LineRenderer lines1 = new DefaultLineRenderer2D();
       plot1.setLineRenderer(d1, lines1);
       Color color1 = new Color(0.0f, 0.3f, 1.0f);
      plot1.getPointRenderer(d1).setColor(color1);
       plot1.getLineRenderer(d1).setColor(color1);
       
       plot1.getPlotArea().setBorderColor(new Color(0.0f, 0.3f, 1.0f));
       
       
				values2=new ArrayList<Double>();
				double vel;
				int k;
				if(logs1.get(logs1.size()-1).getTimestamp().getDate()<logs.get(logs.size()-1).getTimestamp().getDate()){
				 k=logs1.size();
				}else{
					k=logs.size();
				}
				DataTable dt=new DataTable(Double.class, Double.class);
				
				for(int i=0;i<k;i++){
					for(int j=i;j<k;j++){
						if(logs1.get(i).getTimestamp().getDate()==logs.get(j).getTimestamp().getDate()){
							dt.add(logs1.get(i).getValue(),logs.get(j).getValue());
							
							break;
							}
						}
					}
					
			
				
				
				XYPlot plot3 = new XYPlot(dt);
				

			     plot3.setVisible(dt, true);
			     plot3.setInsets(new Insets2D.Double(260.0, 200.0, 40,0));
			     

		         plot3.getTitle().setText("Combined graphs");
		         LineRenderer lines3 = new DefaultLineRenderer2D();
		         plot3.setLineRenderer(dt, lines3);
		         Color color3 = new Color(0.0f, 0.3f, 1.0f);
		         plot3.getPointRenderer(dt).setColor(color3);
		         plot3.getLineRenderer(dt).setColor(color3);
		     
		         plot3.getAxisRenderer(XYPlot.AXIS_X).setTickSpacing(1.0);
		     
		         plot3.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
		         
				
				
				
			         
			         interactivePanel = new InteractivePanel(plot);
			         
			        
			         interactivePanel.setBounds(new Rectangle(0, 0, 440, 230));
			     
					
			          interactivePanel2 = new InteractivePanel(plot3);
				         
				       
				         interactivePanel2.setBounds(new Rectangle(0,0, 540,500));
				      
						
			          

				          interactivePanel1 = new InteractivePanel(plot1);
				          
				         
				          interactivePanel1.setBounds(new Rectangle(0, 0, 950, 230));
				     
			          
			          contentPane = new JPanel();
				       
			          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
			 			
			 		
			 		        
			 				 tabbedPane.addTab("Three graphs", contentPane);
			 				 contentPane.setVisible(true);
			 				contentPane.add(interactivePanel);
			 				
			 			     contentPane.add(interactivePanel1);
			 			    contentPane.add(interactivePanel2);
			 			     	
			 			     	 interactivePanel.setLayout(null);	
			 				     interactivePanel1.setLayout(null);
			 				    interactivePanel2.setLayout(null);
			 			     	
			 				contentPane.setLayout(null);
			 				tabbedPane.setSelectedIndex(1);
			  
			 				
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
			 				   ThreeGraphsViewPanel threeGraphs= new ThreeGraphsViewPanel(tabbedPane);
			 					tabbedPane.add("Three graphs",threeGraphs);
			 					threeGraphs.setLayout(null);
			 				    
			 					tabbedPane.setSelectedIndex(0);
			 						}
			 					});		
			 				
		
		}		
			 				
	}
		 

		void GrafBar(){
			
			boolean have1=true;
			boolean have2=true;

		      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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
				
				
					
				
					
					
					
			  logs=new HibernateEventLogs().getdatesbetween(choice_1.getSelectedItem(),date_start,date_end);
			  
				}
				
				finally {}

				
				size=logs.size();
				if(size==0){
					have1=false;
					JOptionPane.showMessageDialog(null, "Graph one is empty");
				}
				values=new ArrayList<Double>();
				
				for(int i=0; i<logs.size();i++){
				
					values.add(logs.get(i).getValue());           
				 
				}
				
				}catch(Exception e){
					System.out.println("Ne poklapaju se vrijednosti");
				}
			  
			  
			  //two graph
			  
			  Date dateString2 = (Date) datePicker.getModel().getValue();
		  		String date_from1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString);
		  		Date dateString3 = (Date) datePicker1.getModel().getValue();
		  		String date_to1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateString1);	
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date date_start1;
				Date date_end1;
				
				  try {
					date_start1 = sdf1.parse(date_from1);
					date_end1 = sdf1.parse(date_to1);
					 

					try {
						date_start = sdf.parse(date_from);
						date_end = sdf.parse(date_to);
						
							
						
					
						
				  logs1=new HibernateEventLogs().getdatesbetween(choice_12.getSelectedItem(),date_start1,date_end1);
				 
					}
					
					finally {}
					size=logs1.size();
					if(size==0){
						have2=false;
						JOptionPane.showMessageDialog(null, "Graph two is empty");

					}
					  values1=new ArrayList<Double>();
					
					for(int i=0; i<logs1.size();i++){
						
			      
					
							
						values1.add(logs1.get(i).getValue());
						
					
						
						 
					}
					}catch(Exception e){
						 
						System.out.println("Ne poklapaju se vrijednosti");
					}
			  
			  
			  
			  
			  
			  
			  
			 if(have1 && have2){
			 
			  
			  DataTable d=new DataTable(Long.class, Double.class, String.class);
			 
			  
			  for(int i=0;i<logs.size();i++){
				 
					
					d.add(logs.get(i).getTimestamp().getTime(), values.get(i),logs.get(i).getDevice_name());
			  }
			  
			  final BarPlot plot= new BarPlot(d);
								plot.setInsets(new Insets2D.Double(30.0, 20.0, 40.0, 0.0));
				 plot.getTitle().setText("Bar plot");
					
				  plot.setBarWidth(0.075);
			         // Format bars
			    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(d);
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
		      rendererX.setTickLabelFormat(dateFormat);
		      
		      
		      pointRenderer.setValueVisible(true);
		      pointRenderer.setValueColumn(1);
		      pointRenderer.setValueLocation(Location.CENTER);
		      pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
		      pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
			         
			         interactivePanel = new InteractivePanel(plot);
			         
			      
			         interactivePanel.setBounds(new Rectangle(0, 0, 440, 230));
			
			        
						 
							  
						  DataTable d1=new DataTable(Long.class, Double.class, String.class);
						 
						  
						  for(int j=0;j<logs1.size();j++){
							 
								
								d1.add(logs1.get(j).getTimestamp().getTime(), values1.get(j),logs1.get(j).getDevice_name());
						  }
							
						
						  
						  
						  final BarPlot plot1= new BarPlot(d1);
							
							plot1.setInsets(new Insets2D.Double(30.0, 510.0, 40.0, 0));
							 plot1.getTitle().setText("Bar plot");
								
							  plot1.setBarWidth(0.075);
						        
						    BarRenderer pointRenderer1 = (BarRenderer) plot1.getPointRenderer(d1);
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
					      
					     		 
					      plot1.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

					      AxisRenderer rendererX1 = plot1.getAxisRenderer(XYPlot.AXIS_X);
					      DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					      rendererX1.setTickLabelFormat(dateFormat);
					      
					      
					      pointRenderer1.setValueVisible(true);
					      pointRenderer1.setValueColumn(1);
					      pointRenderer1.setValueLocation(Location.CENTER);
					      pointRenderer1.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					      pointRenderer1.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
						         
						   
					      values2=new ArrayList<Double>();
							double vel;
							int k;
							if(logs1.get(logs1.size()-1).getTimestamp().getDate()<logs.get(logs.size()-1).getTimestamp().getDate()){
							 k=logs1.size();
							}else{
								k=logs.size();
							}
							DataTable dt=new DataTable(Double.class, Double.class);
							
							for(int i=0;i<k;i++){
								for(int j=i;j<k;j++){
									if(logs1.get(i).getTimestamp().getDate()==logs.get(j).getTimestamp().getDate()){
										dt.add(logs1.get(i).getValue(),logs.get(j).getValue());
										
										break;
										}
									
									}
								}
								
						
							final BarPlot plot3= new BarPlot(dt);
							plot3.setInsets(new Insets2D.Double(260.0, 200.0, 40,0));
					
						         // Format bars
						    BarRenderer pointRenderer3 = (BarRenderer) plot3.getPointRenderer(dt);
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
					         
					         
					        		 
					         plot3.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);

					         AxisRenderer rendererX3 = plot3.getAxisRenderer(XYPlot.AXIS_X);
					         DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					         rendererX3.setTickLabelFormat(dateFormat3);
					         
					         
					         pointRenderer3.setValueVisible(true);
					         pointRenderer3.setValueColumn(1);
					         pointRenderer3.setValueLocation(Location.CENTER);
					         pointRenderer3.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
					         pointRenderer3.setValueFont(Font.decode(null).deriveFont(Font.BOLD));	
						

					         interactivePanel2 = new InteractivePanel(plot3);
					         
					         interactivePanel2.setLayout(null);
					         interactivePanel2.setBounds(new Rectangle(0, 0, 540, 500));
					        

					       
					        
		
							          
					      interactivePanel1 = new InteractivePanel(plot1);
						         
						         interactivePanel1.setLayout(null);
						         interactivePanel1.setBounds(new Rectangle(0, 0, 950, 230));
						         

						       
						       
			
						          contentPane = new JPanel();
							       
						          contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
						 			
						 			
						 		        
						 				 tabbedPane.addTab("Three graphs", contentPane);
						 				 contentPane.setVisible(true);
						 				contentPane.add(interactivePanel);
						 				
						 			         
						 			     contentPane.add(interactivePanel1);
						 			    contentPane.add(interactivePanel2);
						 			     	
						 			     	 interactivePanel.setLayout(null);	
						 				     interactivePanel1.setLayout(null);
						 				    interactivePanel2.setLayout(null);
						 			     
						 				contentPane.setLayout(null);
						 				tabbedPane.setSelectedIndex(1);		          
						        
						 				
						 				
						 				
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
								 				   ThreeGraphsViewPanel threeGraphs= new ThreeGraphsViewPanel(tabbedPane);
								 					tabbedPane.add("Three graphs",threeGraphs);
								 					threeGraphs.setLayout(null);
								 				    
								 					tabbedPane.setSelectedIndex(0);
						 						}
						 					});		
					
			 }
		
		}	
		
			public int getValueFirstGraph() {
				return valueFirstGraph;
			}
			public void setValueFirstGraph(int valueFirstGraph) {
				this.valueFirstGraph = valueFirstGraph;
			}
			@Override
			public String getDescription() {
				
				return null;
			}
			@Override
			public String getTitle() {
				
				return null;
			}
}

