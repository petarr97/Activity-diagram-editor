/***********************************************************************
 * Module:  TreeControler.java
 * Author:  Admir Orman
 * Purpose: Defines the Class TreeControler
 ***********************************************************************/

package tree.controlerTree;

import tree.projectExplorerView.TreeView;
import views.ObserverInterface;
import tree.modelTree.ModelTree;
import java.util.*;

public class TreeControler {
   public TreeView treeView;
   public ModelTree modelTree;
   
   public List<ObserverInterface> views;
   
   public TreeControler(ModelTree model,TreeView treeView) {
	CustomTreeMouseListener customTreeMouseListener=new CustomTreeMouseListener();
	
	this.modelTree=model;
	this.treeView=treeView;
	
	treeView.registerComponents(customTreeMouseListener);
}

}