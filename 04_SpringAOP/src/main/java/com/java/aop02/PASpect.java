package com.java.aop02;

import org.aspectj.lang.JoinPoint;

public class PASpect {//����Ŭ����
	public void awake(JoinPoint joinpoint) {
		System.out.println("�Ͼ��.");
	}
	public void sleep(JoinPoint joinpotin) {
		System.out.println("���� �ܴ�.");
	}
}
