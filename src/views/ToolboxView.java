/***********************************************************************
 * 
 * * Module:  ToolboxView.java
 * Author:  Admir Orman
 * Purpose: Defines the Class ToolboxView
 ***********************************************************************/

package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Drawing.TabComponent;
import globalClases.ClipboardClass;
import globalClases.ToolboxGlobalClass;
import localization.Localization;
import model.ActivityElement;

public class ToolboxView extends JPanel {
	
	public JButton graberButton;
	public JButton pointerButton;
	public JComboBox<Object> getBackGrounds() {
		return backGrounds;
	}

	public void setBackGrounds(JComboBox<Object> backGrounds) {
		this.backGrounds = backGrounds;
	}

	public JComboBox<Object> getFlows() {
		return flows;
	}

	public void setFlows(JComboBox<Object> flows) {
		this.flows = flows;
	}
	public JButton zoomInButton;
	public JButton zoomOutButton;
	public JPanel seccondRowPanel;
	public JButton deleteButton;
	public JButton packageButton;
	public JButton activityButton;
	public JButton objectnodeButton;
	public JButton decisionButton;
	public JButton startButton;
	public JButton endButton;
	public JButton lineButton;
	public JButton syncButton;
	public JPanel firstRowPanel;
	public JButton textButton;
	public JButton cutButton;
	public  Color color;
	JComboBox<Object> backGrounds = null;
	JComboBox<Object> flows = null;
	
	
	public JPanel getSeccondRowPanel() {
		return seccondRowPanel;
	}

	public void setSeccondRowPanel(JPanel seccondRowPanel) {
		this.seccondRowPanel = seccondRowPanel;
	}

