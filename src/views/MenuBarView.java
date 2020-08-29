/***********************************************************************
 * Module:  MenuBarView.java
 * Author:  Admir Orman
 * Purpose: Defines the Class MenuBarView
 ***********************************************************************/

package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Drawing.TabComponent;
import controller.ButtonActionListener;
import globalClases.ClipboardClass;
import localization.Localization;
import model.ActivityElement;
import model.DecisionElement;
import model.EndElement;
import model.ObjectNodeElement;
import model.PackageElement;
import model.ProjectModel;
import model.StartElement;
import model.SynchronizationElement;

public class MenuBarView extends JMenuBar implements ObserverInterface {
	
	

	private static final long serialVersionUID = 1L;
	JMenu[] menuBarStavke;
	public JMenuItem newProject = new JMenuItem(Localization.getInstance().getString("menu.File.NewProject"));
	public JMenuItem openProject = new JMenuItem(Localization.getInstance().getString("menu.File.OpenProject"));
	public JMenuItem newModel = new JMenuItem(Localization.getInstance().getString("menu.File.NewModel"));
	public JMenuItem newDocument = new JMenuItem(Localization.getInstance().getString("menu.File.NewDocument"));
	public JMenuItem openDocument = new JMenuItem(Localization.getInstance().getString("menu.File.OpenDocument"));
	public JMenuItem save = new JMenuItem(Localization.getInstance().getString("menu.File.Save"));
	public JMenuItem saveAs = new JMenuItem(Localization.getInstance().getString("menu.File.SaveAs"));
	public JMenuItem renameProject = new JMenuItem(Localization.getInstance().getString("menu.File.RenameProject"));
	public JMenuItem close = new JMenuItem(Localization.getInstance().getString("menu.File.Close"));
	public JMenuItem exit = new JMenuItem(Localization.getInstance().getString("menu.File.Exit"));
	
