package Active.base.Interfaces;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

import Active.base.bean.Features;

public interface FeaturesDAO extends DAO<Features,ObjectId> {
//	// Insert a Feature Document and return OBID
//	public ObjectId InsertFeatue(Features feature);
//	// Update a Feature Document 
//	public boolean UpdateFeature(Features feature);
//	// Delete a feature Document
//	public boolean DeleteFeature(Features feature);
//	// List Features by Type Zernike , SIFT, SURF ...
//	public List<Features> FindByFeatureType(String FeatureType);
	// List All Feature Documents
		public List<Features> FindAllFeatures();
		
}
