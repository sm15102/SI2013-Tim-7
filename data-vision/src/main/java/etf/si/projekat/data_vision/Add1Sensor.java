package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Choice;
import java.awt.Button;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import etf.si.projekat.util.HibernateUtil;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;



public class Add1Sensor extends JFrame {
	JButton btnProcess = new JButton("Process");
	Choice choice = new Choice();
	final int graphType;
	private JPanel contentPane;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String g=graphType;
					//Add1Sensor frame = new Add1Sensor("Line");
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
	public Add1Sensor(int graphT) {
		
		graphType=graphT;
		btnProcess.setVisible(false);
		setBounds(100, 100, 298, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type:");
		lblSensorType.setBounds(55, 35, 79, 14);
		contentPane.add(lblSensorType);
		
	
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(graphType==0) {

				BarPlotShow bp=new BarPlotShow();}
				
				else{
				OneGraphShow og=new OneGraphShow();
					
			//	og.setVisible(true);
					
				}
				dispose();
				
				
			
			}
		});
		btnProcess.setBounds(152, 88, 89, 23);
		contentPane.add(btnProcess);
		
		
		JButton btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnExit.setBounds(45, 88, 89, 23);
		contentPane.add(btnExit);
		
		
		choice.setBounds(134, 32, 105, 20);
		contentPane.add(choice);
		
		choice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				choice.disable();
				btnProcess.setVisible(true);
			}
		});
			
		    Session session = HibernateUtil.getSessionFactory().openSession();
		    Transaction t=null;
			try{
				t = session.beginTransaction(); 
			    List list = session.createQuery("from DeviceType").list();
			   
			     for (Iterator iterator = list.iterator(); iterator.hasNext();){  
			        DeviceType dt =(DeviceType) iterator.next();
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
}		
	    
	

