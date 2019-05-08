
public class MedicalSupplies {
    private String medicineName;
	private int medicineQuantity;
	private int medicineCost;
	public MedicalSupplies(String tempMedicineName, int tempMedicineCost) {
		medicineName = tempMedicineName;

		medicineCost = tempMedicineCost;
		//continue here with ideas for the medical supplies then go onto the food
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineQuantity(int tempQuantity) {
		medicineQuantity = tempQuantity;
		// may need to be changed
	}
	public int getMedicineQuantity() {
		return medicineQuantity;
	}
	public int getMedicineCost() {
		return medicineCost;
	}
	public boolean getMedicineAvailability() {
		if (medicineQuantity > 0) {
			return true;
		}
		return false;
		// needs to be tested but should work
	}
	public String toString() {
		return medicineName;
	}
    public String getDescription() {
		return medicineName + " is medicine for a wounded crew member!";
	}

}
