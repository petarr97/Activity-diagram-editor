package ConfigurationWindows;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DecisionElement;
import views.ObserverInterface;

public class DecisionFrame extends JFrame implements ObserverInterface{
	
	Container c = getContentPane();
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel prviPanel = new JPanel();
	JPanel drugiPanel = new JPanel();
	JPanel treciPanel = new JPanel();
	JPanel cetvrtiPanel = new JPanel();
	JPanel petiPanel = new JPanel();
	
 	public JTextField imetxt;
	public  JTextField codetxt;
	public JTextArea commenttxt;
	public JTextField keywordstxt;
	public JTextArea conditionstxt;
	public JTextField aliastxt;
	public JTextArea descriptiontxt;
	public JTextArea annonationtxt;
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");

	DecisionElement decisionElement;
	public DecisionFrame(Point point, DecisionElement decisionElement)
	{
		this.decisionElement=decisionElement;
		setTitle("Decision Properities");
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		c.setLayout(null);
		initTabs();
		initButtons();
		initGeneralTab();
		initConditionTab();
		initDefinitionTab();
		update();
		repaint();
	}
	public void initTabs()
	{
		tabbedPane.setPreferredSize(new Dimension(800,500));
		tabbedPane.setSize(800,500);
		
		prviPanel.setLayout(null);
		prviPanel.setBackground(Color.WHITE);
		drugiPanel.setLayout(null);
		drugiPanel.setBackground(Color.white);
		treciPanel.setLayout(null);
		treciPanel.setBackground(Color.white);
		
		tabbedPane.add("General",prviPanel);
		tabbedPane.add("Condition",drugiPanel);
		tabbedPane.add("Definition",treciPanel);
		
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
		imelbl.setBackground(Color.WHITE);
		
		JLabel codelbl = new JLabel("Code:");
		codelbl.setBackground(Color.WHITE);
		
		JLabel commentlbl = new JLabel("Comment:");
		commentlbl.setBackground(Color.WHITE);
		
		JLabel stereotypelbl = new JLabel("Stereotype:");
		stereotypelbl.setBackground(Color.WHITE);
		
		JLabel organizationunitlbl = new JLabel("Organization unit::");
		organizationunitlbl.setBackground(Color.WHITE);
		
		JLabel typelbl = new JLabel("Type:");
		typelbl.setBackground(Color.WHITE);
		
		JLabel keywordslbl = new JLabel("Keywords:");
		keywordslbl.setBackground(Color.WHITE);
		
		imetxt = new JTextField();
		imetxt.setBackground(Color.WHITE);
		
		codetxt = new JTextField();
		codetxt.setBackground(Color.WHITE);
		
		commenttxt = new  JTextArea();
		commenttxt.setBackground(Color.white);
		commenttxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		JComboBox stereotypecmb = new JComboBox();
		stereotypecmb.setBackground(Color.gray);
		
		JComboBox organizationunitcmb = new JComboBox();
		organizationunitcmb.setBackground(Color.gray);
		
		JButton org1btn = new JButton();
		org1btn.setIcon(new ImageIcon("./icons/openDocument.png"));
		
		JButton org2btn = new JButton();
		org2btn.setIcon(new ImageIcon("./icons/zoomin.png"));
		
		JButton org3btn = new JButton();
		org3btn.setIcon(new ImageIcon("./icons/line.png"));
		
		JLabel incompletelbl = new JLabel("Incomplete");
		
		keywordstxt = new JTextField();
		keywordstxt.setBackground(Color.WHITE);
		
		imelbl.setLocation(5, 0);
		imelbl.setPreferredSize(new Dimension(105,30));
		imelbl.setSize(105,30);
		imetxt.setLocation(110, 0);
		imetxt.setPreferredSize(new Dimension(600,30));
		imetxt.setSize(600,30);
		prviPanel.add(imelbl);
		prviPanel.add(imetxt);
	
		
		codelbl.setLocation(5, 45);
		codelbl.setPreferredSize(new Dimension(105,30));
		codelbl.setSize(105,30);
		codetxt.setLocation(110, 45);
		codetxt.setPreferredSize(new Dimension(600,30));
		codetxt.setSize(600,30);
		
		prviPanel.add(codelbl);
		prviPanel.add(codetxt);
		
		
		commentlbl.setLocation(5, 90);
		commentlbl.setPreferredSize(new Dimension(105,30));
		commentlbl.setSize(105,30);
		commenttxt.setLocation(110, 90);
		commenttxt.setPreferredSize(new Dimension(650,200));
		commenttxt.setSize(650,200);
		prviPanel.add(commentlbl);
		prviPanel.add(commenttxt);
		
		stereotypelbl.setLocation(5, 290);
		stereotypelbl.setPreferredSize(new Dimension(105,30));
		stereotypelbl.setSize(105,30);
		stereotypecmb.setLocation(110, 295);
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
		
		typelbl.setLocation(5, 340);
		typelbl.setPreferredSize(new Dimension(105,30));
		typelbl.setSize(105,30);
		incompletelbl.setLocation(110,340);
		incompletelbl.setPreferredSize(new Dimension(200,30));
		incompletelbl.setSize(150,30);
		prviPanel.add(typelbl);
		prviPanel.add(incompletelbl);
		
		keywordslbl.setLocation(5, 440);
		keywordslbl.setPreferredSize(new Dimension(105,30));
		keywordslbl.setSize(105,30);
		keywordstxt.setLocation(110, 440);
		keywordstxt.setPreferredSize(new Dimension(650,30));
		keywordstxt.setSize(650,30);
		prviPanel.add(keywordslbl);
		prviPanel.add(keywordstxt);
		
	}
	
