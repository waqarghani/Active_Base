package Active.base.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;

import Active.base.Interfaces.FeaturesDAO;
import Active.base.Interfaces.ImagesDAO;
import Active.base.Interfaces.ROIDAO;
import Active.base.Interfaces.UserClassDAO;
import Active.base.MongoDAO.MongoClassesDAO;
import Active.base.MongoDAO.MongoFeaturesDAO;
import Active.base.MongoDAO.MongoImagesDAO;
import Active.base.MongoDAO.MongoROIDAO;
import Active.base.Util.BaseConnect;
import Active.base.Util.IDCounter;
import Active.base.bean.Features;
import Active.base.bean.Images;
import Active.base.bean.ROI;
import Active.base.bean.UserClass;

import ij.IJ;

public class MainFrameModel{
	private BaseConnect BaseConn;
	private ImagesDAO ImagesDAO;
	private ROIDAO ROIDAO;
	private UserClassDAO UserClassDAO;
	private FeaturesDAO FeaturesDAO;
	private DefaultListModel<Images> ListModel;
	private List<Images> img; 
	private List<Features> feat;
	
	
	public MainFrameModel(){
		BaseConn = new BaseConnect();
		ImagesDAO = new MongoImagesDAO(Images.class, BaseConn.getDatastore());
		ROIDAO = new MongoROIDAO(ROI.class,BaseConn.getDatastore());
		UserClassDAO = new MongoClassesDAO(UserClass.class,BaseConn.getDatastore());
		FeaturesDAO = new MongoFeaturesDAO(Features.class,BaseConn.getDatastore());
	}
	public String getbaseName(){
		return BaseConn.getDatabaseName();
	}
	
	public DefaultListModel<Images> setListModel(){
	img = new ArrayList<Images>(); 
	img = ImagesDAO.FindAllImages();
	ListModel = new DefaultListModel<Images>();
	for(Images i :img)
		ListModel.addElement(i);
	return ListModel;
	}
	
	public void runActiveSeg(){
		IJ.run("Test Gui");
	}
//		public void saveEntityExample(){
//		Long imgid,roiid1,roiid2,featid,classid1,classid2; 
//		IDCounter idc = new IDCounter();
//		IJ.log("Save Images,ROI,Features and UserClasses entity example");
//		// Images
//		imgid = idc.CountIs("Images");
//		List<Integer> ImageDim = new ArrayList<Integer>(Arrays.asList(256,254,1));
//		Images img1 = new Images("D://Images//RatBrain.jpg", "Grayscale", false,ImageDim);
//		img1.setImageId(imgid);
//		// ROIS
//		List<Integer> RoiDim1 = new ArrayList<Integer>(Arrays.asList(25,50,40,20));
//		List<Integer> RoiDim2 = new ArrayList<Integer>(Arrays.asList(100,2,100,3));
//		roiid1 = idc.CountIs("ROI");
//		ROI roi1 = new ROI("Rectangle", RoiDim1);
//		roi1.setROIId(roiid1);
//		roiid2 = idc.CountIs("ROI");
//		ROI roi2 = new ROI("Circle",RoiDim2);
//		roi2.setROIId(roiid2);
//		// Features
//		List<Double> ParamVal = new ArrayList<Double>(Arrays.asList(30.0,2.56));
//		List<Double> FeatVal = new ArrayList<Double>(Arrays.asList(0.52,2.40,7.6500,1.204,1.4453,4568.4,110.453,0.0045,23454.56,0.0004,10.61,121.22344));
//		featid = idc.CountIs("Features");
//		Features Feat1 = new Features("Zernike Complex Moments", ParamVal, FeatVal);
//		Feat1.setFeaturesId(featid);
//		// Classes
//		classid1 = idc.CountIs("UserClass");
//		UserClass class1 = new UserClass("A","Single Walled Carbon Nano Tubes");
//		class1.setUserClassId(classid1);
//		classid2 = idc.CountIs("UserClass");
//		UserClass class2 = new UserClass("B","Silicon Wafer");
//		class2.setUserClassId(classid2);
//		// first save individual documents separately in their respective collections 
//		ImagesDAO.save(img1);
//		
//		ROIDAO.save(roi1);
//		ROIDAO.save(roi2);
//		
//		FeaturesDAO.save(Feat1);
//		
//		UserClassDAO.save(class1);
//		UserClassDAO.save(class2);
//		
//		// Add reference documents from the opposite direction 
//		
//		roi1.getClazzes().add(class1);
//		roi1.getRoiFeatures().add(Feat1);
//		
//		// save the roi document AGAIN !!! in which references are added
//		
//		ROIDAO.save(roi1);
//		
//		// next level of reference document saving
//		
//		img1.getRois().add(roi1);
//		img1.getRois().add(roi2);
//	
//		// save the image document AGAIN !!! in which references are added
//		
//		ImagesDAO.save(img1);
//			   
//		// most probably there will be one image save at a time of push record into database
//		IJ.log("After persist  : ");
//		IJ.log("Images that are saved:  " + img1.getImageId());
//		IJ.log("ROIs that are saved:  " + roi1.getROIId() + "and" + roi2.getROIId());
//		IJ.log("Features that are saved:  " + Feat1.getFeaturesId());
//		IJ.log("Classes that are saved:  " + class1.getUserClassId() + "and" + class2.getUserClassId());
//		
//	}
//	
	public void RemoveImage(Images remimg)
	{
		ImagesDAO.delete(remimg);
		
	}
	
	public  List<Images> getImg() {
		img = ImagesDAO.FindAllImages();
		return img;
	}
	
	public  List<Features> getFeat() {
		feat = FeaturesDAO.FindAllFeatures();
		return feat;
	}
	
	public double SimpleL2Norm(List<Double> a1, List<Double> b1)
	{
	        double diff_square_sum = 0.0;
	        for (int i = 0; i < a1.size(); i++) {
	            diff_square_sum += (a1.get(i) - b1.get(i)) * (a1.get(i) - b1.get(i));
	        }
	        return Math.sqrt(diff_square_sum);
	    }
	  
	    
	}
	
