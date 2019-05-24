package main;
import java.util.ListIterator;
/**
 * The main class that implements the logic of the game and stores game attributes
 * @author Leoca
 *
 */
public class GameEnvironment {
	   /**
		 * The number of remaining days
		 */
	private int remainingDays;
	/**
	 * the current day default set to 1
	 */
	private int currentDay = 1;
	/**
	 * the number of remaining pieces that 
	 * haven't been found 
	 */
	private int numberOfPiecesRemaining;
	/**
	 * The initial number of pieces to be found
	 */
	private int initialNumberOfPieces;
	/**
	 * whether the part for the particular planet has been found
	 * initially set to false
	 */
	private boolean partFoundOnPlanet = false;
	/**
	 * new instance of class Crew
	 */
	Crew shipAndCrew = new Crew();
	/**
	 * main function that instantiates GameEnironment and
	 * launches the setup screen 
	 * @param args main call
	 */
	public static void main(String[] args) {
		GameEnvironment gameLogic = new GameEnvironment();
		gameLogic.launchSetupScreen();
	}
	public GameEnvironment() {
	}
	/**
	 * Creates a new instance of ShipMenuScreen
	 */
	public void launchShipOptionsScreen() {
		ShipMenuScreen shipMenuScreen = new ShipMenuScreen(this);
	}
	/**
	 * closes a ShipMenuScreen shipOptionsScreen
	 * @param shipOptionsScreen 	ShipMenuScreen ship option screen
	 */
	
