package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

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
		btnNewButton.setForeground(Color.BLACK);
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
		
		JLabel label = new JLabel("");
		label.setBounds(105, 73, 423, 191);
		contentPane.add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon("slikapozadina.jpg"));
		
		JLabel lblView = new JLabel("View");
		lblView.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblView.setBounds(28, 58, 55, 23);
		contentPane.add(lblView);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 56, 461, 208);
		contentPane.add(panel);
		
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 262, 461, 48);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("DATA VISION\r\n\r\n");
		lblNewLabel.setFont(new Font("Rosewood Std Regular", Font.BOLD, 28));
		lblNewLabel.setBounds(28, 9, 441, 36);
		contentPane.add(lblNewLabel);
		
	
		
			
	}
}
