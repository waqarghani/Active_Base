package Active.base.MongoDAO;

import java.util.List;

import org.bson.types.ObjectId;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import Active.base.Interfaces.ROIDAO;
import Active.base.bean.ROI;


public class MongoROIDAO extends BasicDAO<ROI, ObjectId> implements ROIDAO{
	public MongoROIDAO(Class<ROI> entityClass, Datastore ds) {
		super(entityClass, ds);
	}
	@Override
	public List<ROI> FindAllROI() {
		Query<ROI> query = createQuery();
		return query.asList();
	}
	
}
