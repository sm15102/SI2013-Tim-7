package etf.si.projekat.data_vision;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JSeparator;

public class SensorChoosingPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SensorChoosingPanel() {
		setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Sensor type 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(30, 36, 95, 14);
		add(lblNewLabel);
		
		JLabel lblSensorType = new JLabel("Sensor type 2");
		lblSensorType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType.setBounds(30, 61, 95, 14);
		add(lblSensorType);
		
		JLabel lblSensorType_1 = new JLabel("Sensor type 3");
		lblSensorType_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_1.setBounds(30, 87, 95, 14);
		add(lblSensorType_1);
		
		JLabel lblSensorType_2 = new JLabel("Sensor type 4");
		lblSensorType_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_2.setBounds(30, 113, 95, 14);
		add(lblSensorType_2);
		
		JLabel lblSensorType_3 = new JLabel("Sensor type 5");
		lblSensorType_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_3.setBounds(30, 141, 95, 14);
		add(lblSensorType_3);
		
		JLabel lblSensorType_4 = new JLabel("Sensor type 6");
		lblSensorType_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_4.setBounds(30, 165, 95, 14);
		add(lblSensorType_4);
		
		JLabel lblSensorType_5 = new JLabel("Sensor type 7");
		lblSensorType_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_5.setBounds(30, 192, 95, 14);
		add(lblSensorType_5);
		
		JLabel lblSensorType_6 = new JLabel("Sensor type 8");
		lblSensorType_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_6.setBounds(30, 216, 95, 14);
		add(lblSensorType_6);
		
		JLabel lblSensorType_7 = new JLabel("Sensor type 9");
		lblSensorType_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_7.setBounds(30, 241, 95, 14);
		
		Choice choice = new Choice();
		choice.setBounds(158, 30, 138, 20);
		add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(158, 55, 138, 20);
		add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(158, 81, 138, 20);
		add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(158, 107, 138, 20);
		add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(158, 135, 138, 20);
		add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(158, 159, 138, 20);
		add(choice_5);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(158, 186, 138, 20);
		add(choice_6);
		
		Choice choice_7 = new Choice();
		choice_7.setBounds(158, 210, 138, 20);
		add(choice_7);
		
		Choice choice_8 = new Choice();
		choice_8.setBounds(158, 235, 138, 20);
		add(choice_8);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 337, 2);
		add(separator);
		
		JLabel lblSensorType_8 = new JLabel("Sensor type ");
		lblSensorType_8.setBounds(54, 0, 83, 25);
		add(lblSensorType_8);
		
		JLabel lblSensorType_9 = new JLabel("Sensor type 9");
		lblSensorType_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType_9.setBounds(30, 241, 95, 14);
		add(lblSensorType_9);

	}

}
