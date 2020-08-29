package controller;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import Drawing.TabComponent;
import command.CutCommand;
import command.NewDocument;
import command.NewModel;
import command.NewProject;
import command.PasteCommand;
import command.RedoCommand;
import command.UndoCommand;
import globalClases.ClipboardClass;
import model.ActivityElement;
import model.DecisionElement;
import model.EndElement;
import model.ModelModel;
import model.ObjectNodeElement;
import model.PackageElement;
import model.ProjectModel;
import model.StartElement;
import model.SynchronizationElement;
import state.EditingState;
import state.ModelingState;
import state.ProjectEditingState;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.ModelContextMenu;
import tree.projectExplorerView.ProjectContextMenu;
import tree.projectExplorerView.TreeView;
import views.MainWindow;

public class ButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		TreeView treeView;
		 DefaultMutableTreeNode node;
		
		MainWindow mainWindow=new MainWindow();
		if (e.getSource() instanceof JButton) {
			mainWindow=(MainWindow) SwingUtilities.getWindowAncestor(((JComponent)e.getSource()).getParent());
			
		}
		else if (e.getSource() instanceof JMenuItem) {
			
		mainWindow=(MainWindow) SwingUtilities.getWindowAncestor(((JPopupMenu) ((JMenuItem)e.getSource()).getParent()).getInvoker().getParent());
			
		}
	
		switch (e.getActionCommand()) {
	
		case "newProject":
			
			 treeView=(TreeView) mainWindow.getProjectExplorerView().getTree();
			
			  if(ModelTree.getProjectModels().size()==0) 
				  mainWindow.changeState(new ProjectEditingState(mainWindow));
			 
			
			(new NewProject(treeView.getModelTree(), treeView)).execute();
			
		
		
			mainWindow.repaint();
			
			break;
		case "newDocument":
			
			if(mainWindow!=null) {
				 treeView=mainWindow.getProjectExplorerView().getTree();
				  node=treeView.getFocusedModelNode();
			
				  (new NewDocument(node, treeView)).execute();
				
				  }
			
			
		else if (e.getSource() instanceof JMenuItem) {
			
			treeView=(TreeView) ((JPopupMenu)((JMenu)((JPopupMenu)((JMenuItem)e.getSource()).getParent()).getInvoker()).getParent()).getInvoker();
			
			
			node=(((ModelContextMenu)((JMenu)((JPopupMenu)((JMenuItem)e.getSource()).getParent()).getInvoker()).getParent()).getInvokerNode());
			
				mainWindow=(MainWindow) SwingUtilities.getWindowAncestor(treeView);
			
				(new NewDocument(node, treeView)).execute();
			}
			
			break;
		case "newModel":
					if(mainWindow!=null) {
				
				 treeView=mainWindow.getProjectExplorerView().getTree();
			
				  node=treeView.getfocusedProjectNode();
			
				 
				  (new NewModel(node, treeView)).execute();
				//  if(((ProjectModel)treeView.getfocusedProjectNode().getUserObject()).getModeli().size()==0)
				  mainWindow.changeState(new ModelingState(mainWindow));
		
				  }
			
			
		else if (e.getSource() instanceof JMenuItem) {
			treeView=(TreeView) mainWindow.getProjectExplorerView().getTree();
			node=((ProjectContextMenu)((JPopupMenu) ((JMenuItem)e.getSource()).getParent())).getInvokerNode();
	
			
			 (new NewModel(node, treeView)).execute();
			 mainWindow.changeState(new ModelingState(mainWindow));
				mainWindow.getProjectExplorerView().repaint();
			}
			
			
			break;
		
			case "paste":
			
				new PasteCommand((ModelModel) ((DefaultMutableTreeNode)mainWindow.getProjectExplorerView().getTree().getFocusedDocumentNode().getParent()).getUserObject()).execute();
			//(new PasteCommand((ModelModel)mainWindow.getProjectExplorerView().getTree().getFocusedModelNode().getUserObject())).execute();
				
				break;
				case "undo":
					new UndoCommand().execute();
					break;
					
				case "redo":
					
					(new RedoCommand()).execute();
					
					break;
		default:
			break;
		}

	}

}
