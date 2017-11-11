package Active.base.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Active.base.Model.MainFrameModel;
import Active.base.bean.Features;
import Active.base.bean.Images;
import Active.base.bean.ROI;
import Active.base.views.CentralView;
import Active.base.views.ListEntryView;
import Active.base.views.ParamTable;
import ij.IJ;


public class CentralViewController {
	
	// The Controller coordinates interactions
	// between the View and Model
	
		private CentralView CVView;
		private MainFrameModel MFModel,ListEntryModel;
		private ListEntryView ListEntryView;
		private ParamTable ParamTablee;
		private DefaultTableModel TableModel;
		private String[] ColumnNames = { "Parameter Name", "Parameter value" };
		
		
		public CentralViewController(CentralView CVView, MainFrameModel MFModel) {
			this.CVView = CVView;
			this.MFModel = MFModel;
			
			// Tell the View that when ever the calculate button
			// is clicked to execute the actionPerformed method
			// in the CalculateListener inner class
			
			this.CVView.addImportListener(new ImportListener());
			this.CVView.addInsertListener(new InsertListener());
		}
		
		public CentralViewController(ListEntryView ListEntryView, MainFrameModel MFModel){
			this.ListEntryView=ListEntryView;
			this.MFModel=MFModel;
			
			this.ListEntryView.addOpenListener(new OpenListener());
			this.ListEntryView.addQueryListener(new QueryListener());
			this.ListEntryView.addRemoveListener(new RemoveListener());
			this.ListEntryView.addSimilarImagesListener(new SimilarImagesListener());
			this.ListEntryView.addUpdateListener(new UpdateListener());
		}
		
		public CentralViewController(ParamTable ParamTablee, MainFrameModel MFModel){
			this.ParamTablee = ParamTablee;
			this.MFModel = MFModel;
			
			
		}
		class InsertListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				MFModel.runActiveSeg();
			//CVView.setDataArea();
			}
		
		}
		
		
		class ImportListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//MFModel.saveEntityExample();
				CVView.setDataArea("Welcome to "+MFModel.getbaseName());
				ListEntryView = new ListEntryView("Image Collection",MFModel);
				//ListEntryModel = new MainFrameModel();
				 CentralViewController theLEController = new CentralViewController(ListEntryView,MFModel);
			}
			
		}
		
		class OpenListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] ere; 
				ere = ListEntryView.getSelectedItem();
				int count = 0;
				String[][] ere2d = new String[ere.length/2][2]; 
				ListEntryView.setQueryField("WE are in!!! Controller is working");
				for (int i = 0; i < ere.length/2; i++)
				{
					for(int j = 0; j < 2; j++)
					{
						
						if(count==ere.length) break;
			            ere2d[i][j]=ere[count];
			            count++;
					}
				}
				TableModel = new DefaultTableModel(ere2d,ColumnNames);
				ParamTablee = new ParamTable("WEll how does it looks",TableModel);
			}
		}
		
		class RemoveListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			Images remimg;
			remimg = ListEntryView.getEntryList().getSelectedValue();
			MFModel.RemoveImage(remimg);
			IJ.log("The Item has been removed...");
			
			}
		
		}
		
		
		class SimilarImagesListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			List<Features> totfeat = MFModel.getFeat(); 
			for(int i = 0; i <= totfeat.size();i++)
			{
				List<Double> x = totfeat.get(i).getFeatureValues();
				IJ.log("x is :"+x);
				List<Double> y = totfeat.get(i + 1).getFeatureValues();
				IJ.log("Sim measure is :"+ MFModel.SimpleL2Norm(x, y));
			}
//			for(Features f: totfeat)
//							{
//							List<Double> x = f.getFeatureValues();
//							
//							list<Double> y = 
//							IJ.log("value is"+f.getFeatureValues());
//							IJ.log("iterator is"+f.getFeatureValues().iterator());
//							List<Double> j = totfeat.get(i);
//							for (int i = 0 ; i <totfeat.size();i++)
//							{
//							MFModel.SimpleL2Norm(f.getFeatureValues(), f.getFeatureValues());
//							}
//							}
					}
				
				}
			
			
		
		
		
		class UpdateListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			}
		
		}
		
		class QueryListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
			       String IDNumber = ListEntryView.getQueryField().getText();
			       IJ.log(IDNumber);
//			       if (IDNumber == "") {
//			    	   IJ.log("null !!");
//			            return;
//			       }
			
			       Collections.sort(MFModel.getImg());
			       int foundIndex = Collections.binarySearch(MFModel.getImg(), new Images(IDNumber));
			       IJ.log("index is"+ foundIndex);
		        if (foundIndex >= 0) {
		            ListEntryView.getEntryList().setSelectedIndex(foundIndex);
			        } else {	IJ.log("could not find the image record");  }
		    }
		
			}
		
		
		
		}

		
	


