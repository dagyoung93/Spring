package com.java.aop04;

import org.aspectj.lang.ProceedingJoinPoint;

public class PAspect {
	public void sub(ProceedingJoinPoint joinpoint) {
		try {
		System.out.println("���ǽ� ����");
		
		//�ٽ��ڵ带 joinpoint �� ���� ������
		joinpoint.proceed();
		
		System.out.println("���ɽĻ�");
		
		}catch(Throwable e) {
			System.out.println("�ı� ����");
		}finally {
			System.out.println("���� ��, �������� ������");
		}
	}
}
