package com.java.aop04;

import java.util.Scanner;

public class Student implements Person{

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("�����忡 ����");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�� �Է� : ");
		int su = sc.nextInt();
		
		
		if(su == 5) {
			System.out.println(su/0);
		}
		sc.close();
		
	}

}