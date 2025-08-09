package com.sunbeam.dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//singleton n lazy
@Component //id=scienceTeacher
@Lazy(true)
public class ScienceTeacher implements Teacher {
	public ScienceTeacher() {
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void teach() {
		System.out.println("Learn Science through experiments !");
	}

}
