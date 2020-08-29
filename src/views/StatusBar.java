/***********************************************************************
 * Module:  StatusBarView.java
 * Author:  Admir Orman
 * Purpose: Defines the Class StatusBarView
 ***********************************************************************/

package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class StatusBar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	

	public StatusBar() {

		setPreferredSize(new Dimension(0,25));
		setLayout(null);
		setBackground(Color.white);
		
		JLabel grafickiEditor = new JLabel("Activity Diagram Editor G2");
		grafickiEditor.setLocation(new Point(10,0));
		grafickiEditor.setSize(new Dimension(200,20));
		add(grafickiEditor);
		
		
		
	}
	
	
	

	
}