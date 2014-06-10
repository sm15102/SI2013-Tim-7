package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AboutTeam7 extends JFrame {

	private JPanel contentPane;
		private static final Logger logger = Logger.getLogger(AboutTeam7.class.getName());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutTeam7 frame = new AboutTeam7();
					frame.setVisible(true);
				} catch (Exception e) {
					logger.log( Level.SEVERE, "context", e );
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutTeam7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
