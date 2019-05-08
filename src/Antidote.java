
public class Antidote extends MedicalSupplies{
    public Antidote() {
		super("Antidote", 15);
		// NAME, QUANTITY, PRICE
		// find out how they do the extra functions for the planets eg and then apply them to the crew bit where i put default!	
	}
	public void applyAntidote(CrewMembersMainClass tempCrewMember) {
		// set quantity -= 1
		tempCrewMember.setSpacePlagueStatus(false);
		//remove space plague		
	}
}
