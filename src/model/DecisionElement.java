package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ConfigurationWindows.ActivityFrame;
import ConfigurationWindows.ConfigurationControllers;
import ConfigurationWindows.DecisionController;
import ConfigurationWindows.DecisionFrame;
import Drawing.TabComponent;
import Drawing.DragLineClass;
import globalClases.ElementGlobalClass;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;

public class DecisionElement extends Element {

	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();
	String conditionsString;

	
public String getConditionsString() {
		return conditionsString;
	}
	public void setConditionsString(String conditionsString) {
		this.conditionsString = conditionsString;
	}
public DecisionElement(Point lokacija,Dimension velicina,String naziv) {
	super();
	setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
	setSize(velicina);
	setBackground(Color.black);
	this.naziv=naziv;
	ElementGlobalClass element = ElementGlobalClass.getInstance();
	
	
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
				DecisionFrame frame = new DecisionFrame(new Point(200,200),(DecisionElement) e.getSource());
				((DecisionElement)e.getSource()).getInterfaces().add(frame);
			((DecisionElement)e.getSource()).getInterfaces().add((TabComponent) ((DecisionElement)e.getSource()).getParent());
			
			
			DecisionController configurationControllers=	new DecisionController(frame,(DecisionElement) e.getSource());
			
			}
		}
	});	// TODO Auto-generated method stub
	
}
@Override
protected void paintComponent(Graphics g) {
	//super.paintComponent(g);
	
	 Graphics2D g2d = (Graphics2D)g;
	 	 
	 try {
		BufferedImage img = ImageIO.read(new File("./icons/Rhombus-icon.png"));
		Image slika = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		g2d.drawImage(slika, null, null);
		
		g2d.setColor(Color.black);
		FontMetrics fm = getFontMetrics( getFont() );
		int width = fm.stringWidth(naziv);
		g.setFont(new Font("TimesRoman", Font.BOLD, 11)); 
		g2d.drawString(naziv, (getWidth()-width)/2+1, 50);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	 
		

	
}
}
