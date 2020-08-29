package tree.projectExplorerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import command.NacrtajElement;
import controller.ButtonActionListener;

/**
 * Kontekstni meni za modele
 * @author Milica
 *
 */


public class ModelContextMenu extends JPopupMenu {
	@SuppressWarnings("deprecation")
	DefaultMutableTreeNode invokerNode;
	public DefaultMutableTreeNode getInvokerNode() {
		return invokerNode;
	}
	public void setInvokerNode(DefaultMutableTreeNode invokerNode) {
		this.invokerNode = invokerNode;
	}
	public ModelContextMenu() {

	
		JMenu newItem=new JMenu("New");
		JMenuItem newDocumentItem=new JMenuItem("Document");
		newDocumentItem.setActionCommand("newDocument");
		newDocumentItem.addActionListener(new ButtonActionListener());
		JMenuItem newactionItem=new JMenuItem("Action");
		JMenuItem newDecisionItem=new JMenuItem("Decision");
		JMenuItem newStartItem=new JMenuItem("Start");
		JMenuItem newEndItem=new JMenuItem("End");
		JMenuItem newFlowItem=new JMenuItem("Flow");
		
		newItem.add(newDocumentItem);
		newItem.add(newactionItem);
		newItem.add(newDecisionItem);
		newItem.add(newStartItem);
		newItem.add(newEndItem);
		newItem.add(newFlowItem);
		
		this.add(newItem);
		
		
			
	
	}

}
