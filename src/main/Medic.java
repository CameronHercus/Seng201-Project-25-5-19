package main;
/**
 * This class is a subclass of the class CrewMembers
 * which implements the specific attributes for the crew member Medic
 * @author Leoca
 *
 */
public class Medic extends CrewMembers {
	   /**
		 * Sets the crew member name to "Medic", health level to 100,
		 * hunger level to 0, tiredness level to 0 and the member name provided
		 * by the input from the GUI, by calling the super class ClassMembers
		 * constructor
		 * @param tempName         tempName is name input from player
		 */
	public Medic(String tempName) {
		super("Medic", 100, 0, 0, tempName);
	}

}
