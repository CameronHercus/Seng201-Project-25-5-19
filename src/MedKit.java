
public class MedKit extends MedicalSupplies{
    public MedKit() {
    	super("MedKit", 20);
	}
	public void applyMedKit(CrewMembersMainClass tempCrewMember) {
		tempCrewMember.setHealthLevel(tempCrewMember.getHealthLevel() + 50);
		// HAVE NOT TESTED AND NEEDS TO SET A LIMIT AT 100 AND 125 FOR MEDIC
		// set quantity -= 1
		
		//heals certain amount of health		
	}

}
