package main;
/**
 * This class is a subclass of the class CrewMembers
 * which implements the specific attributes for the crew member Archeologist
 * @author Leoca
 *
 */
public class Archeologist extends CrewMembers {
	public Archeologist(String tempName) {
	    /**
		 * Sets the crew member name to "Archeologist", health level to 100,
		 * hunger level to 0, tiredness level to 0 and the member name provided
		 * by the input from the GUI, by calling the super class ClassMembers
		 * constructor
		 * @param tempName          tempName is the input name from the player
		 */
		super("Archeologist", 100, 0, 0, tempName);
	}
}
