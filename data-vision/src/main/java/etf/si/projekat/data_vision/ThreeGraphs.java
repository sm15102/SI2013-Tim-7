package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ThreeGraphs extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreeGraphs frame = new ThreeGraphs();
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
	public ThreeGraphs() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGraphType = new JLabel("Graph type");
		lblGraphType.setBounds(118, 83, 60, 14);
		contentPane.add(lblGraphType);
		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval from");
		lblTimeIntervalFrom.setBounds(83, 103, 95, 14);
		contentPane.add(lblTimeIntervalFrom);
		
		JLabel lblTimeIntervalTo = new JLabel("Time interval to");
		lblTimeIntervalTo.setBounds(95, 128, 83, 14);
		contentPane.add(lblTimeIntervalTo);
		
		JLabel lblDataNumber = new JLabel("Data number");
		lblDataNumber.setBounds(108, 153, 70, 14);
		contentPane.add(lblDataNumber);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner.setBounds(184, 150, 99, 20);
		contentPane.add(spinner);
		
		Choice choice = new Choice();
		choice.setBounds(184, 77, 99, 20);
		choice.add("Chart");
		choice.add("Line");
		contentPane.add(choice);
		
		Button button = new Button("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
Integer value = (Integer)spinner.getValue();
				
				if(value == 1){
					
					//Add1Sensor a = new Add1Sensor("Line");
					//a.setVisible(true);
				}
				
				else if(value == 2){
					
					Add2Sensors a = new Add2Sensors();
					a.setVisible(true);
				}
				
				else if(value == 3){
					
					Add3Sensors a = new Add3Sensors();
					a.setVisible(true);
				}
				
				else if(value == 4){
						
						Add4Sensors a = new Add4Sensors();
						a.setVisible(true);
					}
				
				
				else if(value == 5){
					
					Add5Sensors a = new Add5Sensors();
					a.setVisible(true);
				}
				
				else if(value == 6){
					
					Add6Sensors a = new Add6Sensors();
					a.setVisible(true);
				}
				
				else if(value == 7){
					
					Add7Sensor a = new Add7Sensor();
					a.setVisible(true);
				}
				
				else if(value == 8){
					
					Add8Sensors a = new Add8Sensors();
					a.setVisible(true);
				}
				
				else{
					
					Add9Sensors a = new Add9Sensors();
					a.setVisible(true);
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
		button_1.setBounds(279, 230, 70, 22);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(184, 100, 99, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 125, 99, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
