/***********************************************************************
 * Module:  CommandHistory.java
 * Author:  Admir Orman
 * Purpose: Defines the Class CommandHistory
 ***********************************************************************/

package command;

import java.util.Stack;

public class CommandHistory {
   public static Stack<Command> undoStack=new Stack<Command>();
   public static Stack<Command> redoStack=new Stack<Command>();
   /** @param command */
   public static void pushU(Command command) {
	   undoStack.push(command);
   }
   
   public static Command popU() {
     
      return undoStack.pop();
    
   }
   
   public static void pushR(Command command) {
	   redoStack.push(command);
   }
   
   public static Command popR() {
     
      return redoStack.pop();
    
   }

}