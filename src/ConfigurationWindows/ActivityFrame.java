package ConfigurationWindows;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
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
import javax.swing.JToolBar;

import model.ActivityElement;
import model.Element;
import views.ObserverInterface;

public class ActivityFrame extends JFrame implements ObserverInterface {
	Container c = getContentPane();

	JTabbedPane tabbedPane = new JTabbedPane();

	JPanel prviPanel = new JPanel();
	JPanel drugiPanel = new JPanel();
	JPanel treciPanel = new JPanel();
	JPanel cetvrtiPanel = new JPanel();
	JPanel petiPanel = new JPanel();
	JPanel sestiPanel = new JPanel();
	JPanel sedmiPanel = new JPanel();
	JPanel osmiPanel = new JPanel();

	public JTextField imetxt;
	public JTextField codetxt;
	public ActivityElement element;
	public JTextArea commenttxt;
	public JTextField keywordstxt;
	public JTextArea preconditiontxt;
	public JTextArea actiontxt;
	public JTextArea postconditiontxt;
	public JTextArea descriptiontxt;
	public JTextArea annonationtxt;
	JButton ok = new JButton("OK");
	JButton cancel=new JButton("Cancel");

	public ActivityFrame(Point tacka, ActivityElement element) {
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Activity Properities");
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		setLocation(tacka);
		c.setLayout(null);
		initTabs();
		initButtons();
		initGeneralTab();
		initActionTab();
		initDefinitionTab();
		repaint();
		this.element = element;
this.update();
	
	}

	public void initTabs() {
		tabbedPane.setPreferredSize(new Dimension(800, 500));
		tabbedPane.setSize(800, 500);

		prviPanel.setLayout(null);
		prviPanel.setBackground(Color.WHITE);
		drugiPanel.setLayout(null);
		drugiPanel.setBackground(Color.white);
		treciPanel.setLayout(null);
		treciPanel.setBackground(Color.white);

		tabbedPane.add("General", prviPanel);
		tabbedPane.add("Action", drugiPanel);
		tabbedPane.add("Definition", treciPanel);

		c.add(tabbedPane);
	}

	public void initButtons() {

		/*
		 * // JButton ok = new JButton("OK"); //ok.addActionListener(new
		 * ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * 
		 * JButton dugme = (JButton) e.getSource(); ActivityFrame fram = (ActivityFrame)
		 * dugme.getTopLevelAncestor(); element.getParent().repaint();
		 * 
		 * 
		 * element.notifyAllObservers();
		 * 
		 * //fram.dispose();
		 * 
		 * 
		 * } });
		 */
		
		JButton help = new JButton("Help");

		JPanel btnPanel = new JPanel();

		btnPanel.setBounds(0, 510, 800, 100);
	
		btnPanel.add(ok);
		btnPanel.add(cancel);

		btnPanel.add(help);

		c.add(btnPanel);

	}

