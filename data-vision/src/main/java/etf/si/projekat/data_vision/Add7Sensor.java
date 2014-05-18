package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add7Sensor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add7Sensor frame = new Add7Sensor();
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
	public Add7Sensor() {
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSensorType = new JLabel("Sensor type 1");
		lblSensorType.setBounds(27, 54, 87, 14);
		contentPane.add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 2");
		lblSensorType_1.setBounds(27, 79, 87, 14);
		contentPane.add(lblSensorType_1);
		
		JLabel lblSensorType_2 = new JLabel("Sensor type 3");
		lblSensorType_2.setBounds(27, 108, 87, 14);
		contentPane.add(lblSensorType_2);
		
		JLabel lblSensorType_3 = new JLabel("Sensor type 4");
		lblSensorType_3.setBounds(27, 134, 87, 14);
		contentPane.add(lblSensorType_3);
		
		JLabel lblSensorType_4 = new JLabel("Sensor type 5");
		lblSensorType_4.setBounds(27, 160, 87, 14);
		contentPane.add(lblSensorType_4);
		
		JLabel lblSensorType_5 = new JLabel("Sensor type 6");
		lblSensorType_5.setBounds(27, 186, 87, 14);
		contentPane.add(lblSensorType_5);
		
		JLabel lblSensorType_6 = new JLabel("Sensor type 7");
		lblSensorType_6.setBounds(27, 211, 87, 14);
		contentPane.add(lblSensorType_6);
		
		Choice choice = new Choice();
		choice.setBounds(106, 48, 120, 20);
		contentPane.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(106, 73, 120, 20);
		contentPane.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(106, 102, 120, 20);
		contentPane.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(106, 128, 120, 20);
		contentPane.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(106, 154, 120, 20);
		contentPane.add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(106, 180, 120, 20);
		contentPane.add(choice_5);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(106, 205, 120, 20);
		contentPane.add(choice_6);
		
		JButton btnProcess = new JButton("Process");
		btnProcess.setBounds(277, 246, 89, 23);
		contentPane.add(btnProcess);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(178, 246, 89, 23);
		contentPane.add(btnCancel);
	}

}