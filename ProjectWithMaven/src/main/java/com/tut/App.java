package com.tut;


import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Configuration cfg = new Configuration();
        cfg.configure("com/tut/hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        //creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Vikash");
        st.setCity("gurgaon");
        
        //creating address of object clas
        
        Address adr = new Address();
        adr.setStreet("sector 23");
        adr.setAddedDate(new Date());
        adr.setCity("gurgaon");
        adr.setOpen(true);
        adr.setX(10);
        
        //start a session
        Session session =factory.openSession();
        
        //transaction started
        session.beginTransaction();
        //saved the object
        //session.save(st);
        session.save(adr);
        //got the transaction and commited the updates
        session.getTransaction().commit();
        
        
        //close the session
        session.close();
        
        
        
       // System.out.println(factory);
        
        
//        System.out.println(factory.isClosed());
        
    }
}
