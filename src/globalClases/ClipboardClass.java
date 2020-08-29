package globalClases;

import java.util.ArrayList;

import Drawing.TabComponent;
import model.Element;

public class ClipboardClass {

	ArrayList<Element> element = new ArrayList<Element>();
	public ArrayList<model.Element> selectedElemnts = new ArrayList<model.Element>();


	static ClipboardClass instance = null;
	public static boolean cut = false;
	public static TabComponent tab;
	public static String naziv;
	public static boolean copy = false;
	
	public static boolean isCopy() {
		return copy;
	}

	public static void setCopy(boolean copy) {
		ClipboardClass.copy = copy;
	}

	public static String getNaziv() {
		return naziv;
	}

	public static void setNaziv(String naziv) {
		ClipboardClass.naziv = naziv;
	}

	public TabComponent getTab() {
		return tab;
	}

	public static void setTab(TabComponent tab) {
		ClipboardClass.tab = tab;
	}

	public static boolean isCut() {
		return cut;
	}

	public static void setCut(boolean cut) {
		ClipboardClass.cut = cut;
	}

	public static ClipboardClass getInstance() 
    { 
        if (instance == null) 
            instance = new ClipboardClass(); 
        
        return instance; 
    }

	public ArrayList<Element> getElement() {
		return element;
	}

	public void setElement(ArrayList<Element> element) {
		this.element = element;
	}
	
	

}
