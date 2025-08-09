
import java.util.Calendar;
import java.util.Scanner;

//Step1: Understand requirement and Declare the class
class Date{
	//Step2: Declare the fields
	//Step4: access modifiers
	private int day; 
	private int month; 
	private int year; 
	
	public void initDate( ) {
		Calendar c = Calendar.getInstance();
	 	this.day = c.get(Calendar.DATE); 
	 	this.month = c.get(Calendar.MONTH) + 1; 
	 	this.year = c.get(Calendar.YEAR);
	}
	public void acceptRecord( ) {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Day : ");
		day = sc.nextInt();
		System.out.print("Month : ");
		month = sc.nextInt();
		System.out.print("Year : ");
		year = sc.nextInt();
		
		
	}
	public void printRecord( ) {
		System.out.println(day + " / " + month + " / " + year);
	}
}
 
 
 


public class Program {
	public static void main(String[] args) {
		//Step3: Creating the instance
		Date dt1 = new Date(); 
		
		//Step5: calling methods
		dt1.initDate( );  // dt1.initDate(dt1); 
		dt1.printRecord( );// dt1.printRecord(dt1); 
		dt1.acceptRecord(); // dt1.acceptRecord(dt1);
		dt1.printRecord(); // dt1.printRecord(dt1);
		dt1.initDate();
	}
}
