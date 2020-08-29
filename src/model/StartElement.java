package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ConfigurationWindows.ActivityFrame;
import ConfigurationWindows.ConfigurationControllers;
import ConfigurationWindows.StartController;
import ConfigurationWindows.StartFrame;
import Drawing.TabComponent;
import Drawing.DragLineClass;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;

public class StartElement extends Element {
	

	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();

	
	public StartElement(Point lokacija,Dimension velicina,String naziv) {
		setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
		setSize(velicina);
		setBackground(Color.WHITE);
		this.naziv=naziv;
//		if (naziv==null) {
//			naziv="Start"+ naziv;
//		}
	
		
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
					StartFrame frame = new StartFrame(new Point(200,200),(StartElement) e.getSource());
					((StartElement)e.getSource()).getInterfaces().add(frame);
				((StartElement)e.getSource()).getInterfaces().add((TabComponent) ((StartElement)e.getSource()).getParent());
				
				StartController controller=new StartController(frame, (StartElement) e.getSource());
				}
			}
				
			
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D)g;
		 
		 //AffineTransform at = AffineTransform.getTranslateInstance(0,0);
	 	 
		 try {
			BufferedImage img = ImageIO.read(new File("./icons/start.png"));
			Image slika = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			//img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			g2d.drawImage(slika, null, null);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  StartElement() {
		addMouseListener(new PanelMouseListener());
		}
		

}
