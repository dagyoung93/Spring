package com.java.aop02;

import org.aspectj.lang.JoinPoint;

public class PASpect {//공통클래스
	public void awake(JoinPoint joinpoint) {
		System.out.println("일어난다.");
	}
	public void sleep(JoinPoint joinpotin) {
		System.out.println("잠을 잔다.");
	}
}
