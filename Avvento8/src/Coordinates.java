
public class Coordinates {
	
	public String left;
	public String right;
	
	public Coordinates(String s) {
		String temp = s.replace("(", "");
		temp = temp.replace(")", "");
		this.left = temp.split(",")[0].trim();
		this.right = temp.split(",")[1].trim();
	}

}
