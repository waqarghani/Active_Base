package Active.base.Interfaces;
import Active.base.bean.UserClass;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;


	public interface UserClassDAO extends DAO<UserClass, ObjectId> {
		
//		//Insert UserClasses and return list of their ObjectID
//		public List<ObjectId> InsertUserClasses(List<UserClass> Classes);
//		//Get OBID of all Classes
//		public List<ObjectId> GetClassesIDList();
//		//Get a Specific UserClass using OBID
//		public UserClass GetUserClass(ObjectId ObjectId);
//		// Look up a UserClass using a Label
//		public UserClass LookupUserClass(String ClassLabel);
		//Get all UserClasses
		public List<UserClass> FindAllClasses();

	}
	


