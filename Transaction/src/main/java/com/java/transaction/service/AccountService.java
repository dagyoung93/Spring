package com.java.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AccountService {

	@Autowired
	PlatformTransactionManager transactionManager;
	
	public void transfer (int money, String accounName) {
		//transaction 
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
