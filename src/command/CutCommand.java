/***********************************************************************
 * Module:  CutCommand.java
 * Author:  Admir Orman
 * Purpose: Defines the Class CutCommand
 ***********************************************************************/

package command;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import Drawing.DragLineClass;
import Drawing.TabComponent;
import globalClases.ClipboardClass;
import globalClases.ToolboxGlobalClass;
import model.ActivityElement;
import model.DecisionElement;
import model.Element;
import model.EndElement;
import model.ModelModel;
import model.ObjectNodeElement;
import model.PackageElement;
import model.StartElement;
import model.SynchronizationElement;
import mouseListeners.PanelMouseListener;
import tree.projectExplorerView.TreeView;
import views.MainWindow;

public class CutCommand extends CanvasCommand {
	Element clickedPanel;
	ToolboxGlobalClass klasa;
	TabComponent tab;
	ClipboardClass pomocna = ClipboardClass.getInstance();
	int x;
	int y;
	String naziv;
	ModelModel model;
	TreeView treeView;
	MainWindow	mainWindow;
	public CutCommand(Element clickedPanel,ModelModel model) {
		
		this.clickedPanel=clickedPanel;
		this.klasa=ToolboxGlobalClass.getInstance();
	
		this.tab = (TabComponent) clickedPanel.getParent();
		
		this.x=clickedPanel.getX();
		this.y=clickedPanel.getY();
	this.model=model;
	mainWindow=(MainWindow) SwingUtilities.getWindowAncestor(tab);
	 treeView=mainWindow.getProjectExplorerView().getTree();
		
	}
	public CutCommand(Element clickedPanel, TabComponent tab) {
		
		this.clickedPanel=clickedPanel;
		this.klasa=ToolboxGlobalClass.getInstance();
		
		this.tab = tab;
		
		this.x=clickedPanel.getX();
		this.y=clickedPanel.getY();
		
	MainWindow	 mainWindow=(MainWindow) SwingUtilities.getWindowAncestor(tab);
		 treeView=mainWindow.getProjectExplorerView().getTree();
	
	}
	
   public void execute() {
	  // if( klasa.cut)
		{
			
			Point tacka1 = new Point((int)clickedPanel.getLocation().getX()+clickedPanel.getWidth()/2,(int)clickedPanel.getLocation().getY()+clickedPanel.getHeight()-10);
			Point tacka2 = new Point((int)clickedPanel.getLocation().getX()+clickedPanel.getWidth()/2,(int)clickedPanel.getLocation().getY()+10);
			
			
			if(tab.getFlows().size()>1)
			{
			for(int i=0;i<tab.getFlows().size();i++)
			{
				if((tab.getFlows().get(i).getX() == tacka1.getX() && tab.getFlows().get(i).getY() == tacka1.getY()))
				{
					PanelMouseListener.delete = true;
					PanelMouseListener.lista.add(new DragLineClass(i,true,false,tacka1));
				}
				else if((tab.getFlows().get(i).getX() == tacka2.getX() && tab.getFlows().get(i).getY() == tacka2.getY()))
				{
					PanelMouseListener.delete = true;
					PanelMouseListener.lista.add(new DragLineClass(i,false,true,tacka2));
					
				}
			}
		
			
			for(int i=0;i<PanelMouseListener.lista.size();i++)
			{
				if(PanelMouseListener.lista.get(i).pozicija%2==0)
				{
				tab.getFlows().set(PanelMouseListener.lista.get(i).getPozicija(),new Point(0,0));
				tab.getFlows().set(PanelMouseListener.lista.get(i).getPozicija()+1,new Point(0,0));
				}
				else if(PanelMouseListener.lista.get(i).pozicija%2!=0)
				{
					tab.getFlows().set(PanelMouseListener.lista.get(i).getPozicija(),new Point(0,0));
					tab.getFlows().set(PanelMouseListener.lista.get(i).getPozicija()-1,new Point(0,0));
				}
				
			}
			for(int i=0;i<tab.getFlows().size();i++)
			{
				if(tab.getFlows().get(i).getX()== 0 && tab.getFlows().get(i).getY() == 0)
					{
					tab.getFlows().remove(i);
					i--;
					}
			}
			}
		
			PanelMouseListener.delete = false;
			PanelMouseListener.lista.clear();
			
		
			{
				
			
				tab.remove(clickedPanel);
				tab.repaint();
				
				
				pomocna.getElement().add(clickedPanel);
				pomocna.setCut(true);
				
				pomocna.setTab(tab);
				pomocna.setNaziv(tab.getNaziv());
			
			}

			int  broj=0;
			TreeView treeView=((MainWindow)SwingUtilities.getWindowAncestor(tab)).getProjectExplorerView().getTree();
			ModelModel model=(ModelModel) ((DefaultMutableTreeNode)tab.getDokument().getNode().getParent()).getUserObject();
			if(clickedPanel instanceof ActivityElement) {
					
				
				for (int i = 0; i < model.getActivityElements().size(); i++) {
				
					if (model.getActivitiesNode().getChildAt(i).toString()==clickedPanel.getNaziv()) {
						broj=i;
						model.getActivitiesNode().remove(i);
						model.getActivityElements().remove(clickedPanel);
						
					}
				}
				
				}
			else if (clickedPanel instanceof DecisionElement) {
				
			
			for (int i = 0; i <model.getDecisionElements().size(); i++) {
				if (model.getDecisionsNode().getChildAt(i).toString()==clickedPanel.getNaziv()) {
					model.getDecisionElements().remove(clickedPanel);
					model.getDecisionsNode().remove(i);
				}
			}
			
			
			}
			
			else if (clickedPanel instanceof ObjectNodeElement) {
				
			
				for (int i = 0; i < model.getObjectNodeElements().size(); i++) {
					if (model.getObjectNodesNode().getChildAt(i).toString()==clickedPanel.getNaziv()) {
						model.getObjectNodesNode().remove(broj);
						model.getObjectNodeElements().remove(clickedPanel);
					}
				}
		
				}
			
			else	if(clickedPanel instanceof StartElement) {
					
				
				for (int i = 0; i < model.getStartElements().size(); i++) {
			
					if (model.getStartsNode().getChildAt(i).toString()==clickedPanel.getNaziv()) {
						broj=i;
						model.getStartsNode().remove(i);
						model.getStartElements().remove(clickedPanel);
						
					}
				}
				
				}
			
			else if(clickedPanel instanceof EndElement) {
					
				
				for (int i = 0; i < model.getEndElements().size(); i++) {
			
					if (model.getEndNodes().getChildAt(i).toString()==clickedPanel.getNaziv()) {
						broj=i;
						model.getEndNodes().remove(i);
						model.getEndElements().remove(clickedPanel);
						
					}
				}
				
				}
			
	else if(clickedPanel instanceof SynchronizationElement) {
					
				
				for (int i = 0; i < model.getSynchronizationElements().size(); i++) {
			
					if (model.getSyncsNode().getChildAt(i).toString()==clickedPanel.getNaziv()) {
						broj=i;
						model.getSyncsNode().remove(i);
						model.getSynchronizationElements().remove(clickedPanel);
						
					}
				}
				
				}
	else if (clickedPanel instanceof PackageElement) {
		
		
		for (int i = 0; i < model.getPackageElements().size(); i++) {
			if (model.getPackagesNode().getChildAt(i).toString()==clickedPanel.getNaziv()) {
				model.getPackageElements().remove(clickedPanel);
				model.getPackagesNode().remove(i);
			}
		}
		
		
		}	
			treeView.update();
			tab.repaint();	
			ClipboardClass klasa = ClipboardClass.getInstance();
			klasa.setTab(tab);
		//	klasa.getElement().add(clickedPanel);
		}
	
	   naziv=clickedPanel.getNaziv();
	   CommandHistory.pushU(this );
	   if(!CommandHistory.undoStack.isEmpty())
 	  { 
 		 mainWindow.menuBarView.undo.setEnabled(true);
 	  mainWindow.getToolbarView().getEditToolBar().getUndo().setEnabled(true);
 	  }
 	  else {
 		  mainWindow.menuBarView.undo.setEnabled(false);
     	  mainWindow.getToolbarView().getEditToolBar().getUndo().setEnabled(false);
		}
		  if(!CommandHistory.redoStack.isEmpty())
 	  { 
 		 mainWindow.menuBarView.redo.setEnabled(true);
 	  mainWindow.getToolbarView().getEditToolBar().getRedo().setEnabled(true);
 	  }
 	  else {
 		  mainWindow.menuBarView.redo.setEnabled(false);
     	  mainWindow.getToolbarView().getEditToolBar().getRedo().setEnabled(false);
		}
   }
   
