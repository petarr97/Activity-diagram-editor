package globalClases;

public class ElementGlobalClass {
	
	public static ElementGlobalClass instance = null;
	public static int activityelementName = 0;
	public static int decisionElementName = 0;
	public static int objectNodeElementName = 0;
	
	public static int getObjectNodeElementName() {
		return objectNodeElementName;
	}

	public static void setObjectNodeElementName(int objectNodeElementName) {
		ElementGlobalClass.objectNodeElementName = objectNodeElementName;
	}

	public static int getDecisionElementName() {
		return decisionElementName;
	}

	public static void setDecisionElementName(int decisionElementName) {
		ElementGlobalClass.decisionElementName = decisionElementName;
	}

	public ElementGlobalClass() {
		
	}
	
	 public static ElementGlobalClass getInstance() 
	    { 
	        if (instance == null) 
	            instance = new ElementGlobalClass(); 
	        
	        return instance; 
	    } 


	public static void setInstance(ElementGlobalClass instance) {
		ElementGlobalClass.instance = instance;
	}

	public static int getActivityelementName() {
		return activityelementName;
	}

	public static void setActivityelementName(int activityelementName) {
		ElementGlobalClass.activityelementName = activityelementName;
	}

}
