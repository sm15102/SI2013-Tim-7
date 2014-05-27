package etf.si.projekat.data_vision;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.LinearGradientPaint;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;

import java.awt.SystemColor;
import java.awt.Point;

import javax.swing.SwingConstants;

import java.awt.Choice;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;
import etf.si.projekat.util.HibernateUtil;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import de.erichseifert.gral.examples.ExamplePanel;
import de.erichseifert.gral.graphics.Drawable;
public class WelcomeDataVision extends ExamplePanel {
	ArrayList<String> senzori = new ArrayList<String>();
	
	private JPanel contentPane;
	final Choice choice;
	final Choice choice1 = new Choice();
	final Choice choice2 = new Choice();
	final Choice choice3 = new Choice();
	final Choice choice4 = new Choice();
	final Choice choice5 = new Choice();
	final Choice choice6 = new Choice();
	final Choice choice7 = new Choice();
	final Choice choice8 = new Choice();
	final Choice choice9 = new Choice();
	List<DeviceType> list_device=new HibernateDeviceType().giveAllDeviceType();
	final JLabel lblSensorType1;
	final JLabel lblSensorType2;
	final JLabel lblSensorType3;
	final JLabel lblSensorType4;
	final JLabel lblSensorType5;
	final JLabel lblSensorType6;
	final JLabel lblSensorType7;
	final JLabel lblSensorType8;
	final JLabel lblSensorType9;
	final  Button button;
	final JSpinner spinner;
	final JTabbedPane tabbedPane;
	final JButton btnProcess = new JButton("Process");
	private JFrame f;
	private InteractivePanel interactivePanel;
	
    
	
	//final JPanel content2;
	private InteractivePanel interactivePanel_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					WelcomeDataVision frame = new WelcomeDataVision();
					frame.setVisible(true);
					
					Timer timer = new Timer(1000, new ActionListener() {
				        public void actionPerformed(ActionEvent e) {
				        	
				    		HibernateDeviceType dt = new HibernateDeviceType();
				    		dt.giveAllDeviceType();
				    		HibernateDeviceName dn = new HibernateDeviceName();
				    		dn.giveAllDeviceName();

				    	
				        }
				    });
				
				    timer.setRepeats(false);
				    timer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public WelcomeDataVision() {
	    f = new JFrame();
		f.setEnabled(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 769, 538);
		/*contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//f.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));*/
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		//f.add(tabbedPane);
		
		/*JLabel lblSnjezaDodatiWelcome = new JLabel("Snjeza dodati welcome sliku :D");
		lblSnjezaDodatiWelcome.setLocation(new Point(9, 6));
		lblSnjezaDodatiWelcome.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Welcome", lblSnjezaDodatiWelcome);
		/*tabbedPane.addTab("One graph", new JLabel(""));
		tabbedPane.addTab("Two graphs", new JLabel("This is tab 3"));
		tabbedPane.addTab("Three graphs", new JLabel("This is tab 4"));
		tabbedPane.addTab("Table view", new JLabel("This is tab 5"));
		tabbedPane.addTab("Consumption", new JLabel("This is tab 6"));
		contentPane.add(tabbedPane);
		
		JLabel lblGraphType = new JLabel("Graph type");
		lblGraphType.setBounds(98, 56, 73, 14);
		//tabbedPane.add(lblGraphType);
		//tabbedPane.getTabComponent.add(lblGraphType, BorderLayout.WEST);
		*/
		
		/*final JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
	    JPanel tab = new JPanel();
	    tab.setOpaque(false);
	    JLabel tabLabel = new JLabel("Welcome" );
	    tab.add(tabLabel, BorderLayout.WEST);
	    tabbedPane.addTab(null, content);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab);*/
		
		final JPanel content2=new JPanel();
	    content2.setBackground(Color.WHITE);
	    content2.setBounds(new Rectangle(100, 100, 450, 300));
	    
	  //  content2.add(contentPane);
	    JPanel tab2 = new JPanel();
	    tab2.setOpaque(false);
	    JLabel tabLabel2 = new JLabel("One graph " );
	    tab2.add(tabLabel2);
	    tabbedPane.addTab(null, content2);
	    content2.setLayout(new BoxLayout(content2, BoxLayout.X_AXIS));
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab2);
	    
	    
		

	    f.setContentPane(tabbedPane);
	    
	   
	   
	
		content2.setLayout(null);
		
		JLabel lblGraphType = new JLabel("Graph type:");
		lblGraphType.setBounds(98, 46, 73, 14);
		lblGraphType.setLocation(46, 10);
		content2.add(lblGraphType);
		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval from:");
		lblTimeIntervalFrom.setLocation(10,15);
		lblTimeIntervalFrom.setBounds(10, 36, 113, 24);
		content2.add(lblTimeIntervalFrom);
		
