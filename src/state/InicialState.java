package state;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.ButtonActionListener;
import views.EditToolBar;
import views.FileToolBar;
import views.MainWindow;
import views.ToolbarView;
import views.ViewToolBar;

public class InicialState extends State {
	FileToolBar fileToolBar=new FileToolBar();
	EditToolBar editToolBar=new EditToolBar();
	ViewToolBar viewToolBar=new ViewToolBar();
	
	ToolbarView toolbarView=new ToolbarView();
	
	public ToolbarView getToolbarView() {
		return toolbarView;
	}

	public void setToolbarView(ToolbarView toolbarView) {
		this.toolbarView = toolbarView;
	}

	MainWindow mainWindow;
	
	
	
	public InicialState(MainWindow mainWindow) {
		this.mainWindow=mainWindow;
		this.setFileToolBar(mainWindow.getToolbarView().getFileToolBar());
		this.setEditToolBar(mainWindow.getToolbarView().getEditToolBar());
		this.setViewToolBar(mainWindow.getToolbarView().getViewToolBar());
		initToolbar();
		setToolbox();
		setMenuBar();
		//fileToolBar.repaint();

		
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
	
	
		
	fileToolBar.getNewModel().setEnabled(false);
	fileToolBar.getNewDocument().setEnabled(false);
	fileToolBar.getOpenModel().setEnabled(false);
	fileToolBar.getOpenDocument().setEnabled(false);
	fileToolBar.getRenameProject().setEnabled(false);
	fileToolBar.getSave().setEnabled(false);
	fileToolBar.getSaveAs().setEnabled(false);
	
	
	editToolBar.getCut().setEnabled(false);
	editToolBar.getCopy().setEnabled(false);
	editToolBar.getPaste().setEnabled(false);	
	editToolBar.getUndo().setEnabled(false);
	editToolBar.getRedo().setEnabled(false);

	
	
	
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
		mainWindow.getMenuBarView().newModel.setEnabled(false);
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
