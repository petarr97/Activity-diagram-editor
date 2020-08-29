package state;

import java.awt.Component;

import javax.swing.JButton;

import views.MainWindow;
import views.MenuBarView;

public class EditingState extends State {

	public EditingState(MainWindow mainWindow) {
		this.mainWindow=mainWindow;
		this.setFileToolBar(mainWindow.getToolbarView().getFileToolBar());
		this.setEditToolBar(mainWindow.getToolbarView().getEditToolBar());
		this.setViewToolBar(mainWindow.getToolbarView().getViewToolBar());
	
		initToolbar();
		setToolbox();
		setMenuBar();
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
		
		
		editToolBar.getCut().setEnabled(true);
		editToolBar.getCopy().setEnabled(true);
		editToolBar.getPaste().setEnabled(true);	
		
		
	}

	@Override
	void setCoursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void setToolbox() {
		for (Component button : mainWindow.getToolboxView().getSeccondRowPanel().getComponents()) {
			((JButton)button).setEnabled(true);
		}
		mainWindow.toolboxView.getBackGrounds().setEnabled(true);
		mainWindow.toolboxView.getFlows().setEnabled(true);
		
	}

	@Override
	void setMenuBar() {
		mainWindow.getMenuBarView().newModel.setEnabled(true);
		mainWindow.getMenuBarView().newDocument.setEnabled(true);	
		mainWindow.getMenuBarView().openDocument.setEnabled(true);
		mainWindow.getMenuBarView().newProject.setEnabled(true);
		mainWindow.getMenuBarView().cut.setEnabled(true);
		mainWindow.getMenuBarView().copy.setEnabled(true);
		mainWindow.getMenuBarView().paste.setEnabled(true);
		mainWindow.getMenuBarView().save.setEnabled(true);
		mainWindow.getMenuBarView().saveAs.setEnabled(true);
		mainWindow.getMenuBarView().close.setEnabled(true);
		mainWindow.getMenuBarView().exit.setEnabled(true);
		
		
	}

}
