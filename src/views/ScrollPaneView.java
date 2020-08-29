package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollPaneView extends JScrollPane {

	JPanel tab = null;
	public ScrollPaneView(JPanel panel) {
		
		
			super(panel);
			this.tab = panel;
			super.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        super.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        super.setBounds(0, 0, 1050	, 730);
	        
	}
	public JPanel getTab() {
		return tab;
	}
	public void setTab(JPanel tab) {
		this.tab = tab;
	}
}
