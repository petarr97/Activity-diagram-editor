package controller;

import java.util.Vector;

import javax.swing.text.View;

import model.ModelModel;
import mouseListeners.MyMouseListener;
import views.ObserverInterface;

public class DrawController {
	
	ModelModel model;
	Vector<ObserverInterface>views=new Vector<ObserverInterface>();
	public DrawController(ModelModel modelModel, ObserverInterface interface1) {
		model=modelModel;
		views.add(interface1);
		
		for (ObserverInterface observerInterface : views) {
			observerInterface.registerComponents(new MyMouseListener(model, observerInterface));
			
		}
	}
	

}
