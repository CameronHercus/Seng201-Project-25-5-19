package main;
import java.util.ArrayList;
/**
 * This class implements and stores ship and crew attributes
 * @author Leoca
 *
 */
public class Crew {
    /**
	 * the name of the ship
	 */
	private String shipName;
	/**
	 * the health of the ship
	 */
	private int shipHealth = 100;
	/**
	 * crews amount of money initialized to 100
	 */
	private int amountMoney = 100;
	/**
	 * An array list containing all the selected crew members
	 */
	ArrayList<CrewMembers> membersList = new ArrayList<CrewMembers>();
	/**
	 * an array list that contains the medical items
	 */
	ArrayList<MedicalItems> medicalList = new ArrayList<MedicalItems>();
	/**
	 * An array list containing the food items
	 */
	ArrayList<FoodItems> foodList = new ArrayList<FoodItems>();
	/**
	 * constructor
	 */
	public Crew() {
	}
	/**
	 * Gets ship name 
	 * @return	ship name
	 */
	public String getShipName() {
		return shipName;
	}
	/**
	 * Sets ship name
	 * @param inputShipName	ship name input by user
	 */
	public void setShipName(String inputShipName) {
		shipName = inputShipName;
	}
	/**
	 * Gets ship health
	 * @return	the health of the ship
	 */
	public int getShipHealth() {
		return shipHealth;
	}
	/**
	 * Sets the ships health
	 * @param i	ships health
	 */
	public void setShipHealth(int i) {
		shipHealth = i;
	}
	/**
	 * Gets the amount of money the crew have
	 * @return	the amount of money
	 */
	public int getAmountMoney() {
		return amountMoney;
	}
	/**
	 * Sets the amount of money the crew have
	 * @param i		amount of money
	 */
	public void setAmountMoney(int i) {
		amountMoney = i;
	}
	/**
	 * Gets the crew members array list
	 * @return	Crew members list
	 */
	public ArrayList<CrewMembers> getMembersList() {
		return membersList;
	}
	/**
	 * Gets the medical items array list
	 * @return	Medical items list
	 */
	public ArrayList<MedicalItems> getMedicineList() {
		return medicalList;
	}
	/**
	 * Gets the food items array list
	 * @return	Food items list
	 */
	public ArrayList<FoodItems> getFoodList() {
		return foodList;
	}
}