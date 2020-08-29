/***********************************************************************
 * Module:  ConfigurationElementCommand.java
 * Author:  Admir Orman
 * Purpose: Defines the Class ConfigurationElementCommand
 ***********************************************************************/

package command;

import java.awt.Frame;
import java.util.*;

import ConfigurationWindows.ActivityFrame;
import model.ActivityElement;
import model.Element;
import views.ObserverInterface;


public class ConfigurationElementCommand extends ElementCommand {
	Element element;
	ObserverInterface view;

	
	public ConfigurationElementCommand(Element element,ObserverInterface view) {
		this.element=element;
		this.view=view;
		
		
	}

public void execute() {
		 
			if(element instanceof ActivityElement) {
				
				element.naziv = ((ActivityFrame)view).imetxt.getText();
				element.code = ((ActivityFrame)view).codetxt.getText();
				element.comment = ((ActivityFrame)view).commenttxt.getText();
				element.keywords = ((ActivityFrame)view).keywordstxt.getText();
				((ActivityElement)element).preCondition = ((ActivityFrame)view).preconditiontxt.getText();
				((ActivityElement)element).postCondition =((ActivityFrame)view). postconditiontxt.getText();
				((ActivityElement)element).action = ((ActivityFrame)view).actiontxt.getText();
				((ActivityElement)element).anotation = ((ActivityFrame)view).annonationtxt.getText();
				((ActivityElement)element).descritpion = ((ActivityFrame)view).descriptiontxt.getText();
				
			
			}
			
			CommandHistory.pushU(this);
   }
   
   public void unexecute() {
	  
	   if(element instanceof ActivityElement) {
			
			element.naziv = ((ActivityFrame)view).imetxt.getText();
			element.code = ((ActivityFrame)view).codetxt.getText();
			element.comment = ((ActivityFrame)view).commenttxt.getText();
			element.keywords = ((ActivityFrame)view).keywordstxt.getText();
			((ActivityElement)element).preCondition = ((ActivityFrame)view).preconditiontxt.getText();
			((ActivityElement)element).postCondition =((ActivityFrame)view). postconditiontxt.getText();
			((ActivityElement)element).action = ((ActivityFrame)view).actiontxt.getText();
			((ActivityElement)element).anotation = ((ActivityFrame)view).annonationtxt.getText();
			((ActivityElement)element).descritpion = ((ActivityFrame)view).descriptiontxt.getText();
			
		
		}
     
   }

}