package Active.base.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CentralView{
		
	    private JPanel MainPanel;    
	    private JTextArea DataArea;        
	    private JButton Import,Insert;         
	    private JFrame CentralView;
	    public CentralView(){
	        CentralView = new JFrame("Database View");     
	        
	        MainPanel = new JPanel();             
	        DataArea = new JTextArea();       
	        Import = new JButton("Import Database");
	        Insert = new JButton("Insert New Record");
	        CentralView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        CentralView.setPreferredSize(new Dimension(800, 150)); 
	        CentralView.setResizable(false);
	        MainPanel.setLayout(new BorderLayout());
	        MainPanel.add(Import,BorderLayout.LINE_START);
	        MainPanel.add(DataArea,BorderLayout.CENTER);
	        MainPanel.add(Insert,BorderLayout.LINE_END);  
	        CentralView.add(MainPanel);
	        CentralView.pack();  
	        CentralView.setVisible(true);
	    }
		
	    public void addImportListener(ActionListener listenForImportButton){   
	    	Import.addActionListener(listenForImportButton);}
	    
	    public void addInsertListener(ActionListener listenForInsertButton){   
	        Insert.addActionListener(listenForInsertButton);}
	    
	    

		public void setDataArea(String dataAreaText) {
			DataArea.setText(dataAreaText); 
		}

		public String getDataArea() {
			return DataArea.getText();
		}


	}