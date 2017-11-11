package Active.base.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SelectBase {
	@SuppressWarnings("rawtypes")
	private JList list;
	private JLabel label;
	    private JButton okButton, cancelButton, newBase;
	    private JPanel panel,Listpanel,Buttonpanel;
	    private JFrame SBFrame;
	    @SuppressWarnings("rawtypes")
		public SelectBase(JList listToDisplay){
	    	list = listToDisplay;
	    	SBFrame = new JFrame("Welcome to Active-Base");
	    	SBFrame.setPreferredSize(new Dimension(400, 150));  
	    	label = new JLabel("please select a database");
	    	okButton = new JButton("Ok");
	        cancelButton = new JButton("Cancel");
	        newBase = new JButton("newBase");
	    	panel = new JPanel(new GridLayout(1,1));
	    	Listpanel = new JPanel();
	    	Buttonpanel = new JPanel();
	    	DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
		    renderer.setHorizontalAlignment(SwingConstants.CENTER);
	    	Listpanel.setLayout(new BorderLayout(5,5));
	    	Buttonpanel.setLayout(new BorderLayout());
	    	Listpanel.add(label, BorderLayout.NORTH);
	    	Listpanel.add(list,BorderLayout.CENTER);
	    	Buttonpanel.add(okButton,BorderLayout.PAGE_START);
	    	Buttonpanel.add(cancelButton,BorderLayout.CENTER);
	    	Buttonpanel.add(newBase,BorderLayout.PAGE_END);
	    	panel.add(Listpanel);
	    	panel.add(Buttonpanel);
	    	SBFrame.add(panel,BorderLayout.CENTER);
	    	SBFrame.pack();
	    	SBFrame.setVisible(true);
	    }
	    
	    public void buttonActionListeners(ActionListener al)
	    {
	        okButton.setActionCommand("Ok");
	        cancelButton.setActionCommand("Cancel");
	        newBase.setActionCommand("newBase");
	        okButton.addActionListener(al);
	        cancelButton.addActionListener(al);
	        newBase.addActionListener(al);
	    }
		 
			public void setList(JList list) {
				this.list = list;
			}
			
			public JList getList(){
				return list;
			}
			
			public Object getitem(){
				return list.getSelectedValue();
			}
			
			public void hide(){
				SBFrame.setVisible(false);
			}
	    
	    
}    
	    
	
	    

