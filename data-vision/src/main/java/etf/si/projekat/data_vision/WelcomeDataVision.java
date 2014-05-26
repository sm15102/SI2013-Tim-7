package etf.si.projekat.data_vision;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

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

import ba.unsa.etf.si.beans.DeviceType;
import etf.si.projekat.util.HibernateUtil;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class WelcomeDataVision extends JFrame {
	
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
	
	final JLabel lblSensorType1;
	final JLabel lblSensorType2;
	final JLabel lblSensorType3;
	final JLabel lblSensorType4;
	final JLabel lblSensorType5;
	final JLabel lblSensorType6;
	final JLabel lblSensorType7;
	final JLabel lblSensorType8;
	final JLabel lblSensorType9;
	ArrayList<DeviceType> list_device = new ArrayList<DeviceType>();
	final  Button button;
	final JSpinner spinner;
	final JTabbedPane tabbedPane;
	final JButton btnProcess = new JButton("Process");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeDataVision frame = new WelcomeDataVision();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 538);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		
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
		
		final JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
	    JPanel tab = new JPanel();
	    tab.setOpaque(false);
	   
	    JLabel tabLabel = new JLabel("Welcome" );
	    tab.add(tabLabel, BorderLayout.WEST);
	    tabbedPane.addTab(null, content);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab);
		
	    final JPanel content2 = new JPanel();
	    content2.setBackground(Color.WHITE);
	    content2.setBounds(new Rectangle(100, 100, 450, 300));
	    JPanel tab2 = new JPanel();
	    tab2.setOpaque(false);
	    JLabel tabLabel2 = new JLabel("One graph " );
	    tab2.add(tabLabel2);
	    tabbedPane.addTab(null, content2);
	    content2.setLayout(new BoxLayout(content2, BoxLayout.X_AXIS));
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab2);
	    
	    
	   
	
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
		
		final JPanel content3 = new JPanel();
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
	    
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction t=null;
		try{
			t = session.beginTransaction(); 
		    List list = session.createQuery("from DeviceType").list();
		   
		     for (Iterator iterator = list.iterator(); iterator.hasNext();){  
		        DeviceType dt =(DeviceType) iterator.next();
		        choice1.addItem(dt.getType());
		        list_device.add(dt);
		      }
		      t.commit();
	}
		catch(Exception e)
	{
		System.out.println("Error:"+e);
	}
		finally{
			session.close();
		}
		
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
}
