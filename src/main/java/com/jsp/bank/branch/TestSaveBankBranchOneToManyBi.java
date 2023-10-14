package com.jsp.bank.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveBankBranchOneToManyBi {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aryan");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Bank bank = new Bank();
		bank.setName("Axis");
		
		
		Branch branch1 = new Branch();
		branch1.setAddress("Vashi");
		
		Branch branch2 = new Branch();
		branch2.setAddress("Nerul");
		
		Branch branch3 = new Branch();
		branch3.setAddress("Panvel");
		
		
		List<Branch> branches = new ArrayList<>();
		branches.add(branch1);
		branches.add(branch2);
		branches.add(branch3);
		
		bank.setBranches(branches);
		
		branch1.setBank(bank);
		branch2.setBank(bank);
		branch3.setBank(bank);
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
		
		
		

	}

}
