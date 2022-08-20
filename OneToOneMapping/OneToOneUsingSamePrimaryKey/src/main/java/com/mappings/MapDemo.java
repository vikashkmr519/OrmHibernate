package com.mappings;

import java.io.IOException;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main( String[] args ) throws IOException
	{
	    System.out.println( "Welcome to Embed Demo" );

	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    
	    SessionFactory factory = cfg.buildSessionFactory();
	    
	    Question q = new Question();
	    q.setQuestionId(1);
	    q.setQuestion("what is java?");
	    
	    Answer ans = new Answer();
	    //here only the assumption of same primary key will be there;
	    ans.setAnswerId(1);
	    ans.setAnswer("java is programming lang");
	    
	    q.setAnswer(ans);
	    
	    Session s = factory.openSession();
	  
	    
	    Transaction tx = s.beginTransaction();
	    s.save(ans);
	    s.save(q);
	    System.out.println("printing questioon-------->");
	    q = s.get(Question.class, 1);
		   System.out.println(q);
	    
	    tx.commit();
	    s.close();
	    factory.close();
	    
	    
	}


}
