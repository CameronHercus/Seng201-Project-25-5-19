public class MedicalItems {
    private String medicineName;
	private int medicineCost;
	public MedicalItems(String tempMedicineName, int tempMedicineCost) {
		medicineName = tempMedicineName;
		medicineCost = tempMedicineCost;
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
