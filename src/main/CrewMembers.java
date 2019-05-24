package main;
/**
 * This class implements Crew Members and their attributes 
 * @author Leoca
 *
 */
public class CrewMembers {
    /**
     * The name of the class
     */
    private String className;
	/**
	 * The name of the member (nickname)
	 */
	private String memberName;
	/**
	 * The crew members health
	 */
	private int healthLevel;
	/**
	 * The crew members hunger
	 */
	private int hungerLevel;
	/**
	 * The crew members tiredness
	 */
	private int tirednessLevel;
	/**
	 * The remaining actions the crew member has left
	 */
	private int remainingActions = 2;
	/**
	 * Initializes the space plague status as false
	 */
	private boolean spacePlagueStatus = false;
	/**
	 * Sets the class name, health, hunger, tiredness, and member name to the values passed into the constructor
	 * @param tempClassName       	String Provided name
	 * @param tempHealthLevel     	int Provided health level
	 * @param tempHungerLevel     	int Provided hunger level
	 * @param tempTirednessLevel  	int Provided tiredness level
	 * @param tempMemberName		String Provided member name
	 */
	public CrewMembers(String tempClassName, int tempHealthLevel, int tempHungerLevel, int tempTirednessLevel, String tempMemberName) {
		className = tempClassName;
		healthLevel = tempHealthLevel;
		hungerLevel = tempHungerLevel;
		tirednessLevel = tempTirednessLevel;
		memberName = tempMemberName;
	}
	/**
	 * Gets the health level for the class member
	 * @return   The health level as a integer
	 */
	public int getHealthLevel() {
		return healthLevel;
	}
	/**
	 * Sets the hunger level for the class member
	 * @param tempHungerLevel  int Provided hunger level 
	 */
	public void setHungerLevel(int tempHungerLevel) {
		hungerLevel = tempHungerLevel;
	}
	/**
	 * Gets the hunger level for the class member
	 * @return		Hunger level as a integer
	 */
	public int getHungerLevel() {
		return hungerLevel;
	}
	/**
	 * Sets the health level for the class member
	 * @param tempHealthLevel		Provided health level integer
	 */
	public void setHealthLevel(int tempHealthLevel) {
		healthLevel = tempHealthLevel;
	}
	/**
	 * Gets the tiredness level of the crew member
	 * @return		The tiredness level as a integer
	 */
	public int getTirednessLevel() {
		return tirednessLevel;
	}
	/**
	 * Sets tiredness level for the crew member
	 * @param tempTirednessLevel	int Provided tiredness level 
	 */
	public void setTiredNessLevel(int tempTirednessLevel) {
		tirednessLevel = tempTirednessLevel;
	}
	/**
	 * Gets the remaining actions available for the crew member
	 * @return		Remaining actions as a integer
	 */
	public int getRemainingActions() {
		return remainingActions;
	}
	/**
	 * Sets the remaining actions for the crew member
	 * @param tempRemainingActions		int Number for remaining actions
	 */
	public void setRemainingActions(int tempRemainingActions) {
		remainingActions = tempRemainingActions;
	}
	/**
	 * Sets the space plague status for the crew member
	 * @param tempStatus		boolean Space plague status
	 */
	public void setSpacePlagueStatus(boolean tempStatus) {
		spacePlagueStatus = tempStatus;
	}
	/**
	 * Gets the space plague status for the crew member
	 * @return		The space plague status	as a boolean
	 */
	public boolean getSpacePlagueStatus() {
		return spacePlagueStatus;
	}
	/**
	 * Returns the members name and the specific class type for that member
	 */
	public String toString() {
		return memberName + " The " + className;
	}

}
