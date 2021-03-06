package com.java.bank.ui;

import java.util.List;
import java.util.Scanner;

import com.java.bank.aop.LogAspect;
import com.java.bank.dao.BankDao;
import com.java.bank.dto.BankDto;

public class BankView implements BankUI {
	private BankDto bankDto;
	private BankDao bankDao;

	public BankView() {
	}

	public BankView(BankDto bankDto, BankDao bankDao) {
		this.bankDto = bankDto;
		this.bankDao = bankDao;
	}

	public void setBankDto(BankDto bankDto) {
		this.bankDto = bankDto;
	}

	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		printMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("선택하세요 ");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			makeAccount();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdraw();
			break;
		case 4:
			inquiry();
			break;
		case 5:
			showData();
			break;
		case 6:
			break;
		default:
			System.out.println("잘못입력하였습니다.");

		}
		sc.close();

	}

	public void printMenu() {
		System.out.println("====MENU====");
		System.out.println("1. 계좌 개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 잔액 조회");
		System.out.println("5. 전체 출력");
		System.out.println("6. 종료");

	}

	// 1. 계좌 개설
	public void makeAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌 번호 : ");
		String id = sc.next();
		BankDto dto = bankDao.select(id);
		if (dto != null) {
			System.out.println("이미 존재하는 계좌번호 입니다.");
		} else {
			bankDto.setId(id);
			System.out.println("이름 : ");
			bankDto.setName(sc.next());
			System.out.println("입금액 : ");
			bankDto.setBalance(sc.nextLong()); // sc.next() 는 데이터타입이 다름

			int check = bankDao.makeAccount(bankDto);

			LogAspect.logger.info(LogAspect.LogMsg + check);

			System.out.println("계좌가 생성되었습니다.");
		}
		sc.close();
		// 1. 계좌 개설 끝
	}

	// 2. 입금
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();

		bankDto = bankDao.select(id);
		LogAspect.logger.info(LogAspect.LogMsg + bankDto);
		if (bankDto != null) {
			System.out.println("입금액 : ");
			long money = sc.nextLong();
			bankDto.setBalance(bankDto.getBalance() + money);
			int check = bankDao.update(bankDto);
			LogAspect.logger.info(LogAspect.LogMsg + check);
			if (check > 0) {
				System.out.println("입금 완료");

			} else {
				System.out.println("입금 실패");
			}
		} else {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
		sc.close();
	}

	//5.전체 출력
	public void showData() {
		List<BankDto> bankList = bankDao.showData();
		LogAspect.logger.info(LogAspect.LogMsg + bankList.size());

		for (int i = 0; i < bankList.size(); i++) {
			BankDto dto = bankList.get(i);
			System.out.println(dto.toString());
		}
	}

	//3. 출금
	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if (bankDto != null) {
			System.out.println("현재 잔액: " + bankDto.getBalance());
			System.out.println("출금하실 금액을 입력하세요 : ");
			Long money = sc.nextLong();
			if (money > bankDto.getBalance()) {
				System.out.println("잔액이 부족합니다");
			} else {
				bankDto.setBalance(bankDto.getBalance() - money);
				int check = bankDao.update(bankDto);
				if (check > 0) {
					System.out.println("출금 완료");
				} else {
					System.out.println("출금 실패");
				}
			}
		} else {
			System.out.println("계좌 번호가 존재하지 않습니다");
		}
		sc.close();
	}

	//4. 잔액 조회
	public void inquiry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호 : ");
		String id = sc.next();

		bankDto = bankDao.select(id);
		if (bankDto != null) {
			System.out.println(bankDto.getName() + "님의 잔액 : " + bankDto.getBalance());

		} else {
			System.out.println("계좌 번호가 존재하지 않습니다.");
		}
		sc.close();
	}
}
