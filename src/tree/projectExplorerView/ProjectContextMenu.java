package tree.projectExplorerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;


import controller.ButtonActionListener;
import model.ProjectModel;
import tree.modelTree.ModelTree;

/**
 * Kontkstni meni projektata
 * @author Milica
 *
 */

public class ProjectContextMenu extends JPopupMenu {
	DefaultMutableTreeNode invokerNode;
	public DefaultMutableTreeNode getInvokerNode() {
		return invokerNode;
	}
	public void setInvokerNode(DefaultMutableTreeNode invokerNode) {
		this.invokerNode = invokerNode;
	}
	@SuppressWarnings("deprecation")
	public ProjectContextMenu() {
		
		JMenuItem saveItem=new JMenuItem("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK));
		add(saveItem);
		
		JMenuItem saveAsItem=new JMenuItem("Save As New Project...");
		add(saveAsItem);
		
		addSeparator(); 
		
		JMenuItem detachItem=new JMenuItem("Detach from Workspace");
		detachItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = getInvokerNode();
				node.removeFromParent();
				ProjectContextMenu pCm = (ProjectContextMenu) ((JMenuItem)e.getSource()).getParent();
				TreeView object = (TreeView) pCm.getInvoker();
				object.update();
			}
		});
		this.add(detachItem);
		
		addSeparator();
		
		
		JMenuItem newModelItem=new JMenuItem("New model");
		this.add(newModelItem);
		newModelItem.setActionCommand("newModel");
		newModelItem.addActionListener(new ButtonActionListener());
	
		
		addSeparator();
		
		
		JMenuItem renameItem=new JMenuItem("Rename");
		renameItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProjectContextMenu pCm = (ProjectContextMenu) ((JMenuItem)e.getSource()).getParent();
				TreeView object = (TreeView) pCm.getInvoker();
				ModelTree modelTree = object.getModelTree();
				ArrayList<ProjectModel> projectModels = modelTree.getProjectModels();
				
				String novo_ime= JOptionPane.showInputDialog("Unesite novo ime projekta: ");
				boolean postoji = false;
				for(int i = 0 ;i < projectModels.size();i++)
				{	
					if(novo_ime.equals(projectModels.get(i).getNaziv()))
						postoji = true;			
					
				}
				
				if(postoji==false)
				{for(int i = 0 ;i < projectModels.size();i++)
				{
				
					if(projectModels.get(i).getNaziv() == getInvokerNode().toString())
						projectModels.get(i).setNaziv(novo_ime);
			}
			}
				else JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(pCm), "Postoji projekat pod tim imenom");
			}
			}
		);
		this.add(renameItem);
		
		
		
		this.show();
	}

}
