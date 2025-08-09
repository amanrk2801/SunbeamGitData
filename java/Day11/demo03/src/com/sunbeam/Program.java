package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program {
	public static void main(String[] args) {
	    Employee[] arr = new Employee[] {
            new Employee(4, "B", "Clerk", "Sales", 723.44),
            new Employee(8, "X", "Manager", "Accounts", 823.23),
            new Employee(2, "P", "Clerk", "Research", 234.23),
            new Employee(9, "N", "Manger", "Sales", 252.53),
            new Employee(5, "D", "Clerk", "Accounts", 923.23),
            new Employee(1, "Q", "Analyst", "Research", 826.23),
            new Employee(7, "H", "Clerk", "Research", 845.24),
            new Employee(6, "A", "Analyst", "Research", 832.23),
            new Employee(3, "G", "Analyst", "Sales", 952.44)
        };
	    
	    System.out.println("Emps sorted by id -- using EmpIdComparator -- local class");
	    class EmpIdComparator implements Comparator<Employee> {
	    	@Override
	    	public int compare(Employee x, Employee y) {
	    		int diff = x.getId() - y.getId(); //Integer.compare(x.getId(), y.getId());
	    		return diff;
	    	}
	    }
	    Arrays.sort(arr, new EmpIdComparator());
	    for (Employee e : arr)
	    	System.out.println(e);
	    
	    System.out.println("\nEmps sorted by name -- using Anonymous Inner class");
	    Comparator<Employee> empNameComparator = new Comparator<Employee>() {
	    	@Override
	    	public int compare(Employee x, Employee y) {
	    		int diff = x.getName().compareTo(y.getName());
	    		return diff;
	    	}
	    };
	    Arrays.sort(arr, empNameComparator);
	    for (Employee e : arr)
	    	System.out.println(e);
	    
	    System.out.println("\nEmps sorted by job -- using Anonymous Inner class Anonymous object: ");
	    Arrays.sort(arr, new Comparator<Employee>() {
	    	@Override
	    	public int compare(Employee x, Employee y) {
	    		int diff = x.getJob().compareTo(y.getJob());
	    		return diff;
	    	}
	    });
	    for (Employee e : arr)
	    	System.out.println(e);
	
	    System.out.println("\nEmps sorted by job in desc order: ");
	    // lambda is short-hand implementation of the abstract method in the functional interface
	    Arrays.sort(arr, (Employee x, Employee y) -> {
	    	int diff = -x.getJob().compareTo(y.getJob());
	    	return diff;
	    });
	    for (Employee e : arr)
	    	System.out.println(e);

	    System.out.println("\nEmps sorted by name in desc order: ");
	    // compiler inferred argument types
	    Arrays.sort(arr, (x, y) -> {
	    	int diff = -x.getName().compareTo(y.getName());
	    	return diff;
	    });
	    for (Employee e : arr)
	    	System.out.println(e);
	
	    System.out.println("\nEmps sorted by sal in asc order: ");
	    Arrays.sort(arr, (x, y) -> {
	    	return Double.compare(x.getSal(), y.getSal());
	    });
	    for (Employee e : arr)
	    	System.out.println(e);
	    
	    System.out.println("\nEmps sorted by sal in desc order: ");
	    // single liner lambda expression doesn't need curly braces
	    // and the result of expression is considered to be returned.
	    Arrays.sort(arr, (x, y) -> - Double.compare(x.getSal(), y.getSal()) );
	    for (Employee e : arr)
	    	System.out.println(e);
	    
	    System.out.println("\nEmps list sorted by id in desc order: ");
	    List<Employee> list = Arrays.asList(arr);
	    list.sort((x,y) -> -Integer.compare(x.getId(), y.getId()));
	    list.forEach(e -> System.out.println(e.toString()));
	}
}











