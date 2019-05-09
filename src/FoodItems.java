
public class FoodItems {
    private String foodName;
	private int foodQuantity;
	private int foodCost;
	private int hungerReduction;
	// soup, bread, apple, nut, corn beef, tea
	public FoodItems(String tempName, int tempFoodCost, int tempHungerReduction) {
		foodName = tempName;
		foodCost = tempFoodCost;
		hungerReduction = tempHungerReduction;
	}
	public String getFoodName() {
		return foodName;
	}
	public int getFoodQuantity() {
		return foodQuantity;
	}
	public int getfoodCost() {
		return foodCost;
	}
	public boolean getFoodAvailability() {
		if (foodQuantity > 0) {
			// maybe should be not equal to 1 not sure
			return true;
		}
		return false;
		// needs to be tested but should work
	}
	public String toString() {
		return foodName;
	}
    public String getDescription() {
		return foodName + " is food for a hungry crew member!";
	}

}
