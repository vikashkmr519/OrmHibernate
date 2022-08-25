package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory =  cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		
		String query = "from Student as s where city=:x and s.name= :n";
		
		Query q =  s.createQuery(query);
		q.setParameter("x", "Delhi");
		q.setParameter("n", "Vikash");
		
		//to get unique result
		//q.uniqueResult();
		
		//to get list of result
		List<Student> list = q.list();
		
		for(Student student : list) {
			System.out.println(student.getName());
		}
		
		////////////////////////////////////////////////////////////////////
		//for deleting 
		/*
		 * Transaction tx = s.beginTransaction(); Query q2 =
		 * s.createQuery("Delete from Student s where s.name=:c"); q2.setParameter("c",
		 * "vikash"); int r = q2.executeUpdate(); tx.commit();
		 */
		
		
		////////////////////////////////////////////////////////////////////
		//update query
		
		/*
		 * query = "update Student set city=:c where name=:n"; Query q2
		 * =s.createQuery(query); q2.setParameter("c", "delhi"); q2.setParameter("n",
		 * "abhishek");
		 * 
		 * int r = q2.executeUpdate();
		 */
		
		//join query
//		query = "select q.question , a.answer from Question q inner join Answer a";
//		Query q2 = s.createQuery(query);
//		
//		List<Object[]> list3 = q2.getResultList();
//	
		
		s.close();
		factory.close();
	}
	
}
