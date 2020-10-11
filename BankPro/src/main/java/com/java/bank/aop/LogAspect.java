package com.java.bank.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
	public static Logger logger = Logger.getLogger(LogAspect.class.getName());
	public static final String LogMsg = "LogMsg>>>>>>>";

	public Object advice(ProceedingJoinPoint joinpoint)  {
		Object obj = null;
		try {
			logger.info(LogMsg + joinpoint.getTarget().getClass().getName()+"\t\t"+joinpoint.getSignature().getName());
			//ÇÙ½É°´Ã¼
			obj = joinpoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