	public void initGeneralTab() {
		JLabel imelbl = new JLabel("Name:");
		imelbl.setBackground(Color.WHITE);

		JLabel codelbl = new JLabel("Code:");
		codelbl.setBackground(Color.WHITE);

		JLabel commentlbl = new JLabel("Comment:");
		commentlbl.setBackground(Color.WHITE);

		JLabel stereotypelbl = new JLabel("Stereotype:");
		stereotypelbl.setBackground(Color.WHITE);

		JLabel organizationunitlbl = new JLabel("Organization unit:");
		organizationunitlbl.setBackground(Color.WHITE);

		JLabel compositestatuslbl = new JLabel("Composite status:");
		compositestatuslbl.setBackground(Color.WHITE);

		JLabel keywordslbl = new JLabel("Keywords:");
		keywordslbl.setBackground(Color.WHITE);

		imetxt = new JTextField();
		imetxt.setBackground(Color.WHITE);

		codetxt = new JTextField();
		codetxt.setBackground(Color.WHITE);

		commenttxt = new JTextArea();
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

		JRadioButton decoposedactivity = new JRadioButton("Decomposed activity");
		decoposedactivity.setBackground(Color.WHITE);

		JRadioButton atomicactivity = new JRadioButton("Atomic activity");
		atomicactivity.setBackground(Color.white);

		keywordstxt = new JTextField();
		keywordstxt.setBackground(Color.WHITE);

		imelbl.setLocation(5, 0);
		imelbl.setPreferredSize(new Dimension(105, 30));
		imelbl.setSize(105, 30);
		imetxt.setLocation(110, 0);
		imetxt.setPreferredSize(new Dimension(600, 30));
		imetxt.setSize(600, 30);
		prviPanel.add(imelbl);
		prviPanel.add(imetxt);

		codelbl.setLocation(5, 45);
		codelbl.setPreferredSize(new Dimension(105, 30));
		codelbl.setSize(105, 30);
		codetxt.setLocation(110, 45);
		codetxt.setPreferredSize(new Dimension(600, 30));
		codetxt.setSize(600, 30);

		prviPanel.add(codelbl);
		prviPanel.add(codetxt);

		commentlbl.setLocation(5, 90);
		commentlbl.setPreferredSize(new Dimension(105, 30));
		commentlbl.setSize(105, 30);
		commenttxt.setLocation(110, 90);
		commenttxt.setPreferredSize(new Dimension(650, 200));
		commenttxt.setSize(650, 200);
		prviPanel.add(commentlbl);
		prviPanel.add(commenttxt);

		stereotypelbl.setLocation(5, 290);
		stereotypelbl.setPreferredSize(new Dimension(105, 30));
		stereotypelbl.setSize(105, 30);
		stereotypecmb.setLocation(110, 295);
		stereotypecmb.setBackground(Color.white);
		stereotypecmb.setPreferredSize(new Dimension(650, 30));
		stereotypecmb.setSize(650, 30);
		prviPanel.add(stereotypelbl);
		prviPanel.add(stereotypecmb);

		organizationunitlbl.setLocation(5, 340);
		organizationunitlbl.setPreferredSize(new Dimension(105, 30));
		organizationunitlbl.setSize(105, 30);
		organizationunitcmb.setLocation(110, 340);
		organizationunitcmb.setBackground(Color.white);
		organizationunitcmb.setPreferredSize(new Dimension(545, 30));
		organizationunitcmb.setSize(545, 30);

		org1btn.setLocation(660, 340);
		org1btn.setPreferredSize(new Dimension(30, 25));
		org1btn.setSize(30, 25);

		org2btn.setLocation(695, 340);
		org2btn.setPreferredSize(new Dimension(30, 25));
		org2btn.setSize(30, 25);

		org3btn.setLocation(730, 340);
		org3btn.setPreferredSize(new Dimension(30, 25));
		org3btn.setSize(30, 25);
		prviPanel.add(organizationunitlbl);
		prviPanel.add(organizationunitcmb);
		prviPanel.add(org1btn);
		prviPanel.add(org2btn);
		prviPanel.add(org3btn);

		compositestatuslbl.setLocation(5, 390);
		compositestatuslbl.setPreferredSize(new Dimension(105, 30));
		compositestatuslbl.setSize(105, 30);
		decoposedactivity.setLocation(110, 390);
		decoposedactivity.setPreferredSize(new Dimension(200, 30));
		decoposedactivity.setSize(150, 30);
		atomicactivity.setLocation(265, 390);
		atomicactivity.setPreferredSize(new Dimension(200, 30));
		atomicactivity.setSize(150, 30);
		prviPanel.add(compositestatuslbl);
		prviPanel.add(decoposedactivity);
		prviPanel.add(atomicactivity);

		keywordslbl.setLocation(5, 440);
		keywordslbl.setPreferredSize(new Dimension(105, 30));
		keywordslbl.setSize(105, 30);
		keywordstxt.setLocation(110, 440);
		keywordstxt.setPreferredSize(new Dimension(650, 30));
		keywordstxt.setSize(650, 30);
		prviPanel.add(keywordslbl);
		prviPanel.add(keywordstxt);

	}