	public void initConditionTab()
	{
		JLabel aliaslbl = new JLabel("Action Type:");
		aliastxt = new JTextField();
		aliastxt.setBackground(Color.white);
		
		aliaslbl.setLocation(5, 0);
		aliaslbl.setPreferredSize(new Dimension(105,30));
		aliaslbl.setSize(105,30);
		
		aliastxt.setLocation(110, 0);
		aliastxt.setPreferredSize(new Dimension(650,30));
		aliastxt.setSize(650,30);
		
		drugiPanel.add(aliaslbl);
		drugiPanel.add(aliastxt);
		
		conditionstxt = new JTextArea();
		conditionstxt.setLocation(5,40);
		conditionstxt.setPreferredSize(new Dimension(755, 400));
		conditionstxt.setSize(755,400);
		conditionstxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		drugiPanel.add(conditionstxt);
	}
	public void initDefinitionTab()
	{
		JTabbedPane drugiTabbedPane = new JTabbedPane();
		drugiTabbedPane.setBackground(Color.WHITE);
		
		descriptiontxt = new JTextArea();
		descriptiontxt.setBackground(Color.WHITE);
		
		annonationtxt = new JTextArea();
		annonationtxt.setBackground(Color.WHITE);
		
		drugiTabbedPane.setPreferredSize(new Dimension(800,470));
		drugiTabbedPane.setSize(800,470);
		drugiTabbedPane.add(cetvrtiPanel,"Description");
		drugiTabbedPane.add(petiPanel,"Annonation");
		
		
		descriptiontxt.setLocation(5, 50);
		descriptiontxt.setPreferredSize(new Dimension(730,420));
		descriptiontxt.setSize(730,420);
		descriptiontxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		cetvrtiPanel.add(descriptiontxt);
		
		annonationtxt.setLocation(5, 50);
		annonationtxt.setPreferredSize(new Dimension(730,420));
		annonationtxt.setSize(730,420);
		annonationtxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		petiPanel.add(annonationtxt);
		
		
		treciPanel.add(drugiTabbedPane);
	}
	@Override
	public void update() {
		imetxt.setText(decisionElement.naziv);
		codetxt.setText(decisionElement.code);
		//aliastxt.setText(decisionElement);
		commenttxt.setText(decisionElement.comment);
		keywordstxt.setText(decisionElement.keywords);
		conditionstxt.setText(decisionElement.getConditionsString());
	}
	@Override
	public void registerComponents(EventListener listener) {
		ok.setActionCommand("ok");
		ok.addActionListener((ActionListener) listener);
		
		cancel.setActionCommand("cancel");
		cancel.addActionListener((ActionListener) listener);
		
	}
	
}
