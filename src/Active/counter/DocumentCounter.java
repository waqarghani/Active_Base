package Active.counter;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class DocumentCounter {
	
		 private static MongoDatabase  dbConnection = null;
		 private static MongoCollection<Document> counter1 = null;
		 @SuppressWarnings("resource")

	     public static MongoDatabase getDatabaseConnection() {

	        if(dbConnection == null) {

	          MongoClient mongoClient = new MongoClient("localhost", 27017);

	            dbConnection = mongoClient.getDatabase("abc");
	            System.out.println(dbConnection.toString());
	       }
	       return dbConnection;
	    }
		 public static MongoCollection<Document> getCounter1() {
			 MongoCollection<Document> counter1 = dbConnection.getCollection("counter");
				return counter1;
			}
		  public static Object getNextSequence(String name) throws Exception{
			    BasicDBObject find = new BasicDBObject();
			    find.put("_id", name);
			    BasicDBObject update = new BasicDBObject();
			    update.put("$inc", new BasicDBObject("seq", 1));
			    Document obj =  getCounter1().findOneAndUpdate(find, update);
			    return obj.get("seq");
			}
		public static void main(String[] args) throws Exception{
			MongoDatabase connection = getDatabaseConnection();
	  	  System.out.println(connection);
	  	  MongoCollection<Document> counter = getCounter1();
	  	System.out.println(counter);
			// TODO Auto-generated method stub
	  	Document document0 = new Document();
	  	document0.put("_id", "userid");
	  	document0.put("seq", 0);
	  	counter.insertOne(document0);
	  	
			Document document1 = new Document();
			 document1.put("_id", getNextSequence("userid"));
			    document1.put("name","Sarah C.");
			    counter.insertOne(document1); // insert first doc

			    document1.put("_id", getNextSequence("userid"));
			    document1.put("name", "Bob D.");
			    counter.insertOne(document1); // insert second doc
		}
		
		/*public static void setCounter1(MongoCollection<Document> counter1) {
			DocumentCounter.counter1 = counter1;
		}*/

	}

