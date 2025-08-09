package com.sunbeam.dependency;

import org.springframework.stereotype.Component;

//singleton n eager <bean id="cricket" class="com.sunbeam.dependency.CricketCoach"/>
@Component("cricket")
public class CricketCoach implements Coach {

    public CricketCoach() {
    	System.out.println("In constructor - " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
