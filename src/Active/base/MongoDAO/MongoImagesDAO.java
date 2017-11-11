package Active.base.MongoDAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import Active.base.Interfaces.ImagesDAO;
import Active.base.bean.Images;
import ij.IJ;


public class MongoImagesDAO extends BasicDAO<Images, ObjectId> implements ImagesDAO {

	public MongoImagesDAO(Class<Images> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	@Override
	public List<Images> FindAllImages() {
		Query<Images> query = createQuery();
		return query.asList();
	}

	

}
