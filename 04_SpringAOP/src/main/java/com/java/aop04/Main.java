package com.java.aop04;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.aop04.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx  = new GenericXmlApplicationContext("classpath:com/java/aop04/config.xml");
		
		Person student = ctx.getBean("student", Person.class);
		student.work();
		System.out.println("=====================");
		
		Person teacher = ctx.getBean("teacher", Person.class);
		teacher.work();
		System.out.println("=====================");

		ctx.close();
	}

}