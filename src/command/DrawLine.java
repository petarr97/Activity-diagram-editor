package command;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import Drawing.TabComponent;
import globalClases.ToolboxGlobalClass;

public class DrawLine implements Command {

	TabComponent tabComponent;
	Graphics2D g2d;
	public DrawLine(TabComponent tab,Graphics g) {
		tabComponent=tab;
		g2d = (Graphics2D)g;
	}
	@Override
	public void execute() {
		 ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		 
		 float[] dash1 = { 2f, 0f, 2f };
		 BasicStroke bs1 = new BasicStroke(2, 
		        BasicStroke.CAP_BUTT, 
		        BasicStroke.JOIN_ROUND, 
		        1.0f, 
		        dash1,
		        2f);
		 
		 g2d.setStroke(new BasicStroke(2)); 
		
		

		 int broj_linija = tabComponent.getFlows().size();
		 g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		 g2d.setColor(TabComponent.color);

		 //g2d.setColor(Color.decode("#00a3cc"));
 
		 if(broj_linija%2==0)
		 {
		 for(int i = 0;i<broj_linija;i+=2)
		 {
			 int x1=(int)tabComponent.getFlows().get(i).getX();
			 int x2=(int)tabComponent.getFlows().get(i+1).getX();
			 int y1=(int)tabComponent.getFlows().get(i).getY();
			 int y2=(int)tabComponent.getFlows().get(i+1).getY();
	
			 if(y1<y2)
			 {
				 int xPoly[] = {x2,x2+7,x2-7};
				 int yPoly[] = {y2,y2-20,y2-20};
				 if(y2-y1>40)
				 {
				 g2d.drawLine(x1,y1,x1,y1+20);
				 g2d.drawLine(x1,y1+20,x2,y1+20);
				 g2d.drawLine(x2,y1+20,x2,y2-20);
				 g2d.drawLine(x2,y2-20,x2,y2);
				 }
				 else {

					 g2d.drawLine(x1,y1-40,x1,y1-60);
					 g2d.drawLine(x1,y1-60,x2,y1-60);
					 g2d.drawLine(x2,y1-60,x2,y2-20);
					 g2d.drawLine(x2,y2-20,x2,y2);
				 }
				 
				 g2d.fillPolygon(new Polygon(xPoly,yPoly,xPoly.length));
			 }
			 else {
				 y1= y1-40;
				 y2 = y2+40;
				 int xPoly[] = {x2,x2+7,x2-7};
			     int yPoly[] = {y2,y2+20,y2+20};
			     
			     if(y1-y2>40)
			     {

			     g2d.drawLine(x1,y1,x1,y2+40);
				 g2d.drawLine(x1,y2+40,x2,y2+40);
				 g2d.drawLine(x2,y2+40,x2,y2);
			     }
			     else {

			    	 g2d.drawLine(x1,y1+40,x1,y1+120);
					 g2d.drawLine(x1,y1+120,x2,y1+120);
					 g2d.drawLine(x2,y1+120,x2,y2);
			     }
			     g2d.fillPolygon(new Polygon(xPoly,yPoly,xPoly.length));
			 }
		     
		 }
		 }
		 else
			 {
			 tabComponent. getFlows().remove(tabComponent.getFlows().size()-1);
			 }
		
		 
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
