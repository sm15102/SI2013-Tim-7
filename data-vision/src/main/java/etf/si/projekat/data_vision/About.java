package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2796036938770896102L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
				    
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
	public About() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 285, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeam = new JLabel("Made by:");
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam.setBounds(10, 11, 71, 28);
		contentPane.add(lblTeam);
		
		JLabel lblTeam_1 = new JLabel("Team7");
		lblTeam_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTeam_1.setBounds(10, 38, 46, 14);
		contentPane.add(lblTeam_1);
		
		JLabel lblDevelopers = new JLabel("Developers:");
		lblDevelopers.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopers.setBounds(10, 75, 156, 14);
		contentPane.add(lblDevelopers);
		
		JLabel lblMelikaKiselica = new JLabel("Melika Kiselica");
		lblMelikaKiselica.setBounds(10, 100, 103, 14);
		contentPane.add(lblMelikaKiselica);
		
		JLabel lblEnesMujic = new JLabel("Enes Mujic");
		lblEnesMujic.setBounds(10, 119, 103, 14);
		contentPane.add(lblEnesMujic);
		
		JLabel lblSnjezanaMiletic = new JLabel("Snjezana Miletic");
		lblSnjezanaMiletic.setBounds(10, 138, 103, 14);
		contentPane.add(lblSnjezanaMiletic);
		
		JLabel lblSalemMaglic = new JLabel("Salem Maglic");
		lblSnjezanaMiletic.setBounds(10, 138, 103, 14);
		contentPane.add(lblSnjezanaMiletic);
		
		JLabel lblAdnanOmanovic = new JLabel("Adnan Omanovic");
		lblAdnanOmanovic.setBounds(10, 156, 103, 14);
		contentPane.add(lblAdnanOmanovic);
		
		JLabel lblNadinaKunalic = new JLabel("Nadina Kunalic");
		lblNadinaKunalic.setBounds(10, 174, 108, 14);
		contentPane.add(lblNadinaKunalic);
		
		JLabel lblRijadMuhic = new JLabel("Rijad Muhic");
		lblRijadMuhic.setBounds(10, 192, 234, 14);
		contentPane.add(lblRijadMuhic);
		
		JLabel lblcopyrightByTeam = new JLabel(" ©Copyright by Team7");
		lblcopyrightByTeam.setBounds(10, 236, 192, 14);
		contentPane.add(lblcopyrightByTeam);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\snjezana.miletic\\Documents\\GitHub\\SI2013Tim7\\design\\cmon-icon-about.png"));
		label.setBounds(113, 19, 156, 151);
		contentPane.add(label);
		
		
		
	}
}
