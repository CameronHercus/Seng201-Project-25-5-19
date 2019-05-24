package main;
/**
 * This class is a subclass of the class CrewMembers
 * which implements the specific attributes for the crew member Juggernaut
 * @author Leoca
 *
 */
public class Juggernaut extends CrewMembers {
	public Juggernaut(String tempName) {
	    /**
		 * Sets the crew member name to "Juggernaut", health level to 125,
		 * hunger level to 0, tiredness level to 0 and the member name provided
		 * by the input from the GUI, by calling the super class ClassMembers
		 * constructor
		 * @param tempName     tempName is the name input from the player
		 */
		super("Juggernaut", 125, 0, 0, tempName);
	}
}
