
public class FoodItems {
    private String foodName;
	private int foodQuantity;
	private int foodCost;
	// soup, bread, apple, nut, corn beef, tea
	public FoodItems() {
		//continue here with ideas for the food
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

}
