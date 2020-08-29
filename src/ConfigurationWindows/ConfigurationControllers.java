package ConfigurationWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.View;

import Drawing.TabComponent;
import command.CommandHistory;
import command.ConfigurationElementCommand;
import model.ActivityElement;
import model.Element;
import model.StartElement;
import tree.projectExplorerView.ModelContextMenu;
import views.ObserverInterface;

public class ConfigurationControllers implements ActionListener {

	ObserverInterface view;
	Element element;
 public	static Element oldElement;
	
	

	public ConfigurationControllers(ObserverInterface view, Element element) {
		 this.view=view;
		 this.element= element;
		
		 view.registerComponents(this);
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
	switch (e.getActionCommand()) {
	case "ok":
		
		(new ConfigurationElementCommand(element, view)).execute();

		element.notifyAllObservers();
		
		((Frame)view).dispose();
		
		
		break;

	case "cancel":
		((Frame)view).dispose();
		break;
	default:
		break;
	}
		
	}

}
