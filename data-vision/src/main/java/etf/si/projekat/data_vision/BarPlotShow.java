package etf.si.projekat.data_vision;
import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;


import de.erichseifert.gral.plots.BarPlot;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.GraphicsUtils;
import de.erichseifert.gral.util.Insets2D;
import de.erichseifert.gral.util.Location;
import de.erichseifert.gral.examples.ExamplePanel;




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

import java.awt.BasicStroke;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.Component;

public class BarPlotShow extends ExamplePanel {

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
	public BarPlotShow(Choice _sensorChoice) { 
		sensorChoice=_sensorChoice;
		
		 DataTable data = new DataTable(Double.class, Integer.class, String.class);
         data.add(0.1,  1, "January");
         data.add(0.2,  3, "February");
         data.add(0.3, -2, "March");
         data.add(0.4,  6, "April");
         data.add(0.5, -4, "May");
         data.add(0.6,  8, "June");
         data.add(0.7,  9, "July");
         data.add(0.8, 11, "August");
         // Create new bar plot
         BarPlot plot = new BarPlot(data);
         // Format plot
         plot.setInsets(new Insets2D.Double(40.0, 40.0, 40.0, 40.0));
         plot.setBarWidth(0.075);
         // Format bars
         BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderer(data);
         pointRenderer.setColor(
                 new LinearGradientPaint(0f,0f, 0f,1f,
                                 new float[] { 0.0f, 1.0f },
                                 new Color[] { COLOR1, GraphicsUtils.deriveBrighter(COLOR1) }
                 )
         );
         pointRenderer.setBorderStroke(new BasicStroke(3f));
         pointRenderer.setBorderColor(
                 new LinearGradientPaint(0f,0f, 0f,1f,
                                 new float[] { 0.0f, 1.0f },
                                 new Color[] { GraphicsUtils.deriveBrighter(COLOR1), COLOR1 }
                 )
         );
         pointRenderer.setValueVisible(true);
         pointRenderer.setValueColumn(2);
         pointRenderer.setValueLocation(Location.CENTER);
         pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
         pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));
         // Add plot to Swing component
        // add(new InteractivePanel(plot));
         
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
	       
	       InteractivePanel interactivePanel = new InteractivePanel(plot);
	       plot.getTitle().setText("Bar plot");
			interactivePanel.setBounds(new Rectangle(0, 0, 0, 50));
			f.getContentPane().add(interactivePanel, BorderLayout.CENTER);

 }
 @Override
 public String getTitle() {
         return "Bar plot";
 }
 @Override
 public String getDescription() {
         return "Bar plot with example data and color gradients";
 }


}
