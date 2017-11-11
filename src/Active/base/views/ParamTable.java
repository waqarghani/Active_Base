package Active.base.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ij.IJ;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *  shows a JTable with metadata
 */
public class ParamTable {
	private static final long serialVersionUID = -6498880715273775724L;
	
	
	private JTable table;
	private JFrame TableView;
	private DefaultTableModel DTM;

	public ParamTable(String Title,DefaultTableModel DTM) {
		TableView = new JFrame(Title);
		this.DTM=DTM;
		createAndShowTableGUI();
	}


	public void createAndShowTableGUI() {
		JPanel panel2 = new JPanel(new BorderLayout());	
		table = new JTable(DTM);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(4000);
		table.setColumnSelectionAllowed(true);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		int rowcount = table.getRowCount();
		int columncount = table.getColumnCount();
		for (int i = 0; i < rowcount ; i ++)
		{
			for (int j = 0; j < columncount ; j++)
			{
			if(table.getValueAt(i, j).equals(" FeatureValues"))
			{
				
				table.setRowHeight(i,200);
				}
		}
		}
		panel2.add(scrollPane);
		TableView.add(panel2);
		TableView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		TableView.pack();
		TableView.setVisible(true);
		
	}
}
