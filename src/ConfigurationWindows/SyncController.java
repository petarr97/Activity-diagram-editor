package ConfigurationWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ObjectNodeElement;
import model.SynchronizationElement;
import views.ObserverInterface;

public class SyncController implements ActionListener {
	ObserverInterface view;
	SynchronizationElement element;
	 public     SyncController(ObserverInterface view, SynchronizationElement element) {
		 this.view=view;
		 this.element= element;
		 
		 view.registerComponents(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ok":
			element.naziv = ((SyncFrame)view).getImetxt().getText();
			element.code = ((SyncFrame)view).getCodetxt().getText();
		element.comment = ((SyncFrame)view).getCommenttxt().getText();
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
