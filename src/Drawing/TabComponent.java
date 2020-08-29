package Drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import command.DrawLine;
import controller.DrawController;
import globalClases.ToolboxGlobalClass;
import model.ActivityElement;
import model.DecisionElement;
import model.Dokument;
import model.ObjectNodeElement;
import model.PackageElement;
import model.StartElement;
import model.SynchronizationElement;
import model.TextElement;
import mouseListeners.MyMouseListener;
import model.ModelModel;


import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.MainWindow;
import views.ObserverInterface;
import views.ToolboxView;



public class TabComponent extends JPanel implements ObserverInterface {
	
	public double zoomFactor = 1;
	public boolean zoomer = false;
	public AffineTransform at;
	public ArrayList<Point> flows = new ArrayList<Point>();
	public static Color color;
	public static Color backColor = Color.WHITE; 

	public void setColor(Color color) {
		this.color = color;
	}
	public ArrayList<model.Element> selectedElemnts = new ArrayList<model.Element>();
	
	public static int brojActivityElementa = 0;
	public static int brojDecisionElementa = 0;
	public static int brojPackageElementa = 0;
	public static int brojEndElementa = 0;
	public static int brojObjectNodeElemnata = 0;
	public static int brojStartElemenata = 0;
	public static int brojSyncElementata = 0;
	
//	MainWindow mainWindow=(MainWindow) this.getTopLevelAncestor();
//	TreeView treeView=mainWindow.getProjectExplorerView().getTree();
	
	
	public int getBrojPackageElementa() {
		return brojPackageElementa;
	}
	public void setBrojPackageElementa(int brojPackageElementa) {
		this.brojPackageElementa = brojPackageElementa;
	}
	private String naziv;
	ModelModel model;
	
	Dokument dokument;

	
	public Dokument getDokument() {
		return dokument;
	}
	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getBrojActivityElementa() {
		return brojActivityElementa;
	}
	public void setBrojActivityElementa(int brojActivityElementa) {
		this.brojActivityElementa = brojActivityElementa;
	}
	public ArrayList<Point> getFlows() {
		return flows;
	}
	public void setFlows(ArrayList<Point> flows) {
		this.flows = flows;
	}
	public double getZoomFactor() {
		return zoomFactor;
	}
	
	
	public TabComponent(String name,ModelModel model) {
		this.naziv=name;
		setLayout(null);
		setPreferredSize(new Dimension(5000,5000));

this.model=model;
		
	//	addMouseListener(new DrawingMouseListener());
addMouseListener(new MyMouseListener(model,this));
	new DrawController(model, this);

	}
	
	@Override	
	public void repaint() {
		super.repaint();
	 }
	


					
		 public void NacrtajLine(Graphics g)
		 {
 
		new DrawLine(this, g).execute();
			

			
			 

		 }
	  @Override public void paint(Graphics g) { super.paint(g);
	  
	  Graphics2D g2 = (Graphics2D) g;
	  
	  setBackground(backColor);

	  NacrtajLine(g); } 
	  
	
	 public void NacrtajTextPanel(TabComponent tab,int x,int y)
	 {
		 TextElement text = new TextElement(new Point(x,y),new Dimension(100,20));

		 tab.add(text);
		 tab.repaint();
	 }
	 public void addFlow(Point tacka)
	 {
		flows.add(tacka);
	 }
	@Override
	public void update() {
		repaint();
		
	}
	@Override
	public void registerComponents(EventListener listener) {
		// TODO Auto-generated method stub
		
	}

}
