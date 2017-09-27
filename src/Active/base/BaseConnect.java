package Active.base;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ij.IJ;

public class BaseConnect {
	
	private  String  BaseName = null;
	private  List<String> dbs = new ArrayList<String>();
	private MongoClient mongoClient = null;
	
	public BaseConnect(){
		dbs = new ArrayList<String>();
		mongoClient = new MongoClient("localhost",27017); //Maybe replace it with an already existing client
		 MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
	        while(dbsCursor.hasNext()) {
	            dbs.add(dbsCursor.next());
	        }
	    IJ.log("databse names are"+dbs);
	}
	
	  public void close() {  
		  
		  	mongoClient.close();	        
	  }
	  
	  public void setBaseName(MongoDatabase dbname)
	  {
				if (dbs.contains(dbname))
				{
					IJ.log("This Database " + dbname + " already exists and is executed!");
					
				}
				else 
				{
					IJ.log("New database " + dbname + " is created!");
				}
				
	  }
	 public void setBaseName(String baseName) {
		BaseName = baseName;
	}

	public MongoDatabase getBaseName() {
			MongoDatabase Baseis = mongoClient.getDatabase(BaseName);
			IJ.log(Baseis.getName() + "activated now");
          return Baseis;
      }
	
	 public List<String> getBaseList(){
		 return this.dbs;
	 }
}
