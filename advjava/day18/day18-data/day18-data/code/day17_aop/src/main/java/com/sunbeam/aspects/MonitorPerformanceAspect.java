package com.sunbeam.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP

@Aspect // to tell SC , class below contains cross cutting concerns(i.e repeatative
//		// task)
@Component // to tell SC : it's a spring bean (i.e manage it's life cycle)
@Slf4j
public class MonitorPerformanceAspect {

	// intercept method calls to all of the controllers
	@Around("execution(* com.sunbeam.controller.*.*(..))")
	public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		// pre processing : before advice
		log.debug("Begins monitoring ");
		long begin = System.currentTimeMillis();
		log.debug("Proceeding to req handling method");
		Object ret = joinPoint.proceed();// proceed to controller method
		// post processing : after the method exec
		log.debug("Time taken by method : " + joinPoint.getSignature() + " in "
				+ (System.currentTimeMillis() - begin) + "msec");
		return ret;
	}
}