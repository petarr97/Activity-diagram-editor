package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import ConfigurationWindows.ActivityFrame;
import ConfigurationWindows.ConfigurationControllers;
import Drawing.TabComponent;
import Drawing.DragLineClass;
import globalClases.ElementGlobalClass;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;
import views.ObserverInterface;

public class ActivityElement extends Element {

	public static int pozicija;
	public static Point tacka;
	
	public String action;
	public String preCondition;
	public String postCondition;
	public String descritpion;
	public String anotation;
	
	
	@Override
	protected void paintComponent(Graphics g) {
	
		Graphics2D g2d = (Graphics2D) g;
		
        try {
			BufferedImage img = ImageIO.read(new File("./icons/rectangle-icon.png"));
			Image slika = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			g2d.drawImage(slika, null, null);
			
			String ispis = naziv;
			
			g2d.setColor(Color.WHITE);
			FontMetrics fm = getFontMetrics(getFont());
			int width = fm.stringWidth(naziv);
			if(width >= getWidth())
			{
				ispis  = ispis.substring(0, 15) + "...";
				width = fm.stringWidth(ispis);
			}
			g.setFont(new Font("TimesRoman", Font.BOLD, 11)); 
			g2d.drawString(ispis, (getWidth()-width)/2-5, 30);
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	

	public ActivityElement(Point lokacija, Dimension velicina,String naziv) {
		
		super();
		setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
		setSize(velicina);
		setBackground(Color.WHITE);
	this.naziv=naziv;
		ElementGlobalClass element = ElementGlobalClass.getInstance();
	
		//naziv = null;
		


//		if(naziv == null) {
//	
//		naziv = "ActivityElement"+broj;
//		}
		
	//	MainWindow mainWindow=this.getParent();
	
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
					ActivityFrame frame = new ActivityFrame(new Point(200,200),(ActivityElement) e.getSource());
					((ActivityElement)e.getSource()).getInterfaces().add(frame);
				((ActivityElement)e.getSource()).getInterfaces().add((TabComponent) ((ActivityElement)e.getSource()).getParent());
				
				
				ConfigurationControllers configurationControllers=	new ConfigurationControllers(frame,(ActivityElement) e.getSource());
				
				}
			}
		});
		
	}
	public ActivityElement() {
	addMouseListener(new PanelMouseListener());
	}
	
	
	
}

