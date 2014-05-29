package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JSpinner;   

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Consumption extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consumption frame = new Consumption();
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
	public Consumption() {
		setTitle("Consumption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTimeIntervalFrom = new JLabel("Time interval to:");
		lblTimeIntervalFrom.setBounds(33, 50, 95, 14);
		contentPane.add(lblTimeIntervalFrom);
		
		JLabel lblDevice = new JLabel("Device:");
		lblDevice.setBounds(72, 82, 53, 14);
		contentPane.add(lblDevice);
		
		JLabel lblPower = new JLabel("Power:");
		lblPower.setBounds(72, 106, 53, 14);
		contentPane.add(lblPower);
		
		textField = new JTextField();
		textField.setBounds(132, 105, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		
		});
		button.setBounds(255, 168, 70, 22);
		contentPane.add(button);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(160, 168, 89, 23);
		contentPane.add(btnCalculate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 80, 117, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTimeInterfvalFrom = new JLabel("Time interval from:");
		lblTimeInterfvalFrom.setBounds(23, 25, 112, 14);
		contentPane.add(lblTimeInterfvalFrom);
		
		UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setLocation(132, 22);
        datePicker.setSize(117, 27);
        contentPane.add(datePicker);
        
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePane1 = new JDatePanelImpl(model1);
        final JDatePickerImpl datePicker1 = new JDatePickerImpl(datePane1);
        datePicker1.setLocation(132, 50);
        datePicker1.setSize(117, 27);
        contentPane.add(datePicker1);
		btnCalculate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nije implementirano.", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}
}

