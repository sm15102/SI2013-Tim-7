package etf.si.projekat.data_vision;

import java.awt.*;
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
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import com.mysql.jdbc.Statement;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicInformationPanel  extends ExamplePanel {
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
  
    //final InteractivePanel interactivePanel;
    
    
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
		
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JLabel lblGraphType = new JLabel("Graph type");
        lblGraphType.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGraphType.setBounds(55, 60, 68, 14);
        add(lblGraphType);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setLocation(152, 76);
        datePicker.setSize(165, 28);
       add(datePicker);
        
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
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
      		OneBarGraphShow();
      	}
      	else
      	{
      		OneLineGraphShow();
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
      
      choice_2 = new Choice();
      choice_2.setBounds(152, 261, 165, 20);
      add(choice_2);
      
       choice_3 = new Choice();
      choice_3.setBounds(152, 285, 165, 20);
      add(choice_3);
      
      choice_4 = new Choice();
      choice_4.setBounds(152, 310, 165, 20);
      add(choice_4);
      
     choice_5 = new Choice();
      choice_5.setBounds(152, 335, 165, 20);
      add(choice_5);
      
      choice_6 = new Choice();
      choice_6.setBounds(152, 360, 165, 20);
      add(choice_6);
      
      choice_7 = new Choice();
      choice_7.setBounds(152, 385, 165, 20);
      add(choice_7);
      
       choice_8 = new Choice();
      choice_8.setBounds(152, 410, 165, 20);
      add(choice_8);
      
      choice_9 = new Choice();
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
      btnProcess.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
      btnProcess.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
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
				btnGenerateGraph.setVisible(true);
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


				btnGenerateGraph.setVisible(true);
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

				btnGenerateGraph.setVisible(true);
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
				btnGenerateGraph.setVisible(true);
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
				btnGenerateGraph.setVisible(true);
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
				btnGenerateGraph.setVisible(true);
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
				btnGenerateGraph.setVisible(true);
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
				btnGenerateGraph.setVisible(true);
			}
			
			
			
		      
		      for (int i=0; i<list_device.size(); i++){
			    	 choice_1.add(list_device.get(i).getName() );
			    	 choice_2.add(list_device.get(i).getName() );
			    	 choice_3.add(list_device.get(i).getName() );
			    	 choice_4.add(list_device.get(i).getName() );
			    	 choice_5.add(list_device.get(i).getName() );
			    	 choice_6.add(list_device.get(i).getName() );
			    	 choice_7.add(list_device.get(i).getName() );
			    	 choice_8.add(list_device.get(i).getName() );
			    	 choice_9.add(list_device.get(i).getName() );
		      }
		      
		     
		     
	
		  		
		      	
			
      	}
      });
		
      
      
      
      btnProcess.setBounds(181, 163, 136, 23);
      add(btnProcess);
      
      String querry = "Select value from eventlogs";
    
      
  
	}
	
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
        final InteractivePanel interactivePanel = new InteractivePanel(plot);
           //InteractivePanel interactivePanel = new InteractivePanel(plot);
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
	       		BufferedImage bi = new BufferedImage(interactivePanel.getSize().width, interactivePanel.getSize().height, BufferedImage.TYPE_INT_ARGB); 
	       		Graphics g = bi.createGraphics();
	       		interactivePanel.paint(g);  //this == JComponent
	       		g.dispose();
	       		try{ImageIO.write(bi,"png",new File("test.png"));}catch (Exception e) {e.printStackTrace();}
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
         
         
         final InteractivePanel interactivePanel = new InteractivePanel(plot);
         interactivePanel.setLayout(null);
		 interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
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
	       		BufferedImage bi = new BufferedImage(interactivePanel.getSize().width, interactivePanel.getSize().height, BufferedImage.TYPE_INT_RGB); 
	       		Graphics g = bi.createGraphics();
	       		interactivePanel.paint(g);  //this == JComponent
	       		g.dispose();
	       		try{ImageIO.write(bi,"png",new File("test.png"));}catch (Exception e) {e.printStackTrace();}
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
      
      
