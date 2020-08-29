package Drawing;

import java.awt.Point;

public class DragLineClass {

	public int pozicija;
	public boolean gornji;
	public boolean donji;
	public Point tacka;
	
	public DragLineClass(int pozicija,boolean gornji,boolean donji,Point tacka) {
		this.pozicija = pozicija;
		this.gornji = gornji;
		this.donji = donji;
		this.tacka = tacka;
	}
	
	public int getPozicija() {
		return pozicija;
	}
	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}
	public boolean isGornji() {
		return gornji;
	}
	public void setGornji(boolean gornji) {
		this.gornji = gornji;
	}
	public boolean isDonji() {
		return donji;
	}
	public void setDonji(boolean donji) {
		this.donji = donji;
	}
	public Point getTacka() {
		return tacka;
	}
	public void setTacka(Point tacka) {
		this.tacka = tacka;
	}
	
	
}
