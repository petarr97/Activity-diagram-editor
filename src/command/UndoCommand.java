package command;

import java.awt.Point;

import ConfigurationWindows.ActivityFrame;
import ConfigurationWindows.ConfigurationControllers;
import model.ActivityElement;
import views.EditToolBar;
import views.MenuBarView;

public class UndoCommand {
	
	 public void execute() {
	      Command command;
	      try {
	    	  command = CommandHistory.popU();
	    	CommandHistory.pushR(command);
	    
	    	  command.unexecute();	
	    	  
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
	   }

}
