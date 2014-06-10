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
		
		JLabel lblSensorType1 = new JLabel("Sensor type 3");
		lblSensorType1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType1.setBounds(30, 87, 95, 14);
		add(lblSensorType1);
		
		JLabel lblSensorType2 = new JLabel("Sensor type 4");
		lblSensorType2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType2.setBounds(30, 113, 95, 14);
		add(lblSensorType2);
		
		JLabel lblSensorType3 = new JLabel("Sensor type 5");
		lblSensorType3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType3.setBounds(30, 141, 95, 14);
		add(lblSensorType3);
		
		JLabel lblSensorType4 = new JLabel("Sensor type 6");
		lblSensorType4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType4.setBounds(30, 165, 95, 14);
		add(lblSensorType4);
		
		JLabel lblSensorType5 = new JLabel("Sensor type 7");
		lblSensorType5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType5.setBounds(30, 192, 95, 14);
		add(lblSensorType5);
		
		JLabel lblSensorType6 = new JLabel("Sensor type 8");
		lblSensorType6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType6.setBounds(30, 216, 95, 14);
		add(lblSensorType6);
		
		JLabel lblSensorType7 = new JLabel("Sensor type 9");
		lblSensorType7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType7.setBounds(30, 241, 95, 14);
		
		Choice choice = new Choice();
		choice.setBounds(158, 30, 138, 20);
		add(choice);
		
		Choice choice1 = new Choice();
		choice1.setBounds(158, 55, 138, 20);
		add(choice1);
		
		Choice choice2 = new Choice();
		choice2.setBounds(158, 81, 138, 20);
		add(choice2);
		
		Choice choice3 = new Choice();
		choice3.setBounds(158, 107, 138, 20);
		add(choice3);
		
		Choice choice4 = new Choice();
		choice4.setBounds(158, 135, 138, 20);
		add(choice4);
		
		Choice choice5 = new Choice();
		choice5.setBounds(158, 159, 138, 20);
		add(choice5);
		
		Choice choice6 = new Choice();
		choice6.setBounds(158, 186, 138, 20);
		add(choice6);
		
		Choice choice7 = new Choice();
		choice7.setBounds(158, 210, 138, 20);
		add(choice7);
		
		Choice choice8 = new Choice();
		choice8.setBounds(158, 235, 138, 20);
		add(choice8);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 21, 337, 2);
		add(separator);
		
		JLabel lblSensorType8 = new JLabel("Sensor type ");
		lblSensorType8.setBounds(54, 0, 83, 25);
		add(lblSensorType8);
		
		JLabel lblSensorType9 = new JLabel("Sensor type 9");
		lblSensorType9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSensorType9.setBounds(30, 241, 95, 14);
		add(lblSensorType9);

	}

}
