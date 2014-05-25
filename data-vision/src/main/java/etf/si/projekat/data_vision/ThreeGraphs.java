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
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class ThreeGraphs extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public Choice choice;
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
		lblGraphType.setBounds(98, 56, 73, 14);
		contentPane.add(lblGraphType);
		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval from");
		lblTimeIntervalFrom.setBounds(70, 85, 111, 14);
		contentPane.add(lblTimeIntervalFrom);
		
		JLabel lblTimeIntervalTo = new JLabel("Time interval to");
		lblTimeIntervalTo.setBounds(80, 115, 91, 14);
		contentPane.add(lblTimeIntervalTo);
		
		JLabel lblDataNumber = new JLabel("Data number");
		lblDataNumber.setBounds(98, 145, 83, 14);
		contentPane.add(lblDataNumber);
		
		choice = new Choice();
		choice.setBounds(177, 50, 117, 25);
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
		spinner.setBounds(177, 140, 117, 25);
		
		contentPane.add(spinner);
		
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setLocation(176, 79);
        datePicker.setSize(117, 27);
        contentPane.add(datePicker);
        
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
        datePicker1.setLocation(176, 110);
        datePicker1.setSize(117, 27);
        contentPane.add(datePicker1);
        
        Button button = new Button("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
Integer value = (Integer)spinner.getValue();
				
				if(value == 1){
					
					//Add1Sensor a = new Add1Sensor("Line");
					//a.setVisible(true);
				}
				
				else if(value == 2){
					
					Add2Sensors a = new Add2Sensors(choice.getSelectedItem(), datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else if(value == 3){
					
					Add3Sensors a = new Add3Sensors(choice.getSelectedItem(), datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else if(value == 4){
						
						Add4Sensors a = new Add4Sensors(choice.getSelectedItem(), datePicker, datePicker1);
						a.setVisible(true);
					}
				
				
				else if(value == 5){
					
					Add5Sensors a = new Add5Sensors(choice.getSelectedItem(), datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else if(value == 6){
					
					Add6Sensors a = new Add6Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else if(value == 7){
					
					Add7Sensor a = new Add7Sensor(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else if(value == 8){
					
					Add8Sensors a = new Add8Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else{
					
					Add9Sensors a = new Add9Sensors(choice.getSelectedItem(),datePicker, datePicker1);
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
		
		/*textField = new JTextField();
		textField.setBounds(184, 100, 99, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 125, 99, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);*/
	}

}
