package com.challenges.solutions.climbing_the_leaderboard.performanceMonitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceMonitor {

	public PerformanceMonitor() {
		
	}
	@Around("@annotation(TrackTime)")
	public Object around(ProceedingJoinPoint joinPoint) {
		long startTime=System.currentTimeMillis();
		Object value=null;
		try {
			value=(String) joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println((endTime-startTime)+"by"+joinPoint);
		return value;
	}

}
