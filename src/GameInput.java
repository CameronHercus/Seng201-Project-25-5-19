import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class GameInput {
    public GameInput() {
    	ArrayList<CrewMembersMainClass> classList = new ArrayList<CrewMembersMainClass>();
		Haggler haggler = new Haggler();
		Medic medic = new Medic();
		Thief thief = new Thief();
		classList.add(medic);
		classList.add(haggler);
		classList.add(thief);
		//will launch the setup part of the game
		initializeSetup(classList);
	}
	private void initializeSetup(ArrayList<CrewMembersMainClass> classList) {
		// initializes the scanner to be used for the prompts
		Scanner scanner = new Scanner(System.in);
		// initializes finalCrew
		TheShipClass finalCrew = new TheShipClass();
	    // prompts user for how many days they would like to play must be within 3-10
	    boolean found = false;
	    while (!found) {
		    System.out.println("*You can play the game for anywhere between 3-10 days!*" + "\n" + "Please enter how many days would you like to play below");
		    int intputShipDays = scanner.nextInt();
	    	switch (intputShipDays) {
	    	case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
	    		finalCrew.setNumberOfDays(intputShipDays);
	    		found = true;
	    		break;
	    	default:
	    		System.out.println("Please enter a valid number of days" + "\n");
	    		break;
	    	}
	    }
	    // rounds down the number to give the number of pieces to find
	    int numberOfPieces = (int) (Math.floor(finalCrew.getNumberOfDays() * (float) 2/3));
	    finalCrew.setNumberOfPieces(numberOfPieces);
	    //Names the ship maybe it should have error catching not sure
	    System.out.println("\n" + "Please enter what you would like your Spaceship to be called!");
	    String inputShipName = scanner.next();
	    finalCrew.setShipName(inputShipName);
	    //prints the toString of the crew classes to chose from
	    int counter = 0;
	    System.out.println("\n" + "These are the types of crew members you can add:");
	    for (CrewMembersMainClass i: classList) {
	    	counter += 1;
	    	System.out.println(counter + ": " + i.toString());
	    }
	    // prompts user how many crew members they want
	    found = false;
	    while (!found) {
		    System.out.println("\n" + "*You may chose anywhere between 2-4 crew members*");
		    System.out.println("How many crew members would you like?");
		    int inputCrewMemberCount = scanner.nextInt();
	    	switch (inputCrewMemberCount) {
	    	case 2: case 3: case 4:
	    		finalCrew.setStartingMemberCount(inputCrewMemberCount);
	    		found = true;
	    		break;
	    	default:
	    		System.out.println("Please enter a valid number of crew members" + "\n");
	    		break;
	    	}
	    }
	    // prompts the user to enter the classes the while loop ensures that it keeps going until the amount of members they asked for it filled
	    System.out.println("\n" + "*You may enter the same Class more than once*");
	    counter = 0;
	    while (counter < finalCrew.getstartingMemberCount()) {
		    System.out.println("You are now adding Class number " + (counter + 1) +": Enter the NUMBER associated with the class you would like to add");
		    int classInputName = scanner.nextInt();
		   switch (classInputName) {
		   case 1:  
			   counter+=1;
			   System.out.println("\n" + "*You have chosen the Medic class*" + "\n" + "What would you like to name this Crew Member?");
			   String medicClassName = scanner.next();
			   finalCrew.addCrewMember(new Medic(medicClassName));
			   break; 			   
			   // need to find out how to keep placement number and name implementation not sure how to do atm 
		   case 2:
			   System.out.println("\n" + "*You have chosen the Haggler class*" + "\n" + "What would you like to name this Crew Member?");
			   String hagglerClassName = scanner.next();
			   finalCrew.addCrewMember(new Haggler(hagglerClassName));
			   counter+=1;
			   break;
		   case 3:
			   System.out.println("\n" + "*You have chosen the Thief class*" + "\n" + "What would you like to name this Crew Member?");
			   String thiefClassName = scanner.next();
			   finalCrew.addCrewMember(new Thief(thiefClassName));
			   counter+=1;
			   break;
		   default:
			   System.out.println("Invalid Class. Please add a name from the list" + "\n");
			   break;			
		   }
	    }
		// this will launch the main game
		intializeMainGame(finalCrew, scanner);
	}
	
	
	
	
	
	public void intializeMainGame(TheShipClass finalCrew, Scanner scanner) {
		ArrayList<MedicalSupplies> buyableMedicineList = new ArrayList<MedicalSupplies>();
		
		Antidote antidote = new Antidote();
		MedKit medKit = new MedKit();
		FirstAidKit firstAidKit = new FirstAidKit();
		buyableMedicineList.add(antidote);
		buyableMedicineList.add(medKit);
		buyableMedicineList.add(firstAidKit);
		
		
		
		
		System.out.println("\n" + "Enter the number from the options list to proceed:" + "\n" + 
		"1: View the status of your crew Members" + "\n" + 
		"2: Proceed with activities" + "\n" +
		"3: Visit nearest outpost");
		int inputProceed = scanner.nextInt();
		switch (inputProceed) {
		case 1:
			intializeView(finalCrew, scanner);
			break;
		case 2:
			initializeActivites();
			break;
		case 3:
			initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
			break;
		default:
			System.out.println("Please select a valid option number");
			break;
			// not sure if break matters here
			
		}
		intializeMainGame(finalCrew, scanner);
		
		
	}
	
	
	
	public void intializeView(TheShipClass finalCrew, Scanner scanner) {
		for (CrewMembersMainClass i: finalCrew.getCrewList()) {
			System.out.println(i.toStatus());
		}
		System.out.println(finalCrew.getShipName() + " Status: ");
		//not complete
		intializeMainGame(finalCrew, scanner);
	}
	
	
	
	
	
	
	
	
	public void initializeActivites() {
		System.out.println("Not implemented yet");
	}
	
	
	
	
	
	
	public void initializeNearestOutpost(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList) {
		System.out.println("\n" + "You are at the nearest outpost select what to do next from the options below:" + "\n" +
	"1: View objects, such as food and medical supplies that are for sale" + "\n" + 
	"2: View your current inventory and amount of money" + "\n" + 
	"3: See the prices of each object" + "\n" + 
	"4: Inspect each object" + "\n" + 
	"5: Purchase medical supplies, objects and food" + "\n" +
	"6: Return to Ship");
		
		// MAYBE ADD OPTION TO GO BACK?
		
		int inputOutpost = scanner.nextInt();
		switch (inputOutpost) {
		case 1:
			intializeViewItemsForSale(finalCrew, scanner, buyableMedicineList);
			break;
		case 2:
			intializeViewOfInventory(finalCrew, scanner, buyableMedicineList);
			break;
		case 3:
			intializezViewItemPrices(finalCrew, scanner, buyableMedicineList);
			break;
		case 4:
			intializezItemInspect(finalCrew, scanner, buyableMedicineList);
			break;
		case 5:
			intializeShop(finalCrew, scanner, buyableMedicineList);
			break;
		case 6:
			intializeMainGame(finalCrew, scanner);
			break;
			// dont think this is good maybe doest get rid of the switch here
			
		default:
			initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
			break;
		}
	}
	
	
	
	
	
	
	
	
	public void intializeViewItemsForSale(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList) {
		System.out.println("The items for sale are:");
		for (MedicalSupplies i: buyableMedicineList) {
			System.out.println(i);
		}
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
	}
	
	public void intializeViewOfInventory(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList) {
		if (finalCrew.getMedicalList().size() == 0) { //&&foodlist)
			System.out.println("Your inventory is currently empty visit a Shop at an Outpost to purchase Medicine and Food!");
		}
		for (MedicalSupplies i: finalCrew.getMedicalList()) {
			System.out.println(i);
		}
		System.out.println("Amount of Money: " + "$" + finalCrew.getAmountMoney());
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
	}
	
	public void intializezViewItemPrices(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList) {
		System.out.println("The prices of the items for sale are:");
		for (MedicalSupplies i: buyableMedicineList) {
			System.out.println(i.getMedicineName() + " Costs:  $" + i.getMedicineCost());
		}
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
	}
	public void intializezItemInspect(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList) {
		System.out.println("Descriptions of the items for sale:");
		for (MedicalSupplies i: buyableMedicineList) {
			System.out.println(i.getDescription());
		}
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
	}
	
	public void intializeShop(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList) {
		System.out.println("\n" + "You are at the shop select what to do next from the options below:" + "\n" +
		"1: Antidote: cures space plague costs: $15" + "\n" + "2: MedKit: restores 50 health, costs $20" + "\n" + 
		"3: FirstAidKit: restores 25 Health, costs $10" + "\n" + "4: Return to outpost?");
		int inputShop = scanner.nextInt();
		switch (inputShop) {
		
		case 1:
			System.out.println("What quantity of Antidote would you like?");
			int antidoteQuan = scanner.nextInt();
			if (finalCrew.doesPriceExceed(buyableMedicineList.get(0).getMedicineCost(), antidoteQuan)) {
				finalCrew.addMedicalItem(buyableMedicineList.get(0), buyableMedicineList.get(0).getMedicineCost(), antidoteQuan);
			}
			else {
				System.out.println("Your funds are too low for this purchase");
			}
			break;
		case 2:
			System.out.println("What quantity of MedKits would you like?");
			int medkitQuan = scanner.nextInt();
			if (finalCrew.doesPriceExceed(buyableMedicineList.get(1).getMedicineCost(), medkitQuan)) {
				finalCrew.addMedicalItem(buyableMedicineList.get(1), buyableMedicineList.get(1).getMedicineCost(), medkitQuan);
			}
			else {
				System.out.println("Your funds are too low for this purchase");
			}
			break;
		case 3:
			System.out.println("What quantity of First-Aid Kits would you like?");
			int firstaidkitQuan = scanner.nextInt();
			if (finalCrew.doesPriceExceed(buyableMedicineList.get(2).getMedicineCost(), firstaidkitQuan)) {
				finalCrew.addMedicalItem(buyableMedicineList.get(2), buyableMedicineList.get(2).getMedicineCost(), firstaidkitQuan);
			}
			else {
				System.out.println("Your funds are too low for this purchase");
			}
			break;
		case 4: 
			initializeNearestOutpost(finalCrew, scanner, buyableMedicineList);
			break;
		default: 
			System.out.println("Your funds are too low for this purchase");
			break;
			
			
		}
		intializeShop(finalCrew, scanner, buyableMedicineList);
		// add like this
		
		
	}
	
	
	
	
	
	
	
	 public static void main (String[] args) {
		 GameInput gameInputSetup = new GameInput();
		 //this needs to be put in the class that will showcase either input or gui and will call this to use the input
	 }
}
