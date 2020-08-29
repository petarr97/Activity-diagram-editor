/***********************************************************************
 * Module:  PasteCommand.java
 * Author:  Admir Orman
 * Purpose: Defines the Class PasteCommand
 ***********************************************************************/

package command;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.text.Utilities;
import javax.swing.tree.DefaultMutableTreeNode;

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
import tree.projectExplorerView.TreeView;
import views.MainWindow;

public class PasteCommand extends CanvasCommand {
	ClipboardClass klasa =ClipboardClass.getInstance();
	TabComponent tab = klasa.getTab();
	Vector<Element>elements=new Vector<Element>();
	ModelModel model;
	Element element;
	MainWindow mainWindow=(MainWindow) SwingUtilities.getWindowAncestor(tab);
	TreeView treeView=mainWindow.getProjectExplorerView().getTree();
	
	static int j=0;
	
	public PasteCommand(ModelModel model) {
	this.model=model;
	}
   public void execute() {
	

//		ClipboardClass.getInstance();
//		if(ClipboardClass.isCut())
//		{
//		ClipboardClass.setCopy(false);
//		ClipboardClass.setCut(false);

	//	for(int i = 0;i<klasa.getElement().size();i++)
		
		

		
			int i =klasa.getElement().size()-1;
			
		 element=klasa.getElement().get(i);
		 String naziv;
		 
		 if(ClipboardClass.isCopy())
			{
				 naziv=element.getNaziv()+ Element.distNumber++;
	
			}
			naziv=element.getNaziv();
		 if(element instanceof ActivityElement)
			{
			 
				ActivityElement activity = new ActivityElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)), new Dimension(150, 60),naziv);
				this.element=activity;
				
								   if (!model.getActivityElements().contains(activity)) { //
						
								  model.getActivitiesNode().add(activity.napraviCvor());
								  model.getActivityElements().add(activity);
								  
								  
								  }
								   tab.add(activity);
								   tab.repaint();
								   treeView.update();
								
					}
					else if(element instanceof DecisionElement) {
						  DecisionElement decision	  = new DecisionElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(100,100),naziv);
							this.element=decision;
							if (!model.getDecisionElements().contains(decision)) {
								
								model.getDecisionsNode().add(decision.napraviCvor());
								model.getDecisionElements().add(decision);
							
							}
						
						
					}
					else if (element instanceof ObjectNodeElement) {
						 ObjectNodeElement objectNode = new ObjectNodeElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(151,41),naziv);
						  this.element=objectNode;;

							if (!model.getObjectNodeElements().contains(objectNode)) {
								
								model.getObjectNodesNode().add(objectNode.napraviCvor());
								model.getObjectNodeElements().add(objectNode);
							
							}
							
						  } 
					else if (element instanceof PackageElement) {
						PackageElement package1 = new PackageElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(100,100),naziv);
						  this.element=package1;