   public void unexecute() {
//	   ClipboardClass klasa =ClipboardClass.getInstance();
//	   ClipboardClass.setCopy(false);
//		ClipboardClass.setCut(false);
//	
//		int i =klasa.getElement().size()-1;
//		//int i =klasa.getElement().size()-1;
//		Element element=klasa.getElement().get(i);
//		
//		new NacrtajElement(model,element, tab,(int)(tab.getWidth()/10),(int)(tab.getHeight()/10),element.getNaziv()).execute();
////		
//		
//		klasa.getElement().remove(i);
//		
//		klasa.getElement().remove(i);

//		CommandHistory.pushR(this);
		
	   if(clickedPanel instanceof ActivityElement)
		{
			ActivityElement activity = new ActivityElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)), new Dimension(150, 60),clickedPanel.getNaziv());
			this.clickedPanel=activity;
			
							   if (!model.getActivityElements().contains(activity)) { //
					
							  model.getActivitiesNode().add(activity.napraviCvor());
							  model.getActivityElements().add(activity);
							  
							  
							  }
							   tab.add(activity);
							   tab.repaint();
							   treeView.update();
							
				}
	   if(!CommandHistory.undoStack.isEmpty())
	 	  { 
	 		 mainWindow.menuBarView.undo.setEnabled(true);
	 	  mainWindow.getToolbarView().getEditToolBar().getUndo().setEnabled(true);
	 	  }
	 	  else {
	 		  mainWindow.menuBarView.undo.setEnabled(false);
	     	  mainWindow.getToolbarView().getEditToolBar().getUndo().setEnabled(false);
			}
			  if(!CommandHistory.redoStack.isEmpty())
	 	  { 
	 		 mainWindow.menuBarView.redo.setEnabled(true);
	 	  mainWindow.getToolbarView().getEditToolBar().getRedo().setEnabled(true);
	 	  }
	 	  else {
	 		  mainWindow.menuBarView.redo.setEnabled(false);
	     	  mainWindow.getToolbarView().getEditToolBar().getRedo().setEnabled(false);
			}
	   
   }
}