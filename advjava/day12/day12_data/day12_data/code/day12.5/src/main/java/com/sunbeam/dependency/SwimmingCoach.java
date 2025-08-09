package com.sunbeam.dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//singleton n lazy , id=swimming
@Component("swimming")
@Lazy(true)
public class SwimmingCoach implements Coach {

    public SwimmingCoach() {
        System.out.println("In constructor: " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
