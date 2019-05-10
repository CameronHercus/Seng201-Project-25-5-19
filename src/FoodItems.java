
public class FoodItems {
    private String foodName;
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
	public int getfoodCost() {
		return foodCost;
	}
	public int getHungerRedcution() {
		return hungerReduction;
	}
	public String toString() {
		return foodName;
	}
    public String getDescription() {
		return foodName + " is food for a hungry crew member!";
	}

}
