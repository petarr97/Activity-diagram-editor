/***********************************************************************
 * Module:  RemoveCommand.java
 * Author:  Admir Orman
 * Purpose: Defines the Class RemoveCommand
 ***********************************************************************/

package command;

import java.awt.Point;
import java.util.*;

import javax.swing.JOptionPane;
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

public class RemoveCommand extends CanvasCommand {
	ModelModel model;
	TabComponent tabComponent;
	int x,y;
	ToolboxGlobalClass klasa=ToolboxGlobalClass.getInstance();
	Element element;
	public RemoveCommand(ModelModel model, TabComponent tab,Element element) {
		this.element=element;
		this.model=model;
		this.tabComponent=tab;


	}
   public void execute() {
	   
	  
	   if(klasa.delete)
		{
	
			Point tacka1 = new Point((int)element.getLocation().getX()+element.getWidth()/2,(int)element.getLocation().getY()+element.getHeight()-10);
			Point tacka2 = new Point((int)element.getLocation().getX()+element.getWidth()/2,(int)element.getLocation().getY()+10);
			
	
			if(tabComponent.getFlows().size()>1)
			{
			for(int i=0;i<tabComponent.getFlows().size();i++)
			{
				if((tabComponent.getFlows().get(i).getX() == tacka1.getX() && tabComponent.getFlows().get(i).getY() == tacka1.getY()))
				{
					PanelMouseListener.delete = true;
					PanelMouseListener.lista.add(new DragLineClass(i,true,false,tacka1));
				}
				else if((tabComponent.getFlows().get(i).getX() == tacka2.getX() && tabComponent.getFlows().get(i).getY() == tacka2.getY()))
				{
					PanelMouseListener.delete = true;
					PanelMouseListener.lista.add(new DragLineClass(i,false,true,tacka2));
					
				}
			}
	
			
			for(int i=0;i<PanelMouseListener.lista.size();i++)
			{
				if(PanelMouseListener.lista.get(i).pozicija%2==0)
				{
					tabComponent.getFlows().set(PanelMouseListener.lista.get(i).getPozicija(),new Point(0,0));
					tabComponent.getFlows().set(PanelMouseListener.lista.get(i).getPozicija()+1,new Point(0,0));
				}
				else if(PanelMouseListener.lista.get(i).pozicija%2!=0)
				{
					tabComponent.getFlows().set(PanelMouseListener.lista.get(i).getPozicija(),new Point(0,0));
					tabComponent.getFlows().set(PanelMouseListener.lista.get(i).getPozicija()-1,new Point(0,0));
				}
				
			}
			for(int i=0;i<tabComponent.getFlows().size();i++)
			{
				if(tabComponent.getFlows().get(i).getX()== 0 && tabComponent.getFlows().get(i).getY() == 0)
					{
					tabComponent.getFlows().remove(i);
					i--;
					}
			}
			}
	
			PanelMouseListener.delete = false;
			PanelMouseListener.lista.clear();
			
			
		
			tabComponent.remove(element);
			tabComponent.repaint();
			
			int  broj=0;
			TreeView treeView=((MainWindow)SwingUtilities.getWindowAncestor(tabComponent)).getProjectExplorerView().getTree();
			ModelModel model=(ModelModel) ((DefaultMutableTreeNode)tabComponent.getDokument().getNode().getParent()).getUserObject();
			if(element instanceof ActivityElement) {
					
				
				for (int i = 0; i < model.getActivityElements().size(); i++) {
				
					if (model.getActivitiesNode().getChildAt(i).toString()==element.getNaziv()) {
						broj=i;
						model.getActivitiesNode().remove(i);
						model.getActivityElements().remove(element);
						
					}
				}
				
				}
			else if (element instanceof DecisionElement) {
				
			
			for (int i = 0; i <model.getDecisionElements().size(); i++) {
				if (model.getDecisionsNode().getChildAt(i).toString()==element.getNaziv()) {
					model.getDecisionElements().remove(element);
					model.getDecisionsNode().remove(i);
				}
			}
			
			
			}
			
			else if (element instanceof ObjectNodeElement) {
				
			
				for (int i = 0; i < model.getObjectNodeElements().size(); i++) {
					if (model.getObjectNodesNode().getChildAt(i).toString()==element.getNaziv()) {
						model.getObjectNodesNode().remove(broj);
						model.getObjectNodeElements().remove(element);
					}
				}
		
				}
			
			else	if(element instanceof StartElement) {
					
				
				for (int i = 0; i < model.getStartElements().size(); i++) {
			
					if (model.getStartsNode().getChildAt(i).toString()==element.getNaziv()) {
						broj=i;
						model.getStartsNode().remove(i);
						model.getStartElements().remove(element);
						
					}
				}
				
				}
			
			else if(element instanceof EndElement) {
					
				
				for (int i = 0; i < model.getEndElements().size(); i++) {
			
					if (model.getEndNodes().getChildAt(i).toString()==element.getNaziv()) {
						broj=i;
						model.getEndNodes().remove(i);
						model.getEndElements().remove(element);
						
					}
				}
				
				}
			
	else if(element instanceof SynchronizationElement) {
					
				
				for (int i = 0; i < model.getSynchronizationElements().size(); i++) {
			
					if (model.getSyncsNode().getChildAt(i).toString()==element.getNaziv()) {
						broj=i;
						model.getSyncsNode().remove(i);
						model.getSynchronizationElements().remove(element);
						
					}
				}
				
				}
	else if (element instanceof PackageElement) {
		
		
		for (int i = 0; i < model.getPackageElements().size(); i++) {
			if (model.getPackagesNode().getChildAt(i).toString()==element.getNaziv()) {
				model.getPackageElements().remove(element);
				model.getPackagesNode().remove(i);
			}
		}
		
		
		}	
			treeView.update();
			tabComponent.repaint();	
			ClipboardClass klasa = ClipboardClass.getInstance();
			klasa.setTab(tabComponent);
		}
	   
   }
   
   public void unexecute() {
      // TODO: implement
   }

}