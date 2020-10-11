package com.java.bank.dao;

import java.util.List;

import com.java.bank.dto.BankDto;

public interface BankDao {
	public int makeAccount(BankDto bankDto); //insert Ȯ��
	public List<BankDto> showData();
	public BankDto select (String id); //����������ȸ
	public int update(BankDto bankDto); //update Ƚ��
	
}
