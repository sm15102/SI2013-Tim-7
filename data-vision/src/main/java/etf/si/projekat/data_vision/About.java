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
		
		JLabel lblTeam = new JLabel("Comming soon");
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTeam.setBounds(10, 10, 108, 28);
		contentPane.add(lblTeam);
		
		JLabel lblTeam_1 = new JLabel("maybe later");
		lblTeam_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTeam_1.setBounds(10, 35, 93, 14);
		contentPane.add(lblTeam_1);
		
		JLabel lblDevelopers = new JLabel("Starring");
		lblDevelopers.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevelopers.setBounds(10, 75, 156, 14);
		contentPane.add(lblDevelopers);
		
		JLabel lblMelikaKiselica = new JLabel("Melika Kiselica");
		lblMelikaKiselica.setBounds(141, 91, 103, 14);
		contentPane.add(lblMelikaKiselica);
		
		JLabel lblEnesMujic = new JLabel("Enes Mujic");
		lblEnesMujic.setBounds(10, 100, 103, 14);
		contentPane.add(lblEnesMujic);
		
		JLabel lblSnjezanaMiletic = new JLabel("Snjezana Miletic");
		lblSnjezanaMiletic.setBounds(63, 116, 103, 14);
		contentPane.add(lblSnjezanaMiletic);
		
		JLabel lblSalemMaglic = new JLabel("Salem Maglic");
		lblSalemMaglic.setBounds(155, 222, 103, 14);
		contentPane.add(lblSalemMaglic);
		
		JLabel lblAdnanOmanovic = new JLabel("Adnan Omanovic");
		lblAdnanOmanovic.setBounds(0, 141, 103, 14);
		contentPane.add(lblAdnanOmanovic);
		
		JLabel lblNadinaKunalic = new JLabel("Nadina Kunalic");
		lblNadinaKunalic.setBounds(136, 141, 108, 14);
		contentPane.add(lblNadinaKunalic);
		
		JLabel lblRijadMuhic = new JLabel("Rijad Muhic");
		lblRijadMuhic.setBounds(27, 174, 76, 14);
		contentPane.add(lblRijadMuhic);
		
		JLabel lblcopyrightByTeam = new JLabel("Made in China");
		lblcopyrightByTeam.setBounds(66, 247, 192, 14);
		contentPane.add(lblcopyrightByTeam);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\snjezana.miletic\\Documents\\GitHub\\SI2013Tim7\\design\\cmon-icon-about.png"));
		label.setBounds(113, 19, 156, 151);
		contentPane.add(label);
		
		
		
	}
}
