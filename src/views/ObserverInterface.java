package views;

import java.util.EventListener;

/**
 * Interfejs posmatraca
 * @author Milica
 *
 */

public interface ObserverInterface {
	
void	update() ;
void registerComponents(EventListener listener);
	

}
