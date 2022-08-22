package com.employee;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setEid(34);
		e1.setName("Ram");
		
		e2.setEid(35);
		e2.setName("Shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(23);
		p1.setProjectName("orca");
		
		p2.setPid(24);
		p2.setProjectName("emma");
		
		List<Employee> list1 = new ArrayList<>();
		List<Project> list2 = new ArrayList<>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p2);
		list2.add(p1);
		
		e1.setProjects(list2);
		p2.setEmployees(list1);
		
		Session session = factory.openSession();
		
		Transaction tx  = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		
		tx.commit();
		session.close();
		factory.close();
		
	}
}
