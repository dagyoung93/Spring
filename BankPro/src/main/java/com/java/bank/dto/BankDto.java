package com.java.bank.dto;

public class BankDto {
	
	/* Dto는 데이터를 넣고 꺼내기 위해 사용 ; VO 와 같다고 보면 됨 - 객체를 통해 데이터 받음  */
	
	private int num; //sequence
	private String id;
	private String name;
	private long balance;
	
	public BankDto() {}
	
	public BankDto(int num, String id, String name, long balance) {
		this.num=num;
		this.id=id;
		this.name =name;
		this.balance=balance;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankDto [num=" + num + ", id=" + id + ", name=" + name + ", balance=" + balance + ", getNum()="
				+ getNum() + ", getId()=" + getId() + ", getName()=" + getName() + ", getBalance()=" + getBalance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
