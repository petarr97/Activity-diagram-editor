package command;

import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.ModelModel;
import model.ProjectModel;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;

public class NewDocument implements Command {

	DefaultMutableTreeNode node;
	TreeView tree;
	
	
	
	public NewDocument(DefaultMutableTreeNode node, TreeView tree) {
		super();
		this.node = node;
		this.tree = tree;
	}

	public DefaultMutableTreeNode getModel() {
		return node;
	}

	public void setModel(DefaultMutableTreeNode model) {
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
Dokument dokument=new Dokument();
		
		ModelModel model=(ModelModel) this.node.getUserObject();

		
		model.getDokumenti().add(dokument);
		dokument.setNaziv("Dokument"+ Dokument.brojDokumenata++ );
		model.getRootNode().add(dokument.napraviCvor());
		
	
	tree.update();
		
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
