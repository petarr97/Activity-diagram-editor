package mouseListeners;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import Drawing.DragLineClass;
import Drawing.TabComponent;
import command.CopyCommand;
import command.CutCommand;
import command.RemoveCommand;
import globalClases.ClipboardClass;
import globalClases.ToolboxGlobalClass;
import model.ActivityElement;
import model.DecisionElement;
import model.Element;
import model.EndElement;
import model.ModelModel;
import model.ObjectNodeElement;
import model.PackageElement;
import model.StartElement;
import model.SynchronizationElement;
import tree.projectExplorerView.TreeView;
import views.MainWindow;

public class PanelMouseListener implements MouseListener,MouseMotionListener,MouseWheelListener {
	
	public static int brojac= 0;
	public static boolean delete = false;
	public static ArrayList<DragLineClass> lista = new ArrayList<DragLineClass>();


	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		ToolboxGlobalClass klasa = ToolboxGlobalClass.getInstance();
		Element clickedPanel = (Element) e.getSource();
		TabComponent tab = (TabComponent) clickedPanel.getParent();
		
		ClipboardClass pomocna = ClipboardClass.getInstance();			
		if(klasa.isDelete()) {
			new RemoveCommand((ModelModel) ((DefaultMutableTreeNode)clickedPanel.getNode().getParent().getParent()).getUserObject(), tab, clickedPanel).execute();
		}
		if(klasa.cut) {
			new CutCommand(clickedPanel,(ModelModel) ((DefaultMutableTreeNode)clickedPanel.getNode().getParent().getParent()).getUserObject()).execute();
		
		}
		else if(klasa.isSelect()) {
			if(e.isControlDown() && SwingUtilities.isLeftMouseButton(e))
			{	
			pomocna.selectedElemnts.add(clickedPanel);
			tab.selectedElemnts.add(clickedPanel);
			clickedPanel.setBorder(BorderFactory.createDashedBorder(null,2,2,2,false));
			pomocna.getElement().add(clickedPanel);
			}
			else if(!e.isControlDown() && SwingUtilities.isLeftMouseButton(e))
			{
				for(int i=0;i<pomocna.selectedElemnts.size();i++)
					{
					pomocna.selectedElemnts.get(i).setBorder(null);
					tab.repaint();
					}
				
				pomocna.selectedElemnts.clear();
				tab.selectedElemnts.clear();
				pomocna.selectedElemnts.add(clickedPanel);
				tab.selectedElemnts.add(clickedPanel);
				clickedPanel.setBorder(BorderFactory.createDashedBorder(null,2,2,2,false));
				pomocna.getElement().clear();
				pomocna.getElement().add(clickedPanel);
			}
			pomocna.setTab((TabComponent) clickedPanel.getParent());

			
		}
		
		Boolean ctrl=e.isControlDown();
		if (klasa.isCopy() ) {
			new CopyCommand(clickedPanel, ctrl).execute();
		}
	
		
		if(klasa.isLine()) {
		
		 if(tab.getFlows().size()%2 == 0)
		{
			tab.addFlow(new Point((int)clickedPanel.getLocation().getX()+clickedPanel.getWidth()/2,(int)clickedPanel.getLocation().getY()+clickedPanel.getHeight()-10));	
		}
		else
		{
			tab.addFlow(new Point((int)clickedPanel.getLocation().getX()+clickedPanel.getWidth()/2,(int)clickedPanel.getLocation().getY()+10));
			tab.repaint();
		}
	}
}
	

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}


}
