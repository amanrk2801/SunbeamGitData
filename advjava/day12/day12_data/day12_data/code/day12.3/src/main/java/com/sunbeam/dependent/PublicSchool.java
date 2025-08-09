package com.sunbeam.dependent;

import com.sunbeam.dependency.Coach;
import com.sunbeam.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;	
	private Coach sportsCoach;	

	public PublicSchool(Teacher subjectTeacher, Coach sportsCoach) {
	
		this.subjectTeacher = subjectTeacher;
		this.sportsCoach = sportsCoach;
		System.out.println("in ctor of "+getClass());
		System.out.println("dependecies - "
		+subjectTeacher+" "+sportsCoach);//not null
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
	public void myInit() {
		System.out.println("in init " + subjectTeacher+" "+sportsCoach);// not null
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy " + subjectTeacher);// not null
	}	

}