		JLabel lblTimeIntervalTo = new JLabel("Time interval to:");
		lblTimeIntervalTo.setBounds(30, 66, 91, 14);
		content2.add(lblTimeIntervalTo);
		
		JLabel lblDataNumber = new JLabel("Data number:");
		lblDataNumber.setBounds(40, 96, 83, 14);
		content2.add(lblDataNumber);
		
	    choice = new Choice();
		choice.setBounds(130, 10, 117, 25);
		choice.add("Line");
		choice.add("Bar");
		content2.add(choice);
		
		
	  
		 spinner = new JSpinner();
		spinner.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner.setBounds(130, 96, 117, 25);
		
		content2.add(spinner);
		
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setLocation(130, 36);
        datePicker.setSize(118, 27);
        content2.add(datePicker);
        
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
        datePicker1.setLocation(130, 66);
        datePicker1.setSize(118, 27);
        content2.add(datePicker1);
        
        
       button = new Button("Continue");
		
		button.setBounds(176, 126, 70, 22);
		content2.add(button);
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//prikaz grafa za jedan senzor
			if(choice.getSelectedItem()=="Line")
			{
				
				//OneLineGraphShow();
			}
			else
			{
				
				
				tabbedPane.add(interactivePanel_1);
				
			}
				
			}
		});
		
		btnProcess.setBounds(170, 426, 90, 22);
		btnProcess.setVisible(false);
		content2.add(btnProcess);
		
		
		lblSensorType1 = new JLabel("Sensor type 1:");
		lblSensorType1.setBounds(40, 166, 89, 24);
		lblSensorType1.setVisible(false);
		content2.add(lblSensorType1);
		
		choice1.setBounds(130, 166, 120, 20);
		choice1.setVisible(false);
		content2.add(choice1);
		
		lblSensorType2 = new JLabel("Sensor type 2:");
		lblSensorType2.setBounds(40, 196, 89, 24);
		lblSensorType2.setVisible(false);
		content2.add(lblSensorType2);
		
		choice2.setBounds(130, 196, 120, 20);
		choice2.setVisible(false);
		content2.add(choice2);

		lblSensorType3 = new JLabel("Sensor type 3:");
		lblSensorType3.setBounds(40, 226, 89, 14);
		lblSensorType3.setVisible(false);
		content2.add(lblSensorType3);
		
		choice3.setBounds(130, 226, 120, 20);
		choice3.setVisible(false);
		content2.add(choice3);
		
		lblSensorType4 = new JLabel("Sensor type 4:");
		lblSensorType4.setBounds(40, 256, 89, 14);
		lblSensorType4.setVisible(false);
		content2.add(lblSensorType4);
		
		choice4.setBounds(130, 256, 120, 20);
		choice4.setVisible(false);
		content2.add(choice4);
		
		lblSensorType5 = new JLabel("Sensor type 5:");
		lblSensorType5.setBounds(40, 286, 89, 14);
		lblSensorType5.setVisible(false);
		content2.add(lblSensorType5);
		
		choice5.setBounds(130, 286, 120, 20);
		choice5.setVisible(false);
		content2.add(choice5);
		
		lblSensorType6 = new JLabel("Sensor type 6:");
		lblSensorType6.setBounds(40, 316, 89, 14);
		lblSensorType6.setVisible(false);
		content2.add(lblSensorType6);
		
		choice6.setBounds(130, 316, 120, 20);
		choice6.setVisible(false);
		content2.add(choice6);
		
		lblSensorType7 = new JLabel("Sensor type 7:");
		lblSensorType7.setBounds(40, 346, 89, 14);
		lblSensorType7.setVisible(false);
		content2.add(lblSensorType7);
		
		choice7.setBounds(130, 346, 120, 20);
		choice7.setVisible(false);
		content2.add(choice7);
		
		lblSensorType8 = new JLabel("Sensor type 8:");
		lblSensorType8.setBounds(40, 376, 89, 14);
		lblSensorType8.setVisible(false);
		content2.add(lblSensorType8);
		
		choice8.setBounds(130, 376, 120, 20);
		choice8.setVisible(false);
		content2.add(choice8);
		
		lblSensorType9 = new JLabel("Sensor type 9:");
		lblSensorType9.setBounds(40, 406, 89, 14);
		lblSensorType9.setVisible(false);
		content2.add(lblSensorType9);
		
		choice9.setBounds(130, 406, 120, 20);
		choice9.setVisible(false);
		content2.add(choice9);
		
		interactivePanel_1 = new InteractivePanel((Drawable) null);
		content2.add(interactivePanel_1);
		
		/*final JPanel content3 = new JPanel();
		content3.setBackground(Color.WHITE);
	    JPanel tab3 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel3 = new JLabel("Two graphs" );
	    tab3.add(tabLabel3);
	    tabbedPane.addTab(null, content3);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab3);
	    
	    final JPanel content4 = new JPanel();
	    content4.setBackground(Color.WHITE);
	    JPanel tab4 = new JPanel();
	    tab4.setOpaque(false);
	    JLabel tabLabel4= new JLabel("Three graphs" );
	    tab4.add(tabLabel4);
	    tabbedPane.addTab(null, content4);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab4);
	    
	    final JPanel content5 = new JPanel();
	    content5.setBackground(Color.WHITE);
	    JPanel tab5 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel5 = new JLabel("Table view" );
	    tab5.add(tabLabel5);
	    tabbedPane.addTab(null, content5);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab5);
	    
	    final JPanel content6 = new JPanel();
	    content6.setBackground(Color.WHITE);
	    JPanel tab6 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel6 = new JLabel("Consumption" );
	    tab3.add(tabLabel6);
	    tabbedPane.addTab(null, content6);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab6);
	    
		*/
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				choice1.enable();
				choice2.enable();
				choice3.enable();
				choice4.enable();
				choice5.enable();
				choice6.enable();
				choice7.enable();
				choice8.enable();
				choice9.enable();
				choice1.removeAll();
				choice2.removeAll();
				choice3.removeAll();
				choice4.removeAll();
				choice5.removeAll();
				choice6.removeAll();
				choice7.removeAll();
				choice8.removeAll();
				choice9.removeAll();
				 for (int i=0; i<list_device.size(); i++){
			    	 choice1.add(list_device.get(i).getType());
			    	   }
				
				Integer value = (Integer) spinner.getValue();
				if(value == 1){
			
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					btnProcess.setVisible(true);
				
				}
				
				else if(value == 2){
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					btnProcess.setVisible(true);
					
			
				
					
				}
				
				else if(value == 3){
					
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					btnProcess.setVisible(true);
				}
				
				else if(value == 4){
						
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					lblSensorType4.setVisible(true);
					choice4.setVisible(true);
					btnProcess.setVisible(true);
					
					}
				
				
				else if(value == 5){
					
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					lblSensorType4.setVisible(true);
					choice4.setVisible(true);
					lblSensorType5.setVisible(true);
					choice5.setVisible(true);
					btnProcess.setVisible(true);
				}
				
				else if(value == 6){
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					lblSensorType4.setVisible(true);
					choice4.setVisible(true);
					lblSensorType5.setVisible(true);
					choice5.setVisible(true);
					lblSensorType6.setVisible(true);
					choice6.setVisible(true);
					btnProcess.setVisible(true);
				}
				
				else if(value == 7){
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					lblSensorType4.setVisible(true);
					choice4.setVisible(true);
					lblSensorType5.setVisible(true);
					choice5.setVisible(true);
					lblSensorType6.setVisible(true);
					choice6.setVisible(true);
					lblSensorType7.setVisible(true);
					choice7.setVisible(true);
					btnProcess.setVisible(true);
				}
				
				else if(value == 8){
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					lblSensorType4.setVisible(true);
					choice4.setVisible(true);
					lblSensorType5.setVisible(true);
					choice5.setVisible(true);
					lblSensorType6.setVisible(true);
					choice6.setVisible(true);
					lblSensorType7.setVisible(true);
					choice7.setVisible(true);
					lblSensorType8.setVisible(true);
					choice8.setVisible(true);
					btnProcess.setVisible(true);
				}
				
				else{
					lblSensorType1.setVisible(true);
					choice1.setVisible(true);
					lblSensorType2.setVisible(true);
					choice2.setVisible(true);
					lblSensorType3.setVisible(true);
					choice3.setVisible(true);
					lblSensorType4.setVisible(true);
					choice4.setVisible(true);
					lblSensorType5.setVisible(true);
					choice5.setVisible(true);
					lblSensorType6.setVisible(true);
					choice6.setVisible(true);
					lblSensorType7.setVisible(true);
					choice7.setVisible(true);
					lblSensorType8.setVisible(true);
					choice8.setVisible(true);
					lblSensorType9.setVisible(true);
					choice9.setVisible(true);
					btnProcess.setVisible(true);
				}
				
				
				
				
				
				
		}
		});
        
		
		choice1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(0);
			}
		});
		choice2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(1);
			}
		});
		
		choice3.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(2);
			}
		});
	
		
		choice4.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(3);
			}
		});
		
		choice5.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(4);
			}
		});
		
		
		choice6.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(5);
			}
		});
		
		choice7.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(6);
			}
		});
		
		
		choice8.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(7);
			}
		});
		
		choice9.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(8);
			}
		
		});
		
		
		
		contentPane.add(tabbedPane);
		}
	
	public void fillChoices(int k){
		switch(k){
		case 0 : {
			for(int i=0; i<list_device.size();i++){
			if(choice1.getSelectedItem() == list_device.get(i).getType()) continue;
			choice2.add(list_device.get(i).getType());
			}
			choice1.disable();
			break;
			
		}
		case 1 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())) continue;
				choice3.add(list_device.get(i).getType());
				}
				choice2.disable();
				break;
		}
		case 2 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())||(choice3.getSelectedItem() == list_device.get(i).getType())) continue;
				choice4.add(list_device.get(i).getType());
				}
				choice3.disable();
				break;
		}
		case 3 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())||(choice3.getSelectedItem() == list_device.get(i).getType())||
						(choice4.getSelectedItem() == list_device.get(i).getType())) continue;
				choice5.add(list_device.get(i).getType());
				}
				choice4.disable();
				break;
		}
		case 4 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())||(choice3.getSelectedItem() == list_device.get(i).getType())||
						(choice4.getSelectedItem() == list_device.get(i).getType())||(choice5.getSelectedItem() == list_device.get(i).getType())) continue;
				choice6.add(list_device.get(i).getType());
				}
				choice5.disable();
				break;
		}
		case 5 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())||(choice3.getSelectedItem() == list_device.get(i).getType())||
						(choice4.getSelectedItem() == list_device.get(i).getType())||(choice5.getSelectedItem() == list_device.get(i).getType())||(choice6.getSelectedItem() == list_device.get(i).getType())) continue;
				choice7.add(list_device.get(i).getType());
				}
				choice6.disable();
				break;
		}
		case 6 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())||(choice3.getSelectedItem() == list_device.get(i).getType())||
				   (choice4.getSelectedItem() == list_device.get(i).getType())||(choice5.getSelectedItem() == list_device.get(i).getType())||(choice6.getSelectedItem() == list_device.get(i).getType())||
				   (choice7.getSelectedItem() == list_device.get(i).getType())) continue;
				choice8.add(list_device.get(i).getType());
				}
				choice7.disable();
				break;
		}
		case 7 : {
			for(int i=0; i<list_device.size();i++){
				if((choice1.getSelectedItem() == list_device.get(i).getType()) || (choice2.getSelectedItem() == list_device.get(i).getType())||(choice3.getSelectedItem() == list_device.get(i).getType())||
				   (choice4.getSelectedItem() == list_device.get(i).getType())||(choice5.getSelectedItem() == list_device.get(i).getType())||(choice6.getSelectedItem() == list_device.get(i).getType())||
				   (choice7.getSelectedItem() == list_device.get(i).getType())||(choice8.getSelectedItem() == list_device.get(i).getType())) continue;
				choice9.add(list_device.get(i).getType());
				}
				choice8.disable();
				break;
		}
		case 8 : {
			choice9.disable();
			
		}	
	}
		
	}
	
	
	public void OneLineGraphShow(){
		
		
	
	}
	
	public void OneBarGraphShow(){
		JOptionPane.showMessageDialog(null, "blaaa.", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
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
		
		Integer value = (Integer) spinner.getValue();
		
		for(int i=0;i<value;i++)
		{
			
			senzori.add(choices.get(i).getSelectedItem());
		   
		}
		
		 DataTable data = new DataTable(Double.class, Integer.class, String.class);
		 double j=0.1;
		 for(int i=0; i<senzori.size(); i++)
		 {
			String naziv=senzori.get(i);
			data.add(j, i+1, naziv);
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
       
           interactivePanel = new InteractivePanel(plot);
           interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
	       plot.getTitle().setText("Bar plot");
	       
			interactivePanel.setVisible(true);
		   // content2.add(interactivePanel, BorderLayout.CENTER);
			//content2.add(new Label("bla")); //doda u novi tab graf
			//content2.add(new InteractivePanel(plot));
		    //content2.setLayout(new BoxLayout(content2, BoxLayout.X_AXIS));

		//f.getContentPane().getComponent(0).getComponentAt(0);
	//	tabbedPane.getTabComponentAt(1).add(interactivePanel, BorderLayout.SOUTH);
		
		    tabbedPane.addTab(null, interactivePanel);
			
			
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
