package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Choice;

import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.DeviceType;
import etf.si.projekat.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Add4Sensors extends JFrame {
	JButton btnProcess = new JButton("Process");
	Choice choice_3 = new Choice();
	Choice choice_2 = new Choice();
	Choice choice_1 = new Choice();
	Choice choice = new Choice();
	ArrayList<DeviceType> list_device = new ArrayList<DeviceType>();
	private JPanel contentPane;
	final List<String> senzori;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Add4Sensors frame = new Add4Sensors();
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
	public Add4Sensors() {
		senzori=new ArrayList<String>();
		setBounds(100, 100, 370, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type 1");
		lblSensorType.setBounds(24, 43, 82, 14);
		contentPane.add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 2");
		lblSensorType_1.setBounds(24, 68, 82, 14);
		contentPane.add(lblSensorType_1);
		
		JLabel lblSensorType_2 = new JLabel("Sensor type 3");
		lblSensorType_2.setBounds(24, 96, 82, 14);
		contentPane.add(lblSensorType_2);
		
		JLabel lblSensorType_3 = new JLabel("Sensor type 4");
		lblSensorType_3.setBounds(24, 123, 82, 14);
		contentPane.add(lblSensorType_3);
		
		
		choice.setBounds(122, 37, 150, 20);
		contentPane.add(choice);
		choice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(0);
			}
		});
		
		choice_1.setBounds(122, 62, 150, 20);
		contentPane.add(choice_1);
		choice_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(1);
			}
		});
		
		choice_2.setBounds(122, 88, 150, 20);
		contentPane.add(choice_2);
		choice_2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(2);
			}
		});
		
		
		choice_3.setBounds(122, 114, 150, 20);
		contentPane.add(choice_3);
		choice_3.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(3);
			}
		});
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senzori.add(choice.getSelectedItem());
				senzori.add(choice_1.getSelectedItem());
				senzori.add(choice_2.getSelectedItem());
				senzori.add(choice_3.getSelectedItem());
				BarPlotShow bp=new BarPlotShow(senzori);				
				dispose();
				
			}
		});
		
		
		btnProcess.setBounds(247, 165, 89, 23);
		contentPane.add(btnProcess);
		btnProcess.setVisible(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnCancel.setBounds(153, 165, 89, 23);
		contentPane.add(btnCancel);
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
		if(k==0) {
			for(int i=0; i<list_device.size();i++){
			if(choice.getSelectedItem() == list_device.get(i).getType()) continue;
			choice_1.add(list_device.get(i).getType());
			}
			choice.disable();
			
		}
		if(k==1){
			for(int i=0; i<list_device.size();i++){
				if((choice.getSelectedItem() == list_device.get(i).getType()) || (choice_1.getSelectedItem() == list_device.get(i).getType())) continue;
				choice_2.add(list_device.get(i).getType());
				}
				choice_1.disable();
		}
		if(k==2){
			for(int i=0; i<list_device.size();i++){
				if((choice.getSelectedItem() == list_device.get(i).getType()) || (choice_1.getSelectedItem() == list_device.get(i).getType())||(choice_2.getSelectedItem() == list_device.get(i).getType())) continue;
				choice_3.add(list_device.get(i).getType());
				}
				choice_2.disable();
		}
		if(k==3){
			choice_3.disable();
			btnProcess.setVisible(true);
		}	
	}
	

}
