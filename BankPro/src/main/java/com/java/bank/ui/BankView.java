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
		System.out.println("�����ϼ��� ");
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
			System.out.println("�߸��Է��Ͽ����ϴ�.");

		}
		sc.close();

	}

	public void printMenu() {
		System.out.println("====MENU====");
		System.out.println("1. ���� ����");
		System.out.println("2. �Ա�");
		System.out.println("3. ���");
		System.out.println("4. �ܾ� ��ȸ");
		System.out.println("5. ��ü ���");
		System.out.println("6. ����");

	}

	// 1. ���� ����
	public void makeAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ��ȣ : ");
		String id = sc.next();
		BankDto dto = bankDao.select(id);
		if (dto != null) {
			System.out.println("�̹� �����ϴ� ���¹�ȣ �Դϴ�.");
		} else {
			bankDto.setId(id);
			System.out.println("�̸� : ");
			bankDto.setName(sc.next());
			System.out.println("�Աݾ� : ");
			bankDto.setBalance(sc.nextLong()); // sc.next() �� ������Ÿ���� �ٸ�

			int check = bankDao.makeAccount(bankDto);

			LogAspect.logger.info(LogAspect.LogMsg + check);

			System.out.println("���°� �����Ǿ����ϴ�.");
		}
		sc.close();
		// 1. ���� ���� ��
	}

	// 2. �Ա�
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();

		bankDto = bankDao.select(id);
		LogAspect.logger.info(LogAspect.LogMsg + bankDto);
		if (bankDto != null) {
			System.out.println("�Աݾ� : ");
			long money = sc.nextLong();
			bankDto.setBalance(bankDto.getBalance() + money);
			int check = bankDao.update(bankDto);
			LogAspect.logger.info(LogAspect.LogMsg + check);
			if (check > 0) {
				System.out.println("�Ա� �Ϸ�");

			} else {
				System.out.println("�Ա� ����");
			}
		} else {
			System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
		}
		sc.close();
	}

	//5.��ü ���
	public void showData() {
		List<BankDto> bankList = bankDao.showData();
		LogAspect.logger.info(LogAspect.LogMsg + bankList.size());

		for (int i = 0; i < bankList.size(); i++) {
			BankDto dto = bankList.get(i);
			System.out.println(dto.toString());
		}
	}

	//3. ���
	public void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();
		bankDto = bankDao.select(id);
		if (bankDto != null) {
			System.out.println("���� �ܾ�: " + bankDto.getBalance());
			System.out.println("����Ͻ� �ݾ��� �Է��ϼ��� : ");
			Long money = sc.nextLong();
			if (money > bankDto.getBalance()) {
				System.out.println("�ܾ��� �����մϴ�");
			} else {
				bankDto.setBalance(bankDto.getBalance() - money);
				int check = bankDao.update(bankDto);
				if (check > 0) {
					System.out.println("��� �Ϸ�");
				} else {
					System.out.println("��� ����");
				}
			}
		} else {
			System.out.println("���� ��ȣ�� �������� �ʽ��ϴ�");
		}
		sc.close();
	}

	//4. �ܾ� ��ȸ
	public void inquiry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���¹�ȣ : ");
		String id = sc.next();

		bankDto = bankDao.select(id);
		if (bankDto != null) {
			System.out.println(bankDto.getName() + "���� �ܾ� : " + bankDto.getBalance());

		} else {
			System.out.println("���� ��ȣ�� �������� �ʽ��ϴ�.");
		}
		sc.close();
	}
}
