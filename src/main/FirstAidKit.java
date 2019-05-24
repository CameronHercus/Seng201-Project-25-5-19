package main;
/**
 * This class is a subclass of the class MedicalItems 
 * which implements the specific attributes for the medical item FirstAidKit
 * @author Leoca
 *
 */
public class FirstAidKit extends MedicalItems {
    public FirstAidKit() {
        /**
         * Sets the medical items name to "FirstAidKit" and cost to 15
         * by calling the super class MedicalItems constructor
         */
    	super("FirstAidKit", 15);
	}
}
