
package model;

import javax.swing.tree.DefaultMutableTreeNode;

public class Dokument implements Cvor {
 // public java.util.Collection<Element> elementi;
   private String naziv;
   transient DefaultMutableTreeNode node;
  public static int brojDokumenata;
   
   public DefaultMutableTreeNode getNode() {
	return node;
}

public void setNode(DefaultMutableTreeNode node) {
	this.node = node;
}


public Dokument() {
	
}
	/*
	 * public java.util.Collection<Element> getElementi() { return elementi; }
	 * public void setElementi(java.util.Collection<Element> elementi) {
	 * this.elementi = elementi; }
	 */

   @Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNaziv();
	}
public String getNaziv() {
	return naziv;
}
public void setNaziv(String naziv) {
	this.naziv = naziv;
}
@Override
public DefaultMutableTreeNode napraviCvor() {
	node=new DefaultMutableTreeNode(this);
	return node;
}

   
 

}