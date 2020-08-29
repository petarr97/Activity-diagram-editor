package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import ConfigurationWindows.TextConfig;
import Drawing.DragLineClass;
import Drawing.TabComponent;
import globalClases.ToolboxGlobalClass;
import mouseListeners.PanelMouseListener;

public class TextElement extends Element {
	
	public static int pozicija;
	public static Point tacka;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();
	public String naziv = "defaultText";
	
	public TextElement(Point lokacija,Dimension dimenzije) {
		setLayout(null);
		setSize(dimenzije);
		setLocation((int)(lokacija.getX()-dimenzije.getWidth()/2),(int)(lokacija.getY()-dimenzije.getHeight()/2));
		setOpaque(false);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2)
				{
					TextConfig frame = new TextConfig(naziv,(TextElement) arg0.getSource());
					frame.show();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d  = (Graphics2D) g;
		
		FontMetrics fm = getFontMetrics(getFont());
		int width = fm.stringWidth(naziv);
		
		setSize(new Dimension(width+30,10));
		g2d.drawString("<<"+naziv+">>", 1, 10);
	}
}
