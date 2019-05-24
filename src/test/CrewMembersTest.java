package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Archeologist;
import main.Engineer;
import main.Haggler;
import main.Juggernaut;
import main.Medic;
import main.Thief;

class CrewMembersTest {
	private Haggler bob;
	private Thief bill;
	private Archeologist cam;
	private Medic sam;
	private Juggernaut chris;
	private Engineer will;
	 @BeforeEach
	 public void init() {
		 bob = new Haggler("bob");
		 bill = new Thief("bill");
		 cam = new Archeologist("cam");
		 sam = new Medic("sam");
		 chris = new Juggernaut("chris");
		 will = new Engineer("will");
		 }
	@Test
	public void testGetHealthLevel() {
		assertEquals(100, bob.getHealthLevel());
	}
	@Test
	public void testGetTirednessLevvel() {
		assertEquals(0, bill.getTirednessLevel());
	}
	@Test
	public void testGetRemainingActions() {
		assertEquals(2, cam.getRemainingActions());
	}
	@Test
	public void testGetSpacePlagueStatus() {
		assertFalse(sam.getSpacePlagueStatus());
		assertFalse(will.getSpacePlagueStatus());
	}
	@Test
	public void testToString() {
		assertEquals("chris The Juggernaut", chris.toString());
	}
}
