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
import java.util.Iterator;
import java.util.List;

public class Add5Sensors extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add5Sensors frame = new Add5Sensors();
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
	public Add5Sensors() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type 1");
		lblSensorType.setBounds(20, 54, 86, 14);
		contentPane.add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 2");
		lblSensorType_1.setBounds(20, 79, 86, 14);
		contentPane.add(lblSensorType_1);
		
		JLabel lblSensorType_2 = new JLabel("Sensor type 3");
		lblSensorType_2.setBounds(20, 104, 86, 14);
		contentPane.add(lblSensorType_2);
		
		JLabel lblSensorType_3 = new JLabel("Sensor type 4");
		lblSensorType_3.setBounds(20, 129, 86, 14);
		contentPane.add(lblSensorType_3);
		

		
		JLabel lblSensorType_4 = new JLabel("Sensor type 5");
		lblSensorType_4.setBounds(20, 154, 86, 14);
		contentPane.add(lblSensorType_4);
		
		Choice choice = new Choice();
		choice.setBounds(128, 48, 135, 20);
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(128, 73, 135, 20);
		contentPane.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(128, 98, 135, 20);
		contentPane.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(128, 123, 135, 20);
		contentPane.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(128, 148, 135, 20);
		contentPane.add(choice_4);
		
		

		choice.add(""); 
		choice_1.add(""); 
		choice_2.add("");
		choice_3.add("");
		choice_4.add("");
		
		JButton btnProcess = new JButton("Process");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}
		});
		btnProcess.setBounds(248, 209, 89, 23);
		contentPane.add(btnProcess);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(147, 209, 89, 23);
		contentPane.add(btnCancel);
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction t=null;
		try{
			t = session.beginTransaction(); 
		    List list = session.createQuery("from DeviceType").list();
		   
		     for (Iterator iterator = list.iterator(); iterator.hasNext();){  
		        DeviceType dt =(DeviceType) iterator.next();
		        choice.addItem(dt.getType());
		        choice_1.addItem(dt.getType());
		        choice_2.addItem(dt.getType());
		        choice_3.addItem(dt.getType());
		        choice_4.addItem(dt.getType());
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

}
