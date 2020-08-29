package tree.controlerTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Vector;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import Drawing.TabComponent;
import model.Dokument;
import model.Element;
import model.ModelModel;
import model.ProjectModel;
import state.EditingState;
import tree.projectExplorerView.DokumentContextMenu;
import tree.projectExplorerView.ElementContextMenu;
import tree.projectExplorerView.GroupElementContextMenu;
import tree.projectExplorerView.ModelContextMenu;
import tree.projectExplorerView.ProjectContextMenu;
import tree.projectExplorerView.TreeView;
import views.CanvasView;
import views.MainWindow;
import views.ScrollPaneView;
/**
 * Implementirani MouseListener za stablo pretrazivaca projekata
 * @author Milica
 *
 */
public class CustomTreeMouseListener implements MouseListener {
	
	
	
	ProjectContextMenu projectContextMenu=new ProjectContextMenu();
	ModelContextMenu modelContextMenu= new ModelContextMenu();
	 GroupElementContextMenu groupElementCntextMenu=new GroupElementContextMenu();
	 DokumentContextMenu dokumentContextMenu=new DokumentContextMenu();
	 ElementContextMenu elementContextMenu=new ElementContextMenu();
	
	@Override
	public void mouseClicked(MouseEvent e) {
		 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		TreeView  tree=(TreeView) e.getSource();
		  
		TreePath  treePath=tree.getPathForLocation(e.getX(), e.getY());
		  if(treePath!=null) {
			  DefaultMutableTreeNode node=(DefaultMutableTreeNode)treePath.getLastPathComponent();
			  
			  MainWindow frame=(MainWindow) SwingUtilities.getWindowAncestor(tree);
			  CanvasView canvasView=frame.getCanvasView();
		  
	if(SwingUtilities.isRightMouseButton(e)) {
	
		  if((node.getUserObject()) instanceof ProjectModel) {
		
			  projectContextMenu.show(tree, e.getX(), e.getY());
			
			  projectContextMenu.setInvokerNode(node);
		  }
		  
		else if (node.getUserObject() instanceof ModelModel) {
			modelContextMenu.show(tree, e.getX(), e.getY());
			modelContextMenu.setInvokerNode(node);
			
		}
			else if (node.getUserObject() instanceof Dokument ) {
			dokumentContextMenu.show(tree, e.getX(), e.getY());
			dokumentContextMenu.setInvokerNode(node);
				
			}
			
			else  if(node.getUserObject() instanceof String && node.getUserObject()!="Workspace")
			{
			groupElementCntextMenu.show(tree, e.getX(), e.getY());
			
		}
		  
		
//		else  if(node.getUserObject() instanceof String)
//		{
//		groupElementCntextMenu.show(tree, e.getX(), e.getY());
//		
//		}
		  
			}
	else if (SwingUtilities.isLeftMouseButton(e) && node.getUserObject() instanceof Dokument) {
		  if (e.getClickCount()==2) {
			  TabComponent tab=new TabComponent(node.getUserObject().toString(),(ModelModel) ((DefaultMutableTreeNode)node.getParent()).getUserObject());
			  ScrollPaneView jScrollPane=new ScrollPaneView(tab);

			  Boolean contains=false;
			  int index=0;
			  for (int i = 0; i < canvasView.getSkrolovi().size(); i++) {
				if (canvasView.getSkrolovi().containsKey(tab.getNaziv())) {
					contains=true;
					index=i;

					 canvasView.setSelectedComponent(canvasView.getSkrolovi().get(tab.getNaziv()));
					 tree.setFocusedDocumentNode(node);
					  frame.changeState(new EditingState(frame));
					break;
				}}
			
			  if (!contains) {

				canvasView.addTab(node.getUserObject().toString(), jScrollPane);
				canvasView.getSkrolovi().put(tab.getNaziv(), jScrollPane);		
			//	tree.setFocusedDocumentNode(node);
				tab.setDokument((Dokument) node.getUserObject());
				canvasView.setSelectedComponent(jScrollPane);
				tree.setFocusedDocumentNode(node);
				  frame.changeState(new EditingState(frame));
				canvasView.repaint();
				
			}
			
		}
		  

		  }
	else if (SwingUtilities.isLeftMouseButton(e) && node.getUserObject() instanceof ProjectModel) {
		 if (e.getClickCount()==1) {
			 tree.setfocusedProjectNode(node);
		 }
		 }
	else if (SwingUtilities.isLeftMouseButton(e) && node.getUserObject() instanceof ModelModel) {
		 if (e.getClickCount()==1) {
			 tree.setFocusedModelNode(node);
		 }
		 }
	}
	}
	  
	
	
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
