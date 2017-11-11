package Active.base.Interfaces;
import Active.base.bean.ROI;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;


public interface ROIDAO extends DAO<ROI,ObjectId>{
//	//Insert ROI Document and return OBID
//	public ObjectId InsertROI(ROI roi);
//	//Update a field in ROI Document 
//	public boolean UpdateROI(ROI roi);
//	// Delete a ROI Document
//	public boolean DeleteROI(ROI roi);
//	// List on Base of Type such as Circular or Rectangular
//	public List<ROI> FindByROIType(String RoiType);
	// List All ROI documents 
	public List<ROI> FindAllROI();
}
