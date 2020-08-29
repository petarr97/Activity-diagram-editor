package tree.projectExplorerView;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import command.NacrtajElement;
import model.ModelModel;

/**
 * Kontekstni meni za kolekcije elemenata
 * @author Milica
 *
 */


public class GroupElementContextMenu extends JPopupMenu {
	DefaultMutableTreeNode invokerNode;
	public DefaultMutableTreeNode getInvokerNode() {
		return invokerNode;
	}
	public void setInvokerNode(DefaultMutableTreeNode invokerNode) {
		this.invokerNode = invokerNode;
	}
	public GroupElementContextMenu() {
		JMenuItem newItem=new JMenuItem("New");
		add(newItem);
		newItem.setActionCommand("newElement");
		
	//	newItem.addActionListener(new ActionListener() ;{
			
	//		@Override
//			public void actionPerformed(ActionEvent e) {
//			node=(((ModelContextMenu)((JMenu)((JPopupMenu)((JMenuItem)e.getSource()).getParent()).getInvoker()).getParent()).getInvokerNode());
//			
//			switch (node.getUserObject) {
//				case "Activities":
//					new NacrtajElement(model, tab, x, y)
//					break;
//
//				default:
//					break;
//				}
//				
//			}
//		});
//	}

}}
