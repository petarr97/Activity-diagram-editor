/***********************************************************************
 * Module:  MainClass.java
 * Author:  Admir Orman
 * Purpose: Defines the Class MainClass
 ***********************************************************************/

package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import views.MainWindow;

public class MainClass  {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		MainWindow prozor = new MainWindow();
		prozor.show();
		
		  try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	    } 

	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	}
}