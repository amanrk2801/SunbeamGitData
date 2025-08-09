
public class Program {
	public static void main(String[] args) {
		int a = 123; 
		String strNumber = String.valueOf(a); // Boxing 
		System.out.println("Str : "+strNumber);
		
		String str = "100"; 
		int x = Integer.parseInt(str); //unboxing 
		System.out.println("x : "+x);
	}

}
