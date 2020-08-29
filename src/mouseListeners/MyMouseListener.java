package mouseListeners;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.tools.ToolProvider;

import Drawing.TabComponent;
import command.NacrtajElement;
import globalClases.ClipboardClass;
import globalClases.ToolboxGlobalClass;
import model.ActivityElement;
import model.Element;
import model.ModelModel;
import views.MainWindow;
import views.ObserverInterface;
import views.ToolbarView;
import views.ToolboxView;

public class MyMouseListener implements MouseListener,MouseMotionListener {
	TabComponent view;
	ModelModel model;
	public MyMouseListener(ModelModel model2, ObserverInterface observerInterface) {
	
	this.view=(TabComponent) observerInterface;
	this.model=model2;

	}
public void mouseClicked(MouseEvent event) {

	if(SwingUtilities.isMiddleMouseButton(event))
	{
		JFileChooser jfileChoser = new JFileChooser();
	}
} 
public void mouseEntered(MouseEvent event) {}
public void mouseExited(MouseEvent event) {}
public void mousePressed(MouseEvent event) {

	ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
	TabComponent panel = (TabComponent)event.getSource();
	


	
	if (SwingUtilities.isLeftMouseButton(event)) {
	
		(new NacrtajElement(model,view,event.getX(),event.getY())).execute();
	}
	


	else if(klasa.isLine() && SwingUtilities.isLeftMouseButton(event))
	{
		JOptionPane.showMessageDialog(panel.getTopLevelAncestor(),"Morate kliknuti na element","Greska u crtanju linije",JOptionPane.OK_OPTION);
	}
	else if(klasa.isText() && SwingUtilities.isLeftMouseButton(event))
	{
		panel.NacrtajTextPanel(panel, event.getX(), event.getY());
	}
	else if(SwingUtilities.isRightMouseButton(event))
	{
	
		ToolboxView toolBox  = ((MainWindow) panel.getTopLevelAncestor()).getToolboxView();
		toolBox.ponisti();
	}
	else if(SwingUtilities.isLeftMouseButton(event))
		{
	
		ClipboardClass clipBoard = ClipboardClass.getInstance();
		
		for(int i=0;i<clipBoard.selectedElemnts.size();i++)
		{
		panel.selectedElemnts.get(i).setBorder(null);
		panel.selectedElemnts.get(i).repaint();
		panel.repaint();

		}
		panel.selectedElemnts.clear();
		clipBoard.selectedElemnts.clear();
		}
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseMoved(MouseEvent e) {} 
}