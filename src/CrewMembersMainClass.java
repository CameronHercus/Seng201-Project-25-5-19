
public class CrewMembersMainClass {
    private String className;
	private int healthLevel;
	private int hungerLevel;
	private int tirednessLevel;
	private String skill;
	private String memberName;
	private boolean spacePlagueStatus = false;
	private int crewActions = 2;
	public CrewMembersMainClass(String tempName) {
		className = tempName;
	}
	public CrewMembersMainClass(String tempName, int tempHealthLevel, int tempHungerLevel, int tempTirednessLevel,
			String tempSkill, String tempMemberName) {
		memberName = tempMemberName;
		healthLevel = tempHealthLevel;
		hungerLevel = tempHungerLevel;
		tirednessLevel = tempTirednessLevel;
		skill = tempSkill;
		className = tempName;
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
	public void setTiredNessLevel(int tempTirednessLevel) {
		tirednessLevel = tempTirednessLevel;
	}
	public String getSkill() {
		return skill;
	}
	public String toString() {
		return memberName + " The " + className;
	}
	public String toStatus() {
		return memberName + " status: " + "\n" + "Tiredness level is " + tirednessLevel + ", Health level is " + healthLevel + ",  Hunger level is " + hungerLevel;
	}

}
