/***********************************************************************
 * Module:  ModelTree.java
 * Author:  Admir Orman
 * Purpose: Defines the Class ModelTree
 ***********************************************************************/

package tree.modelTree;

import model.ActivityElement;
import model.Cvor;
import model.Dokument;
import model.ModelModel;
import model.ProjectModel;
import tree.projectExplorerView.TreeView;
import views.ObserverInterface;

import java.util.*;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
/**
 * Model pretraživača projekata
 * @author Milica Vuković
 *
 */
public class ModelTree extends DefaultTreeModel {
	
	Vector<ObserverInterface>subscribers=new Vector<ObserverInterface>();
	
	public static ArrayList<ProjectModel> projectModels=new ArrayList<ProjectModel>();
	public static  ArrayList<ProjectModel> getProjectModels() {
		return projectModels;
	}
	public static void setProjectModels(ArrayList<ProjectModel> modelsOfProject) {
		projectModels = modelsOfProject;
	}
	private DefaultMutableTreeNode node;
	static DefaultMutableTreeNode rootNode=new DefaultMutableTreeNode();
	public static DefaultMutableTreeNode getRootNode() {
		return rootNode;
		
	}
	
	/**
	 * Konstruktor za kreiranje modela pretraživača projekta
	 * @param projectModel - Lista postojećih projekata
	 * @author Milica Vuković
	 */
	
	
 public ModelTree() {
	super(rootNode);
	rootNode.setUserObject("Workspace");
	//projectModels=new Vector<ProjectModel>();
	subscribers.add(new TreeView(this));
		
		/*
		 * ProjectModel model=new ProjectModel(); model.setNaziv("Projekat1");
		 * projectModels.add(model);
		 * 
		 * ModelModel model1=new ModelModel(); Dokument dokumentModel=new Dokument();
		 * dokumentModel.setNaziv("Dokument");
		 * 
		 * ActivityElement activityElement=new ActivityElement();
		 * activityElement.setNaziv("Aktiviti");
		 * 
		 * model1.getDokumenti().add(dokumentModel);
		 * model1.getActivityElements().add(activityElement); model1.setNaziv("Model");
		 * 
		 * model.getModeli().add(model1);
		 * 
		 * 
		 * for (ProjectModel projectModel : projectModels) {
		 rootNode.add(projectModel.napraviCvor());
		 }
		 * 
		 * 
		 * 
		 }
		  */
	
	}
	
	

 
	public void NotifyAllObservers() {
		for (ObserverInterface observerInterface : subscribers) {
			observerInterface.update();
		}
	}
}


   
   
 
