import javax.swing.JList;

import Active.base.BaseConnect;
import Active.views.SelectBase;
import ij.IJ;
import ij.plugin.PlugIn;

public class Baserun_ implements PlugIn{
	
		public void run(String arg0) {
			IJ.log("entry");
			BaseConnect b1 = new BaseConnect();
			//MongoDatabase k = b1.getBaseName();
			@SuppressWarnings({ "unchecked", "rawtypes" })
			JList list = new JList(b1.getBaseList().toArray());
			 SelectBase enter = new SelectBase("Please select an item in the list", list);
			 enter.show();
			b1.close();
		}
	}


