package com.jsp.person.bankaccount;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBankAccount {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aryan");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		person.setName("abc");
		person.setEmail("abc@gmail.com");
		person.setCno(9274926305l);
		
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setBank_name("HDFC");
		
		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.setBank_name("Axis");
		
		BankAccount bankAccount3 = new BankAccount();
		bankAccount3.setBank_name("PNB");
		
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(bankAccount1);
		accounts.add(bankAccount2);
		accounts.add(bankAccount3);
		
		person.setAccounts(accounts);
		
		bankAccount1.setPerson(person);
		bankAccount2.setPerson(person);
		bankAccount3.setPerson(person);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAccount1);
		entityManager.persist(bankAccount2);
		entityManager.persist(bankAccount3);
		entityTransaction.commit();
		
		
		
		
		
	}

}
