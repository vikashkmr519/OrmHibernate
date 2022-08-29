package com.hql.nativeQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student;

public class NativeQuery {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		//write native sql query
		
		String q = "select * from student";
		
		org.hibernate.query.NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		
		for(Object[] obj : list) {
			System.out.println(Arrays.deepToString(obj));
		}
		
		s.close();
		factory.close();
	}

}
