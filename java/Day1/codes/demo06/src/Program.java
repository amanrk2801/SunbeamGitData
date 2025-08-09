import java.util.Scanner;
public class Program {
	
	
	public static void main1(String[] args) {
		int a = 65; 
		//short s = a; // narrowing
		short s = (short) a; // narrowing ( explicit casting is required) 
		System.out.println(a);
		System.out.println(s);
	}
	public static void main(String[] args) {
		short s = 10; 
		int a = s; // Widening 
		System.out.println(s);
		System.out.println(a);
	}
	

}
