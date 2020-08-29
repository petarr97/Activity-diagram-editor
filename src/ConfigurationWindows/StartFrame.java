package ConfigurationWindows;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.text.JTextComponent;

import model.ActivityElement;
import model.StartElement;
import views.ObserverInterface;

public class StartFrame extends JFrame implements ObserverInterface
{
	
	Container c = getContentPane();
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	
	JPanel prviPanel = new JPanel();
	JPanel drugiPanel = new JPanel();
	JPanel treciPanel = new JPanel();
	JPanel cetvrtiPanel = new JPanel();
	JButton ok;
	JButton cancel;
	public JTextField imetxt = new JTextField();
	public JTextField codetxt = new JTextField();
	public JTextField keywordstxt = new JTextField();
	public JTextArea commenttxt = new  JTextArea();
	public JTextArea getCommenttxt() {
		return commenttxt;
	}

	public void setCommenttxt(JTextArea commenttxt) {
		this.commenttxt = commenttxt;
	}

	public JTextField getImetxt() {
		return imetxt;
	}

	public void setImetxt(JTextField imetxt) {
		this.imetxt = imetxt;
	}

	public JTextField getCodetxt() {
		return codetxt;
	}

	public void setCodetxt(JTextField codetxt) {
		this.codetxt = codetxt;
	}

	public JTextField getKeywordstxt() {
		return keywordstxt;
	}

	public void setKeywordstxt(JTextField keywordstxt) {
		this.keywordstxt = keywordstxt;
	}

	public StartFrame(Point tacka, StartElement element)
	{
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Start Properities");
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		c.setLayout(null);
		initTabs();
		initButtons();
		initGeneralTab();
		initDefinitionTab();
		repaint();
	}
	
	public void initTabs()
	{
		tabbedPane.setPreferredSize(new Dimension(800,500));
		tabbedPane.setSize(800,500);
		tabbedPane.setBackground(Color.WHITE);
		prviPanel.setLayout(null);
		prviPanel.setBackground(Color.WHITE);
		drugiPanel.setLayout(null);
		drugiPanel.setBackground(Color.WHITE);
		
		tabbedPane.add("General",prviPanel);
		tabbedPane.add("Definition",drugiPanel);
		
		c.add(tabbedPane);
	}
	
	public void initButtons()
	{
		 ok = new JButton("OK");
		 cancel = new JButton("Cancel");
	
		JPanel btnPanel = new JPanel();
		
		btnPanel.setBounds(0, 510, 800, 100);
	
		btnPanel.add(ok);
		btnPanel.add(cancel);
	
		
		c.add(btnPanel);
		
	}
	
