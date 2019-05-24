package main;
/**
 * This class is a subclass of the class CrewMembers
 * which implements the specific attributes for the crew member Haggler
 * @author Leoca
 *
 */
public class Haggler extends CrewMembers {
	public Haggler(String tempName) {
	    /**
		 * Sets the crew member name to "Haggler", health level to 100,
		 * hunger level to 0, tiredness level to 0 and the member name provided
		 * by the input from the GUI, by calling the super class ClassMembers
		 * constructor
		 * @param tempName       tempName is the name input from the player
		 */
		super("Haggler", 100, 0, 0, tempName);
	}

}
