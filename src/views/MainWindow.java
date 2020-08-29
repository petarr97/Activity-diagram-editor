/***********************************************************************
 * Module:  MainWindow.java
 * Author:  Admir Orman
 * Purpose: Defines the Class MainWindow
 ***********************************************************************/

package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.tree.TreeModel;

import localization.Localization;
//import StatusBarView;
import state.InicialState;
import state.ProjectEditingState;
import state.State;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.ProjectExplorerView;
import tree.projectExplorerView.TreeView;

public class MainWindow extends JFrame  {
  
	private static final long serialVersionUID = 1L;
	
public ProjectExplorerView projectExplorerView;
public CanvasView canvasView;
   public ToolboxView toolboxView;
//   public StatusBarView statusBarView;
   public MenuBarView menuBarView;
   public ToolbarView toolbarView;
 public StatusBar statusbarView;
   State state;
   
   ModelTree model=new ModelTree();
   TreeView treeView=new TreeView(model);
   
   public MenuBarView getMenuBarView() {
	return menuBarView;
}
public void setMenuBarView(MenuBarView menuBarView) {
	this.menuBarView = menuBarView;
}
public void changeState(State state) {
	this.state=state;
	//this.setToolbarView(state.getToolbarView());
}
   public ToolboxView getToolboxView() {
	return toolboxView;
}

public void setToolboxView(ToolboxView toolboxView) {
	this.toolboxView = toolboxView;
}

public ProjectExplorerView getProjectExplorerView() {
	return projectExplorerView;
}

public void setProjectExplorerView(ProjectExplorerView projectExplorerView) {
	this.projectExplorerView = projectExplorerView;
}

public MainWindow()
   {
	   setLayout(new BorderLayout());
	   setTitle(Localization.getInstance().getString("Title"));
	   Localization.getInstance().registerComponent("Title", this);
	   setBackground(Color.decode("#E9FDFF"));
	   
	   Toolkit toolkit=Toolkit.getDefaultToolkit();
	   Image icon=toolkit.getImage("icons/diagram.png");
	   setIconImage(icon);
	   
	   menuBarView=new MenuBarView();
	   
	   setJMenuBar(menuBarView);
	   setExtendedState(JFrame.MAXIMIZED_BOTH); 
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	   toolboxView = new ToolboxView();
	   add(toolboxView,BorderLayout.EAST);
	  // add(new StatusBarView(),BorderLayout.SOUTH);
	   
	   canvasView = new CanvasView();
	   add(canvasView,BorderLayout.CENTER);
	   
	   projectExplorerView=new ProjectExplorerView(treeView,model);
	   this.add(projectExplorerView, BorderLayout.WEST);
	   
	toolbarView=new ToolbarView();
	   add(toolbarView,BorderLayout.NORTH);
	   
	  // setToolbarView(state);
	   
	   
	statusbarView = new StatusBar();
	add(statusbarView,BorderLayout.SOUTH);
	   
	   state=new InicialState(this);
	   
		try {
            // Set System L&F
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");    } 
			catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    }
   }

public ToolbarView getToolbarView() {
	return toolbarView;
}
public void setToolbarView(ToolbarView toolbarView) {

	this.toolbarView=toolbarView;
	 
}
public CanvasView getCanvasView() {
	return canvasView;
}

public void setCanvasView(CanvasView canvasView) {
	
	this.canvasView = canvasView;
}

}