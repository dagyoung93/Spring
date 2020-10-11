package com.java.bank.dao;

import java.util.List;

import com.java.bank.dto.BankDto;

public interface BankDao {
	public int makeAccount(BankDto bankDto); //insert 확인
	public List<BankDto> showData();
	public BankDto select (String id); //각각계좌조회
	public int update(BankDto bankDto); //update 횟수
	
}
