package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Choice;

import javax.swing.JSpinner;

import java.awt.Button;

import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class OneGraph extends JFrame {

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
					OneGraph frame = new OneGraph();
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
	public OneGraph() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGraphType = new JLabel("Graph type");
		lblGraphType.setBounds(65, 51, 73, 14);
		contentPane.add(lblGraphType);
		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval from");
		lblTimeIntervalFrom.setBounds(37, 76, 111, 14);
		contentPane.add(lblTimeIntervalFrom);
		
		JLabel lblTimeIntervalTo = new JLabel("Time interval to");
		lblTimeIntervalTo.setBounds(47, 101, 91, 14);
		contentPane.add(lblTimeIntervalTo);
		
		JLabel lblDataNumber = new JLabel("Data number");
		lblDataNumber.setBounds(65, 126, 83, 14);
		contentPane.add(lblDataNumber);
		
		Choice choice = new Choice();
		choice.setBounds(144, 49, 117, 20);
		choice.add("Line");
		choice.add("Bar");
		contentPane.add(choice);
		
		final JSpinner spinner = new JSpinner();
		spinner.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner.setBounds(144, 123, 117, 20);
		
		contentPane.add(spinner);
		//final String type=(String) choice.getSelectedItem();
		final int type1=choice.getSelectedIndex();
		Button button = new Button("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer value = (Integer) spinner.getValue();
				if(value == 1){
					
					Add1Sensor a = new Add1Sensor(type1);
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 2){
					
					Add2Sensors a = new Add2Sensors();
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 3){
					
					Add3Sensors a = new Add3Sensors();
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 4){
						
						Add4Sensors a = new Add4Sensors();
						a.setVisible(true);
						dispose();
					}
				
				
				else if(value == 5){
					
					Add5Sensors a = new Add5Sensors();
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 6){
					
					Add6Sensors a = new Add6Sensors();
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 7){
					
					Add7Sensor a = new Add7Sensor();
					a.setVisible(true);
					dispose();
				}
				
				else if(value == 8){
					
					Add8Sensors a = new Add8Sensors();
					a.setVisible(true);
					dispose();
				}
				
				else{
					
					Add9Sensors a = new Add9Sensors();
					a.setVisible(true);
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
		
		textField = new JTextField();
		textField.setBounds(144, 73, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 98, 117, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