	public void initGeneralTab()
	{
		JLabel imelbl = new JLabel("Name:");
		JLabel codelbl = new JLabel("Code:");
		JLabel commentlbl = new JLabel("Comment:");
		JLabel stereotypelbl = new JLabel("Stereotype:");
		JLabel organizationunitlbl = new JLabel("Organization unit:");
		JLabel keywordslbl = new JLabel("Keywords:");
		
		
		imetxt.setBackground(Color.WHITE);
		JButton imebtn = new JButton("=");
		
		codetxt.setBackground(Color.WHITE);
		JButton codebtn = new JButton("=");
		
		commenttxt.setBackground(Color.WHITE);
		JComboBox stereotypecmb = new JComboBox();
		JComboBox organizationunitcmb = new JComboBox();
		JButton org1btn = new JButton();
		org1btn.setIcon(new ImageIcon("./icons/openDocument.png"));
		JButton org2btn = new JButton();
		org2btn.setIcon(new ImageIcon("./icons/zoomin.png"));
		JButton org3btn = new JButton();
		org3btn.setIcon(new ImageIcon("./icons/line.png"));
		
		keywordstxt.setBackground(Color.WHITE);
		
		imelbl.setLocation(5, 0);
		imelbl.setPreferredSize(new Dimension(105,30));
		imelbl.setSize(105,30);
		imetxt.setLocation(110, 0);
		imetxt.setPreferredSize(new Dimension(600,30));
		imetxt.setSize(600,30);
		imetxt.setBackground(Color.WHITE);
		imebtn.setLocation(710,0);
		imebtn.setPreferredSize(new Dimension(50,25));
		imebtn.setSize(50,25);
		prviPanel.add(imelbl);
		prviPanel.add(imetxt);
		prviPanel.add(imebtn);
		
		codelbl.setLocation(5, 45);
		codelbl.setPreferredSize(new Dimension(105,30));
		codelbl.setSize(105,30);
		codetxt.setLocation(110, 45);
		codetxt.setPreferredSize(new Dimension(600,30));
		codetxt.setSize(600,30);
		codetxt.setBackground(Color.WHITE);
		codebtn.setLocation(710,45);
		codebtn.setPreferredSize(new Dimension(50,25));
		codebtn.setSize(50,25);
		prviPanel.add(codelbl);
		prviPanel.add(codetxt);
		prviPanel.add(codebtn);
		
		commentlbl.setLocation(5, 90);
		commentlbl.setPreferredSize(new Dimension(105,30));
		commentlbl.setSize(105,30);
		commenttxt.setLocation(110, 90);
		commenttxt.setPreferredSize(new Dimension(650,250));
		commenttxt.setSize(650,250);
		commenttxt.setBackground(Color.WHITE);
		prviPanel.add(commentlbl);
		prviPanel.add(commenttxt);
		
		stereotypelbl.setLocation(5, 340);
		stereotypelbl.setPreferredSize(new Dimension(105,30));
		stereotypelbl.setSize(105,30);
		stereotypecmb.setLocation(110, 345);
		stereotypecmb.setBackground(Color.white);
		stereotypecmb.setPreferredSize(new Dimension(650,30));
		stereotypecmb.setSize(650,30);
		prviPanel.add(stereotypelbl);
		prviPanel.add(stereotypecmb);
		
		organizationunitlbl.setLocation(5, 390);
		organizationunitlbl.setPreferredSize(new Dimension(105,30));
		organizationunitlbl.setSize(105,30);
		organizationunitcmb.setLocation(110, 390);
		organizationunitcmb.setBackground(Color.white);
		organizationunitcmb.setPreferredSize(new Dimension(545,30));
		organizationunitcmb.setSize(545,30);
		
		org1btn.setLocation(660,390);
		org1btn.setPreferredSize(new Dimension(30,25));
		org1btn.setSize(30,25);
		
		org2btn.setLocation(695,390);
		org2btn.setPreferredSize(new Dimension(30,25));
		org2btn.setSize(30,25);
		
		org3btn.setLocation(730,390);
		org3btn.setPreferredSize(new Dimension(30,25));
		org3btn.setSize(30,25);
		prviPanel.add(organizationunitlbl);
		prviPanel.add(organizationunitcmb);
		prviPanel.add(org1btn);
		prviPanel.add(org2btn);
		prviPanel.add(org3btn);
		
		
		keywordslbl.setLocation(5, 440);
		keywordslbl.setPreferredSize(new Dimension(105,30));
		keywordslbl.setSize(105,30);
		keywordstxt.setLocation(110, 440);
		keywordstxt.setPreferredSize(new Dimension(650,30));
		keywordstxt.setSize(650,30);
		keywordstxt.setBackground(Color.WHITE);
		prviPanel.add(keywordslbl);
		prviPanel.add(keywordstxt);
		
	}
	public void initDefinitionTab()
	{
		JTabbedPane drugiTabbedPane = new JTabbedPane();
		
		JTextArea descriptiontxt = new JTextArea();
		JTextArea annonationtxt = new JTextArea();
		
		drugiTabbedPane.setPreferredSize(new Dimension(800,470));
		drugiTabbedPane.setSize(800,470);
		drugiTabbedPane.add(treciPanel,"Description");
		drugiTabbedPane.add(cetvrtiPanel,"Annonation");
		
		
		descriptiontxt.setLocation(5, 50);
		descriptiontxt.setPreferredSize(new Dimension(750,450));
		descriptiontxt.setSize(750,450);
		descriptiontxt.setBackground(Color.WHITE);
		treciPanel.add(descriptiontxt);
		
		annonationtxt.setLocation(5, 50);
		annonationtxt.setPreferredSize(new Dimension(750,450));
		annonationtxt.setSize(750,450);
		annonationtxt.setBackground(Color.WHITE);
		cetvrtiPanel.add(annonationtxt);
		
		initDescriptionToolBar();
		initAnnonationToolBar();
		drugiPanel.add(drugiTabbedPane);
	}
	public void initDescriptionToolBar()
	{
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setLocation(5, 5);
		toolBar.setPreferredSize(new Dimension(300,30));
		toolBar.setSize(300,30);
		
		JButton newDocument = new JButton();
		newDocument.setIcon(new ImageIcon("./icons/newDocument.png"));
		newDocument.setBorderPainted(false);
		newDocument.setToolTipText("New Document");
		toolBar.add(newDocument);
		toolBar.addSeparator();
		
		JButton openDocument = new JButton();
		openDocument.setIcon(new ImageIcon("./icons/openDocument.png"));
		openDocument.setBorderPainted(false);
		openDocument.setToolTipText("Open Document");
		toolBar.add(openDocument);
		toolBar.addSeparator();
		
		JButton save = new JButton();
		save.setIcon(new ImageIcon("./icons/save.png"));
		save.setBorderPainted(false);
		save.setToolTipText("Save");
		toolBar.add(save);
		toolBar.addSeparator();
		JButton cut = new JButton();
		cut.setIcon(new ImageIcon("./icons/cut.png"));
		cut.setBorderPainted(false);
		cut.setToolTipText("Cut");
		toolBar.add(cut);
		toolBar.addSeparator();
		
		JButton copy = new JButton();
		copy.setIcon(new ImageIcon("./icons/copy.png"));
		copy.setBorderPainted(false);
		copy.setToolTipText("Copy");
		toolBar.add(copy);
		toolBar.addSeparator();
		
		JButton paste = new JButton();
		paste.setIcon(new ImageIcon("./icons/paste.png"));
		paste.setBorderPainted(false);
		paste.setToolTipText("Paste");
		toolBar.add(paste);
		toolBar.addSeparator();
		
		JButton undo = new JButton();
		undo.setIcon(new ImageIcon("./icons/undo.png"));
		undo.setBorderPainted(false);
		undo.setToolTipText("Undo");
		toolBar.add(undo);
		toolBar.addSeparator();
		
		JButton redo = new JButton();
		redo.setIcon(new ImageIcon("./icons/redo.png"));
		redo.setBorderPainted(false);
		redo.setToolTipText("Redo");
		toolBar.add(redo);
		toolBar.addSeparator();
		
		treciPanel.setLayout(null);
		treciPanel.add(toolBar);
	}
	
