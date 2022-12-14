package com.tut;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {


public static void main( String[] args ) throws IOException
{
    System.out.println( "Hello World!" );

    Configuration cfg = new Configuration();
    cfg.configure("com/tut/hibernate.cfg.xml");
    
    SessionFactory factory = cfg.buildSessionFactory();
    
    Session session = factory.openSession();
    
    //get student id =101
    Student student = (Student) session.get(Student.class, 101);
    System.out.println(student);
    Address adr = session.get(Address.class, 1);
    System.out.println(adr);
    session.close();
    factory.close();
    
    
}




//		this main method is used to show saving data in database
//    public static void main( String[] args ) throws IOException
//    {
//        System.out.println( "Hello World!" );
//
//        Configuration cfg = new Configuration();
//        cfg.configure("com/tut/hibernate.cfg.xml");
//        
//        SessionFactory factory = cfg.buildSessionFactory();
//        //creating student
//        Student st = new Student();
//        st.setId(101);
//        st.setName("Vikash");
//        st.setCity("gurgaon");
//        
//        //creating address of object clas
//        
//        Address adr = new Address();
//        adr.setStreet("sector 23");
//        adr.setAddedDate(new Date());
//        adr.setCity("gurgaon");
//        adr.setOpen(true);
//        adr.setX(10);
//        
//        //Reading image from system
//        FileInputStream fis = new FileInputStream("src/main/java/pic.jpeg");
//        byte[] data = new byte[fis.available()];
//        fis.read(data);
//        
//        adr.setImage(data);
//        
//        
//        //start a session
//        Session session =factory.openSession();
//        
//        //transaction started
//        session.beginTransaction();
//        //saved the object
//        session.save(st);
//        session.save(adr);
//        //got the transaction and commited the updates
//        session.getTransaction().commit();
//        
//        
//        //close the session
//        session.close();
//        
//        
//        
//       // System.out.println(factory);
//        
//        
////        System.out.println(factory.isClosed());
//        
//    }
}
