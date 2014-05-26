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
		setBounds(100, 100, 715, 433);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
		
		/*final JPanel content = new JPanel();
	    JPanel tab = new JPanel();
	    tab.setOpaque(false);
	   
	    JLabel tabLabel = new JLabel("Welcome" );
	    tab.add(tabLabel, BorderLayout.WEST);
	    tabbedPane.addTab(null, content);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab);*/
		
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
	    
	    
	    
	    
	    
	    
	   // contentPane = new JPanel();
		//content2.setBorder(new EmptyBorder(5, 5, 5, 5));
	
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
		
		final JSpinner spinner = new JSpinner();
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
        
        
        Button button = new Button("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer value = (Integer) spinner.getValue();
				if(value == 1){
					
					Add1Sensor a = new Add1Sensor(choice.getSelectedItem(), datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 2){
					
					Add2Sensors a = new Add2Sensors(choice.getSelectedItem(), datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 3){
					
					Add3Sensors a = new Add3Sensors(choice.getSelectedItem(), datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 4){
						
						Add4Sensors a = new Add4Sensors(choice.getSelectedItem(), datePicker, datePicker1);
						a.setVisible(true);
						dispose();
					}
				
				
				else if(value == 5){
					
					Add5Sensors a = new Add5Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 6){
					
					Add6Sensors a = new Add6Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 7){
					
					Add7Sensor a = new Add7Sensor(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 8){
					
					Add8Sensors a = new Add8Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				else{
					
					Add9Sensors a = new Add9Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
					dispose();
				}
				
				
				
				
				
				
			}
		});
        
		button.setBounds(176, 126, 70, 22);
		content2.add(button);
		
		
		JLabel lblSensorType = new JLabel("Sensor type:");
		lblSensorType.setBounds(40, 166, 79, 14);
		lblSensorType.setVisible(false);
		content2.add(lblSensorType);
		
		choice1.setBounds(130, 166, 120, 20);
		choice1.setVisible(false);
		content2.add(choice1);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction t=null;
		try{
			t = session.beginTransaction(); 
		   List list = session.createQuery("from DeviceType").list();
		    
		    
		   // list_time = session.createQuery("select timestamp from eventlogs where TIMESTAMP>= CONVERT(datetime, datePickerFrom) and timestamp<= CONVERT(datetime, datePickerTo) and device_name='CO2'").list();*/
		   
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){  
		        DeviceType dt =(DeviceType) iterator.next();
		        choice1.addItem(dt.getType());
		         
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
	
	    
	   /* final JPanel content3 = new JPanel();
	    JPanel tab3 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel3 = new JLabel("Two graphs" );
	    tab3.add(tabLabel3);
	    tabbedPane.addTab(null, content3);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab3);
	    
	    final JPanel content4 = new JPanel();
	    JPanel tab4 = new JPanel();
	    tab4.setOpaque(false);
	    JLabel tabLabel4= new JLabel("Three graphs" );
	    tab4.add(tabLabel4);
	    tabbedPane.addTab(null, content4);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab4);
	    
	    final JPanel content5 = new JPanel();
	    JPanel tab5 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel5 = new JLabel("Table view" );
	    tab5.add(tabLabel5);
	    tabbedPane.addTab(null, content5);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab5);
	    
	    final JPanel content6 = new JPanel();
	    JPanel tab6 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel6 = new JLabel("Consumption" );
	    tab3.add(tabLabel6);
	    tabbedPane.addTab(null, content6);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab6);
	    
	    */
	    
	    contentPane.add(tabbedPane);
	    
	    
	}
}