	public void initAnnonationToolBar()
	{
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setLocation(5, 5);
		toolBar.setPreferredSize(new Dimension(300,30));
		toolBar.setSize(300,30);
		
		JButton newDocument = new JButton();
		newDocument.setIcon(new ImageIcon("./icons/newDocument.png"));
		newDocument.setBorderPainted(false);
		newDocument.setToolTipText("New Document");
		toolBar.add(newDocument);
		toolBar.addSeparator();
		
		JButton openDocument = new JButton();
		openDocument.setIcon(new ImageIcon("./icons/openDocument.png"));
		openDocument.setBorderPainted(false);
		openDocument.setToolTipText("Open Document");
		toolBar.add(openDocument);
		toolBar.addSeparator();
		
		JButton save = new JButton();
		save.setIcon(new ImageIcon("./icons/save.png"));
		save.setBorderPainted(false);
		save.setToolTipText("Save");
		toolBar.add(save);
		toolBar.addSeparator();
		JButton cut = new JButton();
		cut.setIcon(new ImageIcon("./icons/cut.png"));
		cut.setBorderPainted(false);
		cut.setToolTipText("Cut");
		toolBar.add(cut);
		toolBar.addSeparator();
		
		JButton copy = new JButton();
		copy.setIcon(new ImageIcon("./icons/copy.png"));
		copy.setBorderPainted(false);
		copy.setToolTipText("Copy");
		toolBar.add(copy);
		toolBar.addSeparator();
		
		JButton paste = new JButton();
		paste.setIcon(new ImageIcon("./icons/paste.png"));
		paste.setBorderPainted(false);
		paste.setToolTipText("Paste");
		toolBar.add(paste);
		toolBar.addSeparator();
		
		JButton undo = new JButton();
		undo.setIcon(new ImageIcon("./icons/undo.png"));
		undo.setBorderPainted(false);
		undo.setToolTipText("Undo");
		toolBar.add(undo);
		toolBar.addSeparator();
		
		JButton redo = new JButton();
		redo.setIcon(new ImageIcon("./icons/redo.png"));
		redo.setBorderPainted(false);
		redo.setToolTipText("Redo");
		toolBar.add(redo);
		toolBar.addSeparator();
		
		cetvrtiPanel.setLayout(null);
		cetvrtiPanel.add(toolBar);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerComponents(EventListener listener) {
		ok.setActionCommand("ok");
		ok.addActionListener((ActionListener) listener);
		
		cancel.setActionCommand("cancel");
		cancel.addActionListener((ActionListener) listener);
		
	}

}
