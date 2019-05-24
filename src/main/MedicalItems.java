package main;
/**
 * This class implements medical items that can be purchased
 * and used for healing and curing crew members
 * @author Leoca
 *
 */
public class MedicalItems {
	   /**
	    * The name of the medical item
	    */
    private String medicineName;
	/**
	 * The price of the medical item
	 */
	private int medicineCost;
	/**
	 * Sets the medical items name from the values passed into the constructor
	 * and sets the medical items price
	 * @param tempMedicineName 	string Provided medicine name
	 * @param tempMedicineCost 	int Provided medicine cost
	 */
	public MedicalItems(String tempMedicineName, int tempMedicineCost) {
		medicineName = tempMedicineName;
		medicineCost = tempMedicineCost;
	}
	/**
	 * Gets the medical items name
	 * @return Medical items name as a string
	 */
	public String getMedicineName() {
		return medicineName;
	}
	/**
	 * Gets the medical items price
	 * @return medical items price integer
	 */
	public int getMedicineCost() {
		return medicineCost;
	}
	/**
	 * Returns a string value as the medical items name
	 */
	public String toString() {
		return medicineName;
	}

}
