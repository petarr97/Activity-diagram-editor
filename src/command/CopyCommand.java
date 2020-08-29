/***********************************************************************
 * Module:  CopyCommand.java
 * Author:  Admir Orman
 * Purpose: Defines the Class CopyCommand
 ***********************************************************************/

package command;

import java.util.*;

import Drawing.TabComponent;
import globalClases.ClipboardClass;
import globalClases.ToolboxGlobalClass;
import model.Element;
import mouseListeners.PanelMouseListener;
import tree.projectExplorerView.TreeView;

public class CopyCommand extends CanvasCommand {
	Element clickedPanel;
	ToolboxGlobalClass klasa=ToolboxGlobalClass.getInstance();
	TabComponent tab;
	ClipboardClass pomocna=ClipboardClass.getInstance();
	boolean ctrl;
	public CopyCommand(Element clickedPanel,Boolean ctrl) {
		this.clickedPanel=clickedPanel;
	
		this.tab = (TabComponent) clickedPanel.getParent();
	
		this.ctrl=ctrl;
		
	}
   public void execute() {
	   if( ctrl==false)
		{
			
			pomocna.getElement().clear();
			pomocna.getElement().add(clickedPanel);
			pomocna.setTab(tab);
			
		//	pomocna.setNaziv(tab.getNaziv());
			PanelMouseListener.brojac = 0;
		}
		else if( ctrl)
		{
			//ClipboardClass pomocna = ClipboardClass.getInstance();
			if(PanelMouseListener.brojac == 0)
				pomocna.getElement().clear();
			
			pomocna.getElement().add(clickedPanel);
			ClipboardClass.setTab(tab);
			ClipboardClass.setNaziv(tab.getNaziv());
			PanelMouseListener.brojac++;
		}
	   
	   

   }
   
   public void unexecute() {
      // TODO: implement
   }

}