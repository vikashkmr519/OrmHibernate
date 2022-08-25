package com.tut;

import java.io.IOException;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbDemo {
	
	public static void main( String[] args ) throws IOException
	{
	    System.out.println( "Welcome to Embed Demo" );

	    Configuration cfg = new Configuration();
	    cfg.configure("com/tut/hibernate.cfg.xml");
	    
	    SessionFactory factory = cfg.buildSessionFactory();
	    

	    
	    //get student id =101
	   Student st = new Student();
	   st.setId(14241);
	   st.setName("Ankit Tiwari");
	   st.setCity("LKO");
	   
	   Certificate cert = new Certificate();
	   cert.setCourse("Spring hibernate");
	   cert.setDuration("1 month");
	   
	   st.setCerti(cert);
	   
	    Session session = factory.openSession();
	    
	    Transaction tx = session.beginTransaction();
	   session.save(st);
	   
	   tx.commit();
	    session.close();
	    factory.close();
	    
	    
	}


}
