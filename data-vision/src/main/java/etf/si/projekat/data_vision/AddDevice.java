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

import ba.unsa.etf.si.beans.DeviceName;
import ba.unsa.etf.si.beans.DeviceType;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceName;
import ba.unsa.etf.si.hibernate_klase.HibernateDeviceType;

import java.awt.Color;

public class AddDevice extends JFrame { //extends JFrame

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	

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
					e.printStackTrace();
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
				
				
				if(textField_2.getText().isEmpty() || textField_3.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Nisu sva polja ispunjena", "AlertBox", JOptionPane.WARNING_MESSAGE);
				}
				else{
				DeviceName dn = new DeviceName();
				dn.setName(textField_2.getText());
				HibernateDeviceName hdn = new HibernateDeviceName();
				hdn.addDeviceName(dn);
				
				DeviceType dt = new DeviceType();
			
				dt.setType(textField_3.getText());
				HibernateDeviceType hdt = new HibernateDeviceType();
				hdt.addDeviceType(dt);
				
				JOptionPane.showMessageDialog(null, "Novi uređaj dodan", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				}
			}
		});
		button.setBounds(354, 230, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(278, 230, 70, 22);
		contentPane.add(button_1);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 434, 36);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 218, 434, 54);
		contentPane.add(panel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 81, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 136, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
	}
}
