package command;

import javax.swing.tree.DefaultMutableTreeNode;

import model.ModelModel;
import model.ProjectModel;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;

public class NewModel implements Command {

	DefaultMutableTreeNode node;
	TreeView tree;
	public NewModel(DefaultMutableTreeNode model, TreeView tree) {
		super();
		this.node = model;
		this.tree = tree;
	}

	public DefaultMutableTreeNode getNode() {
		return node;
	}

	public void setNde(DefaultMutableTreeNode model) {
		this.node = model;
	}

	public TreeView getTree() {
		return tree;
	}

	public void setTree(TreeView tree) {
		this.tree = tree;
	}

	@Override
	public void execute() {
		ModelModel modelModel=new ModelModel();
		
		ProjectModel model=(ProjectModel) this.node.getUserObject();
		
		model.getModeli().add(modelModel);
		modelModel.setNaziv("Model"+ ModelModel.brojModela++);
		DefaultMutableTreeNode modelNode=modelModel.napraviCvor();
		tree.setFocusedModelNode(modelNode);
		node.add(modelNode);
		
	
	
	tree.update();

	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