	public void closeShipOptionsScreen(ShipMenuScreen shipOptionsScreen) {
		shipOptionsScreen.closeWindow();
	}
	/**
	 * Creates a new instance of SetupScreen called setupwindow
	 */
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	/**
	 * closes a Setup screen called setupWindow and
	 * calls the method launchShipOptionsScreen and 
	 * creates a new Ship options window and launches it
	 * @param setupWindow  SetupScreen setup window
	 */
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		launchShipOptionsScreen();
	}
	/**
	 * Creates a new instance of OutpostOptionScreen called outpostWindow
	 */
	public void launchOutpostOptionScreen() {
		OutpostOptionScreen outpostWindow = new OutpostOptionScreen(this);
	}
	/**
	 * calls the closeWindow method on outpostScreen
	 * which closes the window
	 * It then launches the ship option screen
	 * @param outpostScreen		of type OutpostOptionScreen 
	 */
	public void closeOutpostOptionScreen(OutpostOptionScreen outpostScreen) {
		outpostScreen.closeWindow();
		launchShipOptionsScreen();
	}
	/**
	 * calls the closeWindow method on end screen which closes the window
	 * @param endingScreen 	 type: EndingScreen
	 */
	public void closeEndingScreen(EndingScreen endingScreen) {
		endingScreen.closeWindow();
	}
	/**
	 * creates a new instance of EndingScreen
	 */
	public void launchEndingScreen() {
		EndingScreen endingScreen = new EndingScreen(this);
	}
	/**
	 * Gets the initialized class Crew parameter called shipAndCrew
	 * @return	Crew initialized parameter
	 */
	public Crew getShipAndCrew() {
		return shipAndCrew;
	}
	/**
	 * Gets the current day
	 * @return 		int, current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	/**
	 * Gets the remaining days for the game to be played
	 * @return 		int, remaining days
	 */
	public int getRemainingDays() {
		return remainingDays;
	}
	/**
	 * Sets the remaining days for the game to be played
	 * @param i 	int, remaining days
	 */
	public void setRemainingDays(int i) {
		remainingDays = i; 
	}
	/**
	 * Sets the number of pieces that remain to be found
	 * @param i  	int, number of remaining pieces
	 */
	public void setNumberOfPiecesRemaining(int i) {
		numberOfPiecesRemaining = i;
	}
	/**
	 * Gets the number of pieces that remain to be found
	 * @return 		int, number of remaining pieces
	 */
	public int getNumberOfPiecesRemaining() {
		return numberOfPiecesRemaining;
	}
	/**
	 * Sets whether or not a part is found for a particular planet
	 * @param booleanValue 		boolean, part found or not found 
	 */
	public void setPartFoundOnPlanet(boolean booleanValue) {
		partFoundOnPlanet = booleanValue;
	}
	/**
	 * Sets the initial number of pieces needed to be collected
	 * @param i 	int, number of pieces
	 */
	public void setInitialNumberOfPieces(int i) {
		initialNumberOfPieces = i;
	}
	/**
	 * Calls method getAmountMoney to see if crew member has enough money
	 * in which case a food item/s are added to the crews food items list
	 * otherwise the funds are insufficient and the purchase is not made
	 * @param item	FoodItems, the particular food item
	 * @param quantity	int, the quantity of food items 
	 * @return		boolean, true or false, depending on whether purchase is made
	 */
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
	/**
	 * Determines what food is selected and adjusts the hunger levels
	 * of the crew member relative to the particular food items
	 * how much the item reduces their hunger level
	 * @param food 		String, which particular food
	 * @param appliedMember, String, the current member playing
	 * @return		boolean, true or false depending if hunger levels are 0
	 * or not 0
	 */
	public boolean feed(FoodItems food, CrewMembers appliedMember) {
		if (appliedMember.getHungerLevel() != 0) {
			if (food instanceof Tea) {
				appliedMember.setHungerLevel(Math.max(appliedMember.getHungerLevel() - 5, 0));
				removeFood(food);
			} else if (food instanceof Nuts) {
				appliedMember.setHungerLevel(Math.max(appliedMember.getHungerLevel() - 10, 0));
				removeFood(food);
			} else if (food instanceof Apple) {
				appliedMember.setHungerLevel(Math.max(appliedMember.getHungerLevel() - 15, 0));
				removeFood(food);
			} else if (food instanceof Bread) {
				appliedMember.setHungerLevel(Math.max(appliedMember.getHungerLevel() - 20, 0));
				removeFood(food);
			} else if (food instanceof Soup) {
				appliedMember.setHungerLevel(Math.max(appliedMember.getHungerLevel() - 25, 0));
				removeFood(food);
			} else if (food instanceof CornedBeef) {
				appliedMember.setHungerLevel(Math.max(appliedMember.getHungerLevel() - 30, 0));
				removeFood(food);
			}
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Removes food from crew members food list
	 * @param removeFood 	FoodItems, food being removed
	 */
	public void removeFood(FoodItems removeFood)  {
		for (int i=0; i < shipAndCrew.getFoodList().size(); i++) {
			if (shipAndCrew.getFoodList().get(i) == removeFood) {
				shipAndCrew.getFoodList().remove(i);
				break;
			}
		}
	}
	/**
	 * If the ship and crew have sufficient funds to purchase medical items
	 * then the item/s are added to the crews medicine list and their amount
	 * of money is reduced
	 * @param item		String, the particular medical item
	 * @param quantity	int, the quantity of selected item
	 * @return		boolean, True or false depending if the crew has sufficient funds
	 */
	public boolean purchaseMedicine(MedicalItems item, int quantity) {
		if (item.getMedicineCost() * quantity <= shipAndCrew.getAmountMoney()) {
			shipAndCrew.setAmountMoney(shipAndCrew.getAmountMoney() - item.getMedicineCost() * quantity);
			for (int i = 0; i < quantity; i++) {
				shipAndCrew.getMedicineList().add(item);
			}
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Determines what medical item is being used and then uses the item, and thus
	 * removes it from the crews medical items list
	 * Using the medical item also decreases the crew members actions remaining
	 * @param medicine		MedicalItems, the particular medical item
	 * @param appliedMember     The particular member to which the item is being used on
	 * @return	tells player that a item is used if the item can be used, else
	 * prompts the player with a error
	 */
	public String applyMedicine(MedicalItems medicine, CrewMembers appliedMember) {

		if (medicine instanceof Antidote) {
			if (!appliedMember.getSpacePlagueStatus()) {
				return "Cannot apply Andtiode on a Member that is not infected by Space Plague";
			} else {
				appliedMember.setSpacePlagueStatus(false);
				appliedMember.setRemainingActions(appliedMember.getRemainingActions()-1);
				removeMedicine(medicine);
				return "Antidote applied to " + appliedMember.toString();
			}
		} else if (medicine instanceof MedKit) {
			if (appliedMember instanceof Juggernaut && appliedMember.getHealthLevel() < 125) {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 25, 125));
				removeMedicine(medicine);
				appliedMember.setRemainingActions(appliedMember.getRemainingActions()-1);
				return "MedKit applied to " + appliedMember.toString();
			} else if (((!(appliedMember instanceof Juggernaut)) && appliedMember.getHealthLevel() < 100)) {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 25, 100));
				removeMedicine(medicine);
				appliedMember.setRemainingActions(appliedMember.getRemainingActions()-1);
				return "MedKit applied to " + appliedMember.toString();
			} else {
				return "Cannot apply MedKit to a Member that is full health";
			}		
		} else if (medicine instanceof FirstAidKit){
			if (appliedMember instanceof Juggernaut && appliedMember.getHealthLevel() < 125) {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 15, 125));
				removeMedicine(medicine);
				appliedMember.setRemainingActions(appliedMember.getRemainingActions()-1);
				return "First-Aid Kit applied to " + appliedMember.toString();
			} else if (((!(appliedMember instanceof Juggernaut)) && appliedMember.getHealthLevel() < 100)) {
				appliedMember.setHealthLevel(Math.min(appliedMember.getHealthLevel() + 15, 100));
				removeMedicine(medicine);
				appliedMember.setRemainingActions(appliedMember.getRemainingActions()-1);
				return "First-Aid Kit applied to " + appliedMember.toString();
			} else {
				return "Cannot apply First-Aid Kit to a Member that is full health";
			}	
		}
		return null;
	} 
	/**
	 * removes medicine from crews medical item list 
	 * @param removeMed	MedicalItems, the medical item being removed
	 */
	public void removeMedicine(MedicalItems removeMed)  {
		for (int i=0; i < shipAndCrew.getMedicineList().size(); i++) {
			if (shipAndCrew.getMedicineList().get(i) == removeMed) {
				shipAndCrew.getMedicineList().remove(i);
				break;
			}
		}
	}
	/**
	 * Random chance to find a medical item
	 * @return	the item found
	 */
	public String addRandomMedicine() {
		switch((int)(Math.random() * 2 + 1)) {
		case 1: shipAndCrew.getMedicineList().add(new FirstAidKit());
		return " found a First-Aid Kit";
		case 2: shipAndCrew.getMedicineList().add(new Antidote());
		return " found an Antidote";
		default: return null;
		}
	}
	/**
	 * Random chance to find a food item
	 * @return	the item found
	 */
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
	/**
	 * Initiates a member to search for parts, random chance event occurs
	 * @param member	CrewMembers, member searching for parts
	 * @return		item that is found when search or a prompt saying that
	 * the crew member has no actions remaining
	 */
	public String searchForParts(CrewMembers member) {
		if (member.getRemainingActions() >= 1 ) {
			member.setRemainingActions(member.getRemainingActions()-1);
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
			case 4:
				if (member instanceof Archeologist) {
					shipAndCrew.setAmountMoney(shipAndCrew.getAmountMoney()+100);
					return " used his skills t	o find $100";
				} else {
					return " found nothing";
				}
			case 5:	return addRandomMedicine();
			}
		}
		return " has no actions remaining";
	}
	/**
	 * Creates a random chance for a event to occur, resulting in different
	 * changes to the crew members inventory and possible infections of space plague
	 * @return	the random event that occurs
	 */
	public String newDayEvent() {
		switch((int)(Math.random() * 2 + 1)) {
		case 1:
			if (shipAndCrew.getFoodList().size() == 0 && shipAndCrew.getMedicineList().size() == 0) {
				return "Alien pirates arrives but you had nothing for them to steal";
			} else {
				if (shipAndCrew.getFoodList().size() != 0) {
					return "Alien Pirates have arrived on your ship and have stolen " + shipAndCrew.getFoodList().remove((int)(Math.random() * shipAndCrew.getFoodList().size()));
				} else {
					return "Alien Pirates have arrived on your ship and have stolen a " + shipAndCrew.getMedicineList().remove((int)(Math.random() * shipAndCrew.getMedicineList().size()));
				}
			}
		case 2:
			for (CrewMembers i: shipAndCrew.getMembersList()) {
				if(!i.getSpacePlagueStatus()) {
					i.setSpacePlagueStatus(true);
					return i.toString() + " has been infected with space plague";
				}
			}
			return "Space Plague has spread to your ship but all your crew members already have been infected";
		}
		return null;
	}
	/**
	 * All the daily changes to each crew members stats,
	 * current days are increased and remaining days are decreased
	 */
	public void newDayChanges() {
		for (int i = 0; i < shipAndCrew.getMembersList().size(); i++) {
			shipAndCrew.getMembersList().get(i).setHungerLevel(Math.min(shipAndCrew.getMembersList().get(i).getHungerLevel() + 20, 100));
			shipAndCrew.getMembersList().get(i).setTiredNessLevel(Math.min(shipAndCrew.getMembersList().get(i).getTirednessLevel() + 20, 100));
			if (shipAndCrew.getMembersList().get(i).getHealthLevel() > 0) {
				shipAndCrew.getMembersList().get(i).setHealthLevel(Math.max(shipAndCrew.getMembersList().get(i).getHealthLevel() - 15, 0));
				if (shipAndCrew.getMembersList().get(i).getSpacePlagueStatus()) {
					shipAndCrew.getMembersList().get(i).setHealthLevel(Math.max(shipAndCrew.getMembersList().get(i).getHealthLevel() - 5, 0));
				}
			}
		}
		for (CrewMembers i: shipAndCrew.getMembersList()) {
			i.setRemainingActions(2);
		}
		currentDay += 1;
		remainingDays -= 1;
	}
	/**
	 * Decreases crew members daily actions by 1 such that the crew member
	 * has 100 tiredness level
	 * @return	prompt letting player know crew member has less actions
	 */
	public String removeActionsTooTired() {
		String str1 = "";
		for (CrewMembers i: shipAndCrew.getMembersList()) {
			if (i.getTirednessLevel() >= 100) {
				str1 += i.toString() + ", ";
				i.setRemainingActions(1);
			}
		} if (str1 != "") {
			str1 += " now have 1 action because they are too tired";
		}
		return str1;
	}
	/**
	 * Decreases crew members daily actions by 1 such that the crew member
	 * has 100 Hunger level
	 * @return	prompts letting player know crew member has less actions
	 */
	public String removeActionsTooHungry() {
		String str1 = "";
		for (CrewMembers i: shipAndCrew.getMembersList()) {
			if (i.getHungerLevel() >= 100) {
				str1 += i.toString() + ", ";
				i.setRemainingActions(1);
			}
		} if (str1 != "") {
			str1 += " now have 1 action because they are too hungry";
		}
		return str1;
	}
	/**
	 * Removes a crew member if the crew member dies, i.e
	 * the crew members Health level less than 0
	 * @return	prompt alerting player that the crew member has died
	 * and removed from the crew
	 */
	public String removeDeadCrewMembers() {
		String str1 = "";
		ListIterator<CrewMembers> listIterator = shipAndCrew.getMembersList().listIterator();
		while (listIterator.hasNext()) {
			CrewMembers member = listIterator.next();
			if (member.getHealthLevel() == 0) {
				str1 += member.toString() + ", ";
				listIterator.remove();
			}
		}
		if (str1 != "") {
			str1 += " Have been removed from the Crew as their health level has reached 0";
		}
		return str1;
	}
	/**
	 *  Travels crew to new planet, decreasing the 2 pilots
	 *  actions by 1 each, and initializes the parts found planet
	 *  to false. Also creates a random chance for ship damage to occur
	 * @param member1  	one of the crew members
	 * @param member2	one of the crew members
	 * @return	boolean, true or false depending on whether 
	 * or not asteroid damage occurs
	 */
	public boolean newPlanet(CrewMembers member1, CrewMembers member2) {
		member1.setRemainingActions(member1.getRemainingActions()-1);
		member2.setRemainingActions(member2.getRemainingActions()-1);
		setPartFoundOnPlanet(false);
		switch((int)(Math.random() * 3 + 1)) {
		case 1:	asteroidBeltDamage();
			return true;
		default: return false;
		}
	}
	/**
	 * Calculates the damage the ship takes from the asteroid
	 * and applys the damage to the ships shield
	 */
	public void asteroidBeltDamage() {
		int calculion = (int) ((Math.floor((((float) 25 / shipAndCrew.getShipHealth())) * 4 + 20)));
		shipAndCrew.setShipHealth(shipAndCrew.getShipHealth()- calculion);
	}
	/**
	 * Implements ship repairing
	 * @param member	specific crew member
	 * @return	a prompt as to what action has occurred
	 */
	public String repairShip(CrewMembers member) {
		if (shipAndCrew.getShipHealth() < 100) {
			if (member.getRemainingActions() >= 1) {
				member.setRemainingActions(member.getRemainingActions()-1);
				if (member instanceof Engineer) {
					shipAndCrew.setShipHealth(Math.min(shipAndCrew.getShipHealth() + 50, 100));
					return member.toString() + " has used their skill and repaird a lot of damage to the ship";
				} else {
					shipAndCrew.setShipHealth(Math.min(shipAndCrew.getShipHealth() + 15, 100));
					return member.toString() + " has made some repairs to the ship";
				}
			} else {
				return member.toString() + " has no actions remaining";
			}
		} else {
			return member.toString() + " cannot repair the ship any further as it is already at full health";
		}
	}
	/**
	 * implements the sleep option
	 * @param member	a specific crew member
	 * @return	a prompt to the player depending on the
	 * tiredness level and the actions remaining
	 */
	public String haveMemberSleep(CrewMembers member) {
		if (member.getTirednessLevel() > 0) {
			if (member.getRemainingActions() >= 1) {
				member.setRemainingActions(member.getRemainingActions()-1);
				member.setTiredNessLevel(Math.max(member.getTirednessLevel() - 50, 0));
				return member.toString() + " is now less tired";
			}
			return member.toString() + " has no actions remaining";
		} else {
			return member.toString() + " is not tired enough to need to sleep";
		}
	}
	/**
	 * Determines if part is found on planet
	 * @return	either yes or no depending on whether its there
	 */
	public String foundPartOnPlanetYesNo() {
		if (partFoundOnPlanet) {
			return "Yes";
		} else {
			return "No";
		}
	}
	/**
	 * Determines whether or not a crew member has space plague
	 * @param member	A specific crew member
	 * @return		status of either Infected, or No infection
	 */
	public String spacePlagueYesNo(CrewMembers member) {
		if (member.getSpacePlagueStatus()) {
			return "Infected";
		} else {
			return "No Infection";
		}
	}
	/**
	 * Gets the inventory and all the items within
	 * @return	all the items in the inventory
	 */
	public String getInvetory() {
		int antidoteQuan = 0;
		int firstAidQuan = 0;
		int medKitQuan = 0;
		int teaQuan = 0;
		int nutsQuan = 0;
		int applesQuan = 0;
		int breadQuan = 0;
		int soupQuan = 0;
		int cornedBeefQuan = 0;
		for (MedicalItems i: shipAndCrew.getMedicineList()) {
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
	/**
	 * Determines if game is over
	 * @return	true or false if game is over
	 */
	public boolean isGameOver() {
		if (shipAndCrew.getShipHealth() <= 0 || remainingDays == 0 || 
			shipAndCrew.getMembersList().size() <= 0 || numberOfPiecesRemaining <= 0) {
			return true;
		}
		return false;
	}
	/**
	 * Calculates and returns the game score
	 * @return	game score
	 */
	public int getGameScore() {
		int calculation =  (int) (((initialNumberOfPieces / (numberOfPiecesRemaining + 1)) * 300 * (remainingDays * 5))+ (shipAndCrew.getAmountMoney() * 10));
		return calculation;
	}
}
