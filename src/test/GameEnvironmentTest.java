package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Antidote;
import main.Apple;
import main.Archeologist;
import main.Bread;
import main.CornedBeef;
import main.Engineer;
import main.FirstAidKit;
import main.GameEnvironment;
import main.Haggler;
import main.Juggernaut;
import main.MedKit;
import main.Medic;
import main.Nuts;
import main.Soup;
import main.Tea;
import main.Thief;

public class GameEnvironmentTest {
	private GameEnvironment gameLogic;
	
	
	 @BeforeEach
	 public void init() {
		 gameLogic = new GameEnvironment();
		 }
	@Test
	public void getNumberOfPiecesRemainingTest() {
		gameLogic.setNumberOfPiecesRemaining(5);
		assertEquals(5, gameLogic.getNumberOfPiecesRemaining());
	}
	@Test
	public void purchaseFoodTest() {
		assertTrue(gameLogic.purchaseFood(new Nuts(), 4));
		assertEquals(4, gameLogic.getShipAndCrew().getFoodList().size());
		assertFalse(gameLogic.purchaseFood(new Nuts(), 400));
	}
	@Test
	public void feedTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(0);
		assertFalse(gameLogic.feed(new Nuts(), gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(50);
		assertTrue(gameLogic.feed(new Tea(), gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(50);
		assertTrue(gameLogic.feed(new Nuts(), gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(50);
		assertTrue(gameLogic.feed(new Apple(), gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(50);
		assertTrue(gameLogic.feed(new Bread(), gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(50);
		assertTrue(gameLogic.feed(new Soup(), gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(50);
		assertTrue(gameLogic.feed(new CornedBeef(), gameLogic.getShipAndCrew().getMembersList().get(0)));
	}
	@Test
	public void removeFoodTest() {
		gameLogic.getShipAndCrew().getFoodList().add(new Nuts());
		assertEquals(1, gameLogic.getShipAndCrew().getFoodList().size());
		gameLogic.removeFood(gameLogic.getShipAndCrew().getFoodList().get(0));
		assertEquals(0, gameLogic.getShipAndCrew().getFoodList().size());
	}
	@Test
	public void purchaseMedicineTest() {
		assertTrue(gameLogic.purchaseMedicine(new FirstAidKit(), 4));
		assertEquals(4, gameLogic.getShipAndCrew().getMedicineList().size());
		assertFalse(gameLogic.purchaseMedicine(new FirstAidKit(), 400));
	}
	@Test
	public void applyMedicineTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().add(new Juggernaut("bill"));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHealthLevel(50);
		assertEquals("MedKit applied to " + gameLogic.getShipAndCrew().getMembersList().get(0).toString(), 
				(gameLogic.applyMedicine(new MedKit(), gameLogic.getShipAndCrew().getMembersList().get(0))));
		assertEquals("First-Aid Kit applied to " + gameLogic.getShipAndCrew().getMembersList().get(0).toString(), 
				(gameLogic.applyMedicine(new FirstAidKit(), gameLogic.getShipAndCrew().getMembersList().get(0))));
		gameLogic.getShipAndCrew().getMembersList().get(1).setHealthLevel(50);
		assertEquals("MedKit applied to " + gameLogic.getShipAndCrew().getMembersList().get(1).toString(), 
				(gameLogic.applyMedicine(new MedKit(), gameLogic.getShipAndCrew().getMembersList().get(1))));
		assertEquals("First-Aid Kit applied to " + gameLogic.getShipAndCrew().getMembersList().get(1).toString(), 
				(gameLogic.applyMedicine(new FirstAidKit(), gameLogic.getShipAndCrew().getMembersList().get(1))));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHealthLevel(100);
		assertEquals("Cannot apply MedKit to a Member that is full health", 
				(gameLogic.applyMedicine(new MedKit(), gameLogic.getShipAndCrew().getMembersList().get(0))));
		assertEquals("Cannot apply First-Aid Kit to a Member that is full health", 
				(gameLogic.applyMedicine(new FirstAidKit(), gameLogic.getShipAndCrew().getMembersList().get(0))));
	}
	@Test
	public void removeMedicineTest() {
		gameLogic.getShipAndCrew().getMedicineList().add(new MedKit());
		assertEquals(1, gameLogic.getShipAndCrew().getMedicineList().size());
		gameLogic.removeMedicine(gameLogic.getShipAndCrew().getMedicineList().get(0));
		assertEquals(0, gameLogic.getShipAndCrew().getMedicineList().size());
	}
	@Test
	public void addRandomMedicineTest() {
	}
	@Test
	public void addRandomFoodTest() {
		// need to find way to do this for random
	}
	@Test
	public void searchForPartsTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().get(0).setRemainingActions(0);
		assertEquals(" has no actions remaining", gameLogic.searchForParts(gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setRemainingActions(2);
		// need to find way to do this for random
	}
	@Test
	public void newDayEventTest() {
		// need to find way to do this for random
	}
	@Test
	public void newDayChangesTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().get(0).setRemainingActions(1);
		gameLogic.getShipAndCrew().getMembersList().get(0).setSpacePlagueStatus(true);
		gameLogic.getShipAndCrew().getMembersList().add(new Juggernaut("bill"));
		gameLogic.getShipAndCrew().getMembersList().get(1).setRemainingActions(1);
		gameLogic.setRemainingDays(7);
		gameLogic.newDayChanges();
		assertEquals(20, gameLogic.getShipAndCrew().getMembersList().get(0).getTirednessLevel());
		assertEquals(20, gameLogic.getShipAndCrew().getMembersList().get(0).getHungerLevel());
		assertEquals(80, gameLogic.getShipAndCrew().getMembersList().get(0).getHealthLevel());
		assertEquals(20, gameLogic.getShipAndCrew().getMembersList().get(1).getTirednessLevel());
		assertEquals(20, gameLogic.getShipAndCrew().getMembersList().get(1).getHungerLevel());
		assertEquals(110, gameLogic.getShipAndCrew().getMembersList().get(1).getHealthLevel());
		assertEquals(2, gameLogic.getShipAndCrew().getMembersList().get(0).getRemainingActions());
		assertEquals(2, gameLogic.getShipAndCrew().getMembersList().get(1).getRemainingActions());
		assertEquals(2, gameLogic.getCurrentDay());
		assertEquals(6, gameLogic.getRemainingDays());
	}
	@Test
	public void removeActionsTooTiredTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		assertEquals("", gameLogic.removeActionsTooTired());
		gameLogic.getShipAndCrew().getMembersList().get(0).setTiredNessLevel(100);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + ", " + " now have 1 action because they are too tired", gameLogic.removeActionsTooTired());
	}
	@Test
	public void removeActionsTooHungryTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		assertEquals("", gameLogic.removeActionsTooHungry());
		gameLogic.getShipAndCrew().getMembersList().get(0).setHungerLevel(100);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + ", " + " now have 1 action because they are too hungry", gameLogic.removeActionsTooHungry());
	}
	@Test
	public void removeDeadCrewMembersTest() {
		assertEquals("", gameLogic.removeDeadCrewMembers());
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().get(0).setHealthLevel(0);
		assertEquals("bob The Haggler" + ", " +" Have been removed from the Crew as their health level has reached 0", gameLogic.removeDeadCrewMembers());
	}
	@Test
	public void newPlanetTest() {
	}
	@Test
	public void asteroidBeltDamageTest() {
		assertEquals(100, gameLogic.getShipAndCrew().getShipHealth());
		gameLogic.asteroidBeltDamage();
		assertEquals(79, gameLogic.getShipAndCrew().getShipHealth());
	}
	@Test
	public void repairShipTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().add(new Engineer("bill"));
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + " cannot repair the ship any further as it is already at full health", 
				gameLogic.repairShip(gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().setShipHealth(25);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + " has made some repairs to the ship", 
				gameLogic.repairShip(gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().setShipHealth(25);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(1).toString() + " has used their skill and repaird a lot of damage to the ship", 
				gameLogic.repairShip(gameLogic.getShipAndCrew().getMembersList().get(1)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setRemainingActions(0);
		gameLogic.getShipAndCrew().setShipHealth(25);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + " has no actions remaining", 
				gameLogic.repairShip(gameLogic.getShipAndCrew().getMembersList().get(0)));
	
	}
	@Test
	public void haveMemberSleepTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		gameLogic.getShipAndCrew().getMembersList().get(0).setTiredNessLevel(0);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + " is not tired enough to need to sleep", 
				gameLogic.haveMemberSleep(gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setTiredNessLevel(75);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + " is now less tired", 
				gameLogic.haveMemberSleep(gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setTiredNessLevel(75);
		gameLogic.getShipAndCrew().getMembersList().get(0).setRemainingActions(0);
		assertEquals(gameLogic.getShipAndCrew().getMembersList().get(0).toString() + " has no actions remaining", 
				gameLogic.haveMemberSleep(gameLogic.getShipAndCrew().getMembersList().get(0)));
	}
	@Test
	public void foundPartOnPlanetYesNoTest() {
		assertEquals("No", gameLogic.foundPartOnPlanetYesNo());
		gameLogic.setPartFoundOnPlanet(true);
		assertEquals("Yes", gameLogic.foundPartOnPlanetYesNo());
	}
	@Test
	public void spacePlagueYesNoTest() {
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		assertEquals("No Infection", gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getMembersList().get(0)));
		gameLogic.getShipAndCrew().getMembersList().get(0).setSpacePlagueStatus(true);
		assertEquals("Infected", gameLogic.spacePlagueYesNo(gameLogic.getShipAndCrew().getMembersList().get(0)));
	}
	@Test
	public void getInvetoryTest() {
		assertEquals("<html>Antidote Quantity: 0<br>First-Aid Quantity: 0<br>Med Kit Quantity: 0<br>Tea Quantity: 0<br>Nuts Quantity: 0<br>Apples Quantity: 0<br>Bread Quantity: 0<br>Soup Quantity: 0<br>Corned Beef Quantity: 0</html>", 
				gameLogic.getInvetory());
		gameLogic.getShipAndCrew().getFoodList().add(new Bread());
		gameLogic.getShipAndCrew().getMedicineList().add(new Antidote());
		assertEquals("<html>Antidote Quantity: 1<br>First-Aid Quantity: 0<br>Med Kit Quantity: 0<br>Tea Quantity: 0<br>Nuts Quantity: 0<br>Apples Quantity: 0<br>Bread Quantity: 1<br>Soup Quantity: 0<br>Corned Beef Quantity: 0</html>", 
				gameLogic.getInvetory());
		gameLogic.getShipAndCrew().getFoodList().add(new Tea());
		gameLogic.getShipAndCrew().getFoodList().add(new Nuts());
		gameLogic.getShipAndCrew().getFoodList().add(new Apple());
		gameLogic.getShipAndCrew().getFoodList().add(new Soup());
		gameLogic.getShipAndCrew().getFoodList().add(new CornedBeef());
		gameLogic.getShipAndCrew().getMedicineList().add(new MedKit());
		gameLogic.getShipAndCrew().getMedicineList().add(new FirstAidKit());
		assertEquals("<html>Antidote Quantity: 1<br>First-Aid Quantity: 1<br>Med Kit Quantity: 1<br>Tea Quantity: 1<br>Nuts Quantity: 1<br>Apples Quantity: 1<br>Bread Quantity: 1<br>Soup Quantity: 1<br>Corned Beef Quantity: 1</html>", 
				gameLogic.getInvetory());
	}
	@Test
	public void isGameOverTest() {
		gameLogic.setRemainingDays(5);
		gameLogic.setNumberOfPiecesRemaining(5);
		gameLogic.getShipAndCrew().setShipHealth(100);
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		assertFalse(gameLogic.isGameOver());
		gameLogic.setRemainingDays(0);
		gameLogic.setNumberOfPiecesRemaining(0);
		gameLogic.getShipAndCrew().setShipHealth(0);
		gameLogic.getShipAndCrew().getMembersList().remove(0);
		assertTrue(gameLogic.isGameOver());
	}
	@Test
	public void getGameScoreTest() {
		gameLogic.setInitialNumberOfPieces(2);
		gameLogic.setRemainingDays(4);
		gameLogic.setNumberOfPiecesRemaining(0);
		gameLogic.getShipAndCrew().setAmountMoney(110);
		gameLogic.getShipAndCrew().getMembersList().add(new Haggler("bob"));
		assertEquals(13100, gameLogic.getGameScore());
	}
	
	
	
	
	
	
	
	
	
	


}
