package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.Choice;

import javax.swing.SpinnerNumberModel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.SpringLayout;

public class TwoGraphs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1220749560655781995L;
	private JPanel contentPane;
	//private JTextField textField;
	// JTextField textField_1;
	public Choice choice;
	private SpringLayout springLayout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TwoGraphs frame = new TwoGraphs();
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
	public TwoGraphs() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), -23, SpringLayout.SOUTH, datePicker);
        springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), -6, SpringLayout.SOUTH, datePicker);
        springLayout = (SpringLayout) datePicker.getLayout();
        datePicker.setLocation(143, 86);
        datePicker.setSize(127, 22);
       
        contentPane.add(datePicker);
        
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
        SpringLayout springLayout_1 = (SpringLayout) datePicker1.getLayout();
        springLayout_1.putConstraint(SpringLayout.WEST, datePicker1.getJFormattedTextField(), 0, SpringLayout.WEST, datePicker1);
        datePicker1.setLocation(143, 119);
        datePicker1.setSize(127, 27);
        contentPane.add(datePicker1);
		
		JLabel lblDataType = new JLabel("Graph type:");
		lblDataType.setBounds(42, 66, 70, 14);
		contentPane.add(lblDataType);
		
		JLabel lblTimeIntervalForm = new JLabel("Time interval form:");
		lblTimeIntervalForm.setBounds(10, 91, 123, 14);
		contentPane.add(lblTimeIntervalForm);
		
		JLabel lblTimeIntervalTo = new JLabel("Time interval to:");
		lblTimeIntervalTo.setBounds(20, 126, 117, 14);
		contentPane.add(lblTimeIntervalTo);
		
		JLabel lblDataNumber = new JLabel("Data number:");
		lblDataNumber.setBounds(30, 155, 103, 14);
		contentPane.add(lblDataNumber);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner.setBounds(143, 152, 127, 20);
		contentPane.add(spinner);
		
		 choice = new Choice();
		choice.setBounds(143, 60, 127, 20);
		choice.add("Line");
		choice.add("Bar");
		contentPane.add(choice);
		//final String type=(String) choice.getSelectedItem();
		final int type1=choice.getSelectedIndex();
		Button button = new Button("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
Integer value = (Integer) spinner.getValue();
				
				if(value == 1){
					
				Add1Sensor a = new Add1Sensor(choice.getSelectedItem(), datePicker, datePicker1);
				a.setVisible(true);
				}
				
				if(value == 2){
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
				
				else  if(value == 9){
					
					Add9Sensors a = new Add9Sensors(choice.getSelectedItem(),datePicker, datePicker1);
					a.setVisible(true);
				}
				
				else {}
				
			}
			
			
		});
		button.setBounds(341, 230, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(265, 230, 70, 22);
		contentPane.add(button_1);
		
		
		 
	
		 
		
		
		
		/*textField = new JTextField();
		textField.setBounds(143, 88, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 110, 127, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);*/
	}
}
