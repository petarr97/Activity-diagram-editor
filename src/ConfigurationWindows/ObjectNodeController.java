package ConfigurationWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EndElement;
import model.ObjectNodeElement;
import views.ObserverInterface;

public class ObjectNodeController implements ActionListener {
	ObserverInterface view;
	ObjectNodeElement element;
	 public    ObjectNodeController(ObserverInterface view, ObjectNodeElement element) {
		 this.view=view;
		 this.element= element;
		 
		 view.registerComponents(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ok":
			element.naziv = ((ObjectNodeFrame)view).imetxt.getText();
			element.code = ((ObjectNodeFrame)view).getCodetxt().getText();
		element.comment = ((ObjectNodeFrame)view).getCommenttxt().getText();
		//element.keywords = ((ObjectNodeFrame)view).getKeywordstxt().getText();
//			
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
