package command;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;

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
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.EditToolBar;
import views.MainWindow;
import views.MenuBarView;

public class NacrtajElement implements Command {
	TabComponent tabComponent;
	int x,y;
	String naziv;
	ModelModel model;
	Element element;
	MainWindow mainWindow;
	TreeView treeView;
	ToolboxGlobalClass klasa=ToolboxGlobalClass.getInstance();
	public NacrtajElement(ModelModel model, TabComponent tab,int x, int y) {
		
		this.model=model;
		this.tabComponent=tab;

		this.x=x;
		this.y=y;

		}
	public NacrtajElement(ModelModel model,Element element,TabComponent tab,int x, int y,String naziv) {
		this.model=model;
		this.element=element;
		this.tabComponent=tab;
		this.x=x;
		this.y=y;
		this.naziv=naziv;
	}
	

	@Override
	public void execute() {
		 mainWindow = (MainWindow) tabComponent.getTopLevelAncestor();
System.out.println(naziv);
		 treeView = (TreeView) mainWindow.getProjectExplorerView().getTree();
		if(naziv==null) {
			
		if (klasa.isActivity()) {
			
		
		ActivityElement activity = new ActivityElement(new Point(x, y), new Dimension(150, 60),"ActivityElement"+TabComponent.brojActivityElementa++);
	this.element=activity;
	
	
					   if (!model.getActivityElements().contains(activity)) { //
			
					  model.getActivitiesNode().add(activity.napraviCvor());
					  model.getActivityElements().add(activity);
					  
					  
					  }
					
		}
		else if(klasa.isDecision()) {
			  DecisionElement decision	  = new DecisionElement(new Point(x,y),new Dimension(100,100),"Decision"+TabComponent.brojDecisionElementa++);
				this.element=decision;
				if (!model.getDecisionElements().contains(decision)) {
					
					model.getDecisionsNode().add(decision.napraviCvor());
					model.getDecisionElements().add(decision);
				
				}
			
			
		}
		else if (klasa.isObjectNode()) {
			 ObjectNodeElement objectNode = new ObjectNodeElement(new Point(x,y),new Dimension(151,41),"ObjectNode"+TabComponent.brojObjectNodeElemnata++);
			  this.element=objectNode;;

				if (!model.getObjectNodeElements().contains(objectNode)) {
					
					model.getObjectNodesNode().add(objectNode.napraviCvor());
					model.getObjectNodeElements().add(objectNode);
				
				}
				
			  } 
		else if (klasa.isPackage1()) {
			PackageElement package1 = new PackageElement(new Point(x,y),new Dimension(100,100),"Package"+TabComponent.brojPackageElementa++);
			  this.element=package1;
//			
			  if (!model.getPackageElements().contains(package1)) {
					// System.out.println(tabComponent.getDokument());
					model.getPackagesNode().add(package1.napraviCvor());
					model.getPackageElements().add(package1);
			  }
			
		}
		else if (klasa.isStart()) {
			StartElement start = new StartElement(new Point(x,y),new Dimension(31,31),"Start"+TabComponent.brojStartElemenata++);
			  this.element=start;
			
			  if (!model.getStartElements().contains(start)) {
				
					model.getStartsNode().add(start.napraviCvor());
					model.getStartElements().add(start);
					
			  }
			
		}
		
		else if (klasa.isEnd()) {
			model.EndElement end = new model.EndElement(new Point(x,y), new Dimension(30,30),"End"+TabComponent.brojEndElementa++);
			  this.element=end;
	  
			 end.getInterfaces().add(treeView);
			  if (!model.getStartElements().contains(end)) {
			
					model.getEndNodes().add(end.napraviCvor());
					model.getEndElements().add(end);
			  }
		}
		else if (klasa.isSynchronization()) {
			 SynchronizationElement sync = new SynchronizationElement((new Point(x,y)),(new Dimension(45,5)),"Synchronization"+TabComponent.brojSyncElementata++);
			 this.element=sync;
			 
			  if (!model.getSynchronizationElements().contains(sync)) {
					
					model.getSyncsNode().add(sync.napraviCvor());
					model.getSynchronizationElements().add(sync);
					
			   }
		}
		element.getInterfaces().add(tabComponent);
		tabComponent.add(element);
		element.getInterfaces().add(treeView);
		element.notifyAllObservers();
		
	
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
//		else if(naziv!=null) {
//		
//		
//		
//		
//			if(element instanceof ActivityElement)
//		{
//			ActivityElement activity = new ActivityElement(new Point(x, y), new Dimension(150, 60),naziv);
//			this.element=activity;
//			
//							   if (!model.getActivityElements().contains(activity)) { //
//					
//							  model.getActivitiesNode().add(activity.napraviCvor());
//							  model.getActivityElements().add(activity);
//							  
//							  }
//							
//				}
//				else if(element instanceof DecisionElement) {
//					  DecisionElement decision	  = new DecisionElement(new Point(x,y),new Dimension(100,100),naziv);
//						this.element=decision;
//						if (!model.getDecisionElements().contains(decision)) {
//							
//							model.getDecisionsNode().add(decision.napraviCvor());
//							model.getDecisionElements().add(decision);
//						
//						}
//					
//					
//				}
//				else if (element instanceof ObjectNodeElement) {
//					 ObjectNodeElement objectNode = new ObjectNodeElement(new Point(x,y),new Dimension(151,41),naziv);
//					  this.element=objectNode;;
//
//						if (!model.getObjectNodeElements().contains(objectNode)) {
//							
//							model.getObjectNodesNode().add(objectNode.napraviCvor());
//							model.getObjectNodeElements().add(objectNode);
//						
//						}
//						
//					  } 
//				else if (element instanceof PackageElement) {
//					PackageElement package1 = new PackageElement(new Point(x,y),new Dimension(100,100),naziv);
//					  this.element=package1;
////					
//					  if (!model.getPackageElements().contains(package1)) {
//							// System.out.println(tabComponent.getDokument());
//							model.getPackagesNode().add(package1.napraviCvor());
//							model.getPackageElements().add(package1);
//					  }
//					
//				}
//				else if (element instanceof StartElement) {
//					StartElement start = new StartElement(new Point(x,y),new Dimension(31,31),naziv);
//					  this.element=start;
//					
//					  if (!model.getStartElements().contains(start)) {
//						
//							model.getStartsNode().add(start.napraviCvor());
//							model.getStartElements().add(start);
//							
//					  }
//					
//				}
//				
//				else if (element instanceof EndElement) {
//					model.EndElement end = new model.EndElement(new Point(x,y), new Dimension(30,30),naziv);
//					  this.element=end;
//			  
//					 end.getInterfaces().add(treeView);
//					  if (!model.getStartElements().contains(end)) {
//					
//							model.getEndNodes().add(end.napraviCvor());
//							model.getEndElements().add(end);
//					  }
//				}
//				else if (element instanceof SynchronizationElement) {
//					 SynchronizationElement sync = new SynchronizationElement((new Point(x,y)),(new Dimension(45,5)),naziv);
//					 this.element=sync;
//					  if (!model.getSynchronizationElements().contains(sync)) {
//							
//							model.getSyncsNode().add(sync.napraviCvor());
//							model.getSynchronizationElements().add(sync);
//							
//					   }
//		}
		}
		
	
		
	

	@Override
	public void unexecute() {

klasa.setDelete(true);
new RemoveCommand(model, tabComponent, element).execute();
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
