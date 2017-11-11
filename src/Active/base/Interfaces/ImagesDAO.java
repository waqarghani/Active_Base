package Active.base.Interfaces;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

//import Active.base.Util.ImageSearchType;
import Active.base.bean.Images;


public interface ImagesDAO extends DAO<Images, ObjectId>{
	/*//Insert an Image with all its fields
	public ObjectId InsertImage(Images image);
	// Update an Image's fields 
	public boolean UpdateImage(Images image);
	// Delete or IsValid Hide an image record or Document 
	public boolean DeleteImage(Images image);
	// Find Images by Property
	public List<Images> FindImagesByProperty(ImageSearchType searchtype, Object value);*/
	// Find all Images
	public List<Images> FindAllImages();

}
