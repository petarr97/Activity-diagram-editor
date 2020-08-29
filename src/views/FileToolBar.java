package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.ButtonActionListener;

public class FileToolBar extends JToolBar implements ObserverInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton newProject;
	JButton openProject;
	JButton renameProject;
	JButton newModel;
	JButton openModel;
	JButton newDocument;
	JButton openDocument;
	JButton save;
	JButton saveAs;
	
	
	
	public JButton getNewProject() {
		return newProject;
	}
	public void setNewProject(JButton newProject) {
		this.newProject = newProject;
	}
	public JButton getOpenProject() {
		return openProject;
	}
	public void setOpenProject(JButton openProject) {
		this.openProject = openProject;
	}
	public JButton getRenameProject() {
		return renameProject;
	}
	public void setRenameProject(JButton renameProject) {
		this.renameProject = renameProject;
	}
	public JButton getNewModel() {
		return newModel;
	}
	public void setNewModel(JButton newModel) {
		this.newModel = newModel;
	}
	public JButton getOpenModel() {
		return openModel;
	}
	public void setOpenModel(JButton openModel) {
		this.openModel = openModel;
	}
	public JButton getNewDocument() {
		return newDocument;
	}
	public void setNewDocument(JButton newDocument) {
		this.newDocument = newDocument;
	}
	public JButton getOpenDocument() {
		return openDocument;
	}
	public void setOpenDocument(JButton openDocument) {
		this.openDocument = openDocument;
	}
	public JButton getSave() {
		return save;
	}
	public void setSave(JButton save) {
		this.save = save;
	}
	public JButton getSaveAs() {
		return saveAs;
	}
	public void setSaveAs(JButton saveAs) {
		this.saveAs = saveAs;
	}
	public FileToolBar()
	{
		setFloatable(false);
		setBackground(Color.decode("#E9FDFF"));
		
		newProject= new JButton();
		newProject.setBackground(Color.decode("#E9FDFF"));
		newProject.setIcon(new ImageIcon("./icons/newProject.png"));
		newProject.setBorderPainted(false);
		newProject.setToolTipText("New Project");
		add(newProject);
		newProject.setActionCommand("newProject");
		
		//newProject.addActionListener(new ButtonActionListener());
		addSeparator();
		
		 openProject = new JButton();
		openProject.setBackground(Color.decode("#E9FDFF"));
		openProject.setIcon(new ImageIcon("./icons/openProjectIcon.png"));
		openProject.setBorderPainted(false);
		openProject.setToolTipText("Open Project");
		add(openProject);
		addSeparator();
		
		 renameProject = new JButton();
		renameProject.setBackground(Color.decode("#E9FDFF"));
		renameProject.setIcon(new ImageIcon("./icons/RenameIcon.png"));
		renameProject.setBorderPainted(false);
		renameProject.setToolTipText("Rename Project");
		add(renameProject);
		addSeparator();
		
		newModel=new JButton();
		newModel.setBackground(Color.decode("#E9FDFF"));
		newModel.setIcon(new ImageIcon("./icons/diagram.png"));
		newModel.setBorderPainted(false);
		newModel.setToolTipText("New Model");
		add(newModel);
		
		openModel=new JButton();
		openModel.setBackground(Color.decode("#E9FDFF"));
		openModel.setIcon(new ImageIcon("./icons/diagram.png"));
		openModel.setBorderPainted(false);
		openModel.setToolTipText("Open Model");
		add(openModel);
		addSeparator();
		
		
		 newDocument = new JButton();
		newDocument.setBackground(Color.decode("#E9FDFF"));
		newDocument.setIcon(new ImageIcon("./icons/newDocument.png"));
		newDocument.setBorderPainted(false);
		newDocument.setToolTipText("New Document");
		add(newDocument);
	//	newDocument.setActionCommand("newDocument");
		addSeparator();
		
		 openDocument = new JButton();
		openDocument.setBackground(Color.decode("#E9FDFF"));
		openDocument.setIcon(new ImageIcon("./icons/openDocument.png"));
		openDocument.setBorderPainted(false);
		openDocument.setToolTipText("Open Document");
		add(openDocument);
		addSeparator();
		
		 save = new JButton();
		save.setBackground(Color.decode("#E9FDFF"));
		save.setIcon(new ImageIcon("./icons/save.png"));
		save.setBorderPainted(false);
		save.setToolTipText("Save");
		add(save);
		addSeparator();
		
		 saveAs = new JButton();
		saveAs.setBackground(Color.decode("#E9FDFF"));
		saveAs.setIcon(new ImageIcon("./icons/saveAs.png"));
		saveAs.setBorderPainted(false);
		saveAs.setToolTipText("Save As");
		add(saveAs);
		addSeparator();
		
		registerComponents(new ButtonActionListener());
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerComponents(EventListener listener) {
		//listener=new ButtonActionListener();
		//newDocument.addActionListener((ActionListener) listener);
		//newProject.addActionListener((ActionListener) listener);
		for (int i = 0; i < this.getComponentCount(); i++) {
			if (this.getComponent(i) instanceof JButton) {
				((JButton)this.getComponent(i)).addActionListener((ActionListener) listener);
			}
			
		}
		newDocument.setActionCommand("newDocument");
		newModel.setActionCommand("newModel");
		
	}

}
