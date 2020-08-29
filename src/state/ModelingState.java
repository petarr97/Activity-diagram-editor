package state;

import java.awt.Component;

import javax.swing.JButton;

import views.MainWindow;

public class ModelingState extends State {

	public ModelingState(MainWindow mainWindow) {
		this.mainWindow=mainWindow;
		this.setFileToolBar(mainWindow.getToolbarView().getFileToolBar());
		this.setEditToolBar(mainWindow.getToolbarView().getEditToolBar());
		this.setViewToolBar(mainWindow.getToolbarView().getViewToolBar());
	
		initToolbar();
		setToolbox();
		setMenuBar();
		fileToolBar.repaint();
	}
	
	@Override
	void initToolbar() {
		fileToolBar.getNewModel().setEnabled(true);
		fileToolBar.getNewDocument().setEnabled(true);
		fileToolBar.getOpenModel().setEnabled(true);
		fileToolBar.getOpenDocument().setEnabled(true);
		fileToolBar.getRenameProject().setEnabled(true);
		fileToolBar.getSave().setEnabled(true);
		fileToolBar.getSaveAs().setEnabled(true);
		
		
		editToolBar.getCut().setEnabled(false);
		editToolBar.getCopy().setEnabled(false);
		editToolBar.getPaste().setEnabled(false);
	}

	@Override
	void setCoursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setToolbox() {
		
	
		
	}

	@Override
	void setMenuBar() {
		mainWindow.getMenuBarView().newModel.setEnabled(true);
		mainWindow.getMenuBarView().newDocument.setEnabled(true);	
		mainWindow.getMenuBarView().openDocument.setEnabled(true);
		mainWindow.getMenuBarView().newProject.setEnabled(true);
		mainWindow.getMenuBarView().cut.setEnabled(false);
		mainWindow.getMenuBarView().copy.setEnabled(false);
		mainWindow.getMenuBarView().paste.setEnabled(false);
		mainWindow.getMenuBarView().save.setEnabled(true);
		mainWindow.getMenuBarView().saveAs.setEnabled(true);
		mainWindow.getMenuBarView().close.setEnabled(true);
		mainWindow.getMenuBarView().exit.setEnabled(true);
		mainWindow.getMenuBarView().undo.setEnabled(false);
		mainWindow.getMenuBarView().redo.setEnabled(true);
		
	}

}
