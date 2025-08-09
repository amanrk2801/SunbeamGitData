
public class Program {
	//( use of primitive as Objects) 
	public static void main1(String[] args) {
		int a = 10; 
		Integer i = new Integer(a); // int -> Integer 
		//System.out.println(a);
		//System.out.println(i);
		
		// wrapper -> type conversion 
		double d = i.doubleValue(); 
		float f = i.floatValue(); 
		String str = i.toString(); 
		
		System.out.println(d);
		System.out.println(f);
		System.out.println(str);

	}
	public static void main(String[] args) {
		int a = 10 , b = 20; 
		//int max = Integer.max(a, b);   
		//System.out.println("max : "+max);
		
		int min = Integer.min(a, b); 
		System.out.println("min : "+min);
	}

}
