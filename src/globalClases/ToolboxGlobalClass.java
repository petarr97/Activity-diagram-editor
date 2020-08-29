package globalClases;

import java.awt.List;
import java.awt.Point;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;

import model.Element;
import model.FlowElement;

public class ToolboxGlobalClass {

	private static ToolboxGlobalClass instance =null;
	public boolean activity;
	public boolean objectNode;
	public boolean decision;
	public boolean package1;
	public boolean start;
	public boolean end;
	public boolean line;
	public Point startPoint;
	public Point endPoint;
	public boolean synchronization;
	public boolean delete;
	public boolean select;
	public boolean panelClick;
	public boolean drawing1 = false;
	public boolean drawing2 = false;
	public boolean text;
	public boolean cut;
	public boolean copy;
	
	
	
	public boolean isCopy() {
		return copy;
	}

	public void setCopy(boolean copy) {
		this.copy = copy;
	}

	public boolean isCut() {
		return cut;
	}

	public void setCut(boolean cut) {
		this.cut = cut;
	}

	public boolean isText() {
		return text;
	}

	public void setText(boolean text) {
		this.text = text;
	}

	public boolean isDrawing1() {
		return drawing1;
	}

	public void setDrawing1(boolean drawing1) {
		this.drawing1 = drawing1;
	}

	public boolean isDrawing2() {
		return drawing2;
	}

	public void setDrawing2(boolean drawing2) {
		this.drawing2 = drawing2;
	}

	public boolean isPanelClick() {
		return panelClick;
	}

	public void setPanelClick(boolean panelClick) {
		this.panelClick = panelClick;
	}


	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isSynchronization() {
		return synchronization;
	}

	public void setSynchronization(boolean synchronization) {
		this.synchronization = synchronization;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isLine() {
		return line;
	}

	public void setLine(boolean line) {
		this.line = line;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public boolean isPackage1() {
		return package1;
	}

	public void setPackage1(boolean package1) {
		this.package1 = package1;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	public boolean isObjectNode() {
		return objectNode;
	}

	public void setObjectNode(boolean objectNode) {
		this.objectNode = objectNode;
	}

	public boolean isActivity() {
		return activity;
	}

	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	
	 public static ToolboxGlobalClass getInstance() 
	    { 
	        if (instance == null) 
	            instance = new ToolboxGlobalClass(); 
	        
	        return instance; 
	    } 


	public ToolboxGlobalClass() {
	}
}
