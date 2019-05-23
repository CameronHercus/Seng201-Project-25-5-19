
public class CrewMembers {
    private String className;
	private String memberName;
	private int healthLevel;
	private int hungerLevel;
	private int tirednessLevel;
	private int remainingActions = 2;
	private boolean spacePlagueStatus = false;
	public CrewMembers(String tempName) {
		className = tempName;
	}
	public CrewMembers(String tempClassName, int tempHealthLevel, int tempHungerLevel, int tempTirednessLevel, String tempMemberName) {
		className = tempClassName;
		healthLevel = tempHealthLevel;
		hungerLevel = tempHungerLevel;
		tirednessLevel = tempTirednessLevel;
		memberName = tempMemberName;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public String getClassName() {
		return className;
	}
	public int getHealthLevel() {
		return healthLevel;
	}
	public void setHungerLevel(int tempHungerLevel) {
		hungerLevel = tempHungerLevel;
	}
	public int getHungerLevel() {
		return hungerLevel;
	}
	public void setHealthLevel(int tempHealthLevel) {
		healthLevel = tempHealthLevel;
	}
	public int getTirednessLevel() {
		return tirednessLevel;
	}
	public void setTiredNessLevel(int tempTirednessLevel) {
		tirednessLevel = tempTirednessLevel;
	}
	public int getRemainingActions() {
		return remainingActions;
	}
	public void setRemainingActions(int tempRemainingActions) {
		remainingActions = tempRemainingActions;
	}
	public void setSpacePlagueStatus(boolean tempStatus) {
		spacePlagueStatus = tempStatus;
	}
	public boolean getSpacePlagueStatus() {
		return spacePlagueStatus;
	}
	public String toString() {
		return memberName + " The " + className;
	}

}
