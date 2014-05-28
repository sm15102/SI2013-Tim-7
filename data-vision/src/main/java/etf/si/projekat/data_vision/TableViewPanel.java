package etf.si.projekat.data_vision;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Choice;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import java.awt.Component;

public class TableViewPanel extends JPanel
{
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTabbedPane tabbedPane;
	public TableViewPanel(JTabbedPane tabbedPane1) 
	{
		 tabbedPane=tabbedPane1;
		setLayout(null);
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
	    setBounds(100, 100, 986, 478);
	   
	    table = new JTable();
	    Object[][] data = new Object[5][3];
	    data[0][0] = "0";
	    data[0][1] = "0";
	    data[0][2] = "0";
	    table.setModel(model);
	    table.getColumnModel().getColumn(0).setResizable(false);
	    table.getColumnModel().getColumn(0).setPreferredWidth(56);
	    table.getColumnModel().getColumn(4).setPreferredWidth(110);        
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(45, 33, 739, 445);
		add(scrollPane);
		
		JButton btnAddSensor = new JButton("Add Device");
		btnAddSensor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDevice a = new AddDevice();
				a.setVisible(true);
			}
		});
		btnAddSensor.setBounds(825, 30, 114, 23);
		add(btnAddSensor);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int size=model.getRowCount();
					for(int i=0;i<size;i++)
					{
						model.removeRow(0);
					}
					popuniTabelu();
			}
		});
		btnRefresh.setBounds(825, 64, 114, 23);
		add(btnRefresh);
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
}}
