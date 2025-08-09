package com.sunbeam;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface DevInfo {
	String value();  // default attribute "author" 
	String company() default "Sunbeam";  
	String designation() default "Sw Dev";  
}
