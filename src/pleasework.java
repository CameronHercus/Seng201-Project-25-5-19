import java.util.ListIterator;

public class pleasework {
	static GameEnvironment gameLogic = new GameEnvironment();

	public static void main(String[] args) {
		TheShipClass shipAndCrew = new TheShipClass();
		gameLogic.getShipAndCrew().addCrewMember(new Haggler("harry"));
		gameLogic.getShipAndCrew().addCrewMember(new Thief("Bob"));
		gameLogic.getShipAndCrew().getCrewList().get(0).setHealthLevel(0);
		gameLogic.getShipAndCrew().getCrewList().get(1).setHealthLevel(0);
		System.out.println(gameLogic.getShipAndCrew().getCrewList());
		ListIterator<CrewMembersMainClass> listIterator = gameLogic.getShipAndCrew().getCrewList().listIterator();
		while (listIterator.hasNext()) {
			CrewMembersMainClass member = listIterator.next();
			if (member.getHealthLevel() == 0) {
				listIterator.remove();
			}
		}
	}



}
