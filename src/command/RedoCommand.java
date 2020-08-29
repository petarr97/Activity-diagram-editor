package command;

public class RedoCommand {
	 public void execute() {
	      Command command;
	    
	      try {
	   
	    	  command = CommandHistory.popR();
	    	  command.execute();		
	    	 
	    	 
		} catch (Exception e) {
			// TODO: handle exception
		}
	   }

}
