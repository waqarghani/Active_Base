package Active.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Active.base.BaseConnect;
import ij.IJ;
 
public class NewBaseName{
	private JTextField txtfield;
	private JButton okButton, cancelButton;
	private ActionListener okEvent, cancelEvent;
	 private JOptionPane optionPane;
	 private JDialog dialog;
	 private String txt;
	 public NewBaseName(){
	        init();
	    }
	    
	    public NewBaseName(String title){
	        this();
	        dialog.setTitle(title);
	    }
	 
	 private void init()
	 {
		
		 txtfield = new JTextField();
		 setupButtons();
		 JPanel pane = layoutComponents();
		 optionPane = new JOptionPane(pane);
		 optionPane.setOptions(new Object[]{okButton, cancelButton});
		 dialog = optionPane.createDialog("Insert name for new Database"); 
	 }
	 
	  private void setupButtons(){
	        okButton = new JButton("ok");
	        okButton.addActionListener(e -> handleOkButtonClick(e));

	        cancelButton = new JButton("Cancel");
	        cancelButton.addActionListener(e -> handleCancelButtonClick(e));
	       
	  }
	  
	  private JPanel layoutComponents(){
	        JPanel panel = new JPanel(new BorderLayout(5,5));
	        panel.add(txtfield, BorderLayout.NORTH);
	        return panel;
	    }
	  
	 private void handleOkButtonClick(ActionEvent e){
	    	if(okEvent != null){ okEvent.actionPerformed(e);}
	    	txt = txtfield.getText();
	    	IJ.log(txt);
	    	BaseConnect baseconnected = new BaseConnect();
	    	baseconnected.setBaseName(txt);
	    	baseconnected.getBaseName();
	    	hide();
	    }
	 
	  private void handleCancelButtonClick(ActionEvent e){
	        if(cancelEvent != null){ cancelEvent.actionPerformed(e);}
	        hide();   
	    }
	    
	  public void show(){ dialog.setVisible(true); }
	  
	  private void hide(){ dialog.setVisible(false); }
	  
	
	   
}