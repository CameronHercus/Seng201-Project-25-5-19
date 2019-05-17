import java.util.ArrayList;
import java.util.ListIterator;

public class GameEnvironment {
	private int remainingDays;
	private int numberOfPiecesRemaining;
	private boolean partFoundOnPlanet = false;
	TheShipClass shipAndCrew = new TheShipClass();

	public static void main(String[] args) {
		GameEnvironment gameLogic = new GameEnvironment();
		gameLogic.launchSetupScreen();
	}
	public GameEnvironment() {
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
	public void launchOutpostOptionScreen() {
		OutpostOptionScreen outpostWindow = new OutpostOptionScreen(this);
	}
	public void closeOutpostOptionScreen(OutpostOptionScreen outpostScreen) {
		outpostScreen.closeWindow();
		launchShipOptionsScreen();
	}
	public void closeEndingScreen(EndingScreen endingScreen) {
		endingScreen.closeWindow();
	}
	public void launchEndingScreen() {
		EndingScreen endingScreen = new EndingScreen(this);
	}
	public TheShipClass getShipAndCrew() {
		return shipAndCrew;
	}
	public void setPartFoundOnPlanet(boolean booleanValue) {
		partFoundOnPlanet = booleanValue;
	}

	
	
	public void feed(FoodItems food) {
	}
	public void applyMedicine(MedicalSupplies medicine) {
	} 
	
	
	public String newDayEvent() {
		switch((int)(Math.random() * 2 + 1)) {
		// *3 means in range of 3, the +1 means +1 to the answer, otherwise it would be 0,1,2 instead of 1,2,3
		case 1: //"Alien Pirates steal an item"
			return "Alien Pirates";
		case 2: //"Space plague affects one of the crew members"
			return "Space Plague";
			// random for i in size() of crewlist picks a number 
		}
		return null;
	}
	public void newDayChanges() {
		for (int i = 0; i < shipAndCrew.getCrewList().size(); i++) {
			shipAndCrew.getCrewList().get(i).setHungerLevel(Math.min(shipAndCrew.getCrewList().get(i).getHungerLevel() + 15, 100));
			shipAndCrew.getCrewList().get(i).setTiredNessLevel(Math.min(shipAndCrew.getCrewList().get(i).getTirednessLevel() + 50, 100));
			if (shipAndCrew.getCrewList().get(i).getHealthLevel() > 0) {
				shipAndCrew.getCrewList().get(i).setHealthLevel(Math.max(shipAndCrew.getCrewList().get(i).getHealthLevel() - 19, 0));
			}
		}
		setPartFoundOnPlanet(false);
		removeDeadCrewMembers();
		//iterates throught the arraylist and removes any crew members who health is 0, can only be done using listiterator
	}
	public void removeDeadCrewMembers() {
		ListIterator<CrewMembersMainClass> listIterator = shipAndCrew.getCrewList().listIterator();
		while (listIterator.hasNext()) {
			CrewMembersMainClass member = listIterator.next();
			if (member.getHealthLevel() == 0) {
				listIterator.remove();
			}
		}
		
	}
	public void searchForParts(CrewMembersMainClass member) {
		if (member.getCrewActions() > 0 ) {
			member.setCrewActions(member.getCrewActions()-1);
			switch((int)(Math.random() * 5 + 1)) {
			case 1: System.out.println("Food");
			addRandomFood();
				break;
			case 2: System.out.println("Part");
			if (partFoundOnPlanet) {
				numberOfPiecesRemaining -= 1;
				System.out.println("Part");
			} else {
				System.out.println("Part already found you found nothing");
			}
				break;
			case 3: System.out.println("Money");
			shipAndCrew.setAmountMoney(shipAndCrew.getAmountMoney()+10);
				break;
			case 4: System.out.println("None");
				break;
			case 5: System.out.println("Medicine");
			addRandomMedicine();
				break;
			}
		}
	}
	public void setAllCrewmembersActions() {
		for (CrewMembersMainClass i: shipAndCrew.getCrewList()) {
			i.setCrewActions(2);
		}
	}
	public void addRandomMedicine() {
		switch((int)(Math.random() * 2 + 1)) {
		case 1: shipAndCrew.getMedicalList().add(new FirstAidKit());
			break;
		case 2: shipAndCrew.getMedicalList().add(new Antidote());
			break;
		}
	}
	public void addRandomFood() {
		switch((int)(Math.random() * 3 + 1)) {
		case 1: shipAndCrew.getFoodList().add(new Tea());
			break;
		case 2: shipAndCrew.getFoodList().add(new Nuts()); 
			break;
		case 3: shipAndCrew.getFoodList().add(new Apple());
			break;
		}
	}
	public boolean newPlanet() {
		switch((int)(Math.random() * 3 + 1)) {
		// 33% chance to trigger ship damage
		case 1: //trigger ship taking % damage
			shipAndCrew.setShipHealth((shipAndCrew.getShipHealth()-25));
			// do a min max thing here
			return true;
		default: return false;
		}
	}
	public boolean isGameOver() {
		if (shipAndCrew.getShipHealth() <= 0 || remainingDays <= 0 || 
			shipAndCrew.getCrewList().size() <= 0 || numberOfPiecesRemaining <= 0) {
			return true;
		}
		return false;
	}
	public boolean purchaseMedicine(MedicalSupplies item, int quantity) {
		if (item.getMedicineCost() * quantity <= shipAndCrew.getAmountMoney()) {
			shipAndCrew.setAmountMoney(shipAndCrew.getAmountMoney() - item.getMedicineCost() * quantity);
			for (int i = 0; i < quantity; i++) {
				shipAndCrew.getMedicalList().add(item);
			}
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public ArrayList<CrewMembersMainClass>  getCrewMembersList() {
		return shipAndCrew.getCrewList();
	}
	public ArrayList<FoodItems> getCrewFoodList() {
		return shipAndCrew.getFoodList();
	}
	public ArrayList<MedicalSupplies> getCrewMedicineList() {
		return shipAndCrew.getMedicalList();
	}
	public int getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(int i) {
		remainingDays = i; 
	}
	public void setNumberOfPiecesRemaining(int i) {
		numberOfPiecesRemaining = i;
	}
	public int getNumberOfPiecesRemaining() {
		return numberOfPiecesRemaining;
	}





}
