package tree.projectExplorerView;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;

public class MyTreeCellEditor implements TreeCellEditor {


	private Object value="";
	private JTextField textField=null;
	
	private CellEditorListener listener=null;
	private boolean leaf;
	
	@Override
	public Object getCellEditorValue() {
		return this.value;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		if(anEvent instanceof MouseEvent && SwingUtilities.isLeftMouseButton((MouseEvent) anEvent))
		{
			MouseEvent mouseEvent=(MouseEvent)anEvent;
			JTree jTree=(JTree) mouseEvent.getSource();
			//DefaultMutableTreeNode  node=(DefaultMutableTreeNode) jTree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY()).getLastPathComponent();
			if( mouseEvent.getClickCount()>2)
				return true;
		}
		return false;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		if(anEvent instanceof MouseEvent && SwingUtilities.isLeftMouseButton((MouseEvent) anEvent))
		{
			MouseEvent mouseEvent= (MouseEvent) anEvent;
			if(mouseEvent.getClickCount()==1)
				return true; 
		}
	return false;
	}

	@Override
	public boolean stopCellEditing() {
		this.value=textField.getText();
		return true;
	}

	@Override
	public void cancelCellEditing() {
		textField.setText(value.toString());

	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		listener= l;

	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		this.listener=null;

	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		this.value=value;
		this.leaf=leaf;
	//	if(leaf)
		{
			textField=new JTextField();
			textField.setText(value.toString());
			textField.addActionListener(new ActionListener() {
				
				

				@Override
				public void actionPerformed(ActionEvent e) {
					if(stopCellEditing())
						listener.editingCanceled(new ChangeEvent(e.getSource()));
					
				}
			});
			
		}
		return textField;
	
	}

}
