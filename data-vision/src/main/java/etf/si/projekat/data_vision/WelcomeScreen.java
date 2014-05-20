package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
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
	public WelcomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 348);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ONE GRAPH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OneGraph a = new OneGraph();
				a.setVisible(true);
			}
			
			
		});
		btnNewButton.setBounds(28, 92, 197, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTwoGraphs = new JButton("TWO GRAPHS");
		btnTwoGraphs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoGraphs a = new TwoGraphs();
				a.setVisible(true);
			}
		});
		btnTwoGraphs.setBounds(28, 126, 197, 23);
		contentPane.add(btnTwoGraphs);
		
		JButton btnThreeGraphs = new JButton("THREE GRAPHS");
		btnThreeGraphs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThreeGraphs a = new ThreeGraphs();
				a.setVisible(true);
			}
		});
		btnThreeGraphs.setBounds(28, 160, 197, 23);
		contentPane.add(btnThreeGraphs);
		
		JButton btnTableView = new JButton("TABLE VIEW");
		btnTableView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableView a = new TableView();
				a.setVisible(true);
			}
		});
		btnTableView.setBounds(28, 194, 197, 23);
		contentPane.add(btnTableView);
		
		JButton btnConsumption = new JButton("CONSUMPTION");
		btnConsumption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consumption a = new Consumption();
				a.setVisible(true);
			}
		});
		btnConsumption.setBounds(28, 228, 197, 23);
		contentPane.add(btnConsumption);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 71, 461, 192);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 262, 461, 48);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO DATA VISION\r\n\r\n");
		lblNewLabel.setFont(new Font("Rosewood Std Regular", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 11, 441, 36);
		contentPane.add(lblNewLabel);
		
	}
}
