package com.example.inflearn_study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTrace {
	
	
//	@Around("execution(* com.example.inflearn_study..*(..))")			//com.example.inflearn_study 패키지 하위 전부다
	@Around("execution(* com.example.inflearn_study.controller..*(..))")	//com.example.inflearn_study.Controller 패키지 하위 전부다
	public Object execute(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		
		System.out.println("START :: " + jp.toString());
		try {
			return jp.proceed();
		} finally {
			long end = System.currentTimeMillis();
			long diff = end - start;
			System.out.println("END :: " + jp.toString() + " :: time(ms) : " + diff);
		}
		
		
		
		
	}
	
}
