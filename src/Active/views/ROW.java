package Active.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Active.base.BaseConnect;

public class ROW {
	private JButton ReadButton, WriteButton;
	private ActionListener ReadEvent, WriteEvent;
	 private JOptionPane optionPane;
	 private JDialog dialog;
	 private JLabel label;
	 
	 public ROW(){
		 WelcomePanel();
	    }
	    
	    public ROW(String title){
	        this();
	        dialog.setTitle(title);
	        
	    }
	    private void WelcomePanel(){
	        setupButtons();
	        JPanel pane = layoutComponents();
	        optionPane = new JOptionPane(pane);
	        optionPane.setOptions(new Object[]{ReadButton, WriteButton});
	        dialog = optionPane.createDialog("Welcome to Active-Base");
	    }

	    private void setupButtons(){
	        ReadButton = new JButton("Read");
	        ReadButton.addActionListener(e -> handleReadButtonClick(e));

	        WriteButton = new JButton("Write");
	        WriteButton.addActionListener(e -> handleWriteButtonClick(e));
	        
	        
	    }
	    private JPanel layoutComponents(){
	        label = new JLabel("Read operation includes searching database depending on user queries, while write operations" 
	        		+"are basic CRUD (Create, Replace, Update and Delete)");
	        JPanel panel = new JPanel(new BorderLayout(5,5));
	        panel.add(label, BorderLayout.NORTH);
	        return panel;
	    }
	    
	    private void handleReadButtonClick(ActionEvent e){
	        if(ReadEvent != null){ ReadEvent.actionPerformed(e);}
	        BaseConnect b1 = new BaseConnect();
	        JList list = new JList(b1.getBaseList().toArray());
			 SelectBase enter = new SelectBase("Please select an item in the list", list);
			 enter.show();
			b1.close();
	        hide();
	    }
	    
	    private void handleWriteButtonClick(ActionEvent e){
	    	if(WriteEvent != null){WriteEvent.actionPerformed(e);}
	    	hide();	
	    }
	    public void show(){ dialog.setVisible(true); }

	    private void hide(){ dialog.setVisible(false); }
}
