package com.mappings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	    List<Answer> ans = new ArrayList<>();
	    
	    Answer ans1 = new Answer();
	    ans1.setAnswerId(1);
	    ans1.setAnswer("java is programming lang");
	    ans1.setQuestion(q);
	    
	    Answer ans2 = new Answer();
	    ans2.setAnswerId(2);
	    ans2.setAnswer("java is programming lang 2");
	    ans2.setQuestion(q);
	    
	    Answer ans3 = new Answer();
	    ans3.setAnswerId(3);
	    ans3.setAnswer("java is programming lang 3");
	    ans3.setQuestion(q);
	    
	    ans.add(ans1);
	    ans.add(ans2);
	    ans.add(ans3);
	    q.setAnswer(ans);


	    
	    
	    
	    Session s = factory.openSession();
	  
	    
	    Transaction tx = s.beginTransaction();
//	    s.save(ans1);
//	    s.save(ans2);
//	    s.save(ans3);
	    s.save(q);
	    System.out.println("printing questioon-------->");
	    q = s.get(Question.class, 1);
		   System.out.println(q);
	    
	    tx.commit();
	    s.close();
	    factory.close();
	    
	    
	}


}
