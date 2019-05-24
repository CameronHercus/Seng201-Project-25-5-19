package main;
/**
 * This class is a subclass of the class MedicalItems 
 * which implements the specific attributes for the medical item Antidote
 * @author Leoca
 *
 */
public class Antidote extends MedicalItems {
    public Antidote() {
        /**
         * Sets the medical items name to "Antidote" and cost to 15
         * by calling the super class MedicalItems constructor
         */
		super("Antidote", 15);
	}
}
