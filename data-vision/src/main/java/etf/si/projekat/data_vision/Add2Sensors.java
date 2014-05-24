package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Choice;

import javax.swing.JButton;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.DeviceType;
import etf.si.projekat.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Add2Sensors extends JFrame {
	Choice choice = new Choice();
	Choice choice_1 = new Choice();
	JButton btnProcess = new JButton("Process");
	ArrayList<DeviceType> list_device = new ArrayList<DeviceType>();
	private JPanel contentPane;
	public String graphType;
	final List<String> senzori;
	final JDatePickerImpl datePickerFrom;
	final JDatePickerImpl datePickerTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Add2Sensors frame = new Add2Sensors(graphType);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add2Sensors(String _graphType, JDatePickerImpl dp1, JDatePickerImpl dp2) {
		senzori=new ArrayList<String>();
		datePickerFrom=dp1;
		datePickerTo=dp2;
		graphType=_graphType;
		setBounds(100, 100, 305, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type 1");
		lblSensorType.setBounds(10, 27, 85, 14);
		contentPane.add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 2");
		lblSensorType_1.setBounds(10, 52, 85, 14);
		contentPane.add(lblSensorType_1);
		
		
		choice.setBounds(100, 23, 150, 20);
		contentPane.add(choice);
		
		
		
		choice_1.setBounds(100, 48, 150, 20);
		contentPane.add(choice_1);
		choice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(1);
			}
		});
		choice_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(2);
			}
		});
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(graphType=="Bar") {

					senzori.add(choice.getSelectedItem());
					senzori.add(choice_1.getSelectedItem());
					BarPlotShow bp=new BarPlotShow(senzori);
					dispose();
					}
					
					else{
						senzori.add(choice.getSelectedItem());
						senzori.add(choice_1.getSelectedItem());
					OneGraphShow og=new OneGraphShow(senzori, datePickerFrom, datePickerTo);
						
			
						
					}
				
				
				//dispose();
			}
		});
		
		
		btnProcess.setBounds(190, 98, 89, 23);
		contentPane.add(btnProcess);
		btnProcess.setVisible(false);
		
		JButton btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(91, 98, 89, 23);
		contentPane.add(btnExit);

		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction t=null;
		try{
			t = session.beginTransaction(); 
		    List list = session.createQuery("from DeviceType").list();
		   
		     for (Iterator iterator = list.iterator(); iterator.hasNext();){  
		        DeviceType dt =(DeviceType) iterator.next();
		        list_device.add(dt);
		        choice.addItem(dt.getType());
		         
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
	}
	
	public void fillChoices(int k){
		if(k==1) {
			for(int i=0; i<list_device.size();i++){
			if(choice.getSelectedItem() == list_device.get(i).getType()) continue;
			choice_1.add(list_device.get(i).getType());
			}
			choice.disable();
			
		}
		if(k==2){
	        choice_1.disable();
			btnProcess.setVisible(true);
		}	
	}

}
