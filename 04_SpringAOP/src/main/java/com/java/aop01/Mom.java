package com.java.aop01;

public class Mom implements Person{

	@Override
	public void awake() {
		// TODO Auto-generated method stub
		System.out.println("Mom �Ͼ��");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Mom �������� �Ѵ�");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Mom ���� �ܴ�");
	}

}
