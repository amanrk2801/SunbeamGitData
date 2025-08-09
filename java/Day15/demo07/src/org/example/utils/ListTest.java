package org.example.utils;

import java.util.ArrayList;
import java.util.Comparator;

import org.example.domain.Employee;

public class ListTest {
	private ArrayList<Employee> empList = new ArrayList<>();

	public void addElement(Employee[] arr) {
		if( arr != null ) {
			for( Employee emp : arr )
				this.empList.add(emp);
		}
	}
	/* public Employee findElement( int empid ){
		for( Employee emp : this.empList ) {
			if( emp.getEmpId() == empid )
				return emp;
		}
		return null;
	} */
	
	public Employee findElement( int empid ){
		Employee key = new Employee( empid );
		if( this.empList.contains(key)) {
			int index = this.empList.indexOf(key);
			return this.empList.get(index);
		}
		return null;
	}
	/* public boolean removeElement( int empid ){
		Employee key = new Employee( empid );
		if( this.empList.contains(key)) {
			int index = this.empList.indexOf(key);
			this.empList.remove(index);
			return true;
		}
		return false;
	} */
	
	public boolean removeElement( int empid ){
		Employee key = new Employee( empid );
		if( this.empList.contains(key)) {
			this.empList.remove(key);
			return true;
		}
		return false;
	}
	public void print(Comparator<Employee> comparator) {
		this.empList.sort(comparator);
		this.empList.forEach(System.out::println);
	}
}
