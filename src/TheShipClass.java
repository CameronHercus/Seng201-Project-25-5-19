
import java.util.ArrayList;

public class TheShipClass {
	private String shipName;
	private int shipHealth = 100;
	private int amountMoney = 100;
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
	public int getAmountMoney() {
		return amountMoney;
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
	public void addCrewMember(CrewMembersMainClass member) {

		crewList.add(member);
	}
	public ArrayList<MedicalSupplies> getMedicalList() {
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
	public void setAmountMoney(int i) {
		amountMoney = i;
	}



}