	public void initActionTab() {
		JTabbedPane drugiTabbedPane = new JTabbedPane();
		drugiTabbedPane.setBackground(Color.white);

		preconditiontxt = new JTextArea();
		preconditiontxt.setBackground(Color.WHITE);

		actiontxt = new JTextArea();
		actiontxt.setBackground(Color.WHITE);

		postconditiontxt = new JTextArea();
		postconditiontxt.setBackground(Color.white);

		JLabel actiontypelbl = new JLabel("Action Type:");
		JTextField actiontypetxt = new JTextField();
		actiontypetxt.setBackground(Color.white);

		JLabel durationlbl = new JLabel("Duration:");
		JTextField durationtxt = new JTextField();
		durationtxt.setBackground(Color.WHITE);

		JLabel timeoutlbl = new JLabel("Timeout:");
		JTextField timeouttxt = new JTextField();
		timeouttxt.setBackground(Color.white);

		actiontypelbl.setLocation(5, 0);
		actiontypelbl.setPreferredSize(new Dimension(105, 30));
		actiontypelbl.setSize(105, 30);

		actiontypetxt.setLocation(110, 0);
		actiontypetxt.setPreferredSize(new Dimension(650, 30));
		actiontypetxt.setSize(650, 30);

		drugiPanel.add(actiontypelbl);
		drugiPanel.add(actiontypetxt);

		preconditiontxt.setLocation(5, 40);
		preconditiontxt.setPreferredSize(new Dimension(745, 330));
		preconditiontxt.setSize(735, 330);

		actiontxt.setLocation(5, 40);
		actiontxt.setPreferredSize(new Dimension(745, 330));
		actiontxt.setSize(735, 330);

		postconditiontxt.setLocation(5, 40);
		postconditiontxt.setPreferredSize(new Dimension(745, 330));
		postconditiontxt.setSize(735, 330);

		drugiTabbedPane.setLocation(5, 35);
		drugiTabbedPane.setPreferredSize(new Dimension(755, 400));
		drugiTabbedPane.setSize(755, 400);

		cetvrtiPanel.setLayout(null);
		cetvrtiPanel.add(preconditiontxt);
		drugiTabbedPane.add(cetvrtiPanel, "Pre-Conditions");
		petiPanel.setLayout(null);
		petiPanel.add(actiontxt);
		drugiTabbedPane.add(petiPanel, "Actions");
		sestiPanel.setLayout(null);
		sestiPanel.add(postconditiontxt);
		drugiTabbedPane.add(sestiPanel, "Post-Conditions");
		drugiPanel.add(drugiTabbedPane);
		timeoutlbl.setLocation(5, 440);
		timeoutlbl.setPreferredSize(new Dimension(105, 30));
		timeoutlbl.setSize(105, 30);
		timeouttxt.setLocation(110, 440);
		timeouttxt.setPreferredSize(new Dimension(200, 30));
		timeouttxt.setSize(200, 30);

		durationlbl.setLocation(315, 440);
		durationlbl.setPreferredSize(new Dimension(105, 30));
		durationlbl.setSize(105, 30);
		durationtxt.setLocation(420, 440);
		durationtxt.setPreferredSize(new Dimension(200, 30));
		durationtxt.setSize(200, 30);

		drugiPanel.add(timeoutlbl);
		drugiPanel.add(timeouttxt);
		drugiPanel.add(durationlbl);
		drugiPanel.add(durationtxt);
	}

	public void initDefinitionTab() {
		JTabbedPane drugiTabbedPane = new JTabbedPane();
		drugiTabbedPane.setBackground(Color.WHITE);

		descriptiontxt = new JTextArea();
		descriptiontxt.setBackground(Color.WHITE);

		annonationtxt = new JTextArea();
		annonationtxt.setBackground(Color.WHITE);

		drugiTabbedPane.setPreferredSize(new Dimension(800, 470));
		drugiTabbedPane.setSize(800, 470);
		drugiTabbedPane.add(sedmiPanel, "Description");
		drugiTabbedPane.add(osmiPanel, "Annonation");

		descriptiontxt.setLocation(5, 50);
		descriptiontxt.setPreferredSize(new Dimension(750, 450));
		descriptiontxt.setSize(750, 450);
		sedmiPanel.add(descriptiontxt);

		annonationtxt.setLocation(5, 50);
		annonationtxt.setPreferredSize(new Dimension(750, 450));
		annonationtxt.setSize(750, 450);
		osmiPanel.add(annonationtxt);

		treciPanel.add(drugiTabbedPane);
	}

	@Override
	public void update() {
		imetxt.setText(element.naziv);

		if (element.naziv != null)
			codetxt.setText(element.naziv.toLowerCase());
		else
			codetxt.setText(element.code.toString());

		commenttxt.setText(element.comment);
		keywordstxt.setText(element.keywords);
		preconditiontxt.setText(element.preCondition);
		postconditiontxt.setText(element.postCondition);
		actiontxt.setText(element.action);
		descriptiontxt.setText(element.descritpion);
		annonationtxt.setText(element.anotation);

	repaint();

	}

	@Override
	public void registerComponents(EventListener listener) {
		ok.setActionCommand("ok");
		ok.addActionListener((ActionListener) listener);
		
		cancel.setActionCommand("cancel");
		cancel.addActionListener((ActionListener) listener);

	}

}
