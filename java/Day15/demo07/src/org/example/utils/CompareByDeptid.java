package org.example.utils;

import java.util.Comparator;

import org.example.domain.Employee;

public class CompareByDeptid implements Comparator<Employee>{
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getDeptId() - emp2.getDeptId();
	}
}
