package model;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.text.Document;
import javax.swing.tree.DefaultMutableTreeNode;

public class ModelModel implements Cvor {

	private String naziv;
	private ArrayList<Dokument>dokumenti;
	private Vector<DecisionElement>decisionElements;
	private Vector<StartElement>startElements;
	private Vector<EndElement>endElements;
	private Vector<FlowElement>flowElements;
	private Vector<ActivityElement>activityElements;
	private Vector<SynchronizationElement>synchronizationElements;
	private Vector<ObjectNodeElement>objectNodeElements;
	private Vector<PackageElement>packageElements;
	transient DefaultMutableTreeNode activitiesNode=new DefaultMutableTreeNode("Activities");
	transient DefaultMutableTreeNode decisionsNode=new DefaultMutableTreeNode("Decisions");
	transient DefaultMutableTreeNode startsNode=new DefaultMutableTreeNode("Starts");
	transient DefaultMutableTreeNode endNodes=new DefaultMutableTreeNode("Ends");
	transient DefaultMutableTreeNode flowsNode=new DefaultMutableTreeNode("Flows");
	transient DefaultMutableTreeNode syncsNode=new DefaultMutableTreeNode("Synchronizations");
	transient DefaultMutableTreeNode objectNodesNode=new DefaultMutableTreeNode("Object Nodes");
	transient DefaultMutableTreeNode packagesNode=new DefaultMutableTreeNode("Packages");
	
	public static int brojModela;
	transient DefaultMutableTreeNode rootNode;
	
	
	public Vector<PackageElement> getPackageElements() {
		return packageElements;
	}

	public void setPackageElements(Vector<PackageElement> packageElements) {
		this.packageElements = packageElements;
	}

	public DefaultMutableTreeNode getPackagesNode() {
		return packagesNode;
	}

	public void setPackagesNode(DefaultMutableTreeNode packagesNode) {
		this.packagesNode = packagesNode;
	}

	public Vector<ObjectNodeElement> getObjectNodeElements() {
		return objectNodeElements;
	}

	public void setObjectNodeElements(Vector<ObjectNodeElement> objectNodeElements) {
		this.objectNodeElements = objectNodeElements;
	}

	public DefaultMutableTreeNode getObjectNodesNode() {
		return objectNodesNode;
	}

	public void setObjectNodesNode(DefaultMutableTreeNode objectNodesNode) {
		this.objectNodesNode = objectNodesNode;
	}

	public Vector<SynchronizationElement> getSynchronizationElements() {
		return synchronizationElements;
	}

	public void setSynchronizationElements(Vector<SynchronizationElement> synchronizationElements) {
		this.synchronizationElements = synchronizationElements;
	}

	public DefaultMutableTreeNode getSyncsNode() {
		return syncsNode;
	}

	public void setSyncsNode(DefaultMutableTreeNode syncsNode) {
		this.syncsNode = syncsNode;
	}

	public DefaultMutableTreeNode getActivitiesNode() {
		return activitiesNode;
	}

	public DefaultMutableTreeNode getDecisionsNode() {
		return decisionsNode;
	}

	public DefaultMutableTreeNode getStartsNode() {
		return startsNode;
	}

	public DefaultMutableTreeNode getEndNodes() {
		return endNodes;
	}

	public DefaultMutableTreeNode getFlowsNode() {
		return flowsNode;
	}

	public DefaultMutableTreeNode getRootNode() {
		return rootNode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNaziv();
	}
	
	public ModelModel() {
		this.dokumenti=new ArrayList<Dokument>();
		this.decisionElements=new Vector<DecisionElement>();
		startElements=new Vector<StartElement>();
		endElements=new Vector<EndElement>();
		flowElements=new Vector<FlowElement>();
		activityElements=new Vector<ActivityElement>();
		synchronizationElements=new Vector<SynchronizationElement>();
		objectNodeElements=new Vector<ObjectNodeElement>();
		packageElements=new Vector<PackageElement>();
		
	}
	public Vector<ActivityElement> getActivityElements() {
		return activityElements;
	}
	public void setActivityElements(Vector<ActivityElement> activityElements) {
		this.activityElements = activityElements;
	}
	public Vector<DecisionElement> getDecisionElements() {
		return decisionElements;
	}
	public void setDecisionElements(Vector<DecisionElement> decisionElements) {
		this.decisionElements = decisionElements;
	}
	public Vector<StartElement> getStartElements() {
		return startElements;
	}
	public void setStartElements(Vector<StartElement> startElements) {
		this.startElements = startElements;
	}
	public Vector<EndElement> getEndElements() {
		return endElements;
	}
	public void setEndElements(Vector<EndElement> endElements) {
		this.endElements = endElements;
	}
	public Vector<FlowElement> getFlowElements() {
		return flowElements;
	}
	public void setFlowElements(Vector<FlowElement> flowElements) {
		this.flowElements = flowElements;
	}
	
	public ArrayList<Dokument> getDokumenti() {
		return dokumenti;
	}
	public void setDokumenti(ArrayList<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override
	public DefaultMutableTreeNode napraviCvor() {
		rootNode=new DefaultMutableTreeNode(this);
		for (Dokument dokumentModel : dokumenti) {
			rootNode.add(dokumentModel.napraviCvor());
		}
		
		
		for (ActivityElement activityElement : activityElements) {
			activitiesNode.add(activityElement.napraviCvor());
		}
		
		for (DecisionElement decisionElement : decisionElements) {
			decisionsNode.add(decisionElement.napraviCvor());
		}
		
		for (StartElement startElement : startElements) {
			startsNode.add(startElement.napraviCvor());
		}
		
		for (EndElement endElement : endElements) {
			endNodes.add(endElement.napraviCvor());
		}
		
		
		rootNode.add(activitiesNode);
		rootNode.add(decisionsNode);
		rootNode.add(startsNode);
		rootNode.add(endNodes);
		rootNode.add(syncsNode);
		rootNode.add(objectNodesNode);
		rootNode.add(packagesNode);
		return rootNode;
	}

}
