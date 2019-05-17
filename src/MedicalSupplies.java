
public class MedicalSupplies {
    private String medicineName;
	private int medicineCost;
	public MedicalSupplies(String tempMedicineName, int tempMedicineCost) {
		medicineName = tempMedicineName;

		medicineCost = tempMedicineCost;
		//continue here with ideas for the medical supplies then go onto the food
	}
	public String getMedicineName() {
		return medicineName;
	}
	public int getMedicineCost() {
		return medicineCost;
	}
	public String toString() {
		return medicineName;
	}

}
