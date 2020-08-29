package tree.projectExplorerView;

import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import tree.modelTree.ModelTree;
import views.ObserverInterface;

/**
 * Stablo pretrazivaca projekata
 * @author Milica
 *
 */

public class TreeView extends JTree implements ObserverInterface {

	DefaultMutableTreeNode focusedProjectNode;
	ModelTree modelTree;
	DefaultMutableTreeNode focusedModelNode;
	DefaultMutableTreeNode focusedDocumentNode;
	
	public DefaultMutableTreeNode getFocusedProjectNode() {
		return focusedProjectNode;
	}
	public void setFocusedProjectNode(DefaultMutableTreeNode focusedProjectNode) {
		this.focusedProjectNode = focusedProjectNode;
	}
	public DefaultMutableTreeNode getFocusedDocumentNode() {
		return focusedDocumentNode;
	}
	public void setFocusedDocumentNode(DefaultMutableTreeNode focusedDocumentNode) {
		this.focusedDocumentNode = focusedDocumentNode;
	}
	public DefaultMutableTreeNode getFocusedModelNode() {
		return focusedModelNode;
	}
	public void setFocusedModelNode(DefaultMutableTreeNode focusedModelNode) {
		this.focusedModelNode = focusedModelNode;
	}
	public DefaultMutableTreeNode getfocusedProjectNode() {
		return focusedProjectNode;
	}
	public void setfocusedProjectNode(DefaultMutableTreeNode focusedNode) {
		this.focusedProjectNode = focusedNode;
	}
	public ModelTree getModelTree() {
		return modelTree;
	}
	public void setModelTree(ModelTree modelTree) {
		this.modelTree = modelTree;
	}
	public TreeView(ModelTree model) {
		super();
	this.setModel(model);
	this.modelTree=model;
	
	this.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
	
	this.setEditable(true);
	
	this.setCellRenderer(new MyCellRenderer());
	this.setCellEditor(new MyTreeCellEditor());
	
	}
	@Override
	public void update() {
		
		this.setModel(new ModelTree());
		for (int i = 0; i < this.getRowCount(); i++) {
		    this.expandRow(i);
		}
		
	}

	@Override
	public void registerComponents(EventListener listener) {
		this.addMouseListener((MouseListener) listener);
		
		
		
	}

}
