package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ConfigurationWindows.DecisionController;
import ConfigurationWindows.DecisionFrame;
import ConfigurationWindows.EndController;
import ConfigurationWindows.EndFrame;
import Drawing.TabComponent;
import Drawing.DragLineClass;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;

public class EndElement extends Element {
	
	
	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();
	
	public EndElement(Point lokacija,Dimension velicina,String naziv) {
		setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
		setSize(velicina);
		setBackground(Color.white);
		this.naziv=naziv;
		TabComponent tabComponent=((TabComponent) ((EndElement)this).getParent());
		
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
					EndFrame frame = new EndFrame(new Point(200,200),(EndElement) e.getSource());
					((EndElement)e.getSource()).getInterfaces().add(frame);
				((EndElement)e.getSource()).getInterfaces().add((TabComponent) ((EndElement)e.getSource()).getParent());
				
				
				EndController configurationControllers=	new EndController(frame,(EndElement) e.getSource());
				
				}
			}
		});	// TODO Auto-generated method stub
		
		}
	
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		 
		 try {
				BufferedImage img = ImageIO.read(new File("./icons/end.png"));
				Image slika = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				//img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				g2d.drawImage(slika, null, null);
	
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
	public EndElement() {
		addMouseListener(new PanelMouseListener());
	}
}