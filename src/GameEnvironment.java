import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
	ArrayDeque<CrewMembersMainClass> deque = new ArrayDeque<CrewMembersMainClass>();
	// scanner, a crew list, number of days
	// theshipclass should have a medical list, money, and food items,
	public static void main(String[] args) {
		GameEnvironment gameLogic = new GameEnvironment();
		gameLogic.launchSetupScreen();
	}
	public GameEnvironment() {
		classList.add(new Medic());
		classList.add(new Haggler());
		classList.add(new Thief());
	}
	public void launchShipOptionsScreen() {
		ShipOptionsScreen shipOptionsScreen = new ShipOptionsScreen(this);
	}
	public void closeShipOptionsScreen(ShipOptionsScreen shipOptionsScreen) {
		shipOptionsScreen.closeWindow();
	}
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchShipOptionsScreen();
	}
	public ArrayDeque<CrewMembersMainClass> getDeque() {
		return deque;
	}
	public int getRemainingDays() {
		return remainingDays;
	}
	public boolean inputShipName(String inputTxtBox) {
        try {
        	shipAndCrew.setShipName(inputTxtBox);
        	return true;
        }
        catch (java.util.InputMismatchException e) {
        	// catch is wrong but should return false;
            return false;
        }
	}
	public boolean inputDays(int inputSlider) {
        try {
        	switch (inputSlider) {
        	case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
        		remainingDays = inputSlider;
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
	public TheShipClass getShipAndCrew() {

		return shipAndCrew;
	}
	public void setRemainingDays(int i) {
		remainingDays = i; 
	}


}
