package org.npu.courseapp.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {
	Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(public * org.npu.courseapp.services.*.find*(..))")	
	public void beforeExecute(JoinPoint joinPoint){
		System.out.println("Found a find method");
	}
}
