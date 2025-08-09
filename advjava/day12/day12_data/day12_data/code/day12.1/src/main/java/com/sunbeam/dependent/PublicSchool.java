package com.sunbeam.dependent;

import com.sunbeam.dependency.Coach;
import com.sunbeam.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;	
	private Coach sportsCoach;

	public PublicSchool() {		
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher);//null
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

	

	//setter Base D.I
	
	public void setSubjectTeacher(Teacher subjectTeacher) {
		System.out.println("in set - teacher");
		this.subjectTeacher = subjectTeacher;
	}

	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in set - coach");
		this.sportsCoach = sportsCoach;
	}
}
