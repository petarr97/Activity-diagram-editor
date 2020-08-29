package command;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import model.ProjectModel;
import tree.modelTree.ModelTree;
import tree.projectExplorerView.TreeView;
import views.MainWindow;

public class NewProject implements Command {

	ModelTree modelTree;
	TreeView treeView;
	
	public NewProject(ModelTree modelTree, TreeView treeView) {
		this.modelTree=modelTree;
		this.treeView=treeView;
	}
	
	public ModelTree getModelTree() {
		return modelTree;
	}
	public void setModelTree(ModelTree modelTree) {
		this.modelTree = modelTree;
	}
	public TreeView getTreeView() {
		return treeView;
	}
	public void setTreeView(TreeView treeView) {
		this.treeView = treeView;
	}
	@Override
	public void execute() {
	ProjectModel projectModel=new ProjectModel();
	ModelTree.projectModels.add(projectModel);
	projectModel.setNaziv("Project"+ModelTree.projectModels.size());
	DefaultMutableTreeNode node=projectModel.napraviCvor();
	ModelTree.getRootNode().add(node);
	treeView.setfocusedProjectNode(node);

	treeView.update();
	
	
	}
	

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
