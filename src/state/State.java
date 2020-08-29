package state;

import javax.naming.InitialContext;
import javax.swing.JToolBar;

import views.EditToolBar;
import views.FileToolBar;
import views.MainWindow;
import views.ToolbarView;
import views.ViewToolBar;

public abstract class State {
	FileToolBar fileToolBar=new FileToolBar();
	EditToolBar editToolBar=new EditToolBar();
	ViewToolBar viewToolBar=new ViewToolBar();
	
	MainWindow mainWindow;
ToolbarView toolbarView=new ToolbarView();


	
	public ToolbarView getToolbarView() {
		return toolbarView;
	}

	public void setToolbarView(ToolbarView toolbarView) {
		this.toolbarView = toolbarView;
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
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	abstract void initToolbar();
	abstract void setCoursor();
	abstract void setToolbox();
	abstract void setMenuBar();

}
