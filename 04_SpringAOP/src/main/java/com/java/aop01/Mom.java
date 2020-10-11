package com.java.aop01;

public class Mom implements Person{

	@Override
	public void awake() {
		// TODO Auto-generated method stub
		System.out.println("Mom 일어난다");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Mom 집안일을 한다");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Mom 잠을 잔다");
	}

}
