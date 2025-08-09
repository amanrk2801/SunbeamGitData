package com.sunbeam.dependency;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//prototype , id=eng

@Component("eng")
@Scope("prototype")
public class EnglishTeacher implements Teacher {
	public EnglishTeacher() {
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void teach() {
		System.out.println("Practice English Grammar");
	}

}