	public ToolboxView() {
		
		setLayout(null);
		setBackground(Color.white);
		setPreferredSize(new Dimension(300,0));
		
		firstRowPanel = new JPanel();
		
		firstRowPanel.setPreferredSize(new Dimension(300,40));
		firstRowPanel.setBackground(Color.WHITE);
		firstRowPanel.setLocation(new Point(2,23));
		firstRowPanel.setSize(300,40);
		//firstRowPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		firstRowPanel.setLayout(null);
		
		
	    graberButton = new JButton();
		graberButton.setIcon(new ImageIcon("./icons/hand.png"));
		graberButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviGraber();
			}
		});
		graberButton.setBorder(BorderFactory.createEmptyBorder());
		graberButton.setLocation(5,1);
		graberButton.setSize(new Dimension(40,38));
		graberButton.setBackground(Color.WHITE);
		firstRowPanel.add(graberButton);
		
	    pointerButton = new JButton();
	    pointerButton.setBackground(Color.WHITE);
		pointerButton.setIcon(new ImageIcon("./icons/pointer.png"));
		pointerButton.setBorder(BorderFactory.createEmptyBorder());
		pointerButton.setLocation(55,1);
		pointerButton.setSize(new Dimension(40,38));
		firstRowPanel.add(pointerButton);
				
	
		
	
		add(firstRowPanel);
		
		seccondRowPanel = new JPanel();
	    seccondRowPanel.setBackground(Color.WHITE);
		seccondRowPanel.setPreferredSize(new Dimension(300,40));
		seccondRowPanel.setLocation(new Point(0,64));
		seccondRowPanel.setSize(300,80);
		//seccondRowPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		seccondRowPanel.setLayout(null);
		
		deleteButton = new JButton();
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setIcon(new ImageIcon("./icons/delete.png"));
		deleteButton.setBorder(BorderFactory.createEmptyBorder());
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				postaviDelete();
			}
		});
		deleteButton.setLocation(5,1);
		deleteButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(deleteButton);
		
		packageButton = new JButton();
		packageButton.setBackground(Color.WHITE);
		packageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPackage();
				
			}
		});
		packageButton.setIcon(new ImageIcon("./icons/package1.png"));
		packageButton.setBorder(BorderFactory.createEmptyBorder());
		packageButton.setLocation(55,1);
		packageButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(packageButton);
		
		activityButton = new JButton();
		activityButton.setBackground(Color.WHITE);
		activityButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			postaviActivity();
			}
		});
		activityButton.setIcon(new ImageIcon("./icons/activity.png"));
		activityButton.setBorder(BorderFactory.createEmptyBorder());
		activityButton.setLocation(105,1);
		activityButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(activityButton);
		
		objectnodeButton = new JButton();
		objectnodeButton.setBackground(Color.WHITE);
		objectnodeButton.setIcon(new ImageIcon("./icons/objectnode.png"));
		objectnodeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviObjectNode();
				
			}
		});
		objectnodeButton.setBorder(BorderFactory.createEmptyBorder());
		objectnodeButton.setLocation(155,1);
		objectnodeButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(objectnodeButton);
		
		decisionButton = new JButton();
		decisionButton.setBackground(Color.white);
		decisionButton.setIcon(new ImageIcon("./icons/decision.png"));
		decisionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviDecison();
				
			}
		});
		decisionButton.setBorder(BorderFactory.createEmptyBorder());
		decisionButton.setLocation(205,1);
		decisionButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(decisionButton);
		
		startButton = new JButton();
		startButton.setBackground(Color.white);
		startButton.setIcon(new ImageIcon("./icons/start.png"));
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviStart();
			}
		});
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setLocation(255,1);
		startButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(startButton);
		
		endButton = new JButton();
		endButton.setBackground(Color.white);
		endButton.setIcon(new ImageIcon("./icons/end.png"));
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviEnd();
			}
		});
		endButton.setBorder(BorderFactory.createEmptyBorder());
		endButton.setLocation(5,40);
		endButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(endButton);
		
		lineButton = new JButton();
		lineButton.setBackground(Color.white);
		lineButton.setIcon(new ImageIcon("./icons/line.png"));
		lineButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviLine();
			}
		});
		lineButton.setBorder(BorderFactory.createEmptyBorder());
		lineButton.setLocation(55,40);
		lineButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(lineButton);
		
		syncButton = new JButton();
		syncButton.setBackground(Color.white);
		syncButton.setIcon(new ImageIcon("./icons/sync.png"));
		syncButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviSinchronization();
			}
		});
		syncButton.setBorder(BorderFactory.createEmptyBorder());
		syncButton.setLocation(105,40);
		syncButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(syncButton);
		
		textButton = new JButton();
		textButton.setBackground(Color.white);
		textButton.setIcon(new ImageIcon("./icons/text.png"));
		textButton.setBorder(BorderFactory.createEmptyBorder());
		textButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviTextElement();
			}
		});
		textButton.setLocation(155,40);
		textButton.setSize(new Dimension(40,38));
		seccondRowPanel.add(textButton);	
		
		add(seccondRowPanel);
		
		Object[] items=
			{
					 new ImageIcon("./backgrounds/pozadina1.PNG"),
					 new ImageIcon("./backgrounds/pozadina2.PNG"),
					 new ImageIcon("./backgrounds/pozadina3.PNG"),
					 new ImageIcon("./backgrounds/pozadina4.PNG")
			};
		
		
		JLabel labela = new JLabel(Localization.getInstance().getString("toolbox.canvasColor"));
		Localization.getInstance().registerComponent("toolbox.canvasColor", labela);
		labela.setSize(new Dimension(400,20));
		labela.setLocation(new Point(10,180));
		add(labela);
		
		backGrounds = new JComboBox<Object>(items);
		backGrounds.setSelectedIndex(1);
		backGrounds.setLocation(new Point(10,200));
		backGrounds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index = backGrounds.getSelectedIndex();
				MainWindow frame=(MainWindow) SwingUtilities.getWindowAncestor(backGrounds);
				CanvasView canvasView=frame.getCanvasView();
				ScrollPaneView panel = (ScrollPaneView) canvasView.getSelectedComponent();
				 HashMap<String, ScrollPaneView> skrolovi = canvasView.getSkrolovi();
				 Color boja = null;
				 
				   if(index==0)
						 boja =(Color.decode("#C8E1E3"));
					else if(index ==1)
						boja= (Color.white);
					else if(index == 2)
						boja= (Color.decode("#F9FFBD"));
					else if(index == 3)
						boja=(Color.decode("#FCB471"));
				 
			for(int i = 0;i<skrolovi.size();i++)
			{
				ScrollPaneView spv = skrolovi.get("Dokument"+i);
				TabComponent tab = (TabComponent) spv.getTab();
				tab.backColor = boja;		
				tab.repaint();
			}
			
			}
		});
		backGrounds.setSize(new Dimension(100,50));
		add(backGrounds);
		
		JLabel labela1 = new JLabel(Localization.getInstance().getString("toolbox.lineColor"));
		Localization.getInstance().registerComponent("toolbox.lineColor", labela1);
		labela1.setSize(new Dimension(400,20));
		labela1.setLocation(new Point(10,270));
		add(labela1);
		

		Object[] items1=
			{
					 new ImageIcon("./backgrounds/blackLine.PNG"),
					 new ImageIcon("./backgrounds/blueLine.PNG"),
					 new ImageIcon("./backgrounds/lightBlueLine.PNG"),
					 new ImageIcon("./backgrounds/redLine.PNG")
			};		
		flows = new JComboBox<Object>(items1);
		flows.setLocation(new Point(10,300));
		flows.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index = flows.getSelectedIndex();
				MainWindow frame=(MainWindow) SwingUtilities.getWindowAncestor(flows);
				CanvasView canvasView=frame.getCanvasView();
				ScrollPaneView panel = (ScrollPaneView) canvasView.getSelectedComponent();
				TabComponent tab = (TabComponent) panel.getTab();

				if(index==0)
					tab.setColor(Color.black);
				else if(index ==1)
					tab.setColor(Color.blue);
				else if(index == 2)
					tab.setColor(Color.decode("#00a3cc"));
				else if(index == 3)
					tab.setColor(Color.red);
				
				tab.repaint();
				tab.NacrtajLine(tab.getGraphics());

			}
		});
		flows.setSize(new Dimension(100,20));
		add(flows);
		
		
	}
	
	public void postaviActivity()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.activity = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/activity.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	
	public void postaviTextElement()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.text = true;
	}
	public void postaviStart()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.start = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/start.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	public void ponisti()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		klasa.activity = false;
		klasa.objectNode = false;
		klasa.decision = false;
		klasa.package1 = false;
		klasa.start = false;
		klasa.end = false;
		klasa.line = false;
		klasa.synchronization = false;
		klasa.delete = false;
		klasa.select = false;
		klasa.cut = false;
		klasa.text = false;
		
		
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}	
	public void postaviGraber()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		klasa.select = true;
		
	}
	public void postaviObjectNode()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.objectNode = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/objectnode.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	public void postaviDecison()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.decision = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/decision.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	public void postaviPackage()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.package1 = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/package.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	public void postaviEnd()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.end = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/end.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	public void postaviLine()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.line = true;
		
	}
	public void postaviSinchronization()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.synchronization = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/sync.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	public void postaviDelete()
	{
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		ponisti();
		klasa.delete = true;
		MainWindow prozor = (MainWindow) this.getTopLevelAncestor();
		CanvasView canvas = prozor.getCanvasView();
		canvas.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./icons/delete.png").getImage(),
				new Point(0,0),"custom cursor"));
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawRoundRect(0, 21, getWidth()-5, getHeight()-23, 30, 30);
		g2d.drawLine(0,63,295, 63);
		g2d.drawLine(0,147,295, 147);
		
	}

}