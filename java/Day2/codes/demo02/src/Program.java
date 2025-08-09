
public class Program {
	public static void main(String[] args) {
		//Converting primitive to wrapper is called as Boxing 
		int a = 10;
		Integer b = new Integer(a);// Boxing 
		
		//Converting wrapper to primitive is called unboxing 
		int c = b.intValue();  // unboxing 
	}

}
