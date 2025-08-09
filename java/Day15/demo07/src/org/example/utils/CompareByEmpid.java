package org.example.utils;

import java.util.Comparator;

import org.example.domain.Employee;

public class CompareByEmpid implements Comparator<Employee>{
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getEmpId() - emp2.getEmpId();
	}
}
