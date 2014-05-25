
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Add6Sensors extends JFrame {
	JButton btnProcess = new JButton("Process");
	Choice choice = new Choice();
	Choice choice_1 = new Choice();
	Choice choice_2 = new Choice();
	Choice choice_3 = new Choice();
	Choice choice_4 = new Choice();
	Choice choice_5 = new Choice();
	ArrayList<DeviceType> list_device = new ArrayList<DeviceType>();
	final List<String> senzori;
	final JDatePickerImpl datePickerFrom;
	final JDatePickerImpl datePickerTo;
	public String graphType;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Add6Sensors frame = new Add6Sensors();
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
	public Add6Sensors(String _graphType, JDatePickerImpl dp1, JDatePickerImpl dp2) {
		senzori=new ArrayList<String>();
		datePickerFrom=dp1;
		datePickerTo=dp2;
		graphType=_graphType;
		setBounds(100, 100, 370, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type 1");
		lblSensorType.setBounds(26, 47, 93, 14);
		contentPane.add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 2");
		lblSensorType_1.setBounds(26, 71, 93, 14);
		contentPane.add(lblSensorType_1);
		
		JLabel lblSensorType_2 = new JLabel("Sensor type 3");
		lblSensorType_2.setBounds(26, 96, 93, 14);
		contentPane.add(lblSensorType_2);
		
		JLabel lblSensorType_3 = new JLabel("Sensor type 4");
		lblSensorType_3.setBounds(26, 121, 93, 14);
		contentPane.add(lblSensorType_3);
		
		JLabel lblSensorType_4 = new JLabel("Sensor type 5");
		lblSensorType_4.setBounds(26, 144, 93, 14);
		contentPane.add(lblSensorType_4);
		
		JLabel lblSensorType_5 = new JLabel("Sensor type 6");
		lblSensorType_5.setBounds(26, 169, 93, 14);
		contentPane.add(lblSensorType_5);
		
		
		choice.setBounds(120, 43, 150, 20);
		contentPane.add(choice);
		choice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(0);
			}
		});
		
		
		choice_1.setBounds(120, 69, 150, 20);
		contentPane.add(choice_1);
		choice_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(1);
			}
		});
		
		choice_2.setBounds(120, 92, 150, 20);
		contentPane.add(choice_2);
		choice_2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(2);
			}
		});
		
		choice_3.setBounds(120, 117, 150, 20);
		contentPane.add(choice_3);
		choice_3.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(3);
			}
		});
		
		choice_4.setBounds(120, 140, 150, 20);
		contentPane.add(choice_4);
		choice_4.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(4);
			}
		});
		
		choice_5.setBounds(120, 165, 150, 20);
		contentPane.add(choice_5);
		choice_5.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				fillChoices(5);
			}
		});
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(graphType=="Bar"){
				senzori.add(choice.getSelectedItem());
				senzori.add(choice_1.getSelectedItem());
				senzori.add(choice_2.getSelectedItem());
				senzori.add(choice_3.getSelectedItem());
				senzori.add(choice_4.getSelectedItem());
				senzori.add(choice_5.getSelectedItem());
				BarPlotShow bp=new BarPlotShow(senzori,datePickerFrom, datePickerTo);}
				
				else {}
				dispose();
			}
		});
		
		btnProcess.setBounds(242, 216, 89, 23);
		contentPane.add(btnProcess);
		btnProcess.setVisible(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(144, 216, 89, 23);
		contentPane.add(btnCancel);
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction t=null;
		try{
			t = session.beginTransaction(); 
		    List list = session.createQuery("from DeviceType").list();
		   
		     for (Iterator iterator = list.iterator(); iterator.hasNext();){  
		        DeviceType dt =(DeviceType) iterator.next();
		        choice.addItem(dt.getType());
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
	}
	public void fillChoices(int k){
		switch(k){
		case 0 : {
			for(int i=0; i<list_device.size();i++){
			if(choice.getSelectedItem() == list_device.get(i).getType()) continue;
			choice_1.add(list_device.get(i).getType());
			}
			choice.disable();
			break;
			
		}
		case 1 : {
			for(int i=0; i<list_device.size();i++){
				if((choice.getSelectedItem() == list_device.get(i).getType()) || (choice_1.getSelectedItem() == list_device.get(i).getType())) continue;
				choice_2.add(list_device.get(i).getType());
				}
				choice_1.disable();
				break;
		}
		case 2 : {
			for(int i=0; i<list_device.size();i++){
				if((choice.getSelectedItem() == list_device.get(i).getType()) || (choice_1.getSelectedItem() == list_device.get(i).getType())||(choice_2.getSelectedItem() == list_device.get(i).getType())) continue;
				choice_3.add(list_device.get(i).getType());
				}
				choice_2.disable();
				break;
		}
		case 3 : {
			for(int i=0; i<list_device.size();i++){
				if((choice.getSelectedItem() == list_device.get(i).getType()) || (choice_1.getSelectedItem() == list_device.get(i).getType())||(choice_2.getSelectedItem() == list_device.get(i).getType())||
						(choice_3.getSelectedItem() == list_device.get(i).getType())) continue;
				choice_4.add(list_device.get(i).getType());
				}
				choice_3.disable();
				break;
		}
		case 4 : {
			for(int i=0; i<list_device.size();i++){
				if((choice.getSelectedItem() == list_device.get(i).getType()) || (choice_1.getSelectedItem() == list_device.get(i).getType())||(choice_2.getSelectedItem() == list_device.get(i).getType())||
						(choice_3.getSelectedItem() == list_device.get(i).getType())||(choice_4.getSelectedItem() == list_device.get(i).getType())) continue;
				choice_5.add(list_device.get(i).getType());
				}
				choice_4.disable();
				break;
		}
		case 5 : {
			choice_5.disable();
			btnProcess.setVisible(true);
		}	
	}
	}

}