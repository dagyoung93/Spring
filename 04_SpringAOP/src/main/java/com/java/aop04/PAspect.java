package com.java.aop04;

import org.aspectj.lang.ProceedingJoinPoint;

public class PAspect {
	public void sub(ProceedingJoinPoint joinpoint) {
		try {
		System.out.println("강의실 입장");
		
		//핵심코드를 joinpoint 를 통해 가져옴
		joinpoint.proceed();
		
		System.out.println("점심식사");
		
		}catch(Throwable e) {
			System.out.println("식권 없음");
		}finally {
			System.out.println("수업 끝, 강의장을 나간다");
		}
	}
}
