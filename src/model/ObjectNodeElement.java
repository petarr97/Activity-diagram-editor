package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class ObjectNodeElement extends Element {
	
	
	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();
	public static Dimension velicina;

	public  ObjectNodeElement(Point lokacija,Dimension velicina,String string) {

		setLocation((int)(lokacija.getX()-velicina.getWidth()/2),(int)(lokacija.getY()-velicina.getHeight()/2));
		this.velicina = velicina;
		setSize(velicina);
		setBackground(Color.decode("#e0e0d1"));
		naziv=string;
		TabComponent tabComponent=((TabComponent) ((ObjectNodeElement)this).getParent());
		
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawRect(1, 1,(int)velicina.getWidth()-2, (int)velicina.getHeight()-2);
		
	
	}
	
	public ObjectNodeElement() {
		addMouseListener(new PanelMouseListener());
		}
		

}
