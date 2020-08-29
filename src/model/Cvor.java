package model;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import views.ObserverInterface;

public interface Cvor  {
	
	public Vector<ObserverInterface> subscribers=new Vector<ObserverInterface>();
	
	 DefaultMutableTreeNode napraviCvor();

}
