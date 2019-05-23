import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.TreeSet;

public class GameEnvironment {
	private int remainingDays;
	private int currentDay = 1;
	private int numberOfPiecesRemaining;
	private boolean partFoundOnPlanet = false;
	TreeSet<FoodItems> foodInventory = new TreeSet<FoodItems>();
	TheShipClass shipAndCrew = new TheShipClass();

	public static void main(String[] args) {
		GameEnvironment gameLogic = new GameEnvironment();
		gameLogic.launchSetupScreen();
	}
	public GameEnvironment() {
	}
	public void launchShipOptionsScreen() {
		ShipMenuScreen shipMenuScreen = new ShipMenuScreen(this);
	}
	public void closeShipOptionsScreen(ShipMenuScreen shipOptionsScreen) {
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
	public void feed(FoodItems food, CrewMembersMainClass appliedMember) {
		// DOESNT CHANGE THE VALUES ATM
		if (food instanceof Tea) {
			removeFood(food);
		} else if (food instanceof Nuts) {
			removeFood(food);
		} else if (food instanceof Apple) {
			removeFood(food);
		} else if (food instanceof Bread) {
			removeFood(food);
		} else if (food instanceof Soup) {
			removeFood(food);
		} else if (food instanceof CornedBeef) {
			removeFood(food);
		}
	}
	public void applyMedicine(MedicalSupplies medicine, CrewMembersMainClass appliedMember) {
		// THE + 25/15 VALUES SHOULD BE THE GET HEALTH TREATMENT FROM ITS CLASS AND THE 100 VALUE SHOULD
		// BE GET HEALTH OF CREW MEMBER
		if (medicine instanceof Antidote) {
			appliedMember.setSpacePlagueStatus(false);
			removeMedicine(medicine);
		} else if (medicine instanceof MedKit) {
			if (appliedMember instanceof Juggernaut) {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 25, 125));
				removeMedicine(medicine);
			} else {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 25, 100));
				removeMedicine(medicine);
			}
		} else if (medicine instanceof FirstAidKit){
			if (appliedMember instanceof Juggernaut) {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 15, 125));
				removeMedicine(medicine);
			} else {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 15, 100));
				removeMedicine(medicine);
			}
		}
	} 
	public String newDayEvent() {
		switch((int)(Math.random() * 2 + 1)) {
		// *3 means in range of 3, the +1 means +1 to the answer, otherwise it would be 0,1,2 instead of 1,2,3
		case 1:
			if (shipAndCrew.getFoodList().size() == 0 && shipAndCrew.getMedicalList().size() == 0) {
				return "Alien pirates arrives but you had nothing for them to steal";
			} else {
				if (shipAndCrew.getFoodList().size() != 0) {
					return "Alien Pirates have arrived on your ship and have stolen " + shipAndCrew.getFoodList().remove((int)(Math.random() * shipAndCrew.getFoodList().size()));
				} else {
					return "Alien Pirates have arrived on your ship and have stolen a " + shipAndCrew.getMedicalList().remove((int)(Math.random() * shipAndCrew.getMedicalList().size()));
				}
			}
		case 2:
			for (CrewMembersMainClass i: shipAndCrew.getCrewList()) {
				if(!i.getSpacePlagueStatus()) {
					i.setSpacePlagueStatus(true);
					return i.toString() + " has been infected with space plague";
				}
			}
			return "Space Plague has spread to your ship but all your crew members already have been infected";
		}
		return null;
	}
	public void newDayChanges() {
		for (int i = 0; i < shipAndCrew.getCrewList().size(); i++) {
			shipAndCrew.getCrewList().get(i).setHungerLevel(Math.min(shipAndCrew.getCrewList().get(i).getHungerLevel() + 20, 100));
			shipAndCrew.getCrewList().get(i).setTiredNessLevel(Math.min(shipAndCrew.getCrewList().get(i).getTirednessLevel() + 20, 100));
			if (shipAndCrew.getCrewList().get(i).getHealthLevel() > 0) {
				shipAndCrew.getCrewList().get(i).setHealthLevel(Math.max(shipAndCrew.getCrewList().get(i).getHealthLevel() - 20, 0));
				if (shipAndCrew.getCrewList().get(i).getSpacePlagueStatus()) {
					shipAndCrew.getCrewList().get(i).setHealthLevel(Math.max(shipAndCrew.getCrewList().get(i).getHealthLevel() - 5, 0));
				}
			}
		}
		setAllCrewmembersActions();
		currentDay += 1;
		remainingDays -= 1;
		//iterates throught the arraylist and removes any crew members who health is 0, can only be done using listiterator
		for (CrewMembersMainClass i: shipAndCrew.getCrewList()) {
			if (i.getTirednessLevel() >= 100) {
				System.out.println("has 1 action now");
				i.setCrewActions(1);
			} else if (i.getHungerLevel() >= 100) {
				System.out.println("has 1 action now");
				i.setCrewActions(1);
			}
		}
	}
	public String removeDeadCrewMembers() {
		String str1 = "";
		ListIterator<CrewMembersMainClass> listIterator = shipAndCrew.getCrewList().listIterator();
		while (listIterator.hasNext()) {
			CrewMembersMainClass member = listIterator.next();
			if (member.getHealthLevel() == 0) {
				str1 += member.toString() + ", ";
				listIterator.remove();
			}
		}
		if (str1 != "") {
			str1 += " Have been removed from the Crew";
		}
		return str1;
	}
	public String searchForParts(CrewMembersMainClass member) {
		if (member.getCrewActions() > 0 ) {
			member.setCrewActions(member.getCrewActions()-1);
			switch((int)(Math.random() * 5 + 1)) {
			case 1: return addRandomFood();
			case 2:
			if (!partFoundOnPlanet) {
				numberOfPiecesRemaining -= 1;
				partFoundOnPlanet = true;
				return " found a Spaceship Part";
			} else {
				return " found nothing";
			}
			case 3:	shipAndCrew.setAmountMoney(shipAndCrew.getAmountMoney()+10);
			return " found $10";
			case 4: return " found nothing";
			case 5:	return addRandomMedicine();
			}
		}
		return " has no actions remaining";
	}
	public String addRandomMedicine() {
		switch((int)(Math.random() * 2 + 1)) {
		case 1: shipAndCrew.getMedicalList().add(new FirstAidKit());
		return " found a First-Aid Kit";
		case 2: shipAndCrew.getMedicalList().add(new Antidote());
		return " found an Antidote";
		default: return null;
		}
	}
	public String addRandomFood() {
		switch((int)(Math.random() * 3 + 1)) {
		case 1: shipAndCrew.getFoodList().add(new Tea());
			return " found Tea";
		case 2: shipAndCrew.getFoodList().add(new Nuts()); 
			return " found Nuts";
		case 3: shipAndCrew.getFoodList().add(new Apple());
			return " found an Apple";
		default: return null;
		}
	}
	public void setAllCrewmembersActions() {
		for (CrewMembersMainClass i: shipAndCrew.getCrewList()) {
			i.setCrewActions(2);
		}
	}
	public boolean newPlanet(CrewMembersMainClass member1, CrewMembersMainClass member2) {
		member1.setCrewActions(member1.getCrewActions()-1);
		member2.setCrewActions(member2.getCrewActions()-1);
		setPartFoundOnPlanet(false);
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
	public String spacePlagueYesNo(CrewMembersMainClass member) {
		if (member.getSpacePlagueStatus()) {
			return "Infected";
		} else {
			return "No Infection";
		}
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
	public boolean purchaseFood(FoodItems item, int quantity) {
		if (item.getfoodCost() * quantity <= shipAndCrew.getAmountMoney()) {
			shipAndCrew.setAmountMoney(shipAndCrew.getAmountMoney() - item.getfoodCost() * quantity);
			for (int i = 0; i < quantity; i++) {
				shipAndCrew.getFoodList().add(item);
			}
			return true;
		} else {
			return false;
		}
	}
	public void removeMedicine(MedicalSupplies removeMed)  {
		for (int i=0; i < shipAndCrew.getMedicalList().size(); i++) {
			if (shipAndCrew.getMedicalList().get(i) == removeMed) {
				shipAndCrew.getMedicalList().remove(i);
				break;
			}
		}
	}
	public void removeFood(FoodItems removeFood)  {
		for (int i=0; i < shipAndCrew.getFoodList().size(); i++) {
			if (shipAndCrew.getFoodList().get(i) == removeFood) {
				shipAndCrew.getFoodList().remove(i);
				break;
			}
		}
	}
	public void remove1Action(CrewMembersMainClass member) {
		member.setCrewActions(member.getCrewActions()-1);
	}	
	public String getFoodFrequency() {
		int antidoteQuan = 0;
		int firstAidQuan = 0;
		int medKitQuan = 0;
		int teaQuan = 0;
		int nutsQuan = 0;
		int applesQuan = 0;
		int breadQuan = 0;
		int soupQuan = 0;
		int cornedBeefQuan = 0;
		for (MedicalSupplies i: shipAndCrew.getMedicalList()) {
			if (i instanceof Antidote) {
				antidoteQuan += 1;
			} else if (i instanceof FirstAidKit) {
				firstAidQuan += 1;
			} else if (i instanceof MedKit) {
				medKitQuan += 1;
			}
		}
		for (FoodItems i: shipAndCrew.getFoodList()) {
			if (i instanceof Tea) {
				teaQuan += 1;
			} else if (i instanceof Nuts) {
				nutsQuan += 1;
			} else if (i instanceof Apple) {
				applesQuan += 1;
			} else if (i instanceof Bread) {
				breadQuan += 1;
			} else if (i instanceof Soup) {
				soupQuan += 1;
			} else if (i instanceof CornedBeef) {
				cornedBeefQuan += 1;
			}
		}
		return "<html>" + "Antidote Quantity: " + antidoteQuan + "<br>" + "First-Aid Quantity: " + firstAidQuan + "<br>" +
		"Med Kit Quantity: " + medKitQuan + "<br>" + "Tea Quantity: " + teaQuan + "<br>" + "Nuts Quantity: " + nutsQuan + "<br>" +
		"Apples Quantity: " + applesQuan + "<br>" + "Bread Quantity: " + breadQuan + "<br>" + "Soup Quantity: " + soupQuan + "<br>" +
		"Corned Beef Quantity: " + cornedBeefQuan + "</html>";
	}
	public boolean repairShip(CrewMembersMainClass member) {
		if (member.getCrewActions() >= 1) {
			member.setCrewActions(member.getCrewActions()-1);
			shipAndCrew.setShipHealth(Math.min(shipAndCrew.getShipHealth() + 15, 100));
			return true;
		} else {
			return false;
		}
	}
	public boolean memberSleep(CrewMembersMainClass member) {
		if (member.getCrewActions() >= 1) {
			member.setCrewActions(member.getCrewActions()-1);
			member.setTiredNessLevel(Math.max(member.getTirednessLevel() - 50, 0));
			return true;
		}
		return false;
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
	public int getCurrentDay() {
		return currentDay;
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
	public String foundPartOnCurrentPlanet() {
		if (partFoundOnPlanet) {
			return "Yes";
		} else {
			return "No";
		}
	}





}
