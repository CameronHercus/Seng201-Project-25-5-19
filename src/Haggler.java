
public class Haggler extends CrewMembersMainClass{
    public Haggler() {
		super("Haggler", 100, 50, 50, " Buying items is cheaper", "DEFAULT");
	}
	public Haggler(String tempName) {
		super("Haggler", 100, 50, 50, " Buying items is cheaper", tempName);
		//NOT SURE IF IT WORKS AS INTENDED
		// also not sure if i need to do it like this maybe just have it set name?
	}

}
