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

import model.SynchronizationElement;
import views.ObserverInterface;

public class SyncFrame extends JFrame implements ObserverInterface{
	Container c = getContentPane();
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel prviPanel = new JPanel();
	JPanel drugiPanel = new JPanel();
	JPanel treciPanel = new JPanel();
	JPanel cetvrtiPanel = new JPanel();
	
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	
	JTextField imetxt = new JTextField();
	JButton imebtn = new JButton("=");
	JTextField codetxt = new JTextField();
	JButton codebtn = new JButton("=");
	JTextArea commenttxt = new  JTextArea();
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


	public JTextArea getCommenttxt() {
		return commenttxt;
	}


	public void setCommenttxt(JTextArea commenttxt) {
		this.commenttxt = commenttxt;
	}


	public SyncFrame(Point point, SynchronizationElement synchronizationElement) {
	//	setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Synchronization Properities");
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
		
		
		prviPanel.setLayout(null);
		
		drugiPanel.setLayout(null);
		
		tabbedPane.add("General",prviPanel);
		tabbedPane.add("Definition",drugiPanel);
		
		c.add(tabbedPane);
	}
	
	public void initButtons()
	{
	

	
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
		JLabel timeoutlbl = new JLabel("Timeout:");
		JLabel typelbl = new JLabel("Type:");
		JLabel keywordslbl = new JLabel("Keywords:");
		
		JTextField imetxt = new JTextField();
		JButton imebtn = new JButton("=");
		JTextField codetxt = new JTextField();
		JButton codebtn = new JButton("=");
		JTextArea commenttxt = new  JTextArea();
		JComboBox stereotypecmb = new JComboBox();
		JTextField timeouttxt = new JTextField();
		JLabel incompletelbl = new JLabel("Incomplete");
		JTextField keywordstxt = new JTextField();
		
		imelbl.setLocation(5, 0);
		imelbl.setPreferredSize(new Dimension(100,30));
		imelbl.setSize(100,30);
		imetxt.setLocation(105, 0);
		imetxt.setPreferredSize(new Dimension(600,30));
		imetxt.setSize(600,30);
		imebtn.setLocation(705,0);
		imebtn.setPreferredSize(new Dimension(50,25));
		imebtn.setSize(50,25);
		prviPanel.add(imelbl);
		prviPanel.add(imetxt);
		prviPanel.add(imebtn);
		
		codelbl.setLocation(5, 45);
		codelbl.setPreferredSize(new Dimension(100,30));
		codelbl.setSize(100,30);
		codetxt.setLocation(105, 45);
		codetxt.setPreferredSize(new Dimension(600,30));
		codetxt.setSize(600,30);
		codebtn.setLocation(705,45);
		codebtn.setPreferredSize(new Dimension(50,25));
		codebtn.setSize(50,25);
		prviPanel.add(codelbl);
		prviPanel.add(codetxt);
		prviPanel.add(codebtn);
		
		commentlbl.setLocation(5, 90);
		commentlbl.setPreferredSize(new Dimension(100,30));
		commentlbl.setSize(100,30);
		commenttxt.setLocation(105, 90);
		commenttxt.setPreferredSize(new Dimension(650,200));
		commenttxt.setSize(650,200);
		prviPanel.add(commentlbl);
		prviPanel.add(commenttxt);
		
		stereotypelbl.setLocation(5, 290);
		stereotypelbl.setPreferredSize(new Dimension(100,30));
		stereotypelbl.setSize(100,30);
		stereotypecmb.setLocation(105, 295);
		stereotypecmb.setBackground(Color.white);
		stereotypecmb.setPreferredSize(new Dimension(650,30));
		stereotypecmb.setSize(650,30);
		prviPanel.add(stereotypelbl);
		prviPanel.add(stereotypecmb);
		
		timeoutlbl.setLocation(5, 340);
		timeoutlbl.setPreferredSize(new Dimension(100,30));
		timeoutlbl.setSize(100,30);
		timeouttxt.setLocation(105, 340);
		timeouttxt.setPreferredSize(new Dimension(650,30));
		timeouttxt.setSize(650,30);
		prviPanel.add(timeoutlbl);
		prviPanel.add(timeouttxt);
		
		typelbl.setLocation(5, 390);
		typelbl.setPreferredSize(new Dimension(100,30));
		typelbl.setSize(100,30);
		incompletelbl.setLocation(105, 390);
		incompletelbl.setPreferredSize(new Dimension(100,30));
		incompletelbl.setSize(100,30);
		prviPanel.add(typelbl);
		prviPanel.add(incompletelbl);
		
		keywordslbl.setLocation(5, 440);
		keywordslbl.setPreferredSize(new Dimension(100,30));
		keywordslbl.setSize(100,30);
		keywordstxt.setLocation(105, 440);
		keywordstxt.setPreferredSize(new Dimension(650,30));
		keywordstxt.setSize(650,30);
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
		
		annonationtxt.setLocation(5, 50);
		annonationtxt.setPreferredSize(new Dimension(750,450));
		annonationtxt.setSize(750,450);
		cetvrtiPanel.add(annonationtxt);
		
		
		descriptiontxt.setLocation(5, 50);
		descriptiontxt.setPreferredSize(new Dimension(750,450));
		descriptiontxt.setSize(750,450);
		treciPanel.add(descriptiontxt);
		
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

