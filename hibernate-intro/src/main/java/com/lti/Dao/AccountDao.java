package com.lti.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class AccountDao extends GenericDao{

	public List<Transaction> fetchMiniStatement(long acno){
	
			EntityManagerFactory emf= null;
			EntityManager em =  null;
			try {
				
					emf = Persistence.createEntityManagerFactory("oracle-pu");
					em = emf.createEntityManager();
					
					String ql="Select t from Transaction t "
									+ "where t.account.acno=:ac "
									+ "order by t.date desc";
					
					
					
					//Introducing JP-QL
					Query q = em.createQuery(ql);
					q.setParameter("ac", acno);
					//q.setFirstResult(10);
					q.setMaxResults(5);
					List<Transaction> list= q.getResultList();
					return  list;
			}
			
			finally {
				
			em.close();
			emf.close();
			}

		}
	
	
	
	public List<Account> fetchAccountByBalance(double balance){
		
		EntityManagerFactory emf= null;
		EntityManager em =  null;
		try {
			
				emf = Persistence.createEntityManagerFactory("oracle-pu");
				em = emf.createEntityManager();
				
				String ql="Select t from Account t "
								+ "where t.balance>= :balance";
				
				
				
				//Introducing JP-QL
				Query q = em.createQuery(ql);
				q.setParameter("balance",balance);
				//q.setFirstResult(10);
				//q.setMaxResults(5);
				List<Account> list= q.getResultList();
				return  list;
		}
		
		finally {
			
		em.close();
		emf.close();
		}

	}
	
	
	public List<Account> fetchAccountByTransaction(String type,double amount){
		
		EntityManagerFactory emf= null;
		EntityManager em =  null;
		try {
			
				emf = Persistence.createEntityManagerFactory("oracle-pu");
				em = emf.createEntityManager();
				
				String ql="Select a from Account a  inner join a.transactions t   "
								+ "where t.type=:tp and t.amount>=:amount";
				
				
				
				//Introducing JP-QL
				Query q = em.createQuery(ql);
				q.setParameter("tp",type);
				q.setParameter("amount",amount);
				//q.setFirstResult(10);
				//q.setMaxResults(5);
				List<Account> list= q.getResultList();
				return  list;
		}
		
		finally {
			
		em.close();
		emf.close();
		}

	}
	
	}

