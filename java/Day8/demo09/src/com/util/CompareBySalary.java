package com.util;

import java.util.Comparator;

import com.domain.Employee;

public class CompareBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee x, Employee y) {
		return (int) (x.getSalary() - y.getSalary()); 
	}

}
