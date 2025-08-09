
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;

class Date{
	private int day; 
	private int month; 
	private int year; 
	
	public Date(int day, int month, int year) {
		System.out.println("public Date(int day, int month, int year)");
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Date( ) {
		System.out.println("public Date()");
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
		Date dt = new Date(); 
		Date dt1 = new Date(1, 1, 2010); 
		dt1.printRecord();
	}
	public static void main1(String[] args) {
		Date dt1 = new Date(); 
		Date dt2 = new Date(); 
		Date dt3 = new Date(); 
	}
}
