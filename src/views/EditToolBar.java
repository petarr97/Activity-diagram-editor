package views;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import Drawing.TabComponent;
import controller.ButtonActionListener;
import globalClases.ClipboardClass;
import globalClases.ToolboxGlobalClass;
import model.ActivityElement;

public class EditToolBar extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton cut = new JButton();
	JButton copy = new JButton();
	JButton paste = new JButton();
 	JButton undo = new JButton();
 	JButton redo = new JButton();
	public JButton getCut() {
		return cut;
	}
	public void setCut(JButton cut) {
		this.cut = cut;
	}
	public JButton getCopy() {
		return copy;
	}
	public void setCopy(JButton copy) {
		this.copy = copy;
	}
	public JButton getPaste() {
		return paste;
	}
	public void setPaste(JButton paste) {
		this.paste = paste;
	}
	public JButton getUndo() {
		return undo;
	}
	public void setUndo(JButton undo) {
		this.undo = undo;
	}
	public JButton getRedo() {
		return redo;
	}
	public void setRedo(JButton redo) {
		this.redo = redo;
	}
	public EditToolBar()
	{
		setFloatable(false);
		setBackground(Color.decode("#E9FDFF"));
		
		cut.setBackground(Color.decode("#E9FDFF"));
		cut.setIcon(new ImageIcon("./icons/cut.png"));
		cut.setBorderPainted(false);
		cut.setToolTipText("Cut");
		cut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
					MainWindow prozor = (MainWindow)getTopLevelAncestor();
					CanvasView canvas = prozor.getCanvasView();
					ToolboxView toolbox = prozor.getToolboxView();
					toolbox.ponisti();
					klasa.cut = true;
				
					canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
							new ImageIcon("./icons/cut-icon.png").getImage(),
							new Point(0,0),"custom cursor"));
							
			}
		});
		add(cut);
		addSeparator();
		
		
		copy.setBackground(Color.decode("#E9FDFF"));
		copy.setIcon(new ImageIcon("./icons/copy.png"));
		copy.setBorderPainted(false);
		copy.setToolTipText("Copy");
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
				MainWindow prozor = (MainWindow)getTopLevelAncestor();
				CanvasView canvas = prozor.getCanvasView();
				ToolboxView toolbox = prozor.getToolboxView();
				ClipboardClass clipboard = ClipboardClass.getInstance();
				clipboard.setCopy(true);
				
				toolbox.ponisti();
				klasa.copy = true;
				
				
				canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("./icons/copy.png").getImage(),
						new Point(0,0),"custom cursor"));
				
				
			}
		});
		add(copy);
		addSeparator();
		
		
		paste.setBackground(Color.decode("#E9FDFF"));
		paste.setIcon(new ImageIcon("./icons/paste.png"));
		paste.setBorderPainted(false);
		paste.setToolTipText("Paste");
		paste.setActionCommand("paste");
		paste.addActionListener(new ButtonActionListener());
		add(paste);
		addSeparator();
		
		
		undo.setBackground(Color.decode("#E9FDFF"));
		undo.setIcon(new ImageIcon("./icons/undo.png"));
		undo.setBorderPainted(false);
		undo.setToolTipText("Undo");
		add(undo);
		undo.setActionCommand("undo");
		undo.addActionListener(new ButtonActionListener());
		addSeparator();
		
		
		redo.setBackground(Color.decode("#E9FDFF"));
		redo.setIcon(new ImageIcon("./icons/redo.png"));
		redo.setBorderPainted(false);
		redo.setToolTipText("Redo");
		redo.setActionCommand("redo");
		redo.addActionListener(new ButtonActionListener());
		add(redo);
		addSeparator();
		
		
	}
	

}
