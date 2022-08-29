package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student;

public class FirstDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// now what ever data will be fetched from the database will be stored
		//in the session
		//here we will see First level Caching
		
		//this will be first time fetched from the database
		Student st1 = session.get(Student.class, 123);
		
		System.out.print(st1);
		
		//now if we again try to fetch the same data from the database
		//it will not hit the query instead , session has cached the data
		//and same data will be returned directly from session
		// and no database call will happen
		
		Student st2 = session.get(Student.class, 123);
		//this get function has fetched the data from session internal caching 
		//mechanism
		//but the catch point is session should not be closed if we want to 
		//take benefit of this caching. After that we can close the session
		
		session.clear();
		
	}

}
