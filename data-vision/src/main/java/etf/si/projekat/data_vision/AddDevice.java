package etf.si.projekat.data_vision;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.util.logging.Logger;
import java.util.logging.Level;
import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

import java.awt.Color;

public class AddDevice extends JFrame { //extends JFrame
	private static final Logger logger = Logger.getLogger(AddDevice.class.getName());

	private JPanel contentPane;
	private JTextField textField2;
	private JTextField textField3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDevice frame = new AddDevice();
					frame.setVisible(true);
				} catch (Exception e) {
					
					logger.log( Level.SEVERE, "context", e );
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddDevice() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGraphType = new JLabel("Device name");
		lblGraphType.setBounds(98, 84, 73, 14);
		contentPane.add(lblGraphType);
		
		JLabel lblTimeIntervalFrom = new JLabel("Device type");
		lblTimeIntervalFrom.setBounds(98, 139, 111, 14);
		contentPane.add(lblTimeIntervalFrom);
		
		Button button = new Button("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField2.getText().matches("\\s+")|| textField3.getText().matches("\\s+")){
					JOptionPane.showMessageDialog(null, "Nisu sva polja ispunjena", "AlertBox", JOptionPane.WARNING_MESSAGE);
				}else{
				DeviceName dn = new DeviceName();
				dn.setName(textField2.getText());
				HibernateDeviceName hdn = new HibernateDeviceName();
				hdn.addDeviceName(dn);
				
				DeviceType dt = new DeviceType();
			
				dt.setType(textField3.getText());
				HibernateDeviceType hdt = new HibernateDeviceType();
				hdt.addDeviceType(dt);
				
				JOptionPane.showMessageDialog(null, "New device added.", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				}
			}
		});
		button.setBounds(354, 230, 70, 22);
		contentPane.add(button);
		
		Button button1 = new Button("Cancel");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button1.setBounds(278, 230, 70, 22);
		contentPane.add(button1);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 434, 36);
		contentPane.add(panel);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 191, 255));
		panel1.setBounds(0, 218, 434, 54);
		contentPane.add(panel1);
		
		textField2 = new JTextField();
		textField2.setBounds(181, 81, 86, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(180, 136, 86, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
	}
}
