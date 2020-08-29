package tree.projectExplorerView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import tree.controlerTree.CustomTreeMouseListener;
import tree.controlerTree.TreeControler;
import tree.modelTree.ModelTree;
import views.ObserverInterface;

/**
 * Panel za pretrazivac projekata
 * @author Milica
 *
 */

public class ProjectExplorerView extends JPanel  {
	
	TreeView tree; 
	ModelTree modelTree;
	
	public TreeView getTree() {
		return tree;
	}

	public void setTree(TreeView tree) {
		this.tree = tree;
	}

	public ModelTree getModelTree() {
		return modelTree;
	}

	public void setModelTree(ModelTree modelTree) {
		this.modelTree = modelTree;
	}

	public ProjectExplorerView(TreeView tree, ModelTree modelTree) {
		
		
		this.modelTree=modelTree;
		this.tree=tree;
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(250	, 0));
		
		Border border=BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(240, 240, 240));
		setBorder(border);
		
		
		JScrollPane scrollPane=new JScrollPane(tree);
		this.add(scrollPane);
		
		TreeControler controler=new TreeControler(modelTree, tree);
		
	}
	





	
}