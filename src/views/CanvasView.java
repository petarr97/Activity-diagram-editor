/***********************************************************************
 * Module:  CanvasView.java
 * Author:  Admir Orman
 * Purpose: Defines the Class CanvasView
 ***********************************************************************/

package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Drawing.TabComponent;

public class CanvasView extends JTabbedPane implements ObserverInterface {
	public static JPanel panel;
	public static JPanel panel1;
	
	  HashMap<String, ScrollPaneView> skrolovi=new HashMap<String, ScrollPaneView>();
	  public static Vector<TabComponent>tabs=new Vector<TabComponent>();
	  
	  public static Vector<TabComponent> getTabs() { return tabs; }
	  
	  public static void setTabs(Vector<TabComponent> panels) { CanvasView.tabs =
	  panels; }
	  
	  public Vector<JScrollPane>scrollPanes=new Vector<JScrollPane>();
	 

	public HashMap<String, ScrollPaneView> getSkrolovi() {
		return skrolovi;
	}

	public void setSkrolovi(HashMap<String, ScrollPaneView> skrolovi) {
		this.skrolovi = skrolovi;
	}

	public Vector<JScrollPane> getScrollPanes() {
		return scrollPanes;
	}

	public void setScrollPanes(Vector<JScrollPane> scrollPanes) {
		this.scrollPanes = scrollPanes;
	}

	JScrollPane scrollPane;
	JScrollPane scrollPane1;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public CanvasView()
	{
		//setPreferredSize(new Dimension(500,500));
		setBackground(Color.decode("#E9FDFF"));
	
		
	}
	



	public static JPanel getPanel() {
		return panel;
	}




	public static void setPanel(JPanel panel) {
		CanvasView.panel = panel;
	}




	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerComponents(EventListener listener) {
		// TODO Auto-generated method stub
		
	}

	
}