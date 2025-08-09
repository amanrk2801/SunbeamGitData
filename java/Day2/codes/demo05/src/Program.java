import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		//primitive to wrapper -> Boxing 
		int a = 10; // primitive
		Integer b = new Integer(a); //Boxing 
		
		//wrapper to primitive -> UnBoxing 
		int c = b.intValue(); // unboxing  
		int d = b; // auto-unboxing 
		//System.out.println(" a " + a + " b " + b + " c " + c + " d " + d);
		
		//Boxing and unboxing are not efficient as it takes more memory and time 
		Integer x = 10; //auto-boxing 
		Integer y = 20; //auto-boxing
		Integer z = x + y; 
		/*
		   x is auto-unboxed to 10 ( primitive) 
		   y is auto-unboxed to 20 ( primitive) 
		   10 + 20 --> 30 
		   30 is auto-boxed to z 	
		 
		*/
		//System.out.println("z : "+z);
		
		List list = new ArrayList(); 
		list.add(new Integer(a)); // boxing 
		list.add(a); //auto-boxing 
		list.add(x); // x -> Integer 
		//System.out.println(list);
		
		//System.out.println("Max range : "+Integer.MAX_VALUE);
		//System.out.println("Max range : "+Integer.MIN_VALUE);
		
		System.out.println("Size : "+Integer.SIZE);
	}

}


