package tree.projectExplorerView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import model.ActivityElement;
import model.DecisionElement;
import model.Dokument;
import model.EndElement;
import model.ModelModel;
import model.ObjectNodeElement;
import model.PackageElement;
import model.ProjectModel;
import model.StartElement;
import model.SynchronizationElement;

public class MyCellRenderer extends DefaultTreeCellRenderer implements TreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		setOpaque(true);
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		
		DefaultMutableTreeNode node=(DefaultMutableTreeNode) value;
		
		if(node.getUserObject() instanceof ProjectModel)
		{
			Image image=new ImageIcon("icons/icons8-storage-box-48.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		else if (node.getUserObject() instanceof ModelModel) {
			Image image=new ImageIcon("icons/diagram.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		else if (node.getUserObject() instanceof Dokument) {
			Image image=new ImageIcon("icons/flowchart.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
			
		}
		else if (node.getUserObject()=="Workspace") {
			Image image=new ImageIcon("icons/juventus.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
			
		}
		else if (node.getUserObject() instanceof ActivityElement) {
			Image image=new ImageIcon("icons/activity.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		
		else if (node.getUserObject() instanceof DecisionElement) {
			Image image=new ImageIcon("icons/decision.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		
		else if (node.getUserObject() instanceof StartElement) {
			Image image=new ImageIcon("icons/start.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		
		else if (node.getUserObject() instanceof EndElement) {
			Image image=new ImageIcon("icons/end.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		
		else if (node.getUserObject() instanceof SynchronizationElement) {
			Image image=new ImageIcon("icons/sync.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		
		else if (node.getUserObject() instanceof ObjectNodeElement) {
			Image image=new ImageIcon("icons/objectnode1.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		else if (node.getUserObject() instanceof PackageElement) {
			Image image=new ImageIcon("icons/package1.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		else {
			Image image=new ImageIcon("icons/folder.png").getImage();
			setIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		}
		
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		
		if(selected==true)
		{
			this.setBackground(Color.LIGHT_GRAY);
			this.setForeground(Color.WHITE);
		}
		
		return this;
	}

}
