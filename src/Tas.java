public class Tas {

	private char color;
	private String location;
	
	public Tas() {
		color='y';  //color yok.
		location = null;
	}
	public void setColor (char c) {
		color = c;
	} public char getColor () {
		return color;
	} public void setLocation (String loc) {
		location = loc;
	} public String getLocation () {
		return location;
	} public boolean checkMove (String loc) {
		return !(this.getLocation() == null);
	} public String[] getMoves () {
		String[] dizi = new String[0];
		return dizi;
	}
	
}
