import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;
public class testingqueue {
	ArrayList<String> planetsList = new ArrayList<String>();
	public testingqueue() {
		planetsList.add("Hocilea");
		planetsList.add("baallsack");
		planetsList.add("Chur");
	}
	public String getPlanetName() {
		ListIterator<String> planetIterator =  planetsList.listIterator();
		if (planetIterator.hasNext()) {
			String planetName = planetIterator.next();
			planetIterator.remove();
			return planetName;
		} else {
			return "There are no more Planets to visit";
		}
		
	}
	public static void main(String[] args) {
	}

}
