import java.util.ArrayList;
import java.util.Scanner;

public class GameEnvironment {
	private int remainingDays;
	private int numberOfPiecesRemaining;
	private int startingMemberCount;
	private boolean found;
	Scanner input = new Scanner(System.in);
	TheShipClass shipAndCrew = new TheShipClass();
	ShopItems shopItems = new ShopItems();
	ArrayList<CrewMembersMainClass> classList = new ArrayList<CrewMembersMainClass>();
	// scanner, a crew list, number of days
	// theshipclass should have a medical lsit, money, and food items,
	public GameEnvironment() {
		classList.add(new Medic());
		classList.add(new Haggler());
		classList.add(new Thief());
	}
	public int getRemainingDays() {
		return remainingDays;
	}
	public boolean inputShipName(String input) {
        try {
        	shipAndCrew.setShipName(input);
        	return true;
        }
        catch (java.util.InputMismatchException e) {
        	// catch is wrong but should return false;
            return false;
        }
	}
	public boolean inputDays(int input) {
        try {
        	switch (input) {
        	case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
        		remainingDays = input;
        		return true;
        		// no break here not sure if thats right
        	default:
        		return false;
        	}
        }
        catch (java.util.InputMismatchException e) {
        	// catch is wrong but should return false;
            return false;
        }
	}
	public String getCrewDescription(CrewMembersMainClass member) {
		return member.toString();
	}
	public ArrayList<CrewMembersMainClass> getClassList() {
		return classList;
	}

}
