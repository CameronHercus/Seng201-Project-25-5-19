package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Antidote;
import main.Crew;
import main.Haggler;
import main.Juggernaut;
import main.Nuts;

class CrewTest {
	private Crew shipAndCrew;
	
	 @BeforeEach
	 public void init() {
		 shipAndCrew = new Crew();
		 }

	@Test
	public void shipNameTest() {
		shipAndCrew.setShipName("Edward");
		assertEquals("Edward", shipAndCrew.getShipName());
	}
	@Test
	public void shipHealthTest() {
		shipAndCrew.setShipHealth(50);
		assertEquals(50, shipAndCrew.getShipHealth());
	}
	@Test
	public void shipMoneyTest() {
		shipAndCrew.setAmountMoney(50);
		assertEquals(50, shipAndCrew.getAmountMoney());
	}
	@Test
	public void crewListTest() {
		shipAndCrew.getMembersList().add(new Haggler("Bob"));
		assertEquals(1, shipAndCrew.getMembersList().size());
		shipAndCrew.getMembersList().remove(0);
		assertEquals(0, shipAndCrew.getMembersList().size());		 
	}
	@Test
	public void medicineListTest() {
		shipAndCrew.getMedicineList().add(new Antidote());
		assertEquals(1, shipAndCrew.getMedicineList().size());
		shipAndCrew.getMedicineList().remove(0);
		assertEquals(0, shipAndCrew.getMedicineList().size());	 
	}
	@Test
	public void foodListTest() {
		 shipAndCrew.getFoodList().add(new Nuts());
		assertEquals(1, shipAndCrew.getFoodList().size());
		shipAndCrew.getFoodList().remove(0);
		assertEquals(0, shipAndCrew.getFoodList().size());	 
	}
	
	

}
