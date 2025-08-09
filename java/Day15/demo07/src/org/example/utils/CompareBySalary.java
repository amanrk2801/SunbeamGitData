package org.example.utils;

import java.util.Comparator;

import org.example.domain.Employee;

public class CompareBySalary implements Comparator<Employee>{
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return (int) (emp1.getSalary() - emp2.getSalary());
	}
}
