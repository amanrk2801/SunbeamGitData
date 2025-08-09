package org.example.test;

import java.sql.Date;
import java.util.Comparator;
import java.util.Scanner;

import org.example.domain.Employee;
import org.example.utils.CompareByDeptid;
import org.example.utils.CompareByEmpid;
import org.example.utils.CompareByHireDate;
import org.example.utils.CompareByName;
import org.example.utils.CompareBySalary;
import org.example.utils.ListTest;

public class Program {
	private static Scanner sc = new Scanner(System.in);
	public static Employee[] getEmployeeArray() {
		Employee[] arr = new Employee[] {
				new Employee(68319, "KAYLING", "PRESIDENT", 0, Date.valueOf("1991-11-18"), 6000.00f, 0, 1001),

				new Employee(66928, "BLAZE", "MANAGER", 68319, Date.valueOf("1991-05-01"), 2750.00f, 0, 3001),

				new Employee(67832, "CLARE", "MANAGER", 68319, Date.valueOf("1991-06-09"), 2550.00f, 0, 1001),

				new Employee(65646, "JONAS", "MANAGER", 68319, Date.valueOf("1991-04-02"), 2957.00f, 0, 2001),

				new Employee(67858, "SCARLET", "ANALYST", 65646, Date.valueOf("1997-04-19"), 3100.00f, 0, 2001),

				new Employee(69062, "FRANK", "ANALYST", 65646, Date.valueOf("1991-12-03"), 3100.00f, 0, 2001),

				new Employee(63679, "SANDRINE", "CLERK", 69062, Date.valueOf("1990-12-18"), 900.00f, 0, 2001),

				new Employee(64989, "ADELYN", "SALESMAN", 66928, Date.valueOf("1991-02-20"), 1700.00f, 400.00f, 3001),

				new Employee(65271, "WADE", "SALESMAN", 66928, Date.valueOf("1991-02-22"), 1350.00f, 600.00f, 3001),

				new Employee(66564, "MADDEN", "SALESMAN", 66928, Date.valueOf("1991-09-28"), 1350.00f, 1500.00f, 3001),

				new Employee(68454, "TUCKER", "SALESMAN", 66928, Date.valueOf("1991-09-08"), 1600.00f, 0, 3001),

				new Employee(68736, "ADNRES", "CLERK", 67858, Date.valueOf("1997-05-23"), 1200.00f, 0, 2001),

				new Employee(69000, "JULIUS", "CLERK", 66928, Date.valueOf("1991-12-03"), 1050.00f, 0, 3001),

				new Employee(69324, "MARKER", "CLERK", 67832, Date.valueOf("1992-01-23"), 1400.00f, 0, 1001) };
		return arr;
	}
	private static void printRecord(Employee value) {
		if( value != null )
			System.out.println(value.toString());
		else 
			System.out.println("Key not found.");
	}
	private static void acceptRecord(int[] empid) {
		System.out.print("Enter empid	:	");
		empid[ 0 ] = sc.nextInt();
	}
	private static void printRecord(boolean removedstatus) {
		if( removedstatus )
			System.out.println("Employee is removed");
		else
			System.out.println("Empid not found");
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Add Element(s)");
		System.out.println("2.Find Element");
		System.out.println("3.Remove Element");
		System.out.println("4.Print Elements[ Sorted ]");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static int subMenuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Compare By Name");
		System.out.println("2.Compare By Empid");
		System.out.println("3.Compare By Deptid");
		System.out.println("4.Compare By Salary");
		System.out.println("5.Compare By Hiredate");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] empid = new int[ 1 ];
		ListTest test = new ListTest();
		while( ( choice = Program.menuList( ) ) != 0 ) {
			switch( choice ){
			case 1:
				Employee[] arr = Program.getEmployeeArray();
				test.addElement( arr );
				break;
			case 2:
				Program.acceptRecord( empid );
				Employee value = test.findElement(empid[ 0 ]);
				Program.printRecord( value );
				break;
			case 3:
				Program.acceptRecord( empid );
				boolean removedstatus = test.removeElement(empid[ 0 ] );
				Program.printRecord(removedstatus );
				break;
			case 4:
				while( ( choice = Program.subMenuList( ) ) != 0 ) {
					Comparator<Employee> comparator = null;
					switch( choice ) {
					case 1:
						comparator = new CompareByName();
						break;
					case 2:
						comparator = new CompareByEmpid();
						break;
					case 3:
						comparator = new CompareByDeptid();
						break;
					case 4:
						comparator = new CompareBySalary();
						break;
					case 5:
						comparator = new CompareByHireDate();
						break;
					}
					test.print( comparator );
				}
				break;
			}
		}
	}
}
