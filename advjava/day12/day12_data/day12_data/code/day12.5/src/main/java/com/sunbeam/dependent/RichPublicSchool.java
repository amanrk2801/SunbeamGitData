package com.sunbeam.dependent;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sunbeam.dependency.Coach;
import com.sunbeam.dependency.Teacher;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//singleton  n eager , poor school - all teachers n all coaches, 
//id="public_school" , field level D.I - auto wire
@Component("rich_public_school")
@Scope("prototype")
public class RichPublicSchool implements School {
	@Autowired //byType - field level D.I
	private Teacher[] subjectTeachers;
	/*
	 * SC searches for any spring bean of the type(byType) Coach
	 * - creates instances of Football , Cricket , Swimming
	 * - adds them to array
	 * - injects the array -> field
	 */
	@Autowired
	private Coach[] sportsCoaches;

	public RichPublicSchool() {
		System.out.println("in ctor of " + getClass());
		System.out.println("dependecies - " + subjectTeachers + " " + sportsCoaches);//null
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
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + subjectTeachers + " " + sportsCoaches);// not null
	}

	// destroy method
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy " + subjectTeachers);// not null
	}

}
