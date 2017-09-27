package Active.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ij.IJ;

public class SelectBase {
	@SuppressWarnings("rawtypes")
	private JList list;
	 private JLabel label;
	    private JOptionPane optionPane;
	    private JButton okButton, cancelButton, newBase;
	    private ActionListener okEvent, cancelEvent, newBaseEvent;
	    private JDialog dialog;
	    //HashMap<String, String> Kval = new HashMap<String, String>();
	    @SuppressWarnings("rawtypes")
		public SelectBase(String message, JList listToDisplay){
	        list = listToDisplay;
	        label = new JLabel(message);
	        createAndDisplayOptionPane();
	    }
	    
	    public SelectBase(String title, String message, @SuppressWarnings("rawtypes") JList listToDisplay){
	        this(message, listToDisplay);
	        dialog.setTitle(title);
	    }
	    
	    private void createAndDisplayOptionPane(){
	        setupButtons();
	        JPanel pane = layoutComponents();
	        optionPane = new JOptionPane(pane);
	        optionPane.setOptions(new Object[]{okButton, cancelButton, newBase});
	        dialog = optionPane.createDialog("Choose a Database");
	    }
	    private void setupButtons(){
	        okButton = new JButton("Ok");
	        okButton.addActionListener(e -> handleOkButtonClick(e));

	        cancelButton = new JButton("Cancel");
	        cancelButton.addActionListener(e -> handleCancelButtonClick(e));
	        
	        newBase = new JButton("newBase");
	        newBase.addActionListener(e -> handlenewBaseClick(e));
	    }
	    
	    private JPanel layoutComponents(){
	        centerListElements();
	        JPanel panel = new JPanel(new BorderLayout(5,5));
	        panel.add(label, BorderLayout.NORTH);
	        panel.add(list, BorderLayout.CENTER);
	        return panel;
	    }
	    
	    private void centerListElements(){
	        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
	        renderer.setHorizontalAlignment(SwingConstants.CENTER);
	    }
	    
	    private void handleOkButtonClick(ActionEvent e){
	        if(okEvent != null){ okEvent.actionPerformed(e); }
	        hide();
	        IJ.log("Chosen item: " + getSelectedItem());
	        
	    }
	    
	    private void handleCancelButtonClick(ActionEvent e){
	        if(cancelEvent != null){ cancelEvent.actionPerformed(e);}
	        hide();
	    }
	    
	    private void handlenewBaseClick(ActionEvent e){
	    	if(newBaseEvent != null){newBaseEvent.actionPerformed(e);}
	    	hide();
	    	NewBaseName b2 = new NewBaseName();
			b2.show();
	    }
	    
	    public void show(){ dialog.setVisible(true); }

	    private void hide(){ dialog.setVisible(false); }
	    
	    public Object getSelectedItem(){ return list.getSelectedValue(); }
	    
	    public void setOnOk(ActionListener event){ okEvent = event; }

	    public void setOnClose(ActionListener event){cancelEvent  = event;}
	    
	    public void setOnnewBase(ActionListener event){newBaseEvent  = event;}
	    

}
