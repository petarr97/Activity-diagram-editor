package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class ViewToolBar  extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton zoomin;
	JButton zoomout;
	JButton scale;
	
	public JButton getZoomin() {
		return zoomin;
	}

	public void setZoomin(JButton zoomin) {
		this.zoomin = zoomin;
	}

	public JButton getZoomout() {
		return zoomout;
	}

	public void setZoomout(JButton zoomout) {
		this.zoomout = zoomout;
	}

	public JButton getScale() {
		return scale;
	}

	public void setScale(JButton scale) {
		this.scale = scale;
	}

	public ViewToolBar()
	{
		setFloatable(false);
		setBackground(Color.decode("#E9FDFF"));
		
	
		
	}
	
	
}
