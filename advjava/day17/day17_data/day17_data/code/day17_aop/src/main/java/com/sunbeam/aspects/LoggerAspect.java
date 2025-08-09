package com.sunbeam.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect // declares advises n join points - cross cutting concerns
@Component // declares spring bean
@Slf4j // adds "log" field from Logger framework
public class LoggerAspect {
	@Before("execution (* com.sunbeam.controller.*.*(..))")
	public void logMessage(JoinPoint joinPoint) {
		log.debug("-----Before Aspect --------{}", joinPoint);
	}

}
