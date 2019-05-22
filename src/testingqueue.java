import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class testingqueue {
	public static void main(String[] args) {
		ArrayDeque<MedicalSupplies> array = new ArrayDeque<MedicalSupplies>();
		array.add(new Antidote());
		System.out.println(array.getFirst().getClass());
		if (array.getFirst() instanceof Antidote) {
			System.out.println("BOB");
		}
		System.out.println(array.getFirst() instanceof Antidote);
	}

}
