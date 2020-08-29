/***********************************************************************
 * Module:  ProjectModel.java
 * Author:  Admir Orman
 * Purpose: Defines the Class ProjectModel
 ***********************************************************************/

package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectModel {
   private ArrayList<ModelModel> modeli;
   public ArrayList<ModelModel> getModeli() {
	return modeli;
}

public void setModeli(ArrayList<ModelModel> modeli) {
	this.modeli = modeli;
}

public ProjectModel() {
	this.modeli=new ArrayList<ModelModel>();
}

private String naziv;

public String getNaziv() {
	return naziv;
}

public void setNaziv(String naziv) {
	this.naziv = naziv;
}


   
public DefaultMutableTreeNode napraviCvor() {
	
	DefaultMutableTreeNode rootNode=new DefaultMutableTreeNode(this);
	for (ModelModel modelModel : modeli) {
		rootNode.add(modelModel.napraviCvor());	
	}
	
	
	return rootNode;
	
}
   
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNaziv();
	}

}