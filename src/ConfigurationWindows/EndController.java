package ConfigurationWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Element;
import model.EndElement;
import model.StartElement;
import views.ObserverInterface;

public class EndController implements ActionListener {
	ObserverInterface view;
	EndElement element;
	 public   EndController(ObserverInterface view, EndElement element) {
		 this.view=view;
		 this.element= element;
		 
		 view.registerComponents(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ok":
			element.naziv = ((EndFrame)view).imetxt.getText();
			element.code = ((EndFrame)view).getCodetxt().getText();
		//element.comment = ((EndFrame)view).getCommenttxt().getText();
		//element.keywords = ((StartFEndFramerame)view).getKeywordstxt().getText();
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