//						
						  if (!model.getPackageElements().contains(package1)) {
								// System.out.println(tabComponent.getDokument());
								model.getPackagesNode().add(package1.napraviCvor());
								model.getPackageElements().add(package1);
						  }
						
					}
					else if (element instanceof StartElement) {
						StartElement start = new StartElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(31,31),naziv);
						  this.element=start;
						
						  if (!model.getStartElements().contains(start)) {
							
								model.getStartsNode().add(start.napraviCvor());
								model.getStartElements().add(start);
								
						  }
						
					}
					
					else if (element instanceof EndElement) {
						model.EndElement end = new model.EndElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)), new Dimension(30,30),naziv);
						  this.element=end;
				  
						 end.getInterfaces().add(treeView);
						  if (!model.getStartElements().contains(end)) {
						
								model.getEndNodes().add(end.napraviCvor());
								model.getEndElements().add(end);
						  }
					}
					else if (element instanceof SynchronizationElement) {
						 SynchronizationElement sync = new SynchronizationElement((new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10))),(new Dimension(45,5)),naziv);
						 this.element=sync;
						  if (!model.getSynchronizationElements().contains(sync)) {
								
								model.getSyncsNode().add(sync.napraviCvor());
								model.getSynchronizationElements().add(sync);
								
						   }
						  
						  tab.repaint();
						   
						  treeView.update();
					}		
			elements.add(element);
			j++;
			klasa.getElement().remove(i);
			
		
		
		tab.repaint();
		

			
			CommandHistory.pushU(this);
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
//int k=elements.size()-1;
//if(k!=0)
//{  tab.remove(elements.get(k));
//	   elements.remove(elements.get(k));
//		tab.repaint();
//		}
	   if(element instanceof ActivityElement)
		{
			//ActivityElement activity = new ActivityElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)), new Dimension(150, 60),clickedPanel.getNaziv());
		ActivityElement activity=(ActivityElement) element;
			
			
							   if (model.getActivityElements().contains(activity)) { //
					
							  model.getActivitiesNode().remove(activity.getNode());
							  model.getActivityElements().remove(activity);
							  
							  }
							   tab.remove(activity);
							   tab.repaint();
							   treeView.update();
							
				}
		
  
				else if(element instanceof DecisionElement) {
		
				
					//  DecisionElement decision	  = new DecisionElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(100,100),"Decision"+TabComponent.brojDecisionElementa++);
					 DecisionElement decision=	(DecisionElement) this.element;
						if (model.getDecisionElements().contains(decision)) {
							
							model.getDecisionsNode().remove(decision.getNode());;
							model.getDecisionElements().remove(decision);
							 tab.remove(decision);
							   tab.repaint();
							   treeView.update();
						}
					
					
				}
				else if (element instanceof ObjectNodeElement) {
					// ObjectNodeElement objectNode = new ObjectNodeElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(151,41),"ObjectNode"+TabComponent.brojObjectNodeElemnata++);
					ObjectNodeElement objectNode =	  (ObjectNodeElement) this.element;

						if (model.getObjectNodeElements().contains(objectNode)) {
							
							model.getObjectNodesNode().remove(objectNode.getNode());
							model.getObjectNodeElements().remove(objectNode);
							 tab.remove(objectNode);
							 tab.repaint();
							   treeView.update();
						}
						
					  } 
				else if (element instanceof PackageElement) {
					//PackageElement package1 = new PackageElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(100,100),"Package"+TabComponent.brojPackageElementa++);
					PackageElement package1= (PackageElement) this.element;
//					
					  if (model.getPackageElements().contains(package1)) {
							// System.out.println(tabComponent.getDokument());
							model.getPackagesNode().remove(package1.getNode());
							model.getPackageElements().remove(package1);
							
					  }
					  tab.remove(package1);
					  tab.repaint();
					   treeView.update();
				}
				else if (element instanceof StartElement) {
					//StartElement start = new StartElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)),new Dimension(31,31),"Start"+TabComponent.brojStartElemenata++);
					StartElement start= (StartElement) this.element;
					
					  if (model.getStartElements().contains(start)) {
						
							model.getStartsNode().remove(start.getNode());
							model.getStartElements().remove(start);
							
					  }
					  tab.remove(start);
					
				}
				
				else if (element instanceof EndElement) {
					//model.EndElement end = new model.EndElement(new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10)), new Dimension(30,30),"End"+TabComponent.brojEndElementa++);
					EndElement end= (EndElement) this.element;
			  
					
					  if (model.getStartElements().contains(end)) {
					
							model.getEndNodes().remove(end.getNode());
							model.getEndElements().remove(end);
					  }
					  tab.remove(end);
				}
				else if (element instanceof SynchronizationElement) {
					// SynchronizationElement sync = new SynchronizationElement((new Point((int)(tab.getWidth()/10),(int)(tab.getHeight()/10))),(new Dimension(45,5)),"Synchronization"+TabComponent.brojSyncElementata++);
					SynchronizationElement sync=(SynchronizationElement) element;
					  if (model.getSynchronizationElements().contains(sync)) {
							
							model.getSyncsNode().remove(sync.getNode());
							model.getSynchronizationElements().remove(sync);
							
					   }
					  tab.remove(sync);
				}
	  
	   tab.repaint();
	   
	  treeView.update();
	  
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
