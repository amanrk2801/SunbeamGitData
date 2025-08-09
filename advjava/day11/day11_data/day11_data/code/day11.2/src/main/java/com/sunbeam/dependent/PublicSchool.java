package com.sunbeam.dependent;

import com.sunbeam.dependency.Coach;
import com.sunbeam.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// =new EnglishTeacher();
	private long funds;
	private Coach sportsCoach;

	private PublicSchool(long myFunds, Teacher myTeacher) {
		this.funds = myFunds;
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher);
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
		System.out.println("in init " + subjectTeacher);// not null
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy " + subjectTeacher);// not null
	}

	// factory method based D.I
	public static PublicSchool myFactoryMethod(Teacher myTeacher,
			long someFunds, Coach myCoach) {
		System.out.println("in factory method");
		PublicSchool school=new PublicSchool(someFunds, myTeacher);
		school.sportsCoach=myCoach;
		return school;
	}

}
