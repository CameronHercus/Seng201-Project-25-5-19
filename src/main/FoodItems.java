package main;
/**
 * This class implements food items that can be purchased
 * and consumed by crew members
 * @author Leoca
 *
 */
public class FoodItems {
	   /**
	    * The name of the food item 
	    */
    private String foodName;
	/**
	 * The price of the food item
	 */
	private int foodCost;
	/**
	 * Sets the food items name and price through values passed into the constructor
	 * @param tempName		Provided name of food item
	 * @param tempFoodCost		Provided price of food item
	 */
	public FoodItems(String tempName, int tempFoodCost) {
		foodName = tempName;
		foodCost = tempFoodCost;
	}
	/**
	 * Gets the name of the food item
	 * @return		Name of food item string 
	 */
	public String getFoodName() {
		return foodName;
	}
	/**
	 * Gets the price of the food item
	 * @return		Food item cost integer
	 */
	public int getfoodCost() {
		return foodCost;
	}
	/**
	 * Returns a string value as the food items name
	 */
	public String toString() {
		return foodName;
	}

}
