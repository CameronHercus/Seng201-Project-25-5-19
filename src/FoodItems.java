
public class FoodItems {
    private String foodName;
	private int foodCost;
	public FoodItems(String tempName, int tempFoodCost) {
		foodName = tempName;
		foodCost = tempFoodCost;
	}
	public String getFoodName() {
		return foodName;
	}
	public int getfoodCost() {
		return foodCost;
	}
	public String toString() {
		return foodName;
	}

}
