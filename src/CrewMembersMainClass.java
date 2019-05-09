
public class CrewMembersMainClass {
    private String className;
	private int healthLevel;
	private int hungerLevel;
	private int tirednessLevel;
	private String skill;
	private String memberName;
	private boolean spacePlagueStatus = false;
	private int crewActions = 2;
	
	
	// not sure if this is a good idea

	
	//This is the main class for the crewmembers which extends to the individual subclasses such as haggler and medic!

	public CrewMembersMainClass(String tempName, int tempHealthLevel, int tempHungerLevel, int tempTirednessLevel,
			String tempSkill, String tempMemberName) {
		memberName = tempMemberName;
		className = tempName;
		healthLevel = tempHealthLevel;
		hungerLevel = tempHungerLevel;
		tirednessLevel = tempTirednessLevel;
		skill = tempSkill;
	}
	public void setMemberName(String tempMemberName) {
		memberName = tempMemberName;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getClassName() {
		return className;
	}
	
	public void setCrewActions(int newamount) {
		crewActions = newamount;
	}
	public int getCrewActions() {
		return crewActions;
	}
	
	
	
	public void setSpacePlagueStatus(boolean tempStatus) {
		spacePlagueStatus = tempStatus;
		// not sure if this should be implimented under the crew member class or ship class
	}
	public boolean getSpacePlagueStatus() {
		return spacePlagueStatus;
	}
	
	
	public void setHealthLevel(int tempHealthLevel) {
		healthLevel = tempHealthLevel;
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
	
	
	
	public int getTirednessLevel() {
		return tirednessLevel;
	}
	public String getSkill() {
		return skill;
	}
	public String toString() {
		return "The " + className;
	}
	public String toStatus() {
		return memberName + " status: " + "\n" + "Tiredness level is " + tirednessLevel + ", Health level is " + healthLevel + ",  Hunger level is " + hungerLevel;
	}

}
