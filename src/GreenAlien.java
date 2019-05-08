public class GreenAlien {
	private String name;
	private int eyeCount;
	private String favouriteCandy;
	
	public GreenAlien() {
		name = "Kloup";
		eyeCount = 6;
		favouriteCandy = "Lollypops";
	}
	public GreenAlien(String tempName, int tempEye, String tempCandy) {
		name = tempName;
		eyeCount = tempEye;
		favouriteCandy = tempCandy;
	}
	public String getName() {
		return name;
	}
	public int getEyeCount() {
		return eyeCount;
	}
	public String getFavouriteCandy() {
		return favouriteCandy;
	}
	public String toString() {
		 return "This Alien is called " + name + " and has " + eyeCount + " eyes. Gross. It seems to enjoy eating " + favouriteCandy;
	}
	public boolean equals(GreenAlien other) {
		if (this.name == other.getName() &&
			this.eyeCount == other.getEyeCount() &&
			this.favouriteCandy == other.getFavouriteCandy()) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		GreenAlien kloup = new GreenAlien();
		GreenAlien lesap = new GreenAlien();
		GreenAlien gwerp = new GreenAlien("Gwerp", 4, "Marshmellows");
		GreenAlien blarg = new GreenAlien("Kloup", 3, "Pop Rocks");

		System.out.println(kloup.equals(lesap));
		System.out.println(gwerp.equals(lesap));
		System.out.println(kloup.equals(blarg));
	}
}





