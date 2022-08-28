package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hql.Student;

public class HqlPagination {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s = factory.openSession();
		
		
		Query<Student> q =s.createQuery("from Student", Student.class);
		
		//implementing pagination using hibernate
		
		//from which index we have to fetch
		q.setFirstResult(0);
		//how many data we need to be fetched at once
		q.setMaxResults(5);
		
		List<Student>list = q.getResultList();
		list.forEach((st)-> System.out.println(st.getId()));
		
		s.close();
		factory.close();
		
	}

}
