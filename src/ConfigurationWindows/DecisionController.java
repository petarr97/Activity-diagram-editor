package ConfigurationWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DecisionElement;
import model.SynchronizationElement;
import views.ObserverInterface;

public class DecisionController implements ActionListener {
	ObserverInterface view;
	DecisionElement element;
	 public     DecisionController(ObserverInterface view, DecisionElement element) {
		 this.view=view;
		 this.element= element;
		 
		 view.registerComponents(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ok":
			element.naziv = ((DecisionFrame)view).imetxt.getText();
			element.code = ((DecisionFrame)view).codetxt.getText();
		element.comment = ((DecisionFrame)view).commenttxt.getText();
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
