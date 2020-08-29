/***********************************************************************
 * Module:  ToolbarView.java
 * Author:  Admir Orman
 * Purpose: Defines the Class ToolbarView
 ***********************************************************************/

package views;


	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToolBar;

import controller.ButtonActionListener;



public class ToolbarView extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileToolBar fileToolBar=new FileToolBar();
	EditToolBar editToolBar=new EditToolBar();
	ViewToolBar viewToolBar=new ViewToolBar();
	ButtonActionListener actionListener=new ButtonActionListener();
	
	
	
	public FileToolBar getFileToolBar() {
		return fileToolBar;
	}



	public void setFileToolBar(FileToolBar fileToolBar) {
		this.fileToolBar = fileToolBar;
	}



	public EditToolBar getEditToolBar() {
		return editToolBar;
	}



	public void setEditToolBar(EditToolBar editToolBar) {
		this.editToolBar = editToolBar;
	}



	public ViewToolBar getViewToolBar() {
		return viewToolBar;
	}



	public void setViewToolBar(ViewToolBar viewToolBar) {
		this.viewToolBar = viewToolBar;
	}



	public ToolbarView()
	{
		setBackground(Color.decode("#E9FDFF"));
		setFloatable(false);
		setPreferredSize(new Dimension(0,30));
		
		  add(fileToolBar,BorderLayout.WEST);
		  
		  add(editToolBar,BorderLayout.WEST); add(viewToolBar,BorderLayout.WEST);
		 
		
		//fileToolBar.registerComponents(actionListener);
	}
}