	public JMenuItem copy = new JMenuItem(Localization.getInstance().getString("menu.Edit.Copy"));
	public JMenuItem cut = new JMenuItem(Localization.getInstance().getString("menu.Edit.Cut"));
	public JMenuItem paste = new JMenuItem(Localization.getInstance().getString("menu.Edit.Paste"));
	public  JMenuItem undo = new JMenuItem(Localization.getInstance().getString("menu.Edit.Undo"));
	public  JMenuItem redo = new JMenuItem(Localization.getInstance().getString("menu.Edit.Redo"));
	
	
	public MenuBarView()
	{
		
		setBackground(Color.decode("#E9FDFF"));
		menuBarStavke = postavi_MenuBar();
		
		for(int i = 0;i<menuBarStavke.length;i++)
		{
			add(menuBarStavke[i]);
		}
	}
	public JMenu[] postavi_MenuBar()
	{
		JMenu[] menuBarStavke = new JMenu[5];
		
		menuBarStavke[0] =  new JMenu(Localization.getInstance().getString("menu.File"));
		Localization.getInstance().registerComponent("menu.File", menuBarStavke[0]);
		menuBarStavke[0].setMnemonic(KeyEvent.VK_F);
		postaviFile(menuBarStavke[0]);	
		
		menuBarStavke[1] =  new JMenu(Localization.getInstance().getString("menu.Edit"));
		Localization.getInstance().registerComponent("menu.Edit", menuBarStavke[1]);
		menuBarStavke[1].setMnemonic(KeyEvent.VK_E);
		postaviEdit(menuBarStavke[1]);
		
		menuBarStavke[2] =  new JMenu(Localization.getInstance().getString("menu.View"));
		Localization.getInstance().registerComponent("menu.View", menuBarStavke[2]);
		menuBarStavke[2].setMnemonic(KeyEvent.VK_V);
		postaviView(menuBarStavke[2]);
		
		menuBarStavke[3] =  new JMenu(Localization.getInstance().getString("menu.Help"));
		Localization.getInstance().registerComponent("menu.Help", menuBarStavke[3]);
		menuBarStavke[3].setMnemonic(KeyEvent.VK_H);
		postaviHelp(menuBarStavke[3]);
		
		menuBarStavke[4] =  new JMenu(Localization.getInstance().getString("menu.Options"));
		Localization.getInstance().registerComponent("menu.Options", menuBarStavke[4]);
		menuBarStavke[4].setMnemonic(KeyEvent.VK_O);
		postaviOptions(menuBarStavke[4]);
		
		return menuBarStavke;
	}
	
	
	public void postaviFile(JMenu File)
	{
		Localization.getInstance().registerComponent("menu.File.NewProject", newProject);
		newProject.setMnemonic(KeyEvent.VK_N);
		newProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		newProject.setIcon(new ImageIcon("./icons/newProject.png"));
		newProject.setActionCommand("newProject");
		newProject.addActionListener(new ButtonActionListener());

		
		Localization.getInstance().registerComponent("menu.File.OpenProject", openProject);
		openProject.setMnemonic(KeyEvent.VK_O);
		openProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		openProject.setIcon(new ImageIcon("./icons/openProjectIcon.png"));
		openProject.setActionCommand("openProject");
		
		
		Localization.getInstance().registerComponent("menu.File.NewModel", newModel);
		newModel.setMnemonic(KeyEvent.VK_M);
		newModel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
		newModel.setIcon(new ImageIcon("./icons/diagram.png"));
		newModel.setActionCommand("newModel");
		newModel.addActionListener(new ButtonActionListener());
		
		
		Localization.getInstance().registerComponent("menu.File.NewDocument", newDocument);
		newDocument.setMnemonic(KeyEvent.VK_E);
		newDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		newDocument.setIcon(new ImageIcon("./icons/newDocument.png"));
		newDocument.setActionCommand("newDocument");
		newDocument.addActionListener(new ButtonActionListener());

	
		Localization.getInstance().registerComponent("menu.File.OpenDocument", openDocument);
		openDocument.setMnemonic(KeyEvent.VK_O);
		openDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK+KeyEvent.SHIFT_MASK));
		openDocument.setIcon(new ImageIcon("./icons/openDocument.png"));
		openDocument.setActionCommand("openDocument");
		
		
		Localization.getInstance().registerComponent("menu.File.Save", save);
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		save.setIcon(new ImageIcon("./icons/save.png"));
		save.setActionCommand("save");
		
	
		Localization.getInstance().registerComponent("menu.File.SaveAs", saveAs);
		saveAs.setIcon(new ImageIcon("./icons/saveAs.png"));
		saveAs.setActionCommand("saveAs");
		
		
		
		Localization.getInstance().registerComponent("menu.File.RenameProject", renameProject);
		renameProject.setMnemonic(KeyEvent.VK_R);
		renameProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
		renameProject.setIcon(new ImageIcon("./icons/renameIcon.png"));
		renameProject.setActionCommand("renameProject");

	
		Localization.getInstance().registerComponent("menu.File.Close", close);
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
		close.setIcon(new ImageIcon("./icons/close.png"));
		close.setActionCommand("close");
		
		
		JMenuItem recentFiles = new JMenuItem(Localization.getInstance().getString("menu.File.RecentFiles"));
		Localization.getInstance().registerComponent("menu.File.RecentFiles", recentFiles);		
		
	
		Localization.getInstance().registerComponent("menu.File.Exit", exit);
		exit.setMnemonic(KeyEvent.VK_X);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
		exit.setIcon(new ImageIcon("./icons/exit.png"));
		exit.setActionCommand("exit");
		
		

		File.add(newProject);
		File.add(openProject);
		File.add(renameProject);
		File.addSeparator();
		File.add(newModel);
		File.add(newDocument);
		File.add(openDocument);
		File.addSeparator();
		File.add(save);
		File.add(saveAs);
		File.addSeparator();
		File.add(close);
		File.addSeparator();
		File.add(recentFiles);
		File.addSeparator();
		File.add(exit);		
	}
	public void postaviEdit(JMenu Edit)
	{
		Localization.getInstance().registerComponent("menu.Edit.Copy", copy);
		copy.setMnemonic(KeyEvent.VK_O);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		copy.setIcon(new ImageIcon("./icons/copy.png"));
		copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			ClipboardClass clipboard = ClipboardClass.getInstance();
			clipboard.copy = true;
			}
		});
		copy.setActionCommand("copy");
		
		
		Localization.getInstance().registerComponent("menu.Edit.Cut", cut);
		cut.setMnemonic(KeyEvent.VK_C);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		cut.setIcon(new ImageIcon("./icons/cut.png"));
		cut.setActionCommand("cut");

		
		Localization.getInstance().registerComponent("menu.Edit.Paste", paste);
		paste.setMnemonic(KeyEvent.VK_P);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
		paste.setIcon(new ImageIcon("./icons/paste.png"));
		paste.setActionCommand("paste");
		paste.addActionListener(new ButtonActionListener());
			
	
		Localization.getInstance().registerComponent("menu.Edit.Undo", undo);
		undo.setMnemonic(KeyEvent.VK_U);
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		undo.setIcon(new ImageIcon("./icons/undo.png"));
		undo.setActionCommand("undo");
		undo.setEnabled(false);

		
		Localization.getInstance().registerComponent("menu.Edit.Redo", redo);
		redo.setMnemonic(KeyEvent.VK_R);
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK));
		redo.setIcon(new ImageIcon("./icons/redo.png"));
		redo.setActionCommand("redo");
	
		Edit.add(copy);
		Edit.add(cut);
		Edit.add(paste);
		Edit.addSeparator();
		Edit.add(undo);
		Edit.add(redo);
	
	}
	
	
	public void postaviView(JMenu View)
	{
		JMenuItem actualSize=new JMenuItem(Localization.getInstance().getString("menu.View.ActualSize"));
		Localization.getInstance().registerComponent("menu.View.ActualSize", actualSize);
		actualSize.setMnemonic(KeyEvent.VK_A);
		actualSize.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, KeyEvent.ALT_MASK));
		actualSize.setActionCommand("actualSize");
		
		JMenuItem zoomIn = new JMenuItem(Localization.getInstance().getString("menu.View.ZoomIn"));
		Localization.getInstance().registerComponent("menu.View.ZoomIn", zoomIn);
		zoomIn.setMnemonic(KeyEvent.VK_I);
		zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, KeyEvent.ALT_MASK));
		zoomIn.setIcon(new ImageIcon("./icons/zoomin.png"));
		zoomIn.setActionCommand("zoomIn");

		
		JMenuItem zoomOut = new JMenuItem(Localization.getInstance().getString("menu.View.ZoomOut"));
		Localization.getInstance().registerComponent("menu.View.ZoomOut", zoomOut);
		zoomOut.setMnemonic(KeyEvent.VK_O);
		zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, KeyEvent.ALT_MASK));
		zoomOut.setIcon(new ImageIcon("./icons/zoomout.png"));
		zoomOut.setActionCommand("zoomOut");
		
		JMenuItem scale = new JMenuItem(Localization.getInstance().getString("menu.View.Scale"));
		Localization.getInstance().registerComponent("menu.View.Scale", scale);
		scale.setIcon(new ImageIcon("./icons/scale.png"));
		scale.setActionCommand("scale");

		JCheckBox toolboxView = new JCheckBox(Localization.getInstance().getString("menu.View.Toolbox"));
		Localization.getInstance().registerComponent("menu.View.Toolbox", toolboxView);
		

		JMenuItem editToolbar = new JMenuItem(Localization.getInstance().getString("menu.View.EditToolbar"));
		Localization.getInstance().registerComponent("menu.View.EditToolbar", editToolbar);
		editToolbar.setActionCommand("editToolbar");
		
		JMenuItem fileToolbar = new JMenuItem(Localization.getInstance().getString("menu.View.FileToolbar"));
		Localization.getInstance().registerComponent("menu.View.FileToolbar", fileToolbar);
		fileToolbar.setActionCommand("fileToolbar");
		
		View.add(actualSize);
		View.add(zoomIn);
		View.add(zoomOut);	
		View.add(scale);
		View.addSeparator();
		View.add(toolboxView);
		View.add(editToolbar);
		View.add(fileToolbar);


	}
	
	public void postaviHelp(JMenu Help) 
	{
		JMenuItem about=new JMenuItem(Localization.getInstance().getString("menu.Help.About"));
		Localization.getInstance().registerComponent("menu.Help.About", about);
		about.setIcon(new ImageIcon("./icons/diagram.png"));
		about.setActionCommand("about");
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
					    "Team members:          \nPetar Rasevic\nMilica Vukovic\nSlavica Miloševic\nNikola Bastah\nVidoslav Kakuca",
					    "Activity Diagram Editor",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		Help.add(about);
		
	}
	
	public void postaviOptions(JMenu Options)
	{
		JMenu languageMenu = new JMenu(Localization.getInstance().getString("menu.Options.Language"));
		Localization.getInstance().registerComponent("menu.Options.Language", languageMenu);
		
		
		JCheckBoxMenuItem english = new JCheckBoxMenuItem(Localization.getInstance().getString("menu.Options.Language.English"));
		Localization.getInstance().registerComponent("menu.Options.Language.English", english);
		english.setSelected(true);
		english.setMnemonic(KeyEvent.VK_E);
		english.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		english.setActionCommand("english");
		english.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				Localization.getInstance().setLocal("en", "US");
				Localization.getInstance().updateAll();
				
			}
		});
		
		
		
		languageMenu.add(english);
		
		JCheckBoxMenuItem serbian = new JCheckBoxMenuItem(Localization.getInstance().getString("menu.Options.Language.Serbian"));
		Localization.getInstance().registerComponent("menu.Options.Language.Serbian", serbian);
		serbian.setMnemonic(KeyEvent.VK_S);
		serbian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		serbian.setActionCommand("serbian");
		serbian.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Localization.getInstance().setLocal("sr", "RS");
				Localization.getInstance().updateAll();
				
			}
		});
		
		languageMenu.add(serbian);
		
		JCheckBoxMenuItem bosnian = new JCheckBoxMenuItem(Localization.getInstance().getString("menu.Options.Language.Bosnian"));
		Localization.getInstance().registerComponent("menu.Options.Language.Bosnian", bosnian);
		bosnian.setMnemonic(KeyEvent.VK_B);
		bosnian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
		bosnian.setActionCommand("bosnian");
		bosnian.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Localization.getInstance().setLocal("bs", "BA");
				Localization.getInstance().updateAll();
				
			}
		});
		
		languageMenu.add(bosnian);
		
		ButtonGroup group = new ButtonGroup();
		group.add(english);
		group.add(serbian);
		group.add(bosnian);
		
		languageMenu.setIcon(new ImageIcon("./icons/book.png"));
		languageMenu.setActionCommand("language");
		
		Options.add(languageMenu);		
	}
		
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerComponents(EventListener listener) {
		for (JMenu jMenu : menuBarStavke) {
			for(int i=0;i<jMenu.getItemCount();i++) {
				if (jMenu.getItem(i)instanceof JMenuItem) {
					jMenu.getItem(i).addActionListener((ActionListener) listener);
				}
			}
		}
		
		
	}
}