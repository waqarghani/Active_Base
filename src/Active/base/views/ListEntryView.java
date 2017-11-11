package Active.base.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Active.base.Model.MainFrameModel;
import Active.base.bean.Images;
import ij.IJ;

public class ListEntryView {
	private JList<Images> EntryList;
	 private JFrame ListView;
	 private JButton Open,Query,Remove,Update,SimilarImages;
	 private JTextField QueryField;
	 private JPanel RightPanel;
	 private MainFrameModel LinkListDefaultModel;
//	 public ListEntryView() {
//		 ListPanel();
//		}
	 
	 public ListEntryView(String SetTitle, MainFrameModel LinkListDefaultModel) {
		 //this();
		 ListPanel();
		 ListView.setTitle(SetTitle);
		 this.LinkListDefaultModel = LinkListDefaultModel;
	 }
	 

//	 public ListEntryView(String SetTitle)
//	 {
//		 this();
//		 ListView.setTitle(SetTitle);
//	 }

	 private void ListPanel(){
		 LinkListDefaultModel = new MainFrameModel();
		 ListView = new JFrame();
		 RightPanel = new JPanel();
		// ListModel = new DefaultListModel<Images>();
		 ListView.setPreferredSize(new Dimension(600, 200)); 
		 Open = new JButton("Open");
		 Query = new JButton("Query");
		 Remove = new JButton("Remove");
		 Update = new JButton("Update");
		 SimilarImages = new JButton("SimilarImages");
		 QueryField = new JTextField(20);  
		 EntryList = new JList(LinkListDefaultModel.setListModel());
		 //EntryList.setModel(LinkListDefualtModel.setmodel());
		 ListView.setLayout(new GridLayout(1,1));
		 ListView.getContentPane().add(new JScrollPane(EntryList), BorderLayout.CENTER);
		 RightPanel.add(Open,BorderLayout.PAGE_END);
		 RightPanel.add(Query,BorderLayout.PAGE_END);
		 RightPanel.add(Remove,BorderLayout.PAGE_END);
		 RightPanel.add(Update,BorderLayout.PAGE_END);
		 RightPanel.add(SimilarImages,BorderLayout.PAGE_END);
		 RightPanel.add(QueryField,BorderLayout.PAGE_END);
		 ListView.getContentPane().add(RightPanel, BorderLayout.SOUTH);
		 ListView.add(RightPanel);
		 ListView.pack();  
	     ListView.setVisible(true);
	 }
	 
	 public JList<Images> getEntryList() {
		return EntryList;
	}

	public void setEntryList(JList<Images> entryList) {
		EntryList = entryList;
	}

	public void addOpenListener(ActionListener listenForOpenButton){   
	        Open.addActionListener(listenForOpenButton);}

	 public void addQueryListener(ActionListener listenForQueryButton){   
		 	Query.addActionListener(listenForQueryButton);}
	 
	 public void addRemoveListener(ActionListener listenForRemoveButton){   
	        Remove.addActionListener(listenForRemoveButton);}

	 public void addUpdateListener(ActionListener listenForUpdateButton){   
		 	Update.addActionListener(listenForUpdateButton);}
	 
	 public void addSimilarImagesListener(ActionListener listenForSimilarImagesButton){   
		 	SimilarImages.addActionListener(listenForSimilarImagesButton);}

	public String[] getSelectedItem() {
		String[] ItemAsArray;
		ItemAsArray = EntryList.getSelectedValue().toString().split("~|#");
		return ItemAsArray;
	}

	public JTextField getQueryField() {
		return QueryField;
	}

	public void setQueryField(String queryField) {
		QueryField.setText(queryField); 
	}

//	public DefaultListModel<Images> getListModel() {
//		return ListModel;
//	}
//
//	public void setListModel(DefaultListModel<Images> ListModel) {
//		this.ListModel = ListModel;
//	}
	 
	 
		
}
