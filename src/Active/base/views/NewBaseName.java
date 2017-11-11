package Active.base.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class NewBaseName{
	private JTextField txtfield;
	private JButton okButton, cancelButton;
	private JFrame NBNFrame;
	 public NewBaseName(){
		 NBNFrame = new JFrame("Enter a new DataBase name ");
		 NBNFrame.setPreferredSize(new Dimension(400, 150));
		 txtfield = new JTextField(20);
		 okButton = new JButton("ok");
		 cancelButton = new JButton("cancel");
		 NBNFrame.add(txtfield,BorderLayout.PAGE_START);
		 NBNFrame.add(okButton,BorderLayout.CENTER);
		 NBNFrame.add(cancelButton,BorderLayout.PAGE_END);
		 NBNFrame.pack();
		 NBNFrame.setVisible(true);
	 }
	public JTextField getTxtfield() {
		return txtfield;
	}
	public void setTxtfield(JTextField txtfield) {
		this.txtfield = txtfield;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	public JFrame getNBNFrame() {
		return NBNFrame;
	}
	public void setNBNFrame(JFrame nBNFrame) {
		NBNFrame = nBNFrame;
	}
	 
	
	       
	  }

	  
	
	   
