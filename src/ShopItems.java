import java.util.ArrayList;

public class ShopItems {
	ArrayList<MedicalSupplies> buyableMedicineList = new ArrayList<MedicalSupplies>();
	ArrayList<FoodItems> buyableFoodList = new ArrayList<FoodItems>();
	public ShopItems() {
		buyableMedicineList.add(new Antidote());
		buyableMedicineList.add(new MedKit());
		buyableMedicineList.add(new FirstAidKit());
		buyableFoodList.add(new Tea());
		buyableFoodList.add(new Nuts());
		buyableFoodList.add(new Apple());
		buyableFoodList.add(new Bread());
		buyableFoodList.add(new Soup());
		buyableFoodList.add(new CornedBeef());
	}

}
