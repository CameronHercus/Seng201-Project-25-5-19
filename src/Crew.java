import java.util.ArrayList;
public class Crew {
	private String shipName;
	private int shipHealth = 100;
	private int amountMoney = 100;
	ArrayList<CrewMembers> crewList = new ArrayList<CrewMembers>();
	ArrayList<MedicalItems> medicalList = new ArrayList<MedicalItems>();
	ArrayList<FoodItems> foodList = new ArrayList<FoodItems>();
	public Crew() {
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
	public ArrayList<CrewMembers> getMembersList() {
		return crewList;
	}
	public ArrayList<MedicalItems> getMedicineList() {
		return medicalList;
	}
	public ArrayList<FoodItems> getFoodList() {
		return foodList;
	}
}