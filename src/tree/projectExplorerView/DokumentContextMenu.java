package tree.projectExplorerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.ModelModel;
import model.ProjectModel;
import tree.modelTree.ModelTree;
import views.CanvasView;
import views.MainWindow;
import views.ScrollPaneView;

/**
 * Kontekstni meni za dokumente
 * @author Milica
 *
 */

public class DokumentContextMenu extends JPopupMenu {
	DefaultMutableTreeNode invokerNode;
	public DefaultMutableTreeNode getInvokerNode() {
		return invokerNode;
	}
	public void setInvokerNode(DefaultMutableTreeNode invokerNode) {
		this.invokerNode = invokerNode;
	}
	public DokumentContextMenu() {

	}
}
