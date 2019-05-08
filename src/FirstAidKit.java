
public class FirstAidKit extends MedicalSupplies{
    public FirstAidKit() {
    	super("FirstAidKit", 10);
	}
	public void applyFirstAidKit(CrewMembersMainClass tempCrewMember) {
		tempCrewMember.setHealthLevel(tempCrewMember.getHealthLevel() + 25);
		// set quantity -= 1
		// HAVE NOT TESTED AND NEEDS TO SET A LIMIT AT 100 AND 125 FOR MEDIC
		
		//heals certain amount of health		
	}

}
