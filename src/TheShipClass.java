
import java.util.ArrayList;

public class TheShipClass {
	private String shipName;
	private int shipHealth = 100;
	private int amountMoney = 100;
	private int startingMemberCount;
	ArrayList<CrewMembersMainClass> crewList = new ArrayList<CrewMembersMainClass>();
	ArrayList<MedicalSupplies> medicalList = new ArrayList<MedicalSupplies>();
	ArrayList<FoodItems> foodList = new ArrayList<FoodItems>();
	public TheShipClass() {
	}
	public void setShipHealth(int i) {
		shipHealth = i;
	}
	public int getShipHealth() {
		return shipHealth;
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
	public void setStartingMemberCount(int tempStartingMemberCount) {
		startingMemberCount = tempStartingMemberCount;
	}
	public int getstartingMemberCount() {
		return startingMemberCount;
	}
	public boolean removeCrewmember(CrewMembersMainClass member) {
		if (crewList.contains(member)) {
			crewList.remove(member);
			return true;
			//think this will only work by removing eg medic and not the name of the crew member maybe use collections or make it accept two arguments with name and class type
		}
		return false;
	}
	public void addMedicine(MedicalSupplies medicine) {
		medicalList.add(medicine);
	}
	public void addMedicalItem(MedicalSupplies medicine, int price, int quantity) {
		amountMoney -= price * quantity;
			for (int i = 0; i < quantity; i ++) {
				medicalList.add(medicine);
			}
			// need to think about this and the crew one
	}
	public void addFoodItem(FoodItems food, int price, int quantity) {
		amountMoney -= price * quantity;
		for (int i = 0; i < quantity; i ++) {
			foodList.add(food);
		}
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
	public String printAllActions() {
		String str1 = "";
		for (CrewMembersMainClass i: crewList) {
			str1 += i.getMemberName() + " has " + i.getCrewActions() + " actions remaining for today" + "\n";
		}
		return str1;
	}
	public void addCrewMember(CrewMembersMainClass member) {
		//should set member name in the setup class! should be boolean too
		crewList.add(member);
	}
	public ArrayList<MedicalSupplies> getMedicalList() {
		// not sure if quantity that passed in should be 0 to start with
		return medicalList;
	}
	public ArrayList<FoodItems> getFoodList() {
		return foodList;
	}
	public ArrayList<CrewMembersMainClass> getCrewList() {
		return crewList;
	}
	public void setShipName(String inputShipName) {
		shipName = inputShipName;
	}
	public String getShipName() {
		return shipName;
	}
	public int getCrewCount() {
		int counter = 0;
		for (int i = 0; i < crewList.size(); i++) {
			counter += 1;
		} // THIS NEEDS TO BE TESTED
		return counter;
	}
	public void printAllCrewMembers() {
		for (CrewMembersMainClass i: crewList) {
			System.out.println(i.getMemberName());
		}
	}

}