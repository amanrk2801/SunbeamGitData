package com.sunbeam.dependent;

import java.util.Arrays;

import com.sunbeam.dependency.Coach;
import com.sunbeam.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher[] subjectTeachers;
	private Coach[] sportsCoaches;

	public PublicSchool(Teacher[] subjectTeachers, Coach[] sportsCoaches) {

		this.subjectTeachers = subjectTeachers;
		this.sportsCoaches = sportsCoaches;
		System.out.println("in ctor of " + getClass());
		System.out.println("dependecies - " + subjectTeachers + " " + sportsCoaches);// not null
	}

	// B.L: method
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		/*
		 * for (Teacher t : subjectTeachers) t.teach();
		 */
		Arrays.stream(subjectTeachers)
		.forEach(System.out::println);
	}

	// B.L method
	@Override
	public void organizeSportsEvent() {
		System.out.println("Organizing sports event");
	//	System.out.println(sportsCoach.getDailyWorkout());
		Arrays.stream(sportsCoaches) //Stream<Coach>
		.forEach(System.out::println);
		

	}

	// init method
	public void myInit() {
		System.out.println("in init " + subjectTeachers + " " + sportsCoaches);// not null
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy " + subjectTeachers);// not null
	}

}
