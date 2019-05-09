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
		Scanner input = new Scanner(System.in);
	    
	    boolean found;
	    /*
	     * I N P U T     F O R    D A Y S
	     * I N P U T     F O R    D A Y S
	     */
	    found = false;
	    while (!found) {
	    	System.out.println("*You can play the game for anywhere between 3-10 days!*" + "\n" + "Please enter how many days would you like to play below");
	        try {
	            int a = input.nextInt();
	            if (3 <= a && a <= 10) {
	            	finalCrew.setNumberOfDays(a);
	            	found = true;
	            } else {
	            	System.out.println("Please enter a valid number of days" + "\n");
	            }
	        }
	        catch (java.util.InputMismatchException e) {
	            input.nextLine();
	            System.out.println("Input must be a number" + "\n");
	        }
	    }
	    /*
	     * N U M B E R     O F    P I E C E S   C A L C U L A T I O N
	     * N U M B E R     O F    P I E C E S   C A L C U L A T I O N
	     */
	    // rounds down the number to give the number of pieces to find
	    int numberOfPieces = (int) (Math.floor(finalCrew.getNumberOfDays() * (float) 2/3));
	    finalCrew.setNumberOfPieces(numberOfPieces);  
	    /*
	     * I N P U T   N A M E   O F    S H I P
	     * I N P U T   N A M E   O F    S H I P
	     */
	    found = false;
	    while (!found) {
	    	 System.out.println("\n" + "Please enter what you would like your Spaceship to be called!");
	        try {
	        	 String inputShipName = scanner.next();
	     	    finalCrew.setShipName(inputShipName);
	     	    found = true;
	        }
	        catch (java.util.InputMismatchException e) {
	            input.nextLine();
	            System.out.println("Input name for ship name was rejected try something different!" + "\n");
	        }
	    }
	    /*
	     * C R E W    S I Z E    S E L E C T I O N
	     * C R E W    S I Z E    S E L E C T I O N
	     */
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
	    /*
	     * C L A S S     S E L E C T I O N
	     * C L A S S     S E L E C T I O N
	     */
	    // prompts the user to enter the classes the while loop ensures that it keeps going until the amount of members they asked for it filled
	    // THIS AINT ELIF YET
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
		ArrayList<FoodItems> buyableFoodList = new ArrayList<FoodItems>();
		Bread bread = new Bread();
		Soup soup = new Soup();
		CornedBeef cornedbeef = new CornedBeef();
		Nuts nuts = new Nuts();
		Tea tea = new Tea();
		Apple apple = new Apple();
		buyableFoodList.add(bread);
		buyableFoodList.add(soup);
		buyableFoodList.add(cornedbeef);
		buyableFoodList.add(apple);
		buyableFoodList.add(tea);
		buyableFoodList.add(nuts);
	    boolean found = false;
	    while (!found) {
			System.out.println("\n" + "You are at your Ship enter a number from the options list to proceed:" + "\n" + 
					"1: View the status of your crew Members" + "\n" + 
					"2: Move on to the next day" + "\n" +
					"3: Visit nearest outpost" + "\n" +
					"4: View the status of your ship" + "\n" +
					"The following activities will require actions to perform:" + "\n" +
					"5: Have a creww member Eat food or Use medical Supplies from the ship's inventory" + "\n" +
					"6: Have a Crew Member sleep" + "\n" +
					"7: Have a Crew Member repair the ship" + "\n" +
					"8: Have a Crew Member search the planet for spaceship parts" + "\n" +
					"9: Have two Crew Members pilot the ship to a new Planet" + "\n" +
					"Your crew members have the following remaing amount of actions for today:" +  "\n" +
					finalCrew.printAllActions());
	        try {
	        	int optionsAtShip = scanner.nextInt();
	     	    if (optionsAtShip == 1) {
	     	    	found = true;
	     	    	intializeCrewView(finalCrew, scanner);
	     	    } else if (optionsAtShip == 2) {	 
	     	    	found = true;
	     	    	finalCrew.setNumberOfDays(finalCrew.getNumberOfDays()-1);
	     	    	// ya not complete number of days should be in the enviornment its just temp
	     	    } else if (optionsAtShip == 3) {
	     	    	found = true;
	     	    	initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else if (optionsAtShip == 4) {
	     	    	found = true;
	     	    	initializeShipView(finalCrew, scanner);
	     	    } else {
	     	    	System.out.println("Please enter a valid number from the list of options" + "\n");
	     	    }
	        }
	        catch (java.util.InputMismatchException e) {
	            scanner.nextLine();
	            System.out.println("Input must be a number" + "\n");
	        }
	    }	
	}
	public void intializeCrewView(TheShipClass finalCrew, Scanner scanner) {
		for (CrewMembersMainClass i: finalCrew.getCrewList()) {
			System.out.println(i.toStatus());
		}
		intializeMainGame(finalCrew, scanner);
	}
	public void initializeShipView(TheShipClass finalCrew, Scanner scanner) {
		System.out.println(finalCrew.getShipName() + " Status: ");
		// not finished need to add a percentage to ship health
		intializeMainGame(finalCrew, scanner);
	}
	public void initializeActivites() {
		System.out.println("Not implemented yet");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void initializeNearestOutpost(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList, ArrayList<FoodItems> buyableFoodList) {
	    boolean found = false;
	    while (!found) {
			System.out.println("\n" + "You are at the nearest outpost select what to do next from the options below:" + "\n" +
					"1: View objects, such as food and medical supplies that are for sale" + "\n" + 
					"2: View your current inventory and amount of money" + "\n" + 
					"3: See the prices of each object" + "\n" + 
					"4: Inspect each object" + "\n" + 
					"5: Purchase medical supplies, objects and food" + "\n" +
					"6: Return to Ship");
	        try {
	    		int inputOutpost = scanner.nextInt();
	     	    if (inputOutpost == 1) {
	     	    	found = true;
	     	    	intializeViewItemsForSale(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else if (inputOutpost == 2) {	 
	     	    	found = true;
	     	    	intializeViewOfInventory(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else if (inputOutpost == 3) {
	     	    	found = true;
	     	    	intializezViewItemPrices(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else if (inputOutpost == 4) {
	     	    	found = true;
	     	    	intializezItemInspect(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else if (inputOutpost == 5) {
	     	    	found = true;
	     	    	intializeShop(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else if (inputOutpost == 6) {
	     	    	found = true;
	     	    	intializeMainGame(finalCrew, scanner);
	     	    } else {
	     	    	System.out.println("Please enter a valid number from the list of options" + "\n");
	     	    }
	        }
	        catch (java.util.InputMismatchException e) {
	            scanner.nextLine();
	            System.out.println("Input must be a number" + "\n");
	        }
	    }
	}	
	public void intializeViewItemsForSale(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList, ArrayList<FoodItems> buyableFoodList) {
		System.out.println("The items for sale are:");
		for (MedicalSupplies i: buyableMedicineList) {
			System.out.println(i);
		}
		for (FoodItems i: buyableFoodList) {
			System.out.println(i);
			
		}
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	}
	public void intializeViewOfInventory(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList, ArrayList<FoodItems> buyableFoodList) {
		if (finalCrew.getMedicalList().size() == 0) { //&&foodlist)
			System.out.println("Your inventory is currently empty visit a Shop at an Outpost to purchase Medicine and Food!");
		}
		for (MedicalSupplies i: finalCrew.getMedicalList()) {
			System.out.println(i);
		}
		System.out.println("Amount of Money: " + "$" + finalCrew.getAmountMoney());
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	}
	public void intializezViewItemPrices(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList, ArrayList<FoodItems> buyableFoodList) {
		System.out.println("The prices of the items for sale are:");
		for (MedicalSupplies i: buyableMedicineList) {
			System.out.println(i.getMedicineName() + " Costs:  $" + i.getMedicineCost());
		}
		for (FoodItems i: buyableFoodList) {
			System.out.println(i.getFoodName() + " Costs:  $" + i.getfoodCost());
		}
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	}
	public void intializezItemInspect(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList, ArrayList<FoodItems> buyableFoodList) {
		System.out.println("Descriptions of the items for sale:");
		for (MedicalSupplies i: buyableMedicineList) {
			System.out.println(i.getDescription());
		}
		for (FoodItems i: buyableFoodList) {
			System.out.println(i.getDescription());
		}
		initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	}
	public void intializeShop(TheShipClass finalCrew, Scanner scanner, ArrayList<MedicalSupplies> buyableMedicineList, ArrayList<FoodItems> buyableFoodList) {
	    boolean found = false;
	    while (!found) {
			System.out.println("\n" + "You are at the shop select what to do next from the options below:" + "\n" +
					"1: Antidote: cures space plague costs: $15" + "\n" + 
					"2: MedKit: restores 50 health, costs $20" + "\n" + 
					"3: FirstAidKit: restores 25 Health, costs $10" + "\n" + 
					"4: Return to outpost?");
	        try {
	    		int inputShop = scanner.nextInt();
	     	    if (inputShop == 1) {
	    			System.out.println("What quantity of Antidote would you like?");
	    			int antidoteQuan = scanner.nextInt();
	    			if (finalCrew.doesPriceExceed(buyableMedicineList.get(0).getMedicineCost(), antidoteQuan)) {
	    				finalCrew.addMedicalItem(buyableMedicineList.get(0), buyableMedicineList.get(0).getMedicineCost(), antidoteQuan);
		     	    	found = true;
		     	    	initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	    			}
	    			else {
	    				found = true;
	    				System.out.println("Your funds are too low for this purchase");
	    				initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	    			}
	     	    } else if (inputShop == 2) {	 
	    			System.out.println("What quantity of MedKits would you like?");
	    			int medkitQuan = scanner.nextInt();
	    			if (finalCrew.doesPriceExceed(buyableMedicineList.get(1).getMedicineCost(), medkitQuan)) {
	    				finalCrew.addMedicalItem(buyableMedicineList.get(1), buyableMedicineList.get(1).getMedicineCost(), medkitQuan);
	    				found = true;
	    				initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	    			}
	    			else {
	    				found = true;
	    				System.out.println("Your funds are too low for this purchase");
	    				initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	    			}
	     	    } else if (inputShop == 3) {
	    			System.out.println("What quantity of First-Aid Kits would you like?");
	    			int firstaidkitQuan = scanner.nextInt();
	    			if (finalCrew.doesPriceExceed(buyableMedicineList.get(2).getMedicineCost(), firstaidkitQuan)) {
	    				finalCrew.addMedicalItem(buyableMedicineList.get(2), buyableMedicineList.get(2).getMedicineCost(), firstaidkitQuan);
	    				found = true;
	    				initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	    			}
	    			else {
	    				found = true;
	    				System.out.println("Your funds are too low for this purchase");
	    				initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	    			}
	     	    } else if (inputShop == 4) {
	     	    	found = true;
	    			initializeNearestOutpost(finalCrew, scanner, buyableMedicineList, buyableFoodList);
	     	    } else {
	     	    	System.out.println("Please enter a valid number from the list of options" + "\n");
	     	    }
	        }
	        catch (java.util.InputMismatchException e) {
	            scanner.nextLine();
	            System.out.println("Input must be a number" + "\n");
	        }
	    }		
	}
	
	
	
	
	
	
	
	 public static void main (String[] args) {
		 GameInput gameInputSetup = new GameInput();
		 //this needs to be put in the class that will showcase either input or gui and will call this to use the input
	 }
}
