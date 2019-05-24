package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Crew;
import main.Nuts;

class FoodItemsTest {
	private Crew shipAndCrew;
	 @BeforeEach
	 public void init() {
		 shipAndCrew = new Crew();
		 }
	@Test
	public void testGetFoodName() {
		shipAndCrew.getFoodList().add(new Nuts());
		assertEquals("Nuts", shipAndCrew.getFoodList().get(0).getFoodName());
	}
	@Test
	public void testGetFoodCost() {
		shipAndCrew.getFoodList().add(new Nuts());
		assertEquals(10, shipAndCrew.getFoodList().get(0).getfoodCost());
	}
	@Test
	public void testFoodToString() {
		shipAndCrew.getFoodList().add(new Nuts());
		assertEquals("Nuts", shipAndCrew.getFoodList().get(0).toString());
	}

}
