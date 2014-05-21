package etf.si.projekat.data_vision;
import javax.swing.JFrame;

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataTable;
//import de.erichseifert.gral.examples.ExamplePanel;
//import de.erichseifert.gral.graphics.Label;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.axes.AxisRenderer;
import de.erichseifert.gral.plots.axes.LogarithmicRenderer2D;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.DiscreteLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.DefaultPointRenderer2D;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.plots.points.SizeablePointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Orientation;







import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;

public class OneGraphShow extends JFrame {

	private JPanel contentPane;
	private JFrame f;
	public Choice sensorChoice;
	
	// * Launch the application.
	// */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
		//	public void run() {
				try {
				  // new OneGraphShow();
				
				     		    
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		
	}

	/**
	 * Create the frame.
	 */
	public OneGraphShow(Choice _sensorChoice) {   
		sensorChoice=_sensorChoice;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(1000, 1000);
	        
	       //Podaci koji ce se prikazivati na grafu 
	       DataTable data = new DataTable(Double.class, Double.class);
	       double x = 1; 
	       double y = 17;
	       data.add(x, y);
	       x = 2; 
	       y = 16;
	       data.add(x, y);
	        
	       x = 3; 
	       y = 18;
	       data.add(x, y);
	        
	      x = 4; 
	       y = 20;
	       data.add(x, y);
	        
	        x = 5; 
	       y = 19;
	       data.add(x, y);
	        
	       x = 6; 
	        y = 22;
	       data.add(x, y);
	        
	       x = 7; 
	       y = 20;
	       
	       data.add(x, y);
	        //kreiranje 2D grafa
	       XYPlot plot = new XYPlot(data);
	       //prikaz grafa na frameu
	     //  add(new InteractivePanel(plot));

	     plot.setVisible(data, true);
	     plot.setInsets(new Insets2D.Double(20.0, 40.0, 40.0, 40.0));
	     // plot.setBackground(Color.WHITE);

         plot.getTitle().setText("Temperature  for 7 days");
         LineRenderer lines = new DefaultLineRenderer2D();
         plot.setLineRenderer(data, lines);
         Color color = new Color(0.0f, 0.3f, 1.0f);
         plot.getPointRenderer(data).setColor(color);
         plot.getLineRenderer(data).setColor(color);
      // Draw a tick mark and a grid line every 10 units along x axis
         plot.getAxisRenderer(XYPlot.AXIS_X).setTickSpacing(1.0);
         // Draw a tick mark and a grid line every 20 units along y axis
         plot.getAxisRenderer(XYPlot.AXIS_Y).setTickSpacing(1.0);
         
        
	     
	     f = new JFrame();
	     f.setEnabled(true);
	     f.getContentPane().setBackground(Color.white);
	     f.getContentPane().setBounds(new Rectangle(10, 10, 10, 10));
	     f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     f.setVisible(true);
	   
     
	  
	     
	     
		f.setBounds(200, 100, 750, 550);
			contentPane = new JPanel();
			contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
			contentPane.setBounds(new Rectangle(50, 0, 50, 50));
			contentPane.setBackground(Color.white);
			contentPane.setBounds(10,10,5,5);
			
	       f.getContentPane().add(contentPane, BorderLayout.NORTH);
	    

		
	   
		JButton btnEyport = new JButton("Export");
		btnEyport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Nije implementirano.", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEyport.setSize(new Dimension(2, 1));
		btnEyport.setBounds(100, 100, 10, 10);
		contentPane.add(btnEyport, BorderLayout.WEST);
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		btnClose.setBounds(270, 207, 128, 23);
		contentPane.add(btnClose);
		
			//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			//setContentPane(contentPane);
			
			JButton btnChange = new JButton("Change");
			btnChange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Nije implementirano.", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			contentPane.add(btnChange);
			btnChange.setBounds(270, 154, 128, 23);
			InteractivePanel interactivePanel = new InteractivePanel(plot);
			interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
			f.getContentPane().add(interactivePanel, BorderLayout.CENTER);
		
	}

}
