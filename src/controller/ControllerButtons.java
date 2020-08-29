package controller;

import java.util.Vector;

import tree.modelTree.ModelTree;
import views.ObserverInterface;

public class ControllerButtons {
	Vector<ObserverInterface>interfaces=new Vector<ObserverInterface>();;
	ModelTree modelTree;
	
	
	public Vector<ObserverInterface> getInterfaces() {
		return interfaces;
	}


	public void setInterfaces(Vector<ObserverInterface> interfaces) {
		this.interfaces = interfaces;
	}


	public ModelTree getModelTree() {
		return modelTree;
	}


	public void setModelTree(ModelTree modelTree) {
		this.modelTree = modelTree;
	}


	public ControllerButtons(ModelTree modelTree, Vector<ObserverInterface> interfaces) {
		ButtonActionListener actionListener=new ButtonActionListener();
		
		this.interfaces=interfaces;
		this.modelTree=modelTree;
		for (ObserverInterface observerInterface : interfaces) {
			observerInterface.registerComponents(actionListener);
		}
	}
	
	
	
	

}
