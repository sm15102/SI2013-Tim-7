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

public class Add8Sensors extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add8Sensors frame = new Add8Sensors();
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
	public Add8Sensors() {
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type 1");
		lblSensorType.setBounds(10, 34, 91, 14);
		contentPane.add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 2");
		lblSensorType_1.setBounds(10, 59, 91, 14);
		contentPane.add(lblSensorType_1);
		
		JLabel lblSensorType_2 = new JLabel("Sensor type 3");
		lblSensorType_2.setBounds(10, 84, 91, 14);
		contentPane.add(lblSensorType_2);
		
		JLabel lblSensorType_3 = new JLabel("Sensor type 4");
		lblSensorType_3.setBounds(10, 107, 91, 14);
		contentPane.add(lblSensorType_3);
		
		JLabel lblSensorType_4 = new JLabel("Sensor type 5");
		lblSensorType_4.setBounds(10, 132, 91, 14);
		contentPane.add(lblSensorType_4);
		
		JLabel lblSensorType_5 = new JLabel("Sensor type 6");
		lblSensorType_5.setBounds(10, 158, 91, 14);
		contentPane.add(lblSensorType_5);
		
		JLabel lblSensorType_6 = new JLabel("Sensor type 7");
		lblSensorType_6.setBounds(10, 182, 91, 14);
		contentPane.add(lblSensorType_6);
		
		JLabel lblSensorType_7 = new JLabel("Sensor type 8");
		lblSensorType_7.setBounds(10, 208, 91, 14);
		contentPane.add(lblSensorType_7);
		
		Choice choice = new Choice();
		choice.setBounds(91, 28, 136, 20);
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(91, 53, 136, 20);
		contentPane.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(91, 78, 136, 20);
		contentPane.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(91, 101, 136, 20);
		contentPane.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(91, 126, 136, 20);
		contentPane.add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(91, 152, 136, 20);
		contentPane.add(choice_5);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(91, 176, 136, 20);
		contentPane.add(choice_6);
		
		Choice choice_7 = new Choice();
		choice_7.setBounds(91, 202, 136, 20);
		contentPane.add(choice_7);
		choice.add(""); 
		choice_1.add(""); 
		choice_2.add("");
		choice_3.add("");
		choice_4.add("");
		choice_5.add("");
		choice_6.add("");
		choice_7.add("");

		JButton btnProcess = new JButton("Process");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}
		});
		btnProcess.setBounds(266, 239, 89, 23);
		contentPane.add(btnProcess);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(167, 239, 89, 23);
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
		        choice_5.addItem(dt.getType());
		        choice_6.addItem(dt.getType());
		        choice_7.addItem(dt.getType());
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
