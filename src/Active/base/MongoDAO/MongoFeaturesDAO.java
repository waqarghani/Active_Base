package Active.base.MongoDAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import Active.base.Interfaces.FeaturesDAO;
import Active.base.bean.Features;


public class MongoFeaturesDAO extends BasicDAO<Features, ObjectId> implements FeaturesDAO{

	public MongoFeaturesDAO(Class<Features> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Features> FindAllFeatures() {
		Query<Features> query = createQuery();
		return query.asList();
	}

}
