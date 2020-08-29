package state;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.MenuBar;

import javax.swing.JButton;
import javax.swing.JToolBar;

import views.EditToolBar;
import views.FileToolBar;
import views.MainWindow;
import views.MenuBarView;
import views.ToolbarView;
import views.ViewToolBar;

public class ProjectEditingState extends State {
	FileToolBar fileToolBar=new FileToolBar();
	EditToolBar editToolBar=new EditToolBar();
	ViewToolBar viewToolBar=new ViewToolBar();
	
	MenuBarView menuBarView;
	
	public MenuBarView getMenuBarView() {
		return menuBarView;
	}

	public void setMenuBarView(MenuBarView menuBarView) {
		this.menuBarView = menuBarView;
	}

	MainWindow mainWindow;
	
ToolbarView toolbarView=new ToolbarView();
	
	public ToolbarView getToolbarView() {
		return toolbarView;
	}

	public void setToolbarView(ToolbarView toolbarView) {
		this.toolbarView = toolbarView;
	}
	
	public ProjectEditingState(MainWindow mainWindow) {
		this.mainWindow=mainWindow;
		this.setFileToolBar(mainWindow.getToolbarView().getFileToolBar());
		this.setEditToolBar(mainWindow.getToolbarView().getEditToolBar());
		this.setViewToolBar(mainWindow.getToolbarView().getViewToolBar());
	
		initToolbar();
		setMenuBar();
		setToolbox();

		
		System.out.println("ProjectEditing");
		
	//	this.initToolbar();
		
	}
	
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

	@Override
	public void initToolbar() {
	
		
	
		
	fileToolBar.getNewModel().setEnabled(true);
	fileToolBar.getNewDocument().setEnabled(false);
	fileToolBar.getOpenModel().setEnabled(true);
	fileToolBar.getOpenDocument().setEnabled(false);
	fileToolBar.getRenameProject().setEnabled(false);
	fileToolBar.getSave().setEnabled(true);
	fileToolBar.getSaveAs().setEnabled(true);
	
	
	editToolBar.getCut().setEnabled(false);
	editToolBar.getCopy().setEnabled(false);
	editToolBar.getPaste().setEnabled(false);
	

	
	
	
	}

	@Override
	public void setCoursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setToolbox() {
		for (Component button : mainWindow.getToolboxView().getSeccondRowPanel().getComponents()) {
			((JButton)button).setEnabled(false);
		}
		mainWindow.toolboxView.getBackGrounds().setEnabled(false);
		mainWindow.toolboxView.getFlows().setEnabled(false);
		
	}

	@Override
	public void setMenuBar() {
	mainWindow.getMenuBarView().newModel.setEnabled(true);
	mainWindow.getMenuBarView().newDocument.setEnabled(false);	
	mainWindow.getMenuBarView().openDocument.setEnabled(false);
	mainWindow.getMenuBarView().newProject.setEnabled(true);
	mainWindow.getMenuBarView().cut.setEnabled(false);
	mainWindow.getMenuBarView().copy.setEnabled(false);
	mainWindow.getMenuBarView().paste.setEnabled(false);
	mainWindow.getMenuBarView().save.setEnabled(true);
	mainWindow.getMenuBarView().saveAs.setEnabled(true);
	mainWindow.getMenuBarView().close.setEnabled(true);
	mainWindow.getMenuBarView().exit.setEnabled(true);
	}

}
