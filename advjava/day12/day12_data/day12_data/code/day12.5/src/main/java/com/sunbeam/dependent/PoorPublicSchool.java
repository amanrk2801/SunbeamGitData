package com.sunbeam.dependent;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sunbeam.dependency.Coach;
import com.sunbeam.dependency.Teacher;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//singleton  n eager , poor school -maths teacher, football coach 
//id="poor_public_school" , field level D.I - auto wire
//@Component("poor_public_school")
public class PoorPublicSchool implements School {
	@Autowired
	@Qualifier("maths") //byName
	private Teacher subjectTeacher;
	/*
	 * SC searches for any spring bean of the type(byName) Coach - creates instances
	 * of Football , Cricket , Swimming - adds them to array - injects the array ->
	 * field
	 */
	@Autowired
	@Qualifier("footballCoach") //byName
	private Coach sportsCoach;

	public PoorPublicSchool() {
		System.out.println("in ctor of " + getClass());
		System.out.println("dependecies - " + subjectTeacher + " " + sportsCoach);// null
	}

	// B.L: method
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	// B.L method
	@Override
	public void organizeSportsEvent() {
		System.out.println("Organizing sports event");
		System.out.println(sportsCoach.getDailyWorkout());

	}

	// init method
	@PostConstruct
	public void myInit() {
		System.out.println("in init - dependencies :  " + subjectTeacher + " " + sportsCoach);// not null
	}

	// destroy method
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy - dependencies :" + subjectTeacher);// not null
	}

}
