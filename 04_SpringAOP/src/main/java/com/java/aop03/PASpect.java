package com.java.aop03;

import org.aspectj.lang.JoinPoint;

public class PASpect {
	public void open(JoinPoint joinpoint) {
		System.out.println("�����忡 ���´�");
	}
	public void close(JoinPoint joinpoint) {
		System.out.println("���� �� �� �������� ������");
	}
	public void error(JoinPoint joinpoint ) {
		System.out.println("�ıǾ��� �� ���´�...");
	}
	public void eat(JoinPoint joinpoint ) {
		System.out.println("���� �Դ´�");
	}
}