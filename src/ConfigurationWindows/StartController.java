package ConfigurationWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Element;
import model.StartElement;
import views.ObserverInterface;

public class StartController implements ActionListener {


	ObserverInterface view;
	Element element;
	 public  StartController(ObserverInterface view, StartElement element) {
		 this.view=view;
		 this.element= element;
		 
		 view.registerComponents(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ok":
			((StartElement)element).naziv = ((StartFrame)view).imetxt.getText();
			((StartElement)element).code = ((StartFrame)view).getCodetxt().getText();
		((StartElement)element).comment = ((StartFrame)view).getCommenttxt().getText();
		((StartElement)element).keywords = ((StartFrame)view).getKeywordstxt().getText();
//			
			element.notifyAllObservers();
			System.out.println(element.getInterfaces());
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
