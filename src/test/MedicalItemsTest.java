package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Crew;
import main.MedKit;

class MedicalItemsTest {
	private Crew shipAndCrew;
	 @BeforeEach
	 
	 public void init() {
		 shipAndCrew = new Crew();
		 shipAndCrew.getMedicineList().add(new MedKit());
		 }
	@Test
	public void testGetMedicineName() {
		assertEquals("MedKit", shipAndCrew.getMedicineList().get(0).getMedicineName());
	}
	@Test
	public void testGetMedicineCost() {
		assertEquals(20, shipAndCrew.getMedicineList().get(0).getMedicineCost());
	}
	@Test
	public void testMedicineToString() {
		assertEquals("MedKit", shipAndCrew.getMedicineList().get(0).toString());
	}
}
