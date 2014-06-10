package etf.si.projekat.data_vision;

import java.awt.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GlavniFrame extends JFrame {

	private static final Logger logger = Logger.getLogger(GlavniFrame.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BasicInformationPanel basicInfo;
	private TwoGraphsViewPanel twoGraphs;
	private ThreeGraphsViewPanel threeGraphs;
	private TableViewPanel tableView;
	
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniFrame frame = new GlavniFrame();
					
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				  //  frame.setResizable(false); // no resize 
				    
				    
				//	frame.setVisible(true);
				} catch (Exception e) {
					logger.log( Level.SEVERE, "context", e );
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 630);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Data Vision");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
				
			}
		});
		mnNewMenu.add(mntmExit);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About aboutTeam7 = new About();
				aboutTeam7.setVisible(true);
			}
		});
		mntmAbout.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AboutTeam7 frame = new AboutTeam7();
				frame.setName("About us");
			
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAbout);
		
		
		
		//PANE
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//tabbedPane.setBounds(0, 0, 1200,1200);
		tabbedPane.setBounds(new Rectangle(0, 0, 985, 590));
		tabbedPane.setBorder(new CompoundBorder());
		
		TwoGraphsViewPanel twographsviewpanel1 = new TwoGraphsViewPanel(tabbedPane);
		ThreeGraphsViewPanel threegraphsviewpanel1 = new ThreeGraphsViewPanel(tabbedPane);
		
		//BasicInformationPanel basicInfo2 = new BasicInformationPanel(); ovo mijenjalaa
		
		
	/*	basicInfo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				
			}
		});*/
		contentPane.setLayout(null);
		
		
		
	
	
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("One graph view", null, tabbedPane1, null);
		basicInfo = new BasicInformationPanel(tabbedPane1);
		tabbedPane1.add("Basic data",basicInfo);
		basicInfo.setLayout(null);
		
		
		
		JTabbedPane tabbedPane3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Two graph view", null, tabbedPane3, null);
		tabbedPane3.setBounds(new Rectangle(0, 0,1200, 1200));
		twoGraphs = new TwoGraphsViewPanel(tabbedPane3);
		tabbedPane3.add("Two graphs",twoGraphs);
		twoGraphs.setLayout(null);

		
		JTabbedPane tabbedPane4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Three graph view", null, tabbedPane4, null);
		threeGraphs = new ThreeGraphsViewPanel(tabbedPane4);
		tabbedPane4.add("Three graphs", threeGraphs);
		threeGraphs.setLayout(null);
	
		
		JTabbedPane tabbedPane5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Table view", null, tabbedPane5, null);
		tabbedPane.setEnabledAt(3, true);
		tableView=new TableViewPanel(tabbedPane5);
		tableView.setLayout(null);
		tableView.setBackground(Color.white);
		//TREBA OVDJE TABLEVIEW DA BUDE ISTE VELICINE KAO I TAB, ODNOSNO TABELU POVECATI
		tableView.setBounds(10, 49, 694, 501);
		tabbedPane5.add("Table view",tableView);
		tabbedPane5.setBounds(10, 49, 694, 501);
		
		
		JTabbedPane tabbedPane6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Consumption", null, tabbedPane6, null);
		Consumption c= new Consumption();
		c.setBounds(10, 49, 694, 501);
		tabbedPane6.add("Consumption",c);
		contentPane.add(tabbedPane);
		tabbedPane6.setBounds(10, 49, 694, 501);
		
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane2.setBounds(0, 45, 912, 516);
		contentPane.add(tabbedPane2);
		tabbedPane2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			};
		});
		
		

		
		
		
		
		
	}

	
}
