package etf.si.projekat.data_vision;

import java.awt.*;

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
import java.awt.FlowLayout;


import java.awt.Rectangle;

//import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.JSeparator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GlavniFrame extends JFrame {

	
	private JPanel contentPane;
	private BasicInformationPanel basicInfo;
	private TwoGraphsViewPanel twoGraphs;
	private TableViewPanel tableView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniFrame frame = new GlavniFrame();
					
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				    frame.setResizable(false);
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 620);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//tabbedPane.setBounds(0, 0, 1200,1200);
		tabbedPane.setBounds(new Rectangle(0, 0, 985, 561));
		tabbedPane.setBorder(new CompoundBorder());
		
		TwoGraphsViewPanel twographsviewpanel1 = new TwoGraphsViewPanel(tabbedPane);
		//BasicInformationPanel basicInfo2 = new BasicInformationPanel(); ovo mijenjalaa
		//ThreeGraphsViewPanel basicInfo3 = new ThreeGraphsViewPanel();
		
	/*	basicInfo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				
			}
		});*/
		contentPane.setLayout(null);
		
		
		
	
	
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("One graph view", null, tabbedPane_1, null);
		basicInfo = new BasicInformationPanel(tabbedPane_1);
		tabbedPane_1.add("Basic data",basicInfo);
		basicInfo.setLayout(null);
		
		
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Two graph view", null, tabbedPane_3, null);
		tabbedPane_3.setBounds(new Rectangle(0, 0,1200, 1200));
		twoGraphs = new TwoGraphsViewPanel(tabbedPane_3);
		tabbedPane_3.add("Basic info",twoGraphs);
		twoGraphs.setLayout(null);

		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Three graph view", null, tabbedPane_4, null);
		//tabbedPane_4.add(basicInfo3);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Table view", null, tabbedPane_5, null);
		tabbedPane.setEnabledAt(3, true);
		tableView=new TableViewPanel(tabbedPane_5);
		tableView.setLayout(null);
		tableView.setBackground(Color.white);
		//TREBA OVDJE TABLEVIEW DA BUDE ISTE VELICINE KAO I TAB, ODNOSNO TABELU POVECATI
		tableView.setBounds(10, 49, 694, 501);
		tabbedPane_5.add("Table view",tableView);
		tabbedPane_5.setBounds(10, 49, 694, 501);
		
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Consumption", null, tabbedPane_6, null);
		Consumption c= new Consumption();
		c.setBounds(10, 49, 694, 501);
		tabbedPane_6.add("Consumption",c);
		contentPane.add(tabbedPane);
		tabbedPane_6.setBounds(10, 49, 694, 501);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 45, 912, 516);
		contentPane.add(tabbedPane_2);
		tabbedPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			};
		});
		
		

		
		
		
		
		
	}
}
