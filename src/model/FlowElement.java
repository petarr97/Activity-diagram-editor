package model;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import globalClases.ToolboxGlobalClass;

public class FlowElement extends Line2D.Double {

	public static ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();

	public JPanel startElement;
	public JPanel endElement;
	public Point startPoint;
	public Point endPoint;
	
	public FlowElement(Point x,Point y) {
		super();
		setLine(x,y);
		
	}
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return super.getBounds2D();
	}

	@Override
	public Point2D getP1() {
		// TODO Auto-generated method stub
		return super.getP1();
	}

	@Override
	public Point2D getP2() {
		// TODO Auto-generated method stub
		return super.getP2();
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return super.getX1();
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return super.getX2();
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return super.getY1();
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return super.getY2();
	}

	@Override
	public void setLine(double arg0, double arg1, double arg2, double arg3) {
		super.setLine(arg0, arg1, arg2, arg3);

	}

}

