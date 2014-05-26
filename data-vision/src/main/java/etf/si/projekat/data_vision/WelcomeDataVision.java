package etf.si.projekat.data_vision;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.Point;

public class WelcomeDataVision extends JFrame {
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeDataVision frame = new WelcomeDataVision();
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
	public WelcomeDataVision() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		/*JLabel lblSnjezaDodatiWelcome = new JLabel("Snjeza dodati welcome sliku :D");
		lblSnjezaDodatiWelcome.setLocation(new Point(9, 6));
		lblSnjezaDodatiWelcome.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Welcome", lblSnjezaDodatiWelcome);
		/*tabbedPane.addTab("One graph", new JLabel(""));
		tabbedPane.addTab("Two graphs", new JLabel("This is tab 3"));
		tabbedPane.addTab("Three graphs", new JLabel("This is tab 4"));
		tabbedPane.addTab("Table view", new JLabel("This is tab 5"));
		tabbedPane.addTab("Consumption", new JLabel("This is tab 6"));
		contentPane.add(tabbedPane);
		
		JLabel lblGraphType = new JLabel("Graph type");
		lblGraphType.setBounds(98, 56, 73, 14);
		//tabbedPane.add(lblGraphType);
		//tabbedPane.getTabComponent.add(lblGraphType, BorderLayout.WEST);
		*/
		
		final JPanel content = new JPanel();
	    JPanel tab = new JPanel();
	    tab.setOpaque(false);
	   
	    JLabel tabLabel = new JLabel("Welcome" );
	    tab.add(tabLabel, BorderLayout.WEST);
	    tabbedPane.addTab(null, content);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab);
		
	    final JPanel content2 = new JPanel();
	    JPanel tab2 = new JPanel();
	    tab2.setOpaque(false);
	    JLabel tabLabel2 = new JLabel("One graph " );
	    tab2.add(tabLabel2);
	    tabbedPane.addTab(null, content2);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab2);
	    
	    final JPanel content3 = new JPanel();
	    JPanel tab3 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel3 = new JLabel("Two graphs" );
	    tab3.add(tabLabel3);
	    tabbedPane.addTab(null, content3);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab3);
	    
	    final JPanel content4 = new JPanel();
	    JPanel tab4 = new JPanel();
	    tab4.setOpaque(false);
	    JLabel tabLabel4= new JLabel("Three graphs" );
	    tab4.add(tabLabel4);
	    tabbedPane.addTab(null, content4);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab4);
	    
	    final JPanel content5 = new JPanel();
	    JPanel tab5 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel5 = new JLabel("Table view" );
	    tab5.add(tabLabel5);
	    tabbedPane.addTab(null, content5);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab5);
	    
	    final JPanel content6 = new JPanel();
	    JPanel tab6 = new JPanel();
	    tab3.setOpaque(false);
	    JLabel tabLabel6 = new JLabel("Consumption" );
	    tab3.add(tabLabel6);
	    tabbedPane.addTab(null, content6);
	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1, tab6);
	    
	    
	    
	    contentPane.add(tabbedPane);
	    
	    
	}
}
