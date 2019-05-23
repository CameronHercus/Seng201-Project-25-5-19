
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
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String inputShipName) {
		shipName = inputShipName;
	}
	public int getShipHealth() {
		return shipHealth;
	}
	public void setShipHealth(int i) {
		shipHealth = i;
	}
	public int getAmountMoney() {
		return amountMoney;
	}
	public void setAmountMoney(int i) {
		amountMoney = i;
	}
	public ArrayList<CrewMembersMainClass> getMembersList() {
		return crewList;
	}
	public ArrayList<MedicalSupplies> getMedicalList() {
		return medicalList;
	}
	public ArrayList<FoodItems> getFoodList() {
		return foodList;
	}
}