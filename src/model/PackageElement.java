package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Drawing.TabComponent;
import Drawing.DragLineClass;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;

public class PackageElement extends Element {
	

	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();

	
	public PackageElement(Point lokacija, Dimension velicina,String naziv) {
		this.naziv=naziv;
		setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
		setSize(velicina);
		setBackground(Color.WHITE);
		TabComponent tabComponent=((TabComponent) ((PackageElement)this).getParent());
	
	
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
        try {
			BufferedImage img = ImageIO.read(new File("./icons/package.png"));
			Image slika = img.getScaledInstance(100,100, Image.SCALE_SMOOTH);
			g2d.drawImage(slika, null, null);
			TabComponent tabComponent=((TabComponent) ((PackageElement)this).getParent());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  PackageElement()  {
		addMouseListener(new PanelMouseListener());
		}
		
}
