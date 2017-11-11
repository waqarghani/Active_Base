package Active.base.MongoDAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import Active.base.Interfaces.UserClassDAO;
import Active.base.bean.UserClass;

public class MongoClassesDAO extends BasicDAO<UserClass, ObjectId> implements UserClassDAO{

	public MongoClassesDAO(Class<UserClass> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserClass> FindAllClasses() {
		Query<UserClass> query = createQuery();
		return query.asList();
	}

}
