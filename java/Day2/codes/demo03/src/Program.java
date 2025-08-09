
public class Program {
	public static void main1(String[] args) {
		int i = 10;
		Integer j = new Integer(i); // Boxing 
		Integer k = i; // auto-boxing (java 5.0) 
	}
	public static void main(String[] args) {
		Integer x = new Integer(10); 
		int y = x.intValue(); // unboxing 
		int z = x; // auto-unboxing 
	}

}
`