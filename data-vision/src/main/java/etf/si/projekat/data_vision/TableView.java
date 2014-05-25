package etf.si.projekat.data_vision;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.beans.EventLogs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import etf.si.projekat.data_vision.AddSensorsTableView;
import etf.si.projekat.util.HibernateUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TableView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
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
	public TableView() {
		model=new DefaultTableModel(
	        	new Object[][] {},
	            	new String[] {
	            		"Br.", "User", "Device name", "Device type", "Event message", "Value", "Timestamp"
	            	}
	            ) {
	            	Class[] columnTypes = new Class[] {
	            		Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
	            	};
	            	public Class getColumnClass(int columnIndex) {
	            		return columnTypes[columnIndex];
	            	}
	            	boolean[] columnEditables = new boolean[] {
	            		false, false, false, false, false, false, false
	            	};
	            	public boolean isCellEditable(int row, int column) {
	            		return columnEditables[column];
	            	}
	            };
		setBounds(100, 100, 506, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		table = new JTable();
		Object[][] data = new Object[14][3];
        data[0][0] = "0";
        data[0][1] = "0";
        data[0][2] = "0";
        table.setModel(model);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(56);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
		contentPane.add(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
			int size=model.getRowCount();
			for(int i=0;i<size;i++)
			{
				model.removeRow(0);
			}
			popuniTabelu();
			}
			
		});
		
		JButton btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addGap(5)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(12)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnRefresh)
        					.addGap(4)
        					.addComponent(btnExit))))
        );
        contentPane.setLayout(gl_contentPane);
        
        popuniTabelu();
	}
	class CustModel extends AbstractTableModel {
        private String[] columnNames = {"Sensor Id", "Sensor Name","Sensor Value"};
        private Object[][] data = null;

        public CustModel(Object[][] data) {
            this.data = data;
        }
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    }
	
	private void popuniTabelu()
	{
		List<EventLogs> temp=new ArrayList<EventLogs>();
		List<EventLogs> sveKolone=pokupiPodatke();
		if(sveKolone.size()<=10)
		{
			temp=sveKolone;
		}
		else{
			int start=sveKolone.size()-10;
			for(int i=start;i<sveKolone.size();i++)
			{
				temp.add(sveKolone.get(i));
			}
		}
		
	//"Br.", "User", "Device name", "Device type", "Even message", "Value", "Timestamp"
		for(int i=0;i<temp.size();i++)
		{
			EventLogs e=temp.get(i);
			String user=e.getActivity_logs().getUser();
			String devName=e.getDevice_name();
			String devType=e.getDevice_type();
			String evMessage=e.getEvent_message();
			String value=String.valueOf(e.getValue());
			
			SimpleDateFormat format=new SimpleDateFormat("hh:mm:ss    dd.MM.yyyy.");
			
			String time=format.format(e.getTimestamp().getTime());
			model.addRow(new Object[]{i+1,user,devName,devType,evMessage,value,time });
		}
	}
	
	private List<EventLogs> pokupiPodatke(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<EventLogs> temp=new ArrayList<EventLogs>();
		Transaction t = session.beginTransaction();
		temp=session.createCriteria(EventLogs.class).list();
		return temp;
	}
}
