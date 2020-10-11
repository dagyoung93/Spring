package com.java.aop01;

public class Papa implements Person {

	@Override
	public void awake() {
		// TODO Auto-generated method stub
		System.out.println("Papa 일어난다");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Papa 출근한다");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Papa 잠을 잔다");
	}

}
