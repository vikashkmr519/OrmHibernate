package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student;

public class SecondDemo {
	
	public static void main(String[] args) {
		/*
		 * Second level cache me do different session ke liye
		 * agr same data ko fetch krna ho , toh query sirf ek baar hit ho
		 * usske liye second level cache use krte hai.
		 * 
		 * Hibernate cache dependency
		 * secondlevelcache dependency
		 * 
		 * 
		 * Entity which we want to cache , above that we will use two 
		 * annotations
		 * @Cacheable
		 * @Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
		 * 
		 * properties file insert two properties
		 * mentioning we want to use second level chaching
		 * in second property mentioning the path of the second level cache dependency 
		 * lib path
		 * <property name="cache.use_second_level_cache">true</property>
		<property name="cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>
		 * 
		 * then we can do below stuff
		 */
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session1 = factory.openSession();
		
		
		Student st1 = session1.get(Student.class, 123);
		//this will fetch data from database
		// now close the session1
		session1.close();
		
		
		//now create new session
		Session session2 = factory.openSession();
		Student st2 =session2.get(Student.class, 123);
		// this student is fetched from the second level caching
		// and not from the database
		//just because we have configured it to work as the second level caching
		session2.close();
	}

}
