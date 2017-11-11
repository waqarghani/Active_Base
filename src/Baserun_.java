
//import Active.base.DAO.SBModel;
//import Active.base.Util.BaseConnect;
//import Active.base.views.SelectBase;
//import Active.controllers.SBController;
import Active.base.Controller.CentralViewController;
import Active.base.Model.MainFrameModel;
import Active.base.views.CentralView;
import ij.IJ;
import ij.plugin.PlugIn;

public class Baserun_ implements PlugIn{
	
		public void run(String arg0) {
			
			IJ.log("entry");
			
			 CentralView theMainView = new CentralView(); 
			  MainFrameModel theMainModel = new MainFrameModel();
			  CentralViewController theMainController = new CentralViewController(theMainView,theMainModel);
					


		}
	}


