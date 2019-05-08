
import java.util.ArrayList;

public class TheShipClass {
    
	private int counter = 0;
	private String shipName;
	private int numberOfDays;
	private int amountMoney = 100;
	private int numberOfPieces;
	private int startingMemberCount;

	// maybe stuff like this should be in the game enviornment class
	
	ArrayList<CrewMembersMainClass> crewList = new ArrayList<CrewMembersMainClass>();
	ArrayList<MedicalSupplies> medicalList = new ArrayList<MedicalSupplies>();
	ArrayList<FoodItems> foodList = new ArrayList<FoodItems>();
	// FIND EXAMPE WHERE IF ALIEN ALREADY EXISTED IT ADDED THE QANTITY BY ONE!
	public TheShipClass() {
	}
	
	
	public void printMedicalSupplies() {
		for (MedicalSupplies i: medicalList) {
			System.out.println(i);
			// NOT ACTUALLY BEING USED BUT PROB USEFUL FOR GUI
		}
	}
	public int getAmountMoney() {
		return amountMoney;
	}
	public void setNumberOfPieces(int tempNumberOfPieces) {
		numberOfPieces = tempNumberOfPieces;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setStartingMemberCount(int tempStartingMemberCount) {
		startingMemberCount = tempStartingMemberCount;
	}
	public int getstartingMemberCount() {
		return startingMemberCount;
	}
	
	
	
	
	
	public boolean addCrewMember(CrewMembersMainClass member) {
		crewList.add(member);
		return true;
		//NEEDS UPDATING

	}
	public boolean removeCrewmember(CrewMembersMainClass member) {
		if (crewList.contains(member)) {
			crewList.remove(member);
			return true;
			// u think this will only work by removing eg medic and not the name of the crew member maybe use collections or make it accept two arguments with name and class type
		}
		return false;
	}
	
	
	public void addMedicalItem(MedicalSupplies medicine, int price, int quantity) {
		amountMoney -= price * quantity;
			for (int i = 0; i < quantity; i ++) {
				medicalList.add(medicine);
			}
			// need to think about this and the crew one
		}
		// if temp is in medical list get its count then add it to the existing count
	public boolean doesPriceExceed(int price, int quantity) {
		if ((price * quantity) <= amountMoney) {
			return true;
		}
		return false;
	}
	public boolean removeMedicalItem(MedicalSupplies medicine, int quantity) {
		if (medicalList.contains(medicine)) {
			for (int i = 0; i < quantity; i++) {
				medicalList.remove(medicine);
			}
			return true;
			
		}
		return false;
		//not sure hasnt been tested
	}
	public boolean containsMedicine(MedicalSupplies medicine) {
		if (medicalList.contains(medicine)) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addCrewMember(CrewMembersMainClass member) {
		//should set member name in the setup class!
		crewList.add(member);
	}
	public void addMedicineItem(MedicalSupplies item) {
		if (medicalList.contains(item))
		medicalList.add(item);
	}

	public ArrayList<MedicalSupplies> getMedicalList() {
		// not sure if quantity that passed in should be 0 to start with
		return medicalList;
	}
	public ArrayList<CrewMembersMainClass> getCrewList() {
		return crewList;
	}
	public void setNumberOfDays(int intputShipDays) {
		numberOfDays = intputShipDays;
	}
	
	public void setShipName(String inputShipName) {
		shipName = inputShipName;
	}
	public String getShipName() {
		return shipName;
	}
	public int getCrewCount() {
		for (CrewMembersMainClass i: crewList) {
			counter += 1;
		}
		return counter;
	}
	public void printAllCrewMembers() {
		for (CrewMembersMainClass i: crewList) {
			System.out.println(i.getMemberName());
		}
	}

}