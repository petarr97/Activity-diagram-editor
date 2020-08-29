package ConfigurationWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.SecretKeyFactorySpi;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.TextElement;

public class TextConfig extends JFrame {

	public String Text;
	public JPanel configPanel;
	public JTextArea textArea;
	public JButton okButton;
	public JButton cancelButton;
	public TextElement textElement;
	
	public TextConfig(String naziv,TextElement text) {
		
		System.out.println("aaaa");
		setLayout(null);
		setSize(new Dimension(200,130));
		setVisible(true);
		textElement = text;
		Text= naziv;
		
		configPanel = new JPanel();
		configPanel.setLayout(null);
		configPanel.setSize(new Dimension(200,130));
		configPanel.setBackground(Color.white);
		configPanel.setLocation(0,0);
		
		textArea = new JTextArea();
		textArea.setText(Text);
		textArea.setBackground(Color.white);
		textArea.setSize(new Dimension(200,70));
		textArea.setLocation(0,0);
		textArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		setResizable(false);
		
		okButton = new JButton("OK");
		okButton.setSize(new Dimension(50,28));
		okButton.setFont(new Font("Calibri",Font.BOLD,12));
		okButton.setLocation(40,74);
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textElement.naziv =  textArea.getText();
				textElement.repaint();
				dispose();
			}
		});
		okButton.setBackground(Color.white);
		okButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		
		
		
		
		configPanel.add(textArea);
		configPanel.add(okButton);
		add(configPanel);
		repaint();

	}
}
