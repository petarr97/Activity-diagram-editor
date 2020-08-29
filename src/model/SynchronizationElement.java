package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.swing.JPanel;

import ConfigurationWindows.EndController;
import ConfigurationWindows.EndFrame;
import ConfigurationWindows.SyncController;
import ConfigurationWindows.SyncFrame;
import Drawing.TabComponent;
import Drawing.DragLineClass;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;

public class SynchronizationElement extends Element {
	

	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();


	public SynchronizationElement(Point lokacija,Dimension velicina,String naziv) {
		super();
		setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
		setSize(velicina);
		setBackground(Color.decode("#00a3cc"));
		this.naziv=naziv;
		addMouseListener(new PanelMouseListener());
		
//		 if (naziv==null) {
//				naziv="Synchronization"+ broj;
//			}
		
addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && ToolboxGlobalClass.getInstance().isSelect())
				{
					SyncFrame frame = new SyncFrame(new Point(200,200),(SynchronizationElement) e.getSource());
					((SynchronizationElement)e.getSource()).getInterfaces().add(frame);
				((SynchronizationElement)e.getSource()).getInterfaces().add((TabComponent) ((SynchronizationElement)e.getSource()).getParent());
				
				
				SyncController configurationControllers = new SyncController(frame,(SynchronizationElement) e.getSource());
				
				}
			}
		});	// TODO Auto-generated method stub
		
		}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		addMouseListener(new PanelMouseListener());
		 
	}
//	public  SynchronizationElement(Point point, Dimension dimension, String naziv)  {
//		addMouseListener(new PanelMouseListener());
//		}
//		
}
