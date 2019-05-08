import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;

public class GreenAlienTransporter {
	private String adder = "";
	private String transporter_name;
	private ArrayList<GreenAlien> transporter;
	private int total = 0;
	private String str1 = "";
	private String str2 = "";
	public GreenAlienTransporter(String name) {
		transporter_name = name;
		transporter = new ArrayList<GreenAlien>();
	}
	public boolean addPassenger(GreenAlien alien) {
		if (!transporter.contains(alien)) {
			transporter.add(alien);
			return true;
		}
		return false;
	}
	public boolean removePassenger(GreenAlien alien) {
		if (transporter.contains(alien)) {
			transporter.remove(alien);
			return true;
		}
		return false;
	}
	public void listPassengers() {
		for (int i = 0; i < transporter.size(); i++) {
			adder += transporter.get(i).getName();
			adder += ", ";
		}
		System.out.println("The passengers on " + transporter_name + " are:");
		System.out.println(adder);
	}
	public int countEyes() {
		for (int i = 0; i < transporter.size(); i++) {
			total += transporter.get(i).getEyeCount();
		}
		return total;
	}
	public ArrayList<String> shoppingList() {
		ArrayList<String> Candy = new ArrayList<String>();
		for (int i = 0; i < transporter.size(); i++) {
			Candy.add(transporter.get(i).getFavouriteCandy());
			
		}
		return Candy;
	}
	public void printDetails() {
		listPassengers();
		System.out.println("The number of eyes on this transporter is: " + countEyes());
		TreeSet<String> candy_set =  new TreeSet<String>();
		for (int i = 0; i < shoppingList().size(); i++) {
			if (!str1.contains(shoppingList().get(i))) {
				str1 += shoppingList().get(i);
				str1 += "(";
				str1 += Collections.frequency(shoppingList(), shoppingList().get(i));
				str1 += "), ";
				candy_set.add(str1);
				str1 = "";
			}
		}
		System.out.println("The favourites of this group are:");
		for (String i: candy_set) {
			str2 += i;
		}
		System.out.println(str2);
	}
	public static void main(String[] args) {
		
		GreenAlienTransporter transporter = new GreenAlienTransporter("Fun Club");

		GreenAlien kloup = new GreenAlien("Yyest", 2, "Biscuits");
		GreenAlien gwerp = new GreenAlien("Lmona", 99, "Marshmellows");
		GreenAlien blarg = new GreenAlien("Troll", 5, "Pop Rocks");
		GreenAlien lesap = new GreenAlien("Nemoa", 3, "Marshmellows");
		GreenAlien hugso = new GreenAlien("Hugso", 8, "Pop Rocks");

		transporter.addPassenger(kloup);
		System.out.println(transporter.addPassenger(kloup));
		transporter.addPassenger(gwerp);
		transporter.addPassenger(blarg);
		transporter.addPassenger(lesap);
		transporter.addPassenger(hugso);

		transporter.printDetails();
	}
}