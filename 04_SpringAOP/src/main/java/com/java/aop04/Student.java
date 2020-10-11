package com.java.aop04;

import java.util.Scanner;

public class Student implements Person{

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("강의장에 들어옴");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수 입력 : ");
		int su = sc.nextInt();
		
		
		if(su == 5) {
			System.out.println(su/0);
		}
		sc.close();
		
	}